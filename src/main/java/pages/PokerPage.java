package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class PokerPage extends BasePage {
    SoftAssert softAssert = new SoftAssert();
    private final By PLAY_NOW_BUTTON = By.cssSelector("a[class='btn buttons1569414849790']");
    private final By BANNER_BUTTON = By.cssSelector("a[class='btn buttons1563950551332']");
    private final By ERROR_PAGE_TEXT = By.cssSelector("div[class='uc-content '] h3");

    public PokerPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPlayNowButtonDisplayed(){
        return isElementDisplayed(PLAY_NOW_BUTTON);
    }

    public void clickOnPlayNowButton(){
        clickOnElement(PLAY_NOW_BUTTON);
    }



    public ArrayList<String> getUrlsOfButtons(){
        List<WebElement> elements = getElements(BANNER_BUTTON);
        ArrayList<String> hrefs = new ArrayList<>();
        for(WebElement list : elements){
            hrefs.add(list.getAttribute("href"));
        }
        return hrefs;
    }

    public void isCurrentPageOpen(){
        List<String> list = getUrlsOfButtons();
        for (int i = 0;i < list.size();i++){
           try {
               openUrl(list.get(i));
               softAssert.assertFalse(isElementDisplayed(ERROR_PAGE_TEXT),list.get(i) + "at index " +  i);
           }catch (Exception e){
               // Can't open url.
           }
        }
        softAssert.assertAll();
    }


}
