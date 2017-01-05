package com.dss.test.coreutilities;

import org.apache.commons.exec.ExecuteException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CoreUtility {


	public static void clickOnElement(WebElement element){
		element.click();
	}

	public static void enterData(String data, WebElement element){
		element.clear();
		element.sendKeys(data);
	} 

	public static String getText(WebElement element){
		return element.getText();
	}

	public static boolean isPresent(WebElement element){

		if(element.isDisplayed()){
			System.out.println(element.getText() +" : Found. . .");
			return true;
		}
		else{
			System.out.println("Element Not Found");
			return false;
		}
	}

	public static WebElement waitForElement(WebElement element, WebDriver driver){
		WebElement visibleElement = null;

		try{
			WebDriverWait wait = new WebDriverWait(driver,60);
			visibleElement = wait.until(ExpectedConditions.visibilityOf(element));
		}
		catch(Exception e){
			System.out.println("No element found after WebdriverWait of 10 seconds");
		}
		return visibleElement;
	}


	public static void handleAlert(WebDriver driver, String action){

		Alert alert = driver.switchTo().alert();

		if(action.equalsIgnoreCase("accept")){
			alert.accept();
			System.out.println("Alert Accepted");
		}
		else{
			alert.dismiss();
			System.out.println("Alert Dissmissed ");
		}
	}


}
