package com.dss.test.apputilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.dss.test.coreutilities.CoreUtility;

public class AppUtility {
	
	public static void closeAds(WebElement element, WebDriver driver){

		try {
			CoreUtility.waitForElementPresent(element, driver);
			if(element!=null){
				System.out.println("Ads present");
				CoreUtility.clickOnElement(element);
			}
		}

		catch(Exception e){
			System.out.println("Ads not displayed");
		}

		
		
	}

}
