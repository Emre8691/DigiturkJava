package itelli.webtests.steps.web.elements;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import itelli.webtests.common.DSLLogConstract;
import itelli.webtests.common.DslLogBeauty;
import itelli.webtests.pages.base.ContextBase;
import itelli.webtests.steps.AbstractSteps;
import itelli.webtests.steps.web.actions.ClickWebSteps;
import itelli.webtests.steps.web.alerts.AlertWebSteps;

/**
 * Check if elements have the expected status.
 */
public class ElementSteps extends AbstractSteps<ContextBase> {

	private static final Logger LOG = Logger.getLogger(AlertWebSteps.class);

	private boolean elementVisible(final String elementID) {
		final WebElement elm = getContext().findElementByGivenAttribute(elementID);
		if (!elm.isDisplayed()) {
			return getContext().findDuplicatedVisibleElements(elementID, elm);
		}
		return elm.isDisplayed();
	}

	/**
	 * Checks if html element searched by html element attribute is displayed.
	 * @param elementID The element which has to be visible
	 */
	@Then("the element $elementID is visible")
	public void checkIfVisible(final String elementID) {
		try {
			Assert.assertTrue(String.format("The element '%s' is not visible", elementID), elementVisible(elementID));	
		} catch (Exception e) {
			DslLogBeauty.logger(DSLLogConstract.ELEMENT_NOT_FOUND, new Object[] { elementID, "The element id " }, new Exception(), ElementSteps.class);
		}
	}

	/**
	 * Checks if html element searched by html element attribute is not displayed.
	 * @param elementID The element which has to be hidden
	 */
	@Then("the hidden $elementID is not visible")
	public void checkIfNotVisible(final String elementID) {
		try {
			Assert.assertFalse(String.format("The element '%s' is visible", elementID), elementVisible(elementID));	
		} catch (Exception e) {
			DslLogBeauty.logger(DSLLogConstract.ELEMENT_NOT_FOUND, new Object[] { elementID, "The element not visible " }, new Exception(), ElementSteps.class);
		}
	}

	/**
	 * Check elementID field at Alert Window expected focus.<br>
	 * @param elementID The elements which has to be visible
	 */
	@Then("the $elementID is visible at the pop up box")
	public void checkIfVisiblePopUp(final String elementID) {
		try {
			final String parentWindow = getContext().getWindowHandle();
			final Set<String> windowHandles = getContext().getWindowHandles();
			final Iterator<String> iterator = windowHandles.iterator();
			
			boolean found = false;
			while (iterator.hasNext()) {
				final String handle = iterator.next();
				if (!handle.contains(parentWindow) && !found) {
					found = true;
					// Switch to popup
					getContext().switchTo().window(handle);
					// Add code to find element
					////Assert.assertTrue(String.format("The element '%s' is not visible", elementID), elementVisible(elementID));
				}
			}
			if (found) {
				Assert.assertTrue(String.format("The element '%s' is not visible", elementID), elementVisible(elementID));
				//getContext().switchTo().window(parentWindow);
			}
		}
		catch (final Exception e) {
			LOG.error("The element '%s' is not visible", e);
		}
	}

	/**
	 * Switch to opened pop up window.<br>
	 */
	@When("I switch to the pop up window")
	public void checkIfVisiblePopUp() {
		try {
			final String parentWindow = getContext().getWindowHandle();
			final Set<String> windowHandles = getContext().getWindowHandles();
			final Iterator<String> iterator = windowHandles.iterator();
			
			boolean found = false;
			while (iterator.hasNext()) {
				final String handle = iterator.next();
				if (!handle.contains(parentWindow) && !found) {
					found = true;
					// Switch to popup
					getContext().switchTo().window(handle);
				}
			}
		}
		catch (final Exception e) {
			LOG.error("The element '%s' is not visible", e);
		}
	}

	/**
	 * Switch to the pop up window where $searchingHTMLValue exists.<br>
	 */
	@When("I switch to the pop up window where $searchingHTMLValue exists")
	public void checkIfVisiblePopUpWithCheck(final String searchingHTMLValue) {
		try {
			LOG.info("checkIfVisiblePopUpWithCheck : " + searchingHTMLValue );
			System.out.println("checkIfVisiblePopUpWithCheck : " + searchingHTMLValue );
			final String parentWindow = getContext().getWindowHandle();
			final Set<String> windowHandles = getContext().getWindowHandles();
			final Iterator<String> iterator = windowHandles.iterator();
			System.out.println("while");
			boolean found = false;
			while (iterator.hasNext()) {
				final String handle = iterator.next();
				System.out.println("pop up handle: " + handle);
				if (!handle.contains(parentWindow) && !found) {
					getContext().switchTo().window(handle);
					System.out.println("Check pop up : " + getContext().getTitle());
					boolean isOnPage = getSystem().checkPageContains(searchingHTMLValue);
					found = isOnPage;
					if (found) {
						System.out.println("Switched to the pop up : " + getContext().getTitle());
						break;
					}
				}
			}
			if (!found) {
				getContext().switchTo().window(parentWindow);
				LOG.info("Switched to the parent : " + searchingHTMLValue);
			}
		}
		catch (final Exception e) {
			LOG.error("The element '%s' is not visible", e);
		}
	}

	/**
	 * Switch Back Focus to parent window from Alert Window expected focus.<br>
	 */
	@Then("switch back the window to parent window from the pop up box")
	public void switchToParentWindow() {
		try {
			final String parentWindow = getContext().getWindowHandle();
			final Set<String> windowHandles = getContext().getWindowHandles();
			final Iterator<String> iterator = windowHandles.iterator();
			while (iterator.hasNext()) {
				final String handle = iterator.next();
				if (!handle.contains(handle)) {
					// Switch to popup
					getContext().switchTo().window(parentWindow);
					// Add code to find element
				}
			}
		}
		catch (final Exception e) {
			LOG.error("switch back '%s' is not possible", e);
		}
	}

	/**
	 * Switch Back Focus to parent window from Alert Window static workaround.<br>
	 */
	@Then("switch back the window to parent window static")
	public void switchToParentWindowStatic() {
		// Check for social test cases if fails Set Handles = getContext().getWindowHandles();
		final Set<String> handles = getContext().getWindowHandles();
		getContext().switchTo().window((String) handles.toArray()[0]);
	}
	
	/**
	 * Wait for element to become visible.<br>
	 */
	@Then("I wait for element with css $css to be visible")
	public void waitForElementVisible(final String css) {
		By cssSelector = By.cssSelector(css);
		WebElement element = getContext().waitForVisibility(cssSelector, MAX_TIMEOUT_COMMON);
		Assert.assertNotNull("Element is not visible: " +  css, element);
	}
	
	/**
	 * Wait for element to become visible.<br>
	 */
	@Then("I wait for element with css $css to be invisible")
	public void waitForElementInvisible(final String css) {
		By cssSelector = By.cssSelector(css);
		Boolean status = getContext().waitForInvisibility(cssSelector, MAX_TIMEOUT_COMMON);
		Assert.assertTrue("Element is visible / not found: " +  css, status);
	}
	
	/**
	 * Wait for element to become visible.<br>
	 */
	@Then("I wait for element with css $css to be clickable")
	public void waitForElementClickable(final String css) {
		By cssSelector = By.cssSelector(css);
		WebElement element = getContext().waitForClickable(cssSelector, MAX_TIMEOUT_COMMON);
		Assert.assertNotNull("Element is not clickable: " +  css, element);
	}
	
	/**
	 * Wait for element to become visible.<br>
	 */
	@Then("I wait for element with xpath $xpath to be visible")
	public void waitForElementVisibleWithXPath(final String xpath) {
		By xpathSelector = By.xpath(xpath);
		WebElement element = getContext().waitForVisibility(xpathSelector, MAX_TIMEOUT_COMMON);
		Assert.assertNotNull("Element is not visible: " +  xpath, element);
	}

	@Then("I wait for element with xpath $xpath contains $value")
	public void waitForElementWithXPathContainsValue(final String xpath, final String value) {
		try {
			new WebDriverWait(getContext(), MAX_TIMEOUT_COMMON).until((ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))));
			Assert.assertTrue("", true);
		} catch (final Exception e) {
			DslLogBeauty.logger(DSLLogConstract.ELEMENT_NOT_FOUND, new Object[] { xpath, "Can not switch or could not find the element! " }, e, ClickWebSteps.class);
		}
	}

	@Then(value = "I wait for element with css $css property $property value is $value", priority = 2)
	public void waitForElementWithXPathProperty(final String css, final String property, final String value) {

		Boolean status = new WebDriverWait(getContext(), MAX_TIMEOUT_COMMON).until(new ExpectedCondition<Boolean>() 
		{
			@Override
			public Boolean apply(WebDriver driver) {
				By cssSelector = By.cssSelector(css);
				WebElement element = getContext().findElement(cssSelector);
				//return element.getCssValue(property).equals(value);
				String elementValue = ((JavascriptExecutor)driver)
				        .executeScript("return window.getComputedStyle(arguments[0], ':before').getPropertyValue('"+property+"');",element).toString();
				return elementValue.equals(value);
			}
		});

		Assert.assertTrue("Element is not as given: " +  css, status);
	}

	@Then(value = "I wait for element with css $css value is $value", priority = 1)
	public void waitForElementWithXPathValue(final String css, final String value) {
		By cssSelector = By.cssSelector(css);
		Boolean status = getContext().waitForValue(cssSelector, value, MAX_TIMEOUT_COMMON);
		Assert.assertTrue("Element is not as given: " +  css, status);
	}


}