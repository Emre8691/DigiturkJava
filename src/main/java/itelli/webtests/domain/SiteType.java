package itelli.webtests.domain;

/**
 * Enum class for valid site types.
 * 
 * @author stefan.person (created), 21.12.2012
 */

public enum SiteType {

	SHOP("d2c", "b2c"), STAFFSALES("staff", "b2e"), CMS("cms", "cms"), OUTLET("outlet", "outlet"), HMC("HMC", "hmc");

	private final String displayString;
	private final String siteTypeCode;

	/**
	 * Private constructor for ENUM setting the brand as String information.
	 * 
	 * @param siteType The internal site type code of the Enum.
	 */
	private SiteType(final String displayString, final String siteType) {
		this.displayString = displayString;
		this.siteTypeCode = siteType;
	}

	/**
	 * Parse the given <tt>_siteType</tt> and return the matching Enum.<br>
	 * Created by: stefan.person
	 * 
	 * @param _siteType The Site Type code to look for. May not be null!
	 * @return The matching SiteType for the given _siteType. Will return null if no matching Country was found.
	 */
	public static final SiteType parseSiteType(final String _siteType) {
		for (final SiteType siteType : SiteType.values()) {
			if (siteType.siteTypeCode.equalsIgnoreCase(_siteType)) {
				return siteType;
			}
		}
		return null;
	}

	/**
	 * Parse the given <tt>_displayString</tt> and return the matching Enum.<br>
	 * Created by: stefan.person
	 * 
	 * @param _displayString The Site Type code to look for. May not be null!
	 * @return The matching SiteType for the given _displayString. Will return null if no matching SiteType was found.
	 */
	public static final SiteType parseSiteTypeDisplayString(final String _displayString) {
		for (final SiteType siteType : SiteType.values()) {
			if (siteType.displayString.equalsIgnoreCase(_displayString)) {
				return siteType;
			}
		}
		return null;
	}

	/**
	 * Gets the displayString.
	 * 
	 * @return the displayString
	 */
	public final String getDisplayString() {
		return displayString;
	}

	/**
	 * Gets the siteTypeCode.
	 * 
	 * @return the siteTypeCode
	 */
	public final String getSiteTypeCode() {
		return siteTypeCode;
	}
}
