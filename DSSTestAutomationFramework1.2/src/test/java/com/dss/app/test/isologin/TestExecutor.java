package com.dss.app.test.isologin;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dss.app.apputilities.AppUtility;
import com.dss.app.apputilities.Config;
import com.dss.app.coreutilities.CoreUtility;
import com.dss.app.coreutilities.Log;
import com.dss.app.test.isoflows.ISOLoginFlows;
import com.dss.app.pageobject.HomePageObject;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestExecutor {

	private WebDriver driver;
	private ISOLoginFlows isoLoginFlow;
	public ExtentTest logger;
	
	private ExtentReports report = new ExtentReports(System.getProperty("user.dir")+"\\AutomationReport.html");
	
	
	@BeforeSuite(alwaysRun = true)
	public void suitConfig(){
		System.out.println("Starting TestExecutor ====> ");
		String ConfibParameterValues = System.getProperty("CONFIG_PARAMETER");
		System.out.println("jenkinParameter = " +ConfibParameterValues);
		
		//report = new ExtentReports(System.getProperty("user.dir")+"\\AutomationReport.html");
		// ExtentTest logger;
	}

	
	@Parameters({"browser","platform","url"})
	@BeforeMethod(alwaysRun=true)
	public void setup(String browser, String platform, String url) {
		//Log.logInit();
		driver = new Config().selectBrowser(browser, platform);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		CoreUtility.handleAlert(driver, "accept");
	
		isoLoginFlow = new ISOLoginFlows(driver);
		AppUtility.closeAds(HomePageObject.btn_AdClose, driver);
		

	}
	
	@Test(groups = {"Regression" }, enabled = true)
	public void isISOLoginSuccessfull() throws InterruptedException {
		System.out.println("in test case");
		String testCaseName = "Verify ISO login with valid user";
		logger = report.startTest("Verify ISO login with valid user");
		Log.startTestCase("Verify ISO login with valid user");
		System.out.println("after log4j");
		boolean isSuccess = isoLoginFlow.isISOLoginSuccess(logger, "test1test1@gmail.com", "tribune01");
	
		Assert.assertTrue(isSuccess);
		logger.log(LogStatus.PASS, "ISO user logged in successfully");
	}
	
	@Test()
	public void test1() throws InterruptedException
	{ 
		driver.get("http://www.google.com/");
	    System.out.println(driver.getTitle());
	    
	    driver.findElement(By.className("gsfi")).sendKeys(Keys.CONTROL+"t"); 
	    System.out.println("ctrl + t");
	    //driver.get("http://www.bing.com/"); 

		    
		    Thread.sleep(100000);
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			logger.log(LogStatus.FAIL, result.getThrowable());
			String screenshotPath = CoreUtility.captureScreen(driver, "screenshotName");
			logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));
		}

		report.endTest(logger);
		//Log.endTestCase();
		driver.quit();
		System.out.println("after method");
	}
	
	
	@AfterSuite(alwaysRun = true)
	public void cleanup(){
		report.flush();
		System.out.println("After suite");
	}
}









