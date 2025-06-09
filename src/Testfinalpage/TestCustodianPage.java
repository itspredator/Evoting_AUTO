package Testfinalpage;

import java.awt.AWTException;
import java.io.IOException;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import custodian.custodianmodule;
import utility.ConfigReader;
import utility.DriverFactory;
import utility.MyListener;
import utility.loginpage;


@Listeners(utility.MyListener.class)

public class TestCustodianPage {
	private static final Logger logger = LogManager.getLogger(TestCustodianPage.class);
	static DriverFactory driverFactory;
	public static WebDriver driver;
	ConfigReader configReader;
	static String even_no;
	static loginpage login;
	custodianmodule cust;


	@BeforeTest
	public void setup() throws IOException {
		ConfigReader configreader = new ConfigReader();
		driverFactory = new DriverFactory();
		String BrowserName = ConfigReader.getProprty("Browser");
		driver = driverFactory.init_driver(BrowserName);
		login = new loginpage(driver);
		cust = new custodianmodule(driver);
		MyListener.setDriver(driver);
	}

	@Test(priority = 1)
	public void testcommonloginpages()
			throws InterruptedException, ClassNotFoundException, IOException, AWTException, SQLException {
		cust.commonloginpages();
		// Assert.assertEquals(true, false);
		logger.info("This is an info message.");

	}

	@Test(priority = 2, dependsOnMethods = "testcommonloginpages")
	public void testuploadcutsodianregfile() throws InterruptedException {

		// Assert.assertEquals(true, false);
		cust.uploadcutsodianregfile();
		logger.error("This is an error message.");
	}

	@Test(priority = 3)
	public void testdownloadregresponse() throws InterruptedException, AWTException {
		cust.downloadregresponse();
		logger.warn("This is an info message.");
	}

	@Test(priority = 4)
	public void testuploadCustodianVotefile() throws InterruptedException, AWTException {
		cust.uploadCustodianVotefile();

	}

	@Test(priority = 5)
	public void testdownloadVoteResponsefile() throws InterruptedException, AWTException {
		cust.downloadVoteResponsefile();

	}

	@Test(priority = 6)
	public void testuploadCustodianVotefileall() throws InterruptedException, AWTException {
		cust.uploadCustodianVotefileall();

	}

	@Test(priority = 7)
	public void testcustodainViewReport() throws InterruptedException, AWTException {
		cust.custodainViewReport();

	}

	@Test(priority = 8)
	public void testshareholderderegistration()
			throws InterruptedException, AWTException, ClassNotFoundException, SQLException {
		cust.shareholderderegistartion();

	}

	@Test(priority = 9)
	public void testCustodainResolutionFile()
			throws InterruptedException, AWTException, ClassNotFoundException, SQLException {
		cust.CustodainResolutionFile();
		logger.error("This is an error message.");
	}

	@Test(priority = 10)
	public void testEvenwiseholding() throws InterruptedException, AWTException, ClassNotFoundException, SQLException {
		cust.Evenwiseholding();

	}

	@Test(priority = 11)
	public void testctnresolutionbulkfileupload()
			throws InterruptedException, AWTException, ClassNotFoundException, SQLException {
		cust.ctnresolutionbulkfileupload();

	}

	@Test(priority = 12)
	public void testuploadVotesplitfile()
			throws InterruptedException, AWTException, ClassNotFoundException, SQLException {
		cust.uploadVotesplitfile();

	}

	@Test(priority = 13)
	public void testViewcustiodianMfFile()
			throws InterruptedException, AWTException, ClassNotFoundException, SQLException {
		cust.ViewcustiodianMfFile();

	}

//	@Test(priority = 14)
//	public void testcommonloginpages1()
//			throws InterruptedException, AWTException, ClassNotFoundException, SQLException {
//		cust.commonloginpages1();
//
//	}

	 @AfterTest
	public void TearDown() {
		driver.close();

	}
}
