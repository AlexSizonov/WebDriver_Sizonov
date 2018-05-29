package Tests;

import Pages.Mailinator.MHomePage;
import Pages.Mailinator.MLoginPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TestMailinator {
    String urlMailinator;
    WebDriver driver;
    String destination;
    String sender;
    String subject;
    String text;

    public TestMailinator(String destination, String sender, String subject, String text) {
        this.destination = destination;
        this.sender = sender;
        this.subject = subject;
        this.text = text;
    }

    @Before
    public void setUp() {
        urlMailinator = "http://mailinator.com/";
        driver = new ChromeDriver();
        driver.get(urlMailinator + "/");
    }

    @Test
    public void CorrectInfo() throws InterruptedException {
        new MLoginPage(driver).ToInbox(destination);

        Assert.assertEquals(sender, driver.findElement(By.xpath("//li/div/div[3]")).getText());
        Assert.assertEquals(subject, driver.findElement(By.xpath("//li/div/div[4]")).getText());

        new MHomePage(driver).clickOnSubj();

        List<WebElement> list = driver.findElements(By.id("msg_body"));
        for (WebElement element : list) {
            if (element.getText().contains(text)) {
                System.out.println("Successful.");
            }else System.out.println("Fail!!!!!");
        }

        //Assert.assertEquals(text, driver.findElement(By.xpath("//html/body/div")).getText());

        Thread.sleep(3000);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
