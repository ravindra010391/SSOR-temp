package com.dss.app.apputilities;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.dss.app.coreutilities.Log;

public class Config {

	private WebDriver driver;
	private Log Log;
	
	public Config(Log Log){
		this.Log = Log;
	}

	//This method will select the browser based on the parameter passed and returns the driver of the browser
	public WebDriver selectBrowserOnLocal(String browser, String platform) {

		switch (browser.toLowerCase()) {
		case "chrome":

			if (platform.equalsIgnoreCase("windows")) {
				System.setProperty("webdriver.chrome.driver",GlobalValues.windowsChromeDriverPath);
				driver = new ChromeDriver();
			} else if (platform.equalsIgnoreCase("mac")) {
				Log.info("Mac Chrome browser is selected ");
			} else if (platform.equalsIgnoreCase("android")) {
				Log.info("Android Chrome browser is selected ");
			} else {
			}
			break;

		case "firefox":
			if (platform.equalsIgnoreCase("windows")) {
				System.setProperty("webdriver.gecko.driver",GlobalValues.windowsFirefoxDriverPath);
				driver = new FirefoxDriver();
				//Log.info("Windows Firefox browser is selected ");
			} else if (platform.equalsIgnoreCase("mac")) {
				Log.info("Mac Firefox browser is selected ");
			} else
				Log.error("Invalid platform is selected - Please select platform as a [Windows/Mac");
			break;

		case "ie":
			if (platform.equalsIgnoreCase("windows")) {
				Log.info("Windows Internet Explorer browser is selected ");
			} else
				Log.error("Invalid platform is selected - Please select platform as a [Windows]");
			break;

		case "safari":
			if (platform.equalsIgnoreCase("mac")) {
				Log.info("Mac Safari browser is selected ");
			} else if (platform.equalsIgnoreCase("iPhone")) {
				Log.info("iPhone Safari browser is selected ");
			} else
				Log.error("Invalid platform is selected - Please select platform as a [Mac/iPhone]");
			break;

		default:
			Log.error("Invalid platform is selected");

		}
		return driver;
	}

	
		public WebDriver selectBrowserOnSauceLab(String browser, String platform) throws MalformedURLException{
			if(platform.equalsIgnoreCase("Windows"))		
				platform = "windows 7";
			
			if(browser.equalsIgnoreCase("chrome")){
				System.out.println("chrome init");
				DesiredCapabilities caps = DesiredCapabilities.chrome(); 
				caps.setCapability("platform", platform);		
				caps.setCapability("version", "latest"); 
				//caps.setVersion("latest");
				driver= new RemoteWebDriver(new URL(GlobalValues.SAUCE_URL), caps);
				System.out.println("After Driver initialization chrome");
			}
			else if(browser.equalsIgnoreCase("firefox")){
				System.out.println("Firefox init");
				DesiredCapabilities caps = DesiredCapabilities.firefox(); 
				caps.setCapability("platform", platform);		
				caps.setCapability("version", "latest"); 
				//caps.setVersion("latest");
				driver=new RemoteWebDriver(new URL(GlobalValues.SAUCE_URL), caps);
				System.out.println("After Driver initialization ff");
			}
			return driver;
			
		}
	
	
}
