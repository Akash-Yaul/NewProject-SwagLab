package utility;

import java.io.IOException;


import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners extends BaseClass implements ITestListener {
	//WebDriver driver;  cant declare here .so need base class here.
	
	public void onTestStart(ITestResult result) {
		
	}
	
	public void onTestSuccess(ITestResult result) {
		
	}

	public void onTestSkipped(ITestResult result) {
		
	}
	
	public void onTestFailure(ITestResult result) {
		try {
			Screenshot.takeScreenshot(result.getName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}






}
