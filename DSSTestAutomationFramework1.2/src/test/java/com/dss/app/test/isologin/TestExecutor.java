package com.dss.app.test.isologin;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.dss.app.coreutilities.Log;
import com.dss.app.reporter.DSSReporter;
import com.dss.app.test.base.BaseTest;
import com.relevantcodes.extentreports.LogStatus;

@Listeners(DSSReporter.class)
public class TestExecutor extends BaseTest {

	@Test(groups = { "Regression" })
	public void isISOLoginSuccessfull() throws InterruptedException {

		String testCaseName = "Verify ISO login with valid user";
		logger = report.startTest(testCaseName);
		Log.startTestCase(testCaseName);

		boolean isSuccess = isoLoginFlow.isISOLoginSuccess(logger,
				"test1test1@gmail.com", "tribune01");

		Assert.assertTrue(isSuccess);
		logger.log(LogStatus.PASS, "ISO user logged in successfully");
	
	}


}
