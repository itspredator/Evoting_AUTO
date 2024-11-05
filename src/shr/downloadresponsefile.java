package shr;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class downloadresponsefile
{	
	
	WebDriver driver;	
	public downloadresponsefile(WebDriver driver)
	 {
		this.driver=driver;

	 }

	By evotingmenu=By.xpath("//strong[contains(text(),'e-Voting')]");
	By downresponsedropdown=By.xpath("//a[contains(text(),'Download Response File')]");
	By errorfilename=By.xpath("/html[1]/body[1]/table[1]/tbody[1]/tr[3]/td[1]/table[2]/tbody[1]/tr[1]/td[6]/a[1]");
	By outfiilename=By.xpath("/html[1]/body[1]/table[1]/tbody[1]/tr[3]/td[1]/table[2]/tbody[1]/tr[1]/td[7]/a[1]");

	@SuppressWarnings("deprecation")
	public void clickondownloadresponsefile()
	{
		driver.findElement(evotingmenu).click();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		driver.findElement(downresponsedropdown).click();
		System.out.println("method clickondownloadresponsefile");
	}
	@SuppressWarnings("deprecation")
	public void downaloderrorandoutfile()
	{
		
		
		String evenfecth=driver.findElement(errorfilename).getText().substring(5, 11);
		System.out.println(evenfecth);
		driver.findElement(errorfilename).click();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		driver.navigate().back();
		driver.findElement(outfiilename).click();
		System.out.println("method downaloderrorandoutfile");
	}
}

