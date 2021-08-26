package pages.profile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import utilities.WaitUtils;

public class LimitsPage extends BasePage {

    private final By DAY_FIELD = By.name("day");
    private final By WEEK_FIELD = By.name("week");
    private final By MONTH_FIELD = By.name("mounth");
    private final By SAVE_BUTTON = By.cssSelector("button[class='btn buttons1558357729029 ']");
    private final By NOTE_TEXT = By.cssSelector("span[class='info-footer']");

    public LimitsPage(WebDriver driver){
        super(driver);
    }

    public boolean isDayFieldDisplayed(){
        return isElementDisplayed(DAY_FIELD);
    }


    public boolean isWeekFieldDisplayed(){
        return isElementDisplayed(WEEK_FIELD);
    }


    public boolean isMonthFieldDisplayed(){
        return isElementDisplayed(MONTH_FIELD);
    }


    public boolean isSaveButtonDisplayed(){
        return isElementDisplayed(SAVE_BUTTON);
    }

    public void waitUntilNoteTextAppear(){
        waitUtils.waitUntilElementAppear(NOTE_TEXT);
    }

}
