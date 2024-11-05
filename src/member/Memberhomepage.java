package member;

import java.awt.Robot;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.ibm.db2.jcc.am.dr;

import utility.ConfigReader;

public class Memberhomepage {
	
	By markallfavour=By.xpath("//tbody/tr[4]/td[1]/input[1]");
	By markallagainst=By.xpath("//tbody/tr[4]/td[1]/input[2]");
	By printbutton=By.xpath("//input[@id='printButton']");
	By submitbutton=By.xpath("//tbody/tr[1]/td[1]/input[2]");
	By resetallbutton=By.xpath("//tbody/tr[1]/td[1]/input[3]");
	By backbutton=By.xpath("//input[@id='backButton']");
	By confirmbutton=By.cssSelector("#confirmButton");
	By confirmscreenback=By.xpath("//input[@id='searchButton']");
	By caststatus=By.xpath("//td[contains(text(),'Vote cast successfully. Click on the Print button ')])");
	By okbuttonaftercast=By.xpath("//tbody/tr[5]/td[1]/input[2]");
	
	static String getevenno;
	WebDriver driver;
	
	
	public Memberhomepage(WebDriver driver) {
		super();
		this.driver = driver;
		ConfigReader configReader = new ConfigReader();
		getevenno = ConfigReader.getProprty("EVEN_NO");
	}

	
	public void membervote() throws InterruptedException
	{	
		driver.findElement(By.linkText(getevenno)).click();
		driver.findElement(markallfavour).click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,650)", "");
		driver.findElement(submitbutton).click();
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,650)", "");
		Thread.sleep(1000);
		driver.findElement(confirmbutton).click();
		driver.findElement(okbuttonaftercast).click();
//		System.err.println(driver.findElement(caststatus).getText());
//		Assert.assertEquals("Vote cast successfully. Click on the Print button below to print the details of the current eVoting cycle.", driver.findElement(caststatus).getText());
		driver.findElement(By.linkText("Logout"));
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(4000));
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Click here")));
		//driver.findElement(By.linkText("Click here"));
		
	}
	

}
