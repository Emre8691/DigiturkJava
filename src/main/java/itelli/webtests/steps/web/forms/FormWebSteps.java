package itelli.webtests.steps.web.forms;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import itelli.webtests.common.DSLLogConstract;
import itelli.webtests.common.DslHelper;
import itelli.webtests.common.DslLogBeauty;
import itelli.webtests.common.SapExecutionService;
import itelli.webtests.config.WebTestsConfiguration;
import itelli.webtests.domain.ContentElement;
import itelli.webtests.pages.base.ContextBase;
import itelli.webtests.pages.base.ContextBasedActions;
import itelli.webtests.steps.AbstractSteps;

/**
 * Web Application Steps which are useable for form functionalities of webpages.
 */
public class FormWebSteps extends AbstractSteps<ContextBase> {

	private WebTestsConfiguration webTestsConfiguration;

	public WebTestsConfiguration getWebTestsConfiguration() {
		return webTestsConfiguration;
	}

	public void setWebTestsConfiguration(WebTestsConfiguration webTestsConfiguration) {
		this.webTestsConfiguration = webTestsConfiguration;
	}

	/**
	 * Clears the given <tt>html element (form field)</tt>.<br>
	 * 
	 * @see ContextBasedActions#clearFormElement(String)
	 * @param fieldID the element to clear
	 */
	@When("I clear the $fieldID field")
	public final void clearFieldByGivenId(final String fieldID) {
		getContext().getContextBasedActions().clearFormElement(fieldID);
	}

	/**
	 * Clears the given <tt>html element (form field)</tt> by {@link ContentElement}.<br>
	 * 
	 * @see ContextBasedActions#clearFormElement(String)
	 * @param fieldID The field to clear
	 * @param element The{@link ContentElement} for determine the correct field
	 */
	@When("I clear the $fieldID field of type $element")
	public final void clearFieldByGivenIdAndElement(final String fieldID, final ContentElement element) {
		String elementId;
		try {
			elementId = element.getIdentifierFor(fieldID);
			getContext().getContextBasedActions().clearFormElement(elementId);
		} catch (NullPointerException e) {
			DslLogBeauty.logger(DSLLogConstract.ELEMENT_NOT_FOUND, new Object[] { fieldID, "The element " }, new Exception(), FormWebSteps.class);
		}
	}

	/**
	 * Give is the option to setup a form field element with a value.<br>
	 * Directly via testing id or some other html element type (e.g. name, id...).<br>
	 * 
	 * @param value The value (testdata). For loading from properties use the standard expression like <<value>>.
	 * @param fieldID The expected field which will be setup with value. Could be a testing id or some other html element type.
	 * @see #propagateFormFieldWithContentElement(String, String, ContentElement)
	 */
	@When(value = "I enter $value into $fieldID", priority = 0)
	public void propagateFormField(final String value, final String fieldID) {
		genericFillForm(fieldID, value);
	}

	/**
	 * Give is the option to setup a target form field element with a value.<br>
	 * ex: When I enter the TestingTest in 2 nd/th available [name="firstName"]<br>
	 * @param cssField is the CSS of the target element
	 * @param orderindex is the order number of target element
	 * 
	 */
	@When(value = "I enter the $value in $orderindex nd/th available $cssField", priority=0)
	public void propagateVisibleFormField(final String value, final int orderindex, final String cssField) {
		List<WebElement> icons = null;
		try {
			icons = getContext().findElements(By.cssSelector(cssField));
			if (orderindex == 0) {
				icons.get(0).clear();
				icons.get(0).sendKeys(value);
			}
			if (orderindex > 0) {
				icons.get(orderindex - 1).clear();
				icons.get(orderindex - 1).sendKeys(value);
			}
			if (icons == null || icons.isEmpty() || orderindex < 0) {
				Assert.assertNull("Unable to find element \"" + cssField + "\"", icons);
				return;
			}
		} catch (IndexOutOfBoundsException e) {
			DslLogBeauty.logger(DSLLogConstract.MULTI_ELEMENT_NOT_FOUND, new Object[] { orderindex, cssField, "Order Index is too big or Out of index : " + orderindex + " So the element " }, e, FormWebSteps.class);
		}
	}
	
	/**
	 * Give is the option to setup a form field element with a value.<br>
	 * Via testing id or some other html element type (e.g. name, id...), you will get the<br>
	 * identifier of {@link ContentElement} with {@link ContentElement#getIdentifierFor(String)}.
	 */
	@When(value = "I enter $value into the $fieldID field of the $element", priority = 1)
	public void propagateFormFieldWithContentElement(final String value, final String fieldID, final ContentElement element) {
		final String elementId;
		try {
			elementId = element.getIdentifierFor(fieldID);
			genericFillForm(elementId, value);
		} catch (NullPointerException e) {
			DslLogBeauty.logger(DSLLogConstract.ELEMENT_NOT_FOUND, new Object[] { fieldID, "The element " }, e, FormWebSteps.class);
		}
		
	}

	/**
	 * TODO: Has to be check if after JBehave update works with Aliases or Alias priority management as expected.
	 */
	@When(value = "I enter $value into the $fieldID field of the $element form", priority = 2)
	public void propagateFormFieldWithElement(final String value, final String fieldID, final ContentElement element) {
		propagateFormFieldWithContentElement(value, fieldID, element);
	}


	/**
	 * TODO: It is a temporary dsl (Date 22-07-17).
	 */
	@Then(value = "get order number $value")
	public void getOrderNumber(final String value) {
		//String orderNumber = getContext().findElementByGivenAttribute(value).getText();
		//WebElement orderelement = getContext().findElement(By.xpath("//div[contains(@class, 'thank')]/div/h2/text()/substring-after(.,':')"));
		WebElement orderelement = getContext().findElement(By.xpath("//div[contains(@class, 'thank')]/div/h2"));
		String orderNumber = orderelement.getAttribute("innerHTML");
		orderNumber = orderNumber.substring(orderNumber.indexOf(":")+1, orderNumber.indexOf("<")).trim();
		
		String issueKey = DslHelper.extractIssueKey(getContext().getContextInformation().getStoryName());
		//issueId = "TTP-" + StringUtils.substringBetween(issueId, "/TTP-", "_");
		
		try {
			SapExecutionService.addExecutionInfo(orderNumber, issueKey, webTestsConfiguration.getTestedSystem(), true);
		} catch (Exception e) {
			DslLogBeauty.logger(DSLLogConstract.SAP_EXECUTION_INFO_NOT_ADDED, new Object[] { orderNumber, issueKey }, e, FormWebSteps.class);
		}

	}
	
	private void genericFillForm(final String fieldID, final String value) {
		final WebElement elm = getContext().findElementByGivenAttribute(fieldID);
		Assert.assertNotNull(String.format("Web: The web element for attribute '%s' could not be null!", fieldID), elm);
		getContext().fillForm(fieldID, value);
	}
}
