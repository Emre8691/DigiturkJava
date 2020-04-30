package pages;

import org.openqa.selenium.WebDriver;

import Base.TestBase;

public class Logout extends TestBase { 
	
    public static void LogoutPage() throws InterruptedException{
    	
		
    	clickButton(driver,"xpath",AVATARHEADER);

    	clickButton(driver,"xpath",LOGOUT);
    
    	
    }

	
	
	

}
