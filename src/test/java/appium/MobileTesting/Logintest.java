package appium.MobileTesting;

import java.io.IOException;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class Logintest{
    
  @Test
  public static void testAppium1() throws IOException, InterruptedException {
	  
	  //launching emulator and waiting for boot completion
<<<<<<< HEAD
	  //AppiumSetup.launchEmulator();
	  //AppiumSetup.waitForEmulator();
	  //AppiumSetup.setEmulatorTimezone();
	  
	  //starting the appium server and verifying if it is listening in the required IP and port
	  //AppiumSetup.server();
=======
	  AppiumSetup.launchEmulator();
	  AppiumSetup.waitForEmulator();
	  //AppiumSetup.setEmulatorTimezone();
	  
	  //starting the appium server and verifying if it is listening in the required IP and port
	  AppiumSetup.server();
>>>>>>> 58e2820faf85d89dce13357acac1d3cb005f3f46
	  
	  //initiating Android driver instance
	  AndroidDriver driver = AppiumSetup.initiateDriver();
	  System.out.println("Driver initiated");
	  
	  //login
	  MobileActions.login(driver);
  }
<<<<<<< HEAD
=======
  
  @Test
  public void testAppium2() {
	  
  }
>>>>>>> 58e2820faf85d89dce13357acac1d3cb005f3f46
}

