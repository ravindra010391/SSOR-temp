package com.dss.app.pageobject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dss.app.coreutilities.CoreUtility;
import com.dss.app.coreutilities.Log;

/*
 * This class will contain all the locators of the HOME PAGE
 */
public class HomePageObject {

	
	
	private WebDriver driver;
	private Log Log;
	private ProfilePageObject profilepage;

	public HomePageObject(WebDriver driver, Log Log) throws IOException {
		this.driver = driver;
		this.Log = Log;
		PageFactory.initElements(driver, this);
		//Log.logInit();
	}
	
	
	@FindBy(xpath = "html/body/header/div[1]/div[1]/a[2]")
	private  WebElement btn_LoginTopNav;

	@FindBy(xpath = "html/body/header/div[1]/div[1]/a[3]")
	private  WebElement btn_Subscribe;

	@FindBy(xpath = "//*[@id='reg-overlay']/div/div[2]/form/div[1]/fieldset[1]/input")
	private  WebElement textBox_EmailId;

	@FindBy(xpath = "//*[@id='reg-overlay']/div/div[2]/form/div[1]/fieldset[2]/input")
	private  WebElement textBox_Password;

	@FindBy(xpath = "//*[@id='reg-overlay']/div/div[2]/form/div[1]/button")
	private  WebElement btn_Login;

	@FindBy(xpath = "//*[@id='reg-overlay']/div/div[2]/form/div[1]/div")
	private  WebElement btn_Cancel;

	// Advertise pop up close button
	@FindBy(xpath = ".//*[@id='checkm8Ad_4']")
	public WebElement btn_AdClose;

	// Navigation links for logged in users
	@FindBy(xpath = "html/body/header/div[1]/div[1]/a[4]")
	private  WebElement icon_User;

	@FindBy(xpath = "html/body/header/div[1]/div[1]/ul/li[1]/a")
	private  WebElement link_ProfilePage;

	@FindBy(xpath = "html/body/header/div[1]/div[1]/ul/li[2]/a")
	private  WebElement link_Newsletter;

	@FindBy(xpath = "html/body/header/div[1]/div[1]/ul/li[3]/a")
	private  WebElement link_SignOut;
	
	


	public HomePageObject clickOnLoginTopNav() {
		CoreUtility.highlightElement(btn_LoginTopNav, driver);
		CoreUtility.clickOnElement(btn_LoginTopNav);
		Log.info("Clicked on Login Button of Top NAV");
		return this;
	}

	public void doLogin(String userName, String userPassword) {
		enterEmailId(userName);
		enterPassword(userPassword);
		clicklogin();

	}

	public ProfilePageObject gotoProfilePage() throws IOException {

		profilepage = clickOnUserIcon().clickOnAccountLink();
		Log.info("Redirecting to Profile page");
		return profilepage;
	}
	
	

	// ****************PRIVATE METHODS*******************************
	private HomePageObject enterEmailId(String emailId) {
		CoreUtility.highlightElement(textBox_EmailId, driver);
		CoreUtility.waitForElementPresent(textBox_EmailId,
				driver);
		CoreUtility.enterData(emailId, textBox_EmailId);
		Log.info("Entered Email id");
		return this;
	}

	private HomePageObject enterPassword(String password) {
		CoreUtility.waitForElementPresent(textBox_Password,
				driver);
		CoreUtility.highlightElement(textBox_Password, driver);
		CoreUtility.enterData(password, textBox_Password);
		Log.info("Entered Password");
		return this;
	}

	private HomePageObject clicklogin() {
		CoreUtility.waitForElementPresent(btn_Login, driver);
		CoreUtility.highlightElement(btn_Login, driver);
		CoreUtility.clickOnElement(btn_Login);
		Log.info("Clicked on Login button at the login panel");
		return this;
	}

	private HomePageObject clickCancel() {
		CoreUtility.clickOnElement(btn_Cancel);
		Log.info("Clicked on Cancel button at the login panel");
		return this;
	}

	private HomePageObject clickOnUserIcon() {
		CoreUtility.highlightElement(icon_User, driver);
		CoreUtility.clickOnElement(icon_User);
		Log.info("Clicked on User Account menu");
		return this;
	}

	private ProfilePageObject clickOnAccountLink() throws IOException {
		CoreUtility.waitForElementPresent(link_ProfilePage,
				driver);
		CoreUtility.highlightElement(link_ProfilePage, driver);
		CoreUtility.clickOnElement(link_ProfilePage);
		Log.info("Clicked on Profile link of account menu drop-down");
		return new ProfilePageObject(driver,Log);
	}

}
