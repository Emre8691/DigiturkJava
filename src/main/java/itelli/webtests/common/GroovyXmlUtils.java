package itelli.webtests.common;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import groovy.util.slurpersupport.NodeChild;
import groovy.xml.XmlUtil;

public class GroovyXmlUtils{

	private GroovyShell shell;
	private String script = "";
	
	public GroovyXmlUtils loadXml(String xml){
		Binding binding = new Binding();
		binding.setVariable("xmlValue", xml);
		shell = new GroovyShell(binding);

		script += "def envelope = new XmlSlurper().parseText(xmlValue)" + "\n";
		return this;
	}
	
	public GroovyXmlUtils setProperty(String key,String value){
		script += key + "=\"" + value + "\""+ "\n";
		return this;
	}
	
	//TODO: Test
	public String getPropertyValue(String key){
		script += "return " + key;
		Object value = shell.evaluate(script);
		return value.toString();
	}
	
	public String getFinalXml(){
		script += "return envelope";
		Object value = shell.evaluate(script);
		return XmlUtil.serialize((NodeChild)value);
	}
}
