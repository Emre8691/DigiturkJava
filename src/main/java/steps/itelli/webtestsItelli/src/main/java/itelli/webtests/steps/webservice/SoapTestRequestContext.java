package steps.itelli.webtestsItelli.src.main.java.itelli.webtests.steps.webservice;

import com.eviware.soapui.impl.wsdl.WsdlOperation;


public class SoapTestRequestContext extends TestRequestContext {

	WsdlOperation operation;
	SoapWebserviceTestContext webserviceContext;
	
	
	public SoapTestRequestContext(String requestName,SoapWebserviceTestContext serviceContext) {
		super(requestName);
		webserviceContext = serviceContext;
		requestContentType = ContentType.XML;
		queryParameters = null;
	}
	
	@Override
	public void setMethodName(String methodName) {
		super.setMethodName(methodName);
		operation = (WsdlOperation) webserviceContext.getIface().getOperationByName(methodName);
	}
	
	public WsdlOperation getOperation() {
		return operation;
	}

	public void setOperation(WsdlOperation operation) {
		this.operation = operation;
	}
}
