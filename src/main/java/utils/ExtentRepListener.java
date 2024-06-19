package utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import base.ReusableFunctions;

public class ExtentRepListener implements ITestListener {
	
	public static ExtentSparkReporter Reporter;
	public static WebDriver driver;
	public ExtentReports extent;
	public ExtentTest test;
	String timestamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

	public void onStart(ITestContext context) {
		try {
			String repname="TestReport-"+ timestamp+".html";
			Reporter = new ExtentSparkReporter(System.getProperty("user.dir")+"//Reports_Folder//"+repname);
			Reporter.loadXMLConfig(System.getProperty("user.dir")+"\\src\\test\\resources\\extent-config1.xml");
			extent = new ExtentReports();
			extent.attachReporter(Reporter);
			extent.setSystemInfo("OS", "Windows");
			extent.setSystemInfo("Host Name", "localhost");
			extent.setSystemInfo("Environment", "QA");
			extent.setSystemInfo("User Name", "Akshay");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void onTestStart(ITestResult result) {
		test=extent.createTest(result.getName());
	}
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test case passed");
		test.log(Status.PASS, MarkupHelper.createLabel(result.getName(),
				ExtentColor.GREEN));
		String folder=result.getInstanceName();
		String nameoftest=result.getName();
		String filepath=System.getProperty("user.dir")+"//TestResult//Screenshots"+folder+"//"+
				nameoftest+"//"+nameoftest+timestamp+"_passed.png";
		try {
			ReusableFunctions.takeScreenshot(DriverUtils.driver,filepath);
			test.log(Status.PASS,"Adding screenshot");
			test.addScreenCaptureFromPath(filepath);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Test case Failed");
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(),
				ExtentColor.RED));
		String folder=result.getInstanceName();
		String nameoftest=result.getName();
		String filepath=System.getProperty("user.dir")+"//TestOutput//Screenshots"+folder+"//"+
				nameoftest+"//"+nameoftest+timestamp+"_failed.png";
		try {
			ReusableFunctions.takeScreenshot(DriverUtils.driver,filepath);
			test.log(Status.FAIL,"Adding screenshot");
			test.addScreenCaptureFromPath(filepath);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "Test case Skipped");
		test.log(Status.SKIP, MarkupHelper.createLabel(result.getName(),
				ExtentColor.AMBER));
	}
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}