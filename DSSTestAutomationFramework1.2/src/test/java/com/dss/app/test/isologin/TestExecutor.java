package com.dss.app.test.isologin;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dss.app.coreutilities.Log;
import com.dss.app.test.base.BaseTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestExecutor extends BaseTest {

	@Test(groups = { "Regression" }, enabled = true)
	public void isISOLoginSuccessfull() throws InterruptedException {

		String testCaseName = "Verify ISO login with valid user";
		logger = report.startTest(testCaseName);
		Log.startTestCase(testCaseName);

		boolean isSuccess = isoLoginFlow.isISOLoginSuccess(logger,
				"test1test1@gmail.com", "tribune01");

		Assert.assertTrue(isSuccess);
		logger.log(LogStatus.PASS, "ISO user logged in successfully");
	}

	@Test(groups = { "Regression" }, enabled = false)
	public void test1() throws InterruptedException {

		logger = report.startTest("Test case 2");
		logger.log(LogStatus.INFO, "Step 1");
		logger.log(LogStatus.INFO, "Step 1");
		logger.log(LogStatus.INFO, "Step 1");
		if (browser.equalsIgnoreCase("chrome")) {
			Assert.assertTrue(false);
			logger.log(LogStatus.FAIL, "Passed 1");
		} else {
			Assert.assertTrue(true);
			logger.log(LogStatus.PASS, "Passed");
		}

	}

}
