package testBase;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utilities.ExtentManager;

public class TestListner  implements ITestListener{
	
	 ExtentReports extent = ExtentManager.getInstance();
	    ExtentTest test;

	    @Override
	    public void onTestStart(ITestResult result) {
	        test = extent.createTest(result.getMethod().getMethodName());
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        test.log(Status.PASS, "Test Passed");
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	        String screenshotPath = ((BaseClass) result.getInstance()).captureScreenshot(result.getMethod().getMethodName());
	        test.log(Status.FAIL, "Test Failed: " + result.getThrowable());
	        try {
	            test.addScreenCaptureFromPath(screenshotPath);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	        extent.flush();
	    }

}
