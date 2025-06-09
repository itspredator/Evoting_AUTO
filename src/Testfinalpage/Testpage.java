package Testfinalpage;

import java.awt.AWTException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import shr.Evencreation;
import shr.createeven;
import shr.downloadpinmailer;
import shr.downloadresponsefile;
import shr.upload_shareholderregistration;
import utility.ConfigReader;
import utility.DriverFactory;
import utility.MyListener;
import utility.datareader;
import utility.loginpage;

@Listeners(MyListener.class)
public class Testpage {

	static DriverFactory driverFactory;
	static WebDriver driver;
	ConfigReader configReader;
	static List<Evencreation> evencreation;
	loginpage loginpageobj;
	createeven creven;
	upload_shareholderregistration usreg;
	downloadresponsefile dr;
	downloadpinmailer dpm;
	public static createeven even;

	public Testpage() throws IOException, ClassNotFoundException, SQLException {
		super();

		driver = setup();
		loginpageobj = new loginpage(driver);
		creven = new createeven(driver);
		usreg = new upload_shareholderregistration(driver);
		dr = new downloadresponsefile(driver);
		dpm = new downloadpinmailer(driver);
		evencreation = datareader.readExcel("C:\\Users\\Pinkeshc\\Desktop", "Book6.xlsx");
		MyListener.setDriver(driver);
	}

	// @BeforeTest

	public WebDriver setup() throws IOException {
		System.out.println("setup method ");
		ConfigReader configreader = new ConfigReader();
		driverFactory = new DriverFactory();
		String BrowserName = ConfigReader.getProprty("Browser");
		driver = driverFactory.init_driver(BrowserName);
		return driver;

	}

	/*
	 * public void mainshr() throws IOException, InterruptedException, AWTException,
	 * ClassNotFoundException, SQLException { // Assert.assertEquals(true, false);
	 * 
	 * testpages();
	 * 
	 * for (Evencreation evenObj : evencreation) {
	 * System.out.println("even "+evenObj.toString()); testevenformfill(evenObj);
	 * testrtafilegeneration(); testuploadshareholderdropdown();
	 * testclickondownloadresponsefile(); testclickondownlaodevenwsepinmailerfile();
	 * 
	 * } }
	 */

	@Test(priority = 1)
	public void TestPages()
			throws IOException, InterruptedException, AWTException, ClassNotFoundException, SQLException {
		System.out.println("--------------------------login page--------------------------");
		loginpageobj.login("SHR1", "nsdl@12345", "RTA");

	}

	@Test(priority = 2)
	public void TestEvenFormFill()
			throws InterruptedException, AWTException, ClassNotFoundException, IOException, SQLException {
		System.out.println("-----------------TestEvenFormFill page--------------------");
		even = creven.evenformfill(evencreation.get(0));

	}

	@Test(priority = 3, dependsOnMethods = "TestEvenFormFill")
	public void TestRtaFileGeneration() throws ClassNotFoundException, IOException, SQLException, InterruptedException {
		System.out.println("------------------TestRtaFileGeneration page---------------");
		upload_shareholderregistration.filegeneration(even.getExtractionofeven());

	}

	@Test(priority = 4)
	public void TestUploadShareholderDropdown()
			throws ClassNotFoundException, IOException, SQLException, InterruptedException {
		System.out.println("--------------TestUploadShareholderDropdown page------------");
		usreg.uploadshareholderdropdown();
	}

	@Test(priority = 5)
	public void TestClickOnDownloadResponseFile() throws InterruptedException, AWTException {
		System.out.println("---------------TestClickOnDownloadResponseFile page-------------");
		dr.clickondownloadresponsefile();
		dr.downaloderrorandoutfile();
	}

	@Test(priority = 6)
	public void TestClickOnDownloadEvenWisePinMailerFile() throws InterruptedException, AWTException {
		System.out.println("------------TestClickOnDownloadEvenWisePinMailerFile page------------");
		dpm.clickondownlaodevenwsepinmailerfile();
		dpm.generatepinmailerfile();

	}
	
//	 @AfterTest 
//	 public void teardown()
//	 { driver.quit();
//	 }

}