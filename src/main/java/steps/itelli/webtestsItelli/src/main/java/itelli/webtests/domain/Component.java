package steps.itelli.webtestsItelli.src.main.java.itelli.webtests.domain;

/**
 * Domain Class {@link Component}.
 * 
 * @author erwin.graf (created), 08.03.2013
 * @author $Author$ (last changed)
 * @version $Rev$, $Date$ $Id: $
 */
public class Component {

	private String name;
	private String code;

	/**
	 * Gets the name of the component.
	 * 
	 * @return the name
	 */
	public final String getName() {
		return name;
	}

	/**
	 * Sets the name of the component.
	 * 
	 * @param name the name to set
	 */
	public final void setName(final String name) {
		this.name = name;
	}

	/**
	 * Gets the code identifier of the component.
	 * 
	 * @return the code
	 */
	public final String getCode() {
		return code;
	}

	/**
	 * Sets the code identifier of the component.
	 * 
	 * @param code the code to set
	 */
	public final void setCode(final String code) {
		this.code = code;
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
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		final Component other = (Component) obj;
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		}
		else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}
}
