package steps.itelli.webtestsItelli.src.main.java.itelli.webtests.steps.customer.itelli.d2c.checks;

import steps.itelli.webtestsItelli.src.main.java.itelli.webtests.pages.base.ContextBase;
import steps.itelli.webtestsItelli.src.main.java.itelli.webtests.steps.AbstractSteps;

/**
 * DSL which is provided the checks for form field content for BSH.
 */
public class FormContentSteps extends AbstractSteps<ContextBase> {

	/**
	 * Checks if the form fields are correct filled.<br />
	 * TODO: This should be separate checks!
	 * 
	 * @param addresstype The address-type (= {@link ContentElement} key).
	 * @param firstname The expected value of firstname.
	 * @param lastname The expected value of lastname.
	 * @param street The expected value of street.
	 * @param housenumber The expected value of housenumber.
	 * @param zipcode The expected value of zip.
	 * @param city The expected value of city.
	 * @param phone The expected value of phone.
	 * @param cellphone The expected value of cellphone.
	 */
	@Then(value = "the form fields of the $addresstype are filled correctly with "
			+ "$firstname, $lastname, $street, $housenumber, $zipcode, $city, $phone and $cellphone", priority = 1)
	public final void checkAllFilledParameters(final ContentElement addresstype, final String firstname, final String lastname,
			final String street, final String housenumber, final String zipcode, final String city, final String phone,
			final String cellphone) {

		final AddressData.Builder addressBuilder = new AddressData.Builder().setFirstname(firstname).setLastName(lastname)
				.setStreetName(street).setStreetnumber(housenumber).setPostalcode(zipcode).setTown(city).setPhone1(phone)
				.setCellPhone(cellphone);

		checkFormFields(addresstype, addressBuilder.build());
	}

	/**
	 * Checks if the form fields are correct filled.<br />
	 * TODO: This should be separate checks!
	 * 
	 * @param addresstype The address-type (= {@link ContentElement} key).
	 * @param firstname The expected value of firstname.
	 * @param lastname The expected value of lastname.
	 * @param street The expected value of street.
	 * @param housenumber The expected value of housenumber.
	 * @param statevalue The expected value of state.
	 * @param zipcode The expected value of zip.
	 * @param city The expected value of city.
	 * @param phone The expected value of phone.
	 */
	@Then(value = "the form fields for us of the $addresstype are filled correctly with "
			+ "$firstname, $lastname, $street, $housenumber, $statevalue, $zipcode, $city and $phone")
	public final void checkAllFilledParamsForUs(final ContentElement addresstype, final String firstname, final String lastname,
			final String street, final String housenumber, final String statevalue, final String zipcode, final String city,
			final String phone) {
		final AddressData.Builder addressBuilder = new AddressData.Builder().setFirstname(firstname).setLastName(lastname)
				.setStreetName(street).setStreetnumber(housenumber).setRegion(statevalue).setPostalcode(zipcode).setTown(city)
				.setPhone1(phone);

		this.checkFormFields(addresstype, addressBuilder.build());
	}

	private void checkFormFields(final ContentElement addressType, final AddressData addressData) {
		final WebElement elmFirst = getContext().findFormElement(By.id(addressType.getIdentifierFor("firstname")));
		if (elmFirst != null) {
			Assert.assertEquals("Firstname is not correct filled in form field.", addressData.getFirstname(), getContext()
					.getContextBasedInformations().getFormElementValueByIdOrByName(addressType.getIdentifierFor("firstname")));
		}

		final WebElement elmLast = getContext().findFormElement(By.id(addressType.getIdentifierFor("lastname")));
		if (elmLast != null) {
			Assert.assertEquals("Lastname is not correct filled in form field.", addressData.getLastName(), getContext()
					.getContextBasedInformations().getFormElementValueByIdOrByName(addressType.getIdentifierFor("lastname")));
		}

		WebElement elmHouseNumb = getContext().findFormElement(By.id(addressType.getIdentifierFor("housenumber")));
		if (elmHouseNumb == null) {
			elmHouseNumb = getContext().findFormElement(By.name(addressType.getIdentifierFor("housenumber")));
		}
		if (elmHouseNumb != null) {
			Assert.assertEquals("Street is not correct filled in form field.", addressData.getStreetName(), getContext()
					.getContextBasedInformations().getFormElementValueByIdOrByName(addressType.getIdentifierFor("street")));
			Assert.assertEquals("Housenumber is not correct filled in form field.", addressData.getStreetnumber(), getContext()
					.getContextBasedInformations().getFormElementValueByIdOrByName(addressType.getIdentifierFor("housenumber")));
		}
		else {
			Assert.assertEquals(
					"Street and housenumber is not correct filled in form field.",
					addressData.getStreetName() + addressData.getStreetnumber(),
					getContext().getContextBasedInformations().getFormElementValueByIdOrByName(
							addressType.getIdentifierFor("street")));
		}

		final WebElement elmState = getContext().findFormElement(By.id("billingAddressregionDropDown"));
		if (elmState != null) {
			Assert.assertEquals("State is not correct filled in form field.", addressData.getRegion(), getContext()
					.getContextBasedInformations().getFormElementValueByIdOrByName("billingAddressregionDropDown"));
		}

		final WebElement elmZip = getContext().findFormElement(By.id(addressType.getIdentifierFor("zipcode")));
		if (elmZip != null) {
			Assert.assertEquals("Zipcode is not correct filled in form field.", addressData.getPostalcode(), getContext()
					.getContextBasedInformations().getFormElementValueByIdOrByName(addressType.getIdentifierFor("zipcode")));
		}

		final WebElement elmCity = getContext().findFormElement(By.id(addressType.getIdentifierFor("city")));
		if (elmCity != null) {
			Assert.assertEquals("City is not correct filled in form field.", addressData.getTown(), getContext()
					.getContextBasedInformations().getFormElementValueByIdOrByName(addressType.getIdentifierFor("city")));
		}

		final WebElement elmPhone = getContext().findFormElement(By.id(addressType.getIdentifierFor("phone")));
		if (elmPhone != null) {
			Assert.assertEquals("Phone is not correct filled in form field.", addressData.getPhone1(), getContext()
					.getContextBasedInformations().getFormElementValueByIdOrByName(addressType.getIdentifierFor("phone")));
		}

		final WebElement elmCell = getContext().findFormElement(By.id(addressType.getIdentifierFor("cellphone")));
		if (elmCell != null) {
			Assert.assertEquals("Cellphone is not correct filled in form field.", addressData.getCellPhone(), getContext()
					.getContextBasedInformations().getFormElementValueByIdOrByName(addressType.getIdentifierFor("cellphone")));
		}
	}
}
