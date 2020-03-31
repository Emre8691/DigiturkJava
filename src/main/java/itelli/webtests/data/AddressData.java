package itelli.webtests.data;

import org.apache.commons.lang3.ObjectUtils;

/**
 * Data object which represents an address.
 */
public class AddressData implements Cloneable {

	protected String firstname;
	protected String lastName;
	protected String email;
	protected String emailReenterred;
	protected String streetName;
	protected String streetnumber;
	protected String region;
	protected String postalcode;
	protected String town;
	protected String phone1;
	protected String cellPhone;

	protected AddressData() {
		// Should only be called by AddressDataBuilder.
	}

	@Override
	public AddressData clone() throws CloneNotSupportedException {
		return (AddressData) super.clone();
	}

	public final String getFirstname() {
		return firstname;
	}

	public final String getLastName() {
		return lastName;
	}

	public final String getEmail() {
		return email;
	}

	public final String getEmailReenterred() {
		return emailReenterred;
	}

	public final String getStreetName() {
		return streetName;
	}

	public final String getStreetnumber() {
		return streetnumber;
	}

	public final String getRegion() {
		return region;
	}

	public final String getPostalcode() {
		return postalcode;
	}

	public final String getTown() {
		return town;
	}

	public final String getPhone1() {
		return phone1;
	}

	public final String getCellPhone() {
		return cellPhone;
	}

	/**
	 * Builder for the {@link AddressData}.
	 */
	public static final class Builder {

		private final AddressData addressData = new AddressData();

		/**
		 * Returns the built {@link AddressData} instance.
		 * 
		 * @return The built {@link AddressData} instance.
		 */
		public AddressData build() {
			return ObjectUtils.clone(addressData);
		}

		/**
		 * Sets the {@link AddressData}'s firstname.
		 * 
		 * @param firstname The value to set.
		 * @return The {@link Builder}.
		 */
		public Builder setFirstname(final String firstname) {
			addressData.firstname = firstname;
			return this;
		}

		/**
		 * Sets the {@link AddressData}'s lastName.
		 * 
		 * @param lastName The value to set.
		 * @return The {@link Builder}.
		 */
		public Builder setLastName(final String lastName) {
			addressData.lastName = lastName;
			return this;
		}

		/**
		 * Sets the {@link AddressData}'s email.
		 * 
		 * @param email The value to set.
		 * @return The {@link Builder}.
		 */
		public Builder setEmail(final String email) {
			addressData.email = email;
			return this;
		}

		/**
		 * Sets the {@link AddressData}'s emailReenterred.
		 * 
		 * @param emailReenterred The value to set.
		 * @return The {@link Builder}.
		 */
		public Builder setEmailReenterred(final String emailReenterred) {
			addressData.emailReenterred = emailReenterred;
			return this;
		}

		/**
		 * Sets the {@link AddressData}'s streetName.
		 * 
		 * @param streetName The value to set.
		 * @return The {@link Builder}.
		 */
		public Builder setStreetName(final String streetName) {
			addressData.streetName = streetName;
			return this;
		}

		/**
		 * Sets the {@link AddressData}'s streetnumber.
		 * 
		 * @param streetnumber The value to set.
		 * @return The {@link Builder}.
		 */
		public Builder setStreetnumber(final String streetnumber) {
			addressData.streetnumber = streetnumber;
			return this;
		}

		/**
		 * Sets the {@link AddressData}'s region.
		 * 
		 * @param region The value to set.
		 * @return The {@link Builder}.
		 */
		public Builder setRegion(final String region) {
			addressData.region = region;
			return this;
		}

		/**
		 * Sets the {@link AddressData}'s postalcode.
		 * 
		 * @param postalcode The value to set.
		 * @return The {@link Builder}.
		 */
		public Builder setPostalcode(final String postalcode) {
			addressData.postalcode = postalcode;
			return this;
		}

		/**
		 * Sets the {@link AddressData}'s town.
		 * 
		 * @param town The value to set.
		 * @return The {@link Builder}.
		 */
		public Builder setTown(final String town) {
			addressData.town = town;
			return this;
		}

		/**
		 * Sets the {@link AddressData}'s phone1.
		 * 
		 * @param phone1 The value to set.
		 * @return The {@link Builder}.
		 */
		public Builder setPhone1(final String phone1) {
			addressData.phone1 = phone1;
			return this;
		}

		/**
		 * Sets the {@link AddressData}'s cellPhone.
		 * 
		 * @param cellPhone The value to set.
		 * @return The {@link Builder}.
		 */
		public Builder setCellPhone(final String cellPhone) {
			addressData.cellPhone = cellPhone;
			return this;
		}
	}

}
