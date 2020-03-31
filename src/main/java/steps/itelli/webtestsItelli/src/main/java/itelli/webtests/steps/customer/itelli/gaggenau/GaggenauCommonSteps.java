package itelli.webtests.steps.customer.itelli.gaggenau;

import java.util.ArrayList;
import java.util.List;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import itelli.webtests.pages.base.ContextBase;
import itelli.webtests.steps.AbstractSteps;

/**
 * Class {@link GaggenauCommonSteps} for all Gaggenau forms.
 * 
 * @author bjoern.wedi (created), 22.02.2013
 */
public class GaggenauCommonSteps extends AbstractSteps<ContextBase> {

	private static final int MOVE = 800;

	/**
	 * Fills the <tt>element</tt> with <tt>value</tt>.<br>
	 * <strong>Gaggenau DSL!</strong> Use directly the html elements but works also on testingIds!<br>
	 * 
	 * @see ContextBase#fillFormElementWithoutTestingID(String, String)
	 * @param element the element to fill
	 * @param value the value to set
	 */
	@When(value = "I fill in $element with $value", priority = 0)
	public final void whenIFillFormElement(final String element, final String value) {
		getContext().fillFormElementWithoutTestingID(element, value);
	}

	/**
	 * String When the service link is clicked.<br>
	 * <strong>Gaggenau DSL!</strong> Use directly the html elements but works also on testingIds!<br>
	 * 
	 * @param serviceLink the serviceLink parameter
	 */
	@When("I click on service $servicelink")
	public final void clickService(@Named("servicelink") final String serviceLink) {
		final WebElement btn = getContext().findElement(By.partialLinkText(serviceLink));
		btn.click();
	}

	/**
	 * When the service link is clicked.<br>
	 * <strong>Gaggenau DSL!</strong> Use directly the html elements but works also on testingIds!<br>
	 * 
	 * @param newsletterlink The newsletterlink parameter
	 */
	@When("I click on newsletter $newsletterlink")
	public final void clickNewsletter(@Named("newsletterlink") final String newsletterlink) {
		final WebElement btn = getContext().findElement(By.partialLinkText(newsletterlink));
		btn.click();
	}

	/**
	 * When the '+' expand menu link is clicked. (after a timeout the servicelink disappears and is replaced by a '+' expand link,<br>
	 * thus we try to click this expand button 'blind' at first to ensure servicelink is available).<br>
	 * <strong>Gaggenau DSL!</strong>Goes directly an the elements not on testingIds!<br>
	 */
	@When(value = "I click on service plus sign", priority = 1)
	public final void clickServicePlugSign() {
		try {
			final WebElement btn = getContext().findElement(By.className("expand"));
			if (btn != null) {
				btn.click();
			}
		}
		catch (final NoSuchElementException nse) {
			// this button is optional
			return;
		}
		catch (final ElementNotVisibleException enve) {
			return;
		}
	}

	/**
	 * When the element with caption <tt>elementText</tt> is clicked.<br>
	 * <strong>Gaggenau DSL!</strong> Use directly the html elements but works also on testingIds!<br>
	 * 
	 * @param elementText the elementText value
	 */
	@When("I click on element $elementText")
	public final void clickElement(@Named("elementText") final String elementText) {
		final WebElement btn = getContext().findElement(By.partialLinkText(elementText));
		btn.click();
	}

	/**
	 * When the element with xpath <tt>xpath</tt> is clicked.<br>
	 * <strong>Gaggenau DSL!</strong> Use directly the html elements but works also on testingIds!<br>
	 * 
	 * @param xpath the xpath value
	 */
	@When(value = "I click on element by xpath $xpath", priority = 1)
	public final void clickElementByXPath(@Named("xpath") final String xpath) {
		final WebElement btn = getContext().findElement(By.xpath(xpath));
		btn.click();
	}

	/**
	 * Then element by xpath is shown.<br>
	 * <strong>Gaggenau DSL!</strong> Use directly the html elements but works also on testingIds!<br>
	 * 
	 * @param xpath the expected xpath
	 */
	@Then("the element by xpath $xpath is shown")
	public final void checkXpathIsAvailable(@Named("xpath") final String xpath) {
		final WebElement element = getContext().findElement(By.xpath(xpath));
		Assert.assertNotNull(element);
	}

	/**
	 * Then element by xpath is shown via given tag,attribute and value parameters.<br>
	 * Use directly the html elements but works also on testingIds!<br>
	 * 
	 * @param tag
	 * @param attribute
	 * @param valuePart
	 */
	@Then("the element by $tag and $attribute and $valuePart is shown")
	public final void checkXpathWithParmetersIsAvailable(final String tag, final String attribute, final String valuePart) {
		final WebElement element = getContext().findElement(
				By.xpath("//" + tag + "[contains(@" + attribute + ",'" + valuePart + "')]"));
		Assert.assertNotNull(element);
	}

	/**
	 * Then element by xpath is shown and <strong>has text</strong> via given tag,attribute and value parameters.<br>
	 * Use directly the html elements but works also on testingIds!<br>
	 * 
	 * @param text
	 * @param tag
	 * @param attribute
	 * @param valuePart
	 */
	@Then("the element has $text by $tag and $attribute and $valuePart is shown")
	public final void checkTextViaGivenParmetersIsAvailable(final String text, final String tag, final String attribute,
			final String valuePart) {
		final WebElement element = getContext().findElement(
				By.xpath("//" + tag + "[contains(@" + attribute + "," + valuePart + " and text()=" + text + ")]"));
		Assert.assertNotNull(element);
	}

	
	
	
	
	
	/**
	 * Then the servicelink is hightlighted.<br>
	 * <strong>Gaggenau DSL!</strong> Use directly the html elements but works also on testingIds!<br>
	 * 
	 * @param serviceLink the serviceLink parameter
	 */
	@Then("$servicelink is highlighted")
	public final void checkServiceActive(@Named("servicelink") final String serviceLink) {
		final WebElement serviceNavigation = getContext().findElement(By.id("servicenavi"));
		Assert.assertNotNull("element.id \"servicenavi\" not found", serviceNavigation);
		// Assert.assertNotNull(serviceNavigation.findElement(By.tagName("ul")));
	}

	/**
	 * Then the contectlink is available.<br>
	 * <strong>Gaggenau DSL!</strong> Use directly the html elements but works also on testingIds!<br>
	 * 
	 * @param contactLink the contact link
	 */
	@Then("$contactlink link is available")
	public final void checkAvailableContact(@Named("contactlink") final String contactLink) {
		final WebElement btn = getContext().findElement(By.partialLinkText(contactLink));
		Assert.assertNotNull(btn);
	}

	/**
	 * Then the form is available.<br>
	 * <strong>Gaggenau DSL!</strong> Use directly the html elements but works also on testingIds!<br>
	 * 
	 * @param form the form id
	 */
	@Then("the $form form is available")
	public final void checkFormAvailable(@Named("form") final String form) {
		final WebElement formTag = getContext().findElement(By.xpath("//form[@id=\"" + form + "\"]")
		/* By.id(form).tagName("form") */);
		Assert.assertNotNull(form + "Not found!", formTag);
	}

	/**
	 * Then field with <tt>fieldId</tt> contains <tt>fieldValue</tt>.<br>
	 * <strong>Gaggenau DSL!</strong> Use directly the html elements but works also on testingIds!<br>
	 * 
	 * @param fieldId the field id
	 * @param fieldValue the expected field value
	 */
	@Then("field $fieldId is $fieldValue")
	public final void checkFieldValue(final String fieldId, final String fieldValue) {
		final WebElement input = getContext().findElement(By.id(fieldId));
		Assert.assertNotNull(input);
		Assert.assertEquals(fieldValue, input.getAttribute("value"));

	}

	/**
	 * Then option with value <tt>value</tt> is shown.<br>
	 * <strong>Gaggenau DSL!</strong> Use directly the html elements but works also on testingIds!<br>
	 * 
	 * @param value the expected value
	 */
	@Then("$value option is shown")
	public final void checkOptionAvailable(final String value) {
		final WebElement option = getContext().findElement(By.xpath("//a[text()[contains(.,\"" + value + "\")]]"));
		Assert.assertNotNull(option);
	}

	/**
	 * Then the submit button is disabled.<br>
	 * <strong>Gaggenau DSL!</strong> Use directly the html elements but works also on testingIds!<br>
	 */
	@Then("the submit button is disabled")
	public final void checkSubmitButtonEnabled() {
		final WebElement buttonTag = getContext().findElement(By.xpath("//button[@type=\"submit\"]"));
		Assert.assertNotNull("submit button not found!", buttonTag);
		Assert.assertFalse("button tag is not enabled", buttonTag.isEnabled());
	}

	/**
	 * Then the submit button is enabled.<br>
	 * <strong>Gaggenau DSL!</strong> Use directly the html elements but works also on testingIds!<br>
	 */
	@Then("the submit button is enabled")
	public final void checkSubmitButtonDisabled() {
		final WebElement buttonTag = getContext().findElement(By.xpath("//button[@type=\"submit\"]"));
		Assert.assertNotNull("submit button not found!", buttonTag);
		Assert.assertTrue("button tag is not enabled", buttonTag.isEnabled());
	}

	/**
	 * Then the div <tt>value</tt> is disabled.<br>
	 * <strong>All DSL!</strong> Use directly the html elements but works also on testingIds!<br>
	 * 
	 * @param value the expected value
	 */
	@Then("$value div is disabled")
	public final void checkDivEnabled(final String value) {
		final WebElement divTag = getContext().findElement(By.xpath("//div[class()[contains(.,\"" + value + "\")]]"));
		Assert.assertNotNull("div element not found!", divTag);
		Assert.assertFalse("div tag is not enabled", divTag.isEnabled());
	}

	/**
	 * Then the div <tt>value</tt> is enabled.<br>
	 * <strong>All DSL!</strong> Use directly the html elements but works also on testingIds!<br>
	 * 
	 * @param value the expected value
	 */
	@Then("$value div is enabled")
	public final void checkDivEnaDisabled(final String value) {
		final WebElement divTag = getContext().findElement(By.xpath("//div[class()[contains(.,\"" + value + "\")]]"));
		Assert.assertNotNull("div element not found!", divTag);
		Assert.assertTrue("div tag is not enabled", divTag.isEnabled());
	}

	/**
	 * Then move the slider.<br>
	 * <strong>Gaggenau DSL!</strong> Use directly the html elements but works also on testingIds!<br>
	 */
	@Then("move slider")
	public final void thenMoveSlider() {
		final WebElement slideMe = getContext().findElement(By.xpath("//div[@class=\"bgSlider\"]/div"));
		Assert.assertNotNull(slideMe);
		getContext().getActions().dragAndDropBy(slideMe, GaggenauCommonSteps.MOVE, 0).perform();

	}

	/**
	 * When the checkbox with id <tt>id</tt> is clicked.<br>
	 * <strong>Gaggenau DSL!</strong> Use directly the html elements but works also on testingIds!<br>
	 * 
	 * @param id the HTML id of the checkbox element
	 */
	@When("I click box $id")
	public final void whenIClickBox(final String id) {
		final WebElement elm = getContext().findElement(By.id(id));
		elm.click();
	}

	/**
	 * Check if the specified text is shown.<br>
	 * <strong>Gaggenau DSL!</strong> Use directly the html elements but works also on testingIds!<br>
	 * 
	 * @param text The text is shown on confirmation page.
	 */
	@Then("the text $text is shown")
	public void checkIfTextIsShown(final String text) {
		final int timeout = 10;
		getContext().setWaitTimeout(timeout);
		final WebElement txt = getContext().findElement(By.xpath("//*[text()[contains(.,\"" + text + "\")]]"));
		Assert.assertNotNull(txt);
	}

	/**
	 * Check if the specified text is shown in "p" tag in HTML<br>
	 * <strong>Gaggenau DSL!</strong> Use directly the html elements but works also on testingIds!<br>
	 * 
	 * @param text The text is shown on any page.
	 */

	@Then("the text $text is shown in paragraph")
	public void checkIfTextIsShowninp(final String text) {
		final int timeout = 10;
		getContext().setWaitTimeout(timeout);
		final WebElement txt = getContext().findElement(By.xpath("//p[text()[contains(.,\"" + text + "\")]]"));
		Assert.assertNotNull(txt);
	}

	/**
	 * Check if an URLPart is shown in "a" tag in HTML<br>
	 * 
	 * @param urlPart is shown on any page in a tag's href part.
	 */

	@Then("the link contains $urlPart")
	public void checkIfUrlpartHasLink(final String urlPart) {
		final int timeout = 10;
		getContext().setWaitTimeout(timeout);
		final WebElement txt = getContext().findElement(By.xpath("//a[contains(@href,\"" + urlPart + "\")]"));
		Assert.assertNotNull(txt);
	}

}
