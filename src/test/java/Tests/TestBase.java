package Tests;

import Config.ConfigurationFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    ConfigurationFile configurationFile;
    // this method will run before each suite
    @BeforeSuite
    // the browser name will be taken from the TestNG file and if it is not exist the chrome browser will be the optional one.
    @Parameters({"browser"})
    public void StartDriver (@Optional("chrome") String browserName) throws IOException
    {
        configurationFile = new ConfigurationFile();
        // ignorecase -- ignore case from name B or b
        if (browserName.equalsIgnoreCase("chrome"))
        {
            System.setProperty("webdriver.chrome.driver",configurationFile.ChromeDriverPath);
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.get(configurationFile.WebsiteURL);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);
    }

    // this method will run after each suite
    @AfterSuite(enabled = true)
    public void StopDriver()
    {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.quit();
    }

}