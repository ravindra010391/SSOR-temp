package com.dss.app.test.isologin;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.TestNG;
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
import com.dss.app.test.base.BaseTest;
import com.dss.app.test.isoflows.ISOLoginFlows;
import com.dss.app.pageobject.HomePageObject;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestExecutor extends BaseTest {

	
	
	@Test(groups = {"Regression" }, enabled = true)
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
	}


}









