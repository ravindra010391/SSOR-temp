package com.dss.app.apputilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.dss.app.coreutilities.CoreUtility;
import com.dss.app.coreutilities.Log;

public class AppUtility {

	// This method will close the advertisement if it is displayed
	public static void closeAds(WebElement element, WebDriver driver) {

		try {
			CoreUtility.waitForElementPresent(element, driver);
			if (element != null) {
				CoreUtility.clickOnElement(element);
			//	Log.info("Advertisement is present and closed");
			}
		}
		catch (Exception e) {
		//	Log.warn("Advertisement is not displayed");
		}
	}

	// This method will generate random ISO email ID
	public static String emailGeneratorISO() {
		String emailId;
		Random random = new Random();
		int randomnum = random.nextInt(1000);

		
		String currentdate = getCurrentDate();

		emailId = "ISO" + "_" + currentdate + "_" + randomnum + "@SSOR.com";
		return emailId;
	}
	
	public static String  getCurrentDate(){
		
		String current_Date = null;
		DateFormat timeFormat = new SimpleDateFormat("ddMMYYYY");
		Date date = new Date();
		current_Date=timeFormat.format(date);
		
		return current_Date;
		
	}

}
