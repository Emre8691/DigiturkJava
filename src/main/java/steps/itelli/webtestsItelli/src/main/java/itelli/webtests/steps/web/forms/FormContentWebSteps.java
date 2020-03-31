package itelli.webtests.steps.web.forms;

import java.util.HashMap;
import java.util.Iterator;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang.StringUtils;
import org.glassfish.jersey.client.ClientConfig;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import itelli.webtests.common.DSLLogConstract;
import itelli.webtests.common.DslLogBeauty;
import itelli.webtests.pages.base.ContextBase;
import itelli.webtests.steps.AbstractSteps;

/**
 * DSL which checks text at form fields.
 */
public class FormContentWebSteps extends AbstractSteps<ContextBase> {

	/**
	 * Checks the given form is empty.<br>
	 * @param form The ID of the form field
	 */
	@Then("the $form is empty")
	public void checkFormIsEmpty(final String form) {
		try {
			final String empty = getContext().getContextBasedInformations().getFormElementValue(form);
			Assert.assertEquals("Form " + form + " code is not empty.", StringUtils.EMPTY, empty);
		} catch (Exception e) {
			DslLogBeauty.logger(DSLLogConstract.ELEMENT_NOT_FOUND, new Object[] { form, "The form " }, new Exception(), FormContentWebSteps.class);
		}
	}

	/**
	 * Checks if the expected parameter is filled at form field.<br>
	 * @param attribute The given element.
	 * @param parameter The given parameter.
	 */
	@Then("the form field $attribute is filled correct with the parameter $parameter")
	public void checkFormField(final String attribute, final String parameter) {
		try {
			final WebElement elm = getContext().findElementByGivenAttribute(attribute);
			Assert.assertNotNull("Form field with '" + attribute + "' has to exist!", elm.getAttribute("value"));
		} catch (Exception e) {
			DslLogBeauty.logger(DSLLogConstract.MULTI_ELEMENT_NOT_FOUND, new Object[] { attribute, parameter, "The attribute " }, new Exception(), FormContentWebSteps.class);
		}
	}

	/**
	 * Checks if the given parameter is sended correct and shown correct at explicit field.<br>
	 * 
	 * @param parameter The searched information.
	 * @param field The field which has the searched information.
	 */
	@Then("the given data $parameter is shown correct at field $field")
	public void checkTheGivenParam(final String parameter, final String field) {
		try {
			final WebElement fld = getContext().getElementFinder().findBy(field);
			final String param = fld.getAttribute("value");
			if (parameter.equals(param)) {
				Assert.assertEquals("The expected parameter isn´t displayed!", parameter, param);	
			} else {
				DslLogBeauty.logger(DSLLogConstract.ELEMENT_NOT_EQUALS, new Object[] { parameter, param, "The parameters " }, new Exception(), FormContentWebSteps.class);
			}
		} catch (Exception e) {
			DslLogBeauty.logger(DSLLogConstract.MULTI_ELEMENT_NOT_FOUND, new Object[] { parameter, field, "The parameter " }, new Exception(), FormContentWebSteps.class);
		}
	}
	
	
	/**
	 * Checks the given Fiels is empty.<br>
	 * The field should be check by it's 'id'
	 * @param field The ID of the form field
	 * e.g. <input id="searchbar-2"
	 * the check is done based on searchbar-2
	 */
	@Then("check the $id is empty")
	public void checkTextBoxFieldIsEmpty(final String id) {
		final String emptyfield = getContext().getContextBasedInformations().getFormElementValueByIdOrByName(id);
		if ( emptyfield != null ) {
			Assert.assertEquals("id " + id + " code is not empty.", StringUtils.EMPTY, emptyfield);
		} else {
			DslLogBeauty.logger(DSLLogConstract.ELEMENT_IS_EMPTY, new Object[] { id, "The id " }, new Exception(), FormContentWebSteps.class);			
		}
	}
	
	/**
	 * Checks the element given is on HTML source code.<br>
	 * @param String parameter can be anything 
	 * given string should not have ' '
	 * i.e Then check /satelliteLib- exists on current page
	 */
	@Then(value = "check $searchingHTMLValue exists on current page", priority = 1)
	public void checkScriptSRCcontains(final String searchingHTMLValue) {
		boolean isOnPage = getSystem().checkPageContains(searchingHTMLValue);
		if (isOnPage) {
			Assert.assertTrue("The search criteria exsist on HTML page", isOnPage);
		} else {
			DslLogBeauty.logger(DSLLogConstract.ELEMENT_NOT_FOUND, new Object[] { searchingHTMLValue, "The html value " }, new Exception(), FormContentWebSteps.class);	
		}
	}
	
	
	@Given(value = "test data web service url is $srvUrl", priority = 1)
	public void getFormDataWithRest(final String srvUrl) {
		Client client = ClientBuilder.newClient( new ClientConfig());
		WebTarget webTarget = client.target(srvUrl);
		 
		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		 
		HashMap<String, Object> formdata = response.readEntity(new GenericType<HashMap<String, Object>>() { });
		
		Iterator it = formdata.entrySet().iterator();
	    while (it.hasNext()) {
	    	HashMap.Entry pair = (HashMap.Entry)it.next();
			getContext().getContextInformation().setPropertyToMetaMap((String)pair.getKey(), (String)pair.getValue());
	        it.remove(); 
	    }
	}
	
}
