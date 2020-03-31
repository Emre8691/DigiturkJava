package itelli.webtests.steps.customer.itelli.d2c.features;

import java.util.List;

import junit.framework.Assert;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import itelli.webtests.pages.base.ContextBase;
import itelli.webtests.steps.AbstractSteps;

/**
 * BSH Feature Dialog Steps included at MyAccount Registration, CEW and Checkout processes.
 */
public class NavigationBarSteps extends AbstractSteps<ContextBase> {

	/**
	 * Check if the navigation element is disabled.<br>
	 * Only for navigation at myaccount usefull.<br>
	 * Search the element and his parant for checking the class of parant is set disable.<br>
	 * <br>
	 * 
	 * @param element The given element.
	 * @param status The given status.
	 */
	@Then("the status of navigation element $element is $status")
	public void checkNavigationElementStatus(final String element, final String status) {
		final WebElement searchedElement = getContext().findElementByTestingId(element);
		String searchedStatus = null;

		if (searchedElement.getAttribute("class").isEmpty() && StringUtils.isNotBlank(status)) {
			// Try to get the class element from parant element.
			final WebElement parant = searchedElement.findElement(By.xpath(".."));
			searchedStatus = parant.getAttribute("class");
		}
		else {
			searchedStatus = searchedElement.getAttribute("class");
		}

		Assert.assertEquals("The status is not correct! Expected: ", status, searchedStatus);
	}

	/**
	 * Checks if dialogue step is in the given status.<br>
	 * <br>
	 * active: The currently active lable.<br>
	 * clickable: The done lable(s) which is/are clickable and marked.<br>
	 * marked: The done lable(s) which is/are only marked.<br>
	 * inactive: The inactive lables(s) means the next step(s).<br>
	 * 
	 * @param stepId Name of current dialogue step.
	 * @param status Status of dialogue step.
	 */
	@Then("the dialogue step $stepId is $status")
	public void checkDialogSteps(final String stepId, final String status) {
		final WebElement dialog = getContext().findElementByTestingId(stepId);
		final String searchedStatus = getContext().getContextBasedInformations().getTextFromElementByAttributeId(
				"status-" +
				stepId);

		Assert.assertNotNull("The expected step isn´t shown!", dialog);
		Assert.assertEquals("The status is not correct! Expected: ", status, searchedStatus);
	}

	/**
	 * Checks if the feature has the expected result.<br>
	 * Then the list result of feature 'feature' is '{size|empty}'.<br>
	 * Only usable for Siemens 2013.
	 * 
	 * @param feature The feature of the list.
	 * @param value The result, also could be parameter "empty".
	 */
	@Then("the list result of feature $feature is $value")
	@Alias("the list result of element $element is $value")
	public void checkListSize(final String feature, final String value) {
		final WebElement featureElm = getContext().findElementByTestingId(feature);
		boolean isFeatureDisplayed = false;
		int currentSize = 0;

		if (featureElm != null && featureElm.isDisplayed()) {
			isFeatureDisplayed = true;

			// first try
			final String actualSizeStr = StringUtils.trim(getContext().getContextBasedInformations()
					.getTextFromElementByAttributeId(feature + "Size"));

			if (StringUtils.isNotBlank(actualSizeStr)) {
				currentSize = Integer.parseInt(value);
			}

			// second try (get size by counting childrens)
			else {
				final List<WebElement> childElements = featureElm.findElements(By.xpath("*"));
				if (childElements != null) {
					currentSize = childElements.size();
				}
			}
		}

		final int expectedSize;

		if (value.equalsIgnoreCase("empty")) {
			expectedSize = 0;
		}
		else if (NumberUtils.isNumber(value)) {
			expectedSize = Integer.parseInt(value);
		}
		else {
			throw new IllegalArgumentException(value + " is not a valid value!");
		}

		Assert.assertTrue(String.format("Feature '%s' does not exist!", feature), isFeatureDisplayed);
		Assert.assertEquals("The list size isn´t the expected!", expectedSize, currentSize);
	}

}
