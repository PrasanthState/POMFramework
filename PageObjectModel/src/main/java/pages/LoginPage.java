package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapsWrappers;

public class LoginPage extends LeafTapsWrappers{

	public LoginPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		if(!verifyTitle("Opentaps Open Source ERP + CRM")){
			reportStep("This in not Login Page", "FAIL");
		}		
	}

	public LoginPage enterUserName(String data){
		enterById("username", data);
		return this;
	}
	
	
	public LoginPage enterPassword(String data){		
		enterByName("PASSWORD", data);	
		return this;
	}
	
	public HomePage clickLogin(){
		clickByClassName("decorativeSubmit");
		return new HomePage(driver, test);
	}
	
	public LoginPage clickLoginForFailure(){
		clickByClassName("decorativeSubmit");
		return this;
	}
	
	public LoginPage verifyMsg(String text){
		verifyTextContainsById("errorDiv", text);
		return this;
	}

}

















