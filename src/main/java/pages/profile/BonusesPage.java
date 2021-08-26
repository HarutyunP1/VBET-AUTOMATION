package pages.profile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import utilities.WaitUtils;

public class BonusesPage extends BasePage {

    private final By SPORTS_BOOK = By.cssSelector("div[class='account-info section selected ember-view'] div[data-tab='bonus-sportsbook']");
    private final By CASINO = By.cssSelector("div[class='account-info section selected ember-view'] div[data-tab='bonus-casino']");
    private final By SUBMIT_BUTTON = By.cssSelector("a[class='btn buttons1558357729029']");
    private final By BONUS_CODE_TABLE = By.cssSelector("div[class='bets-table ember-light-table ember-view'] table tbody");
    private final By BONUS_CODE = By.cssSelector("span[class='bonus-link-text']");

    public BonusesPage(WebDriver driver){
        super(driver);
    }

    public boolean isSportsBookSelected(){
        return getAttribute(SPORTS_BOOK,"class").contains("selected");
    }

    public boolean isICasinoSelected(){
        return getAttribute(CASINO,"class").contains("selected");
    }

    public boolean isSubmitButtonDisplayed(){
        return isElementDisplayed(SUBMIT_BUTTON);
    }

    public boolean isBonusCodeTableDisplayed(){
        return isElementDisplayed(BONUS_CODE_TABLE);
    }

    public void clickOnCasino(){
        clickOnElement(CASINO);
    }

    public void clickOnSportsBook(){
        clickOnElement(SPORTS_BOOK);
    }

    public void waitUntilBonusCodeDisplayed(){
        waitUtils.waitUntilElementAppear(BONUS_CODE);
    }
}
