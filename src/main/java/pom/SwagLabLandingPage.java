package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SwagLabLandingPage {

@FindBy (xpath="//button[text()='Add to cart']") private List<WebElement> addToCart;
@FindBy (xpath="//button[text()='Remove']") private List<WebElement> removeFromCart;
@FindBy (xpath="//button[@id='react-burger-menu-btn']") private WebElement pageOptions;
@FindBy (xpath="//a[@id='inventory_sidebar_link']") private WebElement allIteams;
@FindBy (xpath="a[id='about_sidebar_link']") private WebElement about;
@FindBy (xpath="a[id='logout_sidebar_link']") private WebElement logout;
@FindBy (xpath="a[id='reset_sidebar_link']") private WebElement resetApp;
@FindBy (xpath="a[class='shopping_cart_link']") private WebElement cart;
@FindBy (xpath="select[class='product_sort_container']") private WebElement filter;
@FindBy (xpath="//a[@class='shopping_cart_link']") private WebElement Cart;

@FindBy (xpath="a[href='https://twitter.com/saucelabs']") private WebElement twitter;
@FindBy (xpath="a[href='https://www.facebook.com/saucelabs']") private WebElement facebook;
@FindBy (xpath="a[href='https://www.linkedin.com/company/sauce-labs/']") private WebElement linkedin;

public	SwagLabLandingPage (WebDriver driver) {
	PageFactory.initElements(driver, this);
}
	
	public void addProductToCart(int i) {
		addToCart.get(i).click();
	}
	public void removeProductFromCart(int product) {
		removeFromCart.get(product).click();
	}
	

	public void clickOnPageOptions() {
		pageOptions.click();
	}
	
	public void clickOnAllIteams() {
		allIteams.click();
	}
	public void clickOnAbout() {
		about.click();
	}
	public void clickOnLogout() {
		logout.click();
	}
	public void clickOnResetApp() {
		resetApp.click();
	}
	public void clickOnCart() {
		cart.click();
	}
	public void clickOnFilter() {
		filter.click();
		Select s= new Select (filter);
			s.selectByIndex(1);	
	}
	
	public void clickOnTwitter() {
		twitter.click();
	}
	public void clickOnFacebook() {
		facebook.click();
	}
	public void clickOnLinkedin() {
		linkedin.click();
	}
	
	public boolean isRemoveButtonDisplayed(int product) {
		boolean result=removeFromCart.get(product).isDisplayed();
		return result;
	}
	
	public void addMultipleProductToCart() {
		
		
		
		
	}
	
	
	
	
	
	
	
	
}
