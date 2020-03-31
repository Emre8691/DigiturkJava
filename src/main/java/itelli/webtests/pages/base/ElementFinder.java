package itelli.webtests.pages.base;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import itelli.webtests.common.DSLLogConstract;
import itelli.webtests.common.DslLogBeauty;

/**
 * Helperclass tom find Webelements over CSS Selectors.
 */
public class ElementFinder {

	private ContextBase contextBase;
	private static final Logger LOG = Logger.getLogger(ElementFinder.class);

	private WebElement getElement(final String cssSelector) {
		WebElement findElement = null;
		try {
			findElement = contextBase.findElement(By.cssSelector(cssSelector));
		}
		catch (final Exception e) {
			LOG.debug("");
		}
		return findElement;
	}

	private String getTestingIdSelector(final String attribute) {
		return "[testing_id=\"" + attribute + "\"]";
	}

	private String getIdSelector(final String attribute) {
		return "[id=\"" + attribute + "\"]";
	}

	private String getNameSelector(final String attribute) {
		return "[name=\"" + attribute + "\"]";
	}

	private String getClassSelector(final String attribute) {
		return "[class=\"" + attribute + "\"]";
	}

	private String getTextSelector(final String attribute) {
		return "[text=\"" + attribute + "\"]";
	}

	private String getInputTypeSelector(final String attribute) {
		return "[type=\"" + attribute + "\"]";
	}

	/**
	 * Trys to find the Element by the given Attribute.
	 * 
	 * @param attribute attribute
	 * @return The Found Webelement
	 */
	public WebElement findBy(final String attribute) {

		final List<String> cssSelectors = Arrays.asList(getTestingIdSelector(attribute), getNameSelector(attribute),
				getIdSelector(attribute), getClassSelector(attribute), getInputTypeSelector(attribute),
				getTextSelector(attribute));
		
		//final List<String> cssSelectors = Arrays.asList(getTestingIdSelector(attribute));

		for (final String cssSelector : cssSelectors) {
			final WebElement element = getElement(cssSelector);
			if (element != null) {
				return element;
			}
		}
		
		DslLogBeauty.logger(DSLLogConstract.ELEMENT_NOT_FOUND, new Object[] { attribute, "Page element" }, new Exception(), ElementFinder.class);
		
		return null;
	}

	public WebElement findByAnyAttribute(final String attribute) {

		final List<String> cssSelectors = Arrays.asList(getTestingIdSelector(attribute), getNameSelector(attribute),
				getIdSelector(attribute), getClassSelector(attribute), getInputTypeSelector(attribute),
				getTextSelector(attribute));

		for (final String cssSelector : cssSelectors) {
			final WebElement element = getElement(cssSelector);
			if (element != null) {
				return element;
			}
		}
		
		DslLogBeauty.logger(DSLLogConstract.ELEMENT_NOT_FOUND, new Object[] { attribute, "Page element" }, new Exception(), ElementFinder.class);
		
		return null;
	}

	public ContextBase getContextBase() {
		return contextBase;
	}

	public void setContextBase(final ContextBase contextBase) {
		this.contextBase = contextBase;
	}

}
