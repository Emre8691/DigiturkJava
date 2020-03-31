package itelli.webtests.domain;

/**
 * Domain Class {@link Language}.
 * 
 * @author bjoern.wedi (created), 25.02.2013
 * @author $Author$ (last changed)
 * @version $Rev$, $Date$ $Id: $
 */
public class Language {

	private String isocode;
	private String display;

	/**
	 * Gets the isocode.
	 * 
	 * @return the isocode
	 */
	public final String getIsocode() {
		return isocode;
	}

	/**
	 * Sets the isocode.
	 * 
	 * @param isocode the isocode to set
	 */
	public final void setIsocode(final String isocode) {
		this.isocode = isocode;
	}

	/**
	 * Gets the display.
	 * 
	 * @return the display
	 */
	public final String getDisplay() {
		return display;
	}

	/**
	 * Sets the display.
	 * 
	 * @param display the display to set
	 */
	public final void setDisplay(final String display) {
		this.display = display;
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
		result = prime * result + ((isocode == null) ? 0 : isocode.hashCode());
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
		final Language other = (Language) obj;
		if (isocode == null) {
			if (other.isocode != null) {
				return false;
			}
		}
		else if (!isocode.equals(other.isocode)) {
			return false;
		}
		return true;
	}
}
