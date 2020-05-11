
package test.tools.webapp.automation.Smoke;

import java.lang.reflect.Method;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.TestBase;
import pages.VueLoginPage;
import utils.ExtentReports.ExtentTestManager;

public class RegionTest extends TestBase{
	
	@BeforeClass
	public void Browserchoose() throws Exception {
		//This will launch browser and specific url	
		initialization();
		//Created Page Object using Page Factory
		
		Thread.sleep(3000);
	}
	
	@Test(priority = 0, description = "Region Scenario.")
	public void RegionTestPositiv(Method method) throws InterruptedException {
	    ExtentTestManager.startTest(method.getName(), "Region Scenario add/edit/delete region.");
	    
	   		VueLoginPage login_page=PageFactory.initElements(driver, VueLoginPage.class);
	   		login_page.login(prop.getProperty("Username2"),prop.getProperty("Password"));
	   		Thread.sleep(2000);
	   		 		
	   		waitVisibility(driver,"xpath",VUEDEFINITIONS);
	   		clickButton(driver,"xpath",VUEDEFINITIONS);
	   		
	   		waitVisibility(driver,"xpath",VUEPORTAL);
	   		clickButton(driver,"xpath",VUEPORTAL);
	   		
	   		waitVisibility(driver,"xpath",VUEREGION);
	   		clickButton(driver,"xpath",VUEREGION);
	   		
	   		clickButton(driver,"xpath",VUEADDREGION);
	   		
	   		Sendkeys(driver,"xpath",VUENAMEREGION,"Tesstt Anadolu");
	   		
	   		Sendkeys(driver,"xpath",VUEDESCRIPTIONREGION,"Tesstt Anadolu Bölgesi");

	   		clickButton(driver,"xpath",VUESAVEREGION);
	   		
	   		clickButton(driver,"xpath",VUEEDITREGION);
	   		
	   		clear(driver,"xpath",VUENAMEREGION);
	   		
	   		clear(driver,"xpath",VUEDESCRIPTIONREGION);
	   		
	   		Sendkeys(driver,"xpath",VUENAMEREGION,"Tesst Akdeniz");

	   		Sendkeys(driver,"xpath",VUEDESCRIPTIONREGION,"Tesst Akdeniz Bölgesi");
	   		
	   		clickButton(driver,"xpath",VUESAVEREGION);
	   		
	   		clickButton(driver,"xpath",VUEDELETEREGION);
	   		
	   		waitVisibility(driver,"xpath",VUEDELETEYESREGION);
	   		clickButton(driver,"xpath",VUEDELETEYESREGION); 
	   		//clickButton(driver,"xpath",VUEDELETENOREGION); 
	  
	}
	
	@Test(priority = 1, description = "Region Scenario.")
	public void RegionTestNegativ(Method method) throws InterruptedException {
	    ExtentTestManager.startTest(method.getName(), "Region Scenario add/edit/delete region.");

	   		clickButton(driver,"xpath",VUEADDREGION);
	   		
	   		Sendkeys(driver,"xpath",VUENAMEREGION,"190");
	   		
	   		Sendkeys(driver,"xpath",VUEDESCRIPTIONREGION,"Bölgesii");
	   		
	   		clickButton(driver,"xpath",VUESAVEREGION);
	}
	
	@Test(priority = 2, description = "Region Scenario.")
	public void RegionTestNegativEmpty(Method method) throws InterruptedException {
	    ExtentTestManager.startTest(method.getName(), "Region Scenario add/edit/delete region.");

	   		clickButton(driver,"xpath",VUEADDREGION);
	   		
	   		clickButton(driver,"xpath",VUESAVEREGION);
	   		
	   		clickButton(driver,"xpath",VUECANCELREGION);
	}
	
}