package appium.MobileTesting;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;


public class MobileActions {

		public static WebElement getWhenVisible(By locator, AndroidDriver driver) {
		int timeout = 120;
		WebElement element;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		element = wait.until(ExpectedConditions
				.elementToBeClickable(locator));
		return element;
	}
	  
	 public static String createScreenshotsFolder(String parentFolderPath) {
		 String screenshotsFolderPath = "";
		 try {
			String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
			String folderName = "LoginTest_" + timestamp;
			screenshotsFolderPath = parentFolderPath + File.separator + folderName;

			File folder = new File(screenshotsFolderPath);
			if (!folder.exists()) {
			    folder.mkdirs();
			}
			//System.out.println("Folder created");
			
		 }
		 catch(Exception e) {
			 System.err.println("Failed to create folder: " + e.getMessage());
		 }
		 return screenshotsFolderPath;
	    }
	
	  public static void takeScreenshot(AppiumDriver driver, String path) throws IOException {
	        try {
	        	// Generate a unique file name with timestamp
		        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		        String screenshotFileName = "screenshot_" + timestamp + ".png";
		        String screenshotFilePath = path + File.separator + screenshotFileName;

		        // Take screenshot and save it as a file
		        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		        // Copy the file to the desired location
		        Files.copy(screenshot.toPath(), new File(screenshotFilePath).toPath());
		        //System.out.println("Screenshot taken");
	        }catch(IOException e){
	        	System.err.println("Failed to take screenshot: " + e.getMessage());
	        }
	    }		
	public static void testResult(AppiumDriver driver) {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Replace this path with your image file's path

        //String imagePath = "C://Users//0047HE744//Desktop//Personal//MyLearning//AppiumTesting//MobileTesting//test-result.png";
		String imagePath = System.getProperty("user.dir") + "/test-result.png";




        try {
            // Save the screenshot to the desired location (overwrite the existing file)
            ImageIO.write(ImageIO.read(screenshot), "png", new File(imagePath));
            System.out.println("Screenshot updated successfully at: " + imagePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

	}
	
	public static void login(AndroidDriver driver) throws IOException, InterruptedException {

		//String path = createScreenshotsFolder("C://Users//0047HE744//Desktop//Personal//MyLearning//AppiumTesting//MobileTesting//Results");
		String path = createScreenshotsFolder(System.getProperty("user.dir") + "/Results");
		//MobileUI.btn_newcon(driver).isDisplayed();
		//takeScreenshot(driver,path);
		MobileUI.btn_popupclose(driver).click();

		MobileUI.btn_newcon(driver).isDisplayed();

		MobileUI.btn_newconnection(driver).click();
		//testResult(driver);
		//takeScreenshot(driver,path);
		MobileUI.btn_login(driver).click();
		MobileUI.btn_login(driver).click();
		takeScreenshot(driver,path);		
		Thread.sleep(4000);
		MobileUI.btn_username(driver).sendKeys("9445332945");
		MobileUI.btn_password(driver).sendKeys("Venki00*");
		takeScreenshot(driver,path);
		MobileUI.btn_submit(driver).click();
		testResult(driver);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//takeScreenshot(driver,path);
		MobileUI.btn_locateus(driver).click();
		//takeScreenshot(driver,path);
		System.out.println("test completed");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//testResult(driver);
		//WhatsAppWeb.whatsappAutomation();

	}
	

}
