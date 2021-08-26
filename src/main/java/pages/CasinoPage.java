package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import pages.BasePage;

import java.util.List;

import java.util.ArrayList;

public class CasinoPage extends BasePage {

    public CasinoPage(WebDriver driver){
        super(driver);
    }

    private final By JOIN_BUTTON = By.cssSelector("div[class='tournament-join  click-overrider']");
    private final By PLAY_FOR_REAL_BUTTON = By.cssSelector("div[class='play-icon-container ']");
    private final By CASINO_GAME_PLAY_AREA = By.cssSelector("div[class='casino-game-play']");
    private final By BANNER_BUTTONS = By.cssSelector("div[class='column col-sm-11 '] a");
    private final By BANNER_BUTTONS_NET = By.cssSelector("div[class='row-container  container '] a[class='btn buttons1558357729029']");
    private final By POPUP_CLOSE_ICON = By.cssSelector("polygon");
    private final By POPUP_FRAME = By.cssSelector("iframe[class='intercom-tour-frame intercom-5x43y3 e1s9bqu40']");
    private final By ERROR_PAGE_TEXT = By.cssSelector("div[class='uc-content '] h3");
    private final By FILTER_ICON = By.cssSelector("span[class='uci- icon-S0i4']");
    private SoftAssert softAssert = new SoftAssert();

    public void clickOnJoinButton(){
        clickOnElement(JOIN_BUTTON);
    }

    public void clickOnPLayForRealButton(){
        hoverOnCasinoGamePlayArea(0);
        waitUtils.waitUntilElementAppear(getElements(PLAY_FOR_REAL_BUTTON).get(0),6);
        getElements(PLAY_FOR_REAL_BUTTON).get(0).click();
    }

    public void isCurrentPageOpen(){
        List<String> list = getUrlsOfButtons();
        for (int i = 0;i < list.size();i++){
           try{
               openUrl(list.get(i));
           }catch (Exception e){

           }
            softAssert.assertFalse(isElementDisplayed(ERROR_PAGE_TEXT),list.get(i) + i);
        }
        softAssert.assertAll();
    }

    public ArrayList<String> getUrlsOfButtons(){
        List<WebElement> elements = getElements(BANNER_BUTTONS);
        ArrayList<String> hrefs = new ArrayList<>();
        for(WebElement list : elements){
            hrefs.add(list.getAttribute("href"));
        }
        return hrefs;
    }

    public void isCurrentPageOpenNet(){
        ArrayList<String> list = getUrlsOfButtons();
        for (int i = 0;i < list.size();i++){
            openUrl(list.get(i));
            softAssert.assertFalse(isElementDisplayed(ERROR_PAGE_TEXT),list.get(i) + "at index " +  i);
        }
        softAssert.assertAll();
    }

    public ArrayList<byte[]> getUrlsOfButtonsNet(){
        List<WebElement> elements = getElements(BANNER_BUTTONS_NET);
        ArrayList<byte[]> hrefs = new ArrayList<>();
        for(WebElement list : elements){
            hrefs.add(list.getAttribute("href").getBytes());
        }
        return hrefs;
    }

    public void hoverOnCasinoGamePlayArea(int index){
        mouseHover(CASINO_GAME_PLAY_AREA,index);
    }

    private void closePopUp() {
        switchFrames(POPUP_FRAME);
        clickOnElement(POPUP_CLOSE_ICON);
    }

    public boolean isFilterIconDisplayed(){
        return isElementDisplayed(FILTER_ICON);
    }
}
