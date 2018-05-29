
import Tests.TestIUA;
import Tests.TestMailinator;

import java.io.File;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        File file = new File(".\\WebDriver\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        String sender = "Alexey Sizonov";
        String destination = "qwerty1213@mailinator.com";
        String subject = "SomeSubject";
        String text = "SomeText";

        TestIUA testIUA = new TestIUA();

        testIUA.setUp();
        testIUA.InvalidLogin();
        testIUA.tearDown();

        testIUA.setUp();
        testIUA.ValidLogin();
        testIUA.tearDown();

        testIUA.Sending(destination, subject, text);

        TestMailinator testMailinator = new TestMailinator(destination, sender, subject, text);

        testMailinator.setUp();
        testMailinator.CorrectInfo();
        testMailinator.tearDown();
    }
}
