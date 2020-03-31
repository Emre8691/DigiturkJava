package steps.itelli.webtestsItelli.src.main.java.itelli.webtests.common;

/**
 * @author suatd 07/11/216
 */
public class DSLLogConstract {

	public final static int ELEMENT_NOT_FOUND = 1000;
	public final static int URL_NOT_FOUND = 1001;
	public final static int PAGE_NOT_FOUND = 1002;
	public final static int URL_IS_NOT_MATCHING = 1003;
	public final static int MULTI_ELEMENT_NOT_FOUND = 1004;
	public final static int ELEMENT_IS_EMPTY = 1005;
	public final static int WITHOUT_PARAMATER = 1006;
	public static final int ELEMENT_NOT_EQUALS = 1007;
	public static final int SAP_EXECUTION_INFO_NOT_ADDED = 1008;
	
	public static String getDSLError(Object[] params, int errorId) {

		switch (errorId) {
		
			case ELEMENT_NOT_FOUND:
				String htmlElementSelector = (String) params[0];
				String objType1 = (String) params[1];
				return objType1 + " with " + htmlElementSelector + " not found.";
	
			case URL_NOT_FOUND:
				String pageUrl = (String) params[0];
				String pageUrlDesc = (String) params[1];
				return  pageUrlDesc + " with this url : " + pageUrl;
				
			case PAGE_NOT_FOUND:
				Object page = params[0];
				String pageObjType = (String) params[1];
				return pageObjType + " for " + page.getClass() + " not found.";
				
			case URL_IS_NOT_MATCHING:
				Object openPage = params[0];
				String openPageObjType = (String) params[1];
				return openPageObjType + " for " + openPage + " not found.";
				
			case MULTI_ELEMENT_NOT_FOUND:
				Object element = params[0];
				Object objId = params[1];
				Object elemntsObjType =  params[2];
				return elemntsObjType + " " + element + " for " + objId + " not found.";
			
			case ELEMENT_IS_EMPTY:
				String elementIsEmpty = (String) params[0];
				String objTypeElement = (String) params[1];
				return objTypeElement + " with " + elementIsEmpty + " is empty.";
			
			case WITHOUT_PARAMATER:
				String withoutParameter = (String) params[0];
				return withoutParameter;
				
			case ELEMENT_NOT_EQUALS:
				Object eqParam1 = params[0];
				Object eqParam2 = params[1];
				String equalsParameter = (String) params[2];
				return equalsParameter + eqParam1 + " and " +  eqParam2 + " are not equals.";

			case SAP_EXECUTION_INFO_NOT_ADDED:
				Object orderNumber = params[0];
				Object issueId = params[1];
				return "Error for order " + orderNumber + " and test id " +  issueId;

			default:
				break;
		}

		return null;
	}
}