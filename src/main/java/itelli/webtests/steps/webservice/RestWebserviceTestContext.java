package itelli.webtests.steps.webservice;

import com.eviware.soapui.impl.wsdl.WsdlProject;

public class RestWebserviceTestContext extends WebserviceTestContext {
	

	public RestWebserviceTestContext() {
		super();
		this.setServiceType(ServiceType.REST);
		
	}
}
