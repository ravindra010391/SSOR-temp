package com.dss.app.test.base;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.dss.app.apputilities.AppUtility;
import com.dss.app.apputilities.Config;
import com.dss.app.apputilities.GlobalValues;
import com.dss.app.coreutilities.CoreUtility;
import com.dss.app.coreutilities.Log;
import com.dss.app.pageobject.HomePageObject;
import com.dss.app.pageobject.ProfilePageObject;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest {

	protected WebDriver driver;

	protected ExtentTest logger;
	protected HomePageObject homepage;
	protected ProfilePageObject profilepage;
	protected Log Log;

	protected ExtentReports report = new ExtentReports(GlobalValues.reportFilePath , true);

	@BeforeSuite(alwaysRun = true)
	public void suiteSetUp() {

	}

	@AfterSuite(alwaysRun = true)
	public void suiteTearDown() {
		report.close();
	}
	
	@Parameters({ "browser"})
	@BeforeTest
	public void testSetUp(String browser) throws IOException {

		String logName = browser+Thread.currentThread().getId()+"log";
		Log = new Log(logName);
	}
	
	
	@AfterTest
	public void testTearDown() throws IOException {
		String fromFile = Log.Log.getName()+".log";
		System.out.println("From fiel: "+fromFile);
		
		CoreUtility.copyDataFromTempLogFileToMainLogFile(fromFile);
		report.flush();
	}

	@Parameters({ "browser", "platform", "url" })
	@BeforeMethod(alwaysRun = true)
	public void methodSetUp(String browser, String platform, String url, Method method, ITestContext testContext) throws IOException {

	
		//driver = new Config().selectBrowserOnLocal(browser, platform);
		driver = new Config(Log).selectBrowserOnSauceLab(browser, platform);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		CoreUtility.handleAlert(driver, "accept");
		
		homepage = new HomePageObject(driver,Log);
		AppUtility.closeAds(homepage.btn_AdClose, driver);
		
		Log.startTestCase(method.getName());
		Log.info("Test: "+testContext.getName());
		Log.info("Browser: "+browser);
		Log.info("PLatform: "+platform);
		Log.info("URL: "+url);
		
	}

	@AfterMethod(alwaysRun = true)
	public void methodTearDown(ITestResult result) throws IOException {
	
		System.out.println("After method");
		
		if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("Failed");

			Log.error(result.getThrowable());
		}
		if (result.getStatus() == ITestResult.SKIP) {
			System.out.println("skipped");
			
			Log.error(result.getThrowable());
		}

		report.endTest(logger);
		
		Log.endTestCase();
		report.flush();
		driver.quit();

	}

}
