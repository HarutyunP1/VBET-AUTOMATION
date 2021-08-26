package pages;

import enums.Url;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import utilities.WaitUtils;

public class LiveCasinoPage extends BasePage {

    public LiveCasinoPage(WebDriver driver){
        super(driver);
    }

    private final By PLAY_NOW_BUTTON = By.cssSelector("a[class='btn buttons1563950551332']");
    private final By RIGHT_ROW = By.cssSelector("div[class='slider-right uci-slider-arrow-1-right']");
    private final By FILTER_ICON = By.cssSelector("span[class='uci- icon-S0i6']");

    public void clickOnPlayNowButton() throws InterruptedException {
        for (int i = 0;i < getElements(PLAY_NOW_BUTTON).size();i++){
            WaitUtils.threadSleep(1000);
            while (getElements(PLAY_NOW_BUTTON).get(i).isDisplayed()){
                if (getElements(PLAY_NOW_BUTTON).get(i).getText().equals("Play now")){
                    getElements(PLAY_NOW_BUTTON).get(i).click();
                    i = getElements(PLAY_NOW_BUTTON).size();
                    break;
                }
            }
        }
    }

    public void clickOnRightRow(){
        clickOnElement(RIGHT_ROW);
    }

    public void openLiveCasinoPageViaUrl(){
        openUrl(Url.LIVE_CASINO_URL.getUrl());
    }

    public boolean isFilterIconDisplayed(){
        return isElementDisplayed(FILTER_ICON);
    }
}
