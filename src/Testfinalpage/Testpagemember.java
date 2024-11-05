package Testfinalpage;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.awt.AWTException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;
import member.Memberhomepage;
import service.DatabaseServiceImpl;
import utility.ConfigReader;
import utility.DriverFactory;
import utility.loginpage;

public class Testpagemember {

	static DriverFactory driverFactory;
	static WebDriver driver;
	ConfigReader configReader;
	static List<String> userid=new ArrayList<>();
	static String even_no;

	static 	loginpage login;

	//private static Logger log;
	public Testpagemember() throws IOException {
		super();
		driver = setup();
		login = new loginpage(driver);
	}

	//@BeforeTest
	public WebDriver setup() throws IOException {

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

	@Test(priority = 1)
	public static void mainshr() throws IOException, InterruptedException, AWTException, ClassNotFoundException, SQLException
	{	
		System.out.println(even_no);
		String nsdlQry = "select sem_user_id from shldr_evtng_map where sem_ev_id='"+even_no+"'  and sem_user_id like'%IN%' fetch first 1 rows only ;";
		String cdslQry = "select sem_user_id from shldr_evtng_map where sem_ev_id='"+even_no+"'  and regexp_like( sem_user_id, '^[[:digit:]]*$') and length(sem_user_id) = 16 fetch first 1 rows only ;";
		String folioQry = "select sem_user_id from shldr_evtng_map where sem_ev_id='"+even_no+"'  and sem_user_id like'"+even_no+"%'  fetch first 1 rows only ;";


		DatabaseServiceImpl databaseServiceImpl = new DatabaseServiceImpl();

		userid.add(databaseServiceImpl.FetchShareHolderId(folioQry));
		userid.add(databaseServiceImpl.FetchShareHolderId(nsdlQry));
		userid.add(databaseServiceImpl.FetchShareHolderId(cdslQry));



		System.out.println("fetched userid are as follows:" +userid);


		String updatequery="update usr_psswd set USP_PSSWD_1='shwu6QO5rP/8/kYzhqt+bg==',USP_PSSWD_2='shwu6QO5rP/8/kYzhqt+bg==', "
				+ "USP_HASH_PWD='shwu6QO5rP/8/kYzhqt+bg=='"
				+ " where usp_user_id in('"+userid.get(0)+"','"+userid.get(1)+"','"+userid.get(2)+"');";

		System.out.println(updatequery);
		int status = databaseServiceImpl.UpdateCommonpassword(updatequery);

		System.out.println("status : " + status);


	}

	@Test(priority =2)
	public static void testmemberlogin() throws InterruptedException, AWTException, ClassNotFoundException, SQLException, IOException
	{

		String password = "nsdl@12345";
									
		for(int i=0;i<=2;i++)
		{
			System.out.println("LOOP : " + i);
			login.login(userid.get(i), password, "Member");

			Memberhomepage mem=new Memberhomepage(driver);
			mem.membervote();
			driver.manage().deleteAllCookies();
			Thread.sleep(5000);
			//driver.switchTo().newWindow(WindowType.WINDOW);
			//driver.get("https://10.150.7.19/eVotingWeb/resolutionFileDwn.do");
			//	
		}


	}

}