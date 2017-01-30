package com.dss.test.apputilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.dss.test.coreutilities.CoreUtility;

public class AppUtility {

	public static void closeAds(WebElement element, WebDriver driver) {

		try {
			CoreUtility.waitForElementPresent(element, driver);
			if (element != null) {
				System.out.println("Ads present");
				CoreUtility.clickOnElement(element);
			}
		}

		catch (Exception e) {
			System.out.println("Ads not displayed");
		}


	}

	public static String emailGeneratorISO() {
		String emailId;
		Random random = new Random();
		int randomnum = random.nextInt(1000);

		DateFormat timeFormat = new SimpleDateFormat("ddMMMMyyHHMM");
		Date date = new Date();
		String currentdate = timeFormat.format(date);

		emailId = "ISO" + "_" + currentdate + "_" + randomnum + "@SSOR.com";
		return emailId;
	}

	public static String passwordGeneratorISO() {

		return "Tribune1";
	}

	public static String GetSSOEmailID(String SSO) throws IOException {

		String emailID = "";
		File CredentialDetails = new File(
				System.getProperty("user.dir") + "\\src\\test\\resources\\LoginCredentials.properties");
		FileInputStream inputstream = new FileInputStream(CredentialDetails);
		Properties prop = new Properties();
		prop.load(inputstream);

		Enumeration enumkey = prop.keys();
		while (enumkey.hasMoreElements()) {

			String keys = (String) enumkey.nextElement();
			if (keys.equalsIgnoreCase(SSO)) {
				emailID = prop.getProperty(SSO);
			}
		}

		inputstream.close();
		return emailID;
	}
// this is test conflict
	public static String GetSSOPassword(String SSO) throws IOException {
		String password = "";
		String Passwordkey = SSO.replace("Id", "Password");
		File CredentialDetails = new File(
				System.getProperty("user.dir") + "\\src\\test\\resources\\LoginCredentials.properties");
		FileInputStream inputstream = new FileInputStream(CredentialDetails);
		Properties prop = new Properties();
		prop.load(inputstream);

		Enumeration enumkey = prop.keys();
		while (enumkey.hasMoreElements()) {

			String keys = (String) enumkey.nextElement();
			if (keys.equalsIgnoreCase(Passwordkey)) {
				password = prop.getProperty(Passwordkey);
			}
		}
		inputstream.close();
		return password;
	}

}
