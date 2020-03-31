package steps.itelli.webtestsItelli.src.main.java.itelli.webtests.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Platform;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.InitializingBean;

/**
 * The one and only configuration of the web tests application.
 * 
 * @author stefan.person (created), 21.12.2012
 */
public class WebTestsConfiguration implements InitializingBean {

	private static final Logger LOG = Logger.getLogger(WebTestsConfiguration.class);

	private String seleniumWebDriverType;
	private String seleniumURL;
	private String seleniumBrowser;
	private String seleniumPlatform;
	private String seleniumBrowserPath;
	private String seleniumBrowserVersion;
	private String jBehaveStoryPathPrefix;
	private String jBehaveStoryPathPattern;
	private String jBehaveMetaFilter;
	private String testedSystem;

	private int jbehaveThreadCount;
	private String downloadVideo;

	public String getDownloadVideo() {
		return downloadVideo;
	}

	public void setDownloadVideo(String downloadVideo) {
		this.downloadVideo = downloadVideo;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	@Override
	public void afterPropertiesSet() {
		WebTestsConfiguration.LOG.info("Using the following configuration:");
		WebTestsConfiguration.LOG.info(" - Selenium webDriver type: '" + getSeleniumWebDriverType() + "'");
		WebTestsConfiguration.LOG.info(" - Selenium URL: '" + getSeleniumURL() + "'");
		WebTestsConfiguration.LOG.info(" - Selenium Browser: '" + getSeleniumBrowser() + "'");
		WebTestsConfiguration.LOG.info(" - Selenium PLatform: '" + getSeleniumPlatform() + "'");
		WebTestsConfiguration.LOG.info(" - Selenium Browser Path: '" + getSeleniumBrowserPath() + "'");
		WebTestsConfiguration.LOG.info(" - Selenium Browser Version: '" + getSeleniumBrowserVersion() + "'");
		WebTestsConfiguration.LOG.info(" - JBehave Story Path Prefix: '" + getjBehaveStoryPathPrefix() + "'");
		WebTestsConfiguration.LOG.info(" - JBehave Story Path Pattern: '" + getjBehaveStoryPathPattern() + "'");
		WebTestsConfiguration.LOG.info(" - JBehave Meta Filter: '" + getjBehaveMetaFilter() + "'");
		WebTestsConfiguration.LOG.info(" - Tested System: '" + getTestedSystem() + "'");
		WebTestsConfiguration.LOG.info(" - Thread Count: '" + getJbehaveThreadCount() + "'");
	}

	/**
	 * Gets the meta filter as seperated list.<br>
	 * E.g. a configuration of +x, -y, +z will be a list of {"+x", "-y", "+z"}.<br>
	 * Created by: stefan.person
	 * 
	 * @return The configured meta filters as list splitted by comma.
	 */
	public List<String> getJBehaveMetaFilterAsList() {
		List<String> list = Collections.emptyList();
		final String value = getjBehaveMetaFilter();
		if (value != null) {
			final List<String> tmpList = Arrays.asList(StringUtils.split(value, ','));
			list = new ArrayList<String>(tmpList.size());
			for (int i = 0; i < tmpList.size(); ++i) {
				list.add(tmpList.get(i).trim());
			}
		}
		return list;
	}

	public final String getSeleniumWebDriverType() {
		return seleniumWebDriverType;
	}

	public final void setSeleniumWebDriverType(final String seleniumWebDriverType) {
		this.seleniumWebDriverType = seleniumWebDriverType;
	}

	public final String getSeleniumURL() {
		return seleniumURL;
	}

	public final void setSeleniumURL(final String seleniumURL) {
		this.seleniumURL = seleniumURL;
	}

	public final String getSeleniumBrowser() {
		return seleniumBrowser;
	}

	public final void setSeleniumBrowser(final String seleniumBrowser) {
		this.seleniumBrowser = seleniumBrowser;
	}
	
	public final String getSeleniumPlatform() {
		return seleniumPlatform;
	}
	
	public final void setSeleniumPlatform (final String seleniumPlatform) {
		this.seleniumPlatform = seleniumPlatform;
	}

	public final String getSeleniumBrowserPath() {
		return seleniumBrowserPath;
	}

	public final void setSeleniumBrowserPath(final String seleniumBrowserPath) {
		this.seleniumBrowserPath = seleniumBrowserPath;
	}

	public final String getSeleniumBrowserVersion() {
		return seleniumBrowserVersion;
	}

	public final void setSeleniumBrowserVersion(final String seleniumBrowserVersion) {
		this.seleniumBrowserVersion = seleniumBrowserVersion;
	}


	/**
	 * Get the story path prefix
	 * 
	 * @return the story path prefix
	 */
	public final String getjBehaveStoryPathPrefix() {
		return jBehaveStoryPathPrefix;
	}

	/**
	 * Set the story path prefix
	 * 
	 * @param jBehaveStoryPathPrefix the story path prefix
	 */
	public final void setjBehaveStoryPathPrefix(final String jBehaveStoryPathPrefix) {
		this.jBehaveStoryPathPrefix = jBehaveStoryPathPrefix;
	}

	/**
	 * Get the story path pattern
	 * 
	 * @return the story path pattern
	 */
	public final String getjBehaveStoryPathPattern() {
		return jBehaveStoryPathPattern;
	}

	/**
	 * Set the story path pattern
	 * 
	 * @param jBehaveStoryPathPattern the story path pattern
	 */
	public final void setjBehaveStoryPathPattern(final String jBehaveStoryPathPattern) {
		this.jBehaveStoryPathPattern = jBehaveStoryPathPattern;
	}

	/**
	 * Get the meta filter
	 * 
	 * @return the meta filter
	 */
	public final String getjBehaveMetaFilter() {
		return jBehaveMetaFilter;
	}

	/**
	 * Set the meta filter
	 * 
	 * @param jBehaveMetaFilter the meta filter
	 */
	public final void setjBehaveMetaFilter(final String jBehaveMetaFilter) {
		this.jBehaveMetaFilter = jBehaveMetaFilter;
	}

	public final String getTestedSystem() {
		return testedSystem;
	}

	public final void setTestedSystem(final String testedSystem) {
		this.testedSystem = testedSystem;
	}

	public int getJbehaveThreadCount() {
		return jbehaveThreadCount;
		
	}
	public void setJbehaveThreadCount(int jbehaveThreadCount) {
		this.jbehaveThreadCount = jbehaveThreadCount;
	}
}
