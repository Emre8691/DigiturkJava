package test.tools.webapp.automation.Smoke;


import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import pages.CommonFunctions;
import pages.LoginPage;
import pages.Logout;
import pages.VueLoginPage;
import utils.Log;
import utils.ExtentReports.ExtentTestManager;
import utils.Listeners.*;

public class MilkrunDeneme extends TestBase {
		
	@BeforeClass
	public void Browserchoose() throws Exception {
		//This will launch browser and specific url	
		initialization();
		//Created Page Object using Page Factory
		
		Thread.sleep(3000);
	}
	
	@Test(priority = 0, description = "Login Scenario with username and password.")
	public void LoginTest(Method method) throws InterruptedException {
	    ExtentTestManager.startTest(method.getName(), "Login Scenario with empty username and password.");
	    
	   		VueLoginPage login_page=PageFactory.initElements(driver, VueLoginPage.class);
	   		login_page.login(prop.getProperty("Username2"),prop.getProperty("Password"));
	   		Thread.sleep(2000);
	   		/*waitVisibility(driver,"id",DEFINITIONS);
	   		clickButton(driver,"id",DEFINITIONS);
	   		waitVisibility(driver,"id",MILKRUN);	   		
	   		clickButton(driver,"id",MILKRUN);
	   		waitVisibility(driver,"id",DIMENSION);
	   		clickButton(driver,"id",DIMENSION);
	   		waitVisibility(driver,"xpath",ADD_DIMENSION);
	   		clickButton(driver,"xpath",ADD_DIMENSION);
	   		Sendkeys(driver,"xpath",DimensionName,"package");*/
	   		
	   		Thread.sleep(2000);
	}
	
	
	
}
