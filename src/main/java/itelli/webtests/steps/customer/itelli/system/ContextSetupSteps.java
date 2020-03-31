package itelli.webtests.steps.customer.itelli.system;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.jbehave.core.annotations.Aliases;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.openqa.selenium.By;

import itelli.webtests.domain.Brand;
import itelli.webtests.domain.Country;
import itelli.webtests.domain.Language;
import itelli.webtests.domain.SiteType;
import itelli.webtests.pages.base.ContextBase;
import itelli.webtests.steps.AbstractSteps;

import org.junit.Assert;

/**
 * Definition of DSL including all Senteces with annotation "Given".
 */
public class ContextSetupSteps extends AbstractSteps<ContextBase> {

	/**
	 * Sets the given <b>website</b> by given <tt>type</tt>, <tt>brand</tt> and <tt>country</tt>. Given is 'type' website for
	 * brand 'brand' and country 'country'.<br>
	 * 
	 * @param type the type to use.
	 * @param brand the brand to use.
	 * @param country the country to use.
	 */
	@Given(value = "is $type website for brand $brand and country $country", priority = 1)
	public void setupWebsite(@Named("type") final SiteType type, @Named("brand") final Brand brand,
			@Named("country") final Country country) {
		// @formatter:off
		this.applyBrand(brand)
	     	.applyCountry(country)
	    	.applySiteType(type);		
		// @formatter:on
	}

	/**
	 * Sets the given <b>website</b> by given <tt>type</tt>, <tt>brand</tt> and <tt>country</tt> and <tt>language</tt>. Given is
	 * 'type' website for brand 'brand' and country 'country' and language 'language'.<br>
	 * 
	 * @param type the type to use.
	 * @param brand the brand to use.
	 * @param country the country to use.
	 * @param language the language to use.
	 */
	@Given(value = "is $type website for brand $brand and country $country and language $language", priority = 2)
	public void setupWebsite(@Named("type") final SiteType type, @Named("brand") final Brand brand,
			@Named("country") final Country country, @Named("language") final Language language) {
		// @formatter:off
		this.applyBrand(brand)
	     	.applyCountry(country)
	    	.applyLanguage(language)
    		.applySiteType(type);
		// @formatter:on
	}

	@Given(value = "save current basket count", priority = 1)
	public void setupCurrentBasketCount() {
		// @formatter:off
		String currentBasketCount = getContext().getContextBasedInformations().getCartCountOfCurrentPageForBosch();
		getContext().setupCurrentBasketCount(currentBasketCount);
		// @formatter:on
	}

	/**
	 * Setup the parameters information in the current context.<br>
	 * Given are properties from 'properties'.<br>
	 * Given are properties from {file|files} 'properties'.<br>
	 * 
	 * @param properties The properties to be used as property filenames.
	 */
	@Given("are properties from $properties")
	@Aliases(values = { "are properties from {file|files} $properties", "testdata loaded form {file|files} $properties" })
	public void setupParameters(final List<String> properties) {
		Logger.getLogger(getClass()).info("INITIAL PROPS LIST : "+properties);
		Logger.getLogger(getClass()).info("INITIAL PROPS LIST COUNTRY : "+getContext().getContextInformation().getCountry());

		applyProperties(properties);
	}

	/**
	 * Provide the HTTP authentication to the basic and the secure URL if necessary.
	 * 
	 * @throws MalformedURLException May be thrown if an invalid URL is provided in url.properties configuration.
	 */
	@Given("http authentication is provided")
	public void ensureAuthentication() throws MalformedURLException {
		final String shoplinksStatus = getContext().getContextInformation().getPropertyFromMetaMap("shoplinksstatus");
		Assert.assertFalse("Shoplinks Service Unavailable", shoplinksStatus != null && shoplinksStatus.equals("noservice"));
		
		openUrlIfAuthProvided(getContext().getContextInformation().getMetaMap().get("secureurl"));
		openUrlIfAuthProvided(getContext().getContextInformation().getMetaMap().get("starturl"));
	}

	private void openUrlIfAuthProvided(final String urlString) throws MalformedURLException {
		if (StringUtils.isNotEmpty(urlString)) {
			final URL url = new URL(urlString);
			if (StringUtils.isNotBlank(url.getUserInfo())) {
				getContext().open(urlString);
			}
		}
	}
	
	@Given(value = "is SAP test")
	public void setupSAPTest() {
		this.applySAPTest(true);
	}


	/**
	 * Applies the <tt>parameters</tt> to the {@link #contextBase}.
	 * 
	 * @param brand
	 * @return this
	 */
	private ContextSetupSteps applyProperties(final List<String> properties) {
		getContext().setupParametersForScenario(properties);
		return this;
	}

	/**
	 * Applies the <tt>brand</tt> to the {@link #contextBase}.
	 * 
	 * @param brand
	 * @return this
	 */
	private ContextSetupSteps applyBrand(final Brand brand) {
		getContext().setupBrandForScenario(brand);
		return this;
	}

	/**
	 * Applies the <tt>country</tt> to the {@link #contextBase}.
	 * 
	 * @param brand
	 * @return this
	 */
	private ContextSetupSteps applyCountry(final Country country) {
		getContext().setupCountryForScenario(country);
		return this;
	}

	/**
	 * Applies the <tt>language</tt> to the {@link #contextBase}.
	 * 
	 * @param language
	 * @return this
	 */
	private ContextSetupSteps applyLanguage(final Language language) {
		getContext().setupLanguageForScenario(language);
		return this;
	}

	/**
	 * Applies the <tt>type</tt> to the {@link #contextBase}.
	 * 
	 * @param type
	 * @return this
	 */
	private ContextSetupSteps applySiteType(final SiteType type) {
		getContext().setupSiteTypeForScenario(type);
		return this;
	}

	private ContextSetupSteps applySAPTest(final Boolean isSAP) {
		getContext().setupSAPTestForScenario(isSAP);
		return this;
	}

}
