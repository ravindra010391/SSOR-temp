package com.dss.test.flows;

import org.openqa.selenium.WebDriver;

import com.dss.test.pages.HomePage;
import com.dss.test.pages.ProfilePage;

public class Flows {
	
	private WebDriver driver;
	 public HomePage homepage;
	 public ProfilePage profilepage;
	
	public Flows(WebDriver driver){
		this.driver = driver;
		homepage = new HomePage(driver);
	}

}
