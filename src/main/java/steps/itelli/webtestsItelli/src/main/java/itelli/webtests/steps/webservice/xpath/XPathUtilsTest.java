/**
 * 
 */
package steps.itelli.webtestsItelli.src.main.java.itelli.webtests.steps.webservice.xpath;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

/**
 * @author bchild
 *
 */
public class XPathUtilsTest {

  @Test
	public void testGetChildElementName() throws Exception {
		String childElement = XPathUtils.getChildElementName("/root/child[3]");
	
		assertEquals("child", childElement);
		assertNull(XPathUtils.getChildElementName(""));
		assertNull(XPathUtils.getChildElementName(null));
	}

	@Test
	public void testGetParentXPath() throws Exception {
		String parentPath = XPathUtils.getParentXPath("/root[1]/child");
		assertEquals("/root[1]", parentPath);
		assertNull(XPathUtils.getParentXPath("/root"));
		assertNull(XPathUtils.getParentXPath(""));
		assertNull(XPathUtils.getParentXPath(null));
	}

	@Test
	public void testGetChildElementIndex() throws Exception {
		Integer childIndex = XPathUtils.getChildElementIndex("/root/child[3]");
		assertEquals(new Integer(3), childIndex);
		childIndex = XPathUtils.getChildElementIndex("/root/child");
		assertEquals(new Integer(1), childIndex);
		assertNull(XPathUtils.getChildElementIndex(""));
		assertNull(XPathUtils.getChildElementIndex(null));
	}

	@Test
	public void testCreatePositionXpath() throws Exception {
		String positionXPath = XPathUtils.createPositionXpath("/root/child", 5);
		assertEquals("/root/child[position()<5]", positionXPath);
		
		positionXPath = XPathUtils.createPositionXpath("/root/anotherChild[6]", 6);
		assertEquals("/root/anotherChild[position()<6]", positionXPath);
	}

}
