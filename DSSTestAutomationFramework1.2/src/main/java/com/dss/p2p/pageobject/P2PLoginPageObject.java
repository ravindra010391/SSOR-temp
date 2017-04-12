package com.dss.p2p.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dss.app.coreutilities.CoreUtility;
import com.dss.app.coreutilities.Log;

public class P2PLoginPageObject {

	private WebDriver driver;
	private P2PHomePageObject p2p_HomePage;
	public P2PLoginPageObject(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		//Log.logInit();
	}

	@FindBy(id = "login_username")
	private  WebElement textbox_P2P_Username;

	@FindBy(id = "login_password")
	private  WebElement textBox_P2P_Password;

	@FindBy(xpath = "//*[@id='login']/div[4]/button")
	private  WebElement btn_P2P_Login;

	
	/* Public Methods*/
	
	public P2PHomePageObject doP2PLogin(String userName, String userPassword){
		
		enterP2PUsername(userName);
		enterP2PPassword(userPassword);
		p2p_HomePage= clickOnP2PLoginButton();
		
		return p2p_HomePage;
		
	}
	
	
	

	
	/* Private Methods */

	private P2PLoginPageObject enterP2PUsername(String userName) {

		CoreUtility.enterData(userName, textbox_P2P_Username);
		return this;

	}

	private P2PLoginPageObject enterP2PPassword(String userPassword) {

		CoreUtility.enterData(userPassword, textBox_P2P_Password);
		return this;

	}

	private P2PHomePageObject clickOnP2PLoginButton() {

		CoreUtility.clickOnElement(btn_P2P_Login);
		return new P2PHomePageObject(driver);

	}

}
