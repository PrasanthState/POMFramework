package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapsWrappers;

public class MyHomePage extends LeafTapsWrappers{

	public MyHomePage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		if(!verifyTitle("My Home | opentaps CRM")){
			reportStep("This in not My Home Page", "FAIL");
		}		
	}
	
	public MyLeadsPage clickLeads(){
		clickByLink("Leads");
		return new MyLeadsPage(driver, test);
	}

}