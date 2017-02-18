package com.dss.app.test.isoflows;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ISOLoginFlows extends Flows {
	
	private WebDriver driver;
	
	public ISOLoginFlows(WebDriver driver){
		super(driver);
	}
	
	//Verify ISO login with valid user
	public boolean isISOLoginSuccess(ExtentTest logger, String userName, String userPassword) throws InterruptedException{
		
		boolean isSuccess = false;
		logger.log(LogStatus.INFO, "STEP 1: Click on Top Nav LogIn button");
		homepage.clickOnLoginTopNav();
		
		logger.log(LogStatus.INFO, "STEP 2: Login with Username and Password");
		homepage.doLogin(userName, userPassword);

 		Thread.sleep(10000);
		
		logger.log(LogStatus.INFO,"STEP 3: Navigate to the Profile Page");
		profilepage = homepage.gotoProfilePage();
		
		logger.log(LogStatus.INFO, "STEP 4: Verify the email ID of the user on Profile Page preffered Email ID");
		isSuccess = profilepage.isExpectedUserLogged(userName);
		
		return isSuccess;
		
	}

}
