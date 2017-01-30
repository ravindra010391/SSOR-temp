package com.dss.test.apputilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.dss.test.coreutilities.Log;

public class Config {
	public WebDriver driver;
	
	public WebDriver selectBrowser(String browser, String Platform) {
		System.out.println("Inside selectBrowser");
		switch (browser.toLowerCase()) {
		case "chrome":
			System.out.println("Chrome selected");
			if (Platform.equalsIgnoreCase("windows")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe");
				driver=new ChromeDriver();
				System.out.println("on WINDOWS platform");
			} else if (Platform.equalsIgnoreCase("mac")) {
				System.out.println("Platform : MAC");
			} else if (Platform.equalsIgnoreCase("android")) {
				System.out.println("Platform : Android");
			} else{
				System.out.println("Invalid platform");
			}
			break;

		case "firefox":
			
			System.out.println("Your test will run on Firefox ");
			if (Platform.equalsIgnoreCase("windows")) {
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\geckodriver.exe");
				driver=new FirefoxDriver();
				System.out.println("on WINDOWS platform");
			} else if (Platform.equalsIgnoreCase("mac")) {
				System.out.println("on MAC platform");
			} else
				System.out.println("Invalid Platform Selected");
			break;

		case "ie":
			System.out.println("Your test will run on Internet Explorer ");
			if (Platform.equalsIgnoreCase("windows")) {
				System.out.println("on WINDOWS platform");
			} else
				System.out.println("Invalid Platform Selected");
			break;

		case "safari":
			System.out.println("Your test will run on Safari");
			if (Platform.equalsIgnoreCase("mac")) {
				System.out.println("on MAC platform");
			} else if (Platform.equalsIgnoreCase("iPhone")) {
				System.out.println("on IOS-iPHONE platform");
			} else
				System.out.println("Invalid Platform Selected");
			break;

		default:
			System.out.println("PLATFORM NOT SUPPORTED");

		}
		return driver;
	}

}
