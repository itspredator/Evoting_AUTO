package Testfinalpage;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import java.awt.AWTException;
import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import scrutiniser.scrutiniserhomepage;
import utility.ConfigReader;
import utility.DriverFactory;
import utility.loginpage;

@Listeners(utility.MyListener.class)
public class testscrutiniserpage {


	static DriverFactory driverFactory;
	static WebDriver driver;
	ConfigReader configReader;
	static String even_no;
	static 	loginpage login;
	int i=10;
	@BeforeTest
	public void testscrutiniserpage() throws IOException, InterruptedException, AWTException, ClassNotFoundException, SQLException 
	{
		//super();
		driver = setup();
		login = new loginpage(driver);
		login.login("SCR75NSDL", "nsdl@12345", "Scrutiniser");
		// TODO Auto-generated constructor stub
	}
	
	@Test(priority=1)
	public WebDriver setup() throws IOException
	{
		System.out.println("setup method ");
		ConfigReader configreader = new ConfigReader();
		driverFactory = new DriverFactory();
		String BrowserName = ConfigReader.getProprty("Browser");
		even_no = ConfigReader.getProprty("EVEN_NO");
		System.out.println("even no under setup \t"+even_no);
		System.out.println(BrowserName);
		driver = driverFactory.init_driver(BrowserName);
		return driver;

	}
	
	@Test(priority=2)
	public void FinalTestpage()throws Exception, AWTException
	{	
		testscrutiniserpage scr=new testscrutiniserpage();
		scrutiniserhomepage scrhome=new scrutiniserhomepage(driver);
		scrhome.Evoting_votinresults();
		scrhome.alldocsdownalod();
		
	}
	
	@Test(priority=3)
	public void skiipedmethod()throws Exception, AWTException
	{	
		System.out.println("skipped method executed");
	}
	@Test(priority=4)
	public void skiipedmethod1()
	{	
	AssertJUnit.assertEquals(i, 11);
	}
	@Test(priority=5,dependsOnMethods="skiipedmethod1")
	public void skiipedmethod2()throws Exception, AWTException
	{	
		System.out.println("skipped method executed");
	}
	@Test(priority=6)
	public void skiipedmethod3()throws Exception, AWTException
	{	
		AssertJUnit.assertEquals(i, 13);
	}
	
	@AfterTest
	public void teaddown()
	{
		System.out.println("closing the browser");
		driver.quit();
	}
	
}
