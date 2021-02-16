package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import utilities.TestUtil;

import java.io.IOException;

public class CustomListeners implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.setProperty("org.uncommons.reportng.escape-output","false"); //added reportNG page a screenshot link
        try {
            TestUtil.captureScreenShot();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Reporter.log("<a target=\"_blank\" href=" +TestUtil.screenshotName+ ">Screenshot</a>");
        Reporter.log("<br>");
        Reporter.log("<br>");
        Reporter.log("<a target=\"_blank\" href=" +TestUtil.screenshotName+"> <img src="+TestUtil.screenshotName+" height=200 width=200></img></a>");

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
