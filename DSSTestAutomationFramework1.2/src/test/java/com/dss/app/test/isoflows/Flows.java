package com.dss.app.test.isoflows;

import org.openqa.selenium.WebDriver;

import com.dss.app.pages.HomePage;
import com.dss.app.pages.ProfilePage;

public class Flows {
	
	private WebDriver driver;
	 public HomePage homepage;
	 public ProfilePage profilepage;
	
	public Flows(WebDriver driver){
		this.driver = driver;
		homepage = new HomePage(driver);
	}
	
	public void abc(){
		
	}

}
