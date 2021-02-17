package testcases;

import base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.TestUtil;

import java.lang.reflect.Method;
import java.util.Hashtable;

public class AddCustomerTest extends TestBase {

    @Test (dataProviderClass = TestUtil.class, dataProvider = "dp")
    public void addCustomerTest(String firstName, String lastName, String postCode, String alertText) throws InterruptedException {

        click("addCustBtn_CSS");
        type("firstName_CSS", firstName);
        type("lastName_XPATH", lastName);
        type("postCode_CSS", postCode);
        click("addBtn_CSS");

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertTrue(alert.getText().contains(alertText));
        alert.accept();
        Assert.fail("Login is not successfully"); //for just test
    }
}


