package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapsWrappers;

public class EditLeadPage extends LeafTapsWrappers{

	public EditLeadPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		if(!verifyTitle("opentaps CRM")){
			reportStep("This in not Edit Lead Page", "FAIL");
		}		
	}

	public EditLeadPage enterCompany(String data){
		enterById("updateLeadForm_companyName", data);
		return this;
	}
	
	public ViewLeadPage clickUpdate(){
		clickByXpath("//input[@value='Update']");
		return new ViewLeadPage(driver, test);
	}

}

















