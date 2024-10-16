package tests;
import java.io.File;
import helpers.Helpers;
import helpers.Screenshooter;
import helpers.WebDriverManager;
import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v129.page.model.Screenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.PageLogin;
import pages.PageLogon;
import pages.PageinLogin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Tests {
    private WebDriver driver;
    ArrayList<String> tabs;
    @BeforeMethod
    public void setUp() {
        DesiredCapabilities caps = new DesiredCapabilities();
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
//        driver.manage().window().setSize(new Dimension(800,600));
//        driver.manage().window().setPosition(new Point(800,300));
        driver.navigate().to("https://practicetestautomation.com/practice-test-login/");
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        String googleWindow = "window.open('https://www.google.com')";
        javascriptExecutor.executeScript(googleWindow);
        tabs = new ArrayList<String> (driver.getWindowHandles());
    }

    @Test
    public void pruebaUno() {
        WebDriverManager.setWindowSize(driver,"maximized");
        driver.switchTo().window(tabs.get(1)).navigate().to("http://youtube.com/user/Draculinio");
        driver.switchTo().window(tabs.get(0));
        PageLogin pageLogin = new PageLogin(driver);
        PageLogon pageLogon = new PageLogon(driver);
        pageLogin.login("user", "user");
        pageLogon.assertLogonPage();
    }

    @Test
    public void pruebaDos() {
        WebDriverManager.setWindowSize(driver,"fullscreen");
        PageLogin pageLogin = new PageLogin(driver);
        PageinLogin pageinLogin = new PageinLogin(driver);
        pageLogin.login("student", "Password123");
        pageinLogin.assertInLoginPage();
    }

    @Test
    public void pruebaCantidadDeCampos() {
        WebDriverManager.setWindowSize(driver,400,400);
        PageLogin pageLogin = new PageLogin(driver);
        pageLogin.verifyFields();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if(!result.isSuccess()){
            Screenshooter.takeScreenshot("Error", driver);
        }
        driver.switchTo().window(tabs.get(1)).close();
        driver.switchTo().window(tabs.get(0)).close();
    }


}