package appium.MobileTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class MobileUI {

	public static WebElement btn_popupclose(AndroidDriver driver) {

		System.out.println("About to click on close");
		return MobileActions.getWhenVisible(By.id("cx.indianoil.in:id/button_close"), driver);
	}

	public static WebElement btn_newcon(AndroidDriver driver) {

		return MobileActions.getWhenVisible(
				By.xpath("//android.widget.TextView[@resource-id='cx.indianoil.in:id/text_card_cylinder']"), driver);
	}

	public static WebElement btn_newconnection(AndroidDriver driver) {

		System.out.println("Clicking on Order Cylinder");
		return MobileActions.getWhenVisible(By.id("cx.indianoil.in:id/text_card_cylinder"), driver);
	}

	public static WebElement btn_login(AndroidDriver driver) {

		System.out.println("Clicking on login button");
		return MobileActions.getWhenVisible(By.id("cx.indianoil.in:id/tv_bottom_dialog_login"), driver);
	}

	public static WebElement btn_username(AndroidDriver driver) {

		System.out.println("Entering user name");
		return MobileActions
				.getWhenVisible(By.xpath("//android.widget.EditText[@resource-id='cx.indianoil.in:id/email']"), driver);
	}

	public static WebElement btn_password(AndroidDriver driver) {

		System.out.println("Entering password");
		return MobileActions.getWhenVisible(By.id("cx.indianoil.in:id/password"), driver);
	}

	public static WebElement btn_submit(AndroidDriver driver) {

		System.out.println("Clicking on login button");
		return MobileActions.getWhenVisible(By.id("cx.indianoil.in:id/login_now"), driver);
	}

	public static WebElement btn_locateus(AndroidDriver driver) {

		System.out.println("Clicking on locate me");
		return MobileActions.getWhenVisible(By.xpath("//android.widget.TextView[@text=\"Locate Us\"]"), driver);
	}

	public static WebElement btn_enterLocation(AndroidDriver driver) {

		System.out.println("enter location info");
		return MobileActions.getWhenVisible(By.id("cx.indianoil.in:id/places_autocomplete_search_input"), driver);
	}

	public static WebElement btn_searchLocation(AndroidDriver driver) {

		System.out.println("search location");
		return MobileActions.getWhenVisible(By.xpath("(//android.widget.TextView[@resource-id=\"cx.indianoil.in:id/places_autocomplete_prediction_primary_text\"])[1]"), driver);
	}

}
