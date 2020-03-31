package itelli.webtests.converters;

import java.lang.reflect.Type;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jbehave.core.steps.ParameterConverters.ParameterConverter;

import itelli.webtests.domain.SiteType;

/**
 * {@link ParameterConverter} implementation for {@link SiteType} enums.
 * 
 * @author stefan.person (created), 21.12.2012
 */
public class SiteTypeConverter implements ParameterConverter {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.jbehave.core.steps.ParameterConverters.ParameterConverter#accept(java.lang.reflect.Type)
	 */
	@Override
	public boolean accept(final Type type) {
		if (type instanceof Class<?>) {
			return ((Class<?>) type).equals(SiteType.class);
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.jbehave.core.steps.ParameterConverters.ParameterConverter#convertValue(java.lang.String, java.lang.reflect.Type)
	 */
	@Override
	public Object convertValue(final String value, final Type type) {
		final Matcher matcherParameter = Pattern.compile("(^')(.*)('$)").matcher(value);
		String parameterValue = value;

		if (matcherParameter.find()) {
			parameterValue = matcherParameter.replaceFirst("$2");
		}
		return SiteType.parseSiteTypeDisplayString(parameterValue);
	}
}
