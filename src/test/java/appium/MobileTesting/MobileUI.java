package appium.MobileTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class MobileUI {
	
	public static WebElement btn_menu(AndroidDriver driver) {

		System.out.println("Clicking on menu");
		return MobileActions.getWhenVisible(By.xpath("//android.widget.ImageButton"),driver);
	}
	
	public static WebElement btn_login(AndroidDriver driver) {

		System.out.println("Clicking on sign in");
		return MobileActions.getWhenVisible(By.xpath("//android.widget.LinearLayout"
				+ "[@resource-id='cx.indianoil.in:id/new_card_user']/android.widget.LinearLayout/android.widget.ImageView"),driver);
	}

	public static WebElement btn_username(AndroidDriver driver) {

		System.out.println("entering user name");
		return MobileActions.getWhenVisible(By.xpath("//android.widget.EditText[@resource-id='cx.indianoil.in:id/email']"),driver);
	}

	public static WebElement btn_password(AndroidDriver driver) {

		System.out.println("Entering password");
		return MobileActions.getWhenVisible(By.id("cx.indianoil.in:id/password"),driver);
	}

	public static WebElement btn_submit(AndroidDriver driver) {

		System.out.println("Clicking on login button");
		return MobileActions.getWhenVisible(By.id("cx.indianoil.in:id/login_now"),driver);
	}
	
	public static WebElement btn_locateus(AndroidDriver driver) {
	
		System.out.println("Clicking on locate me");
		return MobileActions.getWhenVisible(By.xpath("//android.widget.LinearLayout"
				+ "[@resource-id='cx.indianoil.in:id/locateus_layout']/android.widget.ImageView"),driver);
	}
}
