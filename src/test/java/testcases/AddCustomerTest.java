package testcases;

import base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.Hashtable;

public class AddCustomerTest extends TestBase {
    @Test(dataProvider = "getData")
    public void addCustomer(String firstName, String lastName, String postCode,String alertText) throws InterruptedException {
        driver.findElement(By.cssSelector(OR.getProperty("addCustBtn"))).click();
        driver.findElement(By.cssSelector(OR.getProperty("firstName"))).sendKeys(firstName);
        driver.findElement(By.cssSelector(OR.getProperty("lastName"))).sendKeys(lastName);
        driver.findElement(By.cssSelector(OR.getProperty("postCode"))).sendKeys(postCode);
        driver.findElement(By.cssSelector(OR.getProperty("addBtn"))).click();
       Alert alert= wait.until(ExpectedConditions.alertIsPresent());
       Assert.assertTrue(alert.getText().contains(alertText));
       alert.accept();
        Assert.fail("Login is not succesfully"); //for just test
    }

    @DataProvider
    public Object[][] getData(Method m){
        String sheetName = "AddCustomerTest";
        int rows = excel.getRowCount(sheetName);
        int cols = excel.getColumnCount(sheetName);

        Object[][] data = new Object[rows - 1][cols];

        Hashtable<String,String> table = null;

        for (int rowNum = 2; rowNum <= rows; rowNum++) { // 2
          //  table = new Hashtable<String,String>();
            for (int colNum = 0; colNum < cols; colNum++) {
                // data[0][0]
                data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum,rowNum);
            }
        }
        return data;
    }
}
