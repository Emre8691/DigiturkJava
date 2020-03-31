package itelli.webtests.steps.customer.itelli.system;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.junit.Assert;

import itelli.webtests.pages.base.ContextBase;
import itelli.webtests.steps.AbstractSteps;

/**
 * Class contains all relevant methods for the system. Definition for DSL with context system.
 */
public class SystemSteps extends AbstractSteps<ContextBase> {

	/**
	 * Setup the system is ready for testing.<br>
	 */
	@Given("is the running tested system")
	public void setupSystemIsRunning() {
		getContext().setupDefaultParametersForScenario();
		getSystem().checkTestedSystemIsRunning();
	}

	/**
	 * Checks the system is ready for testing.<br>
	 */
	@Then("the tested system is running")
	public void checkSystemIsReady() {
		final boolean isRunning = getSystem().checkTestedSystemIsRunning();
		Assert.assertTrue(
				"The system to test is not running or ready! Tested url: "
						+ getContext().getContextInformation().getPropertyFromMetaMap("urlToCheckSystemIsRunning")
						+ ", expected content: '"
						+ getContext().getContextInformation().getPropertyFromMetaMap("contentToCheckSystemIsRunning") + "'",
				isRunning);
	}

}
