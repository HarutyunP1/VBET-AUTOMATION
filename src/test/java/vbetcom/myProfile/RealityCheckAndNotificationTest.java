package vbetcom.myProfile;

import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;
import pages.profile.EditProfilePage;
import pages.profile.MyProfilePage;
import pages.profile.NotificationsPage;
import pages.profile.RealityCheckPage;
import utilities.TestBase;

public class RealityCheckAndNotificationTest extends TestBase {
    private String signInUrl;
    private RealityCheckPage realityCheckPage;
    private String sportsUrl;
    private String realityCheck;
    private LogInPage logInPage;
    private SportsPage sportsPage;
    private NotificationsPage notificationsPage;
    private EditProfilePage editProfilePage;
    private MyProfilePage myProfilePage;
    private String email = "automation7@yopmail.com";
    private String password = "Test1111";

    @BeforeClass
    @Parameters({"signInUrl","realityCheck","sportsUrl"})
    public void setUp(String signInUrl,String realityCheck,String sportsUrl){
        this.signInUrl = signInUrl;
        this.sportsUrl = sportsUrl;
        this.realityCheck = realityCheck;
        realityCheckPage = new RealityCheckPage(driver);
        logInPage = new LogInPage(driver);
        notificationsPage = new NotificationsPage(driver);
        editProfilePage = new EditProfilePage(driver);
        sportsPage = new SportsPage(driver);
        myProfilePage = new MyProfilePage(driver);
        logInPage.openUrl(signInUrl);
        logInPage.fillEmailPassFields(email,password);
        logInPage.clickOnLoginButton();
        logInPage.waitUntilProfileLogoDisplayed();
        logInPage.waitUntilBalanceLoad();
        realityCheckPage.openUrl(realityCheck);
    }

    @BeforeMethod
    public void openSportsPage(){
        sportsPage.openUrl(sportsUrl);
        logInPage.waitUntilProfileLogoDisplayed();
        logInPage.waitUntilBalanceLoad();
    }

    @TmsLink("VBET-T39")
    @Test
    public void validationForChoosePeriodValues(){
        realityCheckPage.openUrl(realityCheck);
        realityCheckPage.waitUntilSaveRealityButtonAppear();
        Assert.assertTrue(realityCheckPage.checkLimitValues(signInUrl),"Limit value isn't right.");
    }

    @TmsLink("VBET-T40")
    @Test
    public void validationForSaveRealityButtonDisplayed(){
        sportsPage.clickOnProfileLogo();
        myProfilePage.clickOnRealityCheck();
        Assert.assertTrue(realityCheckPage.isSaveButtonDisplayed(),"Save button isn't displayed.");
    }

    @TmsLink("VBET-T41")
    @Test
    public void validationForAnHourCheckBoxChecked(){
        realityCheckPage.openUrl(realityCheck);
        realityCheckPage.waitUntilSaveRealityButtonAppear();
        Assert.assertTrue(realityCheckPage.isAnHourChecked(),"An Hour isn't checked.");
    }

    @TmsLink("VBET-T44")
    @Test
    public void validationForIsRadioButtonsChecked() throws InterruptedException{
        sportsPage.clickOnProfileLogo();
        myProfilePage.clickOnNotifications();
        notificationsPage.clickOnRadioButtons();
        notificationsPage.clickOnConfirmButton();
        editProfilePage.fillInPasswordField(password);
        editProfilePage.clickOnSaveProfileButtonOnCurrentPassword();
        Thread.sleep(4000);
        logInPage.reloadLogInPage();
        Assert.assertTrue(notificationsPage.isRadioButtonsChecked(),"Radio buttons aren't checked.");
    }
}
