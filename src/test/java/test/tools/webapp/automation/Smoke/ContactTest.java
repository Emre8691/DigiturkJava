package test.tools.webapp.automation.Smoke;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
	public void ContactTestAdd(Method method) throws InterruptedException {
	    ExtentTestManager.startTest(method.getName(), "Contact Scenario add/edit/delete region.");
	    
	   		VueLoginPage login_page=PageFactory.initElements(driver, VueLoginPage.class);
	   		login_page.login(prop.getProperty("Username2"),prop.getProperty("Password"));
	   		Thread.sleep(2000);
	   		
	   		waitVisibility(driver,"xpath",VUEDEFINITIONS);
	   		clickButton(driver,"xpath",VUEDEFINITIONS);
	   		
	   		clickButton(driver,"xpath",VUEPORTAL);
	   		
	   		scroll(driver,"xpath",VUECONTACT);
	   		clickButton(driver,"xpath",VUECONTACT);
	   		
	   		clickButton(driver,"xpath",VUEADDCONTACT);
	   		
	   		SendkeysDynamicElement(driver,"id",VUEFIRSTNAMECONTACT,"Emre");
	   		SendkeysDynamicElement(driver,"id",VUELASTNAMECONTACT,"Diker");
	   		SendkeysDynamicElement(driver,"id",VUEUSERNAMECONTACT,"TADIKER");
	   		
	   		clickButton(driver,"xpath",VUESTATUSBUTTONCONTACT);
	   		//clickButton(driver,"xpath",VUESTATUSPASSIVECONTACT);
	   		clickButton(driver,"xpath",VUESTATUSACTIVECONTACT);
	
	   		clickButton(driver,"xpath",VUETITLEBUTTONCONTACT);
	   		clickButton(driver,"xpath",VUETITLESUPERADMINCONTACT);
	   		//clickButton(driver,"xpath",VUETITLEADMINCONTACT);
	   		//clickButton(driver,"xpath",VUETITLETECEDEKORCONTACT);
	   		//clickButton(driver,"xpath",VUETITLEWEBINARSUPERADMINCONTACT);
	   		
	   		clickButton(driver,"xpath",VUETYPETITLEBUTTONCONTACT);
	   		clickButton(driver,"xpath",VUETYPEFULLTIMECONTACT);
	   		//clickButton(driver,"xpath",VUETYPEPARTTIMECONTACT);
	   		
	   		clickButton(driver,"xpath",VUECOMPANYBUTTONCONTACT);
	   		clickButton(driver,"xpath",VUECOMPANYITELLICONTACT);
	   		
	   		SendkeysDynamicElement(driver,"id",VUEEMAILCONTACT,"5555554545");
	   		
	   		SendkeysDynamicElement(driver,"id",VUEEXTENSIONCONTACT,"9328");
	   		
	   		SendkeysDynamicElement(driver,"id",VUELICENSENUMBERCONTACT,"12345");
	   		
	   		SendkeysDynamicElement(driver,"id",VUEEXTERNALUSERCONTACT,"DIKER");
	   		
	   		SendkeysDynamicElement(driver,"id",VUEEXTERNALUSER2CONTACT,"EMDIKER");
	   		
	   		SendkeysDynamicElement(driver,"id",VUEDESCRIPTIONCONTACT,"Description");
	   		
	   		//clickButton(driver,"xpath",VUEREGISTERCHECKBOXCONTACT); 
	   	
	   		clickButton(driver,"xpath",VUESAVECONTACT);
	   		

	   		//clickButton(driver,"xpath",VUECANCELCONTACT);
	}
	

	@Test(priority = 1, description = "Contact Scenario.")
	public void ContactTestEdit(Method method) throws InterruptedException {
	    ExtentTestManager.startTest(method.getName(), "Contact Scenario edit/delete region.");
	    
   		clickButton(driver,"xpath",VUEEDITCONTACT);
   		
   		clear(driver,"xpath",getValue("id",VUEFIRSTNAMECONTACT));
   		SendkeysDynamicElement(driver,"id",VUEFIRSTNAMECONTACT,"Taha");
   		
   		clear(driver,"xpath",getValue("id",VUELASTNAMECONTACT));
   		SendkeysDynamicElement(driver,"id",VUELASTNAMECONTACT,"Öztürk");
   	
   		clear(driver,"xpath",getValue("id",VUEUSERNAMECONTACT));
   		SendkeysDynamicElement(driver,"id",VUEUSERNAMECONTACT,"NICKNAME"); 
   		
   		clickButton(driver,"xpath",VUESTATUSBUTTONCONTACT);
   		clickButton(driver,"xpath",VUESTATUSPASSIVECONTACT);
   		
   		clickButton(driver,"xpath",VUETITLEBUTTONCONTACT);
   		clickButton(driver,"xpath",VUETITLETECEDEKORCONTACT);
   		
   		clickButton(driver,"xpath",VUETYPETITLEBUTTONCONTACT);
   		clickButton(driver,"xpath",VUETYPEPARTTIMECONTACT);
   		
   		clickButton(driver,"xpath",VUECOMPANYBUTTONCONTACT);
   		clickButton(driver,"xpath",VUECOMPANYITELLICONTACT);
   		
   		clear(driver,"xpath",getValue("id",VUEEMAILCONTACT));
   		SendkeysDynamicElement(driver,"id",VUEEMAILCONTACT,"tahadiker@test.com"); 
   		
   		clear(driver,"xpath",getValue("id",VUEEXTENSIONCONTACT));
   		SendkeysDynamicElement(driver,"id",VUEEXTENSIONCONTACT,"1919"); 
   		
   		clear(driver,"xpath",getValue("id",VUELICENSENUMBERCONTACT));
   		SendkeysDynamicElement(driver,"id",VUELICENSENUMBERCONTACT,"3455"); 
   		
   		clear(driver,"xpath",getValue("id",VUEEXTERNALUSERCONTACT));
   		SendkeysDynamicElement(driver,"id",VUEEXTERNALUSERCONTACT,"DAYKIR"); 
   		
   		clear(driver,"xpath",getValue("id",VUEEXTERNALUSER2CONTACT));
   		SendkeysDynamicElement(driver,"id",VUEEXTERNALUSER2CONTACT,"MRDAYKIR"); 
   		
   		clear(driver,"xpath",getValue("id",VUEDESCRIPTIONCONTACT));
   		SendkeysDynamicElement(driver,"id",VUEDESCRIPTIONCONTACT,"Tanim"); 
   		
   		clickButton(driver,"xpath",VUESAVECONTACT);
   		
   		clickButton(driver,"xpath",VUEDELETECONTACT);
   		clickButton(driver,"xpath",VUEDELETENOCONTACT);
   		
   		clickButton(driver,"xpath",VUEDELETECONTACT);
   		clickButton(driver,"xpath",VUEDELETEYESCONTACT);
   		
	}
}
