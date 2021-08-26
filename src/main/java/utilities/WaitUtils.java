package utilities;

import exceptions.ElementNotFoundException;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * @author amalyahayrapetova
 */

public class WaitUtils {
    WebDriver driver;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
    }

    private boolean waitUntilConditions(By by, int timeInSeconds, int type) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
            switch (type) {

                case 0: //appear
                    wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
                    break;
                case 1: //disappear
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
                    break;
                case 2: //clickable
                    wait.until(ExpectedConditions.elementToBeClickable(by));
                    break;
                case 3: //visible
                    wait.until(ExpectedConditions.visibilityOfElementLocated(by));
                    break;
            }
        } catch (TimeoutException ex) {
            throw new ElementNotFoundException(by.toString());
        }
        return true;
    }

    /**
     * Wait until Element appear on the page
     * @param by
     * @param timeInSeconds
     * @return
     */
    public boolean waitUntilElementAppear(By by, int timeInSeconds) {
        return waitUntilConditions(by, timeInSeconds, 0);
    }

    /**
     * Wait until element text will be appear
     * @param by
     * @param timeInSeconds
     * @param text
     * @return
     */
    public boolean waitUntilElementTextToBe(By by, int timeInSeconds, String text) {
        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
        return wait.until(ExpectedConditions.textToBe(by, text));
    }

    /**
     * Wait until element will be appear
     * @param by
     * @return
     */
    public boolean waitUntilElementAppear(By by) {
        return waitUntilConditions(by, 15, 0);
    }

    /**
     * Wait until element at current index will be appear
     * @param element
     * @param timeInSeconds
     * @return
     */
    public WebElement waitUntilElementAppear(WebElement element, int timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }


    /**
     * Wait until element will be disappear from the page at given time
     * @param by
     * @param timeInSeconds
     * @return
     */
    public boolean waitUntilElementDisappear(By by, int timeInSeconds) {
        return waitUntilConditions(by, timeInSeconds, 1);
    }


    /**
     * Wait until element will be disappear from the page at fix time
     * @param by
     * @return
     */
    public boolean waitUntilElementDisappear(By by) {
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        return waitUntilConditions(by, 15, 1);
    }

    /**
     * Wait until WEB element will be disappear from the page at fix time
     * @param element
     * @param timeInSeconds
     */
    public void waitUntilElementDisappear(WebElement element, int timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    /**
     * Wait until WEB element will be disappear from the page at fix time
     * @param element
     * @return
     */
    public void waitUntilElementDisappear(WebElement element) {
        waitUntilElementDisappear(element, 5);
    }

    /**
     * Wait until element becomes clickable during given timeInSeconds
     * @param by
     * @param timeInSeconds
     * @return
     */
    public boolean waitUntilElementClickable(By by, int timeInSeconds) {
        return waitUntilConditions(by, timeInSeconds, 2);
    }

    /**
     * Wait until element becomes clickable during fixed time
     * @param by
     * @return
     */
    public boolean waitUntilElementClickable(By by) {
        return waitUntilConditions(by, 15, 2);
    }

    /**
     * Wait until element becomes visible
     * @param by
     * @param timeInSeconds
     * @return
     */
    public boolean waitUntilElementVisible(By by, int timeInSeconds) {
        return waitUntilConditions(by, timeInSeconds, 3);
    }

    /**
     * Wait until element becomes visible  during  fixed time
     * @param by
     * @return
     */
    public boolean waitUntilElementVisible(By by) {
        return waitUntilConditions(by, 15, 3);
    }


    /**
     *
     * @param sleepTime
     */
    public static void threadSleep(int sleepTime) {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitUntilPageIsLoad(){
        new WebDriverWait(driver, 30).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

    }

}
