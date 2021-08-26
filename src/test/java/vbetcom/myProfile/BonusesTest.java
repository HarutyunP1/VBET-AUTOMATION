package vbetcom.myProfile;

import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.profile.BonusesPage;
import pages.LogInPage;
import pages.profile.MyProfilePage;
import utilities.TestBase;

public class BonusesTest extends TestBase {

    private String signInUrl;
    private String sportsBookUrl;
    private String casinoUrl;
    private BonusesPage bonusesPage;
    private LogInPage logInPage;
    private MyProfilePage myProfilePage;
    private String email = "automation7@yopmail.com";
    private String password = "Test1111";

    @BeforeClass
    @Parameters({"signInUrl","sportsBookUrl","casinoUrl"})
    public void setUp(String signInUrl,String sportsBookUrl,String casinoUrl){
        this.signInUrl = signInUrl;
        this.sportsBookUrl = sportsBookUrl;
        this.casinoUrl = casinoUrl;
        bonusesPage = new BonusesPage(driver);
        logInPage = new LogInPage(driver);
        myProfilePage = new MyProfilePage(driver);
        logInPage.openUrl(signInUrl);
        logInPage.fillEmailPassFields(email,password);
        logInPage.clickOnLoginButton();
        logInPage.waitUntilProfileLogoDisplayed();
        logInPage.waitUntilBalanceLoad();
    }

    @TmsLink("VBET-T58")
    @Test
    public void validationForSportsBookElementsDisplayed(){
        bonusesPage.openUrl(casinoUrl);
        myProfilePage.clickOnSportsBook();
        bonusesPage.waitUntilBonusCodeDisplayed();
        Assert.assertTrue(bonusesPage.isSubmitButtonDisplayed(),"Submit button isn't displayed.");
        Assert.assertTrue(bonusesPage.isBonusCodeTableDisplayed(),"Bonus code table isn't displayed.");
    }

    @TmsLink("VBET-T59")
    @Test
    public void validationForCasinoElementsDisplayed(){
        bonusesPage.openUrl(sportsBookUrl);
        myProfilePage.clickOnCasino();
        bonusesPage.waitUntilBonusCodeDisplayed();
        Assert.assertTrue(bonusesPage.isSubmitButtonDisplayed(),"Submit button isn't displayed.");
        Assert.assertTrue(bonusesPage.isBonusCodeTableDisplayed(),"Bonus code table isn't displayed.");
    }

    @TmsLink("VBET-T60")
    @Test
    public void validationForHeaderElementsSelected(){
        bonusesPage.openUrl(casinoUrl);
        bonusesPage.waitUntilBonusCodeDisplayed();
        bonusesPage.clickOnCasino();
        Assert.assertTrue(bonusesPage.isICasinoSelected(),"Casino isn't selected.");
        bonusesPage.clickOnSportsBook();
        Assert.assertTrue(bonusesPage.isSportsBookSelected(),"Sports book isn't selected.");
    }

}
