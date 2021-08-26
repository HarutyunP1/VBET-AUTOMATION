package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * @author amalyahayrapetova
 */

public class Retry implements IRetryAnalyzer {
    private static int retryCount = 0;
    private int maxRetry = 1;
    public static int executeCount = 0;

    /**
     * Retry failed test twice
     *
     * @param iTestResult
     * @return
     */
    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {//Check if test not succeed
            executeCount++;
            if (retryCount < maxRetry) {                            //Check if maxtry count is reached
                retryCount++;                               //Increase the maxTry count by 1
                iTestResult.setStatus(ITestResult.FAILURE);  //Mark test as failed
                return true;                                 //Tells TestNG to re-run the test
            } else {
                iTestResult.setStatus(ITestResult.FAILURE);  //If maxCount reached,test marked as failed
            }
        } else {
            iTestResult.setStatus(ITestResult.SUCCESS);      //If test passes, TestNG marks it as passed
        }
        return false;

    }


}
