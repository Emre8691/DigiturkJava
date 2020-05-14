package test.tools.webapp.automation.Smoke;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.TestBase;
import pages.LoginPage;
import pages.XlsReader;

public class ImportExcel extends TestBase{
	
	@BeforeClass
	public void Browserchoose() throws Exception {
		//This will launch browser and specific url	
		initialization();
		//Created Page Object using Page Factory
		LoginPage login_page=PageFactory.initElements(driver, LoginPage.class);
   		login_page.login(prop.getProperty("Username"),prop.getProperty("Password"));
   		Thread.sleep(2000);   	
	}
	
	@Test(priority = 0, description = "Read values from excel ")
	public static void ReadExcel(Method method) throws InterruptedException, IOException {
		XlsReader src = new XlsReader(System.getProperty("user.dir") + "/src/main/resources/tools/excel/Box.xlsx");
    	
                
        int rowNum = src.getRowCount("emptybox"); //336
        System.out.println(rowNum);
        
        for (int i = 1; i < rowNum; i++) {
        	 int data = src.getCellRowNum("emptybox", "Availability", "Usable");
        	 System.out.println(data);
        	 
        	 String name = src.getCellData("emptybox", "Package name", data);
 			 String width = src.getCellData("emptybox", "Width", data);
 			 String heigth = src.getCellData("emptybox", "Height", data);
 			 String length = src.getCellData("emptybox", "Length", data);
 			 String description = src.getCellData("emptybox", "Package name", data);
 			 String packagecode = src.getCellData("emptybox", "Package Code", data);
 			 String Returnable = src.getCellData("emptybox", "Returnableb", data );
 			 System.out.println(packagecode);
 			 src.setCellData("emptybox", "Availability", data,"used");
        	
 			if (!driver.findElement(By.id(MILKRUN)).isDisplayed())	
    		{
    		
				waitVisibility(driver,"id",DEFINITIONS);
		   		clickButton(driver,"id",DEFINITIONS);
		   		waitVisibility(driver,"id",MILKRUN);
		   		clickButton(driver,"id",MILKRUN);
		   		waitVisibility(driver,"id",PACKAGE);
		   		clickButton(driver,"id",PACKAGE);
    		}
		   		waitVisibility(driver,"xpath",PackageCodeSearch);
		   		clickButton(driver,"xpath",PackageCodeSearch);
		   		clear(driver,"xpath",PackageCodeSearch);
		   		Sendkeys(driver,"xpath",PackageCodeSearch,packagecode);
		   		WebElement Ele = driver.findElement(By.xpath(foundElement));
		   		boolean ElementStatus = Ele.isDisplayed();
		   		
		   			if (ElementStatus == true)
		   				{
		   					waitVisibility(driver,"id",DIMENSION);
		   					clickButton(driver,"id",DIMENSION);
		   					waitVisibility(driver,"xpath",ADD_DIMENSION);
		   					clickButton(driver,"xpath",ADD_DIMENSION);	
		   					waitVisibility(driver,"xpath",DimensionType);
		   					clickButton(driver,"xpath",DimensionType);
		   					clickButton(driver,"xpath",DimensionTypeValue);		   				
		   					waitVisibility(driver,"xpath",DimensionName);
		   					SendkeysDynamicElement(driver,"id",DynamicDimensionName,name);
		   					SendkeysDynamicElement(driver,"id",DimensionWidth,width);
		   					SendkeysDynamicElement(driver,"id",DimensionHeight,heigth);
		   					SendkeysDynamicElement(driver,"id",DimensionLength,length);
		   					SendkeysDynamicElement(driver,"id",DimensionDescription,description);
		   					clickButton(driver,"xpath",save);
		   					clickButton(driver,"id",PACKAGE);
		   					waitVisibility(driver,"xpath",PackageCodeSearch);
		   					clickButton(driver,"xpath",PackageCodeSearch);
		   					clickButton(driver,"xpath",PackageEdit);
		   					clickButton(driver,"xpath",PackageDimension);
		   					waitVisibility(driver,"xpath",PackageDimensionValue);
		   					Sendkeys(driver,"xpath",PackageDimensionValue,Keys.chord(Keys.CONTROL,"a"));
		   					Sendkeys(driver,"xpath",PackageDimensionValue,name);
		   					clickButton(driver,"xpath",ChooseElement);
		   					WebElement checkElement=driver.findElement(By.xpath(is_returnable));
		   					if (Returnable.equals("Y") || Returnable.equals("y"))
		   					{
		   						if (checkElement.getAttribute("value").contains("false"))
		   							{clickButton(driver,"xpath",returnable);}
		   								   						
		   					}
		   					
		   					WebElement dynamicElement = driver.findElement(By.xpath(dynamic));
		   					if (dynamicElement.getAttribute("aria-checked").contains("false"))
		   					{
		   						clickButton(driver,"xpath",dynamicEle);
		   					}
		   					
		   				
		   					clickButton(driver,"xpath",save);
		   				}  	
        		}
         	}	
}
