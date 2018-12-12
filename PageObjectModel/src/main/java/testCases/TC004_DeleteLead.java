package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.FindLeadsPage;
import pages.LoginPage;
import wrappers.LeafTapsWrappers;

public class TC004_DeleteLead extends LeafTapsWrappers{
	@BeforeClass
	public void setValues(){
		browserName = "chrome";
		dataSheetName = "TC004_DeleteLead";
		testCaseName = "Delete Lead";
		testDescription = "Deleting a Lead Based on Phone Number Search";
		category = "sanity";
		authors = "Tendulkar";		
	}
	
	@Test(dataProvider = "fetchData")
	public void deleteLead(String uName, String pwd, String pNum3) throws InterruptedException{
		FindLeadsPage flp = new LoginPage(driver, test)
		.enterUserName(uName)
		.enterPassword(pwd)
		.clickLogin()
		.clickCrmSFa()
		.clickLeads()
		.clickFindLeads()
		.clickPhoneTab()
		//.enterphoneNumb1(pNum1)
		//.enterphoneNumb2(pNum2)
		.enterphoneNumb3(pNum3)
		.clickFindLeads();
		
		String firstLeadId = flp.getFirstLeadId();
		
		flp.clickFirstLeadId()
		.clickDelete()
		.clickFindLeads()
		.enterLeadId(firstLeadId)
		.clickFindLeads()
		.verifyLeadNotPresent("No records to display");
		
		
	}
}
