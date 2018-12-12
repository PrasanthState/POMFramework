package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.LeafTapsWrappers;

public class TC003_CreateLead extends LeafTapsWrappers{
	@BeforeClass
	public void setValues(){
		browserName = "chrome";
		dataSheetName = "TC002_CreateLead";
		testCaseName = "Create Lead";
		testDescription = "Creatin a Lead ";
		category = "sanity";
		authors = "Tendulkar";		
	}
	
	@Test(dataProvider = "fetchData", invocationCount=2, threadPoolSize=2)
	public void createLead(String uName, String pwd, String fName, String lName, String compName){
		new LoginPage(driver, test)
		.enterUserName(uName)
		.enterPassword(pwd)
		.clickLogin()
		.clickCrmSFa()
		.clickLeads()
		.clickCreateLead()
		.enterFName(fName)
		.enterLName(lName)
		.enterCompany(compName)
		.clickCreateLead()
		.verifyFirstName(fName);
		
		
		/*LoginPage lp = new LoginPage(driver, test);
		lp.enterUserName(uName);
		lp.enterPassword(pwd);
		HomePage p = lp.clickLogin();
		MyHomePage mp = p.clickCrmSFa();
		MyLeadsPage mlp = mp.clickLeads();
		CreateLeadPage cl = mlp.clickCreateLead();
		cl.enterFName(fName);
		cl.enterLName(lName);
		cl.enterCompany(compName);
		ViewLeadPage vp = cl.clickCreateLead();
		vp.verifyFirstName(fName);*/
		
	}
}
















