package Testfinalpage;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.awt.AWTException;
import java.io.IOException;
import java.sql.SQLException;
import org.openqa.selenium.WebDriver;
import custodian.custodianmodule;
import utility.ConfigReader;
import utility.DriverFactory;
import utility.loginpage;

public class TestCustodianPage {

	static DriverFactory driverFactory;
	static WebDriver driver;
	ConfigReader configReader;
	static String even_no;
	static loginpage login;
	custodianmodule cust;


	@BeforeTest
	public void setup() throws IOException
	{	
		ConfigReader configreader = new ConfigReader();
		driverFactory = new DriverFactory();
		String BrowserName = 	ConfigReader.getProprty("Browser");
		driver = driverFactory.init_driver(BrowserName);
		login = new loginpage(driver);
		cust=new custodianmodule(driver);
	}

	@Test(priority=1)
	public void testpages() throws IOException, InterruptedException, AWTException, ClassNotFoundException, SQLException {

		login.login("CTN1", "nsdl@12345", "Custodian");
	}

	@Test(priority=2)
	public void testcustodianreg() throws InterruptedException
	{
		cust.uploadcutsodianregfile();
	}


	@Test(priority=3)
	public void testcustodianresponsefile() throws InterruptedException, AWTException
	{
		cust.downloadregresponse();

	}
	
	@Test(priority=4)
	public void testcustodianvotefile() throws InterruptedException, AWTException
	{
		cust.uploadCustodianVotefile();

	}
	
	@Test(priority=5)
	public void testcustodianvoteresponsefile() throws InterruptedException, AWTException
	{
		cust.downloadVoteResponsefile();

	}
	

@AfterTest
	public void TearDown()
	{
		driver.close();

	}
}
