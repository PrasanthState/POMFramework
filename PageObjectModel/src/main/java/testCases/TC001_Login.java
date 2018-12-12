package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.LoginPage;
import utils.TestListener;
import wrappers.LeafTapsWrappers;

@Listeners({TestListener.class})
public class TC001_Login extends LeafTapsWrappers {
	
	@BeforeClass
	public void setValues(){
		browserName = "chrome";
		dataSheetName = "TC001";
		testCaseName = "Login";
		testDescription = "Login to LeafTaps and LogOut";
		category = "smoke";
		authors = "Gopi";		
	}
	
	@Test(dataProvider = "fetchData", invocationCount = 1, threadPoolSize=1)
	public void loginLogOut(String testNumber, String uName, String pwd){
		//setTestNumber(Integer.parseInt(testNumber));
		new LoginPage(driver, test)
		.enterUserName(uName)
		.enterPassword(pwd)
		.clickLogin();
		//.clickLogOut();		
	}

}










