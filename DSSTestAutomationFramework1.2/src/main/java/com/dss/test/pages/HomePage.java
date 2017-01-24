package com.dss.test.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.dss.test.coreutilities.CoreUtility;
import com.dss.test.coreutilities.Log;
import com.dss.test.pageobject.HomePageObject;

public class HomePage {

	private WebDriver driver;
	private ProfilePage profilepage;

	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, HomePageObject.class);
		Log.logInit();
	}

	//****************PUBLIC METHODS*******************************
	public HomePage clickOnLoginTopNav(){
		CoreUtility.highlightElement(HomePageObject.btn_LoginTopNav, driver);
		CoreUtility.clickOnElement(HomePageObject.btn_LoginTopNav);
		Log.info("Click on Login Button Top NAV");
		return this;
	}
	
	
	public void doLogin(String userName, String userPassword){
		enterEmailId(userName);
		enterPassword(userPassword);
		clicklogin();
		
	}
	
	
	public ProfilePage gotoProfilePage(){
		profilepage = clickOnUserIcon().clickOnAccountLink();
		return profilepage;
	}

		
	//****************PRIVATE METHODS*******************************
	
	private HomePage enterEmailId(String emailId){
		CoreUtility.highlightElement(HomePageObject.textBox_EmailId, driver);
		CoreUtility.waitForElementPresent(HomePageObject.textBox_EmailId, driver);
		CoreUtility.enterData(emailId, HomePageObject.textBox_EmailId);
		Log.info("Enter Email id");
		return this;
	}

	
	private HomePage enterPassword(String password){
		CoreUtility.waitForElementPresent(HomePageObject.textBox_Password, driver);
		CoreUtility.highlightElement(HomePageObject.textBox_Password, driver);
		CoreUtility.enterData(password, HomePageObject.textBox_Password);
		Log.info("Enter Password");
		return this;
	}

	
	private HomePage clicklogin(){
		CoreUtility.waitForElementPresent(HomePageObject.btn_Login, driver);
		CoreUtility.highlightElement(HomePageObject.btn_Login, driver);
		CoreUtility.clickOnElement(HomePageObject.btn_Login);
		Log.info("Click on Login button at the login panel");
		return this;
	}
	
	
	private HomePage clickCancel(){
		CoreUtility.clickOnElement(HomePageObject.btn_Cancel);
		Log.info("Click on Cancel button at the login panel");
		return this;
	}

	
	private HomePage clickOnUserIcon(){
		CoreUtility.highlightElement(HomePageObject.icon_User, driver);
		CoreUtility.waitForElementPresent(HomePageObject.icon_User, driver);
		CoreUtility.clickOnElement(HomePageObject.icon_User);
		Log.info("Click on User Account menu");
		return this;
	}


	private ProfilePage clickOnAccountLink(){
		CoreUtility.waitForElementPresent(HomePageObject.link_ProfilePage, driver);
		CoreUtility.highlightElement(HomePageObject.link_ProfilePage, driver);
		CoreUtility.clickOnElement(HomePageObject.link_ProfilePage);
		Log.info("Click on Profile link of account menu drop-down");
		return new ProfilePage(driver);
	}

}
