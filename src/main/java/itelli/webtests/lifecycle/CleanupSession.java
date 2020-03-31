package itelli.webtests.lifecycle;

import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.BeforeStories;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.RemoteWebDriver;

import itelli.webtests.common.DSLLogConstract;
import itelli.webtests.common.DslHelper;
import itelli.webtests.common.DslLogBeauty;
import itelli.webtests.common.SapExecutionService;
import itelli.webtests.config.WebTestsConfiguration;
import itelli.webtests.pages.common.ContextInformation;
import itelli.webtests.pages.common.ContextInformationProvider;
import itelli.webtests.steps.web.forms.FormWebSteps;

/**
 * JBehave lifecycle element which cleans the session state before starting a scenario.
 * 
 * @author stefan.person (created), 21.12.2012
 */
public class CleanupSession {

	private static final Logger LOG = Logger.getLogger(CleanupSession.class);

	private WebDriverProvider webDriverProvider;
	private ContextInformationProvider contextInformationProvider;
	private Map<String, String> failures = new HashMap<String, String>();
	private WebTestsConfiguration webTestsConfiguration;
	private Boolean isSAPTest = false;

	
	public WebTestsConfiguration getWebTestsConfiguration() {
		return webTestsConfiguration;
	}

	public void setWebTestsConfiguration(WebTestsConfiguration webTestsConfiguration) {
		this.webTestsConfiguration = webTestsConfiguration;
	}

	/**
	 * Check for start condition before testing stories.<br>
	 */
	@BeforeStories
	public void beforeAllStories() {
		// Currently not used
	}
	
	@AfterStories
	public void afterAllStories() {
		for(String key : failures.keySet()){
			try{
				LOG.info("failure key : " + key);
				if (isSAPTest) {
					String issueKey = DslHelper.extractIssueKey(key);
					try {
						SapExecutionService.addExecutionInfo("", issueKey, webTestsConfiguration.getTestedSystem(), false);
					} catch (Exception e) {
						DslLogBeauty.logger(DSLLogConstract.SAP_EXECUTION_INFO_NOT_ADDED, new Object[] { "", issueKey }, e, CleanupSession.class);
					}
				}

				if (webTestsConfiguration.getDownloadVideo().equals("true")) {
					
					URL website = new URL("http://34.248.82.41:4444/grid/admin/HubVideoDownloadServlet?sessionId=" + failures.get(key));
					ReadableByteChannel rbc = Channels.newChannel(website.openStream());
					
					int index = key.lastIndexOf('/');
					
					String dir = System.getenv("bamboo_build_working_directory");
					
					if(dir == null){
						dir = "";
					} else{
						dir = dir + "/target/jbehave/";
					}
				
					
					FileOutputStream fos = new FileOutputStream(dir + key.substring(index+1, key.length()) + ".webm");
					fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
					fos.close();
				}
				
			} catch (Exception e) {
				LOG.error("exception when video/record getting from servlet.", e);
			}
		}
		
	}
	
	/**
	 * Clean up after given story.<br>
	 */
	@AfterStory(uponGivenStory = true)
	public void afterGivenStory() {
		// only usefull if only one given story is used per scenario
		try {
			getWebDriverProvider().get().manage().deleteAllCookies();
			// remove properties which are only internaly used
			getContextInformation().removePropertyFromMetaMap("stageproduct");
			getContextInformation().removePropertyFromMetaMap("basketcount");

		}
		catch (final WebDriverException e) {
			CleanupSession.LOG.error("Exception while deleting all cookies during the cleanup phase", e);
		}
	}

	/**
	 * Cleans up the session before a scenario starts.<br>
	 * Created by: stefan.person
	 */
	@AfterStory
	public void cleanupSession() {
		try {
			getContextInformation().setBrand(null);
			getContextInformation().setCountry(null);
			getContextInformation().setLanguage(null);
			getContextInformation().setMetaMap(null);
			getContextInformation().setIsSAP(false);
			//getWebDriverProvider().get().manage().deleteAllCookies();
			
		}
		catch (final WebDriverException e) {
			CleanupSession.LOG.error("Exception while deleting all cookies during the cleanup phase", e);
		}
	}

	/**
	 * Check for before scenario starts.<br>
	 */
	@BeforeScenario
	public void beforeScenario() {
		// not used at this moment
	}

	/**
	 * After successful scenario.<br>
	 */
	@AfterScenario(uponOutcome = AfterScenario.Outcome.SUCCESS)
	public void afterSuccessfulScenario() {
		// not used at this moment
	}

	/**
	 * After scenario failed.<br>
	 */
	@AfterScenario(uponOutcome = AfterScenario.Outcome.FAILURE)
	public void afterFailedScenario() {
		RemoteWebDriver wd = (RemoteWebDriver) getWebDriverProvider().get();

		failures.put(getContextInformation().getStoryName(), wd.getSessionId().toString());
		isSAPTest = isSAPTest || (getContextInformation().getIsSAP() != null && getContextInformation().getIsSAP());
		cleanupSession();
	}

	protected final WebDriverProvider getWebDriverProvider() {
		return webDriverProvider;
	}

	public final void setWebDriverProvider(final WebDriverProvider webDriverProvider) {
		this.webDriverProvider = webDriverProvider;
	}

	protected final ContextInformation getContextInformation() {
		return getContextInformationProvider().getContextInformation();
	}

	public ContextInformationProvider getContextInformationProvider() {
		return contextInformationProvider;
	}

	public void setContextInformationProvider(ContextInformationProvider contextInformationProvider) {
		this.contextInformationProvider = contextInformationProvider;
	}

}
