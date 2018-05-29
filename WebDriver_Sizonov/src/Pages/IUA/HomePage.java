package Pages.IUA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;


    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    public void clickCreateMail(){
        driver.findElement(By.cssSelector("p.make_message > a")).click();
    }
}
