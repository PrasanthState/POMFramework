package utils;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import wrappers.GenericWrappers;

public abstract class Reporter {
	
	public static final ThreadLocal<GenericWrappers> driverTestThreadLocal = new ThreadLocal<GenericWrappers>();

	public ExtentTest test;
	public static ExtentReports extent;
	public String testCaseName, testDescription, category, authors;
	public String browserName;
	public String dataSheetName;
	//public int testNumber = 0;

	/*public int getTestNumber() {
		return testNumber;
	}

	public void setTestNumber(int testNumber) {
		this.testNumber = testNumber;
	}*/

	/*public ExtentTest getTest() {
		return driverTestThreadLocal.get().test;
	}*/
	
	public void reportStep(String desc, String status, boolean bSnap) {

		long snapNumber = 100000l;
		
		try {
			snapNumber= takeSnap();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (bSnap && !status.toUpperCase().equals("INFO")) {
		// Write if it is successful or failure or information
			if(status.toUpperCase().equals("PASS")){
				test.log(LogStatus.PASS, desc+test.
						addScreenCapture("./../reports/images/"+snapNumber+".jpg"));
			}else if(status.toUpperCase().equals("FAIL")){
				test.log(LogStatus.FAIL, desc+test.addScreenCapture("./../reports/images/"+snapNumber+".jpg"));
				throw new RuntimeException("FAILED");
			}else if(status.toUpperCase().equals("INFO")){
				test.log(LogStatus.INFO, desc);
			}else if(status.toUpperCase().equals("WARN")){
				test.log(LogStatus.WARNING, desc+test.addScreenCapture("./../reports/images/"+snapNumber+".jpg"));
			}
		}
	}

	public void reportStep(String desc, String status) {
		reportStep(desc, status, true);
	}
	
	public abstract long takeSnap();
	

	public ExtentReports startResult(){
		extent = new ExtentReports("./reports/result.html", false);
		extent.loadConfig(new File("./src/main/resources/extent-config.xml"));
		return extent;
	}

	public ExtentTest startTestCase(String testCaseName, String testDescription){
		test = extent.startTest(testCaseName, testDescription);
		return test;
	}

	public void endResult(){		
		extent.flush();
	}

	public void endTestcase(){
		extent.endTest(test);
	}
	
}