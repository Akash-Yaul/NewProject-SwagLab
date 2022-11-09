package test;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.Browser;
import pom.SwagLabLogInPage;
import utility.BaseClass;
import utility.Parametrization;
import utility.Reports;

@Listeners(utility.Listeners.class)
public class SwagLabLoginTesting extends BaseClass {
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
	@DataProvider (name="LoginData")
	public Object [][] data(){
		return new Object[][] {{"standard_user","secret_sauce"},{"locked_out_user","secret_sauce"},{"problem_user","secret_sauce"}};
		
	}
	
	@Test (dataProvider ="LoginData")
	public void loginWithValidCredentials(String user,String pass) throws EncryptedDocumentException, IOException {
		test=reports.createTest("loginWithValidCredentials");
		SwagLabLogInPage  swagLab= new SwagLabLogInPage (driver);
		swagLab.enterUsename(user);
		swagLab.enterPassword(pass);
		swagLab.clickOnLogin();
		//String value=Parametrization.getExcelData("sheet3", 9, 2);
			
		SoftAssert   s = new SoftAssert();
		String expectedUrl ="http//SwagLab//Home";
		s.assertEquals(driver.getCurrentUrl(),expectedUrl );
		System.out.println("Url is matching");
		s.assertAll();
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
