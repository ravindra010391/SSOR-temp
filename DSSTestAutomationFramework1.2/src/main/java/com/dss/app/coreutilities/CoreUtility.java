package com.dss.app.coreutilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

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

	public static WebElement waitForElementPresent(WebElement element, WebDriver driver){
		WebElement visibleElement = null;

		try{
			WebDriverWait wait = new WebDriverWait(driver,20);
			visibleElement = wait.until(ExpectedConditions.visibilityOf(element));
		}
		catch(Exception e){
			System.out.println("waitForElementPresent : Catched !!");
		}
		return visibleElement;
	}


	public static void handleAlert(WebDriver driver, String action){
		try{
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			if(action.equalsIgnoreCase("accept")){
				alert.accept();System.out.println("Alert Accepted");}
			else{alert.dismiss();System.out.println("Alert Dissmissed ");}
		
		}catch(Exception e)
		{
			System.out.println("Alert is not Present!!");
		}
	}
	
	

	public static String captureScreen(WebDriver driver, String screenshotName ) throws IOException{
		TakesScreenshot ts = (TakesScreenshot) driver;
		java.io.File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir")+"//TempErrorSreenshot//"+screenshotName+".png";
		java.io.File destination = new java.io.File(dest);
		org.apache.commons.io.FileUtils.copyFile(source, destination);
		return dest;
		
	}
	
	public static void highlightElement(WebElement element, WebDriver driver) {
		
		JavascriptExecutor js=(JavascriptExecutor)driver; 
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		try{
		Thread.sleep(200);
		}catch(InterruptedException e){}
		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element); 
		 
	}

}
