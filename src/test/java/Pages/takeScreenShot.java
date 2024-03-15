package Pages;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import java.text.SimpleDateFormat;

public class takeScreenShot {
	WebDriver driver;
	
	  public takeScreenShot(WebDriver driver) {
	        this.driver = driver;
	        
	    }
	  
	  
	 
	  public void takeScreenshot() {
		  
		Date currentDate=new Date();
		  
		  String ScreenShotFileName=currentDate.toString().replace(" ","-").replace(":","-");
		  
	        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        try {
	            FileUtils.copyFile(screenshot, new File(".//screenshots//"+ScreenShotFileName+".png"));
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

}
