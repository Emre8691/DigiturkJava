package test.tools.webapp.automation.Smoke;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.TestBase;
import pages.LoginPage;
import pages.TakeScreenshot;
import utils.Log;
import utils.ExtentReports.ExtentTestManager;

@Test
public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp(Method method)
	{  	 //ExtentReports Description
        ExtentTestManager.startTest(method.getName(), "Application Launched Successfully");
        	
		initialization();
		Log.info("Application Launched Successfully");
		
	}
	

	@Test(priority = 0, description = "Login Scenario with username and password.")
	public void loginTest(Method method) throws InterruptedException
	{	
		 //ExtentReports Description
        ExtentTestManager.startTest(method.getName(), "Login Scenario with empty username and password.");
 
		LoginPage login_page=PageFactory.initElements(driver, LoginPage.class);
		login_page.login(prop.getProperty("Username"),prop.getProperty("Password"));
		Thread.sleep(3000);
			    
	}
	
	@Test(priority = 1, description = "Title Test")
	public void TitleTest(Method method) throws InterruptedException {
		ExtentTestManager.startTest(method.getName(), "Title test");

		String title= driver.getTitle();
		 System.out.println(title);
		 Assert.assertEquals(title,"Itelligence123");
		 Thread.sleep(2000);
		    
	}
	
	@Test(priority = 2, description = "Loggout into the Application succesfully.") 
	public void logoutTest(Method method) throws InterruptedException
	{	
		//LoginPage login_page=PageFactory.initElements(driver, LoginPage.class);			
		waitVisibility(driver,"xpath",AVATARHEADER);
		clickButton(driver,"xpath",AVATARHEADER);
		clickButton(driver,"xpath",LOGOUT);		
	
	}
	public void tearDown() {
		
		driver.quit();
		driver.close();
	}	

}
