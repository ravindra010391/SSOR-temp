package com.dss.test.isologin;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

import com.dss.test.apputilities.AppUtility;
import com.dss.test.coreutilities.CoreUtility;
import com.dss.test.flows.ISOLoginFlows;
import com.dss.test.pageobject.HomePageObject;
import com.dss.test.pages.HomePage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Execution {

	private WebDriver driver;
	private ISOLoginFlows isoLoginFlow;
	private ExtentReports report;
	private ExtentTest logger;
	
	private ATUTestRecorder videoRecorder;
	

	@BeforeTest
	public void setup() throws ATUTestRecorderException{
		String path ="C:\\eclipse_1\\FF\\";
		
		System.setProperty("webdriver.gecko.driver", path+"geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		System.out.println("maximaised");
		driver.get("http://nguxbeta:nguxtr!b@ngux.latimes.stage.tribdev.com");
		CoreUtility.handleAlert(driver, "accept");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		isoLoginFlow = new ISOLoginFlows(driver);
		AppUtility.closeAds(HomePageObject.btn_AdClose, driver);
		report =new ExtentReports("C:\\Automation1.2\\report\\Automation1.2.html");
		
		
		

	}

	@Test
	public void isISOLoginSuccessfull() throws ATUTestRecorderException {
		System.out.println("Test case start");
		videoRecorder = CoreUtility.recordScreen("isISOLoginSuccessfull");
		videoRecorder.start();
				
		logger = report.startTest("Verify ISO login with valid user");
		boolean isSuccess = isoLoginFlow.isISOLoginSuccess(logger, "test1test1@gmail.com", "tribune01");
		Assert.assertTrue(isSuccess);
		logger.log(LogStatus.PASS, "ISO user logged in successfully");
	}
	

	@AfterMethod
	public void tearDown(ITestResult result) throws ATUTestRecorderException, IOException{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			logger.log(LogStatus.FAIL, result.getThrowable());
			String screenshotPath = CoreUtility.captureScreen(driver, "screenshotName");
			logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));
		}

		report.endTest(logger);
		driver.quit();
		videoRecorder.stop();
	}
	
	
	@AfterTest
	public void cleanup(){
		report.flush();
	}
}
