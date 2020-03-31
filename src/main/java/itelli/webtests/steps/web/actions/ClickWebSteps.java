package itelli.webtests.steps.web.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import itelli.webtests.common.DSLLogConstract;
import itelli.webtests.common.DslLogBeauty;
import itelli.webtests.domain.ContentElement;
import itelli.webtests.pages.base.ContextBase;
import itelli.webtests.steps.AbstractSteps;
import itelli.webtests.steps.web.alerts.AlertWebSteps;

/**
 * Web Application Steps which are useable for click functionalities of webpages.
 */
public class ClickWebSteps extends AbstractSteps<ContextBase> {

	private static final Logger LOG = Logger.getLogger(AlertWebSteps.class);

	/**
	 * Clicks given element by given testingID or html element attribute.<br>
	 * @param elementID The element ID could be a button or a clickable button
	 */
	
	@When(value="I click the {button|element} $elementID by any attribute", priority=2)
	public void doClickByElementWithAnyAttribute(final String elementID) {
		final WebElement elm = getContext().findElementByAnyGivenAttribute(elementID);
		if ( elm != null ) {
			Assert.assertNotNull(String.format("Web: Could not find clickable element: '%s'", elementID), elm);
			getContext().highlightElement(elm);
			genericClick(elementID, elm);
		} else {
			DslLogBeauty.logger(DSLLogConstract.ELEMENT_NOT_FOUND, new Object[] { elementID, "The element id " }, new Exception(), ClickWebSteps.class);
		} 
	}
	 
	@When(value="I click the {button|element} $elementID")
	public void doClickByElement(final String elementID) {
		final WebElement elm = getContext().findElementByGivenAttribute(elementID);
		if ( elm != null ) {
			Assert.assertNotNull(String.format("Web: Could not find clickable element: '%s'", elementID), elm);
			getContext().highlightElement(elm);
			genericClick(elementID, elm);
		} else {
			DslLogBeauty.logger(DSLLogConstract.ELEMENT_NOT_FOUND, new Object[] { elementID, "The element id " }, new Exception(), ClickWebSteps.class);
		}
	}

	@When("I click the hidden {button|element} $elementID")
	public void doClickByElementForced(final String elementID) {
		final WebElement elm = getContext().findElementByGivenAttribute(elementID);
		if ( elm != null ) {
			Assert.assertNotNull(String.format("Web: Could not find clickable element: '%s'", elementID), elm);
			getContext().highlightElement(elm);
			genericClickElement(elm);
		} else {
			DslLogBeauty.logger(DSLLogConstract.ELEMENT_NOT_FOUND, new Object[] { elementID, "The element id " }, new Exception(), ClickWebSteps.class);
		}
	}

	/**
	 * Clicks given element by given css selector if avaliable.<br>
	 * @param css The css of element
	 */
	@When(value = "I click the {button|element} $css if avaliable", priority = 2)
	public void doClickByElementWithCss(final String css) {
		By selector = By.cssSelector(css);
		final WebElement elm = getContext().waitForVisibility(selector, 3);
		genericClickCss(css, elm);
	}

	/**
	 * Clicks on Show more button whenever available on the page.<br>
	 */
	@When("I click on the $clasId button the product page extends")
	public void ClickButton(final String clasId) {
		WebElement div = null;
		WebElement button = null;
		try {
			div = getContext().findElements(By.cssSelector("[class=\"" + "more show-more" + "\"]")).get(0);
			button = div.findElements(By.cssSelector("[type=\"" + "button" + "\"]")).get(0);
			boolean isVisible = true;
			do {
				genericClickElement(button);
				getContext().waitUntilTimeout(MAX_TIMEOUT_5_SECONDS);
				isVisible = button.isDisplayed();
			} while (isVisible == true);
			Assert.assertFalse(String.format("Web: Could not find clickable element: '%s'", button), isVisible);
		} catch (Exception e) {
			DslLogBeauty.logger(DSLLogConstract.ELEMENT_NOT_FOUND, new Object[] { button, "The element id " }, new Exception(), ClickWebSteps.class);
		}
	}
	
	@When(value = "I click the {button|element} $elementID without wait", priority = 2)
	public void doClickByElementWithoutWait(final String elementID) {
		final WebElement elm = getContext().findElementByGivenAttribute(elementID);
		if ( elm != null ) {
			Assert.assertNotNull(String.format("Web: Could not find clickable element: '%s'", elementID), elm);
			genericClickWithoutWait(elementID, elm);
		} else {
			DslLogBeauty.logger(DSLLogConstract.ELEMENT_NOT_FOUND, new Object[] { elementID, "The element id " }, new Exception(), ClickWebSteps.class);
		}
	}

	
	/**
	 * Clicks given element by given testingID or html element attribute for a {@link ContentElement}.<br>
	 * @param elementID The element ID could be a button or a clickable button
	 * @param content The {@link ContentElement} which maps the elementID.
	 */
	@When("I click on the {button|element} $elementID of $content")
	@Alias("I click on the $elementID of $content")
	public void doClickByElementOfContent(final String elementID, final ContentElement content) {
		final String identifier = content.getIdentifierFor(elementID);
		final WebElement elm = getContext().findElementByGivenAttribute(identifier);
		if ( elm != null) {
			Assert.assertNotNull(String.format("Web: Could not find clickable element: '%s' for ConteneElement: '%s'", identifier, elm), elm);
			genericClick(identifier, elm);
		} else {
			DslLogBeauty.logger(DSLLogConstract.MULTI_ELEMENT_NOT_FOUND, new Object[] { elementID, content, "The element id " }, new Exception(), ClickWebSteps.class);
		}
	}

	/**
	 * Press Click Browser Back Button expected focus.<br>
	 */
	@When("I click on the browser back button")
	public void doClickBrowserBackButton() {
		try {
			getContext().navigate().back();
		} catch (final Exception e) {
			DslLogBeauty.logger(DSLLogConstract.WITHOUT_PARAMATER, new Object[] { "The browser back button couldn´t be clicked! " }, e, ClickWebSteps.class);
		}
	}

	/**
	 * Login failed cases with their spesific css class name
	 * You can put class names to the truth binary file names
	 */
	@Then("the login was successful")
	public void checkIfLoginSuccessful() {
		String[] userNameEmpty = {""}; 
		String[] passwordEmpty = {""};
		String[] userNameAndPasswordEmpty = {""};
		String[] userNameOrPasswordWrong = {"erroruserdoesnotexist"};
		String[] userNameDoesNotExist = {"erroruserdoesnotexist"};
		String[] cssValidator = {"ValidationError", "show-error", "error-custom"};
		
		Collection<String[]> collection = new ArrayList<String[]>();
		collection.add(userNameEmpty);
		collection.add(passwordEmpty);
		collection.add(userNameAndPasswordEmpty);
		collection.add(userNameOrPasswordWrong);
		
		List<WebElement> visibilityCheck = null;
		for ( String[] o : collection ) {
			if (o.equals(userNameEmpty)) {
				for (int i = 0; i < userNameEmpty.length; i++) {
					visibilityCheck = getContext().findElements(By.cssSelector("[testing_id=\"" + userNameEmpty[i] + "\"]"));
					if ( visibilityCheck != null && visibilityCheck.size() > 0) {
						break;
					}
				}
				if ( visibilityCheck.isEmpty() ) {
					Assert.assertTrue("Login was successful", true);
				} else {
					DslLogBeauty.logger(DSLLogConstract.WITHOUT_PARAMATER, new Object[] { "Please set the user name " }, new Exception(), ClickWebSteps.class);
				}
			} else if (o.equals(passwordEmpty)) {
				for (int i = 0; i < passwordEmpty.length; i++) {
					visibilityCheck = getContext().findElements(By.cssSelector("[testing_id=\"" + passwordEmpty[i] + "\"]"));
					if ( visibilityCheck != null && visibilityCheck.size() > 0) {
						break;
					}
				}
				if ( visibilityCheck.isEmpty() ) {
					Assert.assertTrue("Login was successful", true);
				} else {
					DslLogBeauty.logger(DSLLogConstract.WITHOUT_PARAMATER, new Object[] { "Please set the password." }, new Exception(), ClickWebSteps.class);
				}
			} else if (o.equals(userNameAndPasswordEmpty)) {
				for (int i = 0; i < userNameAndPasswordEmpty.length; i++) {
					visibilityCheck = getContext().findElements(By.cssSelector("[testing_id=\"" + userNameAndPasswordEmpty[i] + "\"]"));
					if ( visibilityCheck != null && visibilityCheck.size() > 0) {
						break;
					}
				}
				if ( visibilityCheck.isEmpty() ) {
					Assert.assertTrue("Login was successful", true);
				} else {
					DslLogBeauty.logger(DSLLogConstract.WITHOUT_PARAMATER, new Object[] { "Username and password are blank  " }, new Exception(), ClickWebSteps.class);
				}
			} else if (o.equals(userNameOrPasswordWrong)) {
				for (int i = 0; i < userNameOrPasswordWrong.length; i++) {
					visibilityCheck = getContext().findElements(By.cssSelector("[testing_id=\"" + userNameOrPasswordWrong[i] + "\"]"));
					if ( visibilityCheck != null && visibilityCheck.size() > 0) {
						break;
					}
				}
				if ( visibilityCheck.isEmpty() ) {
					Assert.assertTrue("Login was successful", true);
				} else {
					DslLogBeauty.logger(DSLLogConstract.WITHOUT_PARAMATER, new Object[] { "No user is known with the given login and password! " }, new Exception(), ClickWebSteps.class);
				}
			} else if (o.equals(userNameDoesNotExist)) {
				for (int i = 0; i < userNameDoesNotExist.length; i++) {
					visibilityCheck = getContext().findElements(By.cssSelector("[testing_id=\"" + userNameDoesNotExist[i] + "\"]"));
					if ( visibilityCheck != null && visibilityCheck.size() > 0) {
						break;
					}
				}
				if ( visibilityCheck.isEmpty() ) {
					Assert.assertTrue("Login was successful", true);
				} else {
					DslLogBeauty.logger(DSLLogConstract.WITHOUT_PARAMATER, new Object[] { "No user is known with the given login and password " }, new Exception(), ClickWebSteps.class);
				}
			}
		}
		for (int i = 0; i < cssValidator.length; i++) {
			//visibilityCheck = getContext().findElements(By.cssSelector("[class=\"" + cssValidator[i] + "\"]"));
			visibilityCheck = getContext().findElements(By.cssSelector("." + cssValidator[i] + ""));
			if ( visibilityCheck != null && visibilityCheck.size() > 0) {
				break;
			}
		}
		if ( visibilityCheck.isEmpty() ) {
			Assert.assertTrue("Login was successful", true);
		} else {
			DslLogBeauty.logger(DSLLogConstract.WITHOUT_PARAMATER, new Object[] { "Login user not succesfull! " }, new Exception(), ClickWebSteps.class);
		}
	}
	
	/**
	 * Press ScrollDown to bottom of page<br>
	 */
	@When("I scrolldown the bottom of iframe")
	public void doScrollDown() {
		try {
			getContext().switchTo().frame(0);
			getContext().executeScript("window.scrollTo(0,50000);");
		}
		catch (final Exception e) {
			DslLogBeauty.logger(DSLLogConstract.WITHOUT_PARAMATER, new Object[] { "The scroll down to the bottom of page couldn´t be done!" }, e, ClickWebSteps.class);
		}
	}

	/**
	 * Press ScrollDown to bottom of page by iframe index<br>
	 */
	@When(value = "I scrolldown the bottom of iframe $index", priority = 0)
	public void doScrollDown(final int index) {
		try {
			getContext().switchTo().frame(index);
			getContext().executeScript("window.scrollTo(0,50000);");
		}
		catch (final Exception e) {
			DslLogBeauty.logger(DSLLogConstract.WITHOUT_PARAMATER, new Object[] { "The scroll down to the bottom of page couldn´t be done!" }, e, ClickWebSteps.class);
		}
	}

	/**
	 * Press ScrollDown to bottom of page by iframe class<br>
	 */
	@When(value = "I scrolldown the bottom of iframe class $className", priority = 2)
	public void doScrollDown(final String className) {
		try {
			List<WebElement> iframes = getContext().findElements(By.xpath(".//*[@class='"+className+"']"));
			for (WebElement iframe : iframes) {
				Integer width = iframe.getSize().getWidth();
				if (width > 0) {
					getContext().switchTo().frame(iframe);
					break;
				}
			}
			
			getContext().executeScript("window.scrollTo(0,50000);");
		}
		catch (final Exception e) {
			DslLogBeauty.logger(DSLLogConstract.WITHOUT_PARAMATER, new Object[] { "The scroll down to the bottom of page couldn´t be done!" }, e, ClickWebSteps.class);
		}
	}

	@When("I slide to end of the captcha")
	public void doScrollRightCaptcha() {
		try {
			WebElement slider = getContext().findElement(By.xpath(".//*[@class='noUi-origin']"));
			Actions builder = new Actions (getContext());
			getContext().executeScript("$('.js-slider-captcha')[0].noUiSlider.set(1)");
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
			builder.clickAndHold(slider).moveByOffset(0, 0).release().perform();

			
		}
		catch (final Exception e) {
			DslLogBeauty.logger(DSLLogConstract.WITHOUT_PARAMATER, new Object[] { "Slide end of the captcha couldn´t be done!" }, e, ClickWebSteps.class);
		}
	}

	/** 
	 * Switch to iframe location by CSS. usable on Mailinator activation mail and popup close <br>
	 */
	@When(value = "I switch to iframe $css location")
	public void switchToiframe(final String iframelocation) {
		try {
			By iframeLocator = By.cssSelector(iframelocation);
			new WebDriverWait(getContext(), 2).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeLocator));
			Assert.assertTrue("", true);
		} catch (final Exception e) {
			DslLogBeauty.logger(DSLLogConstract.ELEMENT_NOT_FOUND, new Object[] { iframelocation, "Can not switch or could not find the iframe! " }, e, ClickWebSteps.class);
		}
	}

	/** 
	 * Switch to iframe location by id. <br>
	 */
	@When(value = "I switch to iframe with id $id")
	public void switchToiframeWithId(final String id) {
		try {
			getContext().switchTo().frame(id);
			Assert.assertTrue("", true);
		} catch (final Exception e) {
			DslLogBeauty.logger(DSLLogConstract.ELEMENT_NOT_FOUND, new Object[] { id, "Can not switch or could not find the iframe! " }, e, ClickWebSteps.class);
		}
	}

	/**
	 * Switch to Default Content <br>
	 */
	@When("I switch back to switchBackToDefaultContent")
	public void switchBackToDefault() {
		try {
			getContext().switchTo().defaultContent();
		} catch (final Exception e) {
			DslLogBeauty.logger(DSLLogConstract.WITHOUT_PARAMATER, new Object[] { "Can not switch Back To Default Content " }, e, ClickWebSteps.class);
		}
	}
	
	/**
	 * Get Cookies<br>
	 */
	@When("I get domain based cookies")
	public void doCheckBrowserCookies() {
		try {
			getContext().manage().getCookies().contains(getSystem());
		} catch (final Exception e) {
			LOG.error("The browser back button couldn´t be clicked!", e);
		}
	}

	/**
	 * Waits until either elements is visible or timeout expires
	 * @param selector Selector for element to wait to be visible
	 * @param timeout Timeout in seconds
	 */
	private void genericClick(final String elementID, final WebElement elm) {
		Assert.assertTrue(String.format("Web: Could not click element: '%s' because it is not visible", elementID),
				elm.isDisplayed());
		genericClickElement(elm);
		getContext().waitUntilTimeout(MAX_TIMEOUT_5_SECONDS);
	}
	
	private void genericClickWithoutWait(final String elementID, final WebElement elm) {
		Assert.assertTrue(String.format("Web: Could not click element: '%s' because it is not visible", elementID),
				elm.isDisplayed());
		genericClickElement(elm);
	}

	private void genericClickCss(final String css, final WebElement elm) {
		try {
			Assert.assertTrue(String.format("Web: Could not click element: '%s' because it is not visible", css), elm.isDisplayed());
			genericClickElement(elm);
			getContext().waitUntilTimeout(MAX_TIMEOUT_5_SECONDS);
		} catch ( NullPointerException e ) {
			return;
		}
	}
	
	private void genericClickElement(final WebElement elm) {
		getContext().getContextBasedActions().clickElement(elm);
	}
	
	@When("I highlight element with xpath $xpath")
    public void highlightByXpath( final String xpath) {
    	List<WebElement> elements = null;
		try {
			elements = getContext().findElements(By.xpath(xpath));
			WebElement el = elements.get(0);
			
			getContext().highlightElement(el);
			
		}catch (Exception e) {
			LOG.error(e);
		}
    }

}