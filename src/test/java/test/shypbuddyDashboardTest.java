package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.TestNG;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utility.Reports;

public class shypbuddyDashboardTest {

public class ShypBuddyDashboardTest extends TestNG {
    private ShypBuddyDashboardTest dashboardPage;
    private ExtentReports reports;
    private ExtentTest test;

    @BeforeClass
    public void setUp() {
        initializeConfiguration();
        dashboardPage = new ShypBuddyDashboardPage(driver);
        reports = Reports.createReports();
    }

    @Test(priority = 1)
    public void verifyDashboardLogo() {
        test = reports.createTest("Verify Dashboard Logo");
        Assert.assertTrue(dashboardPage.isLogoDisplayed(), "Dashboard logo should be displayed");
    }

    @Test(priority = 2)
    
    public void verifyDashboardLogo1() {
        try {
            // Create test in ExtentReports
            test = reports.createTest("Verify Dashboard Logo");
            
            // Wait for logo to be visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='ShypBuddy-logo']")));
            
            // Verify logo is displayed
            boolean isLogoVisible = logo.isDisplayed();
            Assert.assertTrue(isLogoVisible, "Dashboard logo is not displayed");
            
            // Log success in ExtentReports
            test.log(Status.PASS, "Dashboard logo verification successful");
            
        } catch (Exception e) {
            // Log failure in ExtentReports
            test.log(Status.FAIL, "Failed to verify dashboard logo: " + e.getMessage());
            // Take screenshot on failure
            takeScreenshot("logo_verification_failure");
            throw e;
        }
    }

    @Test(priority = 3)
    public void verifyShipmentStatistics() {
        test = reports.createTest("Verify Shipment Statistics");
        
        // Verify the total shipments count matches with the expected value
        Assert.assertEquals(dashboardPage.getTotalShipments(), "159", 
            "Total shipments count should match");
        
        // Verify delivered shipments count
        Assert.assertEquals(dashboardPage.getDeliveredCount(), "47", 
            "Delivered shipments count should match");
    }

    private String getDeliveredCount() {
		// TODO Auto-generated method stub
		return null;
	}

	private String getTotalShipments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Test(priority = 4)
    public void verifyZoneDistribution() {
        test = reports.createTest("Verify Zone Distribution");
        
        Assert.assertEquals(dashboardPage.getZoneDistributionCount("WithinCity"), "46",
            "Within City count should match");
        Assert.assertEquals(dashboardPage.getZoneDistributionCount("WithinZone"), "1965",
            "Within Zone count should match");
        Assert.assertEquals(dashboardPage.getZoneDistributionCount("MetrotoMetro"), "1457",
            "Metro to Metro count should match");
        Assert.assertEquals(dashboardPage.getZoneDistributionCount("RestofIndia"), "525",
            "Rest of India count should match");
    }

    private String getZoneDistributionCount(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Test(priority = 5)
    public void verifyNSATRating() {
        test = reports.createTest("Verify NSAT Rating");
        String averageRating = dashboardPage.getAverageRating();
        Assert.assertEquals(averageRating, "3.3", 
            "Average NSAT rating should match");
    }

    private String getAverageRating() {
		// TODO Auto-generated method stub
		return null;
	}

	@AfterMethod
    public void logTestStatus(ITestResult result) {
        if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, result.getName() + " test passed");
        } else if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, result.getName() + " test failed");
            // Capture screenshot
            String screenshotPath = TestUtil.captureScreenshot(driver, result.getName());
            test.addScreenCaptureFromPath(screenshotPath);
        }
    }

    @AfterClass
    public void tearDown() {
        reports.flush();
        if (driver != null) {
            driver.quit();
        }
    }
}

public void takeScreenshot(String string) {
	// TODO Auto-generated method stub
	
}


}
