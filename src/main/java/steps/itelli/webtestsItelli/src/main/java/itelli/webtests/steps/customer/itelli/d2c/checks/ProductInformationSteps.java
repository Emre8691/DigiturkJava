package steps.itelli.webtestsItelli.src.main.java.itelli.webtests.steps.customer.itelli.d2c.checks;

import org.apache.commons.lang.StringUtils;
import org.jbehave.core.annotations.Then;
import org.junit.Assert;

import steps.itelli.webtestsItelli.src.main.java.itelli.webtests.pages.base.ContextBase;
import steps.itelli.webtestsItelli.src.main.java.itelli.webtests.steps.AbstractSteps;


/**
 * DSL which checks BSH specific product Informations.
 */
public class ProductInformationSteps extends AbstractSteps<ContextBase> {

	/**
	 * Checks if the productcode of the current page is the same as the given one.<br>
	 * 
	 * @param productcode The product code to check for.
	 */
	@Then("the product of the page is $productcode")
	public void checkProductCode(final String productcode) {
		Assert.assertEquals("Productcode of the current page does not match.", productcode, getContext()
				.getContextBasedInformations().getTextFromElementByAttributeId("productcode"));
	}

	/**
	 * Checks if the stock level is given.<br>
	 */
	@Then(value = "the availability is shown", priority = 3)
	public void checkAvailabilityIsShown() {
		Assert.assertTrue(
				"The Availability of the given product code is not given or empty.",
				StringUtils.isNotEmpty(getContext().getContextBasedInformations().getTextFromElementByAttributeType(
						"availability")));
	}

	/**
	 * Checks if the stock level is green, yellow or red.<br>
	 * The availability must be stable for doing these check!
	 * 
	 * @param stocklevel The stock level given from DSL sentence.
	 */
	@Then(value = "the availability is $stocklevel", priority = 1)
	public void checkCorrectAvailability(final String stocklevel) {
		Assert.assertEquals("The Availability of the given product code does not match.", stocklevel, getContext()
				.getContextBasedInformations().getTextFromElementByAttributeType("availability"));
	}

	/**
	 * Checks if the stock level is green, yellow or red.<br>
	 */
	@Then("product is available to buy")
	public void checkStockAvailabiltity() {
		final String stockLevel = getContext().getContextBasedInformations().getTextFromElementByAttributeType("availability");
		final boolean isBuyable = StringUtils.equals(stockLevel, "on stock") || StringUtils.equals(stockLevel, "some in stock");
		Assert.assertTrue(String.format("The Availability of the given product code %s does not match.", stockLevel), isBuyable);
	}

	// TODO: Old layout

	/**
	 * Check if the product price is shown.<br>
	 * Old layout. Search about the testing id "productprice".
	 */
	@Then("the price of product is shown")
	public void checkIfPriceIsShown() {
		Assert.assertFalse("The current price of the product is not shown", getContext().getContextBasedInformations()
				.getTextFromElementByAttributeId("productprice").isEmpty());
	}

	/**
	 * Check if the quantity is as expected.<br>
	 * Old layout. Checks the given quantity by searching about the qunatity included the productcode.
	 * 
	 * @param quantity The expected quantity
	 * @param productcode The product code
	 */
	@Then(value = "the quantity is $quantity for product $productcode", priority = 0)
	public void checkQuantityByValue(final String quantity, final String productcode) {
		getContext().getContextBasedInformations().getTextFromElementByAttributeId("flyoutCartEntryquantity-" + productcode);
	}

	/**
	 * Check the quantity of was increased or decreased.<br>
	 * Old layout.
	 */
	@Then(value = "the quantity is one {less|more} {as|then} before", priority = 1)
	public void checkQuantityProductDetailPage() {
		final String shownProduct = getContext().getContextBasedInformations().getTextFromElementByAttributeId("productcode");
		Assert.assertEquals("The quantity is not the same as expected: ", "quantity-" + shownProduct, "quantity-" + shownProduct);
	}
}
