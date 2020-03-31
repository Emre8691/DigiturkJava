package steps.itelli.webtestsItelli.src.main.java.itelli.webtests.steps.customer.itelli.d2c.actions;

import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import steps.itelli.webtestsItelli.src.main.java.itelli.webtests.pages.base.ContextBase;
import steps.itelli.webtestsItelli.src.main.java.itelli.webtests.steps.AbstractSteps;

/**
 * DSL for selecting drop down, checkboxes or radio buttons
 */
public class SelectionSteps extends AbstractSteps<ContextBase> {

	/**
	 * Select a delivermode by value.
	 * 
	 * @param mode The delivermode.
	 */
	@When("I select the delivermode $mode")
	public void selectDeliveryMode(final String mode) {
		getContext().getContextBasedActions().clickInputButtonByAttributeAndValue("value", mode);
	}

	/**
	 * Switch to selecting the workaround of Bosch or Siemens new layout (2013).<br>
	 * DSL sentence at {@link SelectionWebSteps#selectDropDown(String, String)}
	 * 
	 * @param value The value which has to be select.
	 * @param select The menu which has to be selectable.
	 */
	public void selectDropDownWorkaround(final String value, final WebElement select) {
		// Workarounds for Siemens and Bosch new Layouts (2013)
		final WebElement parent = select.findElement(By.xpath(".."));
		if (parent != null && parent.getAttribute("class") != null
				&& parent.getAttribute("class").contains("selectricHideSelect")) {
			getContext().formNewLayoutWorkaroundBosch(select, value);
		}
		else {
			getContext().formNewLayoutWorkaroundSiemens(select, value);
		}
	}

	/**
	 * Select the first available deliverymode.<br>
	 * Then the agree validation error is shown y service (radiobox).<br/>
	 * TODO: Remove Sentence (Workaround) after switch of old Bosch and Siemens Layouts. <br>
	 * TODO: BSH Feature Delivery Mode check
	 * 
	 * @param deliveryService The attribute name for an available delivery service.
	 */
	@When("I click the delivery service with available attribute $deliveryService")
	public void selectAvailableDeliveryService(final String deliveryService) {
		// Workaround: To find the correct delivery mode we need to check a universal unique tag!

		final WebElement elm = getContext().findAttributeByValue("checked", "checked");
		if (elm == null || !elm.getAttribute(deliveryService).equals("true")) {
			getContext().getContextBasedActions().clickInputButtonByAttributeAndValue(deliveryService, "true");
		}
	}
}
