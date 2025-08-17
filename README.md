# AutomationExercise Project  

# How to Run the Script  

1. Clone the Project  

- Download or clone the project from the repository.  

- Open the project folder in Eclipse or IntelliJ IDEA.  

2. Run using Maven  

- Open a terminal inside the project folder.  

- Run the command: mvn clean test  

- This will execute all the test cases defined in testng.xml.  

3. Run using TestNG from IDE  

- Right-click on the testng.xml file.  

- Select Run As → TestNG Suite.  

4. Reports and Screenshots  

- Test reports are generated automatically in the test-output folder.    

- Screenshots of failed test cases are stored in the screenshots folder.  

# Tools Used  

- Selenium WebDriver – For automating browser actions.  

- TestNG – For test case management, assertions, and reporting.  

- Maven – For dependency management and build execution.  

- Page Object Model (POM) – For organizing test code and improving reusability.  

- Log4j – For logging execution steps and debugging.  

- Apache Commons IO – For handling file operations like saving screenshots.  

# Automated Scenarios  

1. Product Search  

- Open the homepage.  

- Search for a product.  

- Verify that the search results display the expected product.  

2. Add to Cart and Validate  

- Search for a product.  

- Add the product to the cart.  

- Navigate to the cart page.  

- Verify that the product name and price are correct.  
