package Pages.Mailinator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MLoginPage {
    WebDriver driver;
    By inbox = By.id("inboxfield");
    By submit = By.cssSelector("button.btn.btn-dark");

    public  MLoginPage(WebDriver driver){
        this.driver = driver;
    }
    public void setInbox(String address){
        driver.findElement(inbox).sendKeys(address);
    }
    public  void clickSubmit(){
        driver.findElement(submit).click();
    }
    public void ToInbox(String address){
        setInbox(address);
        clickSubmit();
    }
}
