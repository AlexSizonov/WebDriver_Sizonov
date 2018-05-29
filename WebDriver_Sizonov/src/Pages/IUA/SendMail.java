package Pages.IUA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SendMail {
    WebDriver driver;
    By destination = By.id("to");
    By subject = By.name("subject");
    By body = By.id("text");
    By submit = By.name("send");

    public  SendMail(WebDriver driver){
        this.driver = driver;
    }
    public  void setDestination(String address){
        driver.findElement(destination).sendKeys(address);
    }
    public void setSubject(String sbj){
        driver.findElement(subject).sendKeys(sbj);
    }
    public void setBody(String text){
        driver.findElement(body).sendKeys(text);
    }
    public  void clickSubmit(){
        driver.findElement(submit).click();
    }
    public void Sending(String address, String sbj, String text)throws InterruptedException{

        new HomePage(driver).clickCreateMail();
        Thread.sleep(2000);
        setDestination(address);
        setSubject(sbj);
        setBody(text);
        clickSubmit();
    }
}
