package steps.itelli.webtestsItelli.src.main.java.itelli.webtests.config;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner.dsa224;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.btr.proxy.util.PlatformUtil.Browser;
import org.openqa.selenium.Platform;

import net.lightbody.bmp.BrowserMobProxy;

/**
 * Factory class which can create the {@link DesiredCapabilities} based on the {@link WebTestsConfiguration}.<br>
 * Currently only firefox is used/configured!
 * 
 * @author stefan.person (created), 21.12.2012
 */
public final class DesiredCapabilitiesFactory {

	private static final int FIREFOX_MAX_USERPASS_LENGTH = 255;

	/**
	 * Private constructor to avoid instantiation of this factory class.
	 */
	private DesiredCapabilitiesFactory() {
	}

	/**
	 * The factory method used by Spring to create the {@link org.jbehave.web.selenium.RemoteWebDriverProvider}.<br>
	 * The default is the capabilities of firefox.<br>
	 * Created by: stefan.person
	 * 
	 * @param _config The {@link WebTestsConfiguration} of the application.
	 * @return The fully created {@link DesiredCapabilities}. Will never be null.
	 */
	public static DesiredCapabilities createDesiredCapabilitiesForRemote(final WebTestsConfiguration _config) {
		final DesiredCapabilities desiredCapabilities = DesiredCapabilities.firefox();

		if (StringUtils.isNotBlank(_config.getSeleniumBrowser())) {
			desiredCapabilities.setBrowserName(_config.getSeleniumBrowser());
		}

		if (StringUtils.isNotBlank(_config.getSeleniumBrowserVersion())) {
			desiredCapabilities.setVersion(_config.getSeleniumBrowserVersion());
		}
		if (StringUtils.isNotBlank((CharSequence) _config.getSeleniumPlatform())) {
			desiredCapabilities.setPlatform(Platform.valueOf(_config.getSeleniumPlatform()));
		}
		
		if (StringUtils.isNotBlank(_config.getSeleniumBrowserPath())) {
			desiredCapabilities.setCapability(FirefoxDriver.BINARY, _config.getSeleniumBrowserPath());
		}
		
		//desiredCapabilities.setCapability("uuid","testRun1");
		
		desiredCapabilities.setCapability("uuid", UUID.randomUUID().toString());
		
		desiredCapabilities.setCapability("JbehaveThreadCount", _config.getJbehaveThreadCount());
		
		// Add firefox profile to enable username/password within the URL to get access to Future INT system
		// final FirefoxProfile profile = new FirefoxProfile();
		// profile.setPreference("network.http.phishy-userpass-length", FIREFOX_MAX_USERPASS_LENGTH);
		// desiredCapabilities.setCapability(FirefoxDriver.PROFILE, profile);

		return desiredCapabilities;
	}
}
