package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.LeafTapsWrappers;

public class TC002_LoginNegative extends LeafTapsWrappers {
	
	@BeforeClass
	public void setValues(){
		browserName = "chrome";
		dataSheetName = "TC005";
		testCaseName = "Login(Negative)";
		testDescription = "Validate Login Error Msg";
		category = "Sanity";
		authors = "Babu";		
	}
	
	@Test(dataProvider = "fetchData")
	public void loginLogOut(String uName, String pwd, String msg){
		new LoginPage(driver, test)
		.enterUserName(uName)
		.enterPassword(pwd)
		.clickLoginForFailure()
		.verifyMsg(msg);
	}
	
	
}










