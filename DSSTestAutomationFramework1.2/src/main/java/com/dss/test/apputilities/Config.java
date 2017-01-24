package com.dss.test.apputilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Config {
	public WebDriver driver;
	
	public WebDriver selectBrowser(String browser, String Platform) {

		switch (browser.toLowerCase()) {
		case "chrome":
			if (Platform.equalsIgnoreCase("windows")) {
				System.out.println("Inside win chrome");
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe");
				driver=new ChromeDriver();
			} else if (Platform.equalsIgnoreCase("mac")) {
				System.out.println("Inside mac chrome");
			} else if (Platform.equalsIgnoreCase("android")) {
				System.out.println("Inside android chrome");
			} else
				System.out.println("invalid browser");
			break;

		case "firefox":
			if (Platform.equalsIgnoreCase("windows")) {
				System.out.println("Inside win firefox");
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\geckodriver.exe");
				driver=new FirefoxDriver();
			} else if (Platform.equalsIgnoreCase("mac")) {
				System.out.println("Inside mac firefox");
			} else
				System.out.println("invalid browser");
			break;

		case "ie":
			if (Platform.equalsIgnoreCase("windows")) {
				System.out.println("Inside win IE");
			} else
				System.out.println("invalid browser");
			break;

		case "safari":
			if (Platform.equalsIgnoreCase("mac")) {
				System.out.println("Inside mac safari ");
			} else if (Platform.equalsIgnoreCase("iPhone")) {
				System.out.println("Inside iPhone safari ");
			} else
				System.out.println("invalid browser");
			break;

		default:
			System.out.println("Platform not supported");

		}
		return driver;
	}

}
