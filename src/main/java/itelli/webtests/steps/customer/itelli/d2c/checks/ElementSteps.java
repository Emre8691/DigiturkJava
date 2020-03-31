package itelli.webtests.steps.customer.itelli.d2c.checks;

import junit.framework.Assert;

import org.jbehave.core.annotations.Then;
import org.openqa.selenium.By;

import itelli.webtests.pages.base.ContextBase;
import itelli.webtests.steps.AbstractSteps;

/**
 * Class explanation Specification: TODO
 */
public class ElementSteps extends AbstractSteps<ContextBase> {

	/**
	 * TODO: REFACTOR SYNTAX Checks the element by given identifier is available in page.<br>
	 * Then the element 'selector' exists on page.<br>
	 * 
	 * @param selector The css selector of the component.
	 */
	@Then(value = "the element $selector exists on page", priority = 1)
	public void checkElementByIdentifierExistsOnPage(final String selector) {
		getContext().setWaitTimeout(MAX_TIMEOUT_10_SECONDS);

		final boolean existsOnPage = getContext().getContextBasedValidations().isNotEmptyElementBySelector(
				By.cssSelector(selector));
		Assert.assertTrue("The element by identifier '" + selector + "' does not exist on page", existsOnPage);
	}

	/**
	 * TODO: REFACTOR SYNTAX Checks the element by given identifier is available in page.<br>
	 * Then the element 'selector' exists on page.<br>
	 * 
	 * @param selector The css selector of the component.
	 */
	@Then(value = "the element $selector not exists on page", priority = 0)
	public void checkElementByIdentifierNotExistsOnPage(final String selector) {
		getContext().setWaitTimeout(MAX_TIMEOUT_10_SECONDS);
		final boolean existsOnPage = getContext().getContextBasedValidations().isNotEmptyElementBySelector(
				By.cssSelector(selector));
		Assert.assertFalse("The element by identifier '" + selector + "' does exist on page", existsOnPage);
	}

	/**
	 * TODO: REFACTOR SYNTAX Checks the element by given class is available in page.<br>
	 * Then the element 'selector' exists on page.<br>
	 * 
	 * @param elementID The css selector of the component.
	 */
	@Then(value = "the $elementID div class exists on page", priority = 1)
	public void checkElementByClassExistsOnPage(final String elementID) {
		getContext().setWaitTimeout(MAX_TIMEOUT_10_SECONDS);

		final boolean existsOnPage = getContext().getContextBasedValidations().isNotEmptyElementBySelector(
				By.cssSelector(("div[class=\"" + elementID + "\"]")));
		Assert.assertTrue("The element by identifier '" + elementID + "' does not exist on page", existsOnPage);
	}

	/**
	 * TODO: REFACTOR SYNTAX Checks the element by given class is available in page.<br>
	 * Then the element via 'tag' and 'attribute' and 'valuePart' should not be visible on page.<br>
	 * 
	 * @param tag like <a,<div,
	 *            <table
	 *            ,<input
	 * @param attribute like title=,id=,name=,class=
	 * @param valuePart like "any content" or "value"
	 */
	@Then(value = "the element via $tag and $attribute and $valuePart should not be visible on page", priority = 1)
	public void checkElementByXpathExistsOnPage(final String tag, final String attribute, final String valuePart) {
		getContext().setWaitTimeout(MAX_TIMEOUT_10_SECONDS);

		final boolean existsOnPage = getContext().getContextBasedValidations().isNotEmptyElementBySelector(
				By.xpath("//" + tag + "[contains(@" + attribute + "," + "\"" + valuePart + "\"" + ")]"));
		if (existsOnPage == false) {
			Assert.assertFalse("The element by identifier '\"" + tag + "\",\"" + attribute + "\",\"" + valuePart
					+ "\' exist on page", existsOnPage);
		}
	}

}
