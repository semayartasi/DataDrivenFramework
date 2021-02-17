package listeners;

import base.TestBase;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import utilities.TestUtil;

import java.io.IOException;

public class CustomListeners extends TestBase implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult arg0) {
        test.log(LogStatus.PASS,arg0.getName().toUpperCase()+"PASS");
        rep.endTest(test);
        rep.flush();

    }

    @Override
    public void onTestFailure(ITestResult arg0) {
        System.setProperty("org.uncommons.reportng.escape-output","false"); //added reportNG page a screenshot link
        try {
            TestUtil.captureScreenShot();
        } catch (IOException e) {
            e.printStackTrace();
        }
        test.log(LogStatus.FAIL,arg0.getName().toUpperCase()+"Failed with exception:"+arg0.getThrowable());
        test.log(LogStatus.FAIL,test.addScreenCapture(TestUtil.screenshotName));


        Reporter.log("Click to see screenhot");
        Reporter.log("<a target=\"_blank\" href=" +TestUtil.screenshotName+ ">Screenshot</a>");
        Reporter.log("<br>");
        Reporter.log("<br>");
        Reporter.log("<a target=\"_blank\" href=" +TestUtil.screenshotName+"> <img src="+TestUtil.screenshotName+" height=200 width=200></img></a>");
        rep.endTest(test);
        rep.flush();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext arg0) {
        test=rep.startTest(arg0.getName().toUpperCase());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
