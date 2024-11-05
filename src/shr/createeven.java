package shr;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.time.DateTimeException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import service.DatabaseServiceImpl;
import service.Details;
import utility.ConfigReader;

public class createeven extends Evencreation {

	private WebDriver driver;
	public List<Evencreation> even;
	public static Properties properties;
	public static String extractionofeven;
	createeven gEven;
	public static sharholderfiletoupload  sharholderfiletoupload;



	By evtngdropdown = By.xpath("//font[contains(text(),'e-Voting')]");
	By registerevtngdtls = By.xpath(
			"//body[1]/table[2]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[2]/td[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]");
	By approachradiobtn = By.xpath("//input[@id='currentApproach']");
	By isinnoinputbox = By.xpath("//input[@id='isin']");
	By issuername = By.xpath("//input[@id='Issuer']");
	By isindescription = By.xpath("//input[@id='Isinname']");
	By startcalender = By.xpath("//tbody/tr[4]/td[2]/a[1]/img[1]");
	By monthofcalender = By.xpath("//span[contains(text(),'January')]");
	By yearofcalender = By.xpath("//tbody/tr[1]/td[6]/input[1]");
	By dateofcalender = By.xpath("//a[contains(text(),'12')]");
	By inputboxstartdate = By.xpath("//input[@id='startDate']");
	By inputboxlastdatedispatch = By.xpath("//input[@id='lastDateOfDispatch']");
	By inputboxenddate = By.xpath("//input[@id='endDate']");
	By inputboxresultdate = By.xpath("//input[@id='resultDate']");
	By inputboxcutoffdate = By.xpath("//input[@id='cutOffDate']");
	By inputboxstarttime = By.xpath("//input[@id='startTime']");
	By inputboxendtime = By.xpath("//input[@id='endTime']");
	By inputboxgenmeetdate = By.xpath("//input[@id='startDateOfGm']");
	By inputboxgenmeettime = By.xpath("//input[@id='startTimeOfGm']");
	By checkboxmodeofvote = By.xpath("//input[@id='Remote']");
	By inputboxnoofvacancy = By.xpath("//input[@id='numberOfVacancy']");
	By logofilebrowse = By.xpath("//input[@id='logoFile']");
	By resolutionfileupload = By.xpath("//input[@id='resolutionFile']");
	By uploadannexture = By.xpath("//input[@id='annexureFile']");
	By inputboxresolutionTitle = By.xpath("//input[@id='resolutionTitle']");
	By inputboxresolutionDesc = By.xpath("//textarea[@id='resolutionDesc']");
	By submitbutton = By.xpath("//input[@id='searchButton']");
	By resetbutton = By.id("searchButton2");
	By logoutbutton = By.xpath("//font[contains(text(),'Logout')]");
	By okbuttonevencreation = By.xpath("//input[@id='searchButton']");
	By votetypepostal = By.xpath("//input[@id='postalballot']");
	By votetygeneralmeet = By.xpath("//input[@id='generalmeeting']");
	By votetypedirectorelec = By.xpath("//input[@id='directorelection']");
	By addresolutionbutton = By.xpath("//input[@id='searchButton1']");
	By deleteresoutionbutton = By.xpath("//input[@id='regButton']");
	By evennogettext = By.xpath(
			"/html[1]/body[1]/table[1]/tbody[1]/tr[3]/td[1]/center[1]/table[1]/tbody[1]/tr[3]/td[1]/font[2]/span[1]/a[1]");

	

	public createeven() {
		super();
		// TODO Auto-generated constructor stub
	}

	public createeven(WebDriver driver) {
		this.driver = driver;
	}

	public createeven(String even) {
		extractionofeven = even;
	}

	public static String getExtractionofeven() {
		return extractionofeven;
	}

	public static void setExtractionofeven(String extractionofeven) {
		createeven.extractionofeven = extractionofeven;
	}

	public createeven evenformfill(Evencreation evenObj) throws InterruptedException, AWTException, ClassNotFoundException, IOException, SQLException {

		ConfigReader configreader = new ConfigReader();
		String Voting_Type = ConfigReader.getProprty("Voting_Type");
		System.out.println("The selected Voting type \t" + Voting_Type);

		
		
			if (evenObj.getISIN().trim() != null && evenObj.getISIN().trim().length() != 0) {

				driver.findElement(evtngdropdown).click();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
				driver.findElement(registerevtngdtls).click();
				if (driver.findElement(approachradiobtn).isSelected()) {
					System.out.println("correct approach type");
				} else {
					driver.findElement(approachradiobtn).click();
				}

				driver.findElement(isinnoinputbox).sendKeys(evenObj.getISIN());
				driver.findElement(issuername).sendKeys(evenObj.getIssuer());
				driver.findElement(isindescription).sendKeys(evenObj.getISIN_Description());

				// driver.findElement(startcalender).click();
				Actions ac = new Actions(driver);
				driver.findElements(By.tagName("input"));
				List<WebElement> inputs = driver.findElements(By.tagName("input"));
				for (WebElement input : inputs) {
					((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly','readonly')",
							input);

				}
				if (Voting_Type.equals("Postal_ballot")) {
					if (driver.findElement(votetypepostal).isSelected())
						;
					{
						driver.findElement(inputboxstartdate).sendKeys(evenObj.getVoting_Start_Date());
						Robot rb = new Robot();
						rb.keyPress(KeyEvent.VK_TAB);
						driver.findElement(inputboxlastdatedispatch).sendKeys(evenObj.getLast_date_dispatch());
						rb.keyPress(KeyEvent.VK_TAB);
						driver.findElement(inputboxenddate).sendKeys(evenObj.getVoting_End_Date());
						rb.keyPress(KeyEvent.VK_TAB);
						driver.findElement(inputboxresultdate).sendKeys(evenObj.getVoting_Result_Date());
						rb.keyPress(KeyEvent.VK_TAB);
						driver.findElement(inputboxcutoffdate).sendKeys(evenObj.getCut_Off_Date());
						rb.keyPress(KeyEvent.VK_TAB);
						driver.findElement(inputboxstarttime).sendKeys(evenObj.getEvoting_Start_Time());
						rb.keyPress(KeyEvent.VK_TAB);
						driver.findElement(inputboxendtime).sendKeys(evenObj.getEvoting_End_Time());
						rb.keyPress(KeyEvent.VK_TAB);
						driver.findElement(inputboxresolutionTitle).sendKeys("postal ballot- secrestary  anurag verma");
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
						driver.findElement(inputboxresolutionDesc).sendKeys("postal ballot- secrestary  anurag verma@");
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
						driver.findElement(submitbutton).click();

						Thread.sleep(4000);
						try {

							Alert alert = driver.switchTo().alert();

							alert.accept();
							// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
						} catch (NoAlertPresentException ex) {
							// Alert not present
							ex.printStackTrace();
						}

						gEven = new createeven(driver.findElement(evennogettext).getText());
						System.out.println("Even no generated is \n" + gEven.getExtractionofeven());

						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("document.getElementById('searchButton').click();");
					}


				} else if (Voting_Type.equals("General_meeting")) {
					try {
						driver.findElement(votetygeneralmeet).click();
						driver.findElement(inputboxstartdate).sendKeys(evenObj.getVoting_Start_Date());
						Robot rb = new Robot();
						rb.keyPress(KeyEvent.VK_TAB);
						driver.findElement(inputboxgenmeetdate).sendKeys(evenObj.getGeneral_Meeting_Date());
						rb.keyPress(KeyEvent.VK_TAB);
						driver.findElement(inputboxlastdatedispatch).sendKeys(evenObj.getLast_date_dispatch());
						rb.keyPress(KeyEvent.VK_TAB);
						driver.findElement(inputboxenddate).sendKeys(evenObj.getVoting_End_Date());
						rb.keyPress(KeyEvent.VK_TAB);
						driver.findElement(inputboxresultdate).sendKeys(evenObj.getVoting_Result_Date());
						rb.keyPress(KeyEvent.VK_TAB);
						driver.findElement(inputboxcutoffdate).sendKeys(evenObj.getCut_Off_Date());
						rb.keyPress(KeyEvent.VK_TAB);
						driver.findElement(inputboxstarttime).sendKeys(evenObj.getEvoting_Start_Time());
						rb.keyPress(KeyEvent.VK_TAB);
						driver.findElement(inputboxgenmeettime).sendKeys(evenObj.getGeneral_Meeting_Start_Time());
						rb.keyPress(KeyEvent.VK_TAB);
						driver.findElement(inputboxendtime).sendKeys(evenObj.getEvoting_End_Time());
						rb.keyPress(KeyEvent.VK_TAB);
						driver.findElement(inputboxresolutionTitle).sendKeys("postal ballot- secrestary  anurag verma");
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
						driver.findElement(inputboxresolutionDesc).sendKeys("postal ballot- secrestary  anurag verma@");
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
						driver.findElement(submitbutton).click();
						Thread.sleep(4000);
						try {

							Alert alert = driver.switchTo().alert();

							alert.accept();

						} catch (NoAlertPresentException ex) {
							// Alert not present
							ex.printStackTrace();
						}
						gEven = new createeven(driver.findElement(evennogettext).getText());

						System.out.println("Even no generated is \n" + gEven.getExtractionofeven());

						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("document.getElementById('searchButton').click();");
					} catch (DateTimeException e) {
						e.getStackTrace();

					}
				}

				else if (Voting_Type.equals("Director_election")) {
					try {
						driver.findElement(votetypedirectorelec).click();
						driver.findElement(inputboxstartdate).sendKeys(evenObj.getVoting_Start_Date());
						Robot rb = new Robot();
						rb.keyPress(KeyEvent.VK_TAB);
						// driver.findElement(inputboxgenmeetdate).sendKeys(evenObj.getGeneral_Meeting_Date());
						// rb.keyPress(KeyEvent.VK_TAB);
						driver.findElement(inputboxlastdatedispatch).sendKeys(evenObj.getLast_date_dispatch());
						rb.keyPress(KeyEvent.VK_TAB);
						driver.findElement(inputboxenddate).sendKeys(evenObj.getVoting_End_Date());
						rb.keyPress(KeyEvent.VK_TAB);
						driver.findElement(inputboxresultdate).sendKeys(evenObj.getVoting_Result_Date());
						rb.keyPress(KeyEvent.VK_TAB);
						driver.findElement(inputboxcutoffdate).sendKeys(evenObj.getCut_Off_Date());
						rb.keyPress(KeyEvent.VK_TAB);
						driver.findElement(inputboxstarttime).sendKeys(evenObj.getEvoting_Start_Time());
						rb.keyPress(KeyEvent.VK_TAB);
						// driver.findElement(inputboxgenmeettime).sendKeys(evenObj.getGeneral_Meeting_Start_Time());
						// rb.keyPress(KeyEvent.VK_TAB);
						driver.findElement(inputboxendtime).sendKeys(evenObj.getEvoting_End_Time());
						rb.keyPress(KeyEvent.VK_TAB);
						driver.findElement(inputboxnoofvacancy).sendKeys("1");
						driver.findElement(inputboxresolutionTitle).sendKeys("Direction election-Pinkesh Choudhary");
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
						driver.findElement(inputboxresolutionDesc).sendKeys("election of directores");
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
						driver.findElement(submitbutton).click();
						Thread.sleep(4000);
						try {

							Alert alert = driver.switchTo().alert();

							alert.accept();

						} catch (NoAlertPresentException ex) {
							// Alert not present
							ex.printStackTrace();
						}

						gEven = new createeven(driver.findElement(evennogettext).getText());

						System.out.println("Even no generated is \n" + gEven.getExtractionofeven());

						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("document.getElementById('searchButton').click();");

						Thread.sleep(60000);
					} catch (DateTimeException e) {
						e.getStackTrace();

					}
				}
			}
			
		return gEven;

	}


	// TODO Auto-generated method stub
}
