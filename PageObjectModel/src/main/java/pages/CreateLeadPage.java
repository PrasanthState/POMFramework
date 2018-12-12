package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapsWrappers;

public class CreateLeadPage extends LeafTapsWrappers{

	public CreateLeadPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		if(!verifyTitle("Create Lead | opentaps CRM")){
			reportStep("This in not Create Lead Page", "FAIL");
		}		
	}

	public CreateLeadPage enterCompany(String data){
		enterById("createLeadForm_companyName", data);
		//enterById(prop.getProperty("CreateLead.Company.Id"), data);
		return this;
	}
	
	
	public CreateLeadPage enterFName(String data){		
		enterById("createLeadForm_firstName", data);	
		return this;
	}
	
	public CreateLeadPage enterLName(String data){		
		enterById("createLeadForm_lastName", data);	
		return this;
	}
	
	public ViewLeadPage clickCreateLead(){
		clickByName("submitButton");
		return new ViewLeadPage(driver, test);
	}

}

















