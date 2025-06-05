package test;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.Browser;
import pom.ShypBuddyLoginPage;
import utility.Reports;

public class shypBuddyLoginTest extends BaseTest {
	WebDriver driver ;
	ExtentReports reports;
	ExtentTest test;
	ShypBuddyLoginPage loginPage;
	@BeforeTest
	public void ConfigureReports()
	{
		 reports=Reports.createReports();
	}
	
	@BeforeTest
	@Parameters("Browsers")
	public void openbrowser(String browser)
	{
	 driver=Browser.launchBrowser(browser);
	 loginPage = new ShypBuddyLoginPage(driver);
	}
	@Test
	public void verifyLoginofShypBUDDY() throws EncryptedDocumentException, IOException
	{
		test=reports.createTest(" VerifyloginofShypBUDDY()");
		// shypBuddyLoginTest  verifyLoginofShypBUDDY=new shypBuddyLoginTest();
		 
		 loginPage.enterUsername("shitalj0227@gmail.com");
	        loginPage.enterPassword("Sheetal@2025");
	        loginPage.clickContinueButton();

		
		 
		 
}
	@AfterMethod
	public void captureResults(ITestResult result)
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			 test.log(Status.PASS, result.getName());

		}
		else if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL, result.getName());
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			test.log(Status.SKIP, result.getName());

		}
	}
	@AfterTest
	public void PublishReport()
	{
		reports.flush();
	}
}





