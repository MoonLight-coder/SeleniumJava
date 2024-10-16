package tests;

import helpers.Screenshooter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;

public class CondicionesComunes {
    protected WebDriver driver;
    ArrayList<String> tabs;
    @BeforeMethod
    public void setUp() {
        DesiredCapabilities caps = new DesiredCapabilities();
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--headless");
//        driver = new ChromeDriver(chromeOptions);
        driver = new ChromeDriver();
        driver.navigate().to("https://practicetestautomation.com/practice-test-login/");
//        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
//        String googleWindow = "window.open('https://www.google.com')";
//        javascriptExecutor.executeScript(googleWindow);
//        tabs = new ArrayList<String> (driver.getWindowHandles());
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if(!result.isSuccess()){
            Screenshooter.takeScreenshot("Error", driver);
        }
//        driver.switchTo().window(tabs.get(1)).close();
//        driver.switchTo().window(tabs.get(0)).close();
        driver.close();
        driver.quit();
    }

}
