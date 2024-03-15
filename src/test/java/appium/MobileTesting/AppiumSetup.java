package appium.MobileTesting;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class AppiumSetup {
	
   public static void launchEmulator() {
	  	  try {
	  			@SuppressWarnings("unused")
	  			Process p=Runtime.getRuntime().exec("emulator -avd emulatortest2 -gpu host");
	  			System.out.println("Emulator launched");
	  				Thread.sleep(5000);
	  		} catch (Exception e) {
	  			// TODO Auto-generated catch block
	  			e.printStackTrace();
	  		}
	    }

    public static void waitForEmulator() {
        try {
        Process process = Runtime.getRuntime().exec("adb devices");
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        boolean deviceFound = false;

        while ((line = reader.readLine()) != null) {
            if (line.contains("device")) {
                deviceFound = true;
                break;
            }
        }

        if (deviceFound) {
            System.out.println("Device found, waiting for boot completion...");

            while (true) {
                Process bootProcess = Runtime.getRuntime().exec("adb shell getprop sys.boot_completed");
                BufferedReader bootReader = new BufferedReader(new InputStreamReader(bootProcess.getInputStream()));
                String bootStatus = bootReader.readLine();

                if (bootStatus != null && bootStatus.equals("1")) {
                    System.out.println("Emulator is ready.");
                    break;
                }

                Thread.sleep(2000); // Check every 2 seconds
            }
        } else {
            System.out.println("Device not found or offline.");
        }
    } catch (IOException | InterruptedException e) {
        e.printStackTrace();
    }
   }
    
 	public static void startServer() throws IOException, InterruptedException {
  		Runtime runtime = Runtime.getRuntime();
        runtime.exec("cmd.exe /c start cmd.exe /k appium");
        Thread.sleep(20000);
  	}
  	
  	
  	public static boolean isServerListening() {
        try (Socket socket = new Socket("127.0.0.1", 4723)) {
        	System.out.println("Appium server is listening.");
        	return true;
        } catch (IOException e) {
            System.out.println("Appium server is not listening or reachable.");
            return false;
        }
    }
  	
    
    public static AndroidDriver initiateDriver() throws MalformedURLException {
    
  	  UiAutomator2Options options = new UiAutomator2Options();
  	  options.setDeviceName("emulatortest2");
  	  options.setCapability("autoGrantPermissions", "true");
  	  options.setApp(System.getProperty("user.dir") + "/consumer-app.apk");

  	  AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);

  	  return driver;
    }
    
    public static void server() throws IOException, InterruptedException {
  	  if(AppiumSetup.isServerListening()==false) {
  		  AppiumSetup.startServer();}
  		  
  		  while(AppiumSetup.isServerListening()==false) {
  			  Thread.sleep(10000);
  		  }
    }   
}
