package vbetnet;

import dataproviders.LogInNetDataProvider;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;
import pages.logInNet.LogInNetPage;
import utilities.TestBase;
import utilities.WaitUtils;

public class LogInNetTest extends TestBase {


    /**
     * @author amalyahayrapetova
     */

        private SportsPage sportsPage;
        private LogInPage logInPage;
        private CasinoPage casinoPage;
        private LiveCasinoPage liveCasinoPage;
        private SignUpPage signUpPage;
        private LogInNetPage logInNetPage;
        private WaitUtils waitUtils;
        private final String validEmail = "testing789999@yopmail.com";
        private final String validPassword = "Test1111";
        private final String invalidEmail = "invalidEmail@yopmail.com";
        private final String invalidPassword = "InvalidPassword1111";
        private String signInUrl;
        private String forgotPasswordUrl;
        private String signUpUrl;
        private String sportsUrl;
        private String tournamentsUrl;
        private String liveCasinoUrl;

        @BeforeClass
        @Parameters({"signInUrl","forgotPasswordUrl","signUpUrl","sportsUrl","tournamentsUrl","liveCasinoUrl"})
        public void setUp(String signInUrl,String forgotPasswordUrl,String signUpUrl,String sportsUrl,String tournamentsUrl,String liveCasinoUrl) {
            logInPage = new LogInPage(driver);
            logInNetPage = new LogInNetPage(driver);
            signUpPage = new SignUpPage(driver);
            sportsPage = new SportsPage(driver);
            logInPage = new LogInPage(driver);
            casinoPage = new CasinoPage(driver);
            waitUtils = new WaitUtils(driver);
            liveCasinoPage = new LiveCasinoPage(driver);
            this.signInUrl = signInUrl;
            this.forgotPasswordUrl = forgotPasswordUrl;
            this.sportsUrl = sportsUrl;
            this.tournamentsUrl = tournamentsUrl;
            this.liveCasinoUrl = liveCasinoUrl;
            this.signUpUrl = signUpUrl;
        }

        @BeforeMethod(onlyForGroups = "signInUrl")
        public void openSignInUrl() {
            logInPage.openUrl(signInUrl);
        }

        @Test(groups = "signInUrl")
        public void loginWithValidCredentials() {
            logInPage.fillInEmailField(validEmail);
            logInPage.fillInPasswordField(validPassword);
            logInPage.clickOnLoginButton();
            Assert.assertTrue(sportsPage.isProfileIconDisplayed(), "The log in button isn't worked");
        }

        @Test(groups = "signInUrl",dataProviderClass = LogInNetDataProvider.class,dataProvider = "loginWithInvalidCredentials")
        public void loginWithInvalidCredentials(String email,String password){
            logInPage.fillInEmailField(email);
            logInPage.fillInPasswordField(password);
            logInPage.clickOnLoginButton();
            Assert.assertEquals(signInUrl,logInPage.getUrl(),"Able to log in with invalid credentials");
        }

        @Test(groups = "signInUrl",dataProviderClass = LogInNetDataProvider.class,dataProvider = "validationForErrorMessages")
        public void validationForErrorMessagesTest(String email,String password,int warningIconsCount) {
            logInPage.fillEmailPassFields(email, password);
            logInPage.clickOnLoginButton();
            Assert.assertTrue(logInPage.checkWarningIconsCount(warningIconsCount), "The warning icon near fields are missing");
        }

        @Test(groups = "signInUrl")
        public void redirectionOfForgotPasswordLinkTest() {
            logInPage.clickOnForgotPasswordLink();
            Assert.assertEquals(logInPage.getUrl(), forgotPasswordUrl, "Didn't redirect to forgot password page");
        }

        @Test(groups = "signInUrl")
        public void redirectionOfJoinUsLinkTest() {
            logInPage.clickOnJoinUsButton();
            Assert.assertEquals(signUpPage.getSignUpUrl(),signUpUrl, "Didn't redirect to register page");
        }

        @Test(groups = "signInUrl")
        public void passwordVisibilityIconTest() {
            logInPage.clickOnPasswordVisibilityIconWhenVisible();
            Assert.assertEquals(logInPage.getPassFieldAttribute(), "text", "Type didn't change to 'text'");
            logInPage.clickOnPasswordVisibilityIconWhenHide();
            Assert.assertEquals(logInPage.getPassFieldAttribute(), "password", "Type didn't change to 'password'");
        }

        @Test(groups = "signInUrl",dataProviderClass = LogInNetDataProvider.class,dataProvider = "signInCloseTest")
        public void signInCloseTest(String email,String password) {
            logInPage.fillEmailPassFields(email, password);
            logInPage.clickOnCloseIcon();
            sportsPage.clickSignInButton();
            Assert.assertTrue(logInPage.getEmailFieldText().isBlank(), "Text of fields aren't clear (for email)");
            Assert.assertTrue(logInPage.getPasswordFieldText().isBlank(), "Text of fields aren't clear(for password)");
        }

        @Test(groups = "signInUrl")
        public void logInPopUpOpenWhenTryingToBet() {
            logInPage.openUrl(sportsUrl);
            sportsPage.clickOnFirstRates();
            casinoPage.clickOnPLayForRealButton();
            logInPage.reloadLogInPage();
            Assert.assertTrue(logInPage.isLogInPopUpDisplayed(), "Log in pop up isn't open when trying to bet");
        }

        @Test(groups = "signInUrl")
        public void logInPopUpOpenWhenTryingToPLayCasinoGame() throws InterruptedException {
            logInPage.openUrl(sportsUrl);
            sportsPage.scrollToCasinoGamesSection(sportsUrl);
            casinoPage.clickOnPLayForRealButton();
            logInPage.reloadLogInPage();
            Assert.assertTrue(logInPage.isLogInPopUpDisplayed(), "Log in pop up isn't open when trying to play real");
        }

        @AfterMethod(onlyForGroups = "signInUrl")
        public void reloadPage() {
            clearCaches();
        }

        private void logOut(){
            sportsPage.hoverOnProfileLogo();
            sportsPage.clickOnLogOutButton();
        }

}
