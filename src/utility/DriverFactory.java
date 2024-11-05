package utility;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	public WebDriver driver;
	String downaloadirectory="C:\\Users\\Pinkeshc\\Desktop\\desktop dust\\filedownload";
	// use of java 8 feature thread local
	//public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	/**
	 * this method is used to initialize the thread local driver on basis of given
	 * browser will return webdriver
	 */
	public WebDriver init_driver(String browser) 
	{

		if (browser.equals("Chrome")) {
			System.out.println("Browser name: " + browser + " Selected");
			WebDriverManager.chromedriver().setup();
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--guest");
			options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
			options.addArguments("download.default_directory=" +downaloadirectory);
			options.addArguments("download.prompt_for_download=false"); // Disable the download prompt
			options.addArguments("download.directory_upgrade=true");   
			//String path=System.getProperty("user.dir");
			//System.setProperty("webdriver.chrome.driver",path+"\\drivers\\chromedriver.exe");
			driver= new ChromeDriver(options);
			//lDriver.set(new ChromeDriver());
		} else if (browser.equals("firefox")) {
			// It create firefox profile
			FirefoxProfile profile = new FirefoxProfile();

			// This will set the true value
			profile.setAcceptUntrustedCertificates(true);

			// This will open firefox browser using above created profile

			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			//tlDriver.set(new FirefoxDriver());
		} else if (browser.equals("edge")) {

			// InternetExplorerOptions options = new InternetExplorerOptions().setPageLoadStrategy(PageLoadStrategy.NONE);

			// options.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

			//WebDriver driver=new InternetExplorerDriver(options);
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
			//tlDriver.set(new InternetExplorerDriver());

		}  else {
			System.out.println("Please pass correct value for browser : " + browser);
		}
		//driver.manage().deleteAllCookies();
		//driver.manage().window().maximize();
		return driver;
	}

	/*
	 * synchronized key word used when ever if we want to run code on different
	 * machine simultaneously If 5 thread running together then all thread running
	 * and try to call this method for this reason used sync 
	 * thread local piece then we can used as below
	 */

}
