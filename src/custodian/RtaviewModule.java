package custodian;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.time.Duration;
import java.util.Arrays;
import java.util.Comparator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import utility.ConfigReader;
import utility.DriverFactory;


public class RtaviewModule {

//	static DriverFactory driverFactory;
//	static WebDriver driver;
//	ConfigReader configReader;
//	static String even_no;
//	static String mailSender;
//
//	static By inputeven=By.xpath("//input[@id='evenNo']");
//	static By generatebutton=By.xpath("//button[@id='btn']");
//	public  RtaviewModule() throws IOException, InterruptedException, AWTException 
//	{
//		//super();
//		
//		if (driver==null) {
//			System.out.println("NULL");
//		}
//		else {
//			System.out.println("NOT NULL");
//		}
//		
//	}
//		public static WebDriver setup() throws IOException
//	{
//			
//		System.out.println("setup method ");
//		ConfigReader configreader = new ConfigReader();
//		driverFactory = new DriverFactory();
//		String BrowserName = ConfigReader.getProprty("Browser");
//		
//		File evenFile = new File("D:\\RTA View Module\\input\\");
//		File[] files = evenFile.listFiles();
//		Arrays.sort(files,Comparator.comparingLong(File::lastModified));
//		even_no = files[files.length-1].getName().replace(".txt", "");
//		
//		BufferedReader br = new BufferedReader(new FileReader(files[0]));
//		mailSender = br.readLine();
//		br.close();
//		
//		System.out.println("mailSender :  " + mailSender);
//
//		System.out.println("even no under setup \t"+even_no);
//		System.out.println(BrowserName);
//		driver = driverFactory.init_driver(BrowserName);
//		return driver;
//
//	}
//	
//	
//	public static void rtafilegenerate(WebDriver driver) throws Exception
//	{
//		driver = setup();
//		
//		String Url = "http://10.110.6.192:8080/Rta_View_Module2/index.jsp";
//		
//		driver.get(Url);
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		driver.findElement(inputeven).sendKeys(even_no);
//		driver.findElement(generatebutton).click();
//		
//		Thread.sleep(25000);
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_CONTROL);
//		robot.keyPress(KeyEvent.VK_S);
//		robot.keyRelease(KeyEvent.VK_CONTROL);
//		robot.keyRelease(KeyEvent.VK_S);
//		
//		
//		StringSelection selection = new StringSelection(even_no + ".html");
//		java.awt.Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
//		
//		Thread.sleep(3000);
//		
//		robot.keyPress(KeyEvent.VK_CONTROL);
//		robot.keyPress(KeyEvent.VK_V);
//		robot.keyRelease(KeyEvent.VK_V);
//		robot.keyRelease(KeyEvent.VK_CONTROL);
//
//		
//		Thread.sleep(3000);
//		
//		robot.keyPress(KeyEvent.VK_TAB);
//		robot.keyRelease(KeyEvent.VK_TAB);
//		robot.keyPress(KeyEvent.VK_TAB);
//		robot.keyRelease(KeyEvent.VK_TAB);		
//		robot.keyPress(KeyEvent.VK_TAB);
//		robot.keyRelease(KeyEvent.VK_TAB);
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);
//		
//		robot.keyPress(KeyEvent.VK_TAB);
//		robot.keyRelease(KeyEvent.VK_TAB);
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);
//		
//		Thread.sleep(3000);
//		
//		String attachment = System.getProperty("user.dir") + "\\Downloads\\" + even_no + ".html";
//		System.out.println("filePath : " + attachment);
//		
//		MailSender.mailSender(mailSender, even_no, attachment);
//
//	}
//	
//	public static void main(String[] args) throws Exception {
//		rtafilegenerate(driver);
//
//	}
//	
}
