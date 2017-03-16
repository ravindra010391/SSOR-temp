package com.dss.app.pageobject;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dss.app.coreutilities.CoreUtility;
import com.dss.app.coreutilities.Log;

/*
 * This class will contain all the locators of the HOME PAGE
 */

public class ProfilePageObject{
	

	private WebDriver driver;
	private Log Log;

	public ProfilePageObject(WebDriver driver, Log Log) throws IOException {
		this.driver = driver;
		this.Log = Log;
		PageFactory.initElements(driver, this);
		//Log.logInit();
	}

	@FindBy(xpath = "//*[@id='content']/div/div[2]/div/div/div[1]/div[2]")
	private WebElement preferredEmail;

	@FindBy(xpath = "//*[@id='signup-login']/div/div/ul/li[3]/a")
	private  WebElement topLogOutLink;

	
	
	

	public boolean isExpectedUserLogged(String emailId) {

		boolean isSuccess = false;
		if (emailId.equalsIgnoreCase(getPreferredEmail())) {
			isSuccess = true;
			Log.info("Preferred Email matched with the User's Email ");
		}
		return isSuccess;
	}

	// **********************PRIVATE METHODS****************************
	private String getPreferredEmail() {
		CoreUtility.waitForElementPresent(preferredEmail,
				driver);
		Log.info("Getting 'Preferred Email' on Profile Page");
		return preferredEmail.getText();
	}

}
