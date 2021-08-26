package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class PromotionsPage extends BasePage{

    public PromotionsPage(WebDriver driver){
        super(driver);
    }

    private final By PROMO_IMAGES = By.cssSelector("img[class='image']");
    private final By ERROR_PAGE_TEXT = By.cssSelector("div[class='uc-content '] h3");
    private final By PROMO_BUTTON = By.cssSelector("div[class='column col-sm-8 '] div[class='  module ModuleButton '] div[class='button'] a");
    private SoftAssert softAssert;
    private List<WebElement> promoLinks;

    public void checkRedirectionOfPromoLinks(){
        promoLinks = getElements(PROMO_IMAGES);
        softAssert = new SoftAssert();
        for (int i = 0; i < promoLinks.size();i++){
            promoLinks.get(i).click();
            softAssert.assertFalse(isElementDisplayed(ERROR_PAGE_TEXT),i + "");
            navigateBackFromThePage();
            promoLinks = getElements(PROMO_IMAGES);
        }
        softAssert.assertAll();
    }

    public void isPromoButtonDisplay(){
        promoLinks = getElements(PROMO_IMAGES);
        softAssert = new SoftAssert();
        for (int i = 0; i < promoLinks.size();i++){
            promoLinks.get(i).click();
            waitUtils.waitUntilPageIsLoad();
            softAssert.assertTrue(isElementDisplayed(PROMO_BUTTON),i + "");
            navigateBackFromThePage();
            promoLinks = getElements(PROMO_IMAGES);
        }
        softAssert.assertAll();
    }

}
