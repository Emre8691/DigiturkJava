package itelli.webtests.config;

import java.text.MessageFormat;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.jbehave.core.embedder.EmbedderMonitor;
import org.jbehave.core.embedder.MetaFilter;
import org.jbehave.core.model.Meta;
import org.jbehave.core.model.Meta.Property;

// @formatter:off
/**
 * Using an own MetaFilter to overwrite and enhance the match method.
 *
 * Enhanced match:
 * - Enable setting a filter once for multiple filter values (separator is a blank character)
 *   f.e.  -missingpayment.exclude checkout_bosch_us checkout_bosch_be_*
 * - Enable setting a filter to activate additional scenarios (prefix is character '&')
 *   f.e.  &productivSystem
 */
// @formatter:on
public class ExtendedMetaFilter extends MetaFilter {

	/**
	 * Constructor
	 * 
	 * @param filterAsString Filter string
	 * @param monitor Logging Monitor
	 */
	public ExtendedMetaFilter(final String filterAsString, final EmbedderMonitor monitor) {
		super(filterAsString, monitor);
	}

	/**
	 * Creates an enhanced MetaMatcher based on the filter content.
	 * 
	 * @param filterAsString the String representation of the filter
	 * @return A MetaMatcher
	 */
	@Override
	protected MetaMatcher createMetaMatcher(final String filterAsString) {
		return new ExtendedDefaultMetaMatcher();
	}

	/**
	 * Extended DefaultMetaMatcher overwrites the match method of default implemen
	 */
	final class ExtendedDefaultMetaMatcher extends MetaFilter.DefaultMetaMatcher implements MetaFilter.MetaMatcher {

		private static final String META_PREFIX_PATTERN = "(\\{0}(\\w|\\.|\\,|\\;|\\:|\\!|\\$|\\&|\\s|\\*)*)";

		/**
		 * Enhanced match method to handle additional scenarios
		 * 
		 * @param meta Filter description in local.properties or default.properties
		 * @return Result if scenario meta properties matches defined meta filters
		 */
		@Override
		public boolean match(final Meta meta) {
			final Properties include = include();
			final Properties exclude = exclude();
			boolean matched;

			if (!include.isEmpty() && exclude.isEmpty()) {
				matched = match(include, meta);
			}
			else if (include.isEmpty() && !exclude.isEmpty()) {
				matched = !match(exclude, meta);
			}
			else if (!include.isEmpty() && !exclude.isEmpty()) {
				matched = match(merge(include, exclude), meta) && !match(exclude, meta);
			}
			else {
				matched = true;
			}

			// enable additional scenarios only if meta filter are set
			if (!matched) {
				final Properties addOn = new Properties();
				parse(addOn, "&");
				if (!addOn.isEmpty()) {
					matched = match(addOn, meta);
				}
			}
			return matched;
		}

		/**
		 * Enhanced match method to check for multiple values set within once filter definition
		 * 
		 * @param properties Meta properties set for story or scenario
		 * @param meta Filter description in local.properties or default.properties
		 * @return Result if scenario meta properties matches defined meta filters
		 */
		private boolean match(final Properties properties, final Meta meta) {
			boolean matches = false;
			for (final Object key : properties.keySet()) {
				final String property = (String) properties.get(key);
				for (final String metaName : meta.getPropertyNames()) {
					if (key.equals(metaName)) {
						final String value = meta.getProperty(metaName);
						if (StringUtils.isBlank(value)) {
							matches = true;
						}
						else if (property.contains("*")) {
							final String filterProperties = (String) properties.get(key);
							// filter value may contain multiple values
							final String[] filterValues = filterProperties.split(" ");
							for (final String filterValue : filterValues) {

								if (value.matches(filterValue.replace("*", ".*"))) {
									matches = true;
									break;
								}
							}
							if (value.matches(property.replace("*", ".*"))) {
								matches = true;
							}
						}
						else {
							final String filterProperties = (String) properties.get(key);
							// filter value may contain multiple values
							final String[] filterValues = filterProperties.split(" ");
							for (final String filterValue : filterValues) {
								if (filterValue.equals(value)) {
									matches = true;
									break;
								}
							}
						}
					}
					if (matches) {
						break;
					}
				}
			}
			return matches;
		}

		private void parse(final Properties properties, final String prefix) {
			properties.clear();
			for (final String found : found(prefix)) {
				final Property property = new Property(StringUtils.removeStartIgnoreCase(found, prefix));
				properties.setProperty(property.getName(), property.getValue());
			}
		}

		private Set<String> found(final String prefix) {
			final Matcher matcher = findAllPrefixed(prefix).matcher(asString());
			final Set<String> found = new HashSet<String>();
			while (matcher.find()) {
				found.add(matcher.group().trim());
			}
			return found;
		}

		private Pattern findAllPrefixed(final String prefix) {
			return Pattern.compile(MessageFormat.format(META_PREFIX_PATTERN, prefix), Pattern.DOTALL);
		}

		private Properties merge(final Properties include, final Properties exclude) {
			final Set<Object> allKeys = new HashSet<Object>(include.keySet());
			allKeys.addAll(exclude.keySet());
			final Properties merged = new Properties();
			for (final Object key : allKeys) {
				if (include.containsKey(key)) {
					merged.put(key, include.get(key));
				}
				else if (exclude.containsKey(key)) {
					merged.put(key, exclude.get(key));
				}
			}
			return merged;
		}
	}
}
