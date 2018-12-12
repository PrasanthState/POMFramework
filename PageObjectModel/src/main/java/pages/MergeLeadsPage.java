package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapsWrappers;

public class MergeLeadsPage extends LeafTapsWrappers{

	public MergeLeadsPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		if(!verifyTitle("Merge Leads | opentaps CRM")){
			reportStep("This in not Merge Lead Page", "FAIL");
		}		
	}
	
	public MergeFindLeadsPage clickFirstIcon(){
		clickByXpathNoSnap("(//img[@alt='Lookup'])[1]");
		switchToLastWindow();
		return new MergeFindLeadsPage(driver, test);
	}

	public MergeFindLeadsPage clickSecondIcon(){
		clickByXpathNoSnap("(//img[@alt='Lookup'])[2]");
		switchToLastWindow();
		return new MergeFindLeadsPage(driver, test);
	}
	
	public ViewLeadPage clickMerge() {
		clickByLinkNoSnap("Merge");
		acceptAlert();
		return new ViewLeadPage(driver, test);
	}
}






