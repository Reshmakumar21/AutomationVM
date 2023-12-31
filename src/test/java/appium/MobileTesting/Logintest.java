package appium.MobileTesting;

import java.io.IOException;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class Logintest{
    
  @Test
  public static void appiumtest1() throws IOException, InterruptedException {
	  
	  //launching emulator and waiting for boot completion
	  //AppiumSetup.launchEmulator();
	  //AppiumSetup.waitForEmulator();
	  
	  //starting the appium server and verifying if it is listening in the required IP and port
	  //AppiumSetup.server();
	  
	  //initiating Android driver instance
	  AndroidDriver driver = AppiumSetup.initiateDriver();
	  System.out.println("Driver initiated");
	  
	  //login
	  MobileActions.login(driver);
  }
}

