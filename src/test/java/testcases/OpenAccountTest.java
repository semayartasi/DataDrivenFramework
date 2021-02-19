package testcases;

import base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.TestUtil;

import java.lang.reflect.Method;
import java.util.Hashtable;

public class OpenAccountTest extends TestBase {
    @Test (dataProviderClass = TestUtil.class, dataProvider = "dp")
    public void openAccountTest(String customer, String currency) throws InterruptedException {

        if(!TestUtil.isTestRunnable("openAccountTest",excel)){
            throw  new SkipException("Skipping the test"+"openAccountTest".toUpperCase()+ "as the Run mode is NO");
        }
        click("openaccount_CSS");
        select("customer_CSS",customer);
        select("currency_CSS",currency);
        click("process_CSS");
        Thread.sleep(3000);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();

    }


}
