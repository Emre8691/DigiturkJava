package steps.itelli.webtestsItelli.src.main.java.itelli.webtests.domain;

/**
 * Domain Class {Brand}
 * 
 * @author bjoern.wedi (created), 26.02.2013
 * @author $Author$ (last changed)
 * @version $Rev$, $Date$ $Id: $
 */
public class Brand {

	private String sapcode;
	private String display;

	/**
	 * Gets the sapcode.
	 * 
	 * @return the sapcode
	 */
	public final String getSapcode() {
		return sapcode;
	}

	/**
	 * Sets the sapcode.
	 * 
	 * @param sapcode the sapcode to set
	 */
	public final void setSapcode(final String sapcode) {
		this.sapcode = sapcode;
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
		result = prime * result + ((sapcode == null) ? 0 : sapcode.hashCode());
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
		final Brand other = (Brand) obj;
		if (sapcode == null) {
			if (other.sapcode != null) {
				return false;
			}
		}
		else if (!sapcode.equals(other.sapcode)) {
			return false;
		}
		return true;
	}

}
