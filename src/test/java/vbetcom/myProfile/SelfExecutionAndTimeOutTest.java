package vbetcom.myProfile;

import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;
import pages.profile.MyProfilePage;
import pages.profile.SelfExecutionPage;
import pages.profile.TimeOutPage;
import utilities.TestBase;

public class SelfExecutionAndTimeOutTest extends TestBase {

    private String signInUrl;
    private String sportsUrl;
    private String selfExecutionUrl;
    private String selfExecution;
    private SelfExecutionPage selfExecutionPage;
    private LogInPage logInPage;
    private TimeOutPage timeOutPage;
    private SportsPage sportsPage;
    private MyProfilePage myProfilePage;
    private String email = "automation7@yopmail.com";
    private String password = "Test1111";

    @BeforeClass
    @Parameters({"signInUrl","selfExecution","sportsUrl","selfExecution"})
    public void setUp(String signInUrl,String selfExecutionUrl,String sportsUrl,String selfExecution){
        this.signInUrl = signInUrl;
        this.sportsUrl = sportsUrl;
        this.selfExecutionUrl = selfExecutionUrl;
        this.selfExecution = selfExecution;
        selfExecutionPage = new SelfExecutionPage(driver);
        logInPage = new LogInPage(driver);
        timeOutPage = new TimeOutPage(driver);
        sportsPage = new SportsPage(driver);
        myProfilePage = new MyProfilePage(driver);
        logInPage.openUrl(signInUrl);
        logInPage.fillEmailPassFields(email,password);
        logInPage.clickOnLoginButton();
        logInPage.waitUntilProfileLogoDisplayed();
        logInPage.waitUntilBalanceLoad();
    }

    @BeforeMethod
    public void openSportsPage(){
        logInPage.openUrl(sportsUrl);
        logInPage.waitUntilProfileLogoDisplayed();
        logInPage.waitUntilBalanceLoad();
    }

    @TmsLink("VBET-T33")
    @Test
    public void validationForChoosePeriodValuesSelfExecutionPage(){
        sportsPage.clickOnProfileLogo();
        myProfilePage.clickOnSelfExecution();
        selfExecutionPage.waitUntilSaveSelfButtonAppear();
        Assert.assertTrue(selfExecutionPage.checkChoosePeriodValues(signInUrl),"Choose Period isn't right.");
    }

    @TmsLink("VBET-T34")
    @Test
    public void validationForSaveSelfButtonDisabledSelfExecutionPage(){
        selfExecutionPage.openUrl(selfExecutionUrl);
        Assert.assertTrue(selfExecutionPage.isSaveSelfButtonDisabled(),"Save Self button isn't displayed.");
    }

    @TmsLink("VBET-T35")
    @Test
    public void validationForSaveSelfButtonNotDisabledSelfExecutionPage(){
        selfExecutionPage.openUrl(selfExecutionUrl);
        selfExecutionPage.chooseSaveSelfDropDown();
        Assert.assertFalse(selfExecutionPage.isSaveSelfButtonDisabled(),"Save Self button isn't displayed.");
    }

    @TmsLink("VBET-T36")
    @Test
    public void validationForChoosePeriodValuesTimeOutPage(){
        selfExecutionPage.openUrl(selfExecution);
        Assert.assertTrue(timeOutPage.checkChoosePeriodValues(signInUrl),"Choose Previous values aren't right.");
    }

    @TmsLink("VBET-T37")
    @Test
    public void validationForSaveTimeOutButtonDisabledTimeOutPage(){
        selfExecutionPage.openUrl(selfExecution);
        Assert.assertTrue(timeOutPage.isSaveSelfButtonDisabled(),"Save Self button isn't displayed.");
    }

    @TmsLink("VBET-T38")
    @Test
    public void validationForSaveTimeOutButtonNotDisabledTimeOutPage(){
        sportsPage.clickOnProfileLogo();
        myProfilePage.clickOnTimeOut();
        timeOutPage.chooseSaveTimeOutDropDown();
        Assert.assertFalse(timeOutPage.isSaveSelfButtonDisabled(),"Save Self button isn't displayed.");
    }
}
