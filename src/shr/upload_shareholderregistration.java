package shr;

import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import service.DatabaseServiceImpl;
import service.Details;
import utility.ConfigReader;

public class upload_shareholderregistration {
	static WebDriver driver;
	static List<String> dataHolder = new ArrayList<>();
	ConfigReader config;
	static String header, even;
	static Details details;
	String memberfileupload;
	DatabaseServiceImpl imp;

	public upload_shareholderregistration(WebDriver driver) throws ClassNotFoundException, SQLException {

		upload_shareholderregistration.driver = driver;

		if (driver == null) {
			System.out.println("null value");
		}

		imp = new DatabaseServiceImpl();
		// TODO Auto-generated constructor stub
	}

	By evtngdropdown = By.cssSelector("td[title='eVoting'] strong");
	By drpdownshldrregfile = By.xpath("//tbody/tr[3]/td[2]/a[1]");
	By firstcutoffuploadradiobtn = By.xpath("//input[@value='I']");
	By seconduplaodradiobtn = By.xpath("//input[@id='uploadFileType']");
	By ckboxlastfileflag = By.xpath("//input[@id='lastFileFlag']");
	By selectfiletoupload = By.xpath("//input[@id='Uploadfile']");
	By submitbutton = By.xpath("//input[@id='submitButton']");
	By resetbutton = By.xpath("//tbody/tr[2]/td[1]/input[2]");
	String filesucessmsg = "";
	By fileuploadsucessmsg = By.xpath("//td[@id='message']");

	public static void filegeneration(String evenNo)
			throws ClassNotFoundException, IOException, SQLException, InterruptedException {
		sharholderfiletoupload.filereadutility(evenNo);
		Thread.sleep(6000);

	}

	public void uploadshareholderdropdown()
			throws IOException, ClassNotFoundException, SQLException, InterruptedException {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.findElement(evtngdropdown).click();
		driver.findElement(drpdownshldrregfile).click();
		System.out.println("-------inside upload shareholder file module------");
		String upload_type = ConfigReader.getProprty("Upload_Type");
		System.out.println("The selected upload type \t" + upload_type);
		/*
		 * String actualtitle = driver.getTitle(); String expetitle =
		 * "Upload Registrar"; SoftAssert sf = new SoftAssert();
		 * sf.assertEquals(expetitle, actualtitle);
		 */
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

		if (upload_type.equals("First_upload")) {
			driver.findElement(firstcutoffuploadradiobtn).click();
			String memberfileupload = ConfigReader.getProprty("Fileupload_path");
			driver.findElement(selectfiletoupload).sendKeys(memberfileupload);
			driver.findElement(submitbutton).click();
			Thread.sleep(5000);
			filesucessmsg = driver.findElement(fileuploadsucessmsg).getText();
			System.out.println(filesucessmsg);
			String processidfrommsg = filesucessmsg.substring(45).trim();
			System.out.println("file process with the process id:" + processidfrommsg);
			int processId = Integer.parseInt(processidfrommsg);
			System.out.println("Value of ProceesID:" + processId);
			int process_status = 0;
			Thread.sleep(3000);
			try {
				Thread.sleep(3000);
				process_status = imp.Fileprocessstatus(processId);
			} catch (NullPointerException e) {
				e.printStackTrace();
			}

			System.out.println("Rta file proceess status=" + process_status);

			if (driver.getPageSource().contains("Unable to read file"))

			{
				System.out.println("file contains error");
			} else {
				switch (process_status) {

				case 1:
					System.out
							.println("file uploaded with process status.Kindly check the listeners:" + process_status);
					break;

				case 2:
					System.out
							.println("file uploaded with process status.Kindly check the listeners:" + process_status);
					break;

				case 3:
					System.out.println("file uploaded sucessfully with process status" + process_status);
					break;

				default:
					break;
				}

			}

		}

		else if (upload_type.equals("Second_upload")) {

			driver.findElement(seconduplaodradiobtn).click();
			driver.findElement(selectfiletoupload).sendKeys(memberfileupload);
			driver.findElement(ckboxlastfileflag).click();
			driver.findElement(submitbutton).click();
			filesucessmsg = driver.findElement(fileuploadsucessmsg).getText();
			String processidfrommsg = filesucessmsg.substring(45).trim();
			System.out.println("file process with the process id:" + processidfrommsg);
			int processId = Integer.parseInt(processidfrommsg);
			int process_status = imp.Fileprocessstatus(processId);
			System.out.println("Rta file proceess status=" + process_status);

			if (driver.getPageSource().contains("Unable to read file"))

			{
				System.out.println("file contains error");
			}

			else {
				switch (process_status) {

				case 1:
					System.out.println("file uploaded sucessfully with process status" + process_status);
					break;

				case 2:
					System.out.println("file uploaded sucessfully with process status" + process_status);
					break;

				case 3:
					System.out.println("file uploaded sucessfully with process status" + process_status);
					break;

				default:
					break;
				}

			}
		}

	}

}
