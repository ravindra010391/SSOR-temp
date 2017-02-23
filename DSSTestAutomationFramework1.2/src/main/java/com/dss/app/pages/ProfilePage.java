package com.dss.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.dss.app.coreutilities.CoreUtility;
import com.dss.app.coreutilities.Log;
import com.dss.app.pageobject.ProfilePageObject;

public class ProfilePage {

	private WebDriver driver;

	public ProfilePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, ProfilePageObject.class);
		Log.logInit();
	}

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
		CoreUtility.waitForElementPresent(ProfilePageObject.preferredEmail,
				driver);
		Log.info("Getting 'Preferred Email' on Profile Page");
		return ProfilePageObject.preferredEmail.getText();
	}

}
