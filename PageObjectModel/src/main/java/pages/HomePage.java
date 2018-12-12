package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapsWrappers;

public class HomePage extends LeafTapsWrappers{

	public HomePage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		if(!verifyTitle("Opentaps Open Source ERP + CRM")){
			reportStep("This in not Home Page", "FAIL");
		}		
	}
	
	
	public LoginPage clickLogOut(){
		clickByClassName("decorativeSubmit");
		//LoginPage lp = new LoginPage();
		return new LoginPage(driver, test);		
	
	}
	
	public MyHomePage clickCrmSFa(){
		clickByLink("CRM/SFA");
		return new MyHomePage(driver, test);
	}

}



























