package testcases;

import base.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    @Test
    public void loginAsBankManager() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.cssSelector(OR.getProperty("bmlbtn"))).click();
        Thread.sleep(3000);
    }
}
