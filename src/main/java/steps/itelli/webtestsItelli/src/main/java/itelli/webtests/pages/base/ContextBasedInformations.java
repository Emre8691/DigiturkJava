package steps.itelli.webtestsItelli.src.main.java.itelli.webtests.pages.base;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * 
 */
public class ContextBasedInformations {

	private ContextBase contextBase;

	/**
	 * Get content of form element the given <tt>element</tt>.<br/>
	 * <br/>
	 * 
	 * @param element the element to get input value
	 * @return form element wich expacted by cssSelector testing id
	 */
	public final String getFormElementValue(final String element) {
		return contextBase.findFormElement(By.cssSelector("[testing_id=\"" + element + "\"]")).getAttribute("value");
	}

	/**
	 * Get value of named element the given <tt>element</tt>.<br/>
	 * <br/>
	 * 
	 * @param element the element to get input value
	 * @return named element which expacted by cssSelector name
	 */
	public final String getElementValue(final String element) {
		return contextBase.findFormElement(By.cssSelector("[name=\"" + element + "\"]")).getAttribute("value").toString();
	}

	/**
	 * Get the value by element <tt>id</tt>.<br/>
	 * 
	 * @param id the element to get input value
	 * @return element expected attribute by value
	 */

	public final String getFormElementValueById(final String id) {
		final WebElement input = contextBase.findElement(By.id(id));
		return input.getAttribute("value");
	}

	/**
	 * Get the value by element <tt>id</tt> or if not found by <tt>name</tt>.<br/>
	 * 
	 * @param id the identifier or name of the element to get input value
	 * @return expected attribute by value
	 */

	public final String getFormElementValueByIdOrByName(final String id) {
		final WebElement input = contextBase.getElementFinder().findBy(id);
		if (input == null) {
			return StringUtils.EMPTY;
		}
		return input.getAttribute("value");
	}

	/**
	 * Get the basketCount context information of the current site.<br>
	 * Created by: erwin.graf
	 * 
	 * @return The basketCount context string included in the current page.
	 */
	public final String getCartCountOfCurrentPage() {
		return getTextFromElementByAttributeId("basketcount");
	}

	public final String getCartCountOfCurrentPageForBosch() {
		String result = getTextFromElementByAttributeIdClass("count-indicator");
		if (result.isEmpty()) {
			result = getTextFromElementByAttributeIdClass("basket-count");
		}
		return result;
	}

	/**
	 * Gets any text from the element specified by the tag attribute named testing_id.
	 * 
	 * @param testingId The tag attribute of the element
	 * @return text The text of the element
	 */
	public String getTextFromElementByAttributeId(final String testingId) {
		final WebElement element = contextBase.findElementByAttributeId(testingId);
		if (element == null) {
			return StringUtils.EMPTY;
		}
		return getTextFromElement(element);
	}

	/**
	 * Gets any text from the element specified by the tag attribute named testing_id.
	 * 
	 * @param testingId The tag attribute of the element
	 * @return text The text of the element
	 */
	public String getTextFromElementByAttributeIdClass(final String testingId) {
		final WebElement element = contextBase.findElementByAttributeIdClass(testingId);
		if (element == null) {
			return StringUtils.EMPTY;
		}
		return getTextFromElement(element);
	}

	private String getTextFromElement(final WebElement element) {
		final String text = element.getText();
		if (StringUtils.isEmpty(text) && !element.isDisplayed()) {
			// workaround: since selenium version > 2.35 elements placed off-screen (f.e. by position:absolute;left:-10000px;)
			// are not readable anymore, so we must get the innerHTML via javascript
			return (String) contextBase.executeScript("return arguments[0].innerHTML", element);
		}
		return text;
	}

	private String getLocaleFromHtmlTag() {
		final WebElement element = contextBase.findFormElement(By.cssSelector("html"));
		if (element == null) {
			return StringUtils.EMPTY;
		}
		return StringUtils.defaultString(element.getAttribute("lang")).replace('-', ContextBase.LOCALE_SEPARATOR);
	}

	private String getLocaleFromMetaTag() {
		final WebElement element = contextBase.findFormElement(By.cssSelector("meta[property=\"og:locale\"]"));
		if (element == null) {
			return StringUtils.EMPTY;
		}
		return StringUtils.defaultString(element.getAttribute("content")).replace('-', ContextBase.LOCALE_SEPARATOR);
	}

	/**
	 * Get the brand context information of the current site.<br>
	 * Created by: stefan.person
	 * 
	 * @return The brand context string included in the current page.
	 */
	public final String getBrandOfCurrentPage() {
		return getTextFromElementByAttributeId("test_context_brand");
	}

	/**
	 * Get the country context information of the current site.<br>
	 * Created by: stefan.person
	 * 
	 * @return The country context string included in the current page.
	 */
	public final String getCountrySelection() {
		contextBase.setTimeOutValue();

		WebElement element = contextBase.findElement(By.className("country_selector_switch"));
		element = element.findElement(By.tagName("span"));
		return getTextFromElement(element);
	}

	/**
	 * Get the country context information of the current site.<br>
	 * Created by: stefan.person
	 * 
	 * @return The country context string included in the current page.
	 */
	public final String getCountryOfCurrentPage() {
		return getTextFromElementByAttributeId("test_context_country");
	}

	/**
	 * Get the language context information of the current site.<br>
	 * Created by: stefan.person
	 * 
	 * @return The language context string included in the current page.
	 */
	public final String getLanguageOfCurrentPage() {
		String locale = getLocaleFromHtmlTag();
		if (locale.isEmpty()) {
			locale = getLocaleFromMetaTag();
		}
		if (locale.indexOf(ContextBase.LOCALE_SEPARATOR) > 0) {
			return locale.substring(0, locale.indexOf(ContextBase.LOCALE_SEPARATOR));
		}
		return locale;
	}

	/**
	 * Get the siteType context information of the current site.<br>
	 * Created by: stefan.person
	 * 
	 * @return The siteType context string included in the current page.
	 */
	public final String getSiteTypeOfCurrentPage() {
		return getTextFromElementByAttributeId("test_context_sitetype");
	}

	/**
	 * Get the productcode context information of the current site.<br>
	 * Created by: erwin.graf
	 * 
	 * @return The productcode context string included in the current page.
	 */
	public final String getProductCodeOfCurrentPage() {
		return getTextFromElementByAttributeId("productcode");
	}

	/**
	 * Get the pageId context information of the current site.<br>
	 * Created by: erwin.graf
	 * 
	 * @return The pageid context string included in the current page.
	 */
	public final String getPageIdOfCurrentPage() {
		contextBase.setTimeOutValue();

		return getTextFromElementByAttributeId("test_context_pageId");
	}
	
	public final String getGoogleIdOfCurrentPage() {
		contextBase.setTimeOutValue();
		return contextBase.findJsVariable("wa.pagename");
	}

	/**
	 * Get the itemWasAdded statis information of the current site.<br>
	 * Created by: erwin.graf TODO: Needed to refactor
	 * 
	 * @param wait The max. timeout for waiting status is available (added via ajax request)
	 * @return The itemWasAdded status string included in the current page.
	 */
	public final String getItemWasAddedStatusOfCurrentPage(final long wait) {

		contextBase.setWaitTimeout(wait);

		return getTextFromElementByAttributeId("itemWasAdded");
	}

	/**
	 * Get the list of content for a given testing_type selector.<br>
	 * Created by: erwin.graf
	 * 
	 * @param testingType The attribute type of the element
	 * @return contentlist The list of found testing identifiers
	 */
	public final List<String> getContentByTestingType(final String testingType) {
		final List<String> contentlist = new ArrayList<String>();
		final List<WebElement> elements = contextBase.findElements(By.cssSelector("[testing_type=\"" + testingType + "\"]"));
		if (elements != null) {
			for (final WebElement element : elements) {
				final String content = element.getText();
				if (content != null) {
					// check additional if there exists a sibling element containing the product details
					final WebElement parent = element.findElement(By.xpath(".."));
					final List<WebElement> childElements = parent.findElements(By.xpath("*"));
					if (childElements != null && childElements.size() > 1) {
						contentlist.add(content);
					}
				}
			}
		}
		return contentlist;
	}

	/**
	 * Gets any text from the element specified by a tag identifier.
	 * 
	 * @param bySelector the {@link By} to use for detection
	 * @return text The text of the element
	 */
	public String getTextFromElementBySelector(final By bySelector) {
		final WebElement element = contextBase.findElement(bySelector);
		if (element == null) {
			return StringUtils.EMPTY;
		}
		return getTextFromElement(element);
	}

	/**
	 * Gets any text from the element specified by a tag attribute named testing_type.<br>
	 * (this assumes that only one tag with specified testing_type exists on page)
	 * 
	 * @param testingType The tag attribute of the element
	 * @return text The text of the element
	 */
	public final String getTextFromElementByAttributeType(final String testingType) {
		final WebElement element = contextBase.findElementByAttributeType(testingType);
		if (element == null) {
			return StringUtils.EMPTY;
		}
		return getTextFromElement(element);
	}

	public ContextBase getContextBase() {
		return contextBase;
	}

	public void setContextBase(final ContextBase contextBase) {
		this.contextBase = contextBase;
	}

}
