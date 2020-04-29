package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import java.time.Duration;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.CommonFunctions;
import util.Listeners.*;
import util.ExtentReports.*;


public class TestBase extends CommonFunctions{
	
	public static WebDriver driver; 
	public static Properties property;
	public static ChromeOptions chromeOptions;
	public static Logger Log;
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	public static Properties prop;
	 
		public TestBase(){
		
		Log = Logger.getLogger(this.getClass());
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java"
					+ "/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
		
	public WebDriver getDriver() {
        return driver;
    }
 
	public static WebDriver initialization(){
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("CH")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/tools/driver/chromedriver.exe");
			System.setProperty("webdriver.chrome.logfile", "./Chromelog.txt");
			//System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			// Testi Chrome tarayıcıda çalıştırmak için
	        WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "/src/main/resources/tools/driver/geckodriver.exe");	
	
			  WebDriverManager.firefoxdriver().setup();
			  driver = new FirefoxDriver(); 
		}
		
		
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(TestListener.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
		return driver;
		}
	
	 
	@AfterTest
	public void endReport()
	{
		extent.flush();
		extent.close();
	}
	
	public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
		//Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		File DestFile=new File(fileWithPath);
		//Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
		}

	@AfterMethod
	public void tearDown(ITestResult result) throws Exception
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			extentTest.log(LogStatus.FAIL, "Test Case Failed is "+result.getName()); //To Add Name in Extent Report.
			extentTest.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable()); //To Add Errors and Exceptions in Extent Report.
			TestBase.takeSnapShot(driver, "C:\\Users\\TR24220\\eclipse-workspace2\\selenium.project\\Screenshot\\test.png") ;     

	//		extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); //To Add Screenshot in Extent Report.
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			extentTest.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
			
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			extentTest.log(LogStatus.PASS, "Test Case Passed is " + result.getName());
		}
		extent.endTest(extentTest); //Ending Test and Ends the Current Test and Prepare to Create HTML Report.
		driver.quit();
		Log.info("Browser Terminated");
		Log.info("-----------------------------------------------");
	}
	
	
}
	