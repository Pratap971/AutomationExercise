package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage extends BasePage{
	
	 WebDriverWait wait;
	
	 public ProductsPage(WebDriver driver) {
	        super(driver);
	        
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }

	    @FindBy(id = "search_product")
	    WebElement searchBox;

	    @FindBy(id = "submit_search")
	    WebElement searchButton;

	    @FindBy(xpath = "(//div[@class='productinfo text-center']/p)[1]")
	    WebElement firstProductName;

	    @FindBy(xpath = "(//a[contains(text(),'Add to cart')])[1]")
	    WebElement firstAddToCartBtn;

	    @FindBy(xpath = "//u[normalize-space()='View Cart']")
	    WebElement viewCartLink;

	    public void searchProduct(String productName) {
	        wait.until(ExpectedConditions.visibilityOf(searchBox)).clear();
	        searchBox.sendKeys(productName);
	        searchButton.click();
	    }

	    public String getFirstProductName() {
	        return wait.until(ExpectedConditions.visibilityOf(firstProductName)).getText();
	    }

	    public void addFirstProductToCart() {
	        wait.until(ExpectedConditions.elementToBeClickable(firstAddToCartBtn)).click();
	        wait.until(ExpectedConditions.elementToBeClickable(viewCartLink)).click();
	    }
}
