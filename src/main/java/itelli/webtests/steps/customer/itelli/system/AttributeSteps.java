package itelli.webtests.steps.customer.itelli.system;

import org.jbehave.core.annotations.Then;
import org.junit.Assert;

import itelli.webtests.domain.Language;
import itelli.webtests.domain.SiteType;
import itelli.webtests.pages.base.ContextBase;
import itelli.webtests.steps.AbstractSteps;

/**
 * DSL which checks values from hybris BSH system.
 */
public class AttributeSteps extends AbstractSteps<ContextBase> {

	/**
	 * Checks if the brand of the current page is the same as the given one.<br>
	 * Then the brand of the page is as given.<br>
	 */
	@Then(value = "the brand of the page is as given", priority = 1)
	public void checkGivenBrand() {
		final String expectedBrand = getContext().getContextInformation().getBrand().getSapcode();
		if (!getContext().getCurrentUrl().contains("fi.muc.bsh.arithnea.org")){
			System.out.println("Production Tests: test_context_pageId is not availeble, ignored!!!" + expectedBrand);
		}
		else {
		Assert.assertEquals("Brand of the current page does not match!", expectedBrand, getContext()
				.getContextBasedInformations().getBrandOfCurrentPage());
	}}

	/**
	 * Checks if the country of the current page is the same as the given one.<br>
	 * Then the country of the page is 'country'.<br>
	 * 
	 * @param country The country to check for.
	 */
	@Then("the country of the page is $country")
	public void checkCountry(final String country) {
		Assert.assertEquals("Country of the current page does not match!", country, getContext().getContextBasedInformations()
				.getCountryOfCurrentPage());
	}

	/**
	 * Checks if the country of the current page is the same as the given one.<br>
	 * Then the country of the page is as given.
	 */
	@Then(value = "the country of the page is as given", priority = 1)
	public void checkGivenCountry() {
		final String expectedCountry = getContext().getContextInformation().getCountry().getIsocode();
		if (!getContext().getCurrentUrl().contains("fi.muc.bsh.arithnea.org")){
			System.out.println("Production Tests: test_context_pageId is not availeble, ignored!!!" + expectedCountry);
		}
		else {
		Assert.assertEquals("Country of the current page does not match!", expectedCountry, getContext()
				.getContextBasedInformations().getCountryOfCurrentPage());
	}}

	/**
	 * Checks the country selection is correct for given brand and country.<br>
	 * Then the country selection is for given brand and given country.<br>
	 */
	@Then("the country selection is for given brand and given country")
	public void checkCountrySelection() {
		final String expectedSelection = getContext().getContextInformation().getBrand().getDisplay() + " "
				+ getContext().getContextInformation().getCountry().getDisplay();
		final String currentSelection = getContext().getContextBasedInformations().getCountrySelection();

		Assert.assertEquals(expectedSelection, currentSelection);
	}

	/**
	 * Checks if the language of the current page is the same as the given one.<br>
	 * Then the language of the page is 'language'.<br>
	 * 
	 * @param language The language to check for.
	 */
	@Then("the language of the page is $language")
	public void checkLanguage(final Language language) {
		Assert.assertEquals("Language of the current page does not match!", language.getDisplay(), getContext()
				.getContextBasedInformations().getLanguageOfCurrentPage());
	}

	/**
	 * Checks if the language of the current page is the same as the given one.<br>
	 * Then the language of the page is as given.<br>
	 */
	@Then(value = "the language of the page is as given", priority = 1)
	public void checkGivenLanguage() {
		final String expectedLanguage = getContext().getContextInformation().getLanguage().getIsocode();
		Assert.assertEquals("Language of the current page does not match!", expectedLanguage, getContext()
				.getContextBasedInformations().getLanguageOfCurrentPage());
	}

	/**
	 * Checks if the siteType of the current page is the same as the given one.<br>
	 * Then the site type of the page is 'siteType'.<br>
	 * 
	 * @param siteType The siteType to check for.
	 */
	@Then("the site type of the page is $siteType")
	public void checkSiteType(final String siteType) {
		Assert.assertEquals("SiteType of the current page does not match!", siteType, getContext().getContextBasedInformations()
				.getSiteTypeOfCurrentPage());
	}

	/**
	 * Checks if the siteType of the current page is the same as the given one.<br>
	 * Then the site type of the page is as given.<br>
	 */
	@Then(value = "the site type of the page is as given", priority = 1)
	public void checkGivenSiteType() {
		final String expectedSiteType = getContext().getContextInformation().getSiteType().getDisplayString();
		if (!getContext().getCurrentUrl().contains("fi.muc.bsh.arithnea.org")){
			System.out.println("Production Tests: test_context_pageId is not availeble, ignored!!!" + expectedSiteType);
		}
		else {
			final String gotSiteType = getContext().getContextBasedInformations().getSiteTypeOfCurrentPage();
			final String gotSiteTypeDisplayString = SiteType.parseSiteType(gotSiteType).getDisplayString();
		Assert.assertTrue("SiteType of the current page does not match: " + expectedSiteType + ", " + "got=" + gotSiteType
				+ ", found=" + gotSiteTypeDisplayString, expectedSiteType.equalsIgnoreCase(gotSiteTypeDisplayString));
	}}
}
