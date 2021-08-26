package vbetcom;

import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.PromotionsPage;
import utilities.TestBase;

public class PromotionsTest extends TestBase {

    private PromotionsPage promotionsPage;
    private String promoUrl;

    @BeforeClass
    @Parameters("promoUrl")
    public void setUp(String promoUrl){
        promotionsPage = new PromotionsPage(driver);
        this.promoUrl = promoUrl;
    }

    @BeforeMethod
    public void openPromoPage(){
        promotionsPage.openUrl(promoUrl);
    }

    @TmsLink("VBET-T69")
    @Test
    public void verifyTheFunctionalityRedirectionOfPromoLinks(){
        promotionsPage.checkRedirectionOfPromoLinks();
    }

}
