package steps.itelli.webtestsItelli.src.main.java.itelli.webtests.steps.web.actions;

import java.util.List;

import org.apache.log4j.Logger;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import steps.itelli.webtestsItelli.src.main.java.itelli.webtests.pages.base.ContextBase;
import steps.itelli.webtestsItelli.src.main.java.itelli.webtests.steps.AbstractSteps;


public class TestTrackStep extends AbstractSteps<ContextBase> {

	private static final Logger logger = Logger.getLogger(ClickWebSteps.class);
	
	//do not call this method from production scenarios. this is for testing only.
	@When("Highlight $cssSelector")
    public void clickYusuf( final String cssSelector) {
        //cssSelector example = ".panel"
    	List<WebElement> elements = null;
		try {
			elements = getContext().findElements(By.cssSelector(cssSelector));
			WebElement el = elements.get(0);
			
			getContext().highlightElement(el);
			
			Thread.sleep(3*1000);
		}catch (Exception e) {
			logger.error(e);
		}
    }
}
