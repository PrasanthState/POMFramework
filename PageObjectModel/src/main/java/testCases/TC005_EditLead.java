package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.LeafTapsWrappers;

public class TC005_EditLead extends LeafTapsWrappers{
	@BeforeClass
	public void setValues(){
		browserName = "chrome";
		dataSheetName = "TC005_EditLead";
		testCaseName = "Edit Lead";
		testDescription = "Editing a Lead Based by updating the company name";
		category = "sanity";
		authors = "Tendulkar";		
	}
	
	@Test(dataProvider = "fetchData", invocationCount = 2, threadPoolSize=2)
	public void editLead(String uName, String pwd, String fName, String compName) throws InterruptedException{
		//new GenericWrappers(driver, test);
		new LoginPage(driver, test)
		.enterUserName(uName)
		.enterPassword(pwd)
		.clickLogin()
		.clickCrmSFa()
		.clickLeads()
		.clickFindLeads()
		.enterfirstName(fName)
		.clickFindLeads()
		.clickFirstLeadId()
		.clickEdit()
		.enterCompany(compName)
		.clickUpdate()
		.verifyCompName(compName);
	}
}
