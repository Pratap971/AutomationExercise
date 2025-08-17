package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;


import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.ProductsPage;
import testBase.BaseClass;



public class TC002_CartTest extends BaseClass{
	
	 @Test
	    public void verifyAddToCart() {
		 
		 logger.info("Navigating to Products page");
	        HomePage home = new HomePage(driver);
	        home.clickProducts();

	        
	        logger.info("Searching for product: Tshirt");
	        ProductsPage products = new ProductsPage(driver);
	        products.searchProduct("Tshirt");

	        String expectedProductName = products.getFirstProductName();
	        products.addFirstProductToCart();
	        logger.info("Added product to cart");

	        CartPage cart = new CartPage(driver);

	        
	        Assert.assertEquals(cart.getProductName(), expectedProductName,
	                " Product name in cart does not match!");
	        logger.info("Verified product name matches");
              
	        
	        Assert.assertTrue(cart.getProductPrice().contains("Rs."),
	                " Product price is not displayed correctly!");
	        
	        logger.info("Verified product price is displayed correctly");
	    }

}
