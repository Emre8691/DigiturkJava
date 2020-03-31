package steps.itelli.webtestsItelli.src.main.java.itelli.webtests.steps.webservice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import itelli.webtests.steps.webservice.WebserviceTestContext.FieldType;

public class JsonHelper {

	public Object buildJson(List<String> keys, Map<String, SavedValue> values) throws JSONException {
		Collections.sort(keys);
		if (keys.get(0).startsWith("[")) {
			return buildArray("", keys, values);
		} else {
			return buildComplexObject("", keys, values);
		}
	}

	private Object buildComplexObject(String prefix, List<String> keys, Map<String, SavedValue> values)
			throws JSONException {

		JSONObject obj = new JSONObject();

		for (int i = 0; i < keys.size(); i++) {
			String objectKey = keys.get(i);
			String valueKey = prefix + objectKey;

			if (objectKey.contains(".")) {
				String complexObjKey = objectKey.substring(0, objectKey.indexOf(".") + 1);
				String newObjectKey = complexObjKey.replace(".", "");

				List<String> originalKeys = new ArrayList<String>();
				Object newObj = null;

				if (newObjectKey.contains("[")) {
					newObjectKey = newObjectKey.split("\\[")[0];
					List<String> arrayKeys = new ArrayList<String>();
					for (int j = i; j < keys.size(); j++) {
						String key = keys.get(j);
						if (key.startsWith(newObjectKey)) {
							String tmpKey = key.substring(key.indexOf("["));
							arrayKeys.add(tmpKey);
							originalKeys.add(key);
						}
					}
					newObj = buildArray(prefix + newObjectKey, arrayKeys, values);
				} else {
					List<String> complexObjectFieldKeys = new ArrayList<String>();
					for (int j = i; j < keys.size(); j++) {
						String key = keys.get(j);
						if (key.startsWith(complexObjKey)) {
							String tmpKey = key.substring(key.indexOf(".") + 1);
							complexObjectFieldKeys.add(tmpKey);
							originalKeys.add(key);
						}
					}

					newObj = buildComplexObject(prefix + complexObjKey, complexObjectFieldKeys, values);
				}

				obj.put(newObjectKey, newObj);
				keys.removeAll(originalKeys);
				i--;

			} else if (objectKey.contains("[")) {
				List<String> originalKeys = new ArrayList<String>();
				String newArrayKey = objectKey.split("\\[")[0];
				List<String> arrayKeys = new ArrayList<String>();
				for (int j = i; j < keys.size(); j++) {
					String key = keys.get(j);
					if (key.startsWith(newArrayKey)) {
						String tmpKey = key.substring(key.indexOf("["));
						arrayKeys.add(tmpKey);
						originalKeys.add(key);
					}
				}
				Object newArr = buildArray(prefix + newArrayKey, arrayKeys, values);

				obj.put(newArrayKey, newArr);
				keys.removeAll(originalKeys);
				i--;
			} else {
				Object value = convertToType(values.get(valueKey));
				obj.put(objectKey, value);
			}
		}

		return obj;

	}

	Pattern arrayPattern = Pattern.compile("(.+)\\[(\\d+)\\]");
	Pattern rootArrayPattern = Pattern.compile("(\\[\\d+\\])(.*)");
	Pattern objectArrayPattern = Pattern.compile("(\\[\\d+\\]\\.)(.+)");
	Pattern arrayIndexPattern = Pattern.compile("\\[(\\d+)\\]");

	private JSONArray buildArray(String prefix, List<String> keys, Map<String, SavedValue> values)
			throws JSONException {
		JSONArray arr = new JSONArray();

		for (int i = 0; i < keys.size(); i++) {
			String key = keys.get(i);
			String valueKey = prefix + key;

			Matcher m = rootArrayPattern.matcher(key);
			m.find();

			String arrPrefix = m.group(1);
			String objKey = m.group(2);

			m = arrayIndexPattern.matcher(arrPrefix);
			m.find();
			int index = Integer.parseInt(m.group(1));

			if (arr.length() != index) {
				throw new IllegalStateException("Unable to construct array with prefix: " + prefix
						+ ". Next expected index: " + arr.length() + ", received: " + index);
			}

			if (objKey.startsWith("[")) {
				List<String> originalComplexKeys = new ArrayList<String>();
				List<String> complexObjectFieldKeys = new ArrayList<String>();
				for (int j = i; j < keys.size(); j++) {
					String arrkey = keys.get(j);
					if (arrkey.startsWith(arrPrefix)) {

						m = rootArrayPattern.matcher(arrkey);
						m.find();

						String objectKey = m.group(2);

						complexObjectFieldKeys.add(objectKey);
						originalComplexKeys.add(arrkey);
					}
				}
				Object newObj = buildArray(prefix + arrPrefix, complexObjectFieldKeys, values);

				keys.removeAll(originalComplexKeys);
				i--;
				arr.put(newObj);

			} else if (objKey.startsWith(".")) {
				// arrPrefix = key.split("\\.")[0];

				List<String> originalComplexKeys = new ArrayList<String>();
				List<String> complexObjectFieldKeys = new ArrayList<String>();
				for (int j = i; j < keys.size(); j++) {
					String arrkey = keys.get(j);
					if (arrkey.startsWith(arrPrefix)) {

						m = objectArrayPattern.matcher(arrkey);
						m.find();

						String objectKey = m.group(2);

						complexObjectFieldKeys.add(objectKey);
						originalComplexKeys.add(arrkey);
					}
				}
				Object newObj = buildComplexObject(prefix + arrPrefix + ".", complexObjectFieldKeys, values);

				keys.removeAll(originalComplexKeys);
				i--;
				arr.put(newObj);
			} else {
				Object value = convertToType(values.get(valueKey));
				arr.put(value);
			}
		}

		return arr;
	}

	private Object convertToType(SavedValue savedVal) {

		FieldType type = savedVal.getFieldType();
		Object value = savedVal.getValue();
		switch (type) {
		case Double:
			value = Double.parseDouble(savedVal.getValue());
			break;
		case Integer:
			value = Integer.parseInt(savedVal.getValue());
			break;
		case Boolean:
			value = Boolean.parseBoolean(savedVal.getValue());
		default:
			break;
		}

		return value;
	}
}
