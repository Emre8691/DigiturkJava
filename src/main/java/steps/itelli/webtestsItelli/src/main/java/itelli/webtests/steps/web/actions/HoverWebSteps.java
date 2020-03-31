package steps.itelli.webtestsItelli.src.main.java.itelli.webtests.steps.web.actions;

import java.util.List;

import org.apache.log4j.Logger;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import steps.itelli.webtestsItelli.src.main.java.itelli.webtests.pages.base.ContextBase;
import steps.itelli.webtestsItelli.src.main.java.itelli.webtests.steps.AbstractSteps;


/**
 * Web Application Steps which are useable for click functionalities of webpages.
 */
public class HoverWebSteps extends AbstractSteps<ContextBase> {

	private static final Logger LOG = Logger.getLogger(ContextBase.class);

	/**
	 * Hover given element by given testingID or html element attribute.<br>
	 * 
	 * @param elementID The element ID could be a link or a clickable button
	 */
	@When("I hover on the {button|element} $elementID")
	public void doHoverByElement(final String elementID) {
		final WebElement elm = getContext().findElementByGivenAttribute(elementID);
		Assert.assertNotNull(String.format("Web: Could not find hoverable element: '%s'", elementID), elm);
		genericHover(elementID, elm);
	}

	private void genericHover(final String elementID, final WebElement elm) {
		try {
			Assert.assertTrue(String.format("Web: Could not hover element: '%s' because it is not visible", elementID), elm.isDisplayed());
		} catch (Exception e) {
			DslLogBeauty.logger(DSLLogConstract.ELEMENT_NOT_FOUND, new Object[] { elm, "Error validation block" }, new Exception(), HoverWebSteps.class);
		}
		doHoverByElement(elementID);
		getContext().waitUntilTimeout(MAX_TIMEOUT_5_SECONDS);
	}

	@When("I hover on the Menu Dropdown For Bosch")
	public void doHoverForBosch() {
		final WebElement element = getContext().findElement(By.linkText("store"));

		final Actions action = new Actions(getContext());

		action.moveToElement(element).build().perform();

		getContext().findElement(By.linkText("store")).click();
	}

	/**
	 * Hovers the any element via XPATH.<br>
	 * For getting the visible element, the css selector found a list of elements by given xpath.<br>
	 * The list elements will be checked if there are visible. cssSelector(xpath)
	 * @param xpath of the given element at navigation.
	 */
	@When("I hover2 on the $xpath without click")
	public void doHoverByXpathWitoutClick(final String xpath) {
		List<WebElement> elements = null;

		if (elements == null) {
			elements = getContext().findElements(By.xpath(xpath));
		}
		if (elements == null || elements.isEmpty()) {
			LOG.error("Unable to find navigation element \"" + xpath + "\"!");
			return;
		}

		if (elements.size() >= 1) {
			for (final WebElement element : elements) {
				if (element.isDisplayed()) {

					final Actions hoverDriver = new Actions(getContext());
					final Actions HoverOnHoverDriver = hoverDriver.moveToElement(element);
					HoverOnHoverDriver.perform();
					try {
						Thread.sleep(2000);
					}
					catch (final InterruptedException e) {
						// TODO Auto-generated catch block
						LOG.error("Give me a reasonable message", e);
					}
					// element.click();
					// getContext().waitUntilTimeout(MAX_TIMEOUT_5_SECONDS);
					break;
				}
			}
		}
	}

	@When("I hover on the $xpath")
	public void doHoverByXpath(final String xpath) {
		List<WebElement> elements = null;

		if (elements == null) {
			elements = getContext().findElements(By.xpath(xpath));
		}
		if (elements == null || elements.isEmpty()) {
			LOG.error("Unable to find navigation element \"" + xpath + "\"!");
			return;
		}

		if (elements.size() >= 1) {
			for (final WebElement element : elements) {
				if (element.isDisplayed()) {

					final Actions hoverDriver = new Actions(getContext());
					final Actions HoverOnHoverDriver = hoverDriver.moveToElement(element);
					HoverOnHoverDriver.perform();
					try {
						Thread.sleep(2000);
					}
					catch (final InterruptedException e) {
						// TODO Auto-generated catch block
						LOG.error("Give me a reasonable message", e);
					}
					element.click();
					getContext().waitUntilTimeout(MAX_TIMEOUT_5_SECONDS);
					break;
				}
			}
		}
	}

}
