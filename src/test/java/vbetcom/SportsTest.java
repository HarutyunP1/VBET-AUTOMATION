package vbetcom;

import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LogInPage;
import pages.SportsPage;
import utilities.TestBase;

public class SportsTest extends TestBase {

    private SportsPage sportsPage;
    private LogInPage logInPage;
    private String sportsUrl;

    @BeforeClass
    @Parameters({"sportsUrl","signInUrl"})
    public void setUp(String sportsUrl,String signInUrl) {
        sportsPage = new SportsPage(driver);
        logInPage = new LogInPage(driver);
        sportsPage.openUrl(sportsUrl);
        logInPage.closePopUp(signInUrl);
        this.sportsUrl = sportsUrl;
    }

    @TmsLink("VBET-T74")
    @Test
    public void validationForSequenceOfTabs(){
        Assert.assertTrue(sportsPage.isSportsDisplayed(sportsUrl) & sportsPage.isCasinoDisplayed(sportsUrl),"Sequence of Sports or Casio isn't wright");
        Assert.assertTrue(sportsPage.isSLiveCasinoDisplayed(sportsUrl) & sportsPage.isPokerDisplayed(sportsUrl),"Sequence of Live Casino or Poker isn't wright");
        Assert.assertTrue(sportsPage.isGamesDisplayed(sportsUrl) & sportsPage.isLotteryDisplayed(sportsUrl),"Sequence of Games or Lottery isn't wright");
    }

    @TmsLink("VBET-T76")
    @Test
    public void validationForBannerElementsSequence(){
        Assert.assertTrue(sportsPage.isWelcomeOfferDisplayed(sportsUrl),"Welcome offer place isn't wight");
        Assert.assertTrue(sportsPage.isEsportsWelcomeDisplayed(sportsUrl),"Esport welcome place isn't wight");
        Assert.assertTrue(sportsPage.isVarEdGoalDisplayed(sportsUrl),"Var ed goal place isn't wight");
    }

    @TmsLink("VBET-T75")
    @Test
    public void validationForBannerElementsRedirection(){
        sportsPage.clickOnWelcomeOffer();
        Assert.assertFalse(sportsPage.isErrorPageTextDisplayed(),"Clicking on Welcome offer redirect to Error 404 page.");
        sportsPage.openUrl(sportsUrl);
        sportsPage.clickOnEsportsOffer();
        Assert.assertFalse(sportsPage.isErrorPageTextDisplayed(),"Clicking on Esport welcome redirect to Error 404 page.");
        sportsPage.openUrl(sportsUrl);
        sportsPage.clickOnVarEdGoal();
        Assert.assertFalse(sportsPage.isErrorPageTextDisplayed(),"Clicking on Var Ed Goal redirect to Error 404 page.");
        sportsPage.openUrl(sportsUrl);
    }
}
