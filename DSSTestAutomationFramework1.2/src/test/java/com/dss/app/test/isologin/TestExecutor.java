package com.dss.app.test.isologin;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dss.app.reporter.ExtentTestManager;
import com.dss.app.test.base.BaseTest;
import com.relevantcodes.extentreports.LogStatus;

//@Listeners(DSSReporter.class)
public class TestExecutor  extends BaseTest {
	
	@Test()
	public void isISOLoginSuccessful() throws InterruptedException, IOException {
	
		ExtentTestManager.getTest().log(LogStatus.INFO, "Clicking on TopNav");
		homepage.clickOnLoginTopNav();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Entering UserName and Password");
		homepage.doLogin("test1test1@gmail.com", "tribune01");
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Click on Login Button");
		profilepage= homepage.gotoProfilePage();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Redirecting to Profile Page");
		boolean isSuccess= profilepage.isExpectedUserLogged("test1test1@gmail.com");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Verifying User");
		Assert.assertTrue(isSuccess);
	
	}


	

}
