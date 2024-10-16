package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PageinLogin {
    private WebDriver driver;
    private By titleText;
    public PageinLogin(WebDriver driver){
        this.driver = driver;
        titleText = By.xpath("//*[@id=\"loop-container\"]/div/article/div[1]/h1");
    }

    public void assertInLoginPage(){
        Assert.assertTrue(driver.findElement(titleText).getText().contains("Logged In Successfully"));
    }

}
