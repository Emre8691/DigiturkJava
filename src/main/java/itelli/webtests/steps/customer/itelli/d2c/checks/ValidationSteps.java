package itelli.webtests.steps.customer.itelli.d2c.checks;

import org.apache.log4j.Logger;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import itelli.webtests.common.DSLLogConstract;
import itelli.webtests.common.DslLogBeauty;
import itelli.webtests.domain.Component;
import itelli.webtests.pages.base.ContextBase;
import itelli.webtests.steps.AbstractSteps;

/**
 * DSL which provides validation checks.
 */
public class ValidationSteps extends AbstractSteps<ContextBase> {

	private static final Logger LOG = Logger.getLogger(ContextBase.class);

	/**
	 * Checks if the expected validation is active.<br>
	 * *
	 * 
	 * @param attribute The validation as identifier
	 * @throws Throwable 
	 */
	@Then("the expected $validationID is shown")
	@Alias("the voucher validation error $errorcode is shown")
	public void checkValidationIsActive(final String attribute) {
		// Wait for server validations!
		getContext().setWaitTimeout(MAX_TIMEOUT_5_SECONDS);
		getContext().getContextBasedActions().clickStaticElement("wrapper");

		final WebElement elm = getContext().findElementByGivenAttribute(attribute);
		try {
			Assert.assertTrue(String.format("Validation for form field %s is not the expected!", attribute), elm.isDisplayed());
		} catch (Exception e) {
			DslLogBeauty.logger(DSLLogConstract.ELEMENT_NOT_FOUND, new String[]{attribute, "Error validation block"}, e, ValidationSteps.class);
		}
	}

	// TODO: Check if components.properties will be useable for new layouts.
	/**
	 * Checks the component by given code is available in page.<br>
	 * 
	 * @param component The component description object to get the identifier of the component.
	 */
	@Then(value = "the component $component exists on page", priority = 1)
	public void checkComponentExistsOnPage(final Component component) {
		final String componentName = component.getName();
		final boolean existsOnPage = getContext().getContextBasedValidations().isElementByAttributeIdAvailable(componentName);
		Assert.assertTrue("The component does not exist on page", existsOnPage);
	}

	/**
	 * Checks the component by given name is available in page.<br>
	 * Then the component named by 'component' exists on page.<br>
	 * 
	 * @param component The identifier of the component.
	 */
	@Then(value = "the component named by $component exists on page", priority = 2)
	public void checkComponentNamedByExistsOnPage(final String component) {

		final boolean existsOnPage = getContext().getContextBasedValidations().isElementByAttributeIdAvailable(component);
		Assert.assertTrue("The component named by " + component + " does not exist on page", existsOnPage);
	}
}
