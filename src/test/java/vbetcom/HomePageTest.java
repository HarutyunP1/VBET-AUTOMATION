package vbetcom;

import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;
import utilities.TestBase;

public class HomePageTest extends TestBase {

    private String homePageUrl;
    private String signInUrl;
    private HomePage homePage;
    private SportsPage sportsPage;
    private CasinoPage casinoPage;
    private LiveCasinoPage liveCasinoPage;
    private PokerPage pokerPage;
    private LogInPage logInPage;
    private SignUpPage signUpPage;
    private String userName;
    private String email;
    private String existingEmail = "automation6@yopmail.com";
    private String password = "Test1111";

    @BeforeClass
    @Parameters({"signInUrl","homePageUrl"})
    public void setUp(String signInUrl,String homePageUrl){
        homePage = new HomePage(driver);
        sportsPage = new SportsPage(driver);
        casinoPage = new CasinoPage(driver);
        liveCasinoPage = new LiveCasinoPage(driver);
        pokerPage = new PokerPage(driver);
        logInPage = new LogInPage(driver);
        signUpPage = new SignUpPage(driver);
        this.homePageUrl = homePageUrl;
        this.signInUrl = signInUrl;
    }

    @BeforeMethod
    public void openHomePage(){
        homePage.openUrl(homePageUrl);
    }

    @TmsLink("VBET-T67")
    @Test
    public void validationForBannersRedirection(){
        homePage.clickOnSports();
        Assert.assertTrue(sportsPage.isSearchFieldDisplayed(),"Search field isn't displayed.");
        homePage.openUrl(homePageUrl);
        logInPage.closePopUp(signInUrl);
        homePage.clickOnCasino();
        Assert.assertTrue(casinoPage.isFilterIconDisplayed(),"Filter icon isn't displayed on Casino page.");
        homePage.openUrl(homePageUrl);
        homePage.clickOnLiveCasino();
        Assert.assertTrue(liveCasinoPage.isFilterIconDisplayed(),"Filter icon isn't displayed on LiveCasino page.");
        homePage.openUrl(homePageUrl);
        homePage.clickOnPoker();
        Assert.assertTrue(pokerPage.isPlayNowButtonDisplayed(),"Play now button isn't displayed.");
        homePage.openUrl(homePageUrl);
    }

    @TmsLink("VBET-T68")
    @Test
    public void validationForRedirectionOfVbetCom(){
        homePage.clickOnVbetImage();
        Assert.assertTrue(homePage.isAllPromoTextDisplayed());
    }

    private void logIn(String email,String password){
        logInPage.fillEmailPassFields(email,password);
        logInPage.clickOnLoginButton();
    }


}
