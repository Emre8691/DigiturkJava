package itelli.webtests.steps.customer.itelli.system;

import org.apache.log4j.Logger;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

import itelli.webtests.pages.base.ContextBase;
import itelli.webtests.steps.AbstractSteps;

/**
 * Implements the template switch logic for Bosch and Siemens websites for new layout 2013.
 */
public class LayoutSwitchSteps extends AbstractSteps<ContextBase> {

	private static final Logger LOG = Logger.getLogger(LayoutSwitchSteps.class);

	/**
	 * Switch to new layout.
	 */
	@When("I switch to new layout")
	public final void switchToNewLayout() {
		final String startUrl = getContext().getContextInformation().getPropertyFromMetaMap("starturl");
		String brand = getContext().getContextInformation().getBrand().getDisplay();
		Assert.assertNotNull("starturl not found", startUrl);

		getContext().open(startUrl + "template?choose=new");
		LOG.info("The template is switched to new at url: '" + startUrl + "'");
	}

	/**
	 * Switch to old layout.
	 */
	@When("I switch to old layout")
	public final void switchToOldLayout() {
		final String startUrl = getContext().getContextInformation().getPropertyFromMetaMap("starturl");

		getContext().open(startUrl + "template?choose=old");
		LOG.info("The template is switched to old at url: '" + startUrl + "'");
	}

	/**
	 * Checks if the new layout is active.
	 */
	@Then("the switch to new layout was successful")
	public void checkSwitchToNewLayoutIsSupported() {
		final boolean isUnderMaintenance = getSystem().checkPageContains("Under Maintenance");
		Assert.assertFalse("Site under maintenance", isUnderMaintenance);

		final boolean isSupported = getSystem().checkPageContains("switch to old template");
		Assert.assertTrue("Switch to new layout is not supported (content 'switch to old template' is not shown)", isSupported);
	}

	/**
	 * Checks if the old layout is active.
	 */
	@Then("the switch to old layout was not successful")
	public void checkSwitchToOldLayoutIsSupported() {
		final boolean isSupported = getSystem().checkPageContains("switch to new template");

		Assert.assertTrue("Switch to old layout is not supported (content 'switch to new template' is not shown)", isSupported);
	}
}
