package itelli.webtests.steps.web.system;

import java.util.List;

import org.apache.log4j.Logger;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.mortbay.log.Log;
import org.springframework.beans.factory.annotation.Autowired;

import itelli.webtests.network.ProxyProvider;
import itelli.webtests.pages.base.ContextBase;
import itelli.webtests.steps.AbstractSteps;
import junit.framework.Assert;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.core.har.HarEntry;

public class NetworkSteps extends AbstractSteps<ContextBase> {
	private static final Logger LOG = Logger.getLogger(NetworkSteps.class);

	private ProxyProvider proxyProvider;

	@When("I start network monitoring")
	public void startNetworkMonitor() {
		BrowserMobProxy proxy = proxyProvider.getProxy();
		if (proxy == null) {
			Assert.fail("Proxy not enabled to monitor network");
		}
		proxy.newHar();
		proxy.newPage();

	}

	@Then("I check for network with url starting with $urlstartswith is success")
	public void checkNetworkRequestStatusSuccess(String urlstartswith) {
		BrowserMobProxy proxy = proxyProvider.getProxy();
		Har h = proxy.getHar();

		if (h == null) {
			Assert.fail("Network monitoring not started");
		}

		List<HarEntry> entries = h.getLog().getEntries();

		boolean found = false;
		int statusCode = 0;
		for (HarEntry harEntry : entries) {
			String url = harEntry.getRequest().getUrl();
			statusCode = harEntry.getResponse().getStatus();

			if (url.startsWith(urlstartswith)) {
				found = true;
				if (statusCode == 200) {
					break;
				}
			}
		}

		Assert.assertTrue("Request not found for url: " + urlstartswith, found);
		Assert.assertEquals("Status code not expected", 200, statusCode);

	}
	
	@Then("I check for network with url starting with $urlstartswith is failed")
	public void checkNetworkRequestStatusFail(String urlstartswith) {
		BrowserMobProxy proxy = proxyProvider.getProxy();
		Har h = proxy.getHar();

		if (h == null) {
			Assert.fail("Network monitoring not started");
		}

		List<HarEntry> entries = h.getLog().getEntries();

		boolean found = false;
		int statusCode = 0;
		for (HarEntry harEntry : entries) {
			String url = harEntry.getRequest().getUrl();
			statusCode = harEntry.getResponse().getStatus();

			if (url.startsWith(urlstartswith)) {
				found = true;
				if (statusCode == 200) {
					break;
				}
			}
		}

		Assert.assertTrue("Request not found for url: " + urlstartswith, found);
		if(statusCode != 200){
			Assert.fail("Status code not expected");
		}
	}
	
	@Then("I check for network with url starting with $urlstartswith have not been made")
	public void checkNetworkRequestStatusMade(String urlstartswith) {
		BrowserMobProxy proxy = proxyProvider.getProxy();
		Har h = proxy.getHar();

		if (h == null) {
			Assert.fail("Network monitoring not started");
		}

		List<HarEntry> entries = h.getLog().getEntries();

		boolean found = false;
		for (HarEntry harEntry : entries) {
			String url = harEntry.getRequest().getUrl();

			if (url.startsWith(urlstartswith)) {
				found = true;
			}
		}

		Assert.assertTrue("Request found for url: " + urlstartswith, !found);
	}

	@Then("I stop network monitoring")
	public void stopNetworkCapture() {
		BrowserMobProxy proxy = proxyProvider.getProxy();
		proxy.endHar();
	}
	
	public void setProxyProvider(ProxyProvider proxyProvider) {
		this.proxyProvider = proxyProvider;
	}
	
	public ProxyProvider getProxyProvider() {
		return proxyProvider;
	}
}
