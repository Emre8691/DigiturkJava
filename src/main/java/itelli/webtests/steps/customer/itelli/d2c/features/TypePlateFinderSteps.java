package itelli.webtests.steps.customer.itelli.d2c.features;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import itelli.webtests.pages.base.ContextBase;
import itelli.webtests.steps.AbstractSteps;

/**
 * Implements all methods for type plate finder of BSH.
 */
public class TypePlateFinderSteps extends AbstractSteps<ContextBase> {

	/**
	 * Checks if type plate finder is active and opens or close the type plate finder.<br>
	 * Example: When I '{activate|deactivte}' the type plate finder.<br>
	 * 
	 * @param activation The condition which is neede to click.<br>
	 *            Options for condition: "activate", "deactivate".
	 */
	@When("I $activation the type plate finder")
	public void typePlateFinderAction(final String activation) {
		final WebElement btn = getContext().findElementByTestingId("typePlateFinder");
		final String val = btn.getAttribute("aria-expanded");

		if (val.contains("false") && activation.equalsIgnoreCase("activate")) {
			btn.click();
		}
		if (val.contains("true") && activation.equalsIgnoreCase("deactivate")) {
			btn.click();
		}
	}

	/**
	 * Select the purchase date of siemens product registration. When fill in the purchase date 'date'.<br>
	 * TODO: Has to be refactor for generic and exact finding the expected form.<br>
	 * TODO: Has to be select in another method "not send keys" the purchase date options.
	 * 
	 * @param date The purchase date (format depended on country).
	 */
	@When("I enter the purchase date $date")
	public void fillDate(final String date) {
		final WebElement elm = getContext().getElementFinder().findBy("purchaseDate");
		final List<WebElement> forms = elm.findElements(By.cssSelector("input[type=\"text\"]"));
		final WebElement form = forms.get(0);

		form.sendKeys(date);
		getContext().waitUntilTimeout(MAX_TIMEOUT_1_SECOND);
	}

	/**
	 * Enter a  valid purchase date of a product registration. 
	 * When fill in the purchase date 'Today Date'.<br>
	 * 
	 *  
	 * TODO:This DSL is specific to CEW(WarrantyExtension) tests and CSS. development need for make it dynamic.
	 */
	@When("I enter $number days before Today's date as a Purchase date for CEW")
	public void cewDateFill(final int number) {
		final List<WebElement> forms = getContext().findElements(By.cssSelector("input[id=\"purchaseDate\"]"));// elm.findElements(By.cssSelector("input[id=\"purchaseDate\"]"));
		final WebElement form = forms.get(0);
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy ");
		 
		 //get current date time with Date()
		//Date date = new Date();
		Calendar cal = Calendar.getInstance();
		 // Now format the date
		cal.add(Calendar.DATE, -number);
		String date1= dateFormat.format(cal.getTime());
		System.out.println(date1);
	 
		// Send the date date to found textbox(form)
		form.sendKeys(date1);
		//getContext().waitUntilTimeout(MAX_TIMEOUT_1_SECOND);
	}
	
	
	/**
	 * Checks if type plate finder is active or inactive.<br>
	 * Values: active | inactive
	 * 
	 * @param isActive The condition which is neede to click.
	 */
	@Then("the type plate finder is $isActive")
	public void typePlateFinderCheck(final String isActive) {
		getContext().setWaitTimeout(MAX_TIMEOUT_5_SECONDS);
		final WebElement btn = getContext().findElementByTestingId("typePlateFinder");
		final String val = btn.getAttribute("aria-expanded");

		if (isActive.equalsIgnoreCase("active")) {
			Assert.assertTrue("The Type Plate finder is not active!", val.contains("true"));
		}
		if (isActive.equalsIgnoreCase("inactive")) {
			Assert.assertTrue("The Type Plate finder is active!", val.contains("false"));
		}
	}

	/**
	 * Checks if the type plate finder has results.<br>
	 */
	@Then("the type plate finder has results")
	public void checkTypePlateFinderResult() {
		getContext().setWaitTimeout(MAX_TIMEOUT_5_SECONDS);
		final WebElement parent = getContext().getElementFinder().findBy("typePlateInfo");
		final List<WebElement> childs = parent.findElements(By.className("figure"));

		Assert.assertTrue("No elements for category existing!", !childs.isEmpty());
	}
}
