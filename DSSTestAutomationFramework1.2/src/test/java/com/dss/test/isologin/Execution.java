package com.dss.test.isologin;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dss.test.apputilities.AppUtility;
import com.dss.test.apputilities.Config;
import com.dss.test.coreutilities.CoreUtility;
import com.dss.test.coreutilities.Log;
import com.dss.test.flows.ISOLoginFlows;
import com.dss.test.pageobject.HomePageObject;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;

public class Execution {

	private WebDriver driver;
	private ISOLoginFlows isoLoginFlow;
	private ExtentReports report;
	private ExtentTest logger;
	

	
	@Parameters({"browser","platform"})
	@BeforeTest
	public void setup(String browser, String platform) {
		//Log.logInit();
		String ConfibParameterValues = System.getProperty("CONFIG_PARAMETER");
		System.out.println("jenkinParameter = " +ConfibParameterValues);
		
		String[] marketSpecificConfig = ConfibParameterValues.split(" ");
		for(String market : marketSpecificConfig){
			System.out.println("Each value :"+market);
			
			String[] marketConfig = market.split("-");
			for(String eachConfig : marketConfig){
				System.out.println(" --- "+eachConfig);
		}
		
		}
		
		
		
	
	
		
		
		driver = new Config().selectBrowser(browser, platform);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://nguxbeta:nguxtr!b@ngux.chicagotribune.stage.tribdev.com");
		CoreUtility.handleAlert(driver, "accept");
	
		isoLoginFlow = new ISOLoginFlows(driver);
		AppUtility.closeAds(HomePageObject.btn_AdClose, driver);
		report = new ExtentReports(System.getProperty("user.dir")+"\\AutomationReport.html");

	}
	
	@Test(enabled = true)
	public void isISOLoginSuccessfull() throws InterruptedException {
		
		String testCaseName = "Verify ISO login with valid user";
		logger = report.startTest(testCaseName);
		Log.startTestCase(testCaseName);
		boolean isSuccess = isoLoginFlow.isISOLoginSuccess(logger, "test1test1@gmail.com", "tribune01");
		Assert.assertTrue(isSuccess);
		logger.log(LogStatus.PASS, "ISO user logged in successfully");
	}
	
	@Test(enabled = false)
	public void test1() throws InterruptedException
	{ 
		driver.get("http://www.google.com/");
	    System.out.println(driver.getTitle());
	    
	    driver.findElement(By.className("gsfi")).sendKeys(Keys.CONTROL+"t"); 
	    System.out.println("ctrl + t");
	    //driver.get("http://www.bing.com/"); 

		    
		    Thread.sleep(100000);
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			logger.log(LogStatus.FAIL, result.getThrowable());
			String screenshotPath = CoreUtility.captureScreen(driver, "screenshotName");
			logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));
		}

		report.endTest(logger);
		Log.endTestCase();
		driver.quit();
		System.out.println("after method");
	}
	
	
	@AfterTest
	public void cleanup(){
		report.flush();
		System.out.println("After test");
	}
}









