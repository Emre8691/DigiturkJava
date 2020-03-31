package steps.itelli.webtestsItelli.src.main.java.itelli.webtests.config;

import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.glassfish.jersey.client.ClientConfig;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.BeanCreationException;
import org.syntax.jedit.InputHandler.select_all;

/**
 * Factory class used to create the {@link WebDriverProvider} based on the current {@link WebTestsConfiguration}.<br>
 * 
 * @author stefan.person (created), 21.12.2012
 */
public final class WebDriverProviderFactory {

	/**
	 * Private constructor to avoid instantiation of this factory class.
	 */
	private WebDriverProviderFactory() {
	}

	/**
	 * Create the {@link WebDriverProvider} based on the {@link WebTestsConfiguration}. It also sets some necessary system
	 * properties which are needed to locate the browser binary for example.<br>
	 * Created by: stefan.person
	 * 
	 * @param _possibleWebDriverProvider A Map of configuration values (e.g. local or remote) which are mapped to a real
	 *            {@link WebDriverProvider} implementation.
	 * @param _config The {@link WebTestsConfiguration} of the application.
	 * @return The correct {@link WebDriverProvider} based on the {@link WebTestsConfiguration}.
	 * @throws Exception 
	 */
	public static WebDriverProvider createWebDriverProvider(final Map<String, WebDriverProvider> _possibleWebDriverProvider,
			final WebTestsConfiguration _config,DesiredCapabilities desiredCapabilities) throws Exception {
		// Set the necessary system properties
		System.setProperty("webdriver.firefox.bin", _config.getSeleniumBrowserPath());
		System.setProperty("browser.version", _config.getSeleniumBrowserVersion());
		System.setProperty("browser.platform", _config.getSeleniumPlatform());
		System.setProperty("REMOTE_WEBDRIVER_URL", _config.getSeleniumURL());
		//System.setProperty("webdriver.server.session.timeout", "60");
		//System.setProperty("webdriver.server.browser.timeout", "5");
		//System.setProperty("webdriver.ie.driver", "c:\\DevCommonFiles\\ie\\IEDriverServer.exe");
		
		
		LOG.error("System.getProperty(REMOTE_WEBDRIVER_URL): " + System.getProperty("REMOTE_WEBDRIVER_URL"));

		// Create/Return the configured WebDriverProvider
		if (_possibleWebDriverProvider.containsKey(_config.getSeleniumWebDriverType())) {
			
			LOG.error("inside if 1");
			
			WebDriverProvider webDriverProvider = _possibleWebDriverProvider.get(_config.getSeleniumWebDriverType());
			
			
			if("remote".equals(_config.getSeleniumWebDriverType())){
				
				LOG.error("inside if remote");
				
				String UUID = desiredCapabilities.getCapability("uuid").toString();
				int jbehaveThreadCount = (Integer) desiredCapabilities.getCapability("JbehaveThreadCount");
				
				LOG.error("!!!jbehaveThreadCount: " + jbehaveThreadCount);
				
				LOG.error("_config.getSeleniumURL(): " + _config.getSeleniumURL());
				
				 if(System.getProperty("REMOTE_WEBDRIVER_URL").contains("34.248.82.41")){
				
				
					
					requestNewNodes(UUID, jbehaveThreadCount);
					waitForFreeNodes();
				}
			}
			
			return webDriverProvider;
		}

		throw new BeanCreationException("Unable to create WebDriverProvider because configured seleniumWebDriverType='"
				+ _config.getSeleniumWebDriverType() + "' is not available in Map of Bean 'webDriverProvider'");
	}

	private static void requestNewNodes(String uUID, int jbehaveThreadCount) {
		
		Client client = ClientBuilder.newClient( new ClientConfig() );
		
		WebTarget webTarget = client.target("http://34.248.82.41:4444/grid/admin/AutomationTestRunServlet?uuid=" + uUID + "&threadCount=" + jbehaveThreadCount + "&browser=firefox");
		 
		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_XML);
		Response response = invocationBuilder.get();
		 
		LOG.error("response.getStatus():" + response.getStatus());
		
		client.close();
	}
	
	private static void waitForFreeNodes() throws Exception {
		
		String freeNodeCount = "0";
		long retryCount = 0;
		do{
			Thread.sleep(15000);
			
			Client client = ClientBuilder.newClient( new ClientConfig() );
			
			WebTarget webTarget = client.target("http://34.248.82.41:4444/grid/admin/FreeNodeStatusServlet");
			 
			Invocation.Builder invocationBuilder =  webTarget.request(MediaType.TEXT_HTML);
			Response response = invocationBuilder.get();
			 
			freeNodeCount = response.readEntity(String.class);
			
			LOG.error("freeNodeCount:" + freeNodeCount);
			LOG.error("response.getStatus():" + response.getStatus());
			
			client.close();
			LOG.error("retryCount:" + retryCount);
			retryCount++;
		} while( freeNodeCount.equals("0") && retryCount<=18 );
		
		if(retryCount>18){
			throw new Exception("Can not allocate nodes for selenium.");
		}
		
	}
	
	private static final Logger LOG = Logger.getLogger(WebDriverProviderFactory.class);
}
