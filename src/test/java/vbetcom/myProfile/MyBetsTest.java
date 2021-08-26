package vbetcom.myProfile;

import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;
import pages.profile.MyBetsPage;
import pages.profile.MyProfilePage;
import utilities.TestBase;

public class MyBetsTest extends TestBase {

    private String signInUrl;
    private String myBetsUrl;
    private String sportsUrl;
    private LogInPage logInPage;
    private SportsPage sportsPage;
    private MyBetsPage myBetsPage;
    private BettingPage bettingPage;
    private MyProfilePage myProfilePage;
    private String emailWithPrice = "automation3@yopmail.com";
    private String emailWithoutPrice = "automation7@yopmail.com";
    private String password = "Test1111";
    private String stakeValue = "1";

    @BeforeClass
    @Parameters({"signInUrl","sportsUrl","myBetsUrl"})
    public void setUp(String signInUrl,String sportsUrl,String myBetsUrl){
        this.signInUrl = signInUrl;
        this.myBetsUrl = myBetsUrl;
        this.sportsUrl = sportsUrl;
        sportsPage = new SportsPage(driver);
        myBetsPage = new MyBetsPage(driver);
        logInPage = new LogInPage(driver);
        bettingPage = new BettingPage(driver);
        myProfilePage = new MyProfilePage(driver);
    }

    @BeforeMethod
    public void openMyBetsPage(){
        logInPage.openUrl(signInUrl);
        logInPage.closePopUp(signInUrl);
    }

    @TmsLink("VBET-T57")
    @Test
    public void validationForBetCountChange(){
        logIn(emailWithPrice);
        myBetsPage.openUrl(myBetsUrl);
        myBetsPage.waitUntilReloadButtonAppear();
        String countOfPreviousBets = myBetsPage.getCountOfBetsList() + "";
        sportsPage.openUrl(sportsUrl);
        sportsPage.clickOnEventsRate(1);
        bettingPage.fillInStakeField(stakeValue);
        bettingPage.waitUntilPlaceBetButtonAppear();
        bettingPage.clickOnPlaceBetButton();
        bettingPage.waitUntilPlaceBetButtonDisappear();
        myBetsPage.openUrl(myBetsUrl);
        Assert.assertEquals((myBetsPage.getCountOfBetsList() + ""),(Integer.parseInt(countOfPreviousBets) + 1)+"","Bets count isn't change.");
    }

    @TmsLink("VBET-T56")
    @Test
    public void validationForTextIfThereIsNotBet(){
        logIn(emailWithoutPrice);
        sportsPage.clickOnProfileLogo();
        myProfilePage.clickOnMyBets();
        myBetsPage.waitUntilReloadButtonAppear();
        Assert.assertTrue(myBetsPage.isThereIsNotBetTextDisplayed(),"There is not bet text isn't displayed.");
    }

    private void logIn(String email){
        logInPage.fillEmailPassFields(email,password);
        logInPage.clickOnLoginButton();
        logInPage.waitUntilProfileLogoDisplayed();
        logInPage.waitUntilBalanceLoad();
    }

    @AfterMethod
    public void clearCache(){
        clearCaches();
    }


}
