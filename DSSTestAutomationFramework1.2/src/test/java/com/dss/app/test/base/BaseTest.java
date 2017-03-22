package com.dss.app.test.base;

import org.testng.annotations.Test;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.dss.app.apputilities.AppUtility;
import com.dss.app.apputilities.Config;
import com.dss.app.apputilities.SauceREST;
import com.dss.app.coreutilities.CoreUtility;
import com.dss.app.coreutilities.Log;
import com.dss.app.pageobject.HomePageObject;
import com.dss.app.pageobject.ProfilePageObject;
import com.dss.app.reporter.ExtentTestManager;
import com.dss.app.reporter.Extentmanager;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest{

	protected WebDriver driver;

	protected ExtentTest logger;
	protected HomePageObject homepage;
	protected ProfilePageObject profilepage;
	protected Log Log;
	protected SauceREST SauceREST;
	protected String jobID;
	public static String currentSuiteName;


	@BeforeSuite(alwaysRun = true)
	public void suiteSetUp(ITestContext context) {
		currentSuiteName = context.getCurrentXmlTest().getSuite().getName();
		Extentmanager.getReporter(currentSuiteName);

	}

	@AfterSuite(alwaysRun = true)
	public void suiteTearDown() throws IOException {
		//CoreUtility.cleanAllTempLogFile();
		Extentmanager.getReporter().close();
		
	}
	
	@Parameters({ "browser"})
	@BeforeTest
	public void testSetUp(String browser) throws IOException {

		String logName = browser+Thread.currentThread().getId()+"log";
		Log = new Log(logName);
		SauceREST = new SauceREST();
		
	}
	
	

	@AfterTest
	public void testTearDown(ITestContext context) throws IOException {
        String fromFile = Log.Log.getName()+".log";
        String toFile =  "Log" + currentSuiteName +AppUtility.getCurrentDate()+".log";
               
        System.out.println("From file: "+fromFile);
        CoreUtility.copyDataFromTempLogFileToMainLogFile(fromFile,toFile);

		
	}

	@Parameters({ "browser", "platform", "url" })
	@BeforeMethod(alwaysRun = true)
	public void methodSetUp(String browser, String platform, String url, Method method, ITestContext testContext) throws IOException, InterruptedException {

	
		//driver = new Config().selectBrowserOnLocal(browser, platform);
		driver = new Config(Log).selectBrowserOnSauceLab(browser, platform, method);
		jobID =  (((RemoteWebDriver) driver).getSessionId()).toString();
		
		ExtentTestManager.startTest(CoreUtility.capsFirstLetter(CoreUtility.getMarketName(url))+" - "+ CoreUtility.capsFirstLetter(browser) + " - "+ CoreUtility.capsFirstLetter(method.getName()));
		ExtentTestManager.getTest().assignCategory(CoreUtility.capsFirstLetter(CoreUtility.getMarketName(url)), CoreUtility.capsFirstLetter(browser));

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
		
		String testStatus = "pass";
		if (result.getStatus() == ITestResult.FAILURE) {
			testStatus = "fail";
            ExtentTestManager.getTest().log(LogStatus.FAIL, result.getThrowable());
            SauceREST.jobFailed(jobID);
            Log.error(result.getThrowable());
            
        } else if (result.getStatus() == ITestResult.SKIP) {
        	testStatus = "skip";
            ExtentTestManager.getTest().log(LogStatus.SKIP, "Test skipped " + result.getThrowable());
            Log.error(result.getThrowable());
            
        } else  if (result.getStatus() == ITestResult.SUCCESS){
            ExtentTestManager.getTest().log(LogStatus.PASS, result.getName());
            SauceREST.jobPassed(jobID);
        }
		String click_url = "<a target='_blank'"+ "href='https://saucelabs.com/beta/tests/"+ jobID +"/metadata#9'>Screenshot and Screencast of the Test</a>";
		ExtentTestManager.getTest().log(LogStatus.INFO, click_url);
        
        Extentmanager.getReporter().endTest(ExtentTestManager.getTest());        
        Extentmanager.getReporter().flush();
        Log.endTestCase(testStatus);
        
		driver.quit();


		
	}


	



	
	
	

}
