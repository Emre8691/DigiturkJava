package steps.itelli.webtestsItelli.src.main.java.itelli.webtests.steps.webservice;

import java.io.IOException;
import java.util.Map;

import org.apache.xmlbeans.XmlException;

import com.eviware.soapui.impl.WsdlInterfaceFactory;
import com.eviware.soapui.impl.wsdl.WsdlInterface;
import com.eviware.soapui.impl.wsdl.WsdlOperation;
import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.support.SoapUIException;

import itelli.webtests.steps.webservice.WebserviceTestContext.ServiceType;

public class SoapWebserviceTestContext extends WebserviceTestContext {
	WsdlProject project;
	WsdlInterface iface;
	
	
	public SoapWebserviceTestContext() throws XmlException, IOException, SoapUIException {
		super();
		setServiceType(ServiceType.SOAP);
		project = new WsdlProject();
		
	}

	@Override
	public void setBaseURL(String baseURL) throws Exception {
		super.setBaseURL(baseURL);
		iface = WsdlInterfaceFactory.importWsdl(project, baseURL, true)[0];
	}

	public WsdlProject getProject() {
		return project;
	}

	public void setProject(WsdlProject project) {
		this.project = project;
	}

	public WsdlInterface getIface() {
		return iface;
	}

	public void setIface(WsdlInterface iface) {
		this.iface = iface;
	}

	@Override
	public void addContext(String name){
		this.addContext(name,new SoapTestRequestContext(name,this));
	}
}
