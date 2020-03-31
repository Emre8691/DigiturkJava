package steps.itelli.webtestsItelli.src.main.java.itelli.webtests.network;

import java.net.URL;
import java.util.Map;

import org.jbehave.web.selenium.RemoteWebDriverProvider;
import org.jbehave.web.selenium.RemoteWebDriverProvider.SauceLabsJobHasEnded;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.DriverCommand;
import org.openqa.selenium.remote.HttpCommandExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.Response;
import org.springframework.beans.factory.annotation.Autowired;

import net.lightbody.bmp.BrowserMobProxy;

public class ProxyRemoteWebDriverProvider extends RemoteWebDriverProvider {

	DesiredCapabilities desiredCapabilities;
	private boolean verbose = false;

	private ProxyProvider proxyProvider;

	public ProxyRemoteWebDriverProvider(DesiredCapabilities desiredCapabilities) {
		if (desiredCapabilities == null) {
			this.desiredCapabilities = makeDesiredCapabilities();
		} else {
			this.desiredCapabilities = desiredCapabilities;
		}
	}

	@Override
	public void initialize() {
		URL url = null;
		WebDriver remoteWebDriver;
		try {
			url = createRemoteURL();
			DesiredCapabilities cap = new DesiredCapabilities(desiredCapabilities);

			cap.setCapability(CapabilityType.PROXY, createProxy());

			remoteWebDriver = new ScreenshootingRemoteWebDriver(wrapCommandExecutor(new HttpCommandExecutor(url)),
					cap);
		} catch (Throwable e) {
			if (verbose) {
				System.err.println("*********** Remote WebDriver Initialization Failure ************");
				e.printStackTrace(System.err);
			}
			throw new UnsupportedOperationException("Connecting to remote URL '" + url + "' failed: " + e.getMessage(),
					e);
		}
		// Augmenter does not work. Resulting WebDriver is good for exclusive
		// screenshooting, but not normal operation as 'session is null'
		// remoteWebDriver = new Augmenter().augment(remoteWebDriver);
		// should allow instanceof TakesScreenshot.
		// To take out when this is fixed in Selenium 2.0b4 (beta 4)
		delegate.set(remoteWebDriver);
	}

	private Proxy createProxy() {
		BrowserMobProxy bmproxy = getProxyProvider().getProxy();
		String proxyIP = "localhost";
		int proxyPort = bmproxy.getPort();
		
		Proxy proxy = new Proxy();
		proxy.setHttpProxy(proxyIP + ":" + proxyPort);
		proxy.setProxyType(ProxyType.MANUAL);
		
		return proxy;
	}

	static class ScreenshootingRemoteWebDriver extends RemoteWebDriver implements TakesScreenshot {

		private boolean sauceJobEnded = false;

		public ScreenshootingRemoteWebDriver(CommandExecutor commandExecutor, DesiredCapabilities desiredCapabilities) {
			super(commandExecutor, desiredCapabilities);
		}

		public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
			// Paul: Copied from FirefoxDriver.......
			// Get the screenshot as base64.
			String base64 = execute(DriverCommand.SCREENSHOT).getValue().toString();
			// ... and convert it.
			return target.convertFromBase64Png(base64);
		}

		@Override
		protected Response execute(String driverCommand, Map<String, ?> parameters) {
			if (sauceJobEnded) {
				throw new SauceLabsJobHasEnded();
			}
			try {
				return super.execute(driverCommand, parameters);
			} catch (WebDriverException e) {
				if (e.getMessage().indexOf("Job on Sauce is already complete") > -1) {
					sauceJobEnded = true;
					throw new SauceLabsJobHasEnded();
				}
				throw e;
			} catch (RuntimeException e) {
				throw e;
			}
		}
	}

	public void useVerbosity(boolean verbose) {
		this.verbose = verbose;
	}

	public ProxyProvider getProxyProvider() {
		return proxyProvider;
	}

	public void setProxyProvider(ProxyProvider proxyProvider) {
		this.proxyProvider = proxyProvider;
	}
}
