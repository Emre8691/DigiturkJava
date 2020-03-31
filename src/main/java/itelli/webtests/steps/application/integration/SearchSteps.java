package itelli.webtests.steps.application.integration;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebElement;

import itelli.webtests.pages.base.ContextBase;
import itelli.webtests.steps.AbstractSteps;

/**
 * DSL for Common Application Layer Topics
 */
public class SearchSteps extends AbstractSteps<ContextBase> {

	private static final Logger LOG = Logger.getLogger(SearchSteps.class);

	/**
	 * Get a search box and enter a value for click to it.
	 * 
	 * @param value The parameter for search.
	 * @param searchbox The seach field (form).
	 * @param searchbutton The button of the search field.
	 */
	@When("I search $value at $searchbox and click $searchbutton")
	public void searchValue(@Named(value = "value") final String value, @Named(value = "searchbox") final String searchbox,
			@Named(value = "serachbutton") final String searchbutton) {
		final WebElement field = getContext().getElementFinder().findBy(searchbox);
		final WebElement button = getContext().getElementFinder().findBy(searchbutton);

		Assert.assertNotNull(String.format("Field %s not found", field), field);
		Assert.assertNotNull(String.format("Field %s not found", button), button);
		LOG.info("Elements needed for 'search' are existing");

		getContext().fillForm(searchbox, value);
		getContext().getContextBasedActions().clickByGivenAttribute(searchbutton);
	}
}
