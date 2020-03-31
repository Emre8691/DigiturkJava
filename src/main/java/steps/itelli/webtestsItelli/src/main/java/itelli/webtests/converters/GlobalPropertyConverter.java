package steps.itelli.webtestsItelli.src.main.java.itelli.webtests.converters;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import junit.framework.Assert;

import org.apache.commons.lang.StringUtils;
import org.jbehave.core.steps.ParameterConverters.ParameterConverter;
import org.springframework.beans.factory.annotation.Required;

import itelli.webtests.pages.common.PropertiesReader;

/**
 * Class {@link GlobalPropertyConverter} for reading properties from /resources/itelli/webtests/config/global directory
 * of <tt>propertyType</tt>.properties files using the given <tt>propertyNames</tt> attributes to be set.<br/>
 * <br/>
 * This is configured in the spring-configuration.xml for Brand, Country Language currently.
 * 
 * @author bjoern.wedi (created), 25.02.2013
 * @author $Author$ (last changed)
 * @version $Rev$, $Date$ $Id: $
 */
public class GlobalPropertyConverter implements ParameterConverter {

	private PropertiesReader propertiesReader;
	private Class<?> propertyType;
	private List<String> propertyNames;
	private String propertiesMapName;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.jbehave.core.steps.ParameterConverters.ParameterConverter#accept(java.lang.reflect.Type)
	 */
	@Override
	public boolean accept(final Type type) {
		if (type instanceof Class<?>) {
			return ((Class<?>) type).equals(propertyType);
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
		final Map<String, String> propertyMap = new HashMap<String, String>();
		final Map<String, String> propertiesMap = new HashMap<String, String>();

		for (final String propertyName : propertyNames) {
			final String property = (propertyType.getSimpleName() + "." + parameterValue + "." + propertyName)
					.toLowerCase(Locale.US);
			final String propertyValue = propertiesReader.getGlobalProperty(propertyType.getSimpleName(), property);
			if (StringUtils.isBlank(propertyValue) && !parameterValue.equals(parameterValue.toLowerCase(Locale.US))) {
				Assert.fail("Got empty property value for \"" + property + "\" for parameter \"" + parameterValue + "\" for \""
						+ propertyType.getSimpleName()
						+ "\" (check case sensitivity, property names must always written in lower case!");
			}
			Assert.assertNotNull("Could not receive property \"" + property + "\" for attribute \"" + property + "\" for \""
					+ propertyType.getSimpleName() + "\"!", propertyValue);
			propertyMap.put(propertyName, propertyValue);
		}
		if (propertiesMapName != null && !propertiesMapName.isEmpty()) {
			final String propertiesFilter = (propertyType.getSimpleName() + "." + parameterValue + ".").toLowerCase();
			final Map<String, String> foundProperties = propertiesReader.getGlobalProperties(propertyType.getSimpleName(),
					propertiesFilter);
			if (foundProperties != null && !foundProperties.isEmpty()) {
				propertiesMap.putAll(foundProperties);
			}
		}
		try {
			final Object object = propertyType.newInstance();
			for (final Map.Entry<String, String> entry : propertyMap.entrySet()) {
				new PropertyDescriptor(entry.getKey(), propertyType).getWriteMethod().invoke(object, entry.getValue());
			}
			if (!propertiesMap.isEmpty()) {
				new PropertyDescriptor(propertiesMapName, propertyType).getWriteMethod().invoke(object, propertiesMap);
			}
			return object;
		}
		catch (final InstantiationException ie) {
			Assert.assertNull("Could not create instance of type " + propertyType.getSimpleName(), ie);
		}
		catch (final IllegalAccessException iae) {
			Assert.assertNull("Could not set attribute " + parameterValue + " of type " + propertyType.getSimpleName(), iae);
		}
		catch (final IllegalArgumentException iae) {
			Assert.assertNull("Could not set attribute " + parameterValue + " of type " + propertyType.getSimpleName(), iae);
		}
		catch (final InvocationTargetException ite) {
			Assert.assertNull("Could not set attribute " + parameterValue + " of type " + propertyType.getSimpleName(), ite);
		}
		catch (final IntrospectionException ie) {
			Assert.assertNull("Could not find attribute " + parameterValue + " of type " + propertyType.getSimpleName(), ie);
		}
		return null;
	}

	@Required
	public final void setPropertiesReader(final PropertiesReader propertiesReader) {
		this.propertiesReader = propertiesReader;
	}

	@Required
	public final void setPropertyType(final Class<?> propertyType) {
		this.propertyType = propertyType;
	}

	@Required
	public final void setPropertyNames(final List<String> propertyNames) {
		this.propertyNames = propertyNames;
	}

	public final void setPropertiesMapName(final String propertiesMapName) {
		this.propertiesMapName = propertiesMapName;
	}
}
