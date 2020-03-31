package steps.itelli.webtestsItelli.src.main.java.itelli.webtests.steps.customer.itelli.d2c.checks;

import steps.itelli.webtestsItelli.src.main.java.itelli.webtests.pages.base.ContextBase;
import steps.itelli.webtestsItelli.src.main.java.itelli.webtests.steps.AbstractSteps;

/**
 * DSL which handles text or content of BSH Context.
 */
public class ContentSteps extends AbstractSteps<ContextBase> {

	/**
	 * Checks if the address type given by DSL has the same informations in frontend shown as expected.<br>
	 * <strong>Only use for Siemens formated address types!</strong>
	 * 
	 * @param address The expected address as type
	 * @param addressID The addressID (testingID) given from DSL
	 */
	@Then("the $address for $addressID is the expected address")
	public void checkAddressTypeContent(final String address, final String addressID) {
		final String shownAddress = getContext().getContextBasedInformations().getTextFromElementByAttributeId(addressID);
		final String trimedAddress = shownAddress.replaceAll("\n", " ");

		Assert.assertEquals("Shown address '" + trimedAddress + " is not the expected '" + address + "'!", trimedAddress, address);
	}
}
