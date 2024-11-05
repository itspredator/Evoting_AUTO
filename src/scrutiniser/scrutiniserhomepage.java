package scrutiniser;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utility.ConfigReader;

@Listeners(utility.MyListener.class)
public class scrutiniserhomepage {

	private WebDriver driver;
	public Robot robot;

	static String geteven;
	By evtngdropdown = By.xpath("//font[contains(text(),'e-Voting')]");
	By EvotingvotingResuldtdrpdwn=By.cssSelector("td.indexText:nth-child(1) div.DropDown:nth-child(1) table:nth-child(1) tbody:nth-child(1) tr:nth-child(1) td:nth-child(2) > a:nth-child(1)");	
	By Evoting_enddate=By.cssSelector("table.outline:nth-child(4) td:nth-child(1) table.subOutline:nth-child(6) tbody:nth-child(1) tr:nth-child(4) > td:nth-child(3)");
	By UnlockBuuton=By.xpath("//tbody/tr[1]/td[1]/input[1]");
	By USerdetailsBuuton=By.xpath("//tbody/tr[1]/td[1]/input[2]");
	By OkAfterauthorise=By.xpath("//input[@id='searchButton']");
	By Authorisebutton=By.xpath("//tbody/tr[1]/td[1]/input[1]");
	By DownloadPDF=By.xpath("//tbody/tr[1]/td[1]/input[2]");
	By DownloadCSV=By.xpath("//tbody/tr[1]/td[1]/input[3]");
	By VoteSummary=By.xpath("//tbody/tr[1]/td[1]/input[4]");
	By UserDetail=By.xpath("//tbody/tr[1]/td[1]/input[5]");
	By OnlineCSV=By.xpath("//tbody/tr[1]/td[1]/input[6]");
	By VenueCSV=By.xpath("//tbody/tr[1]/td[1]/input[7]");
	By logoutbutton=By.xpath("//strong[contains(text(),'Logout')]");

	public scrutiniserhomepage(WebDriver driver) throws AWTException 
	{
		super();
		this.driver = driver;
		robot = new Robot();
		ConfigReader configReader = new ConfigReader();
		geteven = ConfigReader.getProprty("EVEN_NO");
		System.out.println("even no:"+ geteven);


	}
	@Test
	public void Evoting_votinresults()
	{	

		driver.findElement(evtngdropdown).click();
		driver.findElement(EvotingvotingResuldtdrpdwn).click();
		driver.findElement(By.linkText(geteven)).click();
		/*String fetcheddate=driver.findElement(Evoting_enddate).getText();*/
		String fetcheddate =  null;
		System.out.println("fetched date and time \t: "+ fetcheddate.substring(0, 10));
		DateTimeFormatter format=DateTimeFormatter.ofPattern("YYYY-MM-DD");
		String  modifieddate=fetcheddate.format(fetcheddate, format);
		LocalDateTime now= LocalDateTime.now();
		System.out.println("curent timestamp "+ now.toString().substring(0, 10));
		LocalDate date1 = LocalDate.parse(fetcheddate.substring(0, 10));
		LocalDate date2 = LocalDate.parse(now.toString().substring(0, 10));

		if(date1.isBefore(date2))
		{
			System.out.println("End date passed");
			driver.findElement(UnlockBuuton).click();
			Alert alert=driver.switchTo().alert();
			System.out.println(alert.getText());
			alert.accept();
			Alert alert1=driver.switchTo().alert();
			System.out.println(alert1.getText());
			alert1.accept();
			driver.findElement(OkAfterauthorise).click();

		}


	}
	public  void alldocsdownalod() throws InterruptedException
	{	

		driver.findElement(By.linkText(geteven)).click();
		//driver.findElement(DownloadPDF).click();
		driver.findElement(DownloadCSV).click();
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);		
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		//		robot.mousePress(MouseEvent.BUTTON1);
		//		robot.mouseRelease(MouseEvent.BUTTON1);

		driver.findElement(VoteSummary).click();
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);		
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		//		driver.findElement(UserDetail).click();
		//		driver.findElement(OnlineCSV).click();
		//		driver.findElement(VenueCSV).click();
		driver.findElement(logoutbutton).click();
	}
}