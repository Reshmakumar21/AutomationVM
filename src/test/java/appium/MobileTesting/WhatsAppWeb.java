package appium.MobileTesting;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WhatsAppWeb {

	@Test
    public static void whatsappAutomation() throws InterruptedException {
        // Set ChromeDriver path
        System.setProperty("webdriver.chrome.driver", 
        "C://Users//0047HE744//Desktop//Personal//MyLearning//AppiumTesting//MobileTesting//src//resources//chromedriver.exe");

        // Set user data directory
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C://Users//0047HE744//Desktop//Personal//MyLearning//AppiumTesting//MobileTesting//src//whatsappbot");

        // Launch Chrome browser with the configured options
        WebDriver driver = new ChromeDriver(options);

        // Open WhatsApp Web
        driver.get("https://web.whatsapp.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        //send me a msg
        driver.findElement(By.xpath("//*[@id=\"pane-side\"]/div[1]/div/div/div[1]/div/div/div/div[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span[2]/div/div[2]/div[1]/div[2]/div[1]/p")).sendKeys(Keys.CONTROL+"v"+Keys.ENTER);
        driver.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span[2]/div/div[1]/div/div/div/div")).click();
        Thread.sleep(1000);
     // Wait for file input element to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement fileInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='main']/footer/div[1]/div/span[2]/div/div[1]/div/div/span/div/ul/div/div[1]/li/div")));

        // Send file path to the file input element
        fileInput.sendKeys("C://Users//0047HE744//Desktop//Personal//MyLearning//AppiumTesting//MobileTesting//test-result.png");

//        driver.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span[2]/div/div[1]/div/div/span/div/ul/div/div[1]/li/div")).sendKeys("C://Users//0047HE744//Desktop//Personal//MyLearning//AppiumTesting//MobileTesting//test-result.png");
        Thread.sleep(20000);
        driver.quit();
	}
}
