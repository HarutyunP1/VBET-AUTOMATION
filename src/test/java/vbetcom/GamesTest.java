package vbetcom;

import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.GamesPage;
import pages.LogInPage;
import pages.SportsPage;
import utilities.TestBase;
import utilities.WaitUtils;

public class GamesTest extends TestBase {

    private LogInPage logInPage;
    private GamesPage gamesPage;
    private SportsPage sportsPage;
    private String gamesUrl;
    private String email = "automation7@yopmail.com";
    private String password = "Test1111";

    @BeforeClass
    @Parameters({"signInUrl","gamesUrl"})
    public void setUp(String signInUrl,String gamesUrl) {
        logInPage = new LogInPage(driver);
        gamesPage = new GamesPage(driver);
        sportsPage = new SportsPage(driver);
        this.gamesUrl = gamesUrl;
        logInPage.openUrl(signInUrl);
        logInPage.closePopUp(signInUrl);
        logInPage.fillEmailPassFields(email,password);
        logInPage.clickOnLoginButton();
        logInPage.waitUntilProfileLogoDisplayed();
        logInPage.waitUntilBalanceLoad();
    }

    @TmsLink("VBET-T66")
    @Test
    public void validationForRedirectionOfPlayNowButton(){
        sportsPage.clickOnGamesLink();
        gamesPage.clickOnPlayNowButton(0);
//        gamesPage.fillInNickNameField();
//        gamesPage.clickOnOkButtonOnNickPopUp();
        Assert.assertTrue(gamesPage.isGameTablePokerDisplayed(),"Didn't open Poker page.");
        gamesPage.navigateBack();
        gamesPage.clickOnPlayNowButton(1);
        Assert.assertTrue(gamesPage.isGameTableBeloteDisplayed(),"Didn't open Belote page.");
        gamesPage.navigateBack();
        gamesPage.clickOnPlayNowButton(2);
        Assert.assertTrue(gamesPage.isGameTableFarkleDisplayed(),"Didn't open Farkle page.");
        gamesPage.navigateBack();
        gamesPage.clickOnPlayNowButton(3);
        Assert.assertTrue(gamesPage.isGameTableFsportDisplayed(),"Didn't open Fsport page.");
        gamesPage.openUrl(gamesUrl);
        gamesPage.clickOnPlayNowButton(4);
        Assert.assertTrue(gamesPage.isGameTableBlastDisplayed(),"Didn't open Blast page.");
        gamesPage.navigateBack();
        gamesPage.clickOnPlayNowButton(5);
        Assert.assertTrue(gamesPage.isGameTableRussianRouletteDisplayed(),"Didn't open Russian Roulet page.");
        gamesPage.navigateBack();
        gamesPage.clickOnPlayNowButton(6);
        Assert.assertTrue(gamesPage.isGameTableBackgammonDisplayed(),"Didn't open Backgammon page.");
        gamesPage.navigateBack();
        gamesPage.clickOnPlayNowButton(8);
        Assert.assertTrue(gamesPage.isGameTableCheckersDisplayed(),"Didn't open Checkers page.");
        gamesPage.navigateBack();
        gamesPage.clickOnPlayNowButton(9);
        Assert.assertTrue(gamesPage.isGameTableTalismanDisplayed(),"Didn't open Talisman page.");
        gamesPage.openUrl(gamesUrl);
        gamesPage.clickOnPlayNowButton(10);
        Assert.assertTrue(gamesPage.isGameTableKenoDisplayed(),"Didn't open Keno page.");
        gamesPage.navigateBack();
        gamesPage.clickOnPlayNowButton(11);
        Assert.assertTrue(gamesPage.isGameTableOgwilDisplayed(),"Didn't open Ogwil page.");
        gamesPage.navigateBack();
        gamesPage.clickOnPlayNowButton(12);
        Assert.assertTrue(gamesPage.isGameTableChingachoongDisplayed(),"Didn't open Chingachoong page.");
        gamesPage.navigateBack();
    }

    @TmsLink("VBET-T77")
    @Test
    public void validationForRedirectionOfCategoriesButtons(){
        gamesPage.openUrl(gamesUrl);
        gamesPage.clickOnPokerCategory();
        Assert.assertTrue(gamesPage.isGameTablePokerDisplayed(),"Didn't open Poker page.");
        gamesPage.openUrl(gamesUrl);
        gamesPage.clickOnFarkleCategory();
        Assert.assertTrue(gamesPage.isGameTableFarkleDisplayed(),"Didn't open Farkle page.");
        gamesPage.navigateBack();
        gamesPage.clickOnBlastCategory();
        Assert.assertTrue(gamesPage.isGameTableBlastDisplayed(),"Didn't open Blast page.");
        gamesPage.navigateBack();
        gamesPage.clickOnBackgammonCategory();
        Assert.assertTrue(gamesPage.isGameTableBackgammonDisplayed(),"Didn't open Backgammon page.");
        gamesPage.navigateBack();
        gamesPage.clickOnTalismanCategory();
        Assert.assertTrue(gamesPage.isGameTableTalismanDisplayed(),"Didn't open Talisman page.");
        gamesPage.navigateBack();
        gamesPage.clickOnOgwilCategory();
        Assert.assertTrue(gamesPage.isGameTableOgwilDisplayed(),"Didn't open Ogwil page.");
        gamesPage.navigateBack();
        gamesPage.clickOnBeloteCategory();
        Assert.assertTrue(gamesPage.isGameTableBeloteDisplayed(),"Didn't open Belote page.");
        gamesPage.navigateBack();
        gamesPage.clickOnFsportCategory();
        Assert.assertTrue(gamesPage.isGameTableFsportDisplayed(),"Didn't open Fsport page.");
        gamesPage.navigateBack();
        gamesPage.clickOnRussianRouletteCategory();
        Assert.assertTrue(gamesPage.isGameTableRussianRouletteDisplayed(),"Didn't open Russian Roulet page.");
        gamesPage.navigateBack();
        gamesPage.clickOnCheckersCategory();
        Assert.assertTrue(gamesPage.isGameTableCheckersDisplayed(),"Didn't open Checkers page.");
        gamesPage.navigateBack();
        gamesPage.clickOnKenoCategory();
        Assert.assertTrue(gamesPage.isGameTableKenoDisplayed(),"Didn't open Keno page.");
        gamesPage.navigateBack();
        gamesPage.clickOnChingaChoongCategory();
        Assert.assertTrue(gamesPage.isGameTableChingachoongDisplayed(),"Didn't open Chingachoong page.");
        gamesPage.navigateBack();
    }

}
