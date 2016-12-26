package com.dss.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.dss.test.coreutilities.Utility;
import com.dss.test.pageobject.HomePageObject;

public class HomePage {

	private WebDriver driver;
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, HomePageObject.class);
	}

	public boolean isISOLoginSuccess(String userName, String userPassword){

			clickOnLoginTopNav().enterEmailId(userName).enterPassword(userPassword).clicklogin();
			
		return true;
	}



























	private HomePage clickOnLoginTopNav(){

		Utility.clickOnElement(HomePageObject.btn_LoginTopNav);
		return this;
	}

	private HomePage enterEmailId(String emailId){
		Utility.enterData(emailId, HomePageObject.textBox_EmailId);
		return this;
	}

	private HomePage enterPassword(String password){
		Utility.enterData(password, HomePageObject.textBox_Password);
		return this;
	}

	private HomePage clicklogin(){
		Utility.clickOnElement(HomePageObject.btn_Login);
		return this;
	}
	private HomePage clickCancel(){
		Utility.clickOnElement(HomePageObject.btn_Cancel);
		return this;

	}



}
