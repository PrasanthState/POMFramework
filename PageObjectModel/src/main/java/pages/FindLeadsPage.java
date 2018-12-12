package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapsWrappers;

public class FindLeadsPage extends LeafTapsWrappers{

	public FindLeadsPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		if(!verifyTitle("Find Leads | opentaps CRM")){
			reportStep("This in not Find Leads Page", "FAIL");
		}		
	}

	public FindLeadsPage clickPhoneTab() {
		clickByXpath("//span[text()='Phone']");
		return this;
	}

	public FindLeadsPage enterphoneNumb1(String data) {
		enterByName("phoneCountryCode", data);
		return this;
	}
	
	public FindLeadsPage enterphoneNumb2(String data) {
		enterByName("phoneAreaCode", data);
		return this;
	}
	
	public FindLeadsPage enterphoneNumb3(String data) {
		enterByName("phoneNumber", data);
		return this;
	}
	
	public FindLeadsPage clickFindLeads() throws InterruptedException {
		clickByXpath("//button[text()='Find Leads']");
		Thread.sleep(10000);
		return this;
	}
	
	public String getFirstLeadId() {
		return getTextByXpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a");
	}
	
	public ViewLeadPage clickFirstLeadId(){
		clickByXpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a");
		return new ViewLeadPage(driver, test);
	}
	
	public FindLeadsPage enterLeadId(String data) {
		enterByXpath("//input[@name='id']", data);
		return this;
	}
	
	public FindLeadsPage verifyLeadNotPresent(String data) {
		verifyTextByXpath("//div[@class='x-paging-info']", data);
		return this;
	}
	
	public FindLeadsPage enterfirstName(String data) {
		enterByXpath("(//input[@name='firstName'])[3]", data);
		return this;
	}
	
	public FindLeadsPage clickEmailTab() {
		clickByXpath("//span[text()='Email']");
		return this;
	}
	
	public FindLeadsPage enterEmail() {
		enterByName("emailAddress", "a@a.com");
		return this;
	}
	
	public String getFirstNameOfFirstLead() {
		return getTextByXpath("(//*[@class='x-grid3-cell-inner x-grid3-col-firstName'])[1]");
	}
}
















