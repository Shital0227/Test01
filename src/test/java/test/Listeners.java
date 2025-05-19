package test;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import utility.ScreenShot;

public class Listeners extends BaseTest implements ITestListener  {
	public void onTestStart(ITestResult result)  {
		System.out.println("Test started "+result.getName());
	}
	public void onTestFailure(ITestResult result)  {
		
		try {
			ScreenShot.takeScrenshot(result.getName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void onTestSkipped(ITestResult result)   {
		System.out.println("Test Skipped"+result.getName());
	}
	public void onTestSuccess(ITestResult result)   {
		System.out.println("Test Success "+result.getName());
	}

}


