package testcases;

import base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.TestUtil;

import java.lang.reflect.Method;
import java.util.Hashtable;

public class OpenAccountTest extends TestBase {
    @Test (dataProviderClass = TestUtil.class, dataProvider = "dp")
    public void openAccountTest(String customer, String currency) throws InterruptedException {

    }


}
