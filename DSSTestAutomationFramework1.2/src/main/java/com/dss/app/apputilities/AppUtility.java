package com.dss.app.apputilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Stack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import com.dss.app.coreutilities.CoreUtility;
import com.dss.p2p.pageobject.P2PHomePageObject;
import com.dss.p2p.pageobject.P2PLoginPageObject;
import com.dss.p2p.pageobject.P2PRegistrationPageObject;


public class AppUtility {	
	
	public static Stack stack_Facebook;
	public static Stack stack_Twitter;
	public static Stack stack_Aol;
	public static Stack stack_Yahoo;
	public static Stack stack_Gmail;
	
	
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
	
	
	public static void deleteGmailCookies(WebDriver driver) throws MalformedURLException, IOException, InterruptedException{
	 deleteAllCookies(driver, GlobalValues.SSO_GMAIL_URL_1);
	 deleteAllCookies(driver, GlobalValues.SSO_GMAIL_URL_2);	    
	}
	public static void deleteFacebookCookies(WebDriver driver){
		deleteAllCookies(driver, GlobalValues.SSO_FACEBOOK_URL);
	}
	
	public static void deleteYahooCookies(WebDriver driver){
		deleteAllCookies(driver, GlobalValues.SSO_YAHOO_URL);
	}
	
	public static void deleteTwitterCookies(WebDriver driver){
		deleteAllCookies(driver, GlobalValues.SSO_TWITTER_URL);
	}
	
	public static void deleteAOLCookies(WebDriver driver){
		deleteAllCookies(driver, GlobalValues.SSO_AOL_URL);
	}
	
	
	public static void deleteAllCookies(WebDriver driver,String URL){
	    driver.manage().deleteAllCookies();
	    driver.get(URL);
	    driver.manage().deleteAllCookies();
	}

	public static void deleteTestDataFromP2P(List<String> allEmailId) throws InterruptedException{
		
		
	  P2PLoginPageObject p2pLogIn ;
	  P2PHomePageObject  p2pHome;
	  P2PRegistrationPageObject p2pRegistration;
	  PhantomJSDriver localdriver;
	
		System.setProperty("phantomjs.binary.path",GlobalValues.PHANTOMJS_DRIVER_PATH);
		localdriver = new PhantomJSDriver();
		localdriver.get(GlobalValues.P2P_STAGE_URL);
		p2pLogIn=new P2PLoginPageObject(localdriver);
		p2pHome=p2pLogIn.doP2PLogin(GlobalValues.P2P_STAGE_USERNAME, GlobalValues.P2P_STAGE_PASSWORD);
		p2pRegistration=p2pHome.clickRegistration();
		
		for(String email : allEmailId){
			p2pRegistration.deleteEntry(email);
		}
		localdriver.close();
		
	}
	
	public static void initAllSSOStacks() throws IOException{
		
		stack_Facebook = SSOStacks.loadSSOStack("Facebook");
		stack_Twitter = SSOStacks.loadSSOStack("Twitter");
		stack_Aol= SSOStacks.loadSSOStack("AOL");
		stack_Yahoo = SSOStacks.loadSSOStack("Yahoo");
		stack_Gmail= SSOStacks.loadSSOStack("Gmail");
				
	}
	
	public static Map<String, ArrayList<String>> getTestCaseLevelSSOTestUsers(){
		
		Map<String, ArrayList<String>> testCaseLevelSSOCredentials = new HashMap<String, ArrayList<String>>();
		
		testCaseLevelSSOCredentials.put("Gmail",SSOStacks.getIDFromStack(stack_Gmail) );
		testCaseLevelSSOCredentials.put("Yahoo",SSOStacks.getIDFromStack(stack_Yahoo) );
		testCaseLevelSSOCredentials.put("Aol",SSOStacks.getIDFromStack(stack_Aol) );
		testCaseLevelSSOCredentials.put("Twitter",SSOStacks.getIDFromStack(stack_Twitter) );
		testCaseLevelSSOCredentials.put("Facebook",SSOStacks.getIDFromStack(stack_Facebook) );
		if(testCaseLevelSSOCredentials != null)
			System.out.println("child stack created");
		else
			System.out.println("child is null");
		return testCaseLevelSSOCredentials;		
		
	}
	
	public static void destoryTestCaseLevelSSOTestUsers(Map<String, ArrayList<String>> testCaseLevelSSOCredentials) throws InterruptedException{
		
		List<String> allSSOEmailids=new ArrayList<String>();
		Map<String, ArrayList<String>> temp1;
	
		for(String key: testCaseLevelSSOCredentials.keySet()){
		
			allSSOEmailids.add(testCaseLevelSSOCredentials.get(key).get(0));
		
		}
		
		System.out.println("calling delete p2p from distroy");
		deleteTestDataFromP2P(allSSOEmailids);
		stack_Facebook.push(testCaseLevelSSOCredentials.get("Facebook"));
		stack_Twitter.push(testCaseLevelSSOCredentials.get("Twitter"));
		stack_Aol.push(testCaseLevelSSOCredentials.get("Aol"));
		stack_Yahoo.push(testCaseLevelSSOCredentials.get("Yahoo"));
		stack_Gmail.push(testCaseLevelSSOCredentials.get("Gmail"));
		//testCaseLevelSSOCredentials = null;		
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		initAllSSOStacks();
		Map<String, ArrayList<String>> testCaseLevelSSOCredentials=	getTestCaseLevelSSOTestUsers();
		destoryTestCaseLevelSSOTestUsers(testCaseLevelSSOCredentials);
	}
	
	
	
	
}
