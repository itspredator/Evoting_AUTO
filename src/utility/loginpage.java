package utility;

import java.awt.AWTException;
import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
	By checkterms = By.xpath("//input[@id='checkTerms']");

	// unique xpaths
	By rtaloginbtndash = By.xpath("//button[@id='RTALogin']");
	By scutiniserloginbtdash = By.xpath("//button[@id='ScrLogin']");
	By memberloginbtndash = By.xpath("//button[@id='InvLogin']");
	By custodinaloginbtndash = By.xpath("//button[@id='CtnLogin']");
	By otpinputbox = By.xpath("//input[@id='otpNumber']");
	By otpsubmitbtn = By.xpath("//input[@id='submitButton']");
	By otpresendbtn = By.xpath("//input[@id='Button']");
	By refreshbutton = By.xpath("//tbody/tr[1]/td[1]/div[1]/img[1]");
	By captchamismatch = By.xpath("//u[normalize-space()='Captcha mismatch !!']");

	@SuppressWarnings("deprecation")
	public void login(String username, String password, String moduleType)
			throws InterruptedException, AWTException, ClassNotFoundException, SQLException, IOException {
		driver.get(Url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		if (moduleType.equals("RTA")) {
			driver.findElement(rtaloginbtndash).click();
			System.out.println("RTA Login page");
		} else if (moduleType.equals("Member")) {
			driver.findElement(memberloginbtndash).click();
			System.out.println("Member Login page");
		} else if (moduleType.equals("Scrutiniser")) {
			driver.findElement(scutiniserloginbtdash).click();
			System.out.println("Scrutiniser Login page");
		} else if (moduleType.equals("Custodian")) {
			driver.findElement(custodinaloginbtndash).click();
			System.out.println("Custodian Login page");
		}
		//for failure password:

		boolean captchaFlag = true;

		while (captchaFlag) {
		    // Enter credentials
		   driver.findElement(userid).sendKeys(username);
		    driver.findElement(pass).sendKeys(password);

		    // Read and enter captcha
		    CapchaReader.getCapcha(driver, captchainnputbox, moduleType);

		    // Accept terms if required
		    if (moduleType.equals("Member") || moduleType.equals("Custodian")) {
		        driver.findElement(checkterms).click();
		    }

		    // Click login
		    driver.findElement(loginbutton).click();

		    // Wait briefly for the page to respond
		    Thread.sleep(2000); // Consider using WebDriverWait instead

		    // Check for captcha mismatch
		    List<WebElement> mismatchElements = driver.findElements(captchamismatch);
		    for(WebElement a:mismatchElements)
		    {
		    	System.out.println("elements are as follows:"+a);
		    }
		    if (!mismatchElements.isEmpty()) {
		        WebElement mismatchElement = mismatchElements.get(0);
		        if (mismatchElement.isDisplayed()) {
		            String captchamismatchtext = mismatchElement.getText();
		            System.out.println("Captcha error: " + captchamismatchtext);

		            if (driver.getCurrentUrl().startsWith("https://10.150.7.19/eVotingWeb")
		                    && captchamismatchtext.equals("Captcha mismatch !!")) {
		                driver.findElement(refreshbutton).click();
		                JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		                jsExecutor.executeScript("document.querySelector('td.error').innerText = '';");
		            }
		        }
		    } else {
		        // No captcha mismatch element found, assume login successful
		        captchaFlag = false;
		    }
		}

		// OTP handling after successful login
		if (driver.getCurrentUrl().startsWith("https://10.150.7.19/eVotingWeb/certlogin.do")) {
		    String otp = otpauthenticator.otpAuth(username);
		    System.out.println("OTP: " + otp);
		    driver.findElement(otpinputbox).click();
		    driver.findElement(otpinputbox).sendKeys(otp);
		    driver.findElement(otpsubmitbtn).click();
		    Thread.sleep(5000); // Consider replacing with WebDriverWait
		}


		else if (driver.getCurrentUrl().startsWith("https://10.150.7.19/eVotingWeb/login.do")) {
			String otp = otpauthenticator.otpAuth(username);
			System.out.println(otp);
			driver.findElement(otpinputbox).click();
			driver.findElement(otpinputbox).sendKeys(otp);
			driver.findElement(otpsubmitbtn).click();
			Thread.sleep(5000);
		} else {
			System.out.println("Invalid credentials");
		}

	}

}
