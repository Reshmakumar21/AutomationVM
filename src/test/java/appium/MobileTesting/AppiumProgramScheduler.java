package appium.MobileTesting;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AppiumProgramScheduler {

    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        // Schedule the Appium program to run every 15 minutes
        scheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                	System.out.println("Executing Appium test every 15 minutes");
					Logintest.appiumtest1();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        }, 0, 2, TimeUnit.MINUTES); // Initial delay 0, repeat every 15 minutes
    }
}
