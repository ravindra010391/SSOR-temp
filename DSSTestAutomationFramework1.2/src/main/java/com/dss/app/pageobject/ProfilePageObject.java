package com.dss.app.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePageObject {
	
    @FindBy(xpath = "//*[@id='content']/div/div[2]/div/div/div[1]/div[2]")
    public static WebElement preferredEmail;
    
    @FindBy(xpath = "//*[@id='signup-login']/div/div/ul/li[3]/a")
    public static WebElement topLogOutLink;


}
