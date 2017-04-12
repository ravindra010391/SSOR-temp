package com.dss.p2p.pageobject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dss.app.coreutilities.CoreUtility;
import com.dss.app.coreutilities.Log;

public class P2PHomePageObject {

	private WebDriver driver;
	P2PRegistrationPageObject p2pRegistration;
	
	public P2PHomePageObject(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		//Log.logInit();
	}
	
	@FindBy(xpath ="//*[@id='navLinks']/li[6]/a")
	private WebElement link_RegistrationOnPrimaryNav;

/*Public methods*/

	public P2PRegistrationPageObject clickRegistration(){
		
		p2pRegistration = clickOnRegistrationLinkOnPrimaryNav();
		return p2pRegistration;
		
	}

	
	
	
	
/* Private Methods*/
private P2PRegistrationPageObject clickOnRegistrationLinkOnPrimaryNav(){
	CoreUtility.clickOnElement(link_RegistrationOnPrimaryNav);
	
	return new P2PRegistrationPageObject(driver);
	
}
}