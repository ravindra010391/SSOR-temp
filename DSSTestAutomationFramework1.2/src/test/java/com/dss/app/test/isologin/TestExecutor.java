package com.dss.app.test.isologin;

import java.io.IOException;

import javax.swing.text.StyledEditorKit.BoldAction;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.dss.app.apputilities.AppUtility;
import com.dss.app.coreutilities.CoreUtility;
import com.dss.app.reporter.ExtentTestManager;
import com.dss.app.test.base.BaseTest;
import com.gargoylesoftware.htmlunit.util.Cookie;
import com.relevantcodes.extentreports.LogStatus;


public class TestExecutor  extends BaseTest {
	
	@Test(enabled = false)
	public void isISOLoginSuccessful() throws InterruptedException, IOException {
	
		String username = "test1test1@gmail.com";
		String password = "tribune01";
		boolean isSuccess = false;
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Click on Login Button on TopNav");
		homepage.clickOnLoginTopNav();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Enter UserName and Password and Login");
		homepage.doLogin(username, password);
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Goto to Profile Page");
		profilepage= homepage.gotoProfilePage();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Verify User on Profile Page");
		isSuccess= profilepage.isExpectedUserLogged(username);
		
		Assert.assertTrue(isSuccess);
	
	}


	@Test(enabled = false)
	public void SSO_Login_With_Facebook_First_Time_Login() throws InterruptedException, IOException{
		String username = "tribunedss10@yahoo.com"; // US based account
		String password = "tribune1";
		String zipcode = "60601";
		boolean isSuccess = false;
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Click on Login Button on Top Nav");
		homepage.clickOnLoginTopNav();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Click on Facebook Icon on Login Panel");
		gigyapage = homepage.clickOnFacebookIcon();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Perform Facebook Login ");
		homepage = gigyapage.doFacebookLogin(username, password);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Enter Zip Code on Intercept Panel");	
		homepage.enterZipcodeOnInterceptPanel(zipcode);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Click on Continue Button on Intercept Panel");
		homepage.clickOnContinueButtonOnInterceptPanel();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Click on Continue Button on Thank You Panel");
		homepage.clickOnContinueButtonOnThankYouPanel();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Goto Profile Page");
		profilepage = homepage.gotoProfilePage();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Verify the User on Profile Page");
		isSuccess = profilepage.isExpectedUserLogged(username);
		
		//Assert.assertEquals(isSuccess, true);
		if(isSuccess)
			ExtentTestManager.getTest().log(LogStatus.PASS, "First Time SSO Login with Facebook PASSED");
		
		
		driver.manage().deleteAllCookies();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Browser Session/History is Deleted");
		
		getURL(url);
		homepage = getHomePageObject();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Click on Login Button on Top Nav");
		homepage.clickOnLoginTopNav();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Click on Facebook Icon on Login Panel");
		gigyapage = homepage.clickOnFacebookIcon();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Perform Facebook Login ");
		homepage = gigyapage.doFacebookLogin(username, password);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Goto Profile Page");
		profilepage = homepage.gotoProfilePage();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Verify the User on Profile Page");
		isSuccess = profilepage.isExpectedUserLogged(username);
		
		if(isSuccess)
			ExtentTestManager.getTest().log(LogStatus.PASS, "Second Time SSO Login with Facebook PASSED");
		
		Assert.assertEquals(isSuccess, true);
		
		
	}
	
	
	@Test(enabled = true)
	public void SSO_Login_With_Gmail_First_Time_Login() throws InterruptedException, IOException{
		String username = "tribunedss@gmail.com";
		String password = "tribune1";
		String zipcode = "60601";
		boolean isSuccess = false;

		
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Click on Login Button on Top Nav");
		homepage.clickOnLoginTopNav();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Click on Gmail Icon on Login Panel");
		gigyapage = homepage.clickOnGmailIcon();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Perform Gmail Login");
		homepage = gigyapage.doGmailLogin(username, password);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Enter Zip Code on Intecept Panel");
		homepage.enterZipcodeOnInterceptPanel(zipcode);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Click on Continue Button On Intercept Panel");
		homepage.clickOnContinueButtonOnInterceptPanel();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Click on Continue Button on Thnak You Panel");
		homepage.clickOnContinueButtonOnThankYouPanel();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Goto Profile Page");
		profilepage = homepage.gotoProfilePage();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Verify User on Profile Page");
		isSuccess = profilepage.isExpectedUserLogged(username);
		 
		
		if(isSuccess)
			ExtentTestManager.getTest().log(LogStatus.PASS, "First Time SSO Login with Gmail PASSED");
		AppUtility.deleteAllCookies(driver);
		AppUtility.deleteGmailCookies(driver);
		getURL(url);
		homepage = getHomePageObject();
		AppUtility.closeAds(homepage.btn_AdClose, driver);		
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Browser Session/History is Deleted");
		

		ExtentTestManager.getTest().log(LogStatus.INFO, "Click on Login Button on Top Nav");
		homepage.clickOnLoginTopNav();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Click on Gmail Icon on Login Panel");
		gigyapage = homepage.clickOnGmailIcon();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Perform Gmail Login ");
		homepage = gigyapage.doGmailLogin(username, password);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Enter Zip Code on Intecept Panel");
		homepage.enterZipcodeOnInterceptPanel(zipcode);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Click on Continue Button On Intercept Panel");
		homepage.clickOnContinueButtonOnInterceptPanel();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Click on Continue Button on Thnak You Panel");
		homepage.clickOnContinueButtonOnThankYouPanel();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Goto Profile Page");
		profilepage = homepage.gotoProfilePage();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Verify User on Profile Page");
		isSuccess = profilepage.isExpectedUserLogged(username);
		
		if(isSuccess)
			ExtentTestManager.getTest().log(LogStatus.PASS, "Second Time SSO Login with Gmail PASSED");
		
	}
	
	@Test(enabled = false)
	public void SSO_Login_With_AOL_First_Time_Login() throws InterruptedException, IOException{
		String username = "ssortest@aol.com";
		String password = "tribune1";
		String zipcode = "60601";
		boolean isSucess = false;
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Click on Login on Top Nav");
		homepage.clickOnLoginTopNav();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Click on AOL icon on Login Panel");
		gigyapage = homepage.clickOnAOLIcon();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Perform AOL Login ");
		homepage = gigyapage.doAOLLogin(username, password);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Enter Zip Code on intercept Panel");
		homepage.enterZipcodeOnInterceptPanel(zipcode);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Click on Continue Button on Intercept Panel");
		homepage.clickOnContinueButtonOnInterceptPanel();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Click on Continue Button on Thank You Panel");
		homepage.clickOnContinueButtonOnThankYouPanel();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Goto Profile Page");
		profilepage = homepage.gotoProfilePage();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Verify User on Profile Page");
		isSucess = profilepage.isExpectedUserLogged(username);
		
		Assert.assertEquals(isSucess, true);
		
		
		
	}
	
	@Test(enabled = false) 
	public void SSO_Login_With_Twitter_First_Time_Login() throws InterruptedException, IOException{
		String username = "tribunedss1@yahoo.com";
		String password = "tribune1";
		String zipcode = "60601";
		boolean isSucess = false;
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Click on Login Button on Top Nav");
		homepage.clickOnLoginTopNav();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Click on Twitter Icon on Login Panel");
		gigyapage = homepage.clickOnTwitterIcon();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Perform Twitter Login");
		homepage = gigyapage.doTwitterLogin(username, password);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Enter Email ID on Intercept Panel");
		homepage.enterEmailOnInterceptPanel(username);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Enter Zip Code on Intercept Panel");
		homepage.enterZipcodeOnInterceptPanel(zipcode);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Click on Continue Button on Intercept Panel");
		homepage.clickOnContinueButtonOnInterceptPanel();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Click on Continue Button on Thank You Panel");
		homepage.clickOnContinueButtonOnThankYouPanel();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Goto Profile Page");
		profilepage = homepage.gotoProfilePage();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Verify user on Profile Page");
		isSucess = profilepage.isExpectedUserLogged(username);
		
		Assert.assertEquals(isSucess, true);
		
	}

	
	@Test(enabled = false)
	public void SSO_Login_With_Yahoo_First_Time_Login() throws InterruptedException, IOException{
		String username = "tribunedss21@yahoo.com";
		String password = "tribune1";
		String zipcode = "60601";
		boolean isSucess = false;
		
		homepage.clickOnLoginTopNav();
		gigyapage = homepage.clickOnYahooIcon();
		homepage = gigyapage.doYahooLogin(username, password);
		homepage.enterZipcodeOnInterceptPanel(zipcode);
		homepage.clickOnContinueButtonOnInterceptPanel();
		homepage.clickOnContinueButtonOnThankYouPanel();
		profilepage = homepage.gotoProfilePage();
		isSucess = profilepage.isExpectedUserLogged(username);
		
		Assert.assertEquals(isSucess, true);	

	}
	
}
