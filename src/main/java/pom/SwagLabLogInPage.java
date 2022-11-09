package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.BaseClass;

public class SwagLabLogInPage extends BaseClass {

	
	@FindBy (xpath="//input[@id='user-name']") private WebElement userName;
	@FindBy (xpath="//input[@id='password']") private WebElement password;
	@FindBy (xpath="//input[@id='login-button']") private WebElement login;
	
	public SwagLabLogInPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterUsename(String name) {
	//	userName.sendKeys(name);
		WebDriverWait   wait = new WebDriverWait(driver,Duration.ofSeconds(10000));
		wait.until(ExpectedConditions.visibilityOf(userName));
		userName.sendKeys(name);
	}
	public void enterPassword(String pass) {
		//password.sendKeys(pass);
		FluentWait<WebDriver>  wait = new FluentWait<WebDriver>(driver);
		
		wait.withTimeout(Duration.ofMillis(10000));
		wait.pollingEvery(Duration.ofMillis(2000));
		wait.ignoring(Exception.class);
		wait.until(ExpectedConditions.visibilityOf(password));
		password.sendKeys(pass);
	}
	
	public void clickOnLogin() {
		login.click();
	}
	
	
}
