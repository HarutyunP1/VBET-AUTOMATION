package vbetnet;

import dataproviders.SignUpNetDataProvider;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LogInPage;
import pages.SignUpPage;
import pages.SportsPage;
import pages.profile.MyProfilePage;
import pages.profile.EditProfilePage;
import pages.profile.NotificationsPage;
import utilities.RandomUtils;
import utilities.TestBase;

public class SignUpNetTest extends TestBase {
    private SignUpPage signUpPage;
    private LogInPage logInPage;
    private SportsPage sportsPage;
    private EditProfilePage editProfilePage;
    private MyProfilePage myProfilePage;
    private NotificationsPage notificationsPage;
    private String userName = RandomUtils.generateRandomLettersAndNumbers(8) + "S";
    private String email = RandomUtils.generateRandomLetters(5) + "@betmail.com";
    private final String password = "Test1234";
    private final String firstName = "TestFirst";
    private final String lastName = "TestLast";
    private final int gender = 0;
    private final String[] birthDateInfo = {"1995", "4", "12"};
    private final String birthDate = "1995-05-12";
    private final String[] billingAddress = {"DE", "Yerevan", "Address", "1234"};
    private final String mobileNumber = "8963648018";
    private final String countryCode = "+49";
    private final String promoCode = "1234";
    private String welcomeOfferUrl;
    private String signUpUrl;

    @BeforeClass
    @Parameters({"welcomeOfferUrl","signUpUrl"})
    public void setUp(String welcomeOfferUrl,String signUpUrl) {
        signUpPage = new SignUpPage(driver);
        logInPage = new LogInPage(driver);
        sportsPage = new SportsPage(driver);
        editProfilePage = new EditProfilePage(driver);
        myProfilePage = new MyProfilePage(driver);
        notificationsPage = new NotificationsPage(driver);
        this.welcomeOfferUrl = welcomeOfferUrl;
        this.signUpUrl = signUpUrl;
    }

    @BeforeMethod(onlyForGroups = "signUpUrl")
    public void openSignUpUrl() {
        signUpPage.openUrl(signUpUrl);
    }

    @Test(groups = "signUpUrl")
    public void registerWithValidCredentials() {
        generateEmailAndUsername();
        registrationSteps();
        signUpPage.clickOnSuccessButtonNet();
        logInPage.fillInEmailField(email);
        logInPage.fillInPasswordField(password);
        logInPage.clickOnLoginButton();
        signUpPage.clickOnProfileCloseIconNet();
        Assert.assertTrue(sportsPage.isProfileIconDisplayed(), "Register process isn't worked");
    }

    @Test(groups = "signUpUrl", enabled = false)
    public void dataOnMyProfilePageAfterRegister(){
        generateEmailAndUsername();
        registrationSteps();
        signUpPage.clickOnOkButton();
        logInPage.fillEmailPassFields(email, password);
        logInPage.clickOnLoginButton();
        sportsPage.hoverOnProfileLogo();
        sportsPage.clickOnEditProfileLink();
        Assert.assertEquals(firstName, editProfilePage.getFirstNameValue(), "First Name value is wrong");
        Assert.assertEquals(lastName, editProfilePage.getLastNameValue(), "Last Name value is wrong");
        Assert.assertEquals(email, editProfilePage.getEmailValue(), "Email Name value is wrong");
        Assert.assertEquals(birthDate, editProfilePage.getBirthDateValue(), "Birth Date Name value is wrong");
        Assert.assertTrue(editProfilePage.isGenderRadioButtonSelected(), "Gender radio button isn't selected");
        Assert.assertEquals(countryCode + mobileNumber, editProfilePage.getMobileNumberValue(), "Mobile Number value is wrong");
        Assert.assertEquals(billingAddress[0], editProfilePage.getCountryValue(), "Country value is wrong");
        Assert.assertEquals(billingAddress[1], editProfilePage.getCiyValue(), "City value is wrong");
        Assert.assertEquals(billingAddress[2], editProfilePage.getAddressValue(), "Address value is wrong");
        myProfilePage.clickOnNotificationsArea();
        Assert.assertTrue(notificationsPage.emailRadioButtonSelected() & notificationsPage.isInternalMessageRadioButtonSelected(), "Email ro Internal Message radio buttons aren't selected");
        Assert.assertTrue(notificationsPage.isPhoneCallRadioButtonSelected() & notificationsPage.pushNotificationRadioButtonSelected(), "Phone call or Push Notification radio buttons aren't selected");
        Assert.assertTrue(notificationsPage.smsRadioButtonSelected(), "SMS radio button isn't selected");
    }

    @Test(groups = "signUpUrl")
    public void navigationToTheNextStepOfRegistration(){
        generateEmailAndUsername();
        signUpFirstSteps(email, password, password);
        Assert.assertTrue(signUpPage.isFirstNameDisplayed(), "Didn't redirect to the Register  2nd step");
    }

    @Test(groups = "signUpUrl", dataProviderClass = SignUpNetDataProvider.class, dataProvider = "missingFieldsOnFirstStep")
    public void missingFieldsOnFirstStep(String email,String password,String confirmPassword,String promoCode,int warningIconCount) {
        signUpFirstSteps(email, password, confirmPassword);
        signUpPage.clickOnNextButton();
        Assert.assertTrue(signUpPage.checkWarningIconsCount(warningIconCount), "Warning icon didn't display when missing fields");
    }

    @Test(groups = "signUpUrl", dataProviderClass = SignUpNetDataProvider.class, dataProvider = "missingFieldsOnSecondStep")
    public void missingFieldsOnSecondStepFirstPart(String firstName,String lastName,String userName,String birthYear,String birthMonth,String birthDay,String country,
                                                   String city,String address,String zipCode, String mobileNumber,String dailyDep,String weeklyDep, String monthlyDep,int warningIconCount,
                                                   boolean intMessage,boolean pushNot,boolean emailNot,boolean sms,boolean phoneCall) {
        generateEmailAndUsername();
        signUpFirstSteps(email, password, password);
        signUpPage.clearAllFields();
        signUpPage.scrollToBackButton();
        signUpPage.clickOnRadioButtonsNet(intMessage,pushNot,emailNot,sms,phoneCall);
        signUpPage.chooseGender(gender);
        fillInInputFieldsOnSecondStep(firstName,lastName,userName,city,address,zipCode,mobileNumber);
        fillInMaxDeposits(dailyDep,weeklyDep,monthlyDep);
        signUpPage.chooseBirthDate(birthYear, birthMonth, birthDay);
        signUpPage.chooseCountryValue(country);
        signUpPage.scrollToBackButton();
        signUpPage.clickOnSubmitButton();
        Assert.assertTrue(signUpPage.checkWarningIconsCount(warningIconCount), "Warning icon didn't display when missing fields");
    }

    @Test(groups = "signUpUrl", dataProviderClass = SignUpNetDataProvider.class,dataProvider = "registerWithInvalidEmail")
    public void registerWithInvalidEmail(String email) {
        fillInFirstStepFields(email, password, password);
        signUpPage.clickOnNextButton();
        Assert.assertTrue(signUpPage.checkWarningIconsCount(1), "Warning icon isn't displayed when Missing symbols on email field");
    }

    @Test(groups = "signUpUrl", dataProviderClass = SignUpNetDataProvider.class,dataProvider = "passwordValidation")
    public void passwordValidation(String password) {
        email = RandomUtils.generateRandomLetters(5) + "@yopmail.com";
        signUpFirstSteps(email, password, password);
        Assert.assertTrue(signUpPage.checkWarningIconsCount(1), "Warning icon isn't displayed when writing invalid password on Password field");
    }

    @Test(groups = "signUpUrl")
    public void confirmPasswordValidation() {
        email = RandomUtils.generateRandomLetters(5) + "@yopmail.com";
        signUpFirstSteps(email, "Test1234", "Test4567");
        Assert.assertTrue(signUpPage.checkWarningIconsCount(1), "Warning icon isn't displayed on Confirm Password field");
    }

    @Test(groups = "signUpUrl")
    public void countryCodeValidation() {
        email = RandomUtils.generateRandomLetters(5) + "@yopmail.com";
        signUpFirstSteps(email, password, password);
        signUpPage.chooseCountryValue(billingAddress[0]);
        Assert.assertTrue(signUpPage.isCountryCodeEquals(countryCode), "Country code isn't comply with country");
    }

    @Test(groups = "signUpUrl")
    public void mobileNumberValidation() {
        userName = RandomUtils.generateRandomLettersAndNumbers(8) + "S";
        email = RandomUtils.generateRandomLetters(5) + "@yopmail.com";
        final int invalidMobileNumber = RandomUtils.generateRandomNumbers(3);
        signUpFirstSteps(email, password, password);
        signUpPage.chooseCountryValue(billingAddress[0]);
        signUpPage.chooseGender(gender);
        fillInInputFieldsOnSecondStep(firstName, lastName,userName ,billingAddress[1], billingAddress[2], billingAddress[3], invalidMobileNumber + "");
        signUpPage.chooseBirthDate(birthDateInfo[0], birthDateInfo[1], birthDateInfo[2]);
        signUpPage.scrollToBackButton();
        signUpPage.clickOnRadioButtonsNet(true,true,true,true,true);
        signUpPage.clickOnTermsAndPolicyCheckbox();
        signUpPage.clickOnSubmitButton();
        Assert.assertTrue(signUpPage.checkWarningIconsCount(1), "Warning icon isn't displayed when country code isn't comply with phone number");
    }

    @Test(groups = "signUpUrl")
    public void welcomeOfferRedirection() {
        logInPage.reloadLogInPage();
        signUpPage.clickOnWelcomeOfferImage();
        signUpPage.switchToWelcomeOfferTab();
        Assert.assertEquals(welcomeOfferUrl, logInPage.getUrl(), "Didn't redirect to Welcome Offer page");
        signUpPage.closeWelcomeOfferTab();
        signUpPage.switchToRegisterTab();
    }

    @Test(groups = "signUpUrl")
    public void backButtonTest() {
        userName = RandomUtils.generateRandomLetters(5) + "@yopmail.com";
        signUpFirstSteps(email, password, password);
        signUpPage.scrollToBackButton();
        signUpPage.clickOnBackButton();
        Assert.assertTrue(signUpPage.isEmailFieldDisplayedNet(), "Didn't redirect to the first page");
    }

    @Test(groups = "signUpUrl")
    public void signInLinkRedirection() {
        logInPage.reloadLogInPage();
        signUpPage.clickOnSignInLink();
        Assert.assertTrue(logInPage.isLogInPopUpDisplayed(), "Didn't redirect to the sign in page");
    }

    @Test(groups = "signUpUrl")
    public void priceDropDownDisabledTest(){
        Assert.assertTrue(signUpPage.isPriceDropDownDisabledNet());
    }

    @AfterMethod(groups = "signUpUrl")
    public void reloadPage() {
        clearCaches();
    }

    private void registrationSteps() {
        signUpPage.fillInEmailField(email);
        signUpPage.fillInPasswordField(password);
        signUpPage.fillInConfirmPassField(password);
        signUpPage.clickOnNextButton();
        signUpPage.fillInFirstNameField(firstName);
        signUpPage.fillInLastNameField(lastName);
        signUpPage.fillInUsernameField(userName);
        signUpPage.chooseGender(gender);
        signUpPage.chooseBirthDate(birthDateInfo[0], birthDateInfo[1], birthDateInfo[2]);
        signUpPage.chooseCountryValue(billingAddress[0]);
        signUpPage.fillInCityField(billingAddress[1]);
        signUpPage.fillInAddressField(billingAddress[2]);
        signUpPage.fillInZipCodeField(billingAddress[3]);
        signUpPage.fillInMobileNumberField(mobileNumber);
        signUpPage.scrollToBackButton();
        signUpPage.clickOnRadioButtonsNet(true,true,true,true,true);
        signUpPage.clickOnTermsAndPolicyCheckbox();
        signUpPage.clickOnSubmitButton();
    }

    private void fillInFirstStepFields(String email, String password, String confirmPassword) {
        if (!userName.isBlank())
            signUpPage.fillInEmailField(email);
        if (!password.isBlank())
            signUpPage.fillInPasswordField(password);
        if (!confirmPassword.isBlank())
            signUpPage.fillInConfirmPassField(confirmPassword);
    }

    private void fillInInputFieldsOnSecondStep(String firstName, String lastName, String userName,String city, String address, String zipCode, String mobileNumber) {
        if (!firstName.isBlank())
            signUpPage.fillInFirstNameField(firstName);
        if (!lastName.isBlank())
            signUpPage.fillInLastNameField(lastName);
        if (!userName.isBlank())
            signUpPage.fillInUsernameField(userName);
        if (!city.isBlank())
            signUpPage.fillInCityField(city);
        if (!address.isBlank())
            signUpPage.fillInAddressField(address);
        if (!zipCode.isBlank())
            signUpPage.fillInZipCodeField(zipCode);
        if (!mobileNumber.isBlank())
            signUpPage.fillInMobileNumberField(mobileNumber);
    }

    private void fillInMaxDeposits(String dailyDeposit,String weeklyDeposit,String monthlyDeposit){
        if (!dailyDeposit.isBlank())
            signUpPage.fillInMaxDailyDepositFieldNet(dailyDeposit);
        if (!weeklyDeposit.isBlank())
            signUpPage.fillInMaxWeeklyDepositFieldNet(weeklyDeposit);
        if (!monthlyDeposit.isBlank())
            signUpPage.fillInMaxMonthlyDepositFieldNet(monthlyDeposit);
    }

    private void signUpFirstSteps(String email, String password, String confirmPassword) {
        fillInFirstStepFields(email, password, confirmPassword);
        signUpPage.clickOnNextButton();
    }

    private void generateEmailAndUsername() {
        userName = RandomUtils.generateRandomLettersAndNumbers(8) + "S";
        email = RandomUtils.generateRandomLetters(5) + "@yopmail.com";
    }
}
