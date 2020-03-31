package itelli.webtests.steps.web.alerts;

import java.util.List;

import org.apache.log4j.Logger;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import itelli.webtests.pages.base.ContextBase;
import itelli.webtests.steps.AbstractSteps;

public class ExtendedDSL extends AbstractSteps<ContextBase> {

	private static final Logger LOG = Logger.getLogger(AlertWebSteps.class);
	int teasersize = 0;
	boolean scrollmore = true;

	/**
	 * @param elementID div class of the component.
	 */
	@Then(value = "the $elementID div class exists on page and get first div link", priority = 1)
	public void getElementByClassFirstClass(final String elementID) {
		this.sleep(5);
		final List<WebElement> products_list = getContext().findElements(By.cssSelector(("div[class=\"" + elementID + "\"]")));
		for (final WebElement product_list : products_list) {
			final List<WebElement> teasers_list = product_list.findElements(By.cssSelector(("div[class=\"" + "teaser product"
					+ "\"]")));
			// System.out.println(teasers_list.size());
			teasers_list.get(0).findElement(By.xpath("//a[contains(@href,\"" + "dealerlist" + "\")]")).click();
		}
		// Assert.assertFalse("The element by identifier '" + elementID + "' does exist on page", existsOnPage);
	}

	/**
	 * @param elementID div class of the component.
	 */
	@Then(value = "the $elementID div class exists on page and get div count", priority = 1)
	public void getElementByClassAndCount(final String elementID) {
		this.sleep(5);
		final List<WebElement> products_list = getContext().findElements(By.cssSelector(("div[class=\"" + elementID + "\"]")));
		for (final WebElement product_list : products_list) {

			final List<WebElement> teasers_list = product_list.findElements(By.cssSelector(("div[class=\"" + "teaser product"
					+ "\"]")));
			// System.out.println(teasers_list.size());
			if (teasers_list.size() > teasersize) {
				teasersize = teasers_list.size();
				scrollmore = true;
			}
			else {
				scrollmore = false;
			}

		}
		// Assert.assertFalse("The element by identifier '" + elementID + "' does exist on page", existsOnPage);
	}

	/**
	 * @param elementID filter div class of the component.
	 */
	@Then(value = "the $elementID  div class filter exists on page", priority = 1)
	public void getElementByFilterClass(final String elementID) {
		// this.sleep(5);
		final List<WebElement> filter_groups = getContext().findElements(By.cssSelector(("div[class=\"" + elementID + "\"]")));
		for (final WebElement filter_box : filter_groups) {
			final List<WebElement> teasers_list = filter_box
					.findElements(By.cssSelector(("div[class=\"" + "filter-box" + "\"]")));
			// System.out.println(teasers_list.size());
		}
		// Assert.assertFalse("The element by identifier '" + elementID + "' does exist on page", existsOnPage);
	}

	/**
	 * @param elementID filter div class of the component.
	 */
	@When(value = "I click filter $index1 and $index2 with $elementID", priority = 1)
	public void getElementByFilterClass(final int index1, final int index2, final String elementID) {
		String filtercount = "";
		String headcount = "";
		// TODO: Write with xpath,"js-expanded" might be usefull
		final List<WebElement> filter_groups = getContext().findElements(By.cssSelector(("div[class=\"" + elementID + "\"]")));
		for (final WebElement filter_group : filter_groups) {

			final List<WebElement> filter_boxlist = filter_group.findElements(By.cssSelector(("div[class=\"" + "filter-box"
					+ "\"]")));
			// System.out.println("filter box count" + filter_boxlist.size());
			final WebElement fbox = filter_boxlist.get(index1).findElement(By.className("box-box"));
			final WebElement ul = fbox.findElement(By.className("js-expanded"));
			// System.out.println("ul ye reach olduk mu" + " tagname" + ul.getTagName() + "text" + ul.getText() );
			final List<WebElement> lilist = ul.findElements(By.tagName("label"));
			// System.out.println("lets see how many in the ul" + lilist.size());
			// System.out.println("li ye reach olduk mu" + " tagname" + lilist.get(index2).getTagName() + "text" +
			// lilist.get(index2).getText() );

			lilist.get(index2).click();
			this.sleep(5);
			filtercount = lilist.get(index2).getText();
			filtercount = filtercount.substring(filtercount.indexOf("(") + 1, filtercount.indexOf(")"));

		}
		this.sleep(5);
		final WebElement head = getContext().findElement(By.cssSelector(("div[class=\"" + "overview-head" + "\"]")));
		final WebElement heada = head.findElement(By.tagName("strong"));
		// System.out.println("strong text" + heada.getTagName() + heada.getText());
		headcount = heada.getText();

		doScrollDown("items-area-inner product-list");
		// System.out.println("BCompare 3 values for head count, filter count, body teaser count:" + headcount + filtercount +
		// teasersize);
		boolean assertfalse = false;

		if (Integer.parseInt(headcount) != Integer.parseInt(filtercount) || Integer.parseInt(filtercount) != teasersize) {
			// System.out.println("Compare 3 values for head count, filter count, body teaser count:" + headcount + filtercount +
			// teasersize);
			assertfalse = false;
		}
		Assert.assertFalse("The element by identifier '" + elementID + "' does exist on page", assertfalse);
	}

	/**
	 * TODO: Filter part is quite different than Siemens. For now, have another method for bosch. Later on combine Siemens and
	 * Bosch method together if can. Also not completed yet, as it takes alot of time to complete, will finish rest later
	 * 
	 * @param elementID filter div class of the component.
	 */
	@When(value = "I click bosch filter $index1 and $index2 with $elementID", priority = 1)
	public void getElementByFilterClassForBosch(final int index1, final int index2, final String elementID) {
		// final String filtercount = "";
		// final String headcount = "";
		final List<WebElement> checkbox_filter = getContext().findElements(By.cssSelector(("li[class=\"" + elementID + "\"]")));
		// System.out.println("filter size" + checkbox_filter.size());
		final WebElement cat_element = checkbox_filter.get(index1).findElement(By.id("cat_id_0_0"));
		// System.out.println("tag: " + cat_element.getTagName() + " text: " + cat_element.getText());
		cat_element.click();

	}

	/**
	 * Checks if the new layout is active.
	 */
	@Then("the popup was closed successful")
	public void checkPopupClosedSuccessfully() {

		final boolean popupVisible = getContext().findElementByXpath("//div[]@class='dialog-box'") != null;
		if (popupVisible) {
			getContext().findElementByXpath("//button[@class='close-btn']").click();
		}
	}

	/**
	 * Press ScrollDown to bottom of page<br>
	 */
	@When("I scrolldown the bottom of page and $elementID div class count")
	public void doScrollDown(final String elementID) {
		teasersize = 0;
		try {
			getContext()
			// .executeScript("var body = document.body,html document.documentElement;var height = Math.max( body.scrollHeight,body.offsetHeight,html.clientHeight, html.scrollHeight, html.offsetHeight );         window.scrollBy(0,height)");
			// .executeScript("scrollTo(0, document.body.scrollHeight)");
					.executeScript("scrollTo(0,15000)");
			getElementByClassAndCount(elementID);
			while (scrollmore == true) {
				getContext().executeScript("scrollTo(0,15000)");
				getElementByClassAndCount(elementID);
			}
		}
		catch (final Exception e) {
			LOG.error("The scroll down to the bottom of page couldn´t be done!", e);
		}
	}

	public void makeTabAvailableInternal(final String tabName) throws InterruptedException {
		final WebElement tabelement = getContext().findElement(By.xpath("//*[@id=\"" + tabName + "\"]"));
		getContext().executeScript("arguments[0].setAttribute('style', 'visibility: visible; display: block;')", tabelement);
	}

	/**
	 * Delete Account DSL
	 */
	@When("I delete account via $elementID")
	public void deleteAccount(final String elementID) throws InterruptedException {
		final WebElement elm = getContext().findElementByGivenAttribute(elementID);
		// Assert.assertNotNull(String.format("Web: Could not find clickable element: '%s'", elementID), elm);
		elm.click();
		final boolean existsOnPage = getContext().getContextBasedValidations().isElementByAttributeIdAvailable(
				"erroruserdoesnotexist");
		// Assert.assertTrue("The component named by " + "erroruserdoesnotexist" + " does not exist on page", existsOnPage);

		// TODO:Implement case for:
		// "<span class="ValidationError"> Your account has not been activated yet. Please confirm your registration.</span>"
		// In case of lock situation backup mail used

		// System.out.println("existsOnPage" + existsOnPage);
		if (existsOnPage) {
			// then do nothing
			// System.out.println("account already deleted or not exists");
		}
		else {
			makeTabAvailableInternal("tab4");
			final WebElement elmx = getContext().findElementByGivenAttribute("deleteAccountLink");
			Assert.assertNotNull(String.format("Web: Could not find clickable element: '%s'", "deleteAccountLink"), elmx);
			elmx.click();
			sleep(1);
			try {
				final Alert alert = getContext().switchTo().alert();
				if (alert != null) {
					alert.accept();
				}
			}
			catch (final Exception e) {
				LOG.error("The alert box couldn´t be confirmed!", e);
			}
			sleep(5);
			try {
				final Alert alert = getContext().switchTo().alert();
				if (alert != null) {
					alert.accept();
				}
			}
			catch (final Exception e) {
				LOG.error("The alert box couldn´t be confirmed!", e);
			}
			sleep(3);

		}
	}

	public void sleep(final int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		}
		catch (final InterruptedException e) {

		}
	}

	/*
	 * public void RecursiveLinkTest() { //list to save visited links final List<String> linkAlreadyVisited = new
	 * ArrayList<String>(); WebDriver driver; public RecursiveLinkTest(WebDriver driver) { this.getContext() = driver; } public
	 * void linkTest() { // loop over all the a elements in the page for(WebElement link :
	 * getContext().findElements(By.tagName("a"))) { // Check if link is displayed and not previously visited if
	 * (link.isDisplayed() && !linkAlreadyVisited.contains(link.getText())) { // add link to list of links already visited
	 * linkAlreadyVisited.add(link.getText()); System.out.println(link.getText()); // click on the link. This opens a new page
	 * link.click(); // call recursiveLinkTest on the new page new RecursiveLinkTest(driver).linkTest(); } }
	 * driver.navigate().back(); } public static void main(String[] args) throws InterruptedException { WebDriver driver = new
	 * FirefoxDriver(); driver.get("http://newtours.demoaut.com/"); // start recursive linkText new
	 * RecursiveLinkTest(driver).linkTest(); } }
	 */

}
