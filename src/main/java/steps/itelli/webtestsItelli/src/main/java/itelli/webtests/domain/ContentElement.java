package steps.itelli.webtestsItelli.src.main.java.itelli.webtests.domain;

import java.util.Locale;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
 * Domain Class {@link ContentElement}.
 * 
 * @author erwin.graf (created), 08.03.2013
 * @author $Author$ (last changed)
 * @version $Rev$, $Date$ $Id: $
 */
public class ContentElement {

	private String identifier;
	private String type;
	private Map<String, String> identifiers;

	/**
	 * Gets the identifier of the web element from the identifiers map.
	 * 
	 * @param key the property name containing in the map identifiers
	 * @return the identifier from the identifiers map
	 */
	public final String getIdentifierFor(final String key) {
		return StringUtils.defaultString(identifiers.get(key.toLowerCase(Locale.US)));
	}

	/**
	 * Gets the identifiers of the web element.
	 * 
	 * @return the identifiers
	 */
	public final Map<String, String> getIdentifiers() {
		return identifiers;
	}

	/**
	 * Sets the identifiers of the web element.
	 * 
	 * @param identifiers the identifiers to set
	 */
	public final void setIdentifiers(final Map<String, String> identifiers) {
		this.identifiers = identifiers;
	}

	/**
	 * Gets the identifier of the web element.
	 * 
	 * @return the identifier
	 */
	public final String getIdentifier() {
		return identifier;
	}

	/**
	 * Sets the identifier of the web element.
	 * 
	 * @param identifier the identifier to set
	 */
	public final void setIdentifier(final String identifier) {
		this.identifier = identifier;
	}

	/**
	 * Gets the type of the web element.
	 * 
	 * @return the type
	 */
	public final String getType() {
		return type;
	}

	/**
	 * Sets the type of the web element.
	 * 
	 * @param type the type to set
	 */
	public final void setType(final String type) {
		this.type = type;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identifier == null) ? 0 : identifier.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final ContentElement other = (ContentElement) obj;
		if (identifier == null) {
			if (other.identifier != null) {
				return false;
			}
		}
		else if (!identifier.equals(other.identifier)) {
			return false;
		}
		return true;
	}
}
