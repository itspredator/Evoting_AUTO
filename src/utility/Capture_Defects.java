package utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import Testfinalpage.Testpage;



public class Capture_Defects {
	
	public static WebDriver driver;
	
	public Capture_Defects() {
		this.driver = Testpage.getDriver();
	}


	public static void takeSnapShot(String fileWithPath, ITestResult result) throws Exception{

        //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot) driver);

        //Call getScreenshotAs method to create image file

                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

            //Move image file to new destination

                File DestFile=new File(fileWithPath + result.getName() + "_" + System.currentTimeMillis() + ".png");

                //Copy file at destination

                FileUtils.copyFile(SrcFile, DestFile);

    }

}
