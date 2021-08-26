package vbetnet;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LogInPage;
import pages.CasinoPage;
import pages.SportsPage;
import utilities.TestBase;


public class BannerNetTest extends TestBase {
    private SportsPage sportsPage;
    private LogInPage logInPage;
    private CasinoPage casinoPage;
    private final String email = "testing789@yopmail.com";
    private final String password = "Test1111";
    private String casinoUrl;
    private String liveCasinoUrl;
    private String signInUrl;

    @BeforeClass
    @Parameters({"casinoUrl","liveCasinoUrl","signInUrl"})
    public void setUp(String casinoUrl,String liveCasinoUrl,String signInUrl){
        logInPage = new LogInPage(driver);
        sportsPage = new SportsPage(driver);
        casinoPage = new CasinoPage(driver);
        this.casinoUrl = casinoUrl;
        this.liveCasinoUrl = liveCasinoUrl;
        this.signInUrl = signInUrl;
        logIn();
    }

    @Test
    public void bannerButtonsRedirectionOnCasinoPage(){
        logInPage.openUrl(casinoUrl);
        casinoPage.isCurrentPageOpenNet();
    }

    @Test
    public void bannerButtonsRedirectionOnLiveCasinoPage(){
        logInPage.openUrl(liveCasinoUrl);
        casinoPage.isCurrentPageOpenNet();
    }

    private void logIn(){
        logInPage.openUrl(signInUrl);
        logInPage.fillEmailPassFields(email,password);
        logInPage.clickOnLoginButton();
        logInPage.waitUntilProfileLogoDisplayed();
    }
}
