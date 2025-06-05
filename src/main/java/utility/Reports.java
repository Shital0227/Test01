package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {
	public static ExtentReports createReports() {
		//ExtentReports reports = new ExtentReports();
		ExtentSparkReporter htmlReports = new ExtentSparkReporter ("test-output/ExtentReport.html");
		ExtentReports reports = new ExtentReports();
		reports.attachReporter(htmlReports);
		
		//reports.setSystemInfo("Application","ShypBYDDY");
		//reports.setSystemInfo("TestType","Regression");
		//reports.setSystemInfo("Created by","Sheetal Jadhav");
		return reports;
		
	}

}
