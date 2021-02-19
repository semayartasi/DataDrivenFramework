package testcases;

import base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.io.IOException;

public class BankManagerLoginTest extends TestBase {
    @Test
    public void bankManagerLoginTest() throws InterruptedException, IOException {

     //  verifyEquals("abc","xyz");
        Thread.sleep(3000);
        log.debug("Inside Login Test");
        click("bmlBtn_CSS");
        Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("addCustBtn_CSS"))),"Login not successfully");
        log.debug("Login successfully executed");

       //Assert.fail("Login is not succesfully"); //for just test

    }
}
