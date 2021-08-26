package vbetcom;

import dataproviders.SignUpDataProvider;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LogInPage;
import pages.SignUpPage;
import pages.SportsPage;
import pages.profile.MyProfilePage;
import pages.profile.EditProfilePage;
import pages.profile.NotificationsPage;
import utilities.RandomUtils;
import utilities.TestBase;
import utilities.WaitUtils;


public class SignUpTest extends TestBase {

    private SignUpPage signUpPage;
    private LogInPage logInPage;
    private SportsPage sportsPage;
    private EditProfilePage editProfilePage;
    private MyProfilePage myProfilePage;
    private NotificationsPage notificationsPage;
    private HomePage homePage;
    private String userName;
    private String email;
    private final String password = "Test1234";
    private String signUpUrl;
    private String welcomeOfferUrl;
    private String signInUrl;
    private String homePageUrl;

    @BeforeClass
    @Parameters({"signUpUrl","welComeOfferUrl","signInUrl","homePageUrl"})
    public void setUp(String signUpUrl,String welcomeOfferUrl,String signInUrl,String homePageUrl) {
        signUpPage = new SignUpPage(driver);
        logInPage = new LogInPage(driver);
        sportsPage = new SportsPage(driver);
        editProfilePage = new EditProfilePage(driver);
        myProfilePage = new MyProfilePage(driver);
        notificationsPage = new NotificationsPage(driver);
        homePage = new HomePage(driver);
        this.signUpUrl = signUpUrl;
        this.welcomeOfferUrl = welcomeOfferUrl;
        this.signInUrl = signInUrl;
        this.homePageUrl = homePageUrl;
    }

    @BeforeMethod(onlyForGroups = "signUpUrl")
    public void openSignUpUrl() {
        signUpPage.openUrl(signUpUrl);
    }

    @TmsLink("VBET-T11")
    @Test(groups = "signUpUrl")
    public void registerWithValidProcessTest(){
        generateEmailAndUsername();
        fillInAllFields(userName,email,password);
        signUpPage.clickOnTermsAndPolicyCheckbox();
        signUpPage.clickOnSubmitButton();
        signUpPage.clickOnOkButton();
        logIn();
        logInPage.closePopUp(signInUrl);
        Assert.assertTrue(signUpPage.isProfileLogoDisplayed(),"User didn't register");
    }

    @TmsLink("VBET-T12")
    @Test(groups = "signUpUrl", dataProvider = "warningIcons", dataProviderClass = SignUpDataProvider.class)
    public void fillMissingFields(String userName,String email,String password,int warningIconCount){
        signUpPage.clickOnTermsAndPolicyCheckbox();
        fillInAllFields(userName,email,password);
        signUpPage.clickOnSubmitButton();
        Assert.assertTrue(signUpPage.checkWarningIconsCount(warningIconCount),"Warning icon didn't displayed when missing fields");
    }

    @TmsLink("VBET-T13")
    @Test(groups = "signUpUrl",dataProviderClass = SignUpDataProvider.class,dataProvider = "emailFieldValidation")
    public void emailFieldValidation(String userName,String email,String password,int warningIconsCount){
        signUpPage.clickOnTermsAndPolicyCheckbox();
        fillInAllFields(userName,email,password);
        Assert.assertTrue(signUpPage.checkWarningIconsCount(warningIconsCount),"Warning icon didn't display when missing symbols on email field");
    }

    @TmsLink("VBET-T14")
    @Test(groups = "signUpUrl",dataProvider = "passwordFieldValidation",dataProviderClass = SignUpDataProvider.class)
    public void passwordFieldValidation(String userName,String email,String password,int warningIconsCount){
        signUpPage.clickOnTermsAndPolicyCheckbox();
        fillInAllFields(userName,email,password);
        Assert.assertTrue(signUpPage.checkWarningIconsCount(warningIconsCount),"Warning icon didn't display when filling in incorrect value on Password field");
    }

    @TmsLink("VBET-T15")
    @Test(groups = "signUpUrl")
    public void welcomeOfferRedirection(){
        if (!signUpUrl.equals("https://www.vbet.com/ka/%E1%83%A1%E1%83%9E%E1%83%9D%E1%83%A0%E1%83%A2%E1%83%98-1#?sign-up")){
            signUpPage.waitUntilWelcomeOfferLinkDisplay();
            signUpPage.clickOnWelcomeOfferImage();
            signUpPage.switchToWelcomeOfferTab();
            Assert.assertEquals(logInPage.getUrl(),welcomeOfferUrl);
            signUpPage.closeWelcomeOfferTab();
            signUpPage.switchToRegisterTab();
        }else
            return;
    }

    @TmsLink("VBET-T16")
    @Test(groups = "signUpUrl")
    public void signInLinkRedirection(){
        signUpPage.openUrl(signUpUrl);
        signUpPage.waitUntilLogInLinkAppear();
        signUpPage.clickOnSignInLink();
        Assert.assertEquals(logInPage.getUrl(),signInUrl);
    }

    @AfterMethod(groups = "signUpUrl")
    public void reloadPage() {
        clearCaches();
    }

    private void generateEmailAndUsername(){
        userName = RandomUtils.generateRandomLettersAndNumbers(8) + "S";
        email = RandomUtils.generateRandomLetters(5) + "@betmail.com";
    }

    private void logIn(){
        logInPage.fillEmailPassFields(email,password);
        logInPage.clickOnLoginButton();
    }

    private void fillInAllFields(String userName,String email,String password){
        if (!userName.isBlank())
            signUpPage.fillInUsernameField(userName);
        if (!email.isBlank())
            signUpPage.fillInEmailField(email);
        if (!password.isBlank())
            signUpPage.fillInPasswordField(password);
        signUpPage.clickOnSubmitButton();
    }

}
