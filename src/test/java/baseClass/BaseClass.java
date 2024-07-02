package baseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass 
{
	 public static WebDriver driver;
	 public Properties property;

	    @BeforeClass
	    public void setup() throws IOException
	    {
	    	property=new Properties();
	    	try 
	    	{
				FileInputStream fis=new FileInputStream("src/test/resources/config.properties");
				property.load(fis);
			} 
	    	catch (FileNotFoundException e)
	    	{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        driver = new ChromeDriver();
	        driver.manage().deleteAllCookies();
	        driver.get(property.getProperty("appURL"));
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    }
	    
	    @AfterClass
	    public void tearDown()
	    {
	        driver.quit();
	    }

	    public String captureScreen(String tname)throws IOException
	    {
	        
			String timestamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

	        TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
	        File sourceFile=takesScreenshot.getScreenshotAs(OutputType.FILE);

	        String targetFilePathString="/Users/arnabmacbook/Desktop/Automation_Demo_Projects/loginTest_Demo/Screenshot/"+ tname + "_" + timestamp + ".jpg";
	        File targetFile=new File(targetFilePathString);
	        sourceFile.renameTo(targetFile);

	        return targetFilePathString;
	    }

}
