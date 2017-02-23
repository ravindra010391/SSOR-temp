package com.dss.app.test.isoflows;

import org.openqa.selenium.WebDriver;

/*
 *This class will contain all the end to end flows related to SSO Login
 */

public class SSOLoginFlows extends Flows {

	private WebDriver driver;

	public SSOLoginFlows(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void isSSOLoginSuccess() {
		homepage.clickOnLoginTopNav();

	}

}
