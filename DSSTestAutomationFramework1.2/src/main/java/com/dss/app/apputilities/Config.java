package com.dss.app.apputilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.dss.app.coreutilities.Log;

public class Config {

	private WebDriver driver;

	//This method will select the browser based on the parameter passed and returns the driver of the browser
	public WebDriver selectBrowser(String browser, String Platform) {

		switch (browser.toLowerCase()) {
		case "chrome":

			if (Platform.equalsIgnoreCase("windows")) {
				System.setProperty("webdriver.chrome.driver",GlobalValues.windowsChromeDriverPath);
				driver = new ChromeDriver();
			} else if (Platform.equalsIgnoreCase("mac")) {
				Log.info("Mac Chrome browser is selected ");
			} else if (Platform.equalsIgnoreCase("android")) {
				Log.info("Android Chrome browser is selected ");
			} else {
			}
			break;

		case "firefox":
			if (Platform.equalsIgnoreCase("windows")) {
				System.setProperty("webdriver.gecko.driver",GlobalValues.windowsFirefoxDriverPath);
				driver = new FirefoxDriver();
				//Log.info("Windows Firefox browser is selected ");
			} else if (Platform.equalsIgnoreCase("mac")) {
				Log.info("Mac Firefox browser is selected ");
			} else
				Log.error("Invalid platform is selected - Please select platform as a [Windows/Mac");
			break;

		case "ie":
			if (Platform.equalsIgnoreCase("windows")) {
				Log.info("Windows Internet Explorer browser is selected ");
			} else
				Log.error("Invalid platform is selected - Please select platform as a [Windows]");
			break;

		case "safari":
			if (Platform.equalsIgnoreCase("mac")) {
				Log.info("Mac Safari browser is selected ");
			} else if (Platform.equalsIgnoreCase("iPhone")) {
				Log.info("iPhone Safari browser is selected ");
			} else
				Log.error("Invalid platform is selected - Please select platform as a [Mac/iPhone]");
			break;

		default:
			Log.error("Invalid platform is selected");

		}
		return driver;
	}

}
