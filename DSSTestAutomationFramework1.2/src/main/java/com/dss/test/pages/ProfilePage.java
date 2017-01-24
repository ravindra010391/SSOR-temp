package com.dss.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.dss.test.coreutilities.CoreUtility;
import com.dss.test.pageobject.ProfilePageObject;

public class ProfilePage {

	
    private WebDriver driver;

    public ProfilePage(WebDriver driver) {
           this.driver = driver;
           PageFactory.initElements(driver, ProfilePageObject.class);
    }

    public boolean isExpectedUserLogged(String emailId){

           boolean isSuccess = false;
           if(emailId.equalsIgnoreCase(getPreferedEmail())){
                  isSuccess= true;
           }
              return isSuccess;
    }


    //
    private String getPreferedEmail() {
		CoreUtility.waitForElementPresent(ProfilePageObject.preferedEmail, driver);
		return ProfilePageObject.preferedEmail.getText();

	}
    
    
    
    

}
