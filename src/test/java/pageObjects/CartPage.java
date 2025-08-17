package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage {
	
	 WebDriverWait wait;
	
	 public CartPage(WebDriver driver) {
	        super(driver);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
	        wait.until(ExpectedConditions.urlContains("view_cart"));
	    }

	 @FindBy(xpath = "//td[@class='cart_description']//a")
	    WebElement productName;

	    @FindBy(xpath = "//td[@class='cart_price']//p")
	    WebElement productPrice;

	    public String getProductName() {
	        return wait.until(ExpectedConditions.visibilityOf(productName)).getText();
	    }

	    public String getProductPrice() {
	        return wait.until(ExpectedConditions.visibilityOf(productPrice)).getText();
	    }

}
