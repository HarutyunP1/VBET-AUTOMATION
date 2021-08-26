package pages.profile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import utilities.WaitUtils;

public class MyBetsPage extends BasePage {

    private final By BETS_LIST = By.cssSelector("tr[class='lt-row is-expandable ember-view']");
    private final By RELOAD_BUTTON = By.cssSelector("button[class='btn buttons1558357729029']");
    private final By THERE_IS_NOT_BET_TEXT = By.cssSelector("div[class='no-record-found'] span");

    public MyBetsPage(WebDriver driver){
        super(driver);
    }

    public int getCountOfBetsList(){
        return getElementsCount(BETS_LIST);
    }

    public void waitUntilReloadButtonAppear(){
        waitUtils.waitUntilElementAppear(RELOAD_BUTTON);
    }

    public boolean isThereIsNotBetTextDisplayed(){
        return isElementDisplayed(THERE_IS_NOT_BET_TEXT);
    }
}
