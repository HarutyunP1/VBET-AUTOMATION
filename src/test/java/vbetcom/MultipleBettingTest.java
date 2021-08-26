package vbetcom;

import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LogInPage;
import pages.BettingPage;
import pages.SportsPage;
import utilities.TestBase;


public class MultipleBettingTest extends TestBase {

    private BettingPage betting;
    private LogInPage logInPage;
    private SportsPage sportsPage;
    private final int countOfRates = 2;
    private final String stakeValue = "1";
    private final String email = "cny_currencycasino@gmail.com";
    private final String password = "Automation123?";
    private String sportsUrl;
    private String signInUrl;

    @BeforeClass
    @Parameters({"sportsUrl","signInUrl"})
    public void setUp(String sportsUrl,String signInUrl){
        betting = new BettingPage(driver);
        logInPage = new LogInPage(driver);
        sportsPage = new SportsPage(driver);
        this.sportsUrl = sportsUrl;
        this.signInUrl = signInUrl;
    }

    @BeforeMethod
    public void openSportsUrl(){
        logIn();
        betting.openUrl(sportsUrl);
        logInPage.closePopUp(signInUrl);
    }

    @TmsLink("VBET-T21")
    @Test
    public void verifyTheFunctionalityOfValidBettingProcess(){
        int previousPrice;
        sportsPage.waitUntilPageIsLoad();
        sportsPage.clickOnEventsRate(countOfRates);
        sportsPage.clickOnCheckedEventsRates();
        betting.fillInStakeField(stakeValue);
        previousPrice = betting.getUserPriceValue();
        betting.waitUntilPlaceBetButtonAppear();
        betting.clickOnPlaceBetButton();
        betting.waitUntilPlaceBetButtonDisappear();
        clearCaches();
        logIn();
        Assert.assertTrue( betting.isPriceSelectedFromUserPrice(Integer.parseInt(stakeValue) ,previousPrice), "Price isn't selected from user");
    }

    @TmsLink("VBET-T22")
    @Test
    public void verifyTheFunctionalityOfPossibleWinTest(){
        sportsPage.waitUntilPageIsLoad();
        sportsPage.clickOnEventsRate(countOfRates);
        betting.fillInStakeField(stakeValue);
        sportsPage.getEventsRateText();
        Assert.assertTrue(betting.possibleWinCalculation(stakeValue),"Possible win value isn't correct");
    }

    @AfterMethod
    public void clearCash(){
        clearCaches();
    }


    private void logIn(){
        logInPage.openUrl(signInUrl);
        logInPage.fillEmailPassFields(email,password);
        logInPage.clickOnLoginButton();
        logInPage.waitUntilUserBalanceVisible();
    }
}
