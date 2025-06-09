package shr;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class downloadpinmailer {

	WebDriver driver;
	String filestatus;

	public downloadpinmailer(WebDriver driver) {
		this.driver = driver;

	}

	By evotingmenu = By.xpath("//strong[contains(text(),'e-Voting')]");
	By downlaodevenwsepinmailer = By.xpath("//a[contains(text(),'Download Even Wise Pin Mailer File')]");
	By evennoclick = By.xpath("//tr[2]/td[1]/table[1]/tbody[1]/tr[2]/td[1]/a");
	By generatepinmailerbutton = By.id("pinbutton");
	By refreshstatusbutton = By.xpath("//input[@id='refresh_button']");
	By confirmpinmailerbutton = By.xpath("//input[@id='pinbutton']");
	By backonconfirmpinmailer = By.xpath("//input[@id='refresh_button']");
	By clickongeneratefile = By.xpath("//td[@id='tableCellID']");
	By Fileprocessstatus = By.xpath("//tr[2]/td[1]/table[1]/tbody[1]/tr[2]/td[6]");
	By Homepageclick = By.xpath("//strong[contains(text(),'Home')]");
	By Pinmailerfileszip = By.xpath("//tr[2]/td[1]/table[1]/tbody[1]/tr[2]/td[7]");
	By Pdownloadbtn1 = By.xpath("//table[2]//tr[2]/td[4]/input[1]");
	By PIdownloadbtn2 = By.xpath("//tr//tr[3]//td[4]//input[1]");

	@SuppressWarnings("deprecation")
	public void clickondownlaodevenwsepinmailerfile() {
		driver.findElement(evotingmenu).click();
		driver.findElement(evotingmenu).click();
		driver.findElement(downlaodevenwsepinmailer).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		String evenId = createeven.getExtractionofeven();
		if (evenId != null) {
			System.out.println("Event ID from config: " + evenId);
		} else {
			System.out.println("Event ID is not set.");
		}

		String evenno = driver.findElement(evennoclick).getText();
		if (evenId.equals(evenno)) {

			System.out.println("evenno found sucessfully: " + evenno);
			driver.findElement(evennoclick).click();
		} else {
			System.out.println("evenno not matched");
		}
	}

	@SuppressWarnings("deprecation")
	public void generatepinmailerfile() throws InterruptedException, AWTException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		String genpinactual_page = driver.getTitle();
		String expectedpinpage = "Pin Mailer File Generation";
		Assert.assertEquals(genpinactual_page, expectedpinpage);
		// assert.assertEquals(genpinactual_page, expectedpinpage)

		String actualStatus = driver.findElement(Fileprocessstatus).getText();
		System.out.println("file_status:" + actualStatus);
		if (actualStatus.equals("File Uploaded")) {
			System.out.println("--------File is not processed yet.Kindly check the listeners-----");
		}

		else if (actualStatus.equals("File Under Processing")) {
			while (true) {

				driver.findElement(refreshstatusbutton).click();
				Thread.sleep(2000);
				actualStatus = driver.findElement(Fileprocessstatus).getText();
				   System.out.println("Current status: " + actualStatus);
				if (actualStatus.equals("File Processed")) {
					break;
				}
			}
			driver.findElement(generatepinmailerbutton).click();
			Thread.sleep(3000);
			driver.findElement(confirmpinmailerbutton).click();
			driver.findElement(Pinmailerfileszip).click();
		}

		else if (actualStatus.equals("File Processed")) {

			Thread.sleep(2000);
			driver.findElement(generatepinmailerbutton).click();
			Thread.sleep(3000);
			driver.findElement(confirmpinmailerbutton).click();
			driver.findElement(Pinmailerfileszip).click();
		}

		else {
			System.out.println("No matching status found");
		}

		Thread.sleep(5000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(5000);
		driver.findElement(Pdownloadbtn1).click();
		Thread.sleep(4000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(5000);
		driver.findElement(PIdownloadbtn2).click();
		Thread.sleep(4000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
}
