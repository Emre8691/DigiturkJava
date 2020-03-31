package itelli.webtests.converters;

import java.lang.reflect.Type;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jbehave.core.steps.ParameterConverters.NumberConverter;

/**
 * {@link org.jbehave.core.steps.ParameterConverters.ParameterConverter} implementation for number parameters which can be set
 * surrounded by '...'.
 * 
 * @author erwin.graf (created), 11.03.2013
 */
public class NumberParameterConverter extends NumberConverter {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.jbehave.core.steps.ParameterConverters.NumberConverter#convertValue(java.lang.String, java.lang.reflect.Type)
	 */
	@Override
	public Object convertValue(final String value, final Type type) {
		final Matcher matcherParameter = Pattern.compile("(^')(.*)('$)").matcher(value);
		String parameterValue = value;

		if (matcherParameter.find()) {
			parameterValue = matcherParameter.replaceFirst("$2");
		}
		return super.convertValue(parameterValue, type);
	}
}
