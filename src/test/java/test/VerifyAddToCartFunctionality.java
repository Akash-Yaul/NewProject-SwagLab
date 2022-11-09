package test;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.Browser;
import pom.SwagLabLandingPage;
import pom.SwagLabLogInPage;
import utility.BaseClass;
import utility.Reports;

public class VerifyAddToCartFunctionality extends BaseClass{

	ExtentReports reports;
	ExtentTest test;
	@BeforeTest
	public void configureReport() {
	 reports=	Reports.createReport();
	}
	
	@BeforeMethod
	public void launchBrowser() {
		 driver=Browser.openBrowser();
	}
	
	@Test
	public void verifyAddToCartFunctionality() {
		test=reports.createTest("loginWithValidCredentials");
		SwagLabLogInPage  swagLab= new SwagLabLogInPage (driver);
		swagLab.enterUsename("standard_user");
		swagLab.enterPassword("secret_sauce");
		swagLab.clickOnLogin();
		SwagLabLandingPage  landingPage = new SwagLabLandingPage (driver);
		landingPage.addProductToCart(1);
		Assert.assertTrue(landingPage.isRemoveButtonDisplayed(1));
		
			}
	
	public void verifyMultipleAddToCartButtons() {
		test=reports.createTest("loginWithValidCredentials");
		SwagLabLogInPage  swagLab= new SwagLabLogInPage (driver);
		swagLab.enterUsename("standard_user");
		swagLab.enterPassword("secret_sauce");
		swagLab.clickOnLogin();
		SwagLabLandingPage  landingPage = new SwagLabLandingPage (driver);
		
		
		
		
	}
	
	@AfterMethod
	public void getTestResults(ITestResult result) {
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS,result.getName());
		}
		else if (result.getStatus()==ITestResult.FAILURE) 
		{
			test.log(Status.FAIL, result.getName());
		} else
		{
			test.log(Status.SKIP, result.getName());
		}
	}
	@AfterTest
	public void publishResult() {
		reports.flush();
	}
	
	
}
