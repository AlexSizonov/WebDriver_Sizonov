package Tests;

import Pages.IUA.LoginPage;
import Pages.IUA.SendMail;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestIUA {

    String urlIUA;
    WebDriver driver;

    @Before
    public void setUp() {
        urlIUA = "http://i.ua/";
        driver = new ChromeDriver();
        driver.get(urlIUA + "/");
    }

    @Test
    public void ValidLogin() throws InterruptedException {
        String name = "sizonovalexey";
        String pass = "2796alex";

        LoginPage loginPage = new LoginPage(driver);
        loginPage.LoginAs(name, pass);

        Assert.assertEquals("Создать письмо", driver.findElement(By.cssSelector("p.make_message > a")).getText());
        Thread.sleep(3000);
    }

    @Test
    public void InvalidLogin() throws InterruptedException {
        String name = "14n1j345";
        String pass = "hdfghdgj";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.LoginAs(name, pass);

        Assert.assertEquals("Неверный логин или пароль", driver.findElement(By.cssSelector("div.content.clear")).getText());
        Thread.sleep(3000);
    }

    @Test
    public void Sending(String address, String sbj, String text) throws InterruptedException {
        setUp();
        ValidLogin();
        SendMail sendMail = new SendMail(driver);
        sendMail.Sending(address, sbj, text);
        tearDown();
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}
