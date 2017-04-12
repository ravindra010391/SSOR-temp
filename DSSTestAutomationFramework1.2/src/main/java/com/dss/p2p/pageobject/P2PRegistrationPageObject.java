package com.dss.p2p.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dss.app.coreutilities.CoreUtility;
import com.dss.app.coreutilities.Log;

public class P2PRegistrationPageObject {

	private WebDriver driver;

	public P2PRegistrationPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath = "//*[@id='functionContainer']/ul/li[3]/a")
	private  WebElement secondary_Nav_P2P_ConsumerSearch;

	@FindBy(xpath = "//*[@id='email']")
	private  WebElement txtBox_ConsumerEmailId;

	@FindBy(name = "commit")
	private  WebElement btn_ConsumerSearch;

	@FindBy(xpath = "//*[starts-with(@id, 'batch_delete_consumer_id')]")
	private List<WebElement> CheckBox_ResultSet;

	@FindBy(id = "ssor_delete_consumer_button")
	private WebElement btn_Batch_Delete;

	@FindBy(xpath = "//*[@id='hud_prompt_Confirm']")
	private WebElement btn_ConfirmationPopUp_Confirm;

	/* public methods */

	public void deleteEntry(String emailID) throws InterruptedException {
		clickOnSecondaryNav_ConsumerSearch();
		enterConsumerEmailId(emailID);
		clickConsumerSearch();
		CoreUtility.waitForElementPresent(btn_Batch_Delete, driver);
		if (!CheckBox_ResultSet.isEmpty()) {
			selectConsumerResultset();
			clickConsumerBatchDelete();
	
			clickPopUpConfirm();
			System.out.println("Email id is deleted from P2P");
		} else {
			System.out.println("Email id is not present in P2P");
		}

	}

	/* private methods */

	private P2PRegistrationPageObject clickOnSecondaryNav_ConsumerSearch() {
		CoreUtility.waitForElementPresent(secondary_Nav_P2P_ConsumerSearch, driver);
		CoreUtility.clickOnElement(secondary_Nav_P2P_ConsumerSearch);
		return this;
	}

	private P2PRegistrationPageObject enterConsumerEmailId(String emailId) {
		CoreUtility.waitForElementPresent(txtBox_ConsumerEmailId, driver);
		CoreUtility.enterData(emailId, txtBox_ConsumerEmailId);
		return this;
	}

	private P2PRegistrationPageObject clickConsumerSearch() {
		CoreUtility.clickOnElement(btn_ConsumerSearch);
		return this;
	}

	private P2PRegistrationPageObject selectConsumerResultset() {

		CoreUtility.waitForElementPresent(btn_Batch_Delete, driver);
		for (WebElement consumer : CheckBox_ResultSet) {
			CoreUtility.clickOnElement(consumer);
		}
		return this;
	}

	private P2PRegistrationPageObject clickConsumerBatchDelete() {
		CoreUtility.clickOnElement(btn_Batch_Delete);
		return this;
	}

	private P2PRegistrationPageObject clickPopUpConfirm() throws InterruptedException {
		Thread.sleep(20000);
		CoreUtility.waitForElementPresent(btn_ConfirmationPopUp_Confirm, driver);
		CoreUtility.clickOnElement(btn_ConfirmationPopUp_Confirm);
		return this;
	}

}
