package appium.MobileTesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class test {

    @Test
    public static void whatsappAutomation() throws InterruptedException {


         //Set user data directory
        ChromeOptions options = new ChromeOptions();
        
        String userDataDir = System.getProperty("user.dir") + "/src/whatsappbot";
        options.addArguments("user-data-dir=" + userDataDir);

        // Launch Chrome browser with the configured options
        WebDriver driver = new ChromeDriver(options);

        // Open WhatsApp Web
        driver.get("https://web.whatsapp.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        //send me a msg
        driver.findElement(By.xpath("//*[@id=\"pane-side\"]/div[1]/div/div/div[1]/div/div/div/div[2]")).click();
        clipboardtest.clipboard();
        driver.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span[2]/div/div[2]/div[1]/div[2]/div[1]/p")).sendKeys(Keys.CONTROL+"v");
        System.out.println("Screenshot pasted to wa");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@title='Type a message']")).sendKeys("Test Completed"+Keys.ENTER);
        System.out.println("comment entered in wa and sent");
        Thread.sleep(20000);
        System.out.println("wa closed");
        driver.quit();

    }
}
