package itelli.webtests.pages.base;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Keyboard;

/**
 *  
 *
 */
public class ContextBasedActions {

	private static final Logger LOG = Logger.getLogger(ContextBasedActions.class);

	private ContextBase contextBase;

	/**
	 * Get the list of links for a given class selector.<br>
	 * 
	 * @param cssSelector The css class of the element
	 * @return contentlist The list of found href links
	 */
	public final List<String> getLinksByCssSelector(final String cssSelector) {
		final List<String> contentlist = new ArrayList<String>();
		final List<WebElement> elements = contextBase.findElements(By.xpath("//a[@class=\"" + cssSelector + "\"]"));
		if (elements != null) {
			for (final WebElement element : elements) {
				final String content = element.getAttribute("href");
				if (!StringUtils.isBlank(content)) {
					contentlist.add(content);
				}
			}
		}
		return contentlist;
	}

	/**
	 * Workaround for getting Element if is not visible.
	 * 
	 * @param attribute The class name
	 */
	public void clickStaticElement(final String attribute) {
		try {
			final WebElement body = contextBase.findElement(By.className(attribute));
			if (body != null) {
				//body.click();
				
				WebDriver driver = contextBase.getDriverProvider().get();
				Actions builder = new Actions(driver);   
				builder.moveToElement(body, 0, 0).click().build().perform();
			}
		}
		catch (final Exception e) {
			LOG.debug("No body tag [class] found on page where to click on button");
		}
	}

	/**
	 * Go to method for clicking button by given attribute.
	 * 
	 * @param attribute the given attribute
	 */
	public void clickByGivenAttribute(final String attribute) {
		doAction(attribute);
	}

	/**
	 * Click (fire event) the element specified given parameter.
	 * 
	 * @param attribute the attribute id as testingId, id, type, name, etc.
	 */

	public void doAction(final String attribute) {
		WebElement input = null;

		final long timeout = 0;
		contextBase.setWaitTimeout(timeout);

		try {
			final WebElement body = contextBase.findElement(By.id("wrapperAll"));
			if (body != null) {
				body.click();
			}
		}
		catch (final Exception e) {
			// something strange has happend
			LOG.debug("No body tag found on page where to click on button");
		}
		input = contextBase.findElementByGivenAttribute(attribute);
		if (input != null) {
			if (!clickButtonInsteadOfDiv(input)) {
				input.click();
			}
		}
		else {
			LOG.error("Unable to find element \"" + attribute + "\"!");
		}
	}

	/**
	 * Click (fire event) the element specified by the attribute testing_id.
	 * 
	 * @param testingId The attribute identifier of the element to be clicked
	 */
	public void clickOption(final String testingId) {
		// Workaround:
		// sometimes there is a problem that the flyout layer above the button gets the click event
		// thus we have to click into the body tag at first to set the focus to the correct window layer
		try {
			final WebElement body = contextBase.findElement(By.id("wrapperAll"));
			if (body != null) {
				body.click();
			}
		}
		catch (final Exception e) {
			// something strange has happend
			LOG.warn("No body tag found on page where to click on button");
		}

		// search if attribute id is an testing id
		final WebElement elm = contextBase.findElementByAttributeId(testingId);
		if (elm != null) {

			if (this.clickLabelInsteadOfInputButton(elm)) {
				return;
			}

			try {
				elm.click();
				return;
			}
			catch (final Exception e) {
				// something strange has happend
				LOG.error("found button to click but there was an exception", e);
			}
		}
	}

	/**
	 * Click (fire event) the input element specified by the attribute name and value.
	 * 
	 * @param attribute The name of the attribute of the element to be clicked
	 * @param value The value of the attribute of the element to be clicked
	 */
	public void clickInputButtonByAttributeAndValue(final String attribute, final String value) {
		final WebElement elm = contextBase.findElementByAttributeAndValue(attribute, value);
		clickElement(elm);
	}
	
	public void clickElement(WebElement elm) {
		if (elm != null) {
			if (!this.clickLabelInsteadOfInputButton(elm)) {
				elm.click();
			}
		}
	}

	private boolean clickLabelInsteadOfInputButton(final WebElement elm) {

		// workaround:
		// there are a problem using the new layout (siemens2013) and to click a radio or checkbox button
		// thus we try to look for the corresponding label (must have set attribute "for")

		if (elm.getTagName().equals("input")
				&& (elm.getAttribute("type").equals("radio") || elm.getAttribute("type").equals("checkbox"))) {

			final String elmId = elm.getAttribute("id");
			if (!StringUtils.isEmpty(elmId)) {

				contextBase.setWaitTimeout(0);	// check immediately

				final WebElement parent = elm.findElement(By.xpath(".."));
				try {
					final WebElement elmLabel = parent.findElement(By.cssSelector("label[for=\"" + elmId + "\"]"));
					if (elmLabel != null) {
						//elmLabel.click();
						int center = elmLabel.getSize().getHeight() / 2;
					
						WebDriver driver = contextBase.getDriverProvider().get();
						Actions builder = new Actions(driver);   
						builder.moveToElement(elmLabel, center, center).click().build().perform();
						
					
						return true;
					}
				}
				catch (final Exception e) {
					LOG.debug("Input button is not exist instead lable.", e);
				}
			}
		}
		return false;
	}

	private boolean clickButtonInsteadOfDiv(final WebElement elm) {

		if (elm.getTagName().equals("div")) {
			contextBase.setWaitTimeout(0);	// check immediately

			final WebElement elmButton = elm.findElement(By.cssSelector("button"));
			try {
				if (elmButton != null) {
					elmButton.click();
					return true;
				}
			}
			catch (final Exception e) {
				LOG.debug("button is not available instead of div.", e);
			}
		}
		return false;
	}

	/**
	 * Go to method for clearing form by given attribute.
	 * 
	 * @param attribute the given attribute
	 */
	public void clearFormElement(final String attribute) {
		final WebElement input = contextBase.findElementByGivenAttribute(attribute);
		if (input != null) {
			while (StringUtils.isNotEmpty(input.getAttribute("value"))) {
				input.sendKeys(Keys.BACK_SPACE);
			}
		}
		
	}

	/**
	 * Press the enter button where the focus is.
	 */
	public void setEnter() {

		final Keyboard key = contextBase.getKeyboard();
		try {
			key.sendKeys(Keys.ENTER);
		}
		catch (final UnhandledAlertException e) {
			LOG.error("Not possible to press Enter on the expected focus!");
		}
	}

	/**
	 * Press the tab button where the focus is.
	 */
	public void setTab() {

		final Keyboard key = contextBase.getKeyboard();
		try {
			key.sendKeys(Keys.TAB);
		}
		catch (final UnhandledAlertException e) {
			LOG.error("Not possible to press Tabulator on the expected focus!");
		}
	}

	/**
	 * Press the tab button where the focus is.
	 */
	public void setSpace() {

		final Keyboard key = contextBase.getKeyboard();
		try {
			key.sendKeys(Keys.SPACE);
		}
		catch (final UnhandledAlertException e) {
			LOG.error("Not possible to press Space on the expected focus!");
		}
	}

	public ContextBase getContextBase() {
		return contextBase;
	}

	public void setContextBase(final ContextBase contextBase) {
		this.contextBase = contextBase;
	}

}
