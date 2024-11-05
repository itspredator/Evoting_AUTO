package custodian;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utility.ConfigReader;
import utility.DB2Connect;
import utility.DriverFactory;

public class custodianmodule extends DB2Connect {

	WebDriver driver;
	String Filepath = "C:\\Users\\Pinkeshc\\Desktop\\desktop dust\\filedownload";
	Properties prop;

	By evtngdropdown = By.xpath("//font[contains(text(),'e-Voting')]");
	By evtngdropdownupmenu = By.xpath("//strong[contains(text(),'e-Voting')]");
	By uploadcustregdrpdwn = By.linkText("Upload Custodian/MF Registration File");
	By choosefile = By.xpath("//tbody/tr[1]/td[3]/input[1]");
	By submitreg = By.xpath("//tbody/tr[1]/td[4]/input[1]");
	By regresponsefiledrdwn = By.xpath("//a[contains(text(),'Download Registration Response File')]");
	By errorfile = By.xpath("//body[1]/table[1]/tbody[1]/tr[3]/td[1]/table[2]/tbody[1]/tr[1]/td[6]");
	By outfile = By.xpath("//body[1]/table[1]/tbody[1]/tr[3]/td[1]/table[2]/tbody[1]/tr[1]/td[7]/a");
	By UploadCustVoteFiledrpdwn = By.xpath("//tbody/tr[3]/td[2]/a[1]");
	By SubmitBtnVoteFile=By.xpath("//input[@id='upldfile']");
	By UploadCustVoteFilealldrpdwn = By.xpath("//tbody/tr[4]/td[2]/a[1]");
	By DownloadVoteResdrpdwn = By.xpath("//a[contains(text(),'Download Vote Response File')]");
	By ViewCustodianReportdrpdwn = By.xpath("//a[contains(text(),'View Report')]");
	By ViewCustodianrptinputbox=By.xpath("//input[@id='even']");
	By showresultctn=By.xpath("//input[@id='ShowResult']");
	By shrdregistrationdrpdwn=By.xpath("//a[contains(text(),'Share Holder Deregistration')]");
	public custodianmodule(WebDriver driver) {
		this.driver = driver;
	}

	public void uploadcutsodianregfile() throws InterruptedException {
		driver.manage().window().maximize();
		driver.findElement(evtngdropdown).click();
		Thread.sleep(1000);
		driver.findElement(uploadcustregdrpdwn).click();
		driver.findElement(choosefile).sendKeys("E:\\SurajSanity\\SurajSanity\\CustodianRegFile2.zip");
		Thread.sleep(2000);
		driver.findElement(submitreg).click();
		Thread.sleep(3000);

	}

	public void downloadregresponse() throws InterruptedException, AWTException {
		Robot robot = new Robot();
		driver.findElement(evtngdropdownupmenu).click();
		driver.findElement(regresponsefiledrdwn).click();

		if (driver.findElement(outfile).isDisplayed()) {
			driver.findElement(outfile).click();

			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} else {
			driver.findElement(errorfile).isDisplayed() ;
			driver.findElement(errorfile).click();
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

		}

	}

	public void uploadCustodianVotefile() throws InterruptedException
	{
		driver.findElement(evtngdropdownupmenu).click();
		driver.findElement(UploadCustVoteFiledrpdwn).click();
		driver.findElement(choosefile).sendKeys("E:\\SurajSanity\\SurajSanity\\CustodianVote2NoW.zip");
		driver.findElement(SubmitBtnVoteFile).click();
	}
	
	
	public void downloadVoteResponsefile() throws InterruptedException, AWTException
	{
		Robot robot = new Robot();
		driver.findElement(evtngdropdownupmenu).click();
		driver.findElement(DownloadVoteResdrpdwn).click();

		if (driver.findElement(outfile).isDisplayed()) {
			driver.findElement(outfile).click();

			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} 
		else {
			driver.findElement(errorfile).isDisplayed();
			driver.findElement(errorfile).click();
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		}

	}
	public void uploadCustodianVotefileall() throws InterruptedException
	{
		driver.findElement(evtngdropdownupmenu).click();
		driver.findElement(UploadCustVoteFilealldrpdwn).click();
		driver.findElement(choosefile).sendKeys("E:\\SurajSanity\\SurajSanity\\CustodianVote2NoW.zip");
		driver.findElement(SubmitBtnVoteFile).click();
	}
	
	public void custodainViewReport( String Evenno)
	{	
		ConfigReader configreader = new ConfigReader();
		DriverFactory driverFactory = new DriverFactory();
		String EVEN = 	ConfigReader.getProprty("EVEN_NO");
		driver.findElement(evtngdropdownupmenu).click();
		driver.findElement(ViewCustodianReportdrpdwn).click();
		driver.findElement(ViewCustodianrptinputbox).sendKeys(EVEN);
		driver.findElement(showresultctn).click();
	}
		
	public void shareholderderegistartion()
	{
		driver.findElement(evtngdropdownupmenu).click();
		driver.findElement(shrdregistrationdrpdwn).click();
	}
	
}
