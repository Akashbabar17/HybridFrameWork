package com.Hybrid.Utilities;

import java.io.File;
import java.text.SimpleDateFormat;

import org.apache.poi.hpsf.Date;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentListenerClass implements ITestListener {
	
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;

	public void configureReports() {
		
		ReadConfig readConfig = new ReadConfig();
		String timestamp=new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		String reportName="HybridFrameWork-" + timestamp + ".html";
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//Reports//" + reportName);
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		//add system information/environment info to reports 
		reports.setSystemInfo("Machine:", "testpc1"); 
		reports.setSystemInfo("OS", "windows 11");
		reports.setSystemInfo("browser:", readConfig.getBrowser());
		reports.setSystemInfo("user name:","Akash Babar");
		
		//configuration to change look and feel of report
		htmlReporter.config().setDocumentTitle("Extent Listener Report Demo");
		htmlReporter.config().setReportName("This is my First Report");
		htmlReporter.config().setTheme(Theme.DARK);
		
		
	}
	
	
	
	@Override
	//On start method is called when any Test starts
	public void onTestStart(ITestResult result) {
		configureReports();
		System.out.println("On start method invoked...");
		
	}

	@Override
	//On 
	public void onTestSuccess(ITestResult result) {
		System.out.println("Name of Test case Success:"+result.getName());
		test= reports.createTest(result.getName());
		test.log(Status.PASS,MarkupHelper.createLabel("Name of Success test case is"+result.getName(), null));
		
	}

	@Override
	//when Test case is failed,This method is called.
	
	public void onTestFailure(ITestResult result) {
		System.out.println("Name of method failed:" +result.getName());
		test=reports.createTest(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case is:"+result.getName(),ExtentColor.RED));
		
		String screenshotPath=System.getProperty("user.dir")+"\\ScreenShots\\"+ result.getName()+".png";
		
		File ScreenShotFile =new File(screenshotPath);
		
		if(ScreenShotFile.exists())
		{
			test.fail("Captured screenshot is below:"+test.addScreenCaptureFromPath(screenshotPath));
		}
	}
	
	//When Test case get skipped, this method is called. 
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Name of Test case skipped:"+result.getName());
		test= reports.createTest(result.getName());
		test.log(Status.SKIP,MarkupHelper.createLabel("Name of skipped test case is"+result.getName(), ExtentColor.RED));
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	//OnFinish method is called after all the tests are executed
	public void onFinish(ITestContext context) {
		System.out.println("On Finish method is invoked...");
		reports.flush(); //it is mandatory to call flush method to ensure information is written to 
		
	}

	
	
}
