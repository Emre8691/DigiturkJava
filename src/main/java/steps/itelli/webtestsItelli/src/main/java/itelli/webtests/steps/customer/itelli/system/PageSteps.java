package itelli.webtests.steps.customer.itelli.system;

import org.apache.log4j.Logger;
import org.jbehave.core.annotations.Then;
import org.junit.Assert;

import itelli.webtests.common.DSLLogConstract;
import itelli.webtests.common.DslLogBeauty;
import itelli.webtests.config.WebDriverProviderFactory;
import itelli.webtests.domain.Page;
import itelli.webtests.pages.base.ContextBase;
import itelli.webtests.steps.AbstractSteps;

/**
 * DSL which provides page checks.
 */
public class PageSteps extends AbstractSteps<ContextBase> {

	private static final Logger LOG = Logger.getLogger(PageSteps.class);
	
	/**
	 * Checks if the current page is the page.<br>
	 * 
	 * @param page
	 *            The page object containing the mapping for the page identifier
	 *            (page.properties).
	 */
	@Then("the page $page is {opened|shown}")
	public void checkPageIsOpened(final Page page) {
		System.out.println("debug it !");
		try {
			if (!getContext().getCurrentUrl().contains("fi.muc.bsh.arithnea.org")) {
				System.out.println("Production Tests: test_context_pageId is not availeble, ignored!!!");
			} else {
				final String expectedPageId = page.getIdentifier();//value from propertie file
				final String gotPageId = getContext().getContextBasedInformations().getPageIdOfCurrentPage();//value form existing/current browser page
				
				try{
					if(expectedPageId==null || expectedPageId.isEmpty() 
					  || gotPageId==null || gotPageId.isEmpty() ){
						final boolean isUnderMaintenance = getSystem().checkPageContains("Under Maintenance");
						Assert.assertFalse("Site under maintenance", isUnderMaintenance);

						throw new Exception("expectedPageId or gotPageId not found.");
					}
	 			}catch(Exception e){
					
	 				LOG.info("expectedPageId or gotPageId not found. This is not an error."
	 						+ "Application will try with google analitics tags.");
	 				checkGoogleId(page);
				}
				
				final boolean matches = gotPageId.matches(expectedPageId);
				if ( matches ) {
					Assert.assertTrue("The current page is not the expected page! expected:<" + expectedPageId + "> but was:<" + gotPageId + ">", matches);
				} else {
					
					LOG.info("expectedPageId and gotPageId not matched. This is not an error."
	 						+ "Application will try with google analitics tags.");
					
					checkGoogleId(page);
				}
			}
		} catch (Exception e) {
			DslLogBeauty.logger(DSLLogConstract.PAGE_NOT_FOUND, new Object[] { page, "Page block" }, e, PageSteps.class);
		}
	}
	
	private void checkGoogleId(Page page){
		final String expectedGoogleId = page.getGoogleid();//value from propertie file
		final String gotGoogleId = getContext().getContextBasedInformations().getGoogleIdOfCurrentPage();//value form existing/current browser page
	
		if(gotGoogleId==null || ! gotGoogleId.startsWith(expectedGoogleId)   ){
			Assert.assertTrue("The current page is not the expected page! expected google id:<" + expectedGoogleId + "> but was:<" + gotGoogleId + ">", false);
		}
		LOG.info("google page id matched.");
	}
}