package steps.itelli.webtestsItelli.src.main.java.itelli.webtests.steps.webservice;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CommonMethods {
	public static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
		return true;
	}

	public static Boolean isDate(String value, String format) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(format);
			dateFormat.parse(value);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}

	public static Boolean isDouble(String value) {
		try {
			Double.parseDouble(value);
		} catch (NumberFormatException e) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
		return true;
	}

	public static Boolean isBoolean(String value) {
		return "true".equalsIgnoreCase(value) || "false".equalsIgnoreCase(value);
	}
}
