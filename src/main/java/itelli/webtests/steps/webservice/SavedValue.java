package itelli.webtests.steps.webservice;

import itelli.webtests.steps.webservice.WebserviceTestContext.FieldType;

public class SavedValue {
	private String value;
	private FieldType fieldType;

	public static SavedValue getInstance(String value) {
		return getInstance(value, FieldType.NA);
	}

	public static SavedValue getInstance(String value, FieldType type) {
		SavedValue val = new SavedValue();
		val.setValue(value);
		val.setFieldType(type);
		return val;
	}

	public FieldType getFieldType() {
		return fieldType;
	}

	public void setFieldType(FieldType fieldType) {
		this.fieldType = fieldType;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}