package base;

import com.sun.deploy.config.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Time;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    /*
     *WebDriver
     * Properties
     * Logs
     * ExtentsReports
     * DB
     * Excel
     * Mail
     */

    public static WebDriver driver; //
    public static Properties config = new Properties();//
    public static Properties OR = new Properties();//
    public static FileInputStream fis;//

    @BeforeSuite
    public void setUp() throws InterruptedException {

        if (driver == null) {

            try {
                fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            try {
                config.load(fis);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                OR.load(fis);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (config.getProperty("browser").equals("firefox")) {
                // System.setProperty("webdriver.gecko.driver", "gecko.exe");
                driver = new FirefoxDriver();
            } else if (config.getProperty("browser").equals("chrome")) {
                System.setProperty("webdriver.chrome.driver",
                        System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
                driver = new ChromeDriver();

            } else if (config.getProperty("browser").equals("ie")) {
                System.setProperty("webdriver.ie.driver",
                        System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\IEDriverServer.exe");
                driver = new InternetExplorerDriver();
            }


            driver.get(config.getProperty("testsiteurl"));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
                    TimeUnit.SECONDS);

        }
    }


    @AfterSuite
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }

    }
}
