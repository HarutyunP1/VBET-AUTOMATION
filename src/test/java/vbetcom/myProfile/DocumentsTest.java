package vbetcom.myProfile;

import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.profile.DocumentsPage;
import pages.LogInPage;
import pages.profile.MyProfilePage;
import pages.SportsPage;
import utilities.TestBase;

public class DocumentsTest extends TestBase {

    private String signInUrl;
    private String documentsUrl;
    private String homePageUrl;
    private DocumentsPage documentsPage;
    private LogInPage logInPage;
    private SportsPage sportsPage;
    private MyProfilePage myProfilePage;
    private String email = "automation7@yopmail.com";
    private String password = "Test1111";

    @BeforeClass
    @Parameters({"signInUrl","documentsUrl","homePageUrl"})
    public void setUp(String signInUrl,String documentsUrl,String homePageUrl){
        this.signInUrl = signInUrl;
        this.documentsUrl = documentsUrl;
        this.homePageUrl = homePageUrl;
        documentsPage = new DocumentsPage(driver);
        logInPage = new LogInPage(driver);
        sportsPage = new SportsPage(driver);
        myProfilePage = new MyProfilePage(driver);
        logInPage.openUrl(signInUrl);
        logInPage.fillEmailPassFields(email,password);
        logInPage.clickOnLoginButton();
        logInPage.waitUntilProfileLogoDisplayed();
        logInPage.waitUntilBalanceLoad();
    }

    @TmsLink("VBET-T30")
    @Test
    public void validationForBankSlipValues(){
        sportsPage.openUrl(homePageUrl);
        sportsPage.clickOnProfileLogo();
        myProfilePage.clickOnDocuments();
        documentsPage.waitUntilChooseFileButtonAppear();
        Assert.assertTrue(documentsPage.checkBankSlipsValues(signInUrl),"Values aren't displayed");
    }

    @TmsLink("VBET-T31")
    @Test
    public void validationForChooseFileType(){
        documentsPage.openUrl(documentsUrl);
        Assert.assertTrue(documentsPage.isChooseFileTypeFile(),"File type is wrong.");
    }
}
