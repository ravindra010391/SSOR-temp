package com.dss.app.test.isologin;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dss.app.test.base.BaseTest;

//@Listeners(DSSReporter.class)
public class TestExecutor  extends BaseTest {
	

	@Test()
	public void isISOLoginSuccessfull() throws InterruptedException {
	
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

	

}
