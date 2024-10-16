package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PageLogon {
    private WebDriver driver;
    private By titleText;
    public PageLogon(WebDriver driver){
        this.driver = driver;
        titleText = By.xpath("//*[@id=\"error\"]");
    }

    public void assertLogonPage(){
        Assert.assertTrue(driver.findElement(titleText).getText().contains("Your username is invalid!"));
    }

}
