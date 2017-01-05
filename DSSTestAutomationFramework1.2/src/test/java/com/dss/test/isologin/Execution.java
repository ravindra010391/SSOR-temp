package com.dss.test.isologin;

import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.dss.test.apputilities.AppUtility;
import com.dss.test.coreutilities.CoreUtility;
import com.dss.test.pageobject.HomePageObject;
import com.dss.test.pages.HomePage;

public class Execution {

	private WebDriver driver;
	private HomePage home;

	@BeforeTest
	public void setup(){
		String path ="C:\\eclipse_1\\FF\\";
		
		System.setProperty("webdriver.gecko.driver", path+"geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		System.out.println("maximaised");
		driver.get("http://nguxbeta:nguxtr!b@ngux.latimes.stage.tribdev.com");
		CoreUtility.handleAlert(driver, "accept");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		home = new HomePage(driver);
		AppUtility.closeAds(HomePageObject.btn_AdClose, driver);

	}

	@Test
	public void isISOLoginSuccessfull() {
		boolean isSuccess =home.isISOLoginSuccess("test1test1@gmail.com", "tribune01");
		Assert.assertEquals(true, isSuccess);
	}
	
	@Test
	public void isUserAbleToChangePassword(){
		
		
	}
	
}
