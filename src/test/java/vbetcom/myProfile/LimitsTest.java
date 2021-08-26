package vbetcom.myProfile;

import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;
import pages.profile.LimitsPage;
import pages.profile.MyProfilePage;
import utilities.TestBase;

public class LimitsTest extends TestBase {

    private String signInUrl;
    private String limitsUrl;
    private LimitsPage limitsPage;
    private LogInPage logInPage;
    private MyProfilePage myProfilePage;
    private SportsPage sportsPage;
    private String email = "automation7@yopmail.com";
    private String password = "Test1111";

    @BeforeClass
    @Parameters({"signInUrl","limitsUrl"})
    public void setUp(String signInUrl,String limitsUrl){
        this.signInUrl = signInUrl;
        this.limitsUrl = limitsUrl;
        limitsPage = new LimitsPage(driver);
        logInPage = new LogInPage(driver);
        sportsPage = new SportsPage(driver);
        myProfilePage = new MyProfilePage(driver);
        logInPage.openUrl(signInUrl);
        logInPage.fillEmailPassFields(email,password);
        logInPage.clickOnLoginButton();
        logInPage.waitUntilProfileLogoDisplayed();
        logInPage.waitUntilBalanceLoad();
    }

    @TmsLink("VBET-T42")
    @Test
    public void validationForInputFieldsAreDisplayed(){
        sportsPage.clickOnProfileLogo();
        myProfilePage.clickOnLimits();
        Assert.assertTrue(limitsPage.isDayFieldDisplayed(),"Day field isn't displayed");
        Assert.assertTrue(limitsPage.isWeekFieldDisplayed(),"Week field isn't displayed");
        Assert.assertTrue(limitsPage.isMonthFieldDisplayed(),"Month field isn't displayed");
    }

    @TmsLink("VBET-T43")
    @Test
    public void validationForSaveButtonIsDisplayed(){
        limitsPage.openUrl(limitsUrl);
        Assert.assertTrue(limitsPage.isSaveButtonDisplayed(),"Save button isn't displayed.");
    }
}
