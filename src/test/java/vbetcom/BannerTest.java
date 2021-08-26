package vbetcom;

import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CasinoPage;
import pages.LogInPage;
import pages.PokerPage;
import pages.SportsPage;
import utilities.TestBase;

public class BannerTest extends TestBase {

    private SportsPage sportsPage;
    private LogInPage logInPage;
    private CasinoPage casinoPage;
    private PokerPage pokerPage;
    private final String email = "testing789@yopmail.com";
    private final String password = "Test1111";
    private String casinoUrl;
    private String liveCasinoUrl;
    private String signInUrl;
    private String pokerUrl;



    @Parameters({"casinoUrl", "liveCasinoUrl", "signInUrl","pokerUrl"})
    @BeforeClass
    public void setUp(String casinoUrl, String liveCasinoUrl, String signInUrl,String pokerUrl) {
        logInPage = new LogInPage(driver);
        sportsPage = new SportsPage(driver);
        casinoPage = new CasinoPage(driver);
        pokerPage = new PokerPage(driver);
        this.casinoUrl = casinoUrl;
        this.liveCasinoUrl = liveCasinoUrl;
        this.signInUrl = signInUrl;
        this.pokerUrl = pokerUrl;
        logIn();
        sportsPage.waitUntilProfileIconVisible();
    }

    @TmsLink("VBET-T17")
    @Test
    public void bannerButtonsRedirectionOnCasinoPage() {
        logInPage.openUrl(casinoUrl);
        casinoPage.isCurrentPageOpen();
    }

    @TmsLink("VBET-T18")
    @Test
    public void bannerButtonsRedirectionOnLiveCasinoPage() {
        logInPage.openUrl(liveCasinoUrl);
        casinoPage.isCurrentPageOpen();
    }

    @TmsLink("VBET-T71")
    @Test
    public void bannerButtonsRedirectionOnLivePokerPage(){
        pokerPage.openUrl(pokerUrl);
        pokerPage.isCurrentPageOpen();
    }

    private void logIn() {
        logInPage.openUrl(signInUrl);
        logInPage.closePopUp(signInUrl);
        logInPage.fillEmailPassFields(email, password);
        logInPage.clickOnLoginButton();
    }

}
