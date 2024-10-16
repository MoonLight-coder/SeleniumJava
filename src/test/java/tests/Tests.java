package tests;
import helpers.WebDriverManager;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.PageLogin;
import pages.PageLogon;
import pages.PageinLogin;

public class Tests extends CondicionesComunes{

    @Test(description = "Login Incorrecto")
    public void pruebaUno() {
        WebDriverManager.setWindowSize(driver,"maximized");
        PageLogin pageLogin = new PageLogin(driver);
        PageLogon pageLogon = new PageLogon(driver);
        pageLogin.login("user", "user");
        pageLogon.assertLogonPage();
    }

    @Test(description = "login correcto")
    public void pruebaDos() {
        WebDriverManager.setWindowSize(driver,"fullscreen");
//        driver.switchTo().window(tabs.get(1)).navigate().to("http://youtube.com/user/Draculinio");
//        driver.switchTo().window(tabs.get(0));
        PageLogin pageLogin = new PageLogin(driver);
        PageinLogin pageinLogin = new PageinLogin(driver);
        pageLogin.login("student", "Password123");
        pageinLogin.assertInLoginPage();
    }

//    @Test
//    public void pruebaCantidadDeCampos() {
//        PageLogin pageLogin = new PageLogin(driver);
//        pageLogin.verifyFields();
//    }
    @Test
    public void pruebaTituloEnUsuario(){
        PageLogin pageLogin = new PageLogin(driver);
        pageLogin.putTitleInUserField();
    }

}