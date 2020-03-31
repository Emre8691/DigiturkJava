package itelli.webtests.steps.web.system;

import org.apache.log4j.Logger;
import org.jbehave.core.annotations.Then;

import itelli.webtests.pages.base.ContextBase;
import itelli.webtests.steps.AbstractSteps;

/**
 * DSL which is common for the system.
 */
public class SystemWebSteps extends AbstractSteps<ContextBase> {

	private static final Logger LOG = Logger.getLogger(SystemWebSteps.class);

	/**
	 * Wait the given timeout if switch runwitoutwaits in global.properties not true.<br>
	 * 
	 * @param time The wait time in seconds to wait.
	 */
	@Then("wait $time {second|seconds}")
	public void waitUntilTimeout(final long time) {
		if (getContext().ignoreWaitCondition()) {
			return;
		}
		LOG.info(String.format("The system will wait for %s second(s)", Long.valueOf(time)));
		getContext().waitUntilTimeout(time);
	}

	/**
	 * Wait the given timeout.<br>
	 * 
	 * @param time The wait time in seconds to wait.
	 */
	@Then("I must wait $time {second|seconds}")
	public void mustWaitUntilTimeout(final long time) {
 		LOG.info(String.format("The system will wait for %s second(s)", Long.valueOf(time)));
		getContext().waitUntilTimeout(time);
	}
}
