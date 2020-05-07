package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class VueLoginPage extends ProductPageElementConstants {
	
	WebDriver driver;		
	 
	@FindBy(id=VUEUSERNAME)
	WebElement username;
	
	@FindBy(how=How.NAME,using=VUEPASSWORD)
	WebElement password;
	
	@FindBy(how=How.ID,using=VUELOGINBUTTON)
	WebElement LoginButton;
	
	@FindBy(how=How.ID,using=VUEFORGOTPASSWORD)
	WebElement ForgotPassword;
	
	public VueLoginPage()
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
