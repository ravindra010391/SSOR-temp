package com.dss.app.test.isologin;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dss.app.apputilities.AppUtility;
import com.dss.app.coreutilities.CoreUtility;
import com.dss.app.pageobject.HomePageObject;
import com.dss.app.pages.HomePage;
import com.dss.app.pages.ProfilePage;

//@Listeners(DSSReporter.class)
public class TestExecutor  {
	
	private WebDriver driver;
	private HomePage homepage;
	private ProfilePage profilepage;
	
	
	public static final String USERNAME = "ravindra.manadage"; 
	public static final String ACCESS_KEY = "78ea3dc2-6312-4b08-872d-9312203d1d3e"; 
	public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
	
	//protected static ExtentReports report = new ExtentReports(GlobalValues.reportFilePath , true);

	//static ThreadLocal<RemoteWebDriver> driverThread = new ThreadLocal<RemoteWebDriver>();
	

	@Parameters({ "browser", "url" })
	@BeforeMethod(alwaysRun = true)
	public synchronized void methodSetUp(String browser, String url) throws MalformedURLException {

		//driver = new Config().selectBrowser(browser, platform);
		//driver = sauceLab(browser);
		
		
		if(browser.equalsIgnoreCase("chrome")){
			System.out.println("chrome init");
			DesiredCapabilities caps = DesiredCapabilities.chrome(); 
	
			caps.setCapability("platform", "windows 7");		
			caps.setCapability("version", "51"); 
			
			driver= new RemoteWebDriver(new URL(URL), caps);
			
			System.out.println("After Driver initialization chrome");
		}
		else if(browser.equalsIgnoreCase("firefox")){
			System.out.println("Firefox init");
			DesiredCapabilities caps = DesiredCapabilities.firefox(); 
			caps.setCapability("platform", "windows 7");		
			caps.setCapability("version", "51"); 
			driver=new RemoteWebDriver(new URL(URL), caps);
			
			System.out.println("After Driver initialization ff");
			
	
		}
		
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.get(url);
		System.out.println("Current thread"+Thread.currentThread().getId()+" "+browser);
		CoreUtility.handleAlert(driver, "accept");

	
		System.out.println("Current thread second"+Thread.currentThread().getId()+" "+browser);
		AppUtility.closeAds(HomePageObject.btn_AdClose, driver);
		homepage = new HomePage(driver);
		
		}



	@Test()
	public void isISOLoginSuccessfull() throws InterruptedException {
		//homepage = new HomePage(driver);
		System.out.println("Current thread tc"+Thread.currentThread().getId());
		homepage.clickOnLoginTopNav();
		System.out.println("Current thread tc after topnav"+Thread.currentThread().getId());
		homepage.doLogin("test1test1@gmail.com", "tribune01");
		Thread.sleep(5000);
		profilepage=homepage.gotoProfilePage();
		boolean isSuccess= profilepage.isExpectedUserLogged("test1test1@gmail.com");
		
		
		
		Assert.assertTrue(isSuccess);
		System.out.println("login pass");
	
	}

	@AfterMethod
	public void end1(){
		System.out.println("after method");
	}

}
