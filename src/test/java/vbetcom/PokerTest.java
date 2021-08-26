package vbetcom;

import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.GamesPage;
import pages.PokerPage;
import utilities.TestBase;

public class PokerTest extends TestBase {

    private String pokerUrl;
    private PokerPage pokerPage;
    private GamesPage gamesPage;

    @BeforeClass
    @Parameters({"pokerUrl"})
    public void setUp(String pokerUrl){
        this.pokerUrl = pokerUrl;
        pokerPage = new PokerPage(driver);
        gamesPage = new GamesPage(driver);
    }

    @TmsLink("VBET-T70")
    @Test
    public void validationForPlayNowButtonRedirection(){
        pokerPage.openUrl(pokerUrl);
        pokerPage.clickOnPlayNowButton();
        Assert.assertTrue(gamesPage.isGameTablePokerDisplayed(),"Poker game table isn't displayed.");
    }
}
