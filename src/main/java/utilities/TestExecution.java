package utilities;

import apicalls.JiraApiCalls;
import io.qameta.allure.TmsLink;
import listeners.Retry;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.lang.reflect.Method;

public class TestExecution {
    private boolean createCycle = System.getProperty("create.cycle").equals("true");

    /**
     * @param iTestContext
     * @throws IOException
     * @throws InterruptedException
     */
    @BeforeSuite(alwaysRun = true)
    protected void setUpRegression(ITestContext iTestContext) throws IOException, InterruptedException {
        if (createCycle)
            JiraApiCalls.createTestCycle(iTestContext);

    }


    /**
     * Execute Tests in Jira
     *
     * @param method
     * @param testResult
     * @throws IOException
     * @throws InterruptedException
     */

    public void setExecution(Method method, ITestResult testResult) throws IOException, InterruptedException {
        TmsLink tmsLink = method.getAnnotation(TmsLink.class);
        if (createCycle && tmsLink != null) {
            if (testResult.isSuccess() && Retry.executeCount == 0) {
                System.out.println("set execution");
                JiraApiCalls.executeTest(tmsLink.value(), setStatus(testResult));
            } else if (testResult.isSuccess() && Retry.executeCount == 1) {
                JiraApiCalls.executeTest(tmsLink.value(), setStatus(testResult));
                System.out.println("set execution");

            } else if (!testResult.isSuccess() && Retry.executeCount == 2) {
                System.out.println("set execution");
                JiraApiCalls.executeTest(tmsLink.value(), setStatus(testResult));

            }

        }
    }


    /**
     * Set status of test execution.
     *
     * @param testResult
     * @return
     */
    private static String setStatus(ITestResult testResult) {
        switch (testResult.getStatus()) {
            case 1:
                return "Pass";
            case 2:
                return "Fail";
            case 3:
                return "In Progress";
            default:
                return "Not Executed";
        }
    }


}
