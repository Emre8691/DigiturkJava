package steps.itelli.webtestsItelli.src.main.java.itelli.webtests.steps.webservice;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.w3c.dom.Node;

import com.eviware.soapui.impl.wsdl.WsdlOperation;
import com.eviware.soapui.impl.wsdl.WsdlRequest;
import com.eviware.soapui.impl.wsdl.WsdlSubmit;
import com.eviware.soapui.impl.wsdl.WsdlSubmitContext;
import com.eviware.soapui.impl.wsdl.submit.transports.http.BaseHttpResponse;
import com.eviware.soapui.model.iface.Response;
import com.eviware.soapui.support.SoapUIException;
import com.eviware.soapui.support.XmlHolder;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;

import itelli.webtests.common.RandomString;
import itelli.webtests.steps.AbstractSteps;
import itelli.webtests.steps.web.alerts.AlertWebSteps;
import itelli.webtests.steps.webservice.WebserviceTestContext.ContentType;
import itelli.webtests.steps.webservice.WebserviceTestContext.FieldType;
import itelli.webtests.steps.webservice.WebserviceTestContext.ServiceType;



/**
 * Web Service Steps
 * @param <ContextBase>
 */
public class DemoWebserviceWebSteps extends AbstractSteps {

	private static final Logger LOG = Logger.getLogger(AlertWebSteps.class);
	WebserviceTestContext context;

	@Given("is service type is $type")
	public void setServiceType(String type) throws XmlException, IOException, SoapUIException {

		ServiceType serviceT = ServiceType.valueOf(type);
		if (serviceT == ServiceType.SOAP) {
			context = new SoapWebserviceTestContext();
		} else if (serviceT == ServiceType.REST) {
			context = new RestWebserviceTestContext();
		} else {
			Assert.fail("Invalid service type. Valid types are: SOAP, REST");
		}
	}

	@Given("is soap wsdl is $url")
	@Alias("is rest base url is $url")
	public void setBaseURL(String url) throws Exception {
		context.setBaseURL(url);
	}

	
	@Given("is soap endpoint url is $url")
	public void setRequestURL(String url) throws Exception {
		context.setRequestURL(url);
	}
	
	Boolean auth = false;

	@Given("is webservice authentication")
	public void setAuhtentication() {
		auth = true;
	}

	@When("I set $methodname as soap method name for request $requestname")
	@Alias("I set $methodname as rest request url for request $requestname")
	public void setServiceMethod(String methotname, String requestname) {
		context.getRequestContext(requestname).setMethodName(methotname);
	}

	@When("I set $value into query parameter $keyfor for request $requestname")
	public void addQueryParameter(String value, String key, String requestname) {
		value = resolveValue(value).getValue();
		context.getRequestContext(requestname).getQueryParameters().put(key, value);
	}

	@When("I set method to $method for request $requestname")
	public void setRestRequestMethod(String method, String requestname) {
		List<String> validRestMethods = Arrays.asList("GET", "POST", "PUT", "DELETE");
		if (!validRestMethods.contains(method)) {
			Assert.fail("Invalid rest method. Valid methods are: " + StringUtils.join(validRestMethods, ','));
		}
		context.getRequestContext(requestname).setMethod(method);
	}

	@When(value = "I set $value into body parameter $key for request $requestname", priority = 1)
	@Alias(value = "I set $value into soap parameter $key for request $requestname")
	public void addBodyParameter(String value, String key, String requestname) {
		SavedValue savedVal = resolveValue(value);
		context.getRequestContext(requestname).getBodyParameters().put(key, savedVal);
	}

	@When(value = "I set $value into body parameter $key with type $type for request $requestname", priority = 2)
	public void addBodyParameterWithType(String value, String key, String type, String requestname) {

		FieldType contentType = FieldType.NA;

		try {
			contentType = FieldType.valueOf(type);
		} catch (Exception ex) {}
		
		if (contentType == FieldType.NA) {
			Assert.fail("Invalid parameter type. Valid types are: Integer, Double, String, Boolean");
		}

		value = resolveValue(value).getValue();
		context.getRequestContext(requestname).getBodyParameters().put(key, SavedValue.getInstance(value, contentType));
	}

	@When("I set $value into header $key for request $requestname")
	public void addheader(String value, String key, String requestname) {
		value = resolveValue(value).getValue();
		context.getRequestContext(requestname).getRequestHeaders().put(key, value);
	}

	@When("I set $value into cookie $cookiename for request $requestname")
	public void addCookie(String value, String key, String requestname) {
		value = resolveValue(value).getValue();
		context.getRequestContext(requestname).getCookieParameters().put(key, value);
	}

	@When("I set $contenttype as body content type for request $requestname")
	public void addBodyConentType(String contenttype, String requestname) {
		// TODO: Refactor
		ContentType contentType = ContentType.valueOf(contenttype);
		context.getRequestContext(requestname).setRequestContentType(contentType);
	}
	
	@When("I set $rootnode as xml body root node name for request $requestname")
	public void addXmlRootNodeName(String rootnodename, String requestname) {
		context.getRequestContext(requestname).setXmlBodyRootNodeName(rootnodename);
	}

	@When("I set $contenttype as response content type for request $requestname")
	public void addResponseConentType(String contenttype, String requestname) {
		// TODO: Refactor
		ContentType contentType = ContentType.valueOf(contenttype);
		context.getRequestContext(requestname).setResponseContentType(contentType);
	}

	@When("I execute request $requestname")
	public void makeRequest(String requestname) throws Exception {
		ServiceType serviceType = context.getServiceType();
		if (serviceType == ServiceType.SOAP) {
			makeSoapRequest(requestname);
		} else if (serviceType == ServiceType.REST) {
			makeRestRequest(requestname);
		} else {
			Assert.fail("Unable to find request type. Valid types are: SOAP, REST");
		}
	}

	private SecureRandom rand = new SecureRandom();

	@When("I generate random value with name $name and type $type for request $requestname")
	public void generateValue(String name, String type, String requestname) {
		String random = "";
		RandomString randomString = new RandomString(15);
		FieldType fieldType = FieldType.NA;

		if (type.equals("EMAIL")) {
			random = randomString.nextString();
			random += "@mailinator.com";
			fieldType = FieldType.String;
		} else if (type.equals("INTEGER")) {
			random = rand.nextInt(100000) + "";
			fieldType = FieldType.Integer;
		} else if (type.equals("DOUBLE")) {
			random = rand.nextDouble() + "";
			fieldType = FieldType.Double;
		} else if (type.equals("STRING")) {
			random = randomString.nextString();
			fieldType = FieldType.String;
		} else {
			Assert.fail("Unable to determine random value type. Avaliable types are: EMAIL,INTEGER,DOUBLE,STRING");
		}
		context.getRequestContext(requestname).getSavedVariables().put(name, SavedValue.getInstance(random, fieldType));
	}

	@Then("for request $requestname the status code is $expectedstatus")
	public void checkStatusCode(String requestname, String expectedstatus) {
		TestRequestContext requestContext = context.getRequestContext(requestname);
		String statusCode = requestContext.getStatusCode();
		Assert.assertEquals(expectedstatus, statusCode);
	}

	@Then("for request $requestname the response header $key value is $value")
	public void checkHeaderValue(String requestname, String key, String value) {
		String expectedValue = resolveValue(value).getValue();
		TestRequestContext requestContext = context.getRequestContext(requestname);
		Map<String, String> responseHeaders = requestContext.getResponseHeaders();
		if (!responseHeaders.containsKey(key)) {
			Assert.fail("Unable to find header value");
		}

		String headerValue = responseHeaders.get(key);
		Assert.assertEquals(expectedValue, headerValue);
	}
	
	@Then("for request $requestname the response cookie $key value is $value")
	public void checkCookieValue(String requestname, String key, String value) {
		String expectedValue = resolveValue(value).getValue();
		TestRequestContext requestContext = context.getRequestContext(requestname);
		Map<String, String> responseCookies = requestContext.getResponseCookies();
		if (!responseCookies.containsKey(key)) {
			Assert.fail("Unable to find cookie value");
		}

		String cookieValue = responseCookies.get(key);
		Assert.assertEquals(expectedValue, cookieValue);
	}

	@Then("for request $requestname response property $key equals $value")
	public void checkPropertyValue(String requestname, String key, String value) {
		value = resolveValue(value).getValue();
		ServiceType serviceType = context.getServiceType();
		if (serviceType == ServiceType.SOAP) {
			checkSoapResultParameter(requestname, key, value);
		} else if (serviceType == ServiceType.REST) {
			checkRestResultParameter(requestname, key, value);
		}
	}

	@Then("for request $requestname result value is $value")
	public void checkSoapResult(String requestname, String value) {
		value = resolveValue(value).getValue();
		ServiceType serviceType = context.getServiceType();
		if (serviceType == ServiceType.SOAP) {
			checkSoapResultParameter(requestname, "", value);
		} else if (serviceType == ServiceType.REST) {
			checkRestResultParameter(requestname, "", value);
		}
	}

	@Then("for request $requestname property $key type is $type")
	public void checkPropertyType(String requestname, String key, String type) {

		TestRequestContext requestContext = context.getRequestContext(requestname);

		FieldType expectedType = FieldType.NA;

		try {
			expectedType = FieldType.valueOf(type);
		} catch (Exception ex) {
		}
		if (expectedType == FieldType.NA) {
			Assert.fail("Invalid field type. Valid types are: Integer, Double, String, Boolean");
		}

		Boolean result = false;

		if (context.getServiceType() == ServiceType.REST
				&& requestContext.getResponseContentType() == ContentType.JSON) {
			result = checkJsonPropertyValue(requestContext, key, expectedType);
		} else {

			String value = "";

			if (context.getServiceType() == ServiceType.SOAP) {
				value = getSoapResponseValue(requestname, key);
			} else if (context.getServiceType() == ServiceType.REST) {
				value = resolveRestBodyParameter(requestContext, key);
			}

			switch (expectedType) {
			case Integer:
				result = CommonMethods.isInteger(value);
				break;
			case Double:
				result = CommonMethods.isDouble(value);
				break;
			case Boolean:
				result = CommonMethods.isBoolean(value);
			case String:
				// Unable to detect
				result = true;
				break;
			default:
				result = false;
				break;
			}

		}

		Assert.assertTrue("Expected value type does not match", result);
	}

	private boolean checkJsonPropertyValue(TestRequestContext requestContext, String key, FieldType expectedType) {
		String body = requestContext.getRepsonseBody();

		ReadContext ctx = JsonPath.parse(body);
		@SuppressWarnings("rawtypes")
		Class type = Object.class;
		switch (expectedType) {
		case Double:
			type = Double.class;
			break;
		case Integer:
			type = Integer.class;
			break;
		case String:
			type = String.class;
			break;
		case Boolean:
			type = Boolean.class;
		default:
			break;
		}
		try {
			Object result = ctx.read("$." + key);
			return type.isInstance(result);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return true;
	}

	private void makeSoapRequest(String requestname) throws Exception {
		TestRequestContext requestContext = context.getRequestContext(requestname);

		WsdlOperation operation = ((SoapTestRequestContext) requestContext).getOperation();
		String methodName = requestContext.getMethodName();
		WsdlRequest request = operation.addNewRequest(methodName + "_" + "Request");
		String requestXMLString = operation.createRequest(true).toString();

		XmlHolder holder = new XmlHolder(requestXMLString);

		String headerXPath = "//*[local-name() = 'Header']";
		Node headerNode = holder.getDomNode(headerXPath);
		String headerNodeName = headerNode.getNodeName();
	
		String headerFirstXPath = headerXPath + "/*[1]";
		Node headerFirstNode = holder.getDomNode(headerFirstXPath);
		String headerFirstNodeName = headerFirstNode.getNodeName();
		String nameSpace = "";
		if(headerFirstNodeName.contains(":")){
			nameSpace = headerFirstNodeName.split(":")[0] + ":";
		}
		
		for (String key : requestContext.getRequestHeaders().keySet()) {
			String savedVal = requestContext.getRequestHeaders().get(key);
			key = nameSpace + key.replaceAll("\\.", "/" + nameSpace);
			String parameterName = String.format("//%s/%s", headerNodeName,key);
			holder.setNodeValue(parameterName, savedVal);
		}
		

		String methodNameXPath = "//*[local-name() = '"+ methodName +"']";
		
		Node methodNameNode = holder.getDomNode(methodNameXPath);
		String methodNodeName =  methodNameNode.getNodeName();
		
		Node firstElementNode = holder.getDomNode(methodNameXPath + "/*[1]");
		String firstNodeName = firstElementNode.getNodeName();
		nameSpace = "";
		if(firstNodeName.contains(":")){
			nameSpace = firstNodeName.split(":")[0] + ":";
		}
		
		// TODO: Improve
		for (String key : requestContext.getBodyParameters().keySet()) {
			SavedValue savedVal = requestContext.getBodyParameters().get(key);
			key = nameSpace + key.replaceAll("\\.", "/" + nameSpace);
			String parameterName = String.format("//%s/%s", methodNodeName,key);
			holder.setNodeValue(parameterName, savedVal.getValue());
		}
		
		//Remove empty value tags
		String emptyValueXPath = "//*[text()='?']";
		holder.removeDomNodes(emptyValueXPath);

		//Remove empty tags
		String emptyTagXPath= "//*[not(normalize-space())]";
		holder.removeDomNodes(emptyTagXPath);
		
		requestXMLString = holder.getXml();

		LOG.debug("Request String Content: " + requestXMLString);
		// generate the request content from the schema
		request.setRequestContent(requestXMLString);
		
		WsdlSubmitContext submitContext = new WsdlSubmitContext(request);
		//submitContext.setProperty("URL", context.getRequestURL());
		String endpointURL = context.getRequestURL();
		if(endpointURL != null && endpointURL.length() > 0){
			request.setEndpoint(endpointURL);
		}
		
		WsdlSubmit<?> submit = (WsdlSubmit<?>) request.submit(submitContext, false);
		// wait for the response
		
		//TODO: Review
		int statusCode = ((BaseHttpResponse)submit.getResponse()).getStatusCode();
		requestContext.setStatusCode(statusCode + "");

		Response response = submit.getResponse();
		requestContext.setRepsonseBody(response.getContentAsString());
	}

	private void checkSoapResultParameter(String requestname, String key, String exceptedValue) {
		String value = getSoapResponseValue(requestname, key);
		Assert.assertEquals(exceptedValue, value);
	}

	private String getSoapResponseValue(String requestname, String key) {
		String value = "";
		TestRequestContext requestContext = context.getRequestContext(requestname);

		try {
			XmlHolder holder = new XmlHolder(requestContext.getRepsonseBody());
		
			String resultXPath = "//*[local-name() = 'Body']/*[1]";
			Node resultNode = holder.getDomNode(resultXPath);
			String resultNodeName = resultNode.getNodeName();
			
			Node firstElementNode = holder.getDomNode(resultXPath + "/*[1]");
			String firstNodeName = firstElementNode.getNodeName();
			String nameSpace = "";
			if(firstNodeName.contains(":")){
				nameSpace = firstNodeName.split(":")[0] + ":";
			}
			
			key = nameSpace + key.replaceAll("\\.", "/" + nameSpace);
			
			String xPath = "//" + resultNodeName + "/" + key;
			value = holder.getNodeValue(xPath);
		
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return value;
	}

	private void makeRestRequest(String requestname) throws MalformedURLException, IOException {
		String charset = "UTF-8";

		TestRequestContext requestContext = context.getRequestContext(requestname);
		String url = context.getBaseURL();
		if (requestContext.methodName != null) {
			String[] parts = requestContext.methodName.split("\\/");
			requestContext.methodName = "";
			for (int i = 0; i < parts.length; i++) {
				String urlPart = parts[i];
				if (urlPart.length() == 0) {
					continue;
				}

				if (urlPart.startsWith("#")) {
					urlPart = resolveValue(urlPart).getValue();
				}
				requestContext.methodName += "/" + urlPart;
			}

			url += requestContext.methodName;
		}

		Map<String, String> queryParameters = requestContext.getQueryParameters();
		if (queryParameters.size() > 0) {
			url += "?" + buildQueryString(queryParameters);
		}
		SSLUtilities.trustAllHostnames();
		SSLUtilities.trustAllHttpsCertificates();
		
		HttpURLConnection httpCon = (HttpURLConnection) new URL(url).openConnection();
		httpCon.setRequestProperty("Accept-Charset", "UTF-8");
		httpCon.setRequestProperty("Authorization", "Basic " + getP());

		String method = requestContext.getMethod();
		httpCon.setRequestMethod(method);
		httpCon.setDoOutput(true);

		Map<String, String> headers = requestContext.getRequestHeaders();
		for (Iterator<String> iterator = headers.keySet().iterator(); iterator.hasNext();) {
			String key = iterator.next();
			httpCon.setRequestProperty(key, headers.get(key));
		}

		Map<String,String> cookies = requestContext.getCookieParameters();
		String myCookies = "";
		String[] keys = new String[0];
		keys = cookies.keySet().toArray(keys);
		for (int i = 0; i < keys.length; i++) {
			String key = keys[i];
			
			if(i > 0){
				myCookies += "; ";
			}
			
			myCookies += key + "=" + cookies.get(key);
		}

		httpCon.setRequestProperty("Cookie", myCookies);

		Map<ContentType, String> contentTypeMap = new HashMap<ContentType, String>();
		contentTypeMap.put(ContentType.FORM, "application/x-www-form-urlencoded");
		contentTypeMap.put(ContentType.PLAIN, "text/plain");
		contentTypeMap.put(ContentType.JSON, "application/json");
		contentTypeMap.put(ContentType.XML, "application/xml");

		if (method.equals("PUT") || method.equals("POST") || method.equals("DELETE")) {
			ContentType type = requestContext.getRequestContentType();
			if (contentTypeMap.containsKey(type)) {
				httpCon.setRequestProperty("Content-Type", contentTypeMap.get(type));
			}

			String body = constructBody(requestname);
			if(body != null){
				OutputStream output = httpCon.getOutputStream();
				output.write(body.getBytes(charset));
				output.close();
			}
		}

		InputStream response = null;

		if (httpCon.getResponseCode() == 200) {
			response = httpCon.getInputStream();
		} else {
			/* error from server */
			response = httpCon.getErrorStream();
		}

		String responseBody = IOUtils.toString(response, charset);
		requestContext.setRepsonseBody(responseBody);

		requestContext.setStatusCode(httpCon.getResponseCode() + "");

		Map<String, List<String>> responseHeaders = httpCon.getHeaderFields();

		for (String key : responseHeaders.keySet()) {
			requestContext.getResponseHeaders().put(key, responseHeaders.get(key).get(0));
			
			if (key != null && key.equals("Set-Cookie")) {                  
				List<String> responseCookies = responseHeaders.get(key);
				responseCookies.toString();
				
				for (String cookie : responseCookies) {
					String cookieName = cookie.substring(0, cookie.indexOf("="));
			        String cookieValue = cookie.substring(cookie.indexOf("=") + 1, cookie.length());
			        requestContext.getResponseCookies().put(cookieName,cookieValue);
				}
		 	}
		}
	}

	private void checkRestResultParameter(String requestname, String key, String exceptedValue) {
		TestRequestContext requestContext = context.getRequestContext(requestname);
		String parameter = resolveRestBodyParameter(requestContext, key);
		Assert.assertEquals(exceptedValue, parameter);
	}

	private SavedValue resolveValue(String value) {
		if (!value.startsWith("#")) {
			return SavedValue.getInstance(value);
		} else {
			value = value.substring(1);
			String[] parts = value.split("\\.");
			String requestName = parts[0];
			TestRequestContext requestContext = context.getRequestContext(requestName);

			if (context.getServiceType() == ServiceType.SOAP) {
				return resolveSoapValue(requestContext, parts);
			} else if (context.getServiceType() == ServiceType.REST) {
				return resolveRestValue(requestContext, parts);
			}
			return SavedValue.getInstance("");
		}
	}

	private SavedValue resolveSoapValue(TestRequestContext requestContext, String[] parts) {
		String requestName = parts[0];
		String requestPart = parts[1];

		String key = "";

		for (int i = 2; i < parts.length; i++) {
			if (key.length() > 0) {
				key += ".";
			}
			key += parts[i];
		}

		if (requestPart.equals("request")) {
			return requestContext.bodyParameters.get(key);
		} else if (requestPart.equals("response")) {
			return SavedValue.getInstance(getSoapResponseValue(requestName, key));
		} else if (requestPart.equals("statuscode")) {
			return SavedValue.getInstance(requestContext.getStatusCode());
		} else if (requestPart.equals("savedvariables")) {
			return requestContext.getSavedVariables().get(key);
		}
		return null;
	}

	private String constructBody(String requestName) {
		TestRequestContext requestContext = context.getRequestContext(requestName);

		if (requestContext.bodyValue != null && requestContext.bodyValue.length() > 0) {
			return requestContext.bodyValue;
		}
		if (requestContext.getRequestContentType() != null) {
			switch (requestContext.getRequestContentType()) {
			case FORM:
				return constructFormBody(requestName);
			case JSON:
				return constructJsonBody(requestName);
			case PLAIN:
				return constructPlainBody(requestName);
			case XML:
				return constructXmlBody(requestName);
			default:
				return null;
			}
		}
		return null;
	}

	private String constructPlainBody(String requestName) {
		return context.getRequestContext(requestName).getBodyValue();
	}

	private String constructFormBody(String requestName) {

		String body = "";
		TestRequestContext requestContext = context.getRequestContext(requestName);
		try {
			Map<String, SavedValue> params = requestContext.getBodyParameters();
			Map<String, String> values = extractSavedValues(params);
			body = buildQueryString(values);

		} catch (UnsupportedEncodingException e) {
		}
		return body;
	}

	private Map<String, String> extractSavedValues(Map<String, SavedValue> params) throws UnsupportedEncodingException {
		Map<String, String> values = new HashMap<String, String>();
		for (String key : params.keySet()) {
			values.put(key, params.get(key).getValue());
		}
		return values;
	}

	private String buildQueryString(Map<String, String> params) throws UnsupportedEncodingException {
		String body = "";
		for (Iterator<String> iterator = params.keySet().iterator(); iterator.hasNext();) {
			String key = iterator.next();
			String value = params.get(key);
			value = URLEncoder.encode(value, "UTF-8");

			if (body.length() > 0) {
				body += "&";
			}
			body += key + "=" + value;
		}
		return body;
	}

	@SuppressWarnings("unused")
	private String constructXmlBody(String requestName) {
		TestRequestContext reqContext = context.getRequestContext(requestName);
		Map<String, SavedValue> body = reqContext.getBodyParameters();
		
		//TODO: get xml root name
		XmlConstructor xmlObj = new XmlConstructor(reqContext.getXmlBodyRootNodeName());
		for (String key : body.keySet()) {
			xmlObj.addElementToParent(key, body.get(key).getValue());
		}
		
		return xmlObj.toString();
	}

	private String constructJsonBody(String requestName) {
		TestRequestContext reqContext = context.getRequestContext(requestName);
		Map<String, SavedValue> body = reqContext.getBodyParameters();

		List<String> keys = new ArrayList<String>();
		keys.addAll(body.keySet());
		Object obj = null;
		try {
			obj = new JsonHelper().buildJson(keys, body);
		} catch (Exception ex) {
			Assert.fail("Unable to build json body");
		}
		return obj.toString();
	}

	private SavedValue resolveRestValue(TestRequestContext requestContext, String[] parts) {
		String requestPart = parts[1];
		String segmentPart = parts[2];

		String key = "";

		for (int i = 3; i < parts.length; i++) {
			String string = parts[i];
			key += string;
			if (i < parts.length - 1) {
				key += ".";
			}
		}

		if (requestPart.equals("request")) {
			if (segmentPart.equals("body")) {
				return requestContext.bodyParameters.get(key);
			} else if (segmentPart.equals("header")) {
				return SavedValue.getInstance(requestContext.requestHeaders.get(key));
			} else if (segmentPart.equals("query")) {
				return SavedValue.getInstance(requestContext.queryParameters.get(key));
			} else if (segmentPart.equals("cookie")) {
				return SavedValue.getInstance(requestContext.cookieParameters.get(key));
			}
		} else if (requestPart.equals("response")) {
			if (segmentPart.equals("body")) {
				return SavedValue.getInstance(resolveRestBodyParameter(requestContext, key));
			} else if (segmentPart.equals("header")) {
				return SavedValue.getInstance(requestContext.responseHeaders.get(key));
			} else if (segmentPart.equals("cookie")) {
				return SavedValue.getInstance(requestContext.getResponseCookies().get(key));
			}
		} else if (requestPart.equals("statuscode")) {
			return SavedValue.getInstance(requestContext.getStatusCode());
		} else if (requestPart.equals("savedvariables")) {
			return requestContext.getSavedVariables().get(parts[2]);
		}
		return null;
	}

	private String resolveRestBodyParameter(TestRequestContext requestContext, String key) {
		String responseBody = requestContext.getRepsonseBody();

		ContentType responseContent = requestContext.getResponseContentType();

		String value = "";

		if (responseContent == ContentType.JSON) {

			ReadContext ctx = JsonPath.parse(responseBody);
			value = ctx.read("$." + key).toString();

		} else if (responseContent == ContentType.XML) {

			try {
				XmlHolder holder = new XmlHolder(responseBody);
				value = holder.getNodeValue(key);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else {
			if (key == null || key.length() == 0) {
				value = responseBody;
			}
			Assert.fail("Invalid operation. Response content type is not JSON or XML");
		}

		return value;
	}

	public String getP() {
		String s1 = "jyD4aQ";
		String s2 = "QfmQOESENBOjleTyI";
		String s3 = "4SatY1WGtXfF2WUi";
		String s4 = "mv24D8";

		String p = "EcT";
		p = s2.substring(s1.length(), s2.indexOf('e')) + p
				+ s3.substring(s4.indexOf('4') + 1, s4.length() + s4.indexOf('4') + 1);

		return p;

	}

}
