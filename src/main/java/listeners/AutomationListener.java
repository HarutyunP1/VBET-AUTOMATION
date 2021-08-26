package listeners;

import io.qameta.allure.Attachment;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static utilities.TestBase.getDriver;

public class AutomationListener implements ITestListener, IInvokedMethodListener {
    private static final Logger LOGGER = Logger.getLogger(AutomationListener.class);


    @Override
    public void onTestStart(ITestResult iTestResult) {
        LOGGER.info("----------------------------------------------------------------------");
        LOGGER.info("Starting to run " + iTestResult.getMethod().getQualifiedName() + " test method");
        LOGGER.info("----------------------------------------------------------------------");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        LOGGER.info("----------------------------------------------------------------------");
        LOGGER.info("PASSED " + iTestResult.getMethod().getQualifiedName() + " test method");
        LOGGER.info("----------------------------------------------------------------------");

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        LOGGER.info("----------------------------------------------------------------------");
        LOGGER.info("FAILED " + iTestResult.getMethod().getQualifiedName() + " test method");
        LOGGER.info("----------------------------------------------------------------------");
        takeScreenShot(iTestResult.getMethod().getMethodName());


    }


    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        LOGGER.info("----------------------------------------------------------------------");
        LOGGER.info("SKIPPED " + iTestResult.getMethod().getQualifiedName() + " test method");
        LOGGER.info("----------------------------------------------------------------------");
    }


    @Attachment(value = "Failure in method {0}", type = "image/png")
    private byte[] takeScreenShot(String methodName) {
        LOGGER.info("Taking screenshot on failure");
        return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext context) {
        LOGGER.info("Staring to run test suite with " + context.getAllTestMethods().length + " tests");
    }
}