package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapsWrappers;

public class ViewLeadPage extends LeafTapsWrappers{

	public ViewLeadPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		if(!verifyTitle("View Lead | opentaps CRM")){
			reportStep("This in not View Lead Page", "FAIL");
		}		
	}
	
	public ViewLeadPage verifyFirstName(String text){
		verifyTextContainsById("viewLead_firstName_sp", text);
		return this;
	}
	
	public MyLeadsPage clickDelete(){
		clickByLink("Delete");
		return new MyLeadsPage(driver, test);
	}
	
	public ViewLeadPage verifyCompName(String data) {
		verifyTextContainsById("viewLead_companyName_sp", data);
		return this;
	}
	
	public EditLeadPage clickEdit(){
		clickByLink("Edit");
		return new EditLeadPage(driver, test);
	}
	
	public FindLeadsPage clickFindLeads(){
		clickByLink("Find Leads");
		return new FindLeadsPage(driver, test);
	}
	
	public DuplicateLeadPage clickDuplicateLeads(){
		clickByLink("Duplicate Lead");	
		return new DuplicateLeadPage(driver, test);
	}
}

















