package pojo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {
	
	
	public static WebDriver openBrowser() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver   driver  =  new  ChromeDriver ();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
	return driver;
		
	}

}
