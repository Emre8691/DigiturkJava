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
	public void LoginTest(Method method) throws InterruptedException {
	    ExtentTestManager.startTest(method.getName(), "Region Scenario add/edit/delete region.");
	    
	   		VueLoginPage login_page=PageFactory.initElements(driver, VueLoginPage.class);
	   		login_page.login(prop.getProperty("Username2"),prop.getProperty("Password"));
	   		Thread.sleep(2000);
	   		
	   		/*
	   		waitVisibility(driver,"xpath",VUEDEFINITIONS);
	   		clickButton(driver,"xpath",VUEDEFINITIONS);
	   		
	   		waitVisibility(driver,"xpath",VUEPORTAL);
	   		clickButton(driver,"xpath",VUEPORTAL);
	   		
	   		waitVisibility(driver,"xpath",VUEREGION);
	   		clickButton(driver,"xpath",VUEREGION);
	   		
	   		//waitVisibility(driver,"xpath",VUEADDREGION);
	   		clickButton(driver,"xpath",VUEADDREGION);
	   		
	   		//waitVisibility(driver,"xpath",VUEREGIONNAME);
	   		Sendkeys(driver,"xpath",VUEREGIONNAME,"Test Anadolu");
	   		
	   		Sendkeys(driver,"xpath",VUEREGIONDESCRIPTION,"Test Anadolu Bölgesi");
	   		
	   		//waitVisibility(driver,"xpath",VUESAVEREGION);
	   		clickButton(driver,"xpath",VUESAVEREGION);
	   		
	   		//waitVisibility(driver,"xpath",VUEEDITREGION);
	   		clickButton(driver,"xpath",VUEEDITREGION);
	   		
	   		//waitVisibility(driver,"xpath",VUEREGIONNAME);
	   		clear(driver,"xpath",VUEREGIONNAME);
	   		
	   		//waitVisibility(driver,"xpath",VUEREGIONDESCRIPTION);
	   		clear(driver,"xpath",VUEREGIONDESCRIPTION);
	   		
	   		//waitVisibility(driver,"xpath",VUEREGIONNAME);
	   		Sendkeys(driver,"xpath",VUEREGIONNAME,"Test Akdeniz");
	   		
	   		//waitVisibility(driver,"xpath",VUEREGIONDESCRIPTION);
	   		Sendkeys(driver,"xpath",VUEREGIONDESCRIPTION,"Test Akdeniz Bölgesi");
	   		
	   		//waitVisibility(driver,"xpath",VUESAVEREGION);
	   		clickButton(driver,"xpath",VUESAVEREGION);
	   		
	   		//waitVisibility(driver,"xpath",VUEDELETEREGION);
	   		clickButton(driver,"xpath",VUEDELETEREGION);
	   		
	   		waitVisibility(driver,"xpath",VUEREGIONDELETEYES);
	   		clickButton(driver,"xpath",VUEREGIONDELETEYES); 
	   		
	   		*/
	   		
	   		//******** Negative Test Case ***********
	   		
	   		/*
	   		waitVisibility(driver,"xpath",VUEDEFINITIONS);
	   		clickButton(driver,"xpath",VUEDEFINITIONS);
	   		
	   		waitVisibility(driver,"xpath",VUEPORTAL);
	   		clickButton(driver,"xpath",VUEPORTAL);
	   		
	   		waitVisibility(driver,"xpath",VUEREGION);
	   		clickButton(driver,"xpath",VUEREGION);
	   		
	   		//waitVisibility(driver,"xpath",VUEADDREGION);
	   		clickButton(driver,"xpath",VUEADDREGION);
	   		
	   		//waitVisibility(driver,"xpath",VUEREGIONNAME);
	   		Sendkeys(driver,"xpath",VUEREGIONNAME,"1905");
	   		
	   		Sendkeys(driver,"xpath",VUEREGIONDESCRIPTION,"Bölgesi");
	   		
	   		//waitVisibility(driver,"xpath",VUESAVEREGION);
	   		clickButton(driver,"xpath",VUESAVEREGION);
	   		*/
	   		
	   	//******** 2. Negative Test Case ***********
	   		waitVisibility(driver,"xpath",VUEDEFINITIONS);
	   		clickButton(driver,"xpath",VUEDEFINITIONS);
	   		
	   		waitVisibility(driver,"xpath",VUEPORTAL);
	   		clickButton(driver,"xpath",VUEPORTAL);
	   		
	   		waitVisibility(driver,"xpath",VUEREGION);
	   		clickButton(driver,"xpath",VUEREGION);
	   		
	   		//waitVisibility(driver,"xpath",VUEADDREGION);
	   		clickButton(driver,"xpath",VUEADDREGION);
	   		
	   		//waitVisibility(driver,"xpath",VUESAVEREGION);
	   		clickButton(driver,"xpath",VUESAVEREGION);
	   		
	   		clickButton(driver,"xpath",VUECANCELREGION);
	   		
	  
	}
}
