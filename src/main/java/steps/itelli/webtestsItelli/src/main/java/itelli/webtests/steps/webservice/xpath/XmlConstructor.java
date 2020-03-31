/**
 * 
 */
package steps.itelli.webtestsItelli.src.main.java.itelli.webtests.steps.webservice.xpath;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.springframework.stereotype.Service;

/**
 * @author bchild
 *
 */
public class XmlConstructor {

	private static final Logger LOGGER = Logger.getLogger(XmlConstructor.class.getName());

	private Document document;

	public XmlConstructor(String rootElementName) {
		this.document = DocumentHelper.createDocument(DocumentHelper.createElement(rootElementName));
	}

	/**
	 * Recursive method to create an element and, if necessary, its parents and
	 * siblings
	 * 
	 * @param document
	 * @param xpath
	 *            to single element
	 * @param value
	 *            if null an empty element will be created
	 * @return the created Node
	 */
	public Node addElementToParent(String xpath, String value) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("adding Element: " + xpath + " -> " + value);
		}

		String elementName = XPathUtils.getChildElementName(xpath);
		String parentXPath = XPathUtils.getParentXPath(xpath);
		Node parentNode = document.selectSingleNode(parentXPath);
		if (parentNode == null) {
			parentNode = addElementToParent(parentXPath, null);
		}

		// create younger siblings if needed
		Integer childIndex = XPathUtils.getChildElementIndex(xpath);
		if (childIndex > 1) {
			List<?> nodelist = document.selectNodes(XPathUtils.createPositionXpath(xpath, childIndex));
			// how many to create = (index wanted - existing - 1 to account for
			// the new element we will create)
			int nodesToCreate = childIndex - nodelist.size() - 1;
			for (int i = 0; i < nodesToCreate; i++) {
				((Element) parentNode).addElement(elementName);
			}
		}

		Element created = null;
		if (elementName.startsWith("@")) {
			elementName = elementName.substring(1);
			((Element) parentNode).addAttribute(elementName, value);
		} else {
			created = (Element) document.selectSingleNode(xpath);
			if (created == null) {
				// create requested element
				created = ((Element) parentNode).addElement(elementName);
			}

			if (null != value) {
				created.addText(value);
			}
		}
		return created;
	}

	@Override
	public String toString() {
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		StringWriter writer = new StringWriter();
		XMLWriter xmlwriter = new XMLWriter(writer, format);
		try {
			xmlwriter.write(document);
			return writer.getBuffer().toString();
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
		}

		return null;
	}
}
