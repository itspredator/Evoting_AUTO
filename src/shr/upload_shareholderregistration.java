package shr;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import service.DatabaseServiceImpl;
import service.Details;
import utility.ConfigReader;

public class upload_shareholderregistration {
	static WebDriver driver;
	static List<String> dataHolder = new ArrayList<>();

	static String header, even;
	static Details details;

	public upload_shareholderregistration(WebDriver driver) {

		upload_shareholderregistration.driver = driver;

		if (driver == null) {
			System.out.println("null value");
		}
		// TODO Auto-generated constructor stub
	}

	By evtngdropdown = By.xpath(
			"//body[1]/table[2]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[1]/td[1]");
	By drpdownshldrregfile = By.xpath("//tbody/tr[3]/td[2]/a[1]");
	By firstcutoffuploadradiobtn = By
			.cssSelector("table.outline:nth-child(3) tbody:nth-child(2) tr:nth-child(2) td.font > input:nth-child(1)");
	By seconduplaodradiobtn = By.xpath("//input[@id='uploadFileType']");
	By ckboxlastfileflag = By.xpath("//input[@id='lastFileFlag']");
	By selectfiletoupload = By.xpath("//input[@id='Uploadfile']");
	By submitbutton = By.xpath("//input[@id='submitButton']");
	By resetbutton = By.xpath("//tbody/tr[2]/td[1]/input[2]");
	String filesucessmsg = "File uploaded successfully with Process id";

	public static void filegeneration(String evenNo) throws ClassNotFoundException, IOException, SQLException, InterruptedException
	{
		sharholderfiletoupload.filereadutility(evenNo);
		Thread.sleep(6000);

	}
	public void uploadshareholderdropdown() throws IOException, ClassNotFoundException, SQLException, InterruptedException 
	{


		System.out.println(upload_shareholderregistration.class);

		ConfigReader configreader = new ConfigReader();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.findElement(evtngdropdown).click();
		driver.findElement(drpdownshldrregfile).click();
		System.out.println("-------inside upload shareholder file module------");
		String upload_type = ConfigReader.getProprty("Upload_Type");
		System.out.println("The selected upload type \t" + upload_type);
		String actualtitle = driver.getTitle();
		String expetitle = "Upload Registrar";
		SoftAssert sf = new SoftAssert();
		sf.assertEquals(expetitle, actualtitle);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

		if (upload_type.equals("First_upload")) {

			driver.findElement(firstcutoffuploadradiobtn).click();

			driver.findElement(selectfiletoupload).sendKeys("D:\\filetoupload\\output.zip");
			driver.findElement(submitbutton).click();
			if (driver.getPageSource().contains("Unable to read file"))

			{
				System.out.println("file contains error");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
			} else {
				System.out.println("file uploaded sucessfully with first uplaod");
			}

		}

		else if (upload_type.equals("Second_upload")) {

			driver.findElement(seconduplaodradiobtn).click();
			driver.findElement(selectfiletoupload).sendKeys("D:\\filetoupload\\output.zip");
			driver.findElement(ckboxlastfileflag).click();
			driver.findElement(submitbutton).click();

			if (driver.getPageSource().contains("Unable to read file")) {

				System.out.println("file contains error");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
			} else {
				System.out.println("file uploaded sucessfully with second uplaod");

			}

		}

	}

}


