package itelli.webtests.steps.customer.itelli.d2c.actions;

import java.util.List;

import org.apache.log4j.Logger;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import itelli.webtests.common.DSLLogConstract;
import itelli.webtests.common.DslLogBeauty;
import itelli.webtests.domain.PageElement;
import itelli.webtests.pages.base.ContextBase;
import itelli.webtests.steps.AbstractSteps;
import itelli.webtests.steps.customer.itelli.system.PageSteps;

/**
 * DSL providing product actions.
 */
public class ProductExecuterSteps extends AbstractSteps<ContextBase> {
	
	private static final Logger logger = Logger.getLogger(ContextBase.class);
	private PageElement pageElement = new PageElement();

	/**
	 * Add the given product to the basket.<br>
	 * 
	 * @param productcode The product code to add to the basket.
	 */
	@When(value = "I add the product $productcode to basket", priority = 1)
	public void addTheGivenProductToBasket(final String productcode) {

		final WebElement elm = getContext().findElementByGivenAttribute("addItemToBasket-" + productcode);

		getContext().getContextBasedActions().clickByGivenAttribute("addItemToBasket-" + productcode);
		getContext().increaseParameterForScenario("basketcount");

		Assert.assertNotNull("The product which will be add to basket is not the expected! Found element: '" + elm
				+ "' for given attribute '" + productcode + "'!", elm);
	}

	/**
	 * Checks which product is given and add this to the basket.<br>
	 * Old layout.
	 */
	@When(value = "I add to basket for SIEMENS the first available product via $tag and $attribute and $valuePart")
	public void addTheProductOfPageToBasket(String tag, String attribute, String valuePart) {
		List<WebElement> icons = null;
		try {
			icons = getContext().findElements(By.xpath("//" + tag + "[contains(@" + attribute + "," + "\"" + valuePart + "\"" + ")]"));
			
			int orderindex = 0;
			while ( !icons.get(orderindex).isEnabled() && orderindex < 20 ) {
				orderindex++;
			}
			icons.get(orderindex).click();
			WebElement elem = getContext().findElement(By.cssSelector(tag + "[" + attribute + "=\"" + valuePart + "\"]" ));
			pageElement.setValue(elem.getAttribute("value"));
			if (icons == null || icons.isEmpty() || orderindex < 0) {
				logger.error("Unable to find navigation element \"" + tag + "\",\"" + attribute + "\",\"" + valuePart + "\"!");
				return;
			}
		} catch (Exception e) {
			DslLogBeauty.logger(DSLLogConstract.WITHOUT_PARAMATER, new Object[] { "There are any available attribute/parameter. " }, new Exception(), ProductExecuterSteps.class);
		}
	}
	
	/**
	 * Check added the product in the basket (For SIEMENS)
	 * This method needed to addTheProductOfPageToBasket method
	 */
	@Then("the added $nameValue is correct for SIEMENS")
	public void checkPageIsOpened( String nameValue ) {
		try {
			WebElement elem = getContext().findFormElement(By.name(nameValue));
			if (elem.getAttribute("value").equals(pageElement.getValue())) {
				Assert.assertEquals("The value of add basket are the same", elem.getAttribute("value"), pageElement.getValue());
			} else {
				DslLogBeauty.logger(DSLLogConstract.ELEMENT_NOT_EQUALS, new Object[] {elem.getAttribute("value"),pageElement.getValue(),  "Page block" }, new Exception(), PageSteps.class);
			}
		} catch (Exception e) {
			DslLogBeauty.logger(DSLLogConstract.PAGE_NOT_FOUND, new Object[] { "Page block" }, e, PageSteps.class);
		}
	}
	
	/**
	 * Remove the given product entry from basket.
	 * 
	 * @param productcode The product code of basket entry which has to be delete from the basket.
	 */
	@When(value = "I remove the product entry of product $productcode from basket", priority = 1)
	public void removeTheGivenProductFromBasket(final String productcode) {

		final WebElement elm = getContext().findElementByGivenAttribute("removeEntry-" + productcode);
		getContext().getContextBasedActions().clickByGivenAttribute("removeEntry-" + productcode);
		getContext().decreaseParameterForScenario("basketcount");

		Assert.assertNotNull(
				String.format(
						"The product which will be delete from basket is not the expected! Found element: '%s' for given attribute '%s'!",
						elm, productcode), elm);
	}

	/**
	 * Increase the quantity of the product for adding to the basket.<br>
	 * Old layout.
	 */
	@When("I increase the quantity of the product")
	public void increaseQuantityProductDetailPage() {
		final String shownProduct = getContext().getContextBasedInformations().getProductCodeOfCurrentPage();
		getContext().getContextBasedActions().clickByGivenAttribute("quantityplus-" + shownProduct);
	}

	/**
	 * Decrease the quantity of the product for adding to the basket.<br>
	 * Old layout.
	 */
	@When("I decrease the quantity of the product")
	public void decreaseQuantityProductDetailPage() {
		final String shownProduct = getContext().getContextBasedInformations().getTextFromElementByAttributeId("productcode");
		getContext().getContextBasedActions().clickByGivenAttribute("quantityminus-" + shownProduct);
	}
}
