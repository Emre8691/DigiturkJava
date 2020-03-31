package itelli.webtests.steps.web.actions;

import java.util.List;

import org.jbehave.core.annotations.Aliases;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Required;

import itelli.webtests.common.DslLogBeauty;
import itelli.webtests.common.DSLLogConstract;
import itelli.webtests.domain.ContentElement;
import itelli.webtests.pages.base.ContextBase;
import itelli.webtests.steps.AbstractSteps;
import itelli.webtests.steps.customer.itelli.d2c.actions.SelectionSteps;

/**
 * DSL which handles all selections like checkbox, drop down, or radio button.
 */
public class SelectionWebSteps extends AbstractSteps<ContextBase> {

	private SelectionSteps bshSelectionSteps;

	/**
	 * Selects the given drop down option.<br>
	 * TODO: Has to be a single DSL without BSH workaround.
	 * @param fieldID The select tag identifier or html element attribute.
	 * @param value The selected option.
	 * @see BSHSelectionSteps#selectDropDownWorkaround(String, WebElement)
	 */
	@When("I select the $fieldID with option $value")
	public void selectDropDown(final String fieldID, final String value) {
		final WebElement select2 = getContext().findElement(By.xpath("//div[contains(@testing_id," + fieldID + ")]"));
		if (select2 == null) {
			getContext().findElement(By.xpath("//div[contains(@testing_id," + fieldID + ")]"));
			return;
		}
		if (select2.getTagName().equals("") && select2.isDisplayed()) {
			getContext().selectOption(value, select2);
		}
		else {
			bshSelectionSteps.selectDropDownWorkaround(value, select2);
		}
	}

	/**
	 * Selects the given drop down option.<br>
	 * TODO: Has to be a single DSL without BSH workaround.
	 * @param fieldID The select tag identifier or html element attribute.
	 * @param value The selected option.
	 * @see BSHSelectionSteps#selectDropDownWorkaround(String, WebElement)
	 */
	@When("I select the $fieldID with the option $value version")
	public void selectDropDown2(final String fieldID, final String value) {
		final WebElement select2 = getContext().findElementByGivenAttribute(fieldID);
		if (select2 == null) {
			return;
		}
		if (select2.getTagName().equals("select") && select2.isDisplayed()) {
			getContext().selectOption(value, select2);
		}
		else {
			bshSelectionSteps.selectDropDownWorkaround(value, select2);
		}
	}

	/**
	 * Selects the option(s)of the indexed target element drop down option.<br>
	 *  ex: When I select London option of the 2 nd/th available [name="region"] version
	 * @param fieldcss  CSS of target element.
	 * @param orderindex index number of target element.
	 *   
	 */
	@When("I select $value option of the $orderindex nd/th available $fieldcss version")
	public void selectDropDown3(final String value, final int orderindex, final String fieldcss){
		List<WebElement> icons = null;
		icons = getContext().findElements(By.cssSelector(fieldcss));
		if (icons == null || orderindex == 0){
			Assert.assertNull("Could not find target element!", icons);
			return;
		}
		if (icons.get(orderindex-1).isDisplayed()&& orderindex > 0) {
			getContext().selectOption(value, icons.get(orderindex-1));
		}
		else {
			bshSelectionSteps.selectDropDownWorkaround(value, icons.get(orderindex-1));
		}
	}
	
	
	/**
	 * Select or deselect the checkbox or radio button.<br>
	 * All DSL which choose a checkbox or a radio button: <br>
	 * When I choose the $optionID<br>
	 * When I continue with $optionID<br>
	 * When I decide to $agreeID<br>
	 * When I choose to subscribe the $newsletterID<br>
	 * When I choose to unsubscribe the $newsletterID<br>
	 * 
	 * @param optionID the checkbox or radiobutton.
	 */
	@When(value = "I choose the $optionID", priority = 0)
	@Aliases(values = { "I decide to $agreementID", "I continue with $optionID", "I choose to subscribe the $newsletterID",
			"I choose to unsubscribe the $newsletterID" })
	public void decideOption(final String optionID) {
		final WebElement elm = getContext().findElementByGivenAttribute(optionID);
		genericClickOption(optionID, elm);
	}

	/**
	 * Select or deselect the checkbox or radio button with internal mapping of {@link ContentElement}.<br>
	 * 
	 * @param optionID The checkbox or radiobutton.
	 * @param element The {@link ContentElement} for checkbox or radio button.
	 */
	@When(value = "I choose the $optionID $element", priority = 2)
	public void decideOptionOfElement(final String optionID, final ContentElement element) {
		final String identifier = element.getIdentifierFor(optionID);
		final WebElement elm = getContext().findElementByGivenAttribute(identifier);
		genericClickOption(identifier, elm);
	}

	/**
	 * Checks if the checkbox or radio button with internal mapping of {@link ContentElement} is selcted.<br>
	 * 
	 * @param element The {@link ContentElement} for checkbox or radio button.
	 * @param optionID The checkbox or radiobutton.
	 */
	@Then("the chosen $element is $optionID")
	public void checkPaymentIsSelected(@Named(value = "element") final ContentElement element, @Named(value = "optionID") final String optionID) {
		try {
			String identifier = element.getIdentifierFor(optionID);
			boolean isSelected = getContext().getContextBasedValidations().isElementByAttributeIdSelected(identifier);
			if ( isSelected ) {
				Assert.assertTrue(String.format("The radio button or checkbox for %s is not selected", identifier), isSelected);
			} else {
				DslLogBeauty.logger(DSLLogConstract.ELEMENT_NOT_FOUND, new Object[] { optionID, "The option ID " }, new Exception(), SelectionWebSteps.class);
			}
		} catch (Exception e) {
			DslLogBeauty.logger(DSLLogConstract.MULTI_ELEMENT_NOT_FOUND, new Object[] { element, optionID, "The Element " }, new Exception(), SelectionWebSteps.class);
		}
	}

	/**
	 * Checks the given checkbox or radio button is selected.<br>
	 * 
	 * @param optionID The html elemenet attribute of checkbox or radio button.
	 */
	@Then(value = "the chosen option $optionID is selected", priority = 1)
	@Aliases(values = { "the decided $agreementID is selected", "the {unsubscriben|subscriben} $newsletterID option is selected",
			"the current $optionID is preselected" })
	public void checkAgreeCheckboxIsSelected(final String optionID) {
		final boolean isSelected = getContext().getContextBasedValidations().isElementByAttributeIdSelected(optionID);
		if ( isSelected ) {
			Assert.assertTrue(String.format("The option %s is not selected", optionID), isSelected);
		} else {
			DslLogBeauty.logger(DSLLogConstract.ELEMENT_NOT_FOUND, new Object[] { optionID, "The option ID " }, new Exception(), SelectionWebSteps.class);
		}
	}

	/**
	 * Clicks a checkbox or radio button.
	 * 
	 * @param option The field which has to be checked.
	 * @param elm The {@link ContentElement} which has to be click.
	 */
	private void genericClickOption(final String optionID, final WebElement elm) {
		getContext().getContextBasedActions().clickOption(optionID);

		Assert.assertNotNull(String.format(
				"Web: The checkbox or radio button which will be searched to click is not the expected! Found element: '%s' "
						+ "for given attribute '%s'!", elm, optionID), elm);
	}

	@Required
	public void setBshSelectionSteps(final SelectionSteps bshSelectionSteps) {
		this.bshSelectionSteps = bshSelectionSteps;
	}
}
