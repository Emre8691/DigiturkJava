package steps.itelli.webtestsItelli.src.main.java.itelli.webtests.common;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DslHelper {
	public static void sendKeysWithEvent(WebDriver driver, WebElement element, String text, String event) throws Exception {
	    element.sendKeys(text);
	    switch(event) {
	    case "keyup":
	        new Actions(driver).keyDown(element, Keys.CONTROL).keyUp(element, Keys.CONTROL).perform();
	        break;
	    case "onblurJS":
	        doJavascriptOnElement(driver, element, element.getAttribute("onblur"));
	        break;
	    case "onchange":
	        doJavascriptOnElement(driver, element, element.getAttribute("onchange"));
	        break;
	    case "onfocus":
	        element.click();
	        break;
	    case "keyupJS": 
	        doJavascriptOnElement(driver, element, element.getAttribute("onkeyup"));
	        break;
	    case "keyupTAB":
	        element.sendKeys(Keys.TAB);
	        break;
	    }

	}
	public static void doJavascriptOnElement(WebDriver driver, WebElement element, String javascript) throws Exception {
	    ((JavascriptExecutor) driver).executeScript(javascript, element);

	}
	public static String extractIssueKey(String storyName) {
		return "TTP-" + StringUtils.substringBetween(storyName, "/TTP-", "_");
	}
}
