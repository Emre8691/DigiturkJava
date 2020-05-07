package test.tools.webapp.automation.Smoke;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.TestBase;
import pages.VueLoginPage;
import utils.ExtentReports.ExtentTestManager;

public class ContactTest extends TestBase {
	@BeforeClass
	public void Browserchoose() throws Exception {
		//This will launch browser and specific url	
		initialization();
		//Created Page Object using Page Factory
		
		Thread.sleep(3000);
	}
	
	@Test(priority = 0, description = "Contact Scenario.")
	public void LoginTest(Method method) throws InterruptedException {
	    ExtentTestManager.startTest(method.getName(), "Contact Scenario add/edit/delete region.");
	    
	   		VueLoginPage login_page=PageFactory.initElements(driver, VueLoginPage.class);
	   		login_page.login(prop.getProperty("Username2"),prop.getProperty("Password"));
	   		Thread.sleep(2000);
	   		
	   		waitVisibility(driver,"xpath",VUEDEFINITIONS);
	   		clickButton(driver,"xpath",VUEDEFINITIONS);
	   		
	   		waitVisibility(driver,"xpath",VUEPORTAL);
	   		clickButton(driver,"xpath",VUEPORTAL);
	   		
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("scroll(0, 300);");
	   		clickButton(driver,"xpath",VUEADDCONTACT);
	   		
	}
}
