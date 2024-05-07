package directMacroTestPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import directMacroPages.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import java.io.IOException;


//import directMacroPages.BaseClass;
//import directMacroPages.XpathClass;

public class DirectMacroTestCases {

	BaseClass base = new BaseClass();
	XpathClass dMxpath = new XpathClass();
	public WebDriver driver;
	public WebDriverWait wait;
	public ExtentReports extent;
	public ExtentTest test;
	
	
	@BeforeTest
	public void startChrome() 
	{
		  try {
		        base.setExtend();
		        extent = base.extent;
		    } catch (Exception e) {
		        System.err.println("Error during setup: " + e.getMessage());
		        throw new IllegalStateException("Failed to initialize reporting tools", e);
		    }
	}
	
	@AfterTest
	public void CloseChrome() 
	
	{
		 try {
		        base.CloseBrowser();
		        base.closeExtentReports();
		    } catch (Exception e) {
		        System.err.println("Error during teardown: " + e.getMessage());
		    }
		
	}
	
	@BeforeMethod
	public void setup() {
		driver = base.driver;
		base.gotoUrl(dMxpath.dMurl);
	}
	
	@Test (priority = 1)
	public void searchBarTestCase() throws InterruptedException
	{

		test = extent.createTest("Test case for searching functionality");
		base.gotoUrl(dMxpath.dMurl);
		base.waitUntilDisplayed(dMxpath.loaderDisplay);
		base.sendKeys(dMxpath.searchBar,dMxpath.searchData );
		base.forClick(dMxpath.searchButton);
		String expectedResult= base.getText(dMxpath.searchPageFirstRecord);
		base.verifyText(expectedResult,dMxpath.searchData);
		
	}
	
	@Test (priority = 2)
	public void addToCartTestCases()
	{
		test = extent.createTest("Adding a product to the cart and assert quantity");
		base.gotoUrl(dMxpath.storagePageUrl);
		base.verifyCurrentUrl(base.getUrl(), dMxpath.storagePageUrl);
		base.forClick(dMxpath.storagePageFirstProduct);
		base.forClick(dMxpath.addToCart);
		String checkOutPageQty = base.getText(dMxpath.checkOutPageQty);
		base.verifyText(checkOutPageQty,dMxpath.productPageQty);
	}
	
	@Test (priority = 3)
	public void productQuantityValidation()
	{
		test= extent.createTest("Check min/max product quantity");
		base.gotoUrl(dMxpath.dMurl);
		base.forClick(dMxpath.homePageProduct);
		
		//check with negative Value
		base.clear(dMxpath.productPageQuantity);
		base.sendKeys(dMxpath.productPageQuantity, "0");
		base.forClick(dMxpath.addToCart);
		base.verifyText(base.getText(dMxpath.productZeroQtyCheck), dMxpath.productZeroQtyErrorMessage);

		//check with max allowed value
		base.clear(dMxpath.productPageQuantity);
		base.sendKeys(dMxpath.productPageQuantity, "10001");
		base.forClick(dMxpath.addToCart);
		base.verifyText(base.getText(dMxpath.productMaxQtyCheck), dMxpath.productMaxQtyErrorMessage);

	}
	
	@Test (priority = 4)
	public void checkoutFormValidationVerfication() throws InterruptedException {
		test = extent.createTest("Check form validation on check out pages");
		base.gotoUrl(dMxpath.storagePageUrl);
		base.verifyCurrentUrl(base.getUrl(), dMxpath.storagePageUrl);
		base.forClick(dMxpath.storagePageFirstProduct);
		base.forClick(dMxpath.addToCart);
		
		base.sendKeys(dMxpath.checkoutEmail,"testteam@yopmail.com");
		base.sendKeys(dMxpath.checkoutFirstName,"Test");
		base.sendKeys(dMxpath.checkoutLastName,"Test");
		base.sendKeys(dMxpath.checkoutCompanyName,"Test");
		base.sendKeys(dMxpath.checkoutAddress1,"Test");
		base.selectDropdownByVisibleText(dMxpath.checkoutCountry, "United States");
		base.selectDropdownByVisibleText(dMxpath.checkoutRegion, "Alabama");
		base.sendKeys(dMxpath.checkoutCity,"Test");
		base.sendKeys(dMxpath.checkoutPostalCode,"75260");
		base.sendKeys(dMxpath.checkoutPhone,"03333344445");
		base.forClick(dMxpath.placOrderButton);
		base.verifyText(base.getText(dMxpath.errorMessageToast), dMxpath.errorToast);
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
	    if(result.getStatus() == ITestResult.FAILURE) {
	        test.log(Status.FAIL, "Test Case Failed is " + result.getName());
	        test.log(Status.FAIL, "Test Case Failed is " + result.getThrowable());
	        String screenshotPath = base.getScreenShot(driver, result.getName());
	        test.addScreenCaptureFromPath(screenshotPath);
	        
	    }
	    else if(result.getStatus() == ITestResult.SKIP) {
	        test.log(Status.SKIP, "Test Case Skipped is " + result.getName());
	    }
	    else if(result.getStatus() == ITestResult.SUCCESS) {
	        test.log(Status.PASS, "Test Case Passed is " + result.getName());
	    }
	}
}
