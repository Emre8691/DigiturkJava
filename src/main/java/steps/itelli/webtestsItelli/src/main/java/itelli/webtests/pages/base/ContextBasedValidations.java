package steps.itelli.webtestsItelli.src.main.java.itelli.webtests.pages.base;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * 
 *
 */
public class ContextBasedValidations {

	private ContextBase contextBase;

	/**
	 * Check if element specified by attribute testing_id exists on shown page.
	 * 
	 * @param testingId The attribute testing_id of the element
	 * @return if element exists
	 */
	public boolean isElementByAttributeIdAvailable(final String testingId) {
		final WebElement element = contextBase.findElementByAttributeId(testingId);
		return element != null;
	}

	/**
	 * Get the value by element <tt>id</tt> or if not found by <tt>name</tt>.<br/>
	 * 
	 * @param id the identifier or name of the element to get input value
	 * @return expected attribute by value
	 */

	public final String getFormElementValueByIdOrByName(final String id) {
		final WebElement input = contextBase.getElementFinder().findBy(id);
		if (input == null) {
			return StringUtils.EMPTY;
		}
		return input.getAttribute("value");
	}

	/**
	 * Check if element specified by attribute testing_id is selected on shown page.
	 * 
	 * @param testingId The attribute testing_id of the element
	 * @return if element is selected
	 */
	public boolean isElementByAttributeIdSelected(final String testingId) {
		final WebElement element = contextBase.findElementByAttributeId(testingId);
		if (element != null) {
			return element.isSelected();
		}
		return false;
	}

	/**
	 * Checks if element is not empty.
	 * 
	 * @param bySelector the {@link By} to use for detection
	 * @return if element exists and is not empty
	 */
	public boolean isNotEmptyElementBySelector(final By bySelector) {
		final WebElement element = contextBase.findElement(bySelector);
		if (element == null) {
			return false;
		}
		contextBase.setWaitTimeout(0);
		final List<WebElement> elements = element.findElements(By.cssSelector("div"));
		if (elements == null || elements.isEmpty()) {
			return false;
		}
		return true;
	}

	/**
	 * Check if element specified by tag identifier is selected on shown page.
	 * 
	 * @param identifier The identifier of the checked element
	 * @return if element is selected
	 */
	public boolean isElementByIdSelected(final String identifier) {
		final WebElement element = contextBase.findElementById(identifier);
		if (element != null) {
			return element.isSelected();
		}
		// as default look for element by testingId (necessary for new siemens2013 layout)
		return this.isElementByAttributeIdSelected(identifier);
	}

	/**
	 * Check if element specified by attribute testing_type exists on shown page.
	 * 
	 * @param testingType The attribute testing_type of the element
	 * @return if element exists
	 */
	public boolean isElementByAttributeTypeAvailable(final String testingType) {
		final WebElement element = contextBase.findElementByAttributeType(testingType);
		return element != null;
	}

	public ContextBase getContextBase() {
		return contextBase;
	}

	public void setContextBase(final ContextBase contextBase) {
		this.contextBase = contextBase;
	}

}
