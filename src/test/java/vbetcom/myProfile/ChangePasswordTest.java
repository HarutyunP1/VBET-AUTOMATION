package vbetcom.myProfile;

import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;
import pages.profile.ChangePasswordPage;
import pages.profile.MyProfilePage;
import utilities.RandomUtils;
import utilities.TestBase;

public class ChangePasswordTest extends TestBase {

    private String signInUrl;
    private String changePasswordUrl;
    private String sportsUrl;
    private String signUpUrl;
    private ChangePasswordPage changePasswordPage;
    private LogInPage logInPage;
    private SignUpPage signUpPage;
    private SportsPage sportsPage;
    private MyProfilePage myProfilePage;
    private String email;
    private String password;
    private String userName;
    private String newPass = "Test1111";

    @BeforeClass
    @Parameters({"signInUrl","changePasswordUrl","sportsUrl","signUpUrl"})
    public void setUp(String signInUrl,String changePasswordUrl,String sportsUrl,String signUpUrl){
        this.signInUrl = signInUrl;
        this.changePasswordUrl = changePasswordUrl;
        this.sportsUrl = sportsUrl;
        this.signUpUrl = signUpUrl;
        changePasswordPage = new ChangePasswordPage(driver);
        logInPage = new LogInPage(driver);
        signUpPage = new SignUpPage(driver);
        sportsPage = new SportsPage(driver);
        myProfilePage = new MyProfilePage(driver);
    }

    @BeforeMethod
    public void openLogInsUrl(){
        changePasswordPage.openUrl(sportsUrl);
        logInPage.closePopUp(signInUrl);
        logInPage.openUrl(signInUrl);
        validRegisterProcess();
        logIn(email, password);
    }

    @TmsLink("VBET-T26")
    @Test
    public void validateChangePasswordFunctionality(){
        sportsPage.clickOnProfileLogo();
        myProfilePage.clickOnChangePassword();
        fillInFieldsOnChangePassPage(password,newPass,newPass);
        password = newPass;
        clearCaches();
        logInPage.openUrl(signInUrl);
        logInPage.closePopUp(signInUrl);
        logIn(email,newPass);
        logInPage.waitUntilLogInButtonDisappear();
        Assert.assertTrue(sportsPage.isProfileIconDisplayed(),"Password didn't change.");
    }

    @TmsLink("VBET-T27")
    @Test
    public void validateChangePasswordFunctionalityLogInWithOldPass(){
        changePasswordPage.openUrl(changePasswordUrl);
        fillInFieldsOnChangePassPage(password,newPass,newPass);
        clearCaches();
        logInPage.openUrl(signInUrl);
        logInPage.closePopUp(signInUrl);
        logIn(email,password);
        Assert.assertEquals(signInUrl,logInPage.getUrl(),"User logged in with previous password.");
    }

    @TmsLink("VBET-T28")
    @Test
    public void validateChangePasswordFunctionalityOldAndNewPassSame(){
        logInPage.waitUntilProfileLogoDisplayed();
        changePasswordPage.openUrl(changePasswordUrl);
        fillInFieldsOnChangePassPage(password,password,password);
        Assert.assertTrue(logInPage.checkWarningIconsCount(1),"Warning icon didn't appear when old and new passwords are same.");
    }

    @TmsLink("VBET-T29")
    @Test
    public void validateChangePasswordFunctionalityNewAndConfNewPassAreNotSame(){
        changePasswordPage.openUrl(changePasswordUrl);
        fillInFieldsOnChangePassPage(password,newPass,newPass + "invalid pass");
        Assert.assertTrue(logInPage.checkWarningIconsCount(1),"Warning icon didn't appear when new and confirm passwords are same.");
    }

    @AfterMethod
    public void reloadPage() {
        clearCaches();
    }

    private void logIn(String email,String password){
        logInPage.openUrl(signInUrl);
        logInPage.fillEmailPassFields(email,password);
        logInPage.clickOnLoginButton();
        logInPage.waitUntilProfileLogoDisplayed();
        logInPage.waitUntilBalanceLoad();
    }

    private void fillInFieldsOnChangePassPage(String currentPass,String newPass,String confNewPass){
        if (!currentPass.isBlank())
            changePasswordPage.fillInCurrentPassField(currentPass);
        if (!newPass.isBlank())
            changePasswordPage.fillInNewPassField(newPass);
        if (!confNewPass.isBlank())
            changePasswordPage.fillInConfNewPass(confNewPass);
        changePasswordPage.clickOnSavePassword();
    }

    private void validRegisterProcess(){
        signUpPage.openUrl(signUpUrl);
        userName = RandomUtils.generateRandomLetters(8) + "S";
        email = RandomUtils.generateRandomLettersAndNumbers(6) + "@yopmail.com";
        password = "Test" + RandomUtils.generateRandomLetters(2) + RandomUtils.generateRandomNumbers(4);
        signUpPage.fillInUsernameField(userName);
        signUpPage.fillInEmailField(email);
        signUpPage.fillInPasswordField(password);
        signUpPage.clickOnTermsAndPolicyCheckbox();
        signUpPage.clickOnSubmitButton();
        logInPage.reloadLogInPage();
    }

}
