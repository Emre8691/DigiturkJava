package itelli.webtests.pages.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.util.UrlUtils;
import com.google.common.base.Function;

import itelli.webtests.common.DslHelper;
import itelli.webtests.domain.Brand;
import itelli.webtests.domain.Country;
import itelli.webtests.domain.Language;
import itelli.webtests.domain.SiteType;
import itelli.webtests.pages.common.ContextInformation;
import itelli.webtests.pages.common.ContextInformationProvider;
import itelli.webtests.pages.common.PropertiesReader;

/**
 * Page object class which provides methods to work with the context.
 * 
 * @author stefan.person (created), 21.12.2012
 */
public class ContextBase extends WebDriverPage {

	private static final Logger LOG = Logger.getLogger(ContextBase.class);

	public static final char LOCALE_SEPARATOR = '_';
	private static final long MILLI_SECONDS = 1000;

	private ContextInformationProvider contextInformationProvider;
	private PropertiesReader propertiesReader;

	private ElementFinder elementFinder;
	private ContextBasedActions contextBasedActions;
	private ContextBasedValidations contextBasedValidations;
	private ContextBasedInformations contextBasedInformations;

	public void highlightElement(WebElement webEl){
		
		WebDriver webDriver = getDriverProvider().get();
		if ( webDriver instanceof JavascriptExecutor) {
			((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView(true);", webEl);
	        ((JavascriptExecutor)webDriver).executeScript("arguments[0].style.border='3px solid red'", webEl);
	      
		}else{
			LOG.error("webDriver is not instance of JavascriptExecutor");
		}
		
		try {
			Thread.sleep(2*1000);
		} catch (InterruptedException e) {
			LOG.error(e);
		}
		
		((JavascriptExecutor)webDriver).executeScript("arguments[0].style.border=''", webEl);
	}
	
	/**
	 * Default constructor with the necessary parameter <tt>webDriverProvider</tt>.
	 * @param webDriverProvider The actual {@link WebDriverProvider} which should be used to execute the commands.
	 */
	public ContextBase(final WebDriverProvider webDriverProvider) {
		super(webDriverProvider);
	}

	/**
	 * Setup the {@link Brand} for the current Scenario.<br>
	 * Created by: stefan.person
	 * 
	 * @param brand The {@link Brand} to setup for the current Scenario. May not be null!
	 */
	public final void setupBrandForScenario(final Brand brand) {
		getContextInformation().setBrand(brand);
	}

	/**
	 * Setup the {@link Country} for the current Scenario.<br>
	 * Created by: stefan.person
	 * 
	 * @param country The {@link Country} to setup for the current Scenario. May not be null!
	 */
	public final void setupCountryForScenario(final Country country) {
		getContextInformation().setCountry(country);
	}

	/**
	 * Setup the {@link Language} for the current Scenario.<br>
	 * Created by: stefan.person
	 * 
	 * @param language The {@link Language} to setup for the current Scenario. May not be null!
	 */
	public final void setupLanguageForScenario(final Language language) {
		getContextInformation().setLanguage(language);
	}

	/**
	 * Setup the {@link SiteType} for the current Scenario.<br>
	 * Created by: stefan.person
	 * 
	 * @param siteType The {@link SiteType} to setup for the current Scenario. May not be null!
	 */
	public final void setupSiteTypeForScenario(final SiteType siteType) {
		getContextInformation().setSiteType(siteType);
	}

	public final void setupCurrentBasketCount(final String currentBasketCount) {
		getContextInformation().setPropertyToMetaMap("currentBasketCount", currentBasketCount);
	}

	public final void setupSAPTestForScenario(final Boolean isSAP) {
		getContextInformation().setIsSAP(isSAP);
	}

	/**
	 * Setup the default parameters by properties global and common for the current Scenario.<br>
	 */
	public final void setupDefaultParametersForScenario() {

		final Map<String, String> scenarioParameters = new HashMap<String, String>();

		// add named parameters from global properties file (if available)
		getPropertiesReader().getNamedParametersFromGlobalProperties(scenarioParameters);

		// add named parameters from common properties file (if available)
		getPropertiesReader().getNamedParametersFromCommonProperties(scenarioParameters);

		getContextInformation().setMetaMap(scenarioParameters);
	}

	/**
	 * Setup the parameters by properties files for the current Scenario.<br>
	 * 
	 * @param paramList The list of filenames to setup for the current Scenario. May not be null!
	 */
	public final void setupParametersForScenario(final List<String> paramList) {

		final Map<String, String> scenarioParameters = new HashMap<String, String>();

		// add named parameters from global properties file (if available)
		getPropertiesReader().getNamedParametersFromGlobalProperties(scenarioParameters);

		// add named parameters from common properties file (if available)
		getPropertiesReader().getNamedParametersFromCommonProperties(scenarioParameters);

		// add named parameters from local properties file (if available)
		getPropertiesReader().getNamedParametersLocalProperties(scenarioParameters);

		// fill (and overwrite) named parameters from given list

		
		Logger.getLogger(getClass()).info("File list for allparameters:"+paramList);
		paramList.add("page");
		for (final String propertyFilename : paramList) {
			getPropertiesReader().getNamedParametersFromProperties(propertyFilename, scenarioParameters);
		}

		
		Logger.getLogger(getClass()).info("allparameters : "+scenarioParameters);
		
		getContextInformation().setMetaMap(scenarioParameters);
	}

	/**
	 * Setup the given parameter for the current Scenario.<br>
	 * 
	 * @param parameter The parameter name to setup for the current Scenario
	 * @param value The value of the parameter
	 */
	public final void setupParameterForScenario(final String parameter, final String value) {
		getContextInformation().setPropertyToMetaMap(parameter, value);
	}

	/**
	 * Get the given parameter for the current Scenario.<br>
	 * 
	 * @param parameter The parameter name to get the value for the current Scenario
	 * @return The value of the parameter
	 */
	public final String getParameterForScenario(final String parameter) {
		return getContextInformation().getPropertyFromMetaMap(parameter);
	}

	/**
	 * Increase the value of the given parameter for the current Scenario.<br>
	 * 
	 * @param parameter The parameter name to increase the value for the current Scenario
	 */
	public final void increaseParameterForScenario(final String parameter) {
		int value = checkParameterIsANumber(parameter);
		getContextInformation().setPropertyToMetaMap(parameter, Integer.toString(++value));
	}

	/**
	 * Increase the value of the given parameter for the current Scenario.<br>
	 * 
	 * @param parameter The parameter name to increase the value for the current Scenario
	 */
	public final void decreaseParameterForScenario(final String parameter) {
		int value = checkParameterIsANumber(parameter);
		getContextInformation().setPropertyToMetaMap(parameter, Integer.toString(--value));
	}

	private int checkParameterIsANumber(final String parameter) {
		final String valueStr = getContextInformation().getPropertyFromMetaMap(parameter);
		final int defValue = 10;
		int value = 0;

		if (!StringUtils.isBlank(valueStr)) {
			try {
				value = Integer.parseInt(valueStr, defValue);
			}
			catch (final NumberFormatException e) {
				ContextBase.LOG.warn("No valid integer found for parameter: " + parameter);
			}
		}
		return value;
	}

	/**
	 * Check if the currently shown url contains the expected part of url.<br>
	 * 
	 * @param partOfUrl The expected part of the currently shown url
	 * @return The currently shown url contains the expect part of url
	 */
	public final boolean waitForUrl(final String partOfUrl) {
		final int retryCount = 10;
		boolean isAvailable = false;

		for (int i = 0; i < retryCount; i++) {
			try {
				if (this.getCurrentUrl().contains(partOfUrl)) {
					isAvailable = true;
					break;
				}
			}
			catch (final Exception e) {
				ContextBase.LOG.error("The expected part of URL [" + partOfUrl + "] is not shown", e);
			}
			waitUntilTimeout(1); // wait before next retry
		}
		return isAvailable;
	}

	/**
	 * Tries to fill <tt>value</tt> into the given <tt>element</tt>.<br/>
	 * <br/>
	 * Uses the following chain to resolve the <tt>element</tt>:
	 * <ol>
	 * <li>{@link By#id(String)} for <tt>element</tt></li>
	 * <li>{@link By#name(String)} for <tt>element</tt></li>
	 * </ol>
	 * 
	 * @param element the element to fill
	 * @param value the value to set
	 */
	public final void fillFormElementWithoutTestingID(final String element, final String value) {
		// fillFormElementInternal(element, value, false);
		fillFormElement(element, value);
	}

	/**
	 * Tries to fill <tt>value</tt> into the given <tt>element</tt>.<br/>
	 * <br/>
	 * Uses the following chain to resolve the <tt>element</tt>:
	 * <ol>
	 * <li>{@link By#cssSelector(String)} for <code>[testing_id="<tt>element</tt>"]</code></li>
	 * <li>{@link By#id(String)} for <tt>element</tt></li>
	 * <li>{@link By#name(String)} for <tt>element</tt></li>
	 * </ol>
	 * 
	 * @param element the element to fill
	 * @param value the value to set
	 */
	public final void fillFormElement(final String element, final String value) {
		fillFormElementInternal(element, value);
	}

	/**
	 * Finds a {@link WebElement} by the given <tt>bySelector</tt>, if available. Otherwise returns <code>null</code>.<br/>
	 * Never throws a {@link NoSuchElementException}.
	 * 
	 * @param bySelector the {@link By} to use for detection
	 * @return {@link WebElement} or <code>null</code>
	 */
	public WebElement findFormElement(final By bySelector) {
		WebElement input;
		try {
			input = findElement(bySelector);
		}
		catch (final NoSuchElementException nse) {
			return null;
		}
		return input;
	}
	
	
	
	public String findJsVariable(final String jsVariable) {
		String value = null;
		try {
			 JavascriptExecutor js = (JavascriptExecutor) getDriverProvider().get();
			 value = (String) js.executeScript("return " + jsVariable + ";");
		}
		catch (final Exception e) {
			LOG.error(e);
			return null;
		}
		return value;
	}
	
	

	/**
	 * Go to method for finding element by given attribute.
	 * 
	 * @param attribute The given attribute.
	 * @return Returns searched WebElement.
	 */
	public WebElement findElementByGivenAttribute(final String attribute) {
		return elementFinder.findBy(attribute);
	}
	
	public WebElement findElementByAnyGivenAttribute(final String attribute) {
		return elementFinder.findByAnyAttribute(attribute);
	}

	/**
	 * Go to method for filling form by given attribute.
	 * 
	 * @param attribute The given attribute
	 * @param parameter The given Parameter
	 */
	public void fillForm(final String attribute, final String parameter) {
		fillFormElementInternal(attribute, parameter);
	}

	private void fillFormElementInternal(final String element, final String value) {
		setWaitTimeout(0);
		final WebElement elm = findElementByGivenAttribute(element);
		if (elm != null) {
			if (elm.getTagName().equals("input") || elm.getTagName().equals("textarea")) {
				elm.click();
				elm.sendKeys(value);
				
				

				// A synchronous AJAX call probably prevented us from entering the value into the field.
				// So we simply wait two seconds and try again.
				if (!elm.getAttribute("value").equalsIgnoreCase(value)) {
					waitUntilTimeout(2);
					elm.clear();
					elm.sendKeys(value);
				}
			}
			else if (elm.getTagName().equals("select")) {
				final List<WebElement> childElements = elm.findElements(By.cssSelector("option"));
				if (childElements != null) {
					for (final WebElement optElm : childElements) {
						if (value.equals(optElm.getAttribute("value")) || value.equals(optElm.getText())) {
							optElm.click();
							break;
						}
					}
				}
			}
		}
	}

	/**
	 * Set try timeout to find element on page by selenium
	 * 
	 * @param waitTimeout the max. time for waiting ins seconds
	 */
	public void setWaitTimeout(final long waitTimeout) {
		this.manage().timeouts().implicitlyWait(waitTimeout, TimeUnit.SECONDS);
	}

	public void setPageLoadTimeout(final long waitTimeout) {
		this.manage().timeouts().pageLoadTimeout(waitTimeout, TimeUnit.SECONDS);
	}

	/**
	 * Wait the given timeout.<br>
	 * Created by: erwin.graf
	 * 
	 * @param timeout The timeout to wait in seconds
	 * @return The result if timeout has elapsed successfully.
	 */
	public final boolean waitUntilTimeout(final long timeout) {
		boolean timeElapsed = true;
		try {
			Thread.sleep(timeout * ContextBase.MILLI_SECONDS);
		}
		catch (final InterruptedException e) {
			timeElapsed = false;
		}
		return timeElapsed;
	}

	/**
	 * Set value of global.properties (timeout). Without value in global.properties methode use the default value of selenium.
	 * Created by: wolfgang.zander
	 */
	public void setTimeOutValue() {

		final String tim = getContextInformation().getPropertyFromMetaMap("timeout");
		if (StringUtils.isEmpty(tim)) {
			return;
		}
		try {
			final long timeout = Long.parseLong(tim.trim());
			manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		}
		catch (final NumberFormatException ne) {
			ContextBase.LOG.error("Syntax error in parameter timeout set via properties: " + tim, ne);
		}

	}

	/**
	 * Configuration switch for time outs via DSL- Set into global.properties.
	 * 
	 * @return boolean condition
	 */
	public boolean ignoreWaitCondition() {
		final String runWithoutWait = getContextInformation().getPropertyFromMetaMap("runwithoutwait");
		return "true".equals(runWithoutWait);
	}

	/**
	 * Open the page specified by the url.<br>
	 * 
	 * @param url the url to open in browser
	 */
	public void open(final String url) {

		LOG.info(String.format("ContextBase Open : %s", url));
		System.out.println(String.format("ContextBase Open : %s", url));
		
		final String dim = getContextInformation().getPropertyFromMetaMap("windowsize");
		final String pos = getContextInformation().getPropertyFromMetaMap("windowposition");
		if (StringUtils.contains(dim, 'x')) {
			try {
				final int width = Integer.parseInt(dim.substring(0, dim.indexOf('x')).trim());
				final int height = Integer.parseInt(dim.substring(dim.indexOf('x') + 1).trim());
				final int horizontal = Integer.parseInt(pos.substring(0, pos.indexOf('x')).trim());
				final int vertical = Integer.parseInt(pos.substring(pos.indexOf('x') + 1).trim());

				manage().window().setSize(new Dimension(width, height));
				manage().window().setPosition(new Point(horizontal, vertical));
			}
			catch (final NumberFormatException ne) {
				if (dim == null) {
					ContextBase.LOG.error("Syntax error in parameter windowsize (width x height)set via properties: " + dim, ne);
				}
				if (pos == null) {
					ContextBase.LOG.error("Syntax error in parameter windowsize (horizontal x vertical)set via properties: "
							+ pos, ne);
				}
			}
		}

		if (isAbsoluteHttpUrl(url)) {
			try {
				get(url);
			} catch (Exception e) {
				ContextBase.LOG.error("contextbase-open second try : " + url, e);
				get(url);
			}
		}
		else {
			final StringBuffer urlBuffer = new StringBuffer();
			final String startURL = getContextInformation().getMetaMap().get("starturl");

			if (startURL == null) {
				urlBuffer.append(url);
			}
			else {
				final URL startPageUrl = UrlUtils.toUrlSafe(startURL);
				final String urlPathPrefix = startPageUrl.getPath();
				final String currentBrowserUrl = this.getCurrentUrl();
				final URL currentUrl;

				// Make sure we only process valid http(s) URLs - but "special URLs" (like about:blank) are skipped!
				// Needed if given URL by DSL are relative (without domian), like "/myaccount/login". So the startURL for the
				// given country, brand and/or site type will be get from meta map and used for cases like these to open the page
				// with given relative URL.
				if (isAbsoluteHttpUrl(currentBrowserUrl)) {
					currentUrl = UrlUtils.toUrlSafe(currentBrowserUrl);
				}
				else {
					currentUrl = startPageUrl;
				}

				// Build the new URL path (this consists of the prefix - which is something like /ch/de/store/ and the requested
				// url). Also make sure double slashes (one comes from the urlPathPrefix - the second one from the incoming url)
				// are removed.
				final String newUrlPath = StringUtils.replaceOnce(urlPathPrefix + url, "//", "/");

				try {
					urlBuffer.append(UrlUtils.getUrlWithNewPath(currentUrl, newUrlPath).toString());
				}
				catch (final MalformedURLException mue) {
					throw new IllegalArgumentException("Failed to change URL-path of " + currentUrl + " to " + newUrlPath, mue);
				}
			}
			get(urlBuffer.toString());
		}
	}

	private boolean isAbsoluteHttpUrl(final String url) {
		
		return StringUtils.startsWithAny(url, new String[] { "http://", "https://" });
	}

	/**
	 * Report Info for advanced information.<br>
	 * Example for call: //reportInfo("Opend URL: [" + this.getCurrentUrl() + "]");
	 * 
	 * @param value The Reported Info.
	 */
	public void reportInfo(final String value) {
		getContextInformation().getReporterData().get().failed(value, null);
	}

	/**
	 * Find element by testing ID.
	 * 
	 * @param testingId The testing Id given by DSL.
	 * @return element The searched Element.
	 */
	public WebElement findElementByTestingId(final String testingId) {
		return findElementByAttributeId(testingId);
	}

	/**
	 * Find element by Xpath.
	 * 
	 * @param Xpath The testing Id given by DSL.
	 * @return element The searched Element.
	 */
	public WebElement findElementByXpath(final String Xpath) {
		return findElementByXpath(Xpath);
	}

	/**
	 * Selects a option of a drop down menu.
	 * 
	 * @param value The drop down option.
	 * @param select The drop down.
	 */
	public void selectOption(final String value, final WebElement select) {
		final List<WebElement> options = select.findElements(By.tagName("option"));
		for (final WebElement option : options) {
			final String txt = option.getText();
			final String val = option.getAttribute("value");
			if (value.equals(txt) || value.equals(val)) {
				option.click();
			}
		}
	}

	public void selectOption2(final String value, final WebElement select2) {
		final List<WebElement> options = select2.findElements(By.tagName("option"));
		for (final WebElement option : options) {
			final String txt = option.getText();
			final String val = option.getAttribute("value");
			if (value.equals(txt) || value.equals(val)) {
				option.click();
			}
		}
	}

	/**
	 * Workaround for getting Element if is not visible for new Siemens layout.
	 * 
	 * @param select The selected element
	 * @param selection The wanted selection
	 */
	public void formNewLayoutWorkaroundSiemens(final WebElement select, final String selection) {
		// workaround:
		// we have not found the wanted option field to click -> maybe a layout substitute is used (select tag
		// is invisible and a datalist-box is generated dynamically) and shown instead thus we try
		// to find the replacement for the select tag (input field) and for the options (li tag containing a span)

		final WebElement parent = select.findElement(By.xpath(".."));
		final List<WebElement> childElements = parent.findElements(By.cssSelector("input[type=\"text\"]"));
		if (childElements != null && childElements.size() == 1) {
			final WebElement selectReplacement = childElements.get(0);

			if (selectReplacement.getTagName().equals("input")) {
				selectReplacement.click(); // open select replacement (input field of type "text")

				// look for the option replacements anywhere in the page
				final WebElement optionsReplacement = findFormElement(By.className("datalist-box"));
				if (optionsReplacement != null) {
					// look for the option replacemnt field (li tag containing a span with the option text)
					WebElement optionReplacement = optionsReplacement.findElement(By.xpath("//span[text()[contains(.,\""
							+ selection + "\")]]"));
					// at least look directly for the li tag containing the option value within attribute "data-val"
					if (optionReplacement == null) {
						optionReplacement = selectReplacement.findElement(By.cssSelector("li[data-val=\"" + selection + "\"]"));
					}
					if (optionReplacement != null) {
						optionReplacement.click();
						return;
					}
				}
			}
		}
	}

	/**
	 * Workaround for getting Element if is not visible for new Bosch layout.
	 * 
	 * @param select The selected element
	 * @param selection The wanted selection
	 */
	public void formNewLayoutWorkaroundBosch(final WebElement select, final String selection) {
		// workaround:
		// we have not found the wanted option field to click -> maybe a layout substitute is used (select tag
		// is invisible and a datalist-box is generated dynamically) and shown instead thus we try
		// to find the replacement for the select tag (input field) and for the options (li tag containing a span)

		final WebElement parent = select.findElement(By.xpath(".."));
		final WebElement parent2 = parent.findElement(By.xpath(".."));
		final WebElement childElement = parent2.findElement(By.className("selectric"));

		childElement.click(); // open select replacement (input field of type "text")

		// look for the option replacements anywhere in the page
		final WebElement optionsReplacement = findFormElement(By.className("selectricItems"));

		if (optionsReplacement != null) {
			// look for the option replacemnt field (li tag containing a span with the option text)
			final WebElement optionReplacement = optionsReplacement.findElement(By.xpath("//li[text()[contains(.,\"" + selection
					+ "\")]]"));
			if (optionReplacement != null) {
				optionReplacement.click();
				return;
			}

		}
	}

	/**
	 * Find element by dom identifier.
	 * 
	 * @param elementId The identifier of the element
	 * @return the found element or null
	 */
	public WebElement findElementById(final String elementId) {
		return findFormElement(By.id(elementId));
	}

	/**
	 * private WebElement findElementByType(final String attributeType) { return findFormElement(By.cssSelector("input[type=\"" +
	 * attributeType + "\"]")); }
	 **/
	/**
	 * Finds an Element by CSS Selector over Inputs
	 * 
	 * @param attribute Attribute
	 * @param value Value
	 * @return Found Webelement
	 */
	public WebElement findElementByAttributeAndValue(final String attribute, final String value) {
		return findFormElement(By.cssSelector("input[" + attribute + "=\"" + value + "\"]"));
	}
	
	public WebElement findElementByAttributeValue(final String attribute, final String value) {
		return findFormElement(By.cssSelector("[" + attribute + "=\"" + value + "\"]"));
	}

	/**
	 * Finds an Element by CSS Selector over Testing ID
	 * 
	 * @param testingId TestingId
	 * @return Found Webelement
	 */
	public WebElement findElementByAttributeId(final String testingId) {
		return findFormElement(By.cssSelector("[testing_id=\"" + testingId + "\"]"));
	}
	public WebElement findElementByAttributeIdClass(final String testingId) {
		return findFormElement(By.cssSelector("[class=\"" + testingId + "\"]"));
	}

	/**
	 * @param testingType testingType
	 * @return WebElement
	 */
	public WebElement findElementByAttributeType(final String testingType) {
		return findFormElement(By.cssSelector("[testing_type=\"" + testingType + "\"]"));
	}

	/**
	 * Find the input element specified by the attribute name and value.
	 * 
	 * @param attribute The name of the attribute of the element to be find.
	 * @param value The value of the attribute of the element to be find.
	 * @return WebElement (Returns element which was found by value.
	 */
	public WebElement findAttributeByValue(final String attribute, final String value) {
		final WebElement elm = findElementByAttributeAndValue(attribute, value);
		if (elm != null) {
			return elm;
		}
		return null;
	}

	/**
	 * Get a list of all elements rendered on current page via given hidden element and trys to find the visible of it. <br>
	 * Usally the hidden element has only one displayed entity!
	 * 
	 * @param testingID Has to be an testingID
	 * @param elm The hidden element
	 * @return Return true if an element at list is displayed or false if no displayed element was found.
	 */
	public boolean findDuplicatedVisibleElements(final String testingID, final WebElement elm) {
		final String tagName = elm.getTagName();
		List<WebElement> elements = null;
		elements = findElements(By.cssSelector(tagName + "[testing_id=\"" + testingID + "\"]"));

		if (elements.size() >= 1) {
			for (final WebElement element : elements) {
				if (element.isDisplayed()) {
					return true;
				}
			}
		}
		LOG.info(String.format("No displayed element was currently found for %s.", testingID));
		return false;
	}
	
	public WebElement waitForVisibility(By selector, int timeout) {
		WebDriver driver = getDriverProvider().get();
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		WebElement element = null;
		try {
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
		} catch (Exception ex) {

		}
		return element;
	}
	
	public Boolean waitForInvisibility(By selector, int timeout) {
		WebDriver driver = getDriverProvider().get();
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		Boolean invisible = false;
		try {
			invisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(selector));
		} catch (Exception ex) {

		}
		return invisible;
	}
	
	public WebElement waitForClickable(By selector, int timeout) {
		WebDriver driver = getDriverProvider().get();
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		WebElement element = null;
		try {
			element = wait.until(ExpectedConditions.elementToBeClickable(selector));
		} catch (Exception ex) {

		}
		return element;
	}

	public Boolean waitForValue(By selector, String value, int timeout) {
		WebDriver driver = getDriverProvider().get();
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		
		Boolean visible = false;
		try {
			visible = wait.until(new ExpectedCondition<Boolean>() {
			    public Boolean apply(WebDriver driver) {
			        String text = getContextBasedInformations().getTextFromElementBySelector(selector);
			        return value.equals(text);
			    }
			});
		} catch (Exception e) {
		}
		
		return visible;
	}

	/**
	 * Gets the selenium Actions object for drag&drop operations.
	 * 
	 * @return Actions The selenium Actions object
	 */
	@Override
	public final Actions getActions() {
		return new Actions(getKeyboard(), getMouse());
	}

	/**
	 * Gets the contextInformation.
	 * 
	 * @return the contextInformation
	 */
	public final ContextInformation getContextInformation() {
		return getContextInformationProvider().getContextInformation();
	}


	/**
	 * Gets the properties reader.
	 * 
	 * @return the properties reader
	 */
	public final PropertiesReader getPropertiesReader() {
		return propertiesReader;
	}

	/**
	 * Sets the propertiesReader.
	 * 
	 * @param propertiesReaderBean the propertiesReader to set
	 */
	public final void setPropertiesReader(final PropertiesReader propertiesReaderBean) {
		this.propertiesReader = propertiesReaderBean;
	}

	public ContextBasedActions getContextBasedActions() {
		return contextBasedActions;
	}

	public ElementFinder getElementFinder() {
		return elementFinder;
	}

	public void setElementFinder(final ElementFinder elementFinder) {
		this.elementFinder = elementFinder;
	}

	public void setContextBasedActions(final ContextBasedActions contextBasedActions) {
		this.contextBasedActions = contextBasedActions;
	}

	public ContextBasedValidations getContextBasedValidations() {
		return contextBasedValidations;
	}

	public void setContextBasedValidations(final ContextBasedValidations contextBasedValidations) {
		this.contextBasedValidations = contextBasedValidations;
	}

	public ContextBasedInformations getContextBasedInformations() {
		return contextBasedInformations;
	}

	public void setContextBasedInformations(final ContextBasedInformations contextBasedInformations) {
		this.contextBasedInformations = contextBasedInformations;
	}

	/**
	 * TODO Method description
	 * 
	 * @param string
	 * @return
	 */
	public Object GetEval(final String string) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public WebDriverProvider getDriverProvider() {
		return super.getDriverProvider();
	}

	public ContextInformationProvider getContextInformationProvider() {
		return contextInformationProvider;
	}

	public void setContextInformationProvider(ContextInformationProvider contextInformationProvider) {
		this.contextInformationProvider = contextInformationProvider;
	}

}
