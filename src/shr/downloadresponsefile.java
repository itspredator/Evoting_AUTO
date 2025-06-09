package shr;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class downloadresponsefile {

	WebDriver driver;

	public downloadresponsefile(WebDriver driver) {
		this.driver = driver;

	}

	By evotingmenu = By.xpath("//strong[contains(text(),'e-Voting')]");
	By downresponsedropdown = By.xpath("//a[contains(text(),'Download Response File')]");
	By errorfilename = By.xpath("//table[2]/tbody[1]/tr[1]/td[6]/a");
	By outfiilename = By.xpath("//table[2]/tbody[1]/tr[1]/td[7]/a");

	public void clickondownloadresponsefile() {
		driver.findElement(evotingmenu).click();
		driver.findElement(downresponsedropdown).click();
		System.out.println("method clickondownloadresponsefile");
	}

	public void downaloderrorandoutfile() throws InterruptedException, AWTException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		String eventId = createeven.getExtractionofeven();
		if (eventId != null) {
			System.out.println("Event ID from config: " + eventId);
		} else {
			System.out.println("Event ID is not set.");
		}

		String outputText  = driver.findElement(outfiilename).getText();
		String errorText  = driver.findElement(errorfilename).getText();
		
		String evenfetchoutfile =null;
		String evenfetcherrofile =null;
		
		if (outputText != null && outputText.length() >= 11) {
		    evenfetchoutfile = outputText.substring(5, 11);
		}
		
		if(evenfetchoutfile == null || evenfetchoutfile.trim().isEmpty())
		{
			System.out.println("File not generated Yet");
		}
		else if (eventId.equals(evenfetchoutfile)) {
			driver.findElement(outfiilename).click();
			Thread.sleep(4000);
			Robot robot=new Robot();
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);		
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} else {
			System.out.println("Out file not found for even id" + evenfetchoutfile);
		}
		
		if (errorText != null && errorText.length() >= 11) {
		    evenfetcherrofile = errorText.substring(5, 11);
			}
		if(evenfetchoutfile == null || evenfetchoutfile.trim().isEmpty())
		{
			System.out.println("File not generated yet");
		}
		else if (eventId.equals(evenfetcherrofile)) {
			driver.findElement(errorfilename).click();
			Thread.sleep(4000);
			Robot robot=new Robot();
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);		
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			
		} else {
			System.out.println("error file not found for even id" + evenfetchoutfile);
		}

	}
}
