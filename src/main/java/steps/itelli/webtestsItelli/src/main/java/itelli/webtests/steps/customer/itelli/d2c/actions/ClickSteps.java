package steps.itelli.webtestsItelli.src.main.java.itelli.webtests.steps.customer.itelli.d2c.actions;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import steps.itelli.webtestsItelli.src.main.java.itelli.webtests.pages.base.ContextBase;
import steps.itelli.webtestsItelli.src.main.java.itelli.webtests.steps.AbstractSteps;


/**
 * DSL providing actions with clicks.
 */
public class ClickSteps extends AbstractSteps<ContextBase> {

	private static final Logger LOG = Logger.getLogger(ContextBase.class);

	/**
	 * Click the logout or login header button (toggle button).<br>
	 * TODO: Delete after old layout switched off (Bosch, Siemens)
	 */
	@When("I click the {login|logout} header button")
	public void clickLogInOutButton() {
		getContext().getContextBasedActions().clickByGivenAttribute("logInOutHeaderButton");
	}

	/**
	 * Clicks given element by attribute.<br>
	 * TODO: Setup Testdata via Befor- and AfterStories.
	 * 
	 * @param attribute the attribute.
	 */
	@When("I click the $button without validation")
	public void clickButtonForReg(final String attribute) {
		getContext().getContextBasedActions().clickByGivenAttribute(attribute);
	}

	/**
	 * Clicks the Siemens navigation at my account area.<br>
	 * For getting the visible element, the context found a list of elements by given testing id.<br>
	 * The list elements will be checked if there are visible. cssSelector(a,button,div)
	 * 
	 * @param elementID The given element at navigation.
	 */
	@When("I click the navigation element $elementID")
	public void doActionByAttributeAndParam(final String elementID) {
		List<WebElement> elements = null;

		if (elements == null) {
			elements = getContext().findElements(By.cssSelector("a[testing_id=\"" + elementID + "\"]"));
		}

		if (elements == null || elements.isEmpty()) {
			elements = getContext().findElements(By.cssSelector("button[testing_id=\"" + elementID + "\"]"));
		}
		if (elements == null || elements.isEmpty()) {
			elements = getContext().findElements(By.cssSelector("div[testing_id=\"" + elementID + "\"]"));
		}

		if (elements == null || elements.isEmpty()) {
			LOG.error("Unable to find navigation element \"" + elementID + "\"!");
			return;
		}

		if (elements.size() >= 1) {
			WebElement element = elements.get(0);
			if (element.isDisplayed()) {
				try {
					element.click();
				} catch (Exception e) {
					LOG.error("doActionByAttributeAndParam - element.click - second try");
					element.click();
				}
				getContext().waitUntilTimeout(MAX_TIMEOUT_5_SECONDS);
			}
			
			/*
			for (final WebElement element : elements) {
				if (element.isDisplayed()) {
					element.click();
					getContext().waitUntilTimeout(MAX_TIMEOUT_5_SECONDS);
				}
			}
			*/
		}
	}

	/**
	 * Clicks the any element via id.<br>
	 * For getting the visible element, the context found a list of elements by given id.<br>
	 * The list elements will be checked if there are visible. cssSelector(a,button,div)
	 * 
	 * @param elementID The given element at navigation.
	 */
	@When("I click the $elementID as an ID")
	public void doActionById(final String elementID) {
		List<WebElement> elements = null;

		if (elements == null) {
			elements = getContext().findElements(By.cssSelector("a[id=\"" + elementID + "\"]"));
		}

		if (elements == null || elements.isEmpty()) {
			elements = getContext().findElements(By.cssSelector("button[id=\"" + elementID + "\"]"));
		}
		if (elements == null || elements.isEmpty()) {
			elements = getContext().findElements(By.cssSelector("div[id=\"" + elementID + "\"]"));
		}

		if (elements == null || elements.isEmpty()) {
			LOG.error("Unable to find navigation element \"" + elementID + "\"!");
			return;
		}

		if (elements.size() >= 1) {
			for (final WebElement element : elements) {
				if (element.isDisplayed()) {
					element.click();
					getContext().waitUntilTimeout(MAX_TIMEOUT_5_SECONDS);
				}
			}
		}
	}

	/**
	 * Clicks the any element via urlPart.<br>
	 * For getting the visible element, the css selector found a list of elements by given urlPart<br>
	 * The list elements will be checked if there are visible. cssSelector(/a[contains(@href])
	 * 
	 * @param urlPart The given element at navigation.
	 * @throws InterruptedException
	 */
	@When("I click the link contains $urlPart")
	public void doActionByLink(final String urlPart) throws InterruptedException {
		List<WebElement> elements = null;

		if (elements == null) {
			elements = getContext().findElements(By.xpath("//a[contains(@href,\"" + urlPart + "\")]"));
		}
		if (elements == null || elements.isEmpty()) {
			LOG.error("Unable to find navigation element \"" + urlPart + "\"!");
			return;
		}

		if (elements.size() >= 1) {
			for (final WebElement element : elements) {
				if (element.isDisplayed()&& element.isEnabled()) {
					element.click();
					// TO-DO : As a workaround we are breaking the for loop.
					break;
				}
				getContext().waitUntilTimeout(MAX_TIMEOUT_5_SECONDS);

			}
		}
	}

	/**
	 * Clicks the any element via urlPart.<br>
	 * For getting the visible element, the css selector found a list of elements by given whole urlPart<br>
	 * The list elements will be checked if there are visible. cssSelector(/a[(@href])
	 * 
	 * @param urlPart The given element at navigation.
	 * @throws InterruptedException
	 */
	@When("I click the link isEqual to $wholeUrlPart")
	public void doActionByLink2(final String wholeUrlPart) throws InterruptedException {
		List<WebElement> elements = null;

		if (elements == null) {
			elements = getContext().findElements(By.xpath("//a[(@href=\"" + wholeUrlPart + "\")]"));
		}
		if (elements == null || elements.isEmpty()) {
			LOG.error("Unable to find navigation element \"" + wholeUrlPart + "\"!");
			return;
		}

		if (elements.size() >= 1) {
			for (final WebElement element : elements) {
				if (element.isDisplayed()&& element.isEnabled()) {
					element.click();
					// TO-DO : As a workaround we are breaking the for loop.
					break;
				}
				getContext().waitUntilTimeout(MAX_TIMEOUT_5_SECONDS);

			}
		}
	}
	
	
	
	
	/**
	 * Clicks the any element via onClickPart.<br>
	 * For getting the visible element, the css selector found a list of elements by given onclick part<br>
	 * The list elements will be checked if there are visible. cssSelector a[contains(@onclick)
	 * 
	 * @param onClickPart The given element at navigation.
	 */
	@When("I click the link onclick contains $onClickPart")
	public void doActionByLinkOnClick(final String onClickPart) {
		List<WebElement> elements = null;

		if (elements == null || elements.isEmpty()) {
			elements = getContext().findElements(By.xpath("//a[contains(@onclick,\"" + onClickPart + "\")]"));

			if (elements == null || elements.isEmpty()) {
				LOG.error("Unable to find navigation element \"" + onClickPart + "\"!");
				return;
			}

			if (elements.size() >= 1) {
				for (final WebElement element : elements) {
					if (element.isDisplayed()) {
						element.click();
						getContext().waitUntilTimeout(MAX_TIMEOUT_5_SECONDS);
					}
				}
			}
		}
	}

	/**
	 * Clicks the any element via XPATH.<br>
	 * For getting the visible element, the css selector found a list of elements by given xpath.<br>
	 * The list elements will be checked if there are visible. cssSelector(xpath)
	 * 
	 * @param xpath of the given element at navigation.
	 */
	@When("I click the xpath element $xpath")
	public void doActionByXpath(final String xpath) {
		List<WebElement> elements = null;

		if (elements == null) {
			elements = getContext().findElements(By.xpath(xpath));
		}
		if (elements == null || elements.isEmpty()) {
			LOG.error("Unable to find navigation element \"" + xpath + "\"!");
			return;
		}

		if (elements.size() >= 1) {
			for (final WebElement element : elements) {
				if (element.isDisplayed()) {
					element.click();
					getContext().waitUntilTimeout(MAX_TIMEOUT_5_SECONDS);
				}
			}
		}
	}
	@When("I click2 the xpath element $xpath with highlight")
	public void doActionByXpathHighlight(final String xpath) {
		List<WebElement> elements = null;

		if (elements == null) {
			elements = getContext().findElements(By.xpath(xpath));
		}
		if (elements == null || elements.isEmpty()) {
			LOG.error("Unable to find navigation element \"" + xpath + "\"!");
			return;
		}

		if (elements.size() >= 1) {
			for (final WebElement element : elements) {
				if (element.isDisplayed()) {
					getContext().highlightElement(element);
					element.click();
					getContext().waitUntilTimeout(MAX_TIMEOUT_5_SECONDS);
				}
			}
		}
	}

	/**
	 * Clicks the the any element via XPATH.<br>
	 * For getting the visible element, the css selector found a list of elements by given xpath.<br>
	 * The list elements will be checked if there are visible. cssSelector(xpath)
	 * 
	 * @param tag like <a,<div,
	 *            <table
	 *            ,<input
	 * @param attribute like title=,id=,name=,class=
	 * @param valuePart like "any content" or "value"
	 */
	@When("I click on first element via $tag and $attribute and $valuePart")
	public void clickFirstByXpath(final String tag, final String attribute, final String valuePart) {
		List<WebElement> elements = null;

		if (elements == null) {
			elements = getContext().findElements(
					By.xpath("//" + tag + "[contains(@" + attribute + "," + "\"" + valuePart + "\"" + ")]"));
		}
		if (elements == null || elements.isEmpty()) {
			LOG.error("Unable to find navigation element \"" + tag + "\",\"" + attribute + "\",\"" + valuePart + "\"!");
			return;
		}
		if (elements.size() >= 1) {
			for (final WebElement element : elements) {
				if (element.isDisplayed()) {
					element.click();
					getContext().waitUntilTimeout(MAX_TIMEOUT_10_SECONDS);
					break;
				}
			}
		}
	}
	
	
	
	/**
	 * 
	 * Check if COPI Hookline exist.<br>
	 * We take itemprop as a parameter to find the whole descriptipn as an element first.<br>
	 * Then we find if tag p exists and if it has a text inside.<br>
	 * 
	 * @param itemprop
	 *  
	 */
	@Then("the element by itemprop $itemprop includes COPI Hookline")
	public void CheckHookline(final String itemprop)
	{
		List<WebElement> elements = null;
		WebElement Elm1 = null;
		WebElement Elm2 = null;
		
		Elm1 = getContext().findElements(By.cssSelector("[itemprop=\"" + "description" + "\"]")).get(0);
		
		if(Elm1==null){
			Assert.assertTrue("Unable to find element", false);
			return;
		}
		
		Elm2 = Elm1.findElements(By.cssSelector("p")).get(0);
		
		if(Elm2==null){
			Assert.assertTrue("Unable to find element", false);
			return;
		}
		
		String COPItext = Elm2.getText();
		
		if (Elm2.getText() == null || Elm2.getText().trim().isEmpty() || Elm2.getText().length()< 2) {
			
			Assert.assertTrue("Unable to find element", false);
		}
		
		Assert.assertTrue("ok", true);
		return;	
	
	}
	
	
	
	/**
	 * 
	 * Check for COPI Key feature.<br>
	 * We take list-data as a parameter to find the whole key features.<br>
	 * Then we find if tag li exists and if it has a text inside.<br>
	 * 
	 * @param klas
	 *  
	 */
	@Then("the element by $klas includes COPI Key Feature")
	public void CheckKeyFeature(final String klas)
	{
		List<WebElement> elements = null;
		WebElement Elm1 = null;
		WebElement Elm2 = null;
		
		Elm1 = getContext().findElements(By.cssSelector("[class=\"" + "list-data" + "\"]")).get(0);
		
		if(Elm1==null){
			Assert.assertTrue("Unable to find element", false);
			return;
		}
		
		Elm2 = Elm1.findElements(By.cssSelector("li")).get(0);
		if(Elm2==null){
			Assert.assertTrue("Unable to find element", false);
			return;
		}
		
		String KeyFeatureText = Elm2.getText();
		
		if (Elm2.getText() == null || Elm2.getText().trim().isEmpty() || Elm2.getText().length()< 2) {
			
			Assert.assertTrue("Unable to find element", false);
		}
		
		Assert.assertTrue("ok", true);
		return;	
	
	}
	
	
	/**
	 * 
	 * Check for PVM header Data.<br>
	 * First we take the Header's class, then we go deeper for the PVM Header.<br>
	 * First, we take the div class for headers, then we go for header tag to see if it is not empty.<br>
	 * This DSL jumps over the first two invisble ts-header class and takes the third one which is first invisible.<br>
	 * 
	 * @param tsHeader
	 *  
	 */
	@Then("the element by $tsHeader includes PVM Header")
	public void CheckPVMheader(final String tsHeader)
	{
		List<WebElement> elements = null;
		WebElement Elm1 = null;
		WebElement Elm2 = null;
		
		Elm1 = getContext().findElements(By.cssSelector("[class=\"" + "ts-header" + "\"]")).get(2);
		
		if(Elm1==null){
			Assert.assertTrue("Unable to find element", false);
			return;
		}
		
		Elm2 = Elm1.findElements(By.cssSelector("h2")).get(0);
		
		if(Elm2==null){
			Assert.assertTrue("Unable to find element", false);
			return;
		}
		
		if (Elm2.getText() == null || Elm2.getText().trim().isEmpty() || Elm2.getText().length()< 2) {
			
			Assert.assertTrue("Unable to find element", false);
		}
		
		Assert.assertTrue("ok", true);
		return;	
	
	}
		
	
	/**
	 * 
	 * After getting down on the page, this DSL makes sure that the number of Feature Icons are less than $count.<br>
	 * 
	 * 
	 * @param count  example: 5, max number of feature icons.
	 * 
	 *  
	 */
	@Then("number of feature icon is not more than $count")
	public void checkFeatureIconCount(final int count)
	{
		List<WebElement> elements = null;
		WebElement rootEl1 = null;
		WebElement rootEl2 = null;
		
		if (rootEl1 == null) {
			rootEl1 = getContext().findElements( By.cssSelector("[class=\"" + "product-info type-1" + "\"]")).get(0);
		}
		
		if (rootEl1 == null) {
			LOG.error("Unable to find element");
			Assert.assertTrue("Unable to find element", false);
		}
		
		if (rootEl2 == null) {
			rootEl2 = rootEl1.findElements( By.cssSelector("[class=\"" + "icon-list" + "\"]")).get(0);
		}
		if (rootEl2 == null) {
			LOG.error("Unable to find element");
			Assert.assertTrue("Unable to find element", false);
		}
		
		elements = rootEl2.findElements( By.cssSelector("[class=\"" + "tooltip-5" + "\"]") );
		
		if (elements == null || elements.isEmpty()) {
			LOG.warn("Unable to find element");
			Assert.assertTrue("Unable to find element", false);
		}
		
		if (elements.size() <= count) {
					Assert.assertTrue("is equal", true);
		}else{
					Assert.assertTrue("is not equal", false);

		}
	}
	

	
	/**
	 * 
	 * Check for Brand Value Class to be right before the PVM header.<br>
	 * First we take the Header's class, then we go deeper for the span tag where the Brand Value Class is at.<br>
	 * First, we take the div class for headers, then we go for SPAN tag to check the Brand Value Class.<br>
	 * 
	 * @param tsHeaders
	 *  
	 */
	@Then("the element by $tsHeaders has Brand Value Class before PVM header")
	public void CheckBrandValueClass(final String tsHeaders)
	{
		List<WebElement> elements = null;
		WebElement Elm1 = null;
		WebElement Elm2 = null;
		
		Elm1 = getContext().findElements(By.cssSelector("[class=\"" + "ts-header" + "\"]")).get(2);
		
		if(Elm1==null){
			Assert.assertTrue("Unable to find element", false);
			return;
		}
		
		Elm2 = Elm1.findElements(By.cssSelector("span")).get(0);
		
		if(Elm2==null){
			Assert.assertTrue("Unable to find element", false);
			return;
		}
		
		if (Elm2.getText() == null || Elm2.getText().trim().isEmpty() || Elm2.getText().length()< 2) {
			
			Assert.assertTrue("Unable to find element", false);
		}
		
		Assert.assertTrue("ok", true);
		return;	
	
	}
	
	
	
	/**
	 * 
	 * Check for Brand Value Class to be right before the PVM header in Product Details Page.<br>
	 * First we take the Header's class, then we go deeper for the span tag where the Brand Value Class is at.<br>
	 * First, we take the div class for headers, then we go for SPAN tag to check the Brand Value Class.<br>
	 * 
	 * @param ProdHeader
	 *  
	 */
	@Then("the element by $ProdHeader has Brand Value Class before PVM header in ProdDetailsPage")
	public void CheckingBrandValueClass(final String ProdHeader)
	{
		List<WebElement> elements = null;
		WebElement Elm1 = null;
		WebElement Elm2 = null;
		
		Elm1 = getContext().findElements(By.cssSelector("[class=\"" + "product-header" + "\"]")).get(0);
		
		if(Elm1==null){
			Assert.assertTrue("Unable to find element", false);
			return;
		}
		
		Elm2 = Elm1.findElements(By.cssSelector("[class=\"" + "value-class" + "\"]")).get(0);
		
		if(Elm2==null){
			Assert.assertTrue("Unable to find element", false);
			return;
		}
		
		if (Elm2.getText() == null || Elm2.getText().trim().isEmpty() || Elm2.getText().length()< 2) {
			
			Assert.assertTrue("Unable to find element", false);
		}
		
		Assert.assertTrue("ok", true);
		return;	
	
	}
	
	
	
	/**
	 * 
	 * We go down to tooltips, and then see if every icon has the required size and format under its class.<br>
	 * They have to be less than 5 icons in total.<br>
	 * Format and size are Strings obtained from the "src".<br>
	 * 
	 * @param size example "80x200" px
	 * @param Format example ".png"
	 *  
	 */
	@Then("selected product has feature icon $format format with $size resolution")
	public void CheckIconFormat(final String format, final String size)
	{
		List<WebElement> elements = null;
		List<WebElement> imgElements = new ArrayList<WebElement>();
		WebElement rootEl1 = null;
		WebElement rootEl2 = null;
		
		if (rootEl1 == null) {
			rootEl1 = getContext().findElements( By.cssSelector("[class=\"" + "product-info type-1" + "\"]")).get(0);
		}
		
		if (rootEl1 == null) {
			LOG.error("Unable to find element");
			Assert.assertTrue("Unable to find element", false);
		}
		
		if (rootEl2 == null) {
			rootEl2 = rootEl1.findElements( By.cssSelector("[class=\"" + "icon-list" + "\"]")).get(0);
		}
		if (rootEl2 == null) {
			LOG.error("Unable to find element");
			Assert.assertTrue("Unable to find element", false);
		}
		
		elements = rootEl2.findElements( By.cssSelector("[class=\"" + "tooltip-5" + "\"]") );
		
		if (elements == null || elements.isEmpty()) {
			LOG.warn("Unable to find element");
			Assert.assertTrue("Unable to find element", false);
		}
		
		for(WebElement webEl : elements){
			
			WebElement el = webEl.findElement( By.cssSelector("[alt]") );
			
			imgElements.add(el);
		}
				
		for(int i=0; i<5; i++){
			String url = imgElements.get(i).getAttribute("src");
			
			if ( ! url.endsWith(format) ){
				Assert.assertTrue("format is not" + format , false);
			}
			
			if ( ! url.contains(size) ){
				Assert.assertTrue("The size is not" + size , false);
			}
		}
		
	}
	
	
	
	/**
	 * 
	 * We open up the product list, then check if every product has max 5 icons in required format and size.<br>
	 * They have to be less than 5 icons in total.<br>
	 * Format and size are Strings obtained from the "src".<br>
	 * The number of products and icons are used as the upper limit in "for" loops.<br>
	 * 
	 * @param size example "80x200" px
	 * @param Format example ".png"
	 *  
	 */
	@Then("all products have maximum 5 feature icons in $format format with $size resolution")
	public void CheckAllIconFormat(final String format, final String size)
	{
		List<WebElement> elements = null;
		List<WebElement> imgElements = new ArrayList<WebElement>();
		WebElement rootEl1 = null;
		WebElement rootEl2 = null;
		
		if (rootEl1 == null) {
			rootEl1 = getContext().findElements( By.cssSelector("[class=\"" + "items-area-inner product-list" + "\"]")).get(0);
		}
		
		if (rootEl1 == null) {
			LOG.error("Unable to find element");
			Assert.assertTrue("Unable to find element", false);
		}
		
		if (rootEl2 == null) {
			rootEl2 = rootEl1.findElements( By.cssSelector("[class=\"" + "icon-list" + "\"]")).get(0);
		}
		if (rootEl2 == null) {
			LOG.error("Unable to find element");
			Assert.assertTrue("Unable to find element", false);
		}
		
		int NumberOfProducts;
		NumberOfProducts = rootEl1.findElements(By.cssSelector("[class=\"" + "product-desc" + "\"]")).size();
		elements = rootEl2.findElements( By.cssSelector("[class=\"" + "tooltip-4" + "\"]"));
		
		WebElement arvin;
		arvin = elements.get(0);
		for (int j=0; j < NumberOfProducts; j++){
		
			if (elements == null || elements.isEmpty()) {
				LOG.warn("Unable to find element");
				Assert.assertTrue("Unable to find element", false);
			}
			
			for(WebElement webEl : elements){
				
				WebElement el = webEl.findElement( By.cssSelector("[alt]") );
				
				imgElements.add(el);
			}
					
			for(int i=0; i < elements.size(); i++){
				
				String url = imgElements.get(i).getAttribute("src");
				
				if ( ! url.endsWith(format) ){
					Assert.assertTrue("format is not" + format , false);
				}
				
				if ( ! url.contains(size) ){
					Assert.assertTrue("The size is not" + size , false);
				}
			}
			
		 }
	  }
	
	
	
	/**
	 * Clicks the the any element via XPATH.<br>
	 * For getting the visible element, the css selector found a list of elements by given xpath.<br>
	 * The list elements will be checked if there are visible. cssSelector(xpath)
	 * 
	 * @param tag like <a,<div,
	 *            <table
	 *            ,<input
	 * @param attribute like title=,id=,name=,class=
	 * @param valuePart like "any content" or "value"
	 */
	@When(value = "I click on first element via $tag and $attribute and $valuePart without wait",priority=2)
	public void clickFirstByXpathWithoutWait(final String tag, final String attribute, final String valuePart) {
		List<WebElement> elements = null;

		if (elements == null) {
			elements = getContext().findElements(
					By.xpath("//" + tag + "[contains(@" + attribute + "," + "\"" + valuePart + "\"" + ")]"));
		}
		if (elements == null || elements.isEmpty()) {
			LOG.error("Unable to find navigation element \"" + tag + "\",\"" + attribute + "\",\"" + valuePart + "\"!");
			return;
		}
		if (elements.size() >= 1) {
			for (final WebElement element : elements) {
				if (element.isDisplayed()) {
					element.click();
					break;
				}
			}
		}
	}
	
	/**
	 * Clicks the the any element via XPATH.<br>
	 * For getting the visible element, the css selector found a list of elements by given xpath.<br>
	 * The list elements will be checked if there are visible. cssSelector(xpath)
	 * 
	 * @param tag like <a,<div,
	 *            <table
	 *            ,<input
	 * @param attribute like title=,id=,name=,class=
	 * @param valuePart like "any content" or "value"
	 */
	@When("I click on first visible element via $tag and $attribute and $valuePart")
	public void clickFirstVisibleByXpath(final String tag, final String attribute, final String valuePart) {
		List<WebElement> elements = null;
		elements = getContext().findElements(By.xpath("//" + tag + "[contains(@" + attribute + "," + "\"" + valuePart + "\"" + ")]"));
		
		if (elements == null || elements.isEmpty()) {
			LOG.error("Unable to find navigation element \"" + tag + "\",\"" + attribute + "\",\"" + valuePart + "\"!");
			Assert.assertNull(elements);
		}
		if (elements.size() >= 1) {
			for (WebElement element : elements) {
				if (element.isDisplayed() && element.isEnabled()) {
					element.click();
					getContext().waitUntilTimeout(MAX_TIMEOUT_5_SECONDS);
					break;
				}
			}
		}
	}
	
	@When("I click on second element via $tag and $attribute and $valuePart")
	public void clickSecondByXpath(final String tag, final String attribute, final String valuePart) 
	{
		List<WebElement> icons = getContext().findElements(By.cssSelector(""+tag+"["+attribute+"='"+valuePart+"']"));
		WebElement icon = icons.get(1);
		icon.click();
	}
	
	
	@When("I click on child element $childtag with parent $tag and $attribute and $valuePart")
	public void clickWithParent(final String childtag,final String tag, final String attribute, final String valuePart) 
	{
		List<WebElement> elements = getContext().findElements(By.cssSelector(""+tag+"["+attribute+"='"+valuePart+"'] " + childtag));
		WebElement element = elements.get(0);
		element.click();
	}
	
	/**
	 * Clicks the Nth element via XPATH.<br>
	 * For getting the visible element, the css selector found a list of elements by given xpath.<br>
	 * The list elements will be checked if there are visible. cssSelector(xpath)
	 * 
	 * @param orderindex like 1,2,3,4,...
	 * @param tag like <a,<div, <table ,<input
	 * @param attribute like title=,id=,name=,class=
	 * @param valuePart like "any content" or "value"
	 */
	@When("I click the $orderindex nd/th element via $tag and $attribute and $valuePart")
	public void clickDynamicByXpath(final int orderindex, final String tag, final String attribute, final String valuePart) {
		List<WebElement> icons = null;
		icons = getContext().findElements(By.xpath("//" + tag + "[contains(@" + attribute + "," + "\"" + valuePart + "\"" + ")]"));
		if (orderindex == 0) {
			icons.get(orderindex).click();
		}
		if (orderindex > 0) {
			icons.get(orderindex - 1).click();
		}
		if (icons == null || icons.isEmpty() || orderindex < 0) {
			LOG.error("Unable to find navigation element \"" + tag + "\",\"" + attribute + "\",\"" + valuePart + "\"!");
			return;
		}
	}
	

	/**
	 * MyAccount DSL
	 */
	@When("I click myaccount and $tabname is available")
	public void makeTabAvailable(final String tabname) throws InterruptedException {

		final WebElement tabelement = getContext().findElement(By.xpath("//*[@id=\"" + tabname + "\"]"));

		getContext().executeScript(
				"document.getElementById(\"" + tabname + "\").setAttribute('style', 'visibility: visible; display: block;')",
				tabelement);

		// getContext().executeScript("arguments[0].setAttribute('style', 'visibility: visible; display: block;')", tabelement);

	}

	@When("I override showModalDialog")
	public void overrideShowModalDialog () throws InterruptedException {

		//getContext().executeScript("window.showModalDialog = window.open;");
		getContext().executeScript("window.showModalDialog = function( sURL,vArguments, sFeatures){modalWin = window.open(sURL, 'modal', sFeatures)}");
	}

	@When("I doubleclick on first element via $tag and $attribute and $valuePart")
	public void doubleClickFirstByXpath(final String tag, final String attribute, final String valuePart) {
		List<WebElement> elements = null;
		final Actions action = new Actions(getContext());

		if (elements == null) {
			elements = getContext().findElements(
					By.xpath("//" + tag + "[contains(@" + attribute + "," + "\"" + valuePart + "\"" + ")]"));
		}
		if (elements == null || elements.isEmpty()) {
			LOG.error("Unable to find navigation element \"" + tag + "\",\"" + attribute + "\",\"" + valuePart + "\"!");
			return;
		}
		if (elements.size() >= 1) {
			for (final WebElement element : elements) {
				if (element.isDisplayed()) {
					action.doubleClick(element).perform();
					getContext().waitUntilTimeout(MAX_TIMEOUT_5_SECONDS);
					break;
				}
			}
		}
	}


}
