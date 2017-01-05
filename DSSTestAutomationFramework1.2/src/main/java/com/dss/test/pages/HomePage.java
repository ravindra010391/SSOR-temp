package com.dss.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.dss.test.coreutilities.CoreUtility;
import com.dss.test.pageobject.HomePageObject;

public class HomePage {

	private WebDriver driver;
	private ProfilePage profilepage;

	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, HomePageObject.class);
	}

	public boolean isISOLoginSuccess(String userName, String userPassword){
		String preferredEmail;
		boolean isRightUser = false;

		clickOnLoginTopNav();
		enterEmailId(userName).enterPassword(userPassword).clicklogin();
		System.out.println("Login successfull");
		profilepage = clickOnUserIcon().clickOnAccountLink();
		isRightUser = profilepage.isRightUserLoggedIn(userName);
		return isRightUser;

	}





























	private HomePage clickOnLoginTopNav(){

		CoreUtility.clickOnElement(HomePageObject.btn_LoginTopNav);
		return this;
	}

	private HomePage enterEmailId(String emailId){
		CoreUtility.waitForElement(HomePageObject.textBox_EmailId, driver);
		CoreUtility.enterData(emailId, HomePageObject.textBox_EmailId);
		return this;
	}

	private HomePage enterPassword(String password){
		CoreUtility.waitForElement(HomePageObject.textBox_Password, driver);
		CoreUtility.enterData(password, HomePageObject.textBox_Password);
		return this;
	}

	private HomePage clicklogin(){
		CoreUtility.waitForElement(HomePageObject.btn_Login, driver);
		CoreUtility.clickOnElement(HomePageObject.btn_Login);
		return this;
	}
	private HomePage clickCancel(){
		CoreUtility.clickOnElement(HomePageObject.btn_Cancel);
		return this;

	}

	private HomePage clickOnUserIcon(){
		CoreUtility.waitForElement(HomePageObject.icon_User, driver);
		CoreUtility.clickOnElement(HomePageObject.icon_User);
		return this;
	}

	private ProfilePage clickOnAccountLink(){
		CoreUtility.waitForElement(HomePageObject.link_ProfilePage, driver);
		CoreUtility.clickOnElement(HomePageObject.link_ProfilePage);
		return new ProfilePage(driver);
	}




}
