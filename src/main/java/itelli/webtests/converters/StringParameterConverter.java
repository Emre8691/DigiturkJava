package itelli.webtests.converters;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.apache.log4j.Logger;
import org.jbehave.core.steps.ParameterConverters.ParameterConverter;

import itelli.webtests.pages.common.ContextInformation;
import itelli.webtests.pages.common.ContextInformationProvider;

/**
 * {@link ParameterConverter} implementation for String parameters given directly or mapped via properties.
 * 
 * @author erwin.graf (created), 11.03.2013
 */
public class StringParameterConverter implements ParameterConverter {

	private static final Logger LOG = Logger.getLogger(StringParameterConverter.class);

	private ContextInformationProvider contextInformationProvider;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.jbehave.core.steps.ParameterConverters.ParameterConverter#accept(java.lang.reflect.Type)
	 */
	@Override
	public boolean accept(final Type type) {
		if (type instanceof Class<?>) {
			return ((Class<?>) type).equals(String.class);
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
		final Matcher matcherScriptParameter = Pattern.compile("(^#)(.*)(#$)").matcher(value);
		String parameterValue = value;

		if (matcherScriptParameter.find()) {
			parameterValue = matcherScriptParameter.replaceFirst("$2");
			try {
				ScriptEngineManager factory = new ScriptEngineManager();
				ScriptEngine engine = factory.getEngineByName("nashorn");
				//ScriptObjectMirror jsDate = (ScriptObjectMirror) engine.eval("new Date();")
				//engine.eval("d = new java.util.Date();");
				//ScriptObjectMirror jsDate = (ScriptObjectMirror)engine.get("d");
				//Date jsDate = (Date)engine.get("d");
				
				parameterValue = engine.eval(parameterValue).toString();
				//System.out.println(jsDate);
			} catch (Exception ex) {
				System.out.println(ex);
			}
		}

		final Matcher matcherVariableParameter = Pattern.compile("(^@)(.*)(@$)").matcher(parameterValue);

		if (matcherVariableParameter.find()) {
			parameterValue = matcherVariableParameter.replaceFirst("$2");
			if (parameterValue.startsWith("today")) {
				String pattern = "dd/MM/yyyy";
				if (parameterValue.contains("-")) {
					pattern = parameterValue.substring(parameterValue.indexOf("-")+1);
				}
				parameterValue = new SimpleDateFormat(pattern).format(new java.util.Date());
			}
		}

		final Matcher matcherStringParameter = Pattern.compile("(^')(.*)('$)").matcher(parameterValue);

		if (matcherStringParameter.find()) {
			parameterValue = matcherStringParameter.replaceFirst("$2");
		}

		final Matcher matcherPropertyParameter = Pattern.compile("(^<)(.*)(>$)").matcher(parameterValue);
		if (matcherPropertyParameter.find()) {
			final String parameter = matcherPropertyParameter.replaceFirst("$2");
			final Map<String, String> metaMap = getContextInformation().getMetaMap();
			if (metaMap == null) {
				StringParameterConverter.LOG.error("Unable to load parameter " + value + "from properties");
			}
			else {
				parameterValue = metaMap.get(parameter);
				if (parameterValue == null) {
					StringParameterConverter.LOG.error("Parameter " + value + " not found in properties");
				}
			}
		}
		return parameterValue;
	}

	public final ContextInformation getContextInformation() {
		return getContextInformationProvider().getContextInformation();
	}

	public ContextInformationProvider getContextInformationProvider() {
		return contextInformationProvider;
	}

	public void setContextInformationProvider(ContextInformationProvider contextInformationProvider) {
		this.contextInformationProvider = contextInformationProvider;
	}
}
