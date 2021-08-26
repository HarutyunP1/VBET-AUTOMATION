package vbetnet;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.LogInPage;
import pages.BettingPage;
import pages.SportsPage;
import utilities.TestBase;

public class SingleBettingNetTest extends TestBase {

    private BettingPage betting;
    private LogInPage logInPage;
    private SportsPage sportsPage;
    private final int countOfRates = 2;
    private final String[] stakeValue = {"1","2"};
    private final String email = "cny_currencycasino@gmail.com";
    private final String password = "Automation123?";
    private final String bettingType = "Single";
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
    }

    @Test
    public void verifyTheFunctionalityOfValidBettingProcessMultiStake(){
        int previousPrice;
        sportsPage.waitUntilPageIsLoad();
        sportsPage.clickOnEventsRate(countOfRates);
        betting.selectBettingType(bettingType);
        betting.fillInStakeFieldSingleBetMultiStake(stakeValue);
        previousPrice = betting.getUserPriceValue();
        betting.clickOnPlaceBetButton();
        betting.waitUntilPlaceBetButtonDisappear();
        clearCaches();
        logIn();
        Assert.assertTrue( betting.isPriceSelectedFromUserPriceSingleBetMultiStake(stakeValue ,previousPrice), "Price isn't selected from user");
    }

    @Test
    public void verifyTheFunctionalityOfValidBettingProcess(){
        int previousPrice;
        sportsPage.waitUntilPageIsLoad();
        sportsPage.clickOnEventsRate(countOfRates);
        betting.selectBettingType(bettingType);
        betting.fillInStakeFieldSingleBet(stakeValue[0]);
        previousPrice = betting.getUserPriceValue();
        betting.clickOnPlaceBetButton();
        betting.waitUntilPlaceBetButtonDisappear();
        clearCaches();
        logIn();
        Assert.assertTrue( betting.isPriceSelectedFromUserPrice(Integer.parseInt(stakeValue[0]) ,previousPrice,countOfRates), "Price isn't selected from user");
    }

    @AfterMethod
    public void clearCash(){
        clearCaches();
    }


    private void logIn(){
        logInPage.openUrl(signInUrl);
        logInPage.closePopUp(signInUrl);
        logInPage.fillEmailPassFields(email,password);
        logInPage.clickOnLoginButton();
        logInPage.waitUntilUserBalanceVisible();
    }

}
