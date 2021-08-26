package utilities;

import annotations.Failing;
import enums.Browser;
import listeners.AutomationListener;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import java.io.IOException;
import java.lang.reflect.Method;
import java.rmi.activation.ActivateFailedException;

/**
 * @author amalyahayrapetova
 */
@Listeners(value = AutomationListener.class)
public class TestBase extends TestExecution {
    public static WebDriver driver;
    private ThreadLocal<WebDriver> driverThread;
    private final Logger LOGGER = Logger.getLogger(TestBase.class);


    /**
     * Set driver, manage browser window.
     *
     * @throws IOException
     */
    @BeforeClass(alwaysRun = true)
    public void initDriver() throws IOException {
        setDriver(Browser.CHROME);
        this.driver.manage().window().maximize();
        driverThread = new ThreadLocal();
        driverThread.set(driver);
    }


    /**
     * Set driver or browser type
     *
     * @param browserType
     * @throws IOException
     */
    private void setDriver(Browser browserType) throws IOException {
        switch (browserType) {
            case CHROME:
                driver = new ChromeDriver(initChromeOptions());
                break;
            case FIREFOX:
                //todo
                break;
            case SAFARI:
                //todo
                break;
            default:
                LOGGER.info("Browser : " + browserType + " is invalid, Launching Chrome as default browser.");
                driver = new ChromeDriver(initChromeOptions());
        }
    }

    /**
     * Initialize chrome driver options.
     *
     * @return
     * @throws IOException
     */
    private ChromeOptions initChromeOptions() throws IOException {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions chromeOptions = new ChromeOptions();
        initChromeOperatingSystem();
        capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.merge(capabilities);
        return chromeOptions;
    }


    /**
     * Initialize Failing annotation
     *
     * @param method
     */
    @Deprecated
    private void initFailingAnnotation(Method method) throws ActivateFailedException {
        Failing failing = method.getAnnotation(Failing.class);
        if (failing != null) {
            String message = "This test has @Failing annotation with a reason " +
                    failing.reason() + " reported by " +
                    failing.user() + " on " +
                    failing.createdDate() + ".There is an issue logged in with key: " +
                    failing.issue();
            throw new ActivateFailedException(message);
        }

    }

    /**
     * Set test execution status.
     *
     * @param method
     * @param testResult
     * @throws IOException
     * @throws InterruptedException
     */

    @AfterMethod(alwaysRun = true)
    public void executeTest(Method method, ITestResult testResult) throws IOException, InterruptedException {
        setExecution(method, testResult);
    }

    /**
     * Close driver(browser) after each class.
     */
    @AfterClass(alwaysRun = true)
    public void quiteDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
            driverThread.remove();
        }

    }


    /**
     * Get driver
     *
     * @return
     */
    public static WebDriver getDriver() {
        return driver;
    }


    /**
     * Check operating system and set proper driver
     *
     * @throws IOException
     */
    private void initChromeOperatingSystem() throws IOException {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            System.setProperty(PropertyConfig.getProperty("chromeDriverName"), FilePaths.USER_DIR_PATH + PropertyConfig.getProperty("chromeDriverWin"));
        } else if (os.contains("nux") || os.contains("nix")) {
            System.setProperty(PropertyConfig.getProperty("chromeDriverName"), FilePaths.USER_DIR_PATH + PropertyConfig.getProperty("chromeDriverLinux"));
        } else if (os.contains("mac")) {
            System.setProperty(PropertyConfig.getProperty("chromeDriverName"), FilePaths.USER_DIR_PATH + PropertyConfig.getProperty("chromeDriverMac"));
        }

    }

    /**
     * Clear caches of browser.
     * You can call this method in tests.(If necessary)
     */
    protected void clearCaches() {
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
    }


}
