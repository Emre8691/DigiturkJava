package itelli.webtests.steps.customer.itelli.d2c.actions;

import org.jbehave.core.annotations.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import itelli.webtests.pages.base.ContextBase;
import itelli.webtests.steps.AbstractSteps;

/**
 * DSL providing actions for basket.
 */

public class BasketSteps extends AbstractSteps<ContextBase> {

	/**
	 * Checks if the basket count is as given.<br>
	 * 
	 * @param basketcount The count of basket entry could be a number starting by 1, for 0 enter "empty" to DSL.
	 */
	@Then(value = "the basket count is $basketcount", priority = 0)
	public void checkBasketCount(final String basketcount) {
		String count = basketcount;

		if (getContext().getCurrentUrl().toString().contains("bosch")) {
			if (count.equalsIgnoreCase("empty")) {
				count = "0";
			}
			Assert.assertEquals("The current basket count is not as given ", count, getContext().getContextBasedInformations()
					.getCartCountOfCurrentPageForBosch());
		}
		else {
			if (count.equalsIgnoreCase("empty")) {
				count = "";
			}

			Assert.assertEquals("The current basket count is not as given ", count, getContext().getContextBasedInformations()
					.getCartCountOfCurrentPage());
		}
	}

	@Then(value = "I wait for the basket count is $basketcount", priority = 0)
	public void waitBasketCount(final String basketcount) {
		String count = basketcount;
		
		Boolean status = getContext().waitForValue(By.xpath("//span[contains(@class,\"count-indicator\")]"), basketcount, MAX_TIMEOUT_5_SECONDS);
		Assert.assertTrue("The current basket count is not as given : " + count , status);
	
	}

	/**
	 * Checks if the basket count is as expected.<br>
	 * TODO: Has to be check if works correct.
	 */
	@Then(value = "the basket count is as expected", priority = 1)
	public void checkBasketCount() {
		final String basketcount = getContext().getParameterForScenario("basketcount");
		Assert.assertEquals("The current basket count is not as expected ", basketcount, getContext()
				.getContextBasedInformations().getCartCountOfCurrentPage());
	}

	@Then(value = "the basket count is changed", priority = 1)
	public void checkBasketCountChanged() {
		final String basketcount = getContext().getContextInformation().getPropertyFromMetaMap("currentBasketCount");
		Assert.assertNotEquals("The current basket count is not changed ", basketcount, 
				getContext().getContextBasedInformations().getCartCountOfCurrentPageForBosch());
	}

	/**
	 * Checks if the status of itemWasAdded in the current page is true.<br>
	 * Used for old layout. Has to be check if itemWasAdded exist on new layouts?
	 * 
	 * @param wait The wait time in seconds for adding the item to the basket.
	 */
	@Then("the product was added to basket within $wait {second|seconds}")
	public void checkItemWasAddedStatus(final long wait) {
		Assert.assertEquals("The itemWasAdded status of the current page does not match!", "true", getContext()
				.getContextBasedInformations().getItemWasAddedStatusOfCurrentPage(wait));
	}
}
