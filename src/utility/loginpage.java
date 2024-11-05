package utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginpage {

	static WebDriver driver;

	public loginpage(WebDriver driver) {
		loginpage.driver = driver;
	}


	// common xpaths 
	String Url = "https://10.150.7.19/eVotingWeb/resolutionFileDwn.do";
	By userid = By.xpath("//input[@id='userId']");
	By pass = By.cssSelector("#pwd");
	By captchainnputbox = By.xpath("//input[@id='captcha']");
	By loginbutton = By.xpath("//input[@id='loginButton']");
	By logincaptaimage = By.xpath("//img[@id='captch-image-control']");
	By checkterms=By.xpath("//input[@id='checkTerms']");

	// unique xpaths 
	By rtaloginbtndash = By.xpath("//button[@id='RTALogin']");
	By scutiniserloginbtdash = By.xpath("//button[@id='ScrLogin']");
	By memberloginbtndash = By.xpath("//button[@id='InvLogin']");
	By custodinaloginbtndash = By.xpath("//button[@id='CtnLogin']");
	By otpinputbox=By.xpath("//input[@id='otpNumber']");
	By otpsubmitbtn=By.xpath("//input[@id='submitButton']");
	By otpresendbtn=By.xpath("//input[@id='Button']");
	@SuppressWarnings("deprecation")
	public void login(String username, String password, String moduleType) throws InterruptedException, AWTException, ClassNotFoundException, SQLException, IOException 
	{
		driver.get(Url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		if (moduleType.equals("RTA")) {
			driver.findElement(rtaloginbtndash).click();
			System.out.println("RTA Login page");
		}
		else if (moduleType.equals("Member")) {
			driver.findElement(memberloginbtndash).click();
			System.out.println("Member Login page");
		}
		else if (moduleType.equals("Scrutiniser")) {
			driver.findElement(scutiniserloginbtdash).click();
			System.out.println("Scrutiniser Login page");
		}
		else if (moduleType.equals("Custodian")) {
			driver.findElement(custodinaloginbtndash).click();
			System.out.println("Custodian Login page");
		}




		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
		// wait1.until(ExpectedConditions.presenceOfAllElementsLocatedBy(rtauserid));

		driver.findElement(userid).sendKeys(username);
		driver.findElement(pass).sendKeys(password);


		CapchaReader.getCapcha(driver, captchainnputbox, moduleType);

		if (moduleType.equals("Member") || moduleType.equals("Custodian")) {
			driver.findElement(checkterms).click();

		}


		driver.findElement(loginbutton).click();


		if (driver.getCurrentUrl().equals("https://10.150.7.19/eVotingWeb/login.do"))
		{
			System.out.println("Valid credentials");

			String otp =  otpauthenticator.otpAuth(username);
			System.out.println(otp);
			driver.findElement(otpinputbox).click();
			driver.findElement(otpinputbox).sendKeys(otp);
			driver.findElement(otpsubmitbtn).click();
			Thread.sleep(5000);
		}

		else 
		{
			System.out.println("Invalid credentials");


		}

	}

}
