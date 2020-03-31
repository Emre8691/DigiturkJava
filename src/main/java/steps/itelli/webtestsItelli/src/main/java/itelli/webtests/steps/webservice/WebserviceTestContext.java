package steps.itelli.webtestsItelli.src.main.java.itelli.webtests.steps.webservice;

import java.util.HashMap;
import java.util.Map;

public abstract class WebserviceTestContext {
	private ServiceType serviceType;
	private String baseURL;
	private String requestURL;
	
	
	private Map<String, TestRequestContext> contexts;

	public WebserviceTestContext() {
		this.contexts = new HashMap<String, TestRequestContext>();
	}

	public ServiceType getServiceType() {
		return serviceType;
	}

	public void setServiceType(ServiceType seviceType) {
		this.serviceType = seviceType;
	}

	public String getBaseURL() {
		return baseURL;
	}

	public void setBaseURL(String baseURL) throws Exception {
		this.baseURL = baseURL;
	}

	
	public Map<String, TestRequestContext> getContexts() {
		return contexts;
	}

	public void setContexts(Map<String, TestRequestContext> contexts) {
		this.contexts = contexts;
	}

	public TestRequestContext getRequestContext(String name) {
		if (!this.contexts.containsKey(name)) {
			addContext(name);
		}
		return this.contexts.get(name);
	}

	public void addContext(String name) {
		this.addContext(name, new TestRequestContext(name));
	}

	public void addContext(String name, TestRequestContext context) {
		this.contexts.put(name, context);
	}

	public String getRequestURL() {
		return requestURL;
	}

	public void setRequestURL(String requestURL) {
		this.requestURL = requestURL;
	}

	public enum ServiceType {
		SOAP, REST
	}

	public enum ContentType {
		JSON, XML, FORM, PLAIN
	}

	public enum FieldType {
		NA, Integer, Double, String, Boolean
	}

	

}
