package testBase;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class BaseClass {

    public static WebDriver driver;
    public static final Logger logger = LogManager.getLogger(BaseClass.class);

    @BeforeClass
    public void setUp() {
        logger.info("Launching Chrome Browser...");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        logger.info("Navigating to AutomationExercise website...");
        driver.get("https://automationexercise.com/");
    }

    
    @AfterMethod
    public void resetState() {
        logger.info("Resetting to homepage...");
        driver.get("https://automationexercise.com/");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public String captureScreenshot(String testName) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = "screenshots/" + testName + ".png";
        try {
            FileUtils.copyFile(src, new File(path));
            logger.info("Screenshot captured: " + path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }
}
