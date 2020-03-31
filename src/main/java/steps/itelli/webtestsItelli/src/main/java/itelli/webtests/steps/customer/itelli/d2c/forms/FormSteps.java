package itelli.webtests.steps.customer.itelli.d2c.forms;

import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import itelli.webtests.domain.ContentElement;
import itelli.webtests.pages.base.ContextBase;
import itelli.webtests.steps.AbstractSteps;

/**
 * BSH specific form handling. Including When and Then annotations.
 */
public class FormSteps extends AbstractSteps<ContextBase> {

	/**
	 * Enter the values housenumber and street into the checkout delivery and billing address forms.
	 * 
	 * @param housenumber The housenumber.
	 * @param street The street.
	 * @param addresstype The address-type (= {@link ContentElement} key).
	 */

	@When(value = "I enter the street $street and housenumber $housenumber of the $addresstype", priority = 1)
	public void setBillingStreetAndHousenumber(final String street, final String housenumber, final ContentElement addresstype) {
		final WebElement elm = getContext().findFormElement(By.name(addresstype.getIdentifierFor("housenumber")));
		if (elm != null) {
			getContext().fillFormElement(addresstype.getIdentifierFor("street"), street);
			getContext().fillFormElement(addresstype.getIdentifierFor("housenumber"), housenumber);
		}
		else {
			getContext().fillFormElement(addresstype.getIdentifierFor("street"), street + housenumber);
		}
	}

	/**
	 * Enter the housenumber and street into the registration step 2 (old layout).<br>
	 * TODO: Sentence has to be delete after implement generic forms at myaccount jsp´s!!
	 * 
	 * @param housenumber The housenumber.
	 * @param street The street.
	 */
	@When("I enter the registration street $street and housenumber $housenumber")
	public void setDeliveryStreetAndHousenumber(final String street, final String housenumber) {
		final int timeout = 10;
		getContext().setWaitTimeout(timeout);
		final WebElement elm = getContext().findFormElement(By.id("houseNumber"));
		if (elm != null) {
			getContext().fillFormElementWithoutTestingID("address", street);
			getContext().fillFormElementWithoutTestingID("houseNumber", housenumber);
		}
		else {
			getContext().fillFormElementWithoutTestingID("address", street + housenumber);
		}
	}

	/**
	 * Enter the values zipcode, housenumber and housenumber2 into checkout billing and delivery address forms of netherland with
	 * trillium logic.
	 * 
	 * @param zipcode The zipcode for netherland.
	 * @param housenumber The housenumber which has to be depend on zipcode for matching and getting as result a valid street
	 *            entry.
	 * @param housenumber2 The second housenumber for enter somthing to activate trillium.
	 * @param addresstype The address-type (= {@link ContentElement} key).
	 */
	@When(value = "I fill out trillium form fields of the $paymentaddress with $zipcode, $housenumber and $housenumber2", priority = 4)
	public void setZipCodeAndHousenumberForNL(final ContentElement addresstype, final String zipcode, final String housenumber,
			final String housenumber2) {

		getContext().fillFormElement(addresstype.getIdentifierFor("zipcode"), zipcode);
		getContext().fillFormElement(addresstype.getIdentifierFor("housenumber"), housenumber);
		// Wait for NL trillium logic!
		getContext().waitUntilTimeout(MAX_TIMEOUT_5_SECONDS);
		getContext().fillFormElement(addresstype.getIdentifierFor("housenumber2"), housenumber2);
	}
}
