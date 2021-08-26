package vbetcom.myProfile;

import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.profile.EditProfilePage;
import pages.LogInPage;
import pages.SignUpPage;
import pages.SportsPage;
import utilities.RandomUtils;
import utilities.TestBase;

public class EditProfileTest extends TestBase {

    private String editProfileUrl;
    private String signInUrl;
    private String signUpUrl;
    private String sportsUrl;
    private String changePasswordUrl;
    private EditProfilePage editProfilePage;
    private LogInPage logInPage;
    private SignUpPage signUpPage;
    private SportsPage sportsPage;
    private final String password = "Test1111";
    private String userName;
    private String email;
    private String firstName = "TestFirst";
    private String lastName = "TestLast";
    private String passportNumber;
    private final String[] birthDateInfo = {"1995", "4", "12"};
    private final String birthDate = "1995-05-12";
    private String mobileNumber;
    private final String city = "City";
    private final String address = "Address";
    private final String[] country = {"AM","AL"};

    @BeforeClass
    @Parameters({"editProfileUrl","signInUrl","signUpUrl","sportsUrl","changePasswordUrl"})
    public void setUp(String editProfileUrl,String signInUrl,String signUpUrl,String sportsUrl,String changePasswordUrl){
        editProfilePage = new EditProfilePage(driver);
        logInPage = new LogInPage(driver);
        signUpPage = new SignUpPage(driver);
        sportsPage = new SportsPage(driver);
        this.editProfileUrl = editProfileUrl;
        this.signInUrl = signInUrl;
        this.signUpUrl = signUpUrl;
        this.sportsUrl = sportsUrl;
        this.changePasswordUrl = changePasswordUrl;
    }

    @BeforeMethod
    public void openSportsPage(){
        logInPage.openUrl(sportsUrl);
    }

    @TmsLink("VBET-T23")
    @Test
    public void validationForEditingProfile(){
        validRegisterProcess();
        logIn(email,password);
        logInPage.closePopUp(signInUrl);
        editProfilePage.openUrl(editProfileUrl);
        logInPage.closePopUp(signInUrl);
        fillInFieldsOnEditProfilePage();
        logInPage.reloadLogInPage();
        Assert.assertTrue(editProfilePage.isUserNameValueValid(userName),"User name value isn't valid.");
        Assert.assertTrue(editProfilePage.isFirstNameValueValid(firstName) & editProfilePage.isLastNameValueValid(lastName),"First Name or last name value isn't valid");
        Assert.assertTrue(editProfilePage.isEmailValueValid(email) & editProfilePage.isCountryValueValid(country[0]),"Email or Country value isn't valid");
        Assert.assertTrue(editProfilePage.isPassportNumberValueValid(passportNumber) & editProfilePage.isBirthDateValueValid(birthDate),"Passport number or Birth Date value isn't valid");
        Assert.assertTrue(editProfilePage.isGenderRadioButtonSelected() & editProfilePage.isMobileNumberValueValid(mobileNumber),"Gender radio button or Mobile Number value isn't valid");
        Assert.assertTrue(editProfilePage.isCityValueValid(city) & editProfilePage.isAddressValueValid(address),"City or Address value isn't valid");
    }

    @TmsLink("VBET-T24")
    @Test
    public void appropriateFieldsShouldBeNotEditableTest(){
        validRegisterProcess();
        logIn(email, password);
        logInPage.closePopUp(signInUrl);
        logInPage.closeCongitPopUp();
        sportsPage.clickOnProfileLogo();
        logInPage.closePopUp(signInUrl);
        fillInFieldsOnEditProfilePage();
        logInPage.reloadLogInPage();
        Assert.assertTrue(editProfilePage.isFirstNameDisabled() & editProfilePage.isLastNameDisabled(),"First Name or Last Name field isn't disabled.");
        Assert.assertTrue(editProfilePage.isEmailDisabled() & editProfilePage.isPassportNumberDisabled(),"Email or Passport Number field isn't disabled.");
        Assert.assertTrue(editProfilePage.isBirthDateDisabled() & editProfilePage.isGenderDisabled(),"Birth Date or Gender field isn't disabled.");
        Assert.assertTrue(editProfilePage.isAddressDisabled(),"Address field isn't disabled");
    }

    @TmsLink("VBET-T25")
    @Test
    public void validationForValuesShouldBeChangedAfterEditingProfile(){
        mobileNumber = "0" + RandomUtils.generateRandomNumbers(8);
        logIn(email,password);
        editProfilePage.openUrl(editProfileUrl);
        editProfilePage.clearMobileNumberField();
        editProfilePage.clearCityField();
        editProfilePage.fillInMobileNumberField(mobileNumber);
        editProfilePage.fillInCityField(city + "test");
        editProfilePage.chooseCountryValue(country[1]);
        editProfilePage.clickOnSaveProfileButton();
        editProfilePage.fillInPasswordField(password);
        editProfilePage.clickOnSaveProfileButtonOnCurrentPassword();
        logInPage.reloadLogInPage();
        Assert.assertTrue(editProfilePage.isMobileNumberValueValid(mobileNumber) & editProfilePage.isCityValueValid(city + "test"),"Mobile or City value isn't valid.");
        Assert.assertTrue(editProfilePage.isCountryValueValid(country[1]),"Country value isn't valid.");
    }

    @AfterMethod
    public void reloadPage() {
        clearCaches();
    }

    private void validRegisterProcess(){
        signUpPage.openUrl(signUpUrl);
        userName = RandomUtils.generateRandomLetters(8) + "S";
        email = RandomUtils.generateRandomLettersAndNumbers(6) + "@yopmail.com";
        signUpPage.fillInUsernameField(userName);
        signUpPage.fillInEmailField(email);
        signUpPage.fillInPasswordField(password);
        signUpPage.clickOnTermsAndPolicyCheckbox();
        signUpPage.clickOnSubmitButton();
        logInPage.reloadLogInPage();
    }

    private void logIn(String email,String password){
        logInPage.openUrl(signInUrl);
        logInPage.fillEmailPassFields(email,password);
        logInPage.clickOnLoginButton();
        logInPage.waitUntilProfileLogoDisplayed();
        logInPage.waitUntilBalanceLoad();
        logInPage.closePopUp(signInUrl);
    }

    private void fillInFieldsOnEditProfilePage(){
        passportNumber = RandomUtils.generateRandomLettersAndNumbers(8);
        mobileNumber = "0" + RandomUtils.generateRandomNumbers(8);
        editProfilePage.fillInFirstNameField(firstName);
        editProfilePage.fillInLastName(lastName);
        editProfilePage.fillInPassportNumber(passportNumber);
        editProfilePage.chooseBirthDate(birthDateInfo[0],birthDateInfo[1],birthDateInfo[2]);
        editProfilePage.chooseGenderRadioButton();
        editProfilePage.fillInMobileNumberField(mobileNumber);
        editProfilePage.fillInCityField(city);
        editProfilePage.fillInAddressField(address);
        editProfilePage.clickOnSaveProfileButton();
        editProfilePage.fillInPasswordField(password);
        editProfilePage.clickOnSaveProfileButtonOnCurrentPassword();
        editProfilePage.waitUntilSaveProfileButtonDisappear();
    }

}
