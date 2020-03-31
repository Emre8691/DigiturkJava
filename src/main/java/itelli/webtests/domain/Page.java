package itelli.webtests.domain;

/**
 * Domain Class {@link Page}.
 * 
 * @author erwin.graf (created), 08.03.2013
 * @author $Author$ (last changed)
 * @version $Rev$, $Date$ $Id: $
 */
public class Page {

	private String identifier;
	private String googleid;

	/**
	 * Gets the identifier of page.
	 * 
	 * @return the identifier
	 */
	public final String getIdentifier() {
		return identifier;
	}

	/**
	 * Sets the identifier of page.
	 * 
	 * @param identifier the identifier to set
	 */
	public final void setIdentifier(final String identifier) {
		this.identifier = identifier;
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
		final Page other = (Page) obj;
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

	public String getGoogleid() {
		return googleid;
	}

	public void setGoogleid(String googleid) {
		this.googleid = googleid;
	}
}