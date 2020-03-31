package itelli.webtests.common;

import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.Assert;

/**
 * @author suatd 07/11/216
 *
 */
public class DslLogBeauty {

	static Logger logger;

	public static void logger(int errorId, Object[] params, Exception ex, Object clazz) {
		logger = Logger.getLogger(clazz.getClass().getSimpleName());
		String all = "";
		all = all + "SMART_BUG_START" + "\r\n";
		all = all + "\r\n" +"Clas Name : " + clazz + "\r\n";
		all = all + "Error Time : " + new Date() + "\r\n";
		all = all + "ErrorId : " + errorId + "\r\n";
		all = all + "Error Description : " + DSLLogConstract.getDSLError(params, errorId) + "\r\n";
		all = all + "Exception : " + ex + "\r\n";
		all = all + "SMART_BUG_END" + "\r\n";
		logger.debug(all);
		Assert.assertTrue(all, false);
	}
}