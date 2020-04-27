package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

/**
 * Created by burak.turkpencesi on 18.09.2017.
 */
public class CommonFunctions extends PageConsructor {


    public static String navigate_to(WebDriver driver,String url) throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:/Users/burak.turkpencesi/Desktop/PythonOtomasyon/Data/chromedriver.exe");
        driver = new ChromeDriver();


        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
        //System.setProperty("webdriver.chrome.driver", "C:/Users/burak.turkpencesi/Desktop/PythonOtomasyon/Data/chromedriver.exe");
        driver.get(url);
        //Maximize the Browser window
        driver.manage().window().maximize();
        Thread.sleep(5000);
        return null;
            }
    public static String Sendkeys(WebDriver driver, String strLocType, String strLocValue,String param1) throws InterruptedException
    {
        switch(strLocType)
        {
            case "id":
                driver.findElement(By.id(strLocValue)).sendKeys(param1);
                break;
            case "xpath":
                driver.findElement(By.xpath(strLocValue)).sendKeys(param1);
                break;
            case "name":
                driver.findElement(By.name(strLocValue)).sendKeys(param1);
                break;
        }
        Thread.sleep(5000);
        return null;
    }
    public static void click_element(By elementLocation) throws InterruptedException {
        Thread.sleep(2000);
    	driver.findElement(elementLocation).click();
    }

    public static void quit_driver(WebDriver driver)
    {
        driver.quit();
    }
}
