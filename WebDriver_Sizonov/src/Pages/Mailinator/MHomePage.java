package Pages.Mailinator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MHomePage {
    WebDriver driver;
    By findSubj = By.xpath("//li/div/div[4]");

    public  MHomePage(WebDriver driver){
        this.driver = driver;
    }

    public void clickOnSubj(){
        driver.findElement(findSubj).click();
    }
}
