package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.FindLeadsPage;
import pages.LoginPage;
import wrappers.LeafTapsWrappers;

public class TC007_DuplicateLead extends LeafTapsWrappers{
	@BeforeClass
	public void setValues(){
		browserName = "chrome";
		dataSheetName = "TC007_DeleteLead";
		testCaseName = "Duplicate Lead";
		testDescription = "Duplicating a Lead Based and verifying the first name";
		category = "sanity";
		authors = "Tendulkar";		
	}
	
	@Test(dataProvider = "fetchData")
	public void deleteLead(String uName, String pwd, String email) throws InterruptedException{
		FindLeadsPage flp = new LoginPage(driver, test)
		.enterUserName(uName)
		.enterPassword(pwd)
		.clickLogin()
		.clickCrmSFa()
		.clickLeads()
		.clickFindLeads()
		.clickEmailTab()
		.enterEmail()
		.clickFindLeads();
		
		String firstLeadName = flp.getFirstNameOfFirstLead();
				
		flp.clickFirstLeadId()
		.clickDuplicateLeads()
		.clickCreateLead()
		.verifyFirstName(firstLeadName);
	}
}
