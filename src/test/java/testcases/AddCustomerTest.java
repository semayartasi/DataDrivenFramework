package testcases;

import base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sun.awt.windows.ThemeReader;
import utilities.TestUtil;
import java.util.Hashtable;

public class AddCustomerTest extends TestBase {

    @Test (dataProviderClass = TestUtil.class, dataProvider = "dp")
    public void addCustomerTest(Hashtable<String,String>data) throws InterruptedException {

            if(!data.get("runmode").equals("Y")){
                throw  new SkipException(("Skipping the test case as the Run mode for the data set is NO"));
            }


        click("addCustBtn_CSS");
        type("firstName_CSS", data.get("firstName"));
        type("lastName_XPATH", data.get("lastName"));
        type("postCode_CSS", data.get("postCode"));
        click("addBtn_CSS");

        Thread.sleep(2000);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertTrue(alert.getText().contains(data.get("alertText")));
        alert.accept();
        Thread.sleep(2000);
     //  Assert.fail("Login is not successfully"); //for just test
    }
}


