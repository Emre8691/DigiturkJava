package test.tools.webapp.automation.Smoke;

import java.lang.reflect.Method;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.TestBase;
import pages.VueLoginPage;
import utils.ExtentReports.ExtentTestManager;

public class RoleTest extends TestBase {
	public class ContactTest extends TestBase {
		@BeforeClass
		public void Browserchoose() throws Exception {
			//This will launch browser and specific url	
			initialization();
			//Created Page Object using Page Factory
			
			Thread.sleep(3000);
		}
		
		@Test(priority = 0, description = "Role Scenario.")
		public void RoleTestAdd(Method method) throws InterruptedException {
		    ExtentTestManager.startTest(method.getName(), "Role Scenario add/edit/delete role.");
		    
		   		VueLoginPage login_page=PageFactory.initElements(driver, VueLoginPage.class);
		   		login_page.login(prop.getProperty("Username2"),prop.getProperty("Password"));
		   		Thread.sleep(2000);
		   		
		   		waitVisibility(driver,"xpath",VUEDEFINITIONS);
		   		clickButton(driver,"xpath",VUEDEFINITIONS);
		   		
		   		clickButton(driver,"xpath",VUEPORTAL);
		   		
		   		clickButton(driver,"xpath",VUEROLE);
		   		
		   		clickButton(driver,"xpath",VUEADDROLE);
		   		
		   		SendkeysDynamicElement(driver,"id",VUENAMEROLE,"Admin Role");
		   		SendkeysDynamicElement(driver,"id",VUEDESCRIPTIONROLE,"Role");
		   		
		   		//clickButton(driver,"xpath",VUECANCELROLE);
		   		clickButton(driver,"xpath",VUESAVEROLE);  

		}
		
		@Test(priority = 1, description = "Role Scenario.")
		public void RoleTestEdit(Method method) throws InterruptedException {
		    ExtentTestManager.startTest(method.getName(), "Role Scenario add/edit/delete role.");
		    
		    waitVisibility(driver,"xpath",VUEEDITROLE);
	   		clickButton(driver,"xpath",VUEEDITROLE);
	   		
	   		clear(driver,"xpath",getValue("id",VUENAMEROLE));
	   		SendkeysDynamicElement(driver,"id",VUENAMEROLE,"Super Admin");
	   		
	   		clear(driver,"xpath",getValue("id",VUEDESCRIPTIONROLE));
	   		SendkeysDynamicElement(driver,"id",VUEDESCRIPTIONROLE,"Super Admin Role");
	   		
	   		clickButton(driver,"xpath",VUESAVEROLE);
	   		
	   		clickButton(driver,"xpath",VUEDELETEROLE);
	   		clickButton(driver,"xpath",VUEDELETENOROLE);
	   		
	   		clickButton(driver,"xpath",VUEDELETEROLE);
	   		clickButton(driver,"xpath",VUEDELETEYESROLE);
		    
		}
		
		@Test(priority = 2, description = "Role Search Scenario.")
		public void RoleTestSearch(Method method) throws InterruptedException {
		    ExtentTestManager.startTest(method.getName(), "Role Search Scenario.");
		    
		    Sendkeys(driver,"xpath",VUETBXSEARCHNAMEROLE,"Emre");
		    clear(driver,"xpath",VUETBXSEARCHNAMEROLE);
		    
		    Sendkeys(driver,"xpath",VUETBXDESCRIPTIONSEARCHROLE,"Emre");
		    clear(driver,"xpath",VUETBXDESCRIPTIONSEARCHROLE);
		}
	}
}
