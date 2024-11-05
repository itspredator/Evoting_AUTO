package utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import tech.grasshopper.pdf.pojo.cucumber.Scenario;

public class ElementUtil {
	public static Scenario scenario;	
	public static void takeSnapShot(WebDriver webdriver,String methodName) throws Exception{
		//Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);

		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		//File DestFile=new File(fileWithPath);
		String screenShotName = String.valueOf(new 
                SimpleDateFormat("yy.MM.dd.HH.mm.ss").format(new Date()))+methodName;
		System.out.println("IMAGE NAME >>"+screenShotName);
		 File screenshot = new File( "Sucess/"+screenShotName + ".png");
		//Copy file at destination
		FileUtils.copyFile(SrcFile, screenshot);
		}
}
