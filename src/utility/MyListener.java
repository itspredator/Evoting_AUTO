package utility;

import org.testng.ITestListener;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.reporters.jq.TestPanel;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Testfinalpage.Testpage;

public class MyListener implements ITestListener {



	public ExtentSparkReporter SparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	WebDriver driver;
	
	 // Default constructor
    public MyListener() {
    }

	@Override
	public void onFinish(ITestContext contextFinish) {
		System.out.println("INSIDE onFinish");
		extent.flush();
	}

	@Override
	public void onStart(ITestContext contextStart) {
		
		System.out.println("on test start..");

		SparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/Myreports.html");

		SparkReporter.config().setDocumentTitle("Automation Report");
		SparkReporter.config().setReportName("fucntional testing");
		SparkReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(SparkReporter);

		extent.setSystemInfo("Computer name", "localhost");
		extent.setSystemInfo("Environment", "Testing UAT");
		extent.setSystemInfo("Tester Name", "Pinkesh");
		extent.setSystemInfo("OS", "Windows 11");
		extent.setSystemInfo("Browser", "Chrome");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Method failed with certain success percentage" + result.getName());

	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		try {
			System.out.println("on test failure..");
			
			test = extent.createTest(result.getName());
			test.log(Status.FAIL, "test case passed is" + result.getName());
			test.log(Status.FAIL, "test case passed is" + result.getThrowable());
			Capture_Defects def= new Capture_Defects();
			try {
				
				def.takeSnapShot("D:\\Pinkesh\\EVOTINGAUTOMATION\\defects_snapshot\\", result);
			} 
			catch (Exception e) {
				e.printStackTrace();
			}

		} finally {
			//Testpage.getDriver().close();
			//System.exit(0);
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "test case skipped is" + result.getName());

	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Method started" + result.getName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "test case passed is" + result.getName());

	}

}
