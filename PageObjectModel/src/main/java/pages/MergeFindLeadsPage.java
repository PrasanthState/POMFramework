package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapsWrappers;

public class MergeFindLeadsPage extends LeafTapsWrappers{

	public MergeFindLeadsPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		if(!verifyTitle("Find Leads")){
			reportStep("This in not Find Leads Page of Merge Leads", "FAIL");
		}		
	}

	public MergeFindLeadsPage enterLead(String data) {
		enterByXpath("//label[contains(text(),'Lead ID:')]/following::input", data);
		return this;
	}

	public MergeFindLeadsPage clickFindLeads() throws InterruptedException {
		clickByXpathNoSnap("//button[contains(text(),'Find Leads')]");
		Thread.sleep(5000);
		return this;
	}
	
	public MergeLeadsPage clickFirstLeadId(){
		clickByXpathNoSnap("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a");
		switchToParentWindow();
		return new MergeLeadsPage(driver, test);
	}
}
















