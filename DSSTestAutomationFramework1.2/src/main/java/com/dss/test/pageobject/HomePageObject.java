package com.dss.test.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageObject {

	@FindBy(xpath = "html/body/header/div[1]/div[1]/a[2]")
	public static WebElement btn_LoginTopNav;

	@FindBy(xpath = "html/body/header/div[1]/div[1]/a[3]")
	public static WebElement btn_Subscribe;

	@FindBy(xpath = "//*[@id='reg-overlay']/div/div[2]/form/div[1]/fieldset[1]/input")
	public static WebElement textBox_EmailId;

	@FindBy(xpath = "//*[@id='reg-overlay']/div/div[2]/form/div[1]/fieldset[2]/input")
	public static WebElement textBox_Password;

	@FindBy(xpath = "//*[@id='reg-overlay']/div/div[2]/form/div[1]/button")
	public static WebElement btn_Login;

	@FindBy(xpath = "//*[@id='reg-overlay']/div/div[2]/form/div[1]/div")
	public static WebElement btn_Cancel;

}
