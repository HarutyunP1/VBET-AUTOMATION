package pages.logInNet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class LogInNetPage extends BasePage {

    private final By PLAY_NOW_BUTTON = By.cssSelector("div[class='row-container  container '] a[class='btn buttons1558357729029'] span");

    public LogInNetPage(WebDriver driver){
        super(driver);
    }

    public void clickOnPlayNowButton(String signInUrl) throws InterruptedException {

        for (int i = 0; i < getElements(PLAY_NOW_BUTTON).size(); i++) {
            Thread.sleep(1000);
            while (getElements(PLAY_NOW_BUTTON).get(i).isDisplayed()) {
                        if (getElements(PLAY_NOW_BUTTON).get(i).getText().equals("Play now")) {
                            getElements(PLAY_NOW_BUTTON).get(i).click();
                            i = getElements(PLAY_NOW_BUTTON).size();
                            break;
                        }
                }
            }
        }
    }

