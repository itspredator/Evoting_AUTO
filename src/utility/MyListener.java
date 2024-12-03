package utility;

import org.testng.ITestListener;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class MyListener implements ITestListener {

	public ExtentSparkReporter SparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	static DriverFactory driverFactory;
	public static WebDriver driver;

	// Default constructor
	public MyListener() throws IOException {
		//setup();
	}
	
	public void setup() throws IOException
	{	
		ConfigReader configreader = new ConfigReader();
		driverFactory = new DriverFactory();
		String BrowserName = 	ConfigReader.getProprty("Browser");
		driver = driverFactory.init_driver(BrowserName);
	}
	

	@Override
	public void onFinish(ITestContext contextFinish) {
		System.out.println("INSIDE onFinish");
		extent.flush();
	}

	@Override
	public void onStart(ITestContext contextStart) {
		

		System.out.println("on test start.." + contextStart.getName());

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

			System.out.println("test Failed:" + result.getName());

			test = extent.createTest(result.getName());
			test.log(Status.FAIL, "Test case failed: " + result.getName());
			test.log(Status.FAIL, "Error: " + result.getThrowable());
			if (driver != null) {
				
				Capture_Defects def = new Capture_Defects(driver);
				try {
					String screenshotPath = "D:\\Pinkesh\\Evoting_Total\\defects_snapshot\\";
					Capture_Defects.takeSnapShot(screenshotPath, result);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		

		} finally {
			// Testpage.getDriver().close();
			// System.exit(0);
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test case skipped: " + result.getName());

	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test started: " + result.getName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "Test case passed: " + result.getName());

	}

}
