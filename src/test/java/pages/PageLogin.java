package pages;

import helpers.Helpers;
import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PageLogin {
    private WebDriver driver;
    @FindBy(name="username")
    private WebElement userFieldElement;
    @FindBy(name="password")
    private WebElement passwordFieldElement;
    @FindBy(id="submit")
    private WebElement loginButtonElement;
    @FindBy(name= "input")
    private List<WebElement> fields;

    public PageLogin(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String user, String pass){
        userFieldElement.sendKeys(user);
        passwordFieldElement.sendKeys(pass);
        loginButtonElement.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void fields_login(String user, String pass){
        fields.get(1).sendKeys(user);
        fields.get(2).sendKeys(pass);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void verifyFields() {
        Assert.assertTrue(fields.size()==2);
    }
    public void putTitleInUserField(){
        userFieldElement.sendKeys(driver.getTitle());
    }
}
