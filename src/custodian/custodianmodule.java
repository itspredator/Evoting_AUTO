package custodian;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import service.DatabaseServiceImpl;
import utility.ConfigReader;
import utility.DB2Connect;
import utility.loginpage;

public class custodianmodule extends DB2Connect {

	WebDriver driver;
	File file;
	loginpage login;
	String Filepath = "C:\\Users\\Pinkeshc\\Desktop\\desktop dust\\filedownload";
	Properties prop;
	By evtngdropdown = By.xpath("//font[contains(text(),'e-Voting')]");
	By filesucessmsg = By.xpath("//td[@id='message']");
	By evtngdropdownupmenu = By.xpath("//strong[contains(text(),'e-Voting')]");
	By uploadcustregdrpdwn = By.linkText("Upload Custodian/MF Registration File");
	By choosefile = By.xpath("//tbody/tr[1]/td[3]/input[1]");
	By submitreg = By.xpath("//tbody/tr[1]/td[4]/input[1]");
	By regresponsefiledrdwn = By.xpath("//a[contains(text(),'Download Registration Response File')]");
	By errorfile = By.xpath("//body[1]/table[1]/tbody[1]/tr[3]/td[1]/table[2]/tbody[1]/tr[1]/td[6]");
	By outfile = By.xpath("//body[1]/table[1]/tbody[1]/tr[3]/td[1]/table[2]/tbody[1]/tr[1]/td[7]/a");
	By UploadCustVoteFiledrpdwn = By.xpath("//tbody/tr[3]/td[2]/a[1]");
	By CommonSubmitBtn = By.xpath("//input[@id='upldfile']");
	By UploadCustVoteFilealldrpdwn = By.xpath("//tbody/tr[4]/td[2]/a[1]");
	By DownloadVoteResdrpdwn = By.xpath("//a[contains(text(),'Download Vote Response File')]");
	By ViewCustodianReportdrpdwn = By.xpath("//a[contains(text(),'View Report')]");
	By ViewCustodianrptinputbox = By.xpath("//input[@id='even']");
	By showresultctn = By.xpath("//input[@id='ShowResult']");
	By shrdregistrationdrpdwn = By.xpath("//a[contains(text(),'Share Holder Deregistration')]");
	By shldrdematinputbox = By.xpath("//tbody/tr[1]/td[2]/input[1]");
	By submitbtnshldrderegi = By
			.xpath("//body[1]/table[1]/tbody[1]/tr[3]/td[1]/form[1]/table[1]/tbody[1]/tr[1]/td[3]/input[1]");
	By Dregisterckboxall = By.cssSelector(
			"table.subOutline:nth-child(5) table:nth-child(1) tbody:nth-child(1) tr:nth-child(1) td:nth-child(3) > input:nth-child(2)");
	By dregiterBtn = By.xpath("//tbody/tr[6]/td[1]/input[1]");
	By DeregistrationMessage = By.xpath("//p[contains(text(),'Deregisteration Successful')]");
	By DeregistrationTable = By
			.xpath("//body[1]/table[1]/tbody[1]/tr[3]/td[1]/form[1]/table[2]/tbody[1]/tr[2]/td[1]/table[1]");
	By UploadcustodianResolutionDrpDwn = By.xpath("//a[contains(text(),'Upload Custodian Resolution File')]");
	By inputboxdpid = By.xpath("//input[@id='dpID']");
	By inputboxclientid = By.xpath("//input[@id='clientID']");
	By UploadResolutionChooseFile = By.xpath("//tbody/tr[4]/td[2]/input[1]");
	By evenwisehldgdrpdwn = By.xpath("//a[contains(text(),'Even-Wise Holding')]");
	By Evenidinputboxevenwise = By.xpath("//tbody/tr[1]/td[2]/input[1]");
	By Searchbuttonevenwise = By.xpath("//input[@id='searchButton']");
	By evencontainsornot = By.xpath("//td[contains(text(),'For this Even Shareholders are not registered.')]");
	By exportbutton = By.xpath("//tbody/tr[2]/td[1]/input[1]");
	By resolutionbulkfiledrpdwn = By.xpath("//a[contains(text(),'Upload Custodian Resolution Bulk File')]");
	By choosefilebulkupload = By.xpath("//tbody/tr[1]/td[2]/input[1]");
	By resolutionuploadsucessalert = By.partialLinkText("File Uploaded Successfully");
	By Votesplitfiledrpdwn = By.xpath("//a[contains(text(),'Upload Vote File (S)')]");
	By ViewCustodianResolutionfile = By.xpath("//a[contains(text(),'View Custodian/MF Resolution File')]");
	By Viewresolutionfiledownloadtbl = By.xpath("//tbody/tr[2]/td[1]/table[2]");
	By exportButtonview = By.xpath("//tbody/tr[10]//td//input[@id='searchButton']");

	public custodianmodule(WebDriver driver) {
		this.driver = driver;
		login = new loginpage(driver);
	}

	public void commonloginpages()
			throws IOException, InterruptedException, AWTException, ClassNotFoundException, SQLException {
		login.login("CTN1", "nsdl@12345", "Custodian");
	}

	public void uploadcutsodianregfile() throws InterruptedException {

		SoftAssert sa = new SoftAssert();
		driver.manage().window().maximize();
		driver.findElement(evtngdropdown).click();
		driver.findElement(uploadcustregdrpdwn).click();
		driver.findElement(choosefile).sendKeys("E:\\SurajSanity\\SurajSanity\\CustodianRegFile2.zip");
		Thread.sleep(2000);
		driver.findElement(submitreg).click();
		String mesgafterupload = driver.findElement(filesucessmsg).getText();
		String[] msgaftersplit = mesgafterupload.split(":");
		String Actualmsg = msgaftersplit[0].trim(); // trim to remove any leading or trailing spaces
		System.out.println(Actualmsg);
		sa.assertEquals(Actualmsg, "File uploaded successfully with Process id");
		sa.assertAll();
		Thread.sleep(2000);
	}

	public void downloadregresponse() throws InterruptedException, AWTException {
		Robot robot = new Robot();
		driver.findElement(evtngdropdownupmenu).click();
		driver.findElement(regresponsefiledrdwn).click();

		if (driver.findElement(outfile).isDisplayed()) {
			driver.findElement(outfile).click();

			Thread.sleep(4000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
		} else {
			driver.findElement(errorfile).isDisplayed();
			driver.findElement(errorfile).click();
			Thread.sleep(4000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

		}
		Thread.sleep(4000);
	}

	public void uploadCustodianVotefile() throws InterruptedException {
		driver.findElement(evtngdropdownupmenu).click();
		driver.findElement(UploadCustVoteFiledrpdwn).click();
		driver.findElement(choosefile).sendKeys("E:\\SurajSanity\\SurajSanity\\CustodianVote2NoW.zip");
		driver.findElement(CommonSubmitBtn).click();
		Thread.sleep(4000);
	}

	public void downloadVoteResponsefile() throws InterruptedException, AWTException {
		Robot robot = new Robot();
		driver.findElement(evtngdropdownupmenu).click();
		driver.findElement(DownloadVoteResdrpdwn).click();

		if (driver.findElement(outfile).isDisplayed()) {
			driver.findElement(outfile).click();

			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
		} else {
			driver.findElement(errorfile).isDisplayed();
			driver.findElement(errorfile).click();
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(4000);
		}

	}

	public void uploadCustodianVotefileall() throws InterruptedException {
		driver.findElement(evtngdropdownupmenu).click();
		driver.findElement(UploadCustVoteFilealldrpdwn).click();
		driver.findElement(choosefile).sendKeys("E:\\SurajSanity\\SurajSanity\\CustodianVote2NoW.zip");
		driver.findElement(CommonSubmitBtn).click();
		Thread.sleep(4000);
	}

	public void custodainViewReport() throws InterruptedException {
		ConfigReader configreader = new ConfigReader();
		// DriverFactory driverFactory = new DriverFactory();
		String EVEN = ConfigReader.getProprty("EVEN_NO");
		driver.findElement(evtngdropdownupmenu).click();
		driver.findElement(ViewCustodianReportdrpdwn).click();
		driver.findElement(ViewCustodianrptinputbox).sendKeys(EVEN);
		driver.findElement(showresultctn).click();
		Thread.sleep(2000);
	}

	public void shareholderderegistartion()
			throws SQLException, ClassNotFoundException, InterruptedException, AWTException {
		SoftAssert sa = new SoftAssert();
		DatabaseServiceImpl databaseServiceImpl = new DatabaseServiceImpl();

		String Dematid = databaseServiceImpl.getDematsIdForEntityId("IN300167");
		driver.findElement(evtngdropdownupmenu).click();
		driver.findElement(shrdregistrationdrpdwn).click();
		driver.findElement(shldrdematinputbox).sendKeys(Dematid);
		driver.findElement(submitbtnshldrderegi).click();
		WebElement checkbox = driver.findElement(Dregisterckboxall);
		if (!checkbox.isSelected()) {
			checkbox.click();
		} else {
			checkbox.clear();
			checkbox.click();
		}

		WebElement table = driver.findElement(DeregistrationTable);
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		int rowNo = rows.size();

		WebElement deregisterbutton = driver.findElement(By.xpath("//tbody/tr[" + rowNo + "]/td[1]/input[1]"));
		if (deregisterbutton.isEnabled()) {

			deregisterbutton.click();
			String demessage = driver.findElement(DeregistrationMessage).getText();
			sa.assertEquals(demessage, "Deregisteration Successful.");
			sa.assertAll();
			Thread.sleep(2000);
		} else {
			System.out.println("Deristration button not enebaled or data is not available");
			Thread.sleep(2000);
		}

	}

	public void CustodainResolutionFile() {

		driver.findElement(evtngdropdownupmenu).click();
		driver.findElement(UploadcustodianResolutionDrpDwn).click();
		WebElement dpid = driver.findElement(inputboxdpid);
		dpid.click();
		String DPID = "IN300167";
		dpid.sendKeys(DPID);
		WebElement Clid = driver.findElement(inputboxclientid);
		String CLID = "10151302";
		Clid.click();
		Clid.sendKeys(CLID);

		String filepath = "C:\\Users\\Pinkeshc\\Downloads\\IN300167_10151302.pdf";
		// filename and and file format should be validated.
		String fileFormatMessage = "Selected file is in .pdf Format";
		String wrongdpidcidmessage = "User is not Present in e-Voting System";
		String uploadsucessmsg = "File Uploaded Successfully" + DPID + "_" + CLID + ".pdf";
		System.out.println(uploadsucessmsg);
		File file = new File(filepath);
		long fileSizeInBytes = file.length();
		System.out.println("File size: " + fileSizeInBytes + " bytes");
		long maxSizeInBytes = 25 * 1024 * 1024;
		if ((filepath.endsWith(".pdf")) && (fileSizeInBytes <= maxSizeInBytes)) {
			System.out.println(fileFormatMessage);
			// Exit the method if the file format is incorrect
			System.out.println("File size under the allowed limit");

			driver.findElement(UploadResolutionChooseFile).sendKeys(filepath);
			driver.findElement(CommonSubmitBtn).click();
			String actualalert = driver.findElement(resolutionuploadsucessalert).getText();
			System.out.println("alert after file uploading" + actualalert);
			SoftAssert sa = new SoftAssert();
			sa.assertEquals(actualalert, uploadsucessmsg);
			sa.assertAll();

		}

		else {
			System.out.println("File size exceeds the allowed limit or invalid file format");
		}

	}

	public void Evenwiseholding() throws InterruptedException, AWTException {
		SoftAssert sa = new SoftAssert();
		driver.findElement(evtngdropdownupmenu).click();
		driver.findElement(evenwisehldgdrpdwn).click();
		driver.findElement(Evenidinputboxevenwise).sendKeys("110718");
		driver.findElement(Searchbuttonevenwise).click();

		if (driver.findElement(exportbutton).isEnabled()) {
			driver.findElement(exportbutton).click();
			Thread.sleep(2000);
			System.out.println("Entered Even id is registered with shareholder");
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
		} else {
			String actualalertmesage = driver.findElement(evencontainsornot).getText();
			sa.assertEquals(actualalertmesage, "For this Even Shareholders are not registered.");
			sa.assertAll();
		}
	}

	public void ctnresolutionbulkfileupload() throws InterruptedException {

		File[] files = new File("D:\\Automation files\\custodian\\resolution bulk upload").listFiles();

		for (File file : files) {

			if ((file.getName().substring(file.getName().indexOf("."))).equals(".zip")) {

				System.out.println("The filename\t" + file.getName());
				Thread.sleep(5000);
				driver.findElement(evtngdropdownupmenu).click();
				driver.findElement(resolutionbulkfiledrpdwn).click();
				driver.findElement(choosefilebulkupload).sendKeys(file.getAbsolutePath());
				driver.findElement(CommonSubmitBtn).click();

			}

		}

	}

	public void uploadVotesplitfile() {
		driver.findElement(evtngdropdownupmenu).click();
		driver.findElement(Votesplitfiledrpdwn).click();
		String actualpage = driver.getTitle();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actualpage, "Custodian Split Vote Upload");
		driver.findElement(choosefile).sendKeys("E:\\SurajSanity\\SurajSanity\\CustodianVote2\\CustodianVote2 (2).zip");
		driver.findElement(CommonSubmitBtn).click();
		String actualalert = driver.findElement(resolutionuploadsucessalert).getText();
		System.out.println("alert after file uploading" + actualalert.substring(0, 26));

		String uploadsucessmsg = "File Uploaded Successfully";
		sa.assertEquals(actualalert, uploadsucessmsg);
		sa.assertAll();

	}

	public void ViewcustiodianMfFile() throws AWTException, InterruptedException {
		driver.findElement(evtngdropdownupmenu).click();
		driver.findElement(ViewCustodianResolutionfile).click();
		String actualpage = driver.getTitle();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actualpage, "Resolution Download");
		WebElement tabledata = driver.findElement(Viewresolutionfiledownloadtbl);
		List<WebElement> rows = tabledata.findElements(By.tagName("tr"));
		int rowsno = rows.size();
		System.out.println("no of data availbale in the table" + rowsno);
		driver.findElement(By.xpath("//tbody/tr[7]/td[3]/a[1]")).click();
		Thread.sleep(3000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(4000);
		driver.findElement(exportButtonview).click();
		Thread.sleep(4000);
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_ENTER);
		robot1.keyRelease(KeyEvent.VK_ENTER);

	}

	/*public void commonloginpages1() {
		// TODO Auto-generated method stub

	}*/

}
