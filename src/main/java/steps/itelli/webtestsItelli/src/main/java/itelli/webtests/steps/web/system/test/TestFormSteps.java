package itelli.webtests.steps.web.system.test;

import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import itelli.webtests.pages.base.ContextBase;
import itelli.webtests.steps.AbstractSteps;

/**
 * Test definitions webtest functions.
 */
public class TestFormSteps extends AbstractSteps<ContextBase> {

	/**
	 * Form field test.<br>
	 * Checks the form field fill functionality of webtest by enter reapeated string combinations to a single form field.<br>
	 * 
	 * @param field The form field which has to be test.
	 * @param keys Keys to send (content of property or parametrised dirctly from sentence).
	 * @param repeated The interation value. How often the form will be filled.
	 */
	@When("I send keys $keys to field $field $repeated times")
	public void testKeys(final String keys, final String field, final int repeated) {
		final WebElement elm = getContext().findElementByGivenAttribute(field);
		final int iterator = repeated;
		for (int i = 0; i < iterator; i++) {
			if (elm.getAttribute("value") != null) {
				getContext().getContextBasedActions().clearFormElement(field);
			}
			getContext().fillForm(field, keys);
			Assert.assertEquals("Form field didn´t show the expected parameter!", keys, elm.getAttribute("value"));
			getContext().getContextBasedActions().clearFormElement(field);
		}
	}

}
