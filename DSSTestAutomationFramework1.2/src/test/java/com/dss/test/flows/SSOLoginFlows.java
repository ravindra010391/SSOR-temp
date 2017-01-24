package com.dss.test.flows;

import org.openqa.selenium.WebDriver;

public class SSOLoginFlows extends Flows {
	
	private WebDriver driver;

	public SSOLoginFlows(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public void isSSOLoginSuccess(){
		homepage.clickOnLoginTopNav();
		
	}
	

}
