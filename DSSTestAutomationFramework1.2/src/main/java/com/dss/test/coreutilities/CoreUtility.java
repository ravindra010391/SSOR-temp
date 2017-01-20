package com.dss.test.coreutilities;

import org.apache.commons.exec.ExecuteException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import com.gargoylesoftware.htmlunit.javascript.host.file.File;
import com.sun.jna.platform.FileUtils;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

import java.io.IOException;
import java.io.File.*;

public class CoreUtility {
	
	private static ATUTestRecorder videoRecorder;
	
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
	
	public static ATUTestRecorder recordScreen(String testcaseName) throws ATUTestRecorderException{
		videoRecorder = new ATUTestRecorder("C:\\Automation1.2\\VideoRecord",testcaseName, false);
		return videoRecorder;
	}

	public static String captureScreen(WebDriver driver, String screenshotName ) throws IOException{
		TakesScreenshot ts = (TakesScreenshot) driver;
		java.io.File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir")+"ErrorSreenshot/"+screenshotName+".png";
		java.io.File destination = new java.io.File(dest);
		org.apache.commons.io.FileUtils.copyFile(source, destination);
		return dest;
		
	}
	
	public static void highlightElement(WebElement element, WebDriver driver){
		
		JavascriptExecutor js=(JavascriptExecutor)driver; 
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element); 
		 
	}

}
