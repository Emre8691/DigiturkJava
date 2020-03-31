package steps.itelli.webtestsItelli.src.main.java.itelli.webtests.pages.base;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import itelli.webtests.pages.common.ContextInformation;
import itelli.webtests.pages.common.ContextInformationProvider;

/**
 * Class to handle authentification for selenium.
 */
public class SystemHelper {

	private static final Logger LOG = Logger.getLogger(SystemHelper.class);

	private ContextInformationProvider contextInformationProvider;
	private ContextBase contextBase;

	/**
	 * Wait till shop is running.<br>
	 * (check shop is running before starting of any story).<br>
	 * 
	 * @return isRunning The check result if system is running
	 */
	public final boolean waitTillTestedSystemIsRunning() {
		final String testUrl = getTestUrlForRunningSystem();
		final String testContent = getTestContentForRunningSystem();
		final int testTimeout = getTestTimeoutForRunningSystem();

		return waitTillTestedSystemIsRunning(testUrl, testContent, testTimeout);
	}

	/**
	 * Wait till shop is running.<br>
	 * (check shop is running before starting of any story).<br>
	 * 
	 * @param testUrl The url for testing
	 * @param testContent The (partly) content (plain text) of the page shown by the url
	 * @param testTimeout The timeout waiting before starting url check
	 * @return isRunning The check result if system is running
	 */
	public final boolean waitTillTestedSystemIsRunning(final String testUrl, final String testContent, final int testTimeout) {
		final int retryCount = 10;
		final int waitBeforeNextTry = 12;
		boolean isRunning = false;

		if (testTimeout > 0) {
			contextBase.waitUntilTimeout(testTimeout); // wait before testing via url is system is running
		}

		if (StringUtils.isEmpty(testUrl)) {
			isRunning = true; // no check, assume system is running
		} else {
			for (int i = 0; i < retryCount; i++) {
				if (checkTestedSystemIsRunning(testUrl, testContent)) {
					isRunning = true;
					break;
				}
				contextBase.waitUntilTimeout(waitBeforeNextTry); // wait before next retry
				SystemHelper.LOG.trace("Wait till system is running, retry=" + retryCount);
			}
		}

		if (isRunning) {
			SystemHelper.LOG.warn("System is running and ready for testing stories");
		} else {
			SystemHelper.LOG.error("System is not running, start of testing stories failed");
		}
		return isRunning;
	}

	/**
	 * Check immediately if system is running (no wait, using configured parameters).<br>
	 * 
	 * @return isRunning The check result if system is running
	 */
	public final boolean checkTestedSystemIsRunning() {
		final String testUrl = getTestUrlForRunningSystem();
		final String testContent = getTestContentForRunningSystem();

		if (StringUtils.isEmpty(testUrl)) {
			return true; // no check, assume system is running
		}
		return checkTestedSystemIsRunning(testUrl, testContent);
	}

	/**
	 * Check immediately if system is running (no wait).<br>
	 * 
	 * @param testUrl The url for testing
	 * @param testContent The (partly) content (plain text) of the page shown by the url
	 * @return isRunning The check result if system is running
	 */
	public final boolean checkTestedSystemIsRunning(final String testUrl, final String testContent) {
		final int waitTimeout = 10;
		boolean isRunning = false;

		try {
			contextBase.open(testUrl);

			// wait to get page source
			contextBase.setWaitTimeout(waitTimeout);

			isRunning = checkPageContains(testContent);
		} catch (final Exception e) {
			SystemHelper.LOG.warn("System is not yet running");
		}
		return isRunning;
	}

	/**
	 * Check the currently shown pages contains (partly) the content (plain text).<br>
	 * 
	 * @param content The (partly) content (plain text) of the page shown by the url
	 * @return isAvailable The check result if page source contains (partly) the content
	 */
	public final boolean checkPageContains(final String content) {
		boolean isAvailable = false;

		try {
			final String pageSource = contextBase.getPageSource();
			if (StringUtils.contains(pageSource, content)) {
				isAvailable = true;
			}
		} catch (final Exception e) {
			SystemHelper.LOG.warn("Page source doesn't contain expected text");
		}
		return isAvailable;
	}

	/**
	 * Gets the wait timeout to check system is running as String.
	 * 
	 * @return the timeoutToCheckSystemIsRunning as integer
	 */
	public final int getTestTimeoutForRunningSystem() {
		final String timeoutForRunningSystem = getContextInformation()
				.getPropertyFromMetaMap("timeoutToCheckSystemIsRunning");

		int timeout = 0;
		if (StringUtils.isEmpty(timeoutForRunningSystem)) {
			return timeout;
		}
		try {
			timeout = Integer.parseInt(timeoutForRunningSystem);
		} catch (final NumberFormatException ne) {
			SystemHelper.LOG.error("Wrong value for setting timeoutToCheckSystemIsRunning", ne);
		}
		return timeout;
	}

	/**
	 * Gets the url to check system is running.
	 * 
	 * @return the urlToCheckSystemIsRunning
	 */
	public final String getTestUrlForRunningSystem() {
		return getContextInformation().getPropertyFromMetaMap("urlToCheckSystemIsRunning");
	}

	/**
	 * Gets the content (partly) of the page to check system is running.
	 * 
	 * @return the contentToCheckSystemIsRunning
	 */
	public final String getTestContentForRunningSystem() {
		return getContextInformation().getPropertyFromMetaMap("contentToCheckSystemIsRunning");
	}

	public void setContextBase(final ContextBase contextBase) {
		this.contextBase = contextBase;
	}
	
	public ContextInformation getContextInformation() {
		return getContextInformationProvider().getContextInformation();
	}
	public void setContextInformationProvider(ContextInformationProvider contextInformationProvider) {
		this.contextInformationProvider = contextInformationProvider;
	}

	public ContextInformationProvider getContextInformationProvider() {
		return contextInformationProvider;
	}

}
