package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	WebDriver driver;
	 
	 public HomePage(WebDriver driver)
	 {
		super(driver);
	 }
	 
//	 @FindBy(xpath = "//a[normalize-space()='Signup / Login']")
//	 WebElement lnkSignupLogin;
	 
	 
	 @FindBy(xpath="//a[@href='/products']")
	 WebElement  productsLink;
	 
	 
//	 public void clickSignuplogin()
//	 {
//		 lnkSignupLogin.click();
//	 }
	 
	 
	 public void clickProducts()
	 {
		 productsLink.click();
	 }
	 

}
