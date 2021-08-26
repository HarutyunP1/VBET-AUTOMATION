package vbetcom;

import dataproviders.LogInDataProvider;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;
import utilities.TestBase;


/**
 * @author amalyahayrapetova
 */
public class LogInTest extends TestBase {

    private SportsPage sportsPage;
    private LogInPage logInPage;
    private CasinoPage casinoPage;
    private LiveCasinoPage liveCasinoPage;
    private SignUpPage signUpPage;
    private HomePage homePage;
    private final String validEmail = "automation6@yopmail.com";
    private final String validPassword = "Test1111";
    private String loginUrl;
    private String forgotPassUrl;
    private String signUpUrl;
    private String sportsUrl;
    private String tournamentsUrl;
    private String liveCasinoUrl;
    private String homePageUrl;

    @BeforeClass
    @Parameters({"signInUrl","forgotPassUrl","signUpUrl","sportsUrl","tournamentsUrl","liveCasinoUrl","homePageUrl"})
    public void setUp(String loginUrl,String forgotPassUrl,String signUpUrl,String sportsUrl,String tournamentsUrl,String liveCasinoUrl,String homePageUrl) {
        logInPage = new LogInPage(driver);
        signUpPage = new SignUpPage(driver);
        sportsPage = new SportsPage(driver);
        casinoPage = new CasinoPage(driver);
        liveCasinoPage = new LiveCasinoPage(driver);
        homePage = new HomePage(driver);
        this.loginUrl = loginUrl;
        this.forgotPassUrl = forgotPassUrl;
        this.signUpUrl = signUpUrl;
        this.sportsUrl = sportsUrl;
        this.tournamentsUrl = tournamentsUrl;
        this.liveCasinoUrl = liveCasinoUrl;
        this.homePageUrl = homePageUrl;
    }

    @BeforeMethod(onlyForGroups = "signInUrl")
    public void openSignInUrl() {
        logInPage.openUrl(loginUrl);
    }

    @TmsLink("VBET-T1")
    @Test(groups = "signInUrl")
    public void loginWithValidCredentials() {
        logInPage.fillInEmailField(validEmail);
        logInPage.fillInPasswordField(validPassword);
        logInPage.clickOnLoginButton();
        logInPage.waitUntilLogInButtonDisappear();
        Assert.assertTrue(sportsPage.isProfileIconDisplayed(), "The log in button isn't worked");
    }

    @TmsLink("VBET-T2")
    @Test(groups = "signInUrl", dataProviderClass = LogInDataProvider.class,dataProvider = "loginWithInvalidCredentials")
    public void loginWithInvalidCredentials(String email,String password){
        logInPage.fillInEmailField(email);
        logInPage.fillInPasswordField(password);
        logInPage.clickOnLoginButton();
        Assert.assertEquals(loginUrl,logInPage.getUrl(),"Logged in with invalid credentials");
    }

    @TmsLink("VBET-T3")
    @Test(groups = "signInUrl", dataProviderClass = LogInDataProvider.class,dataProvider = "validationForErrorMessages")
    public void validationForErrorMessagesTest(String email,String password,int warningIconCount) {
        logInPage.fillEmailPassFields(email,password);
        logInPage.clickOnLoginButton();
        Assert.assertTrue(logInPage.checkWarningIconsCount(warningIconCount), "The warning icon didn't display when fields are missing");
    }

    @TmsLink("VBET-T4")
    @Test(groups = "signInUrl")
    public void redirectionOfForgotPasswordLinkTest() {
        logInPage.clickOnForgotPasswordLink();
        Assert.assertEquals(logInPage.getUrl(), forgotPassUrl, "Didn't redirect to forgot password page");
    }

    @TmsLink("VBET-T5")
    @Test(groups = "signInUrl")
    public void redirectionOfJoinUsLinkTest() {
        logInPage.reloadLogInPage();
        logInPage.clickOnJoinUsButton();
        logInPage.reloadLogInPage();
        Assert.assertEquals(signUpPage.getSignUpUrl(), signUpUrl, "Didn't redirect to register page");
    }

    @TmsLink("VBET-T6")
    @Test(groups = "signInUrl")
    public void passwordVisibilityIconTest() {
        logInPage.clickOnPasswordVisibilityIconWhenVisible();
        Assert.assertEquals(logInPage.getPassFieldAttribute(), "text", "Type didn't change to 'text'");
        logInPage.clickOnPasswordVisibilityIconWhenHide();
        Assert.assertEquals(logInPage.getPassFieldAttribute(), "password", "Type didn't change to 'password'");
    }

    @TmsLink("VBET-T72")
    @Test(groups = "signInUrl", dataProviderClass = LogInDataProvider.class,dataProvider = "signInCloseTest")
    public void signInCloseTest(String email,String password) {
        logInPage.fillEmailPassFields(email, password);
        logInPage.clickOnCloseIcon();
        sportsPage.clickSignInButton();
        Assert.assertTrue(logInPage.getEmailFieldText().isBlank() & logInPage.getPasswordFieldText().isBlank(), "Text of fields aren't clear");
    }

    @TmsLink("VBET-T7")
    @Test(groups = "signInUrl")
    public void logInPopUpOpenWhenTryingToBet() {
        sportsPage.openUrl(sportsUrl);
        logInPage.waitUntilPageIsFinish();
        logInPage.closePopUp(loginUrl);
        sportsPage.clickOnFirstRates();
        sportsPage.waitUntilSignInAndPlaceBetButtonAppear();
        sportsPage.clickOnSignInAndBetButton();
        logInPage.reloadLogInPage();
        Assert.assertTrue(logInPage.isLogInPopUpDisplayed(), "Log in pop up isn't open when trying to bet");
    }

    @TmsLink("VBET-T8")
    @Test(groups = "signInUrl")
    public void logInPopUpOpenWhenTryingToPLayCasinoGame(){
        logInPage.reloadLogInPage();
        sportsPage.openUrl(sportsUrl);
        sportsPage.scrollToCasinoGamesSection(sportsUrl);
        casinoPage.clickOnPLayForRealButton();
        logInPage.reloadLogInPage();
        Assert.assertTrue(logInPage.isLogInPopUpDisplayed(), "Log in pop up isn't open when trying to play real");
    }

    @TmsLink("VBET-T10")
    @Test
    public void validationForLogInFromHomePage(){
        homePage.openUrl(homePageUrl);
        logInPage.closePopUp(loginUrl);
        homePage.waitUntilSignInButtonAppear(homePageUrl);
        homePage.clickOnSignInButton(homePageUrl);
        homePage.closePopUp(homePageUrl);
        logInPage.fillEmailPassFields(validEmail,validPassword);
        logInPage.clickOnLoginButton();
        logInPage.waitUntilLogInButtonDisappear();
        Assert.assertTrue(sportsPage.isProfileIconDisplayed(),"Didn't log in.");
        clearCaches();
    }

    @AfterMethod(onlyForGroups = "signInUrl")
    public void reloadPage() {
        clearCaches();
    }

}



