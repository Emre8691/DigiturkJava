package itelli.webtests.pages.common;

import java.util.HashMap;
import java.util.Map;

import org.jbehave.core.reporters.StoryReporter;

import itelli.webtests.domain.Brand;
import itelli.webtests.domain.Country;
import itelli.webtests.domain.Language;
import itelli.webtests.domain.SiteType;

/**
 * POJO class holding the context information of the current Scenario.
 * 
 * @author stefan.person (created), 21.12.2012
 */

public class ContextInformation {

	private Brand brand;
	private Country country;
	private Language language;
	private SiteType siteType;
	private Map<String, String> metaMap;
	private ThreadLocal<StoryReporter> reporterData;
	private String storyName;
	private Boolean isSAP;
	
	public Boolean getIsSAP() {
		return isSAP;
	}

	public void setIsSAP(Boolean isSAP) {
		this.isSAP = isSAP;
	}

	/**
	 * Gets a property from meta map of the scenario.
	 * 
	 * @param property The property name.
	 * @return the property value or null
	 */
	public final String getPropertyFromMetaMap(final String property) {
		if (metaMap != null) {
			return metaMap.get(property);
		}
		return null;
	}

	/**
	 * Sets a property to meta map of the scenario.
	 * 
	 * @param property The property name.
	 * @param value The property value.
	 */
	public final void setPropertyToMetaMap(final String property, final String value) {
		if (metaMap == null) {
			metaMap = new HashMap<String, String>();
		}
		metaMap.put(property, value);
	}

	/**
	 * Remove properties from meta map of the scenario.
	 * 
	 * @param property The property name.
	 */
	public final void removePropertyFromMetaMap(final String property) {
		if (metaMap != null) {
			metaMap.remove(property);
		}
	}

	public final Brand getBrand() {
		return brand;
	}

	public final void setBrand(final Brand brand) {
		this.brand = brand;
	}

	public final Country getCountry() {
		return country;
	}

	public final void setCountry(final Country country) {
		this.country = country;
	}

	public final Language getLanguage() {
		return language;
	}

	public final void setLanguage(final Language language) {
		this.language = language;
	}

	public final SiteType getSiteType() {
		return siteType;
	}

	public final void setSiteType(final SiteType siteType) {
		this.siteType = siteType;
	}

	public final Map<String, String> getMetaMap() {
		return metaMap;
	}

	public final void setMetaMap(final Map<String, String> metaMapData) {
		this.metaMap = metaMapData;
	}

	public ThreadLocal<StoryReporter> getReporterData() {
		return reporterData;
	}

	public void setReporterData(final ThreadLocal<StoryReporter> reporterData) {
		this.reporterData = reporterData;
	}

	public String getStoryName() {
		return storyName;
	}

	public void setStoryName(String storyName) {
		this.storyName = storyName;
	}

}
