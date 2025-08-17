package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductsPage;
import testBase.BaseClass;

public class TC001_ProductSearchPage extends BaseClass {
	
	  @Test
	    public void verifyProductSearch(){
		  
		  
	        HomePage home = new HomePage(driver);
	        home.clickProducts();
	        

	        ProductsPage products = new ProductsPage(driver);
	        products.searchProduct("Tshirt");
	        

	        String result = products.getFirstProductName();
	        
	        
	        Assert.assertTrue(result.toLowerCase().contains("tshirt"), 
	                "Search results do not match expected product!");
	    }

}
