package itelli.webtests.steps.customer.itelli.cosmos;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import itelli.webtests.common.MailHelper;
import itelli.webtests.pages.base.ContextBase;
import itelli.webtests.steps.AbstractSteps;

public class CosmosCommonSteps extends AbstractSteps<ContextBase> {
	private static final Logger LOG = Logger.getLogger(CosmosCommonSteps.class);
	
	/**
	 * 
	 * Check for Element.<br>
	 * 
	 * @param klas
	 *  
	 */
	@When("I set up the xpath element $xpath")
	public void checkElemntTyXpathChk(final String xpath) {

		List<WebElement> elements = null;

		if (elements == null) {
			elements = getContext().findElements(By.xpath(xpath));
		}
		
		if (elements != null) {
			for (final WebElement element : elements) {
				if (element.isDisplayed()&& element.isEnabled()) {
					element.click();
					getContext().waitUntilTimeout(MAX_TIMEOUT_2_SECONDS);
					getContext().findElement(By.id("btnNext")).click();
					getContext().waitUntilTimeout(MAX_TIMEOUT_5_SECONDS);
				}
			}
		}

	}
	
	
	@When("I fileupload the xpath element $xpath")
	public void fileUploadByXpath(final String xpath){
		List<WebElement> elements = null; 
		if (elements == null) {
			elements = getContext().findElements(By.xpath(xpath));		
				elements.get(0).sendKeys("C:\\tmp\\bg_th.jpg");
				elements.get(0).click();
			}
		}
	@When("I confirm ok")
	public void ConfirmOk()
		{
		List<WebElement> elements = null; 
		elements=getContext().findElements(By.id("btnOk"));
		elements.get(0).click();
		}
	
	@When("Highlightelement in $xpath")
    public void clickXpathHigh( final String xpath) {
        //cssSelector example = ".panel"
    	List<WebElement> elements = null;
		try {
			elements = getContext().findElements(By.xpath(xpath));
			WebElement el = elements.get(0);
			
			getContext().highlightElement(el);
			
			Thread.sleep(3*1000);
		}catch (Exception e) {
			LOG.error(e);
		}
    }
	@When("I approve the element $xpath")
	public void confirmRIS(final String xpath){
		List<WebElement> elements = null;
		elements=	getContext().findElements(By.xpath(xpath));
		boolean rootEl1 = 	getContext().findElements(By.xpath(xpath)).get(0).isEnabled();
			if (rootEl1){
				elements.get(0).click();
		//getContext().findElements(By.xpath(xpath)).get(0).click();
		getContext().waitUntilTimeout(MAX_TIMEOUT_10_SECONDS);
				
		int NumberOfProducts;
		NumberOfProducts = elements.get(0).findElements(By.xpath("//input[@onclick='changeApproveBox(this)']")).size();
		
		for (int j=0; j < NumberOfProducts; j++){
		
		getContext().findElements(By.xpath("//input[@type='checkbox']")).get(j).click();
		getContext().waitUntilTimeout(MAX_TIMEOUT_5_SECONDS);
		}
		getContext().findElement(By.xpath("//button[@id='btnApprove']")).click();
		getContext().waitUntilTimeout(MAX_TIMEOUT_5_SECONDS);
		
		getContext().findElement(By.xpath("//*[@id='navMenu']/li[1]/a")).click();
		getContext().waitUntilTimeout(MAX_TIMEOUT_5_SECONDS);
		
			}
		//elements = rootEl2.findElements( By.cssSelector("[class=\"" + "tooltip-4" + "\"]"));
		//for (int j=0; j < NumberOfProducts; j++){	
	}	

	@Then(value = "checking the component named by $component exists on page")
	public void checkComponentNamedByExistsOnPage(final String component) {
		String mailBody = getContext().getContextInformation().getPropertyFromMetaMap("mailBody");
		String mailAttachment = getContext().getContextInformation().getPropertyFromMetaMap("mailAttachment");
		String mailAttachmentFile = getContext().getContextInformation().getPropertyFromMetaMap("mailAttachmentFile");
		
		final boolean existsOnPage = getContext().getContextBasedValidations().isElementByAttributeIdAvailable(component);
		Assert.assertTrue("The component named by " + component + " does not exist on page", existsOnPage);
		if (existsOnPage==true)
		{
			try {
					MailHelper.SendMail("burak.turkpencesi-ext@bshg.com", "Error", mailBody, mailAttachmentFile, mailAttachment!=null?mailAttachment.getBytes("UTF-8"):null);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
		}
	}
	
	@When("I press $key key after $seconds seconds")
	public void pressAfterSeconds(final String key, final String seconds){
		
		((JavascriptExecutor)getContext()).executeScript("alert('deneme');"); 
		
		int keycode = 0;
		for (int i = 0; i < 0xFFFF; i++) {
			if (KeyEvent.getKeyText(i).equalsIgnoreCase(key)) {
				keycode = i;
				break;
			}
			
		}
		
		if (keycode > 0) {
			prepareToPressEnterKey(Integer.valueOf(seconds), keycode);
		}

	}
	
	public final void prepareToPressEnterKey(int seconds, int keycode) {
	    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
	    ScheduledFuture scheduledFuture = scheduledExecutorService.schedule(new Runnable() {

	        public void run() {

	        	/*
	            try { 
	                Robot robot = new Robot();

	                robot.keyPress(KeyEvent.VK_ENTER);
	                TimeUnit.SECONDS.sleep(1); 
	                robot.keyRelease(KeyEvent.VK_ENTER);
	            } catch (AWTException | InterruptedException e) {
	                System.out.println("Prepare to Press Enter Exception");
	            }
	            */
            	getContext().getContextBasedActions().setEnter();

	        }
	    },
	            seconds,
	            TimeUnit.SECONDS);
	    scheduledExecutorService.shutdown();
	}
 }

	

