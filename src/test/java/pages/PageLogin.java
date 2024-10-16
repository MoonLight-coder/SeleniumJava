package pages;

import helpers.Helpers;
import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PageLogin {
    private WebDriver driver;
    private By userField;
    private By passwordField;
    private By loginButton;
    private By fields;

    public PageLogin(WebDriver driver) {
        this.driver = driver;
        userField = By.name("username");
        passwordField = By.name("password");
        loginButton = By.id("submit");
        fields = By.tagName("input");
    }
//    public void login(String user, String pass){
//        driver.findElement(userField).sendKeys(user);
//        driver.findElement(passwordField).sendKeys(pass);
//        driver.findElement(loginButton).click();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
////        Helpers helper = new Helpers();
////        helper.sleepSeconds(5);
//    }

    public void login(String user, String pass){
        List<WebElement> loginFields = driver.findElements(fields);
        loginFields.get(0).sendKeys(user);
        loginFields.get(1).sendKeys(pass);
        driver.findElement(loginButton).click();
        File myScreenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(myScreenshot, new File("LOGIN "+System.currentTimeMillis()+".png"));
        } catch (IOException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void verifyFields() {
        List<WebElement> loginFields = driver.findElements(fields);
        System.out.println(loginFields.size());
        Assert.assertTrue(loginFields.size()==2);
    }
}
