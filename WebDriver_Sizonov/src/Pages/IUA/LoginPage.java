package Pages.IUA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    By userName = By.name("login");
    By userPass = By.name("pass");
    By login = By.xpath("//input[@value='Войти']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUserName(String Name) {
        driver.findElement(userName).sendKeys(Name);
    }


    public void setUserPass(String Pass) {
        driver.findElement(userPass).sendKeys(Pass);
    }

    public void clickLogin() {
        driver.findElement(login).click();
    }

    public  void LoginAs(String Name, String Pass){
        setUserName(Name);
        setUserPass(Pass);
        clickLogin();
    }
}
