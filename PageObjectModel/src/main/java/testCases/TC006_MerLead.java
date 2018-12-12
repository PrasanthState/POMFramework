package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.LeafTapsWrappers;

public class TC006_MerLead extends LeafTapsWrappers{
	@BeforeClass
	public void setValues(){
		browserName = "chrome";
		dataSheetName = "TC006_MergeLead";
		testCaseName = "Merge Lead";
		testDescription = "Merging two leads and confirming the lead is not present after merging";
		category = "sanity";
		authors = "Tendulkar";		
	}
	
	@Test(dataProvider = "fetchData")
	public void merLead(String uName, String pwd, String lead1, String lead2) throws InterruptedException{
		new LoginPage(driver, test)
		.enterUserName(uName)
		.enterPassword(pwd)
		.clickLogin()
		.clickCrmSFa()
		.clickLeads()
		.clickMergeLeads()
		.clickFirstIcon()
		.enterLead(lead1)
		.clickFindLeads()
		.clickFirstLeadId()
		.clickSecondIcon()
		.enterLead(lead2)
		.clickFindLeads()
		.clickFirstLeadId()
		.clickMerge()
		.clickFindLeads()
		.enterLeadId(lead1)
		.clickFindLeads()
		.verifyLeadNotPresent("No records to display");
	}
}
