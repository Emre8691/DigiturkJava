package test.tools.webapp.automation.Smoke;


import java.lang.reflect.Method;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import pages.CommonFunctions;
import pages.LoginPage;
import util.ExtentReports.ExtentTestManager;
import utils.Log;


public class MilkrunDeneme extends TestBase {
	String password="1234";
	String username = "milkrunadmin";
		
	@BeforeClass
	public void Browserchoose() throws Exception {
		//This will launch browser and specific url	
		WebDriver driver= initialization();
		//Created Page Object using Page Factory
		
		Thread.sleep(3000);
	}
	
	@Test(priority = 0, description = "Login Scenario with username and password.")
	public void LoginTest(Method method) throws InterruptedException {
	    ExtentTestManager.startTest(method.getName(), "Login Scenario with empty username and password.");
	    
	   		LoginPage login_page=PageFactory.initElements(driver, LoginPage.class);
	   		login_page.login(prop.getProperty("Username"),prop.getProperty("Password"));
	   		Thread.sleep(3000);
	   		clickButton(driver,"id",DEFINITIONS);
	   		Thread.sleep(3000);
	   		clickButton(driver,"id",MILKRUN);
		   		
	}
	
	
	
		
public void tearDown() {
	
	driver.quit();
	driver.close();
}	
}
