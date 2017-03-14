package com.dss.app.test.base;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
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

	protected ExtentReports report = new ExtentReports(GlobalValues.reportFilePath , true);

	@BeforeSuite(alwaysRun = true)
	public void suiteSetUp() {

	}

	@AfterSuite(alwaysRun = true)
	public void suiteTearDown() {
		report.close();
	}

	@BeforeTest
	public void testSetUp() {

	}

	@AfterTest
	public void testTearDown() {
		report.flush();
	}

	@Parameters({ "browser", "platform", "url" })
	@BeforeMethod(alwaysRun = true)
	public void methodSetUp(String browser, String platform, String url) throws MalformedURLException {

		//driver = new Config().selectBrowserOnLocal(browser, platform);
		driver = new Config().selectBrowserOnSauceLab(browser, platform);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		CoreUtility.handleAlert(driver, "accept");
		
		homepage = new HomePageObject(driver);
		AppUtility.closeAds(homepage.btn_AdClose, driver);
	}

	@AfterMethod(alwaysRun = true)
	public void methodTearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, result.getThrowable());
			String screenshotPath = CoreUtility.captureScreen(driver,
					"screenshotName");
			logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));
		}

		report.endTest(logger);
		Log.endTestCase();
		report.flush();
		driver.quit();

	}

}
