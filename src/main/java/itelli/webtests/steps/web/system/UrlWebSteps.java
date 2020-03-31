package itelli.webtests.steps.web.system;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import itelli.webtests.common.DSLLogConstract;
import itelli.webtests.common.DslLogBeauty;
import itelli.webtests.config.WebTestsConfiguration;
import itelli.webtests.pages.base.ContextBase;
import itelli.webtests.steps.AbstractSteps;

/**
 * Web Application Steps which are useable for common functionalities of
 * webpages.
 */
public class UrlWebSteps extends AbstractSteps<ContextBase> {

	private static final Logger LOG = Logger.getLogger(ContextBase.class);
	private String sandBoxNo;
	public WebTestsConfiguration getWebTestsConfiguration() {
		return webTestsConfiguration;
	}

	public void setWebTestsConfiguration(WebTestsConfiguration webTestsConfiguration) {
		this.webTestsConfiguration = webTestsConfiguration;
	}

	private WebTestsConfiguration webTestsConfiguration;


	/**
	 * Open the page via given url parameter.<br>
	 * @param url
	 *            The "url" given directly defined at step definition or given
	 *            as named parameter from url.properties / urlsuffix.properties.
	 */
	@When("I open the page for following address $url")
	public void openPage(final String url) {
		try {
			final int timeout = 180; //seconds
			//getContext().setWaitTimeout(timeout);
			getContext().setPageLoadTimeout(timeout);
			
			if ( url == null ) {
				DslLogBeauty.logger(DSLLogConstract.URL_NOT_FOUND, new Object[] { url, "The website is not reachable" }, new Exception(), ContextBase.class);
			}
			getContext().open(url);
			// check if the webpage is accessible
			if (getTestedSystem().contains("sandbox") && checkIfWebpageIsNectarPage() == 0) {
				LOG.warn("Environment is Sandbox and Page is Not a Nectar Page");
				boolean isAgentRunning;

				if (checkIfAgentNeedsRun().size() < 1) {
					isAgentRunning = true;
				} else {
					isAgentRunning = false;
				}
				LOG.warn("isAgentRunning =" + isAgentRunning);

				if (!isAgentRunning) {
					try {
						LOG.warn("checkIfAgentNeedsRun");
						checkIfAgentNeedsRun().get(0).click();
						LOG.warn("checkIfAgentNeedsRun end.");
					} catch (IndexOutOfBoundsException E) {
						LOG.warn("another thread clicked to button already. this is not an error.");
						// another thread clicked to button already
						// this is not an error.
					}
					LOG.warn("waitUntilTimeout(3)");
					getContext().waitUntilTimeout(3);
					getContext().navigate().refresh();
					LOG.warn("refresh()");

					final int MAX_TRY = 5;
					int tried = 0;

					do {
						tried++;
						LOG.warn("getContext().waitForVisibility(By.cssSelector(#environmentsTable), 5);");
						getContext().waitForVisibility(By.cssSelector("#environmentsTable"), 5);

						getContext().navigate().refresh();
						getContext().waitUntilTimeout(3);

					} while (checkIfAgentRunStarted().size() == 0 && tried < MAX_TRY);
				}

				//LOG.warn("waitUntilNectarPageLoaded(url)");
				//waitUntilNectarPageLoaded(url);
				
				getContext().open(url);
				LOG.info(String.format("Web: Selenium try to open the url: '%s'!", url));
				closeDialog();
			}

			else if (getTestedSystem().contentEquals("production")) {

				getContext().open(url + "?preview=newSiteD2C");
				LOG.info(String.format("Web: Selenium try to open the url for Preview Mode: '%s'!", url));
				closeDialog();
				
				WebElement loginForm = getContext().findElementByAttributeValue("id", "previewUserLogin");
				if (loginForm == null) {
					getContext().open(url + "?preview=prodSiteD2C");
				}
				
				String mainlinkSiemens = ".logo>a>strong";
				String mainLinkBosch = ".active>a";
				String testCheckBox = "label[for='testingIdCheckbox']";
				String quitPreview = "#previewoverlay>div>a";

				WebElement btn = null; 
				
				try {
					btn = getContext().findElement(By.cssSelector(testCheckBox));
				} catch (Exception e) {
				}
				
				if (btn == null) {
					getContext().fillFormElementWithoutTestingID("username", "CCTM_QA");
					getContext().fillFormElementWithoutTestingID("password", "Cctm1234");
					getContext().findElementByAttributeAndValue("id", "previewLogin").click();
					getContext().waitUntilTimeout(2);

					btn = getContext().findElement(By.cssSelector(testCheckBox));
					btn.click();
					
					getContext().waitUntilTimeout(4);
					try {
						if (getContext().getCurrentUrl().contains("bosch")) {
							getContext().findElement(By.cssSelector(mainLinkBosch)).click();
						} else {
							getContext().findElement(By.cssSelector(mainlinkSiemens)).click();
						}
					} catch (Exception e) {
					}
					getContext().waitUntilTimeout(2);
					getContext().findElement(By.cssSelector(quitPreview)).click();
				}

			} else {
				getContext().open(url);
				LOG.info(String.format("Web: Selenium try to open the url: '%s'!", url));
				closeDialog();
			}
		} catch (Exception e) {
			LOG.warn("ozel test exception " + e.getMessage());
			e.printStackTrace();
		}
	}

	private void waitUntilNectarPageLoaded(String url) {
		int tryCount = 0;
		final int MAX_TRY = 30;
		do {
			LOG.warn("tryCount = " + tryCount);
			tryCount++;
			getContext().open(url);
			if (checkIfWebpageIsNectarPage() == 0) {
				getContext().navigate().refresh();
				getContext().waitUntilTimeout(10);
			}
		} while (checkIfWebpageIsNectarPage() == 0 && tryCount < MAX_TRY);
	}

	private List<WebElement> checkIfAgentNeedsRun() {
		String sandBoxRow = "button[data-sandbox='" + getSandBoxNo() + "']";
		getContext().open("https://discovery.muc.icore.io/");
		getContext().waitForVisibility(By.cssSelector("#environmentsTable"), 3);
		getContext().waitForVisibility(By.cssSelector(sandBoxRow), 3);
		List<WebElement> sandBoxLink = getContext().findElements(By.cssSelector(sandBoxRow));
		return sandBoxLink;
	}

	private List<WebElement> checkIfAgentRunStarted() {
		String css2 = "tr[data-sandbox='" + getSandBoxNo() + "'] span.label.label-success";
		List<WebElement> listOfRunningSandBox = getContext().findElements(By.cssSelector(css2));
		return listOfRunningSandBox;

	}

	private String getTestedSystem() {
		String url = getContext().getCurrentUrl().toString();
		if (url.contains(".fi.muc.bsh") || url.contains(".tt.msk.bsh") || url.contains(".tt.sin.bsh") || url.contains(".tt.sha.bsh") ) {
			return "futureint";
		} else if (url.contains("sandbox")) {
			String sandBoxRaw = getContext().getCurrentUrl().toString();
			String[] firstSplit = sandBoxRaw.split("sandbox");
			String[] secondSplit = firstSplit[1].split(".muc");
			String sandBoxNo = secondSplit[0];
			String sandBox = "sandbox" + sandBoxNo;
			setSandBoxNo(sandBox);
			return sandBox;
		} else {
			return "production";
		}
	}

	private int checkIfWebpageIsNectarPage() {
		String bshCheck = "[name=source_system]";
		List<WebElement> bshCheckList = getContext().findElements(By.cssSelector(bshCheck));
		int bshSiteCheck = bshCheckList.size();
		return bshSiteCheck;
	}

	@When(value="I open external webpage $url", priority=1)
	public void openExternalPage(final String url) {
		getContext().open(url);
		final String expectedUrl = url;
		final String gotCurrentUrl = getContext().getCurrentUrl();
		final boolean matches = gotCurrentUrl.matches(expectedUrl);
		if ( matches ) {
			Assert.assertTrue("The url of current page is not as expected:<" + expectedUrl + "> but was:<" + gotCurrentUrl + ">", matches);
		} else {
			DslLogBeauty.logger(DSLLogConstract.URL_IS_NOT_MATCHING, new Object[] { url, "The URL did not matched" }, new Exception(), UrlWebSteps.class);
		}
	}

	@When(value="I open external webpage without validate $url", priority=2)
	public void openExternalPageWithoutValidate(final String url) {
		getContext().open(url);
	}
	private void closeDialog() {
		String css = ".dialog .close-btn";
		By selector = By.cssSelector(css);
		try {
			final WebElement elm = getContext().waitForClickable(selector, 5);
			if (elm != null) {
				getContext().getContextBasedActions().clickElement(elm);
			}
			getContext().waitForInvisibility(selector, 5);
			Thread.sleep(2000);

		} catch (NoSuchElementException ex) {

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Get the URL from a testing ID or html attribute by reading the text at
	 * attribute.<br>
	 * @param attribute The code of the attribute which includes the URL as text.
	 */
	@When("I open the $attribute from the current page")
	public void openGivenURL(final String attribute) {
		final String url = getContext().getContextBasedInformations().getTextFromElementByAttributeId(attribute);
		getContext().get(url);
		LOG.info(String.format("Web: The found URL is: '%s' for searched attribute: '%s'!", url, attribute));
		Assert.assertNotNull(String.format("Web: The given URL '%s' is not the expected url '%s'!", url, attribute),
				url);
	}

	/**
	 * Checks if the url of current page is as expected.<br>
	 * @param url The expected url.
	 */
	@Then("the url of current page is $url")
	public void checkUrlOfCurrentPage(final String url) {
		final String expectedUrl = url;
		final String gotCurrentUrl = getContext().getCurrentUrl();
		final boolean matches = gotCurrentUrl.matches(expectedUrl);
		if ( matches ) {
			Assert.assertTrue( "The url of current page is not as expected:<" + expectedUrl + "> but was:<" + gotCurrentUrl + ">", matches);
		} else {
			DslLogBeauty.logger(DSLLogConstract.URL_IS_NOT_MATCHING, new Object[] { url, "The URL did not matched" }, new Exception(), UrlWebSteps.class);
		}
	}

	/**
	 * Checks if the url of current page contains an expected string.<br>
	 * @param urlPart The part of an expected url.
	 */
	@Then("the url of current page contains $urlPart")
	public void checkPartUrlOfCurrentPage(final String urlPart) {
		final boolean isAvailable = getContext().waitForUrl(urlPart);
		if ( isAvailable ) {
			Assert.assertTrue("The url of current page does not contain the expected part '" + urlPart + "', got: "
					+ getContext().getCurrentUrl(), isAvailable);
		} else {
			DslLogBeauty.logger(DSLLogConstract.URL_IS_NOT_MATCHING, new Object[] { urlPart, "The URL did not contains " }, new Exception(), UrlWebSteps.class);
		}
	}

	@When("I check the $url")
	public void checkWebsite(final String url) throws Exception {
		// Open website via URL that provided.
		getContext().get(url);
		getContext().waitUntilTimeout(MAX_TIMEOUT_10_SECONDS);
		LOG.info(String.format("Web: Selenium try to open the url: '%s'!", url));

		// The "A" tag is a hyperlink tag need to find all these tags on page
		final List<WebElement> linksList = getContext().findElements(By.tagName("a"));
		LOG.info(String.format("URL size : ", linksList.size()));

		// Create a txt file and append on it.
		final FileOutputStream fout = new FileOutputStream("broken_links.txt", true);
		int invalidLink = 0;
		new PrintStream(fout).println("URL : " + getContext().getCurrentUrl());
		new PrintStream(fout).println("--------------------------------------------");
		System.out.println(linksList.size());
		int statusCode = 0;
		String statusDesc = "";
		for (int i = 0; i < linksList.size(); i++) {
			final String urltoCheck = linksList.get(i).getAttribute("href");
			// currentLink = getContext().getCurrentUrl();
			// "this.browserbot.getUserWindow().document.links[" + i + "]";
			// temp = (String) getContext().GetEval(urltoCheck + ".href");
			new PrintStream(fout).println(urltoCheck);
			if (urltoCheck != null && (urltoCheck.startsWith("http") || urltoCheck.startsWith("https"))) {
				final HttpURLConnection huc = getResponseCode(urltoCheck);

				statusCode = 0;
				statusDesc = "Invalid URL";
				if (huc != null) {
					statusCode = huc.getResponseCode();
					statusDesc = huc.getResponseMessage();
				}
				if (statusCode == 404) {
					invalidLink++;
				}
				new PrintStream(fout).println("URL : " + urltoCheck + " , Status Code = " + statusCode
						+ " , Status Description = " + statusDesc);
				new PrintStream(fout).println("--------------------------------------------");
				System.out.println("URL : " + urltoCheck + " , Status Code = " + statusCode + " , Status Description = "
						+ statusDesc);
			}
		}
		new PrintStream(fout).println("Total broken Links = " + invalidLink);
		new PrintStream(fout).println(" ");
		fout.close();
	}

	public HttpURLConnection getResponseCode(final String urlString) throws MalformedURLException, IOException {
		final URL u = new URL(urlString);
		if (u.getProtocol().equals("http") || u.getProtocol().equals("https")) {
			final HttpURLConnection huc = (HttpURLConnection) u.openConnection();
			huc.setRequestMethod("GET");
			huc.connect();
			return huc;
		}
		return null;
	}
	
	private void setSandBoxNo(String sandBox) {
		sandBoxNo = sandBox;
	}

	private String getSandBoxNo() {
		return sandBoxNo;
	}
}
