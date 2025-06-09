package utility;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;



public class Capture_Defects {
	
	public static WebDriver driver;
	
	public Capture_Defects(WebDriver driver) 
	{
		this.driver = driver ;
	}


	public static void takeSnapShot(String fileWithPath, ITestResult result) throws Exception{

        //Convert web driver object to TakeScreenshot
		
	

        TakesScreenshot scrShot =((TakesScreenshot) driver);

        //Call getScreenshotAs method to create image file
        LocalDateTime now = LocalDateTime.now();
        
        // Define the format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd:MM:yyyy");
        
        // Format the current date-time to the desired format
        String formattedDate = now.format(formatter);
        
                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

            //Move image file to new destination

                File DestFile=new File(fileWithPath + result.getName() + "_" +formattedDate.replace(":", "_")+ ".png");

                
//            	System.out.println("SrcFile : " + SrcFile);
//            	System.out.println("DestFile : " + DestFile);
                //Copy file at destination

                FileUtils.copyFile(SrcFile, DestFile);
                
    }

}
