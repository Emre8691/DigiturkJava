package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends ProductPageElementConstants {
 
	WebDriver driver;	
	
	 
 	
	 
	@FindBy(id=USERNAME)
	WebElement username;
	
	@FindBy(how=How.NAME,using=PASSWORD)
	WebElement password;
	
	@FindBy(how=How.ID,using=LOGINBUTTON)
	WebElement LoginButton;
	
	@FindBy(how=How.ID,using=FORGOTPASSWORD)
	WebElement ForgotPassword;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	
public void login(String uid,String pass) {
	
	username.sendKeys(uid);
	password.sendKeys(pass);
	LoginButton.click();
}	
	

 }
