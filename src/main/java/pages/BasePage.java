package pages;

import exceptions.ElementNotFoundException;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.WaitUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class BasePage {

    private final Logger LOGGER = Logger.getLogger(BasePage.class);
    protected WebDriver driver;
    private WebDriverWait wait;
    public WaitUtils waitUtils;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        waitUtils = new WaitUtils(driver);
    }
    /**
     * click on element
     *
     * @param by
     */
    public void clickOnElement(By by) {
        try {
            driver.findElement(by).click();
            LOGGER.info("The element: " + by.toString() + " is clicked");

        } catch (Exception e) {
            throw new ElementNotFoundException(by.toString());
        }

    }

    /**
     * click on element by index
     *
     * @param by
     * @param index
     */
    public void clickOnElement(By by, int index) {
        try {
            driver.findElements(by).get(index).click();
            LOGGER.info("The element: " + by.toString() + " at given index " + index + " is clicked");

        } catch (Exception e) {
            throw new ElementNotFoundException(by.toString());

        }
    }


    /**
     * get text from element
     *
     * @param by
     * @return
     */
    public String getText(By by) {
        String text;
        try {
            text = driver.findElement(by).getText();
            LOGGER.info("The tex of element " + by.toString() + " is " + text);
            return text;

        } catch (Exception e) {
            throw new ElementNotFoundException(by.toString());

        }
    }

    /**
     * get text from element by index
     *
     * @param by
     * @param index
     * @return
     */
    public String getText(By by, int index) {
        String text;
        try {
            text = driver.findElements(by).get(index).getText();
            LOGGER.info("The tex of element " + by.toString() + " at given " + index + " is " + text);
            return text;

        } catch (Exception e) {
            throw new ElementNotFoundException(by.toString());

        }


    }

    /**
     * type text
     *
     * @param by
     * @param text
     */
    public void typeText(By by, String text) {
        try {
            driver.findElement(by).sendKeys(text);
            LOGGER.info("The tex " + text + " is send to " + by.toString());

        } catch (Exception e) {
            throw new ElementNotFoundException(by.toString());

        }


    }

    /**
     * type text at index
     *
     * @param by
     * @param index
     * @param text
     */
    public void typeText(By by, int index, String text) {
        try {
            driver.findElements(by).get(index).sendKeys(text);
            LOGGER.info("The tex " + text + " is send to " + by.toString());

        } catch (Exception e) {
            throw new ElementNotFoundException(by.toString());

        }


    }

    /**
     * Get page title
     *
     * @return
     */
    public String getPageTitle() {
        String title = driver.getTitle();
        LOGGER.info("The Page title is " + title);
        return title;
    }


    /**
     * Navigate to given url page
     *
     * @param url
     */
    public void navigateToUrl(String url) {
        driver.navigate().to(url);
        LOGGER.info("Navige to url: " + url);
    }

    /**
     * Refresh/update page
     */
    public void refreshPage() {
        driver.navigate().refresh();
        LOGGER.info("The page is refreshed");
    }


    /**
     * Navigate back from the page
     */
    public void navigateBackFromThePage() {
        driver.navigate().back();
        LOGGER.info("navigateBackFromThePage() method is executed");

    }


    /**
     * Navigate forward from the page
     */
    public void navigateForwardFromThePage() {
        driver.navigate().forward();
        LOGGER.info("navigateForwardFromThePage() method is executed");

    }

    /**
     * Sets the amount of time to wait for a page load to complete before throwing an error.
     * If the timeout is negative, page loads can be indefinite.
     *
     * @param timeOut
     */
    public void pageLoad(long timeOut) {
        driver.manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);
        LOGGER.info("pageLoad() method is executed");
    }

    /**
     * The command retrieve the URL of the webPage the user is currently accessing
     */
    public String getCurrentUrl() {
        String url = driver.getCurrentUrl();
        LOGGER.info("The page url is: " + url);
        return url;
    }


    /**
     * Switch to frame
     *
     * @param by
     */
    public void switchFrames(By by) {
        WebElement element = driver.findElement(by);
        driver.switchTo().frame(element);

    }
    /**
     * Switch to frame by index
     *
     * @param by
     * @param by1
     */
    public void switchFrames(By by,By by1) {
        WebElement element = driver.findElement(by);
        driver.switchTo().frame(element);
        WebElement element1=driver.findElement(by1);
        driver.switchTo().frame(element1);

    }


    /**
     * Switch to frame
     *
     * @param index
     */
    public void switchFrames(int index) {
        driver.switchTo().frame(index);

    }


    /**
     * Open ur
     *
     * @param url
     */
    public void openUrl(String url) {
        driver.get(url);
    }


    /**
     * Check if element enabled
     *
     * @param by
     */
    protected boolean isElementEnabled(By by) {
        return driver.findElement(by).isEnabled();
    }

    /**
     * Check if element is displayed
     *
     * @param by
     * @return
     */
    protected boolean isElementDisplayed(By by) {
        try {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            return driver.findElement(by).isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }

    }


    /**
     * Check if with the same path elements are displayed
     *
     * @param by
     * @param index
     * @return
     */
    protected boolean isElementsDisplayed(By by,int index) {
        return driver.findElements(by).get(index).isDisplayed();
    }

    /**
     * Getting elements from page
     *
     * @param by
     * @return
     */

    protected List<WebElement> getElements(By by){
        List<WebElement> elements = driver.findElements(by);

        return elements;
    }

    /**
     * Check elements count on page
     *
     * @param by
     * @return
     */
    protected int getElementsCount(By by) {
        return driver.findElements(by).size();

    }


    /**
     * Drag the sourceElement and drop to targetElement
     *
     * @param sourceElement
     * @param targetElement
     */
    protected void dragAndDropElement(By sourceElement, By targetElement) {
        WebElement sourceLocator = driver.findElement(sourceElement);
        WebElement destinationLocator = driver.findElement(targetElement);
        Actions actions = new Actions(driver);
        actions.dragAndDrop(sourceLocator, destinationLocator).build().perform();

    }

    /**
     * Hove/move over web elements like over menu to see submenu etc.
     *
     * @param by
     */
    protected void moveToElement(By by) {
        WebElement element = driver.findElement(by);
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();

    }


    /**
     * Get element Atribute
     *
     * @param by
     * @param attribute
     * @return
     */
    protected String getAttribute(By by, String attribute) {
        return driver.findElement(by).getAttribute(attribute);
    }

    /**
     * The command is used to retrieve the page source
     * of the webpage the user is currently accessing.
     *
     * @return
     */
    protected String getPageSource() {
        return driver.getPageSource();
    }


    /**
     * Closes the web browser window that the user is currently working on or we can also say
     * the window that is being currently accessed by the WebDriver
     */
    protected void closeWindow() {
        driver.close();
    }


    /**
     * Closes down all the windows that the program has opened.
     * Do not confuse with closeWindow() method
     */
    protected void quiteWindow() {
        driver.quit();
    }


    /**
     * Mouse hover to element of given index.
     *
     * @param by
     * @param index
     */
    protected void mouseHover(By by, int index) {
        WebElement element = driver.findElements(by).get(index);
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();

    }

    /**
     * Mouse hover to element
     *
     * @param by
     */
    protected void mouseHover(By by) {
        WebElement element = driver.findElement(by);
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();


    }

    /**
     * Selecting multiple items by value in a drop drop down list.
     *
     * @param by
     * @param value
     */
    protected void selectByValue(By by, String value) {
        Select selectByValue = new Select(driver.findElement(by));
        selectByValue.selectByValue(value);
    }

    /**
     * Selecting multiple items by visibility of text in a drop drop down list.
     *
     * @param by
     * @param text
     */
    protected void selectByVisibleText(By by, String text) {
        Select selectByValue = new Select(driver.findElement(by));
        selectByValue.selectByVisibleText(text);

    }

    /**
     * Check if radio button is selected
     *
     * @param by
     */
    protected boolean isRadioButtonChecked(By by) {
        return driver.findElement(by).isSelected();
    }

    /**
     * Check if radio buttons are selected
     *
     * @param by
     * @param index
     */
    protected boolean isRadioButtonsChecked(By by,int index) {
        return driver.findElements(by).get(index).isSelected();
    }

    /**
     * Selecting multiple items by index of text in a drop drop down list.
     *
     * @param by
     * @param index
     */
    protected void selectByIndex(By by, int index) {
        Select selectByValue = new Select(driver.findElement(by));
        selectByValue.selectByIndex(index);

    }

    /**
     * Scrolling to element.
     *
     * @param by
     */
    protected void scrollToElement(By by) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(by));

    }

    /**
     * CLear fields.
     *
     * @param by
     */
    protected void clearFields(By by){
        List<WebElement> elements = driver.findElements(by);
        for (int i = 0; i < elements.size(); i++){
            elements.get(i).clear();
        }
    }

    /**
     * Switch driver to another tab.
     *
     * @param index
     */
    protected void switchDriverToNewTab(int index){
        ArrayList<String> availableWindows = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(availableWindows.get(index));
    }

    /**
     * Is element displayed switching to frames.
     *
     *@param by
     */
    public boolean isElementDisplayedOnFrame(By by){
         List<WebElement> frames = driver.findElements(By.tagName("<iframe>"));
         boolean bool = false;
         for (int i = 0;i < frames.size();i++){
            try {
                driver.switchTo().frame(frames.get(i));
                if (isElementDisplayed(by)) {
                    bool = true;
                    break;
                }
            }catch (Exception e) {
                if (i == frames.size() - 1)
                    bool = false;
            }
        }
        return bool;
    }
}
