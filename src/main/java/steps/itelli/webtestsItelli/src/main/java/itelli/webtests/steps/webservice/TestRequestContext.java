package steps.itelli.webtestsItelli.src.main.java.itelli.webtests.steps.webservice;

import java.util.HashMap;
import java.util.Map;

import steps.itelli.webtestsItelli.src.main.java.itelli.webtests.steps.webservice.WebserviceTestContext.ContentType;


public class TestRequestContext {

	String requestName;

	String methodName;
	String method; // GET,POST,PUT,DELETE
	ContentType requestContentType;
	Map<String, String> requestHeaders;
	Map<String, String> queryParameters;
	Map<String, SavedValue> bodyParameters;
	String bodyValue;
	
	private String xmlBodyRootNodeName;

	Map<String, String> cookieParameters;

	String statusCode;
	String repsonseBody;
	Map<String, String> responseHeaders;
	Map<String, String> responseCookies;
	private ContentType responseContentType;

	private Map<String, SavedValue> savedVariables;

	public TestRequestContext(String requestName) {
		this.requestName = requestName;

		queryParameters = new HashMap<String, String>();
		bodyParameters = new HashMap<String, SavedValue>();
		cookieParameters = new HashMap<String, String>();
		requestHeaders = new HashMap<String, String>();

		responseHeaders = new HashMap<String, String>();
		responseCookies = new HashMap<String, String>();
		savedVariables = new HashMap<String, SavedValue>();
	}

	public ContentType getRequestContentType() {
		return requestContentType;
	}

	public void setRequestContentType(ContentType requestContentType) {
		this.requestContentType = requestContentType;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public Map<String, String> getQueryParameters() {
		return queryParameters;
	}

	public void setQueryParameters(Map<String, String> queryParameters) {
		this.queryParameters = queryParameters;
	}

	public Map<String, SavedValue> getBodyParameters() {
		return bodyParameters;
	}

	public void setBodyParameters(Map<String, SavedValue> bodyParameters) {
		this.bodyParameters = bodyParameters;
	}

	public String getBodyValue() {
		return bodyValue;
	}

	public void setBodyValue(String bodyValue) {
		this.bodyValue = bodyValue;
	}

	public Map<String, String> getCookieParameters() {
		return cookieParameters;
	}

	public void setCookieParameters(Map<String, String> cookieParameters) {
		this.cookieParameters = cookieParameters;
	}

	public String getRepsonseBody() {
		return repsonseBody;
	}

	public void setRepsonseBody(String repsonseBody) {
		this.repsonseBody = repsonseBody;
	}

	public Map<String, String> getResponseHeaders() {
		return responseHeaders;
	}

	public void setResponseHeaders(Map<String, String> responseHeaders) {
		this.responseHeaders = responseHeaders;
	}

	public Map<String, String> getRequestHeaders() {
		return requestHeaders;
	}

	public void setRequestHeaders(Map<String, String> requestHeaders) {
		this.requestHeaders = requestHeaders;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public Map<String, String> getResponseCookies() {
		return responseCookies;
	}

	public void setResponseCookies(Map<String, String> responseCookies) {
		this.responseCookies = responseCookies;
	}

	public String getRequestName() {
		return requestName;
	}

	public void setRequestName(String requestName) {
		this.requestName = requestName;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getMethod() {
		return this.method;
	}

	public ContentType getResponseContentType() {
		return responseContentType;
	}

	public void setResponseContentType(ContentType responseContentType) {
		this.responseContentType = responseContentType;
	}

	public Map<String, SavedValue> getSavedVariables() {
		return savedVariables;
	}

	public void setSavedVariables(Map<String, SavedValue> savedVariables) {
		this.savedVariables = savedVariables;
	}

	public String getXmlBodyRootNodeName() {
		return xmlBodyRootNodeName;
	}

	public void setXmlBodyRootNodeName(String xmlBodyRootNodeName) {
		this.xmlBodyRootNodeName = xmlBodyRootNodeName;
	}
}