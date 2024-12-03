package Testfinalpage;

import org.testng.annotations.Test;
import org.testng.annotations.Test;


import org.testng.annotations.Test;
import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import shr.Evencreation;
import shr.createeven;
import shr.downlaodpinmailer;
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
	loginpage login;
	createeven creven;
	
	upload_shareholderregistration usreg;
	downloadresponsefile dr;
	downlaodpinmailer dpm;
	public static createeven even;

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		Testpage.driver = driver;
	}

	public Testpage() throws IOException {
		super();

		driver = setup();
		login = new loginpage(driver);
		creven = new createeven(driver);
		usreg = new upload_shareholderregistration(driver);
		dr = new downloadresponsefile(driver);
		dpm = new downlaodpinmailer(driver);
		evencreation = datareader.readExcel("C:\\Users\\Pinkeshc\\Desktop", "Book6.xlsx");
	}

	private void deletesnapshots(String path) {
		File file = new File(path);

		File list[]=file.listFiles();
		
		for (File file2 : list) {
			file2.delete();	
		}

	}

	//@BeforeTest

	public WebDriver setup() throws IOException {
		
		deletesnapshots(System.getProperty("user.dir") + "\\defects_snapshot\\");

		System.out.println("setup method ");
		ConfigReader configreader = new ConfigReader();
		driverFactory = new DriverFactory();
		String BrowserName = ConfigReader.getProprty("Browser");
		System.out.println(BrowserName);
		driver = driverFactory.init_driver(BrowserName);
		return driver;

	}
	
	@Test(priority = 1)
	
   public void mainshr() throws IOException, InterruptedException, AWTException, ClassNotFoundException, SQLException
   {
		Assert.assertEquals(true, false);
		
		testpages();
		
		
		for (Evencreation evenObj: evencreation) {
			
			testevenformfill(evenObj);
			testrtafilegeneration() ;
			testuploadshareholderdropdown();
			testclickondownloadresponsefile();
			testclickondownlaodevenwsepinmailerfile();
			
			
		}
   }
	
	
	//@Test(priority = 1)
	//@Test
	@Test
	public void testpages() throws IOException, InterruptedException, AWTException, ClassNotFoundException, SQLException {
	
		login.login("SHR1", "nsdl@12345","RTA");
	}
	
	//@Test(priority = 2)
	//@Test
	@Test
	public void testevenformfill(Evencreation evenObj) throws InterruptedException, AWTException, ClassNotFoundException, IOException, SQLException {
			even = creven.evenformfill(evenObj);
	}  
	//@Test(priority = 3)
	//@Test
	@Test
	public void testrtafilegeneration() throws ClassNotFoundException, IOException, SQLException, InterruptedException
	{
		usreg.filegeneration(even.getExtractionofeven());
	}
	
	//@Test(priority = 4)
	
	//@Test
	@Test
	public void testuploadshareholderdropdown() throws ClassNotFoundException, IOException, SQLException, InterruptedException
	{
		usreg.uploadshareholderdropdown();
	}
		
	

	//@Test(priority = 5)
	//@Test
	@Test
	public void testclickondownloadresponsefile() throws InterruptedException, AWTException {
		dr.clickondownloadresponsefile();
		dr.downaloderrorandoutfile();

	}

	//@Test(priority = 6)
	//@Test
	@Test
	public void testclickondownlaodevenwsepinmailerfile() throws InterruptedException, AWTException {
		dpm.clickondownlaodevenwsepinmailerfile(even);
		dpm.generatepinmailerfile(even);

	}


	
//	 @AfterTest 
//	 public void teardown()
//	 { driver.quit();
//	 }
	 

	// public static void main(String[] args) throws IOException,
	// InterruptedException, AWTException {

	/*
	 * @AfterClass public void tearDown(Scenario scenario) throws IOException {
	 * if(scenario.isFailed()) { //take screen shot String screenShotName =
	 * scenario.getName().replaceAll(" ","_"); byte[] sourcePath =
	 * ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES); File sourcePath1
	 * = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); File screenshot
	 * = new File( "ScreenShotsForErrorCheck/"+screenShotName + ".png");
	 * FileUtils.copyFile(sourcePath1, screenshot); scenario.attach(sourcePath,
	 * "image/png", screenShotName); }
	 */
	/*
	 * @BeforeClass public void setup() throws IOException { ChromeOptions
	 * options=new ChromeOptions(); //options.addArguments("--guest");
	 * options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
	 * DesiredCapabilities capabilities = new DesiredCapabilities();
	 * capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true); String
	 * path=System.getProperty("user.dir");
	 * System.setProperty("webdriver.chrome.driver",path+
	 * "\\drivers\\chromedriver.exe"); WebDriver driver= new ChromeDriver(options);
	 * 
	 * }
	 */

	// }
	// TODO Auto-generated method stub

}