package test;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.Browser;
import pom.SwagLabLandingPage;
import pom.SwagLabLogInPage;
import utility.BaseClass;
import utility.Reports;
@Listeners(utility.Listeners.class)
public class SwagLabHomePage2 extends BaseClass{
 ExtentReports reports;
 ExtentTest test;
	@BeforeTest
	public void configureReport() {
		reports=Reports.createReport();
	}
	@BeforeMethod
	public void launchBrowser() {
		driver=Browser.openBrowser();
		SwagLabLogInPage login = new SwagLabLogInPage(driver);
		login.enterUsename("standard_user");
		login.enterPassword("secret_sauce");
		login.clickOnLogin();
	}
	
	@Test 
	public void verifyAddCartFunctinality() {
		test=reports.createTest("verifyAddCartFunctinality");
		SwagLabLandingPage  swagLab = new SwagLabLandingPage(driver);
		for(int i=0;i<3;i++) {
		swagLab.addProductToCart(i);
		}
		for(int i=3;i<6;i++) {
			swagLab.addProductToCart(i);
			}
	}
	@AfterMethod
	public void logReport(ITestResult result) {
	 if (result.getStatus()==ITestResult.SUCCESS) {
		 test.log(Status.PASS, result.getName());
	 }else if (result.getStatus()==ITestResult.FAILURE) {
		 test.log(Status.FAIL, result.getName());
	 } else {
		 test.log(Status.SKIP, result.getName());
	 }
	}
	
	@AfterTest
	public void clearReport() {
		reports.flush();
	}
	
	
}
