package steps.itelli.webtestsItelli.src.main.java.itelli.webtests.pages.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientResponse;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import itelli.webtests.config.WebTestsConfiguration;
import itelli.webtests.domain.Brand;
import itelli.webtests.domain.Language;
import itelli.webtests.domain.SiteType;
import steps.itelli.webtestsItelli.src.main.java.itelli.webtests.domain.Country;



/**
 * Reader for getting named properties, usable for scenario meta data.
 */
public class PropertiesReader {

	private static final Logger LOG = Logger.getLogger(PropertiesReader.class);

	private WebTestsConfiguration webTestsConfiguration;
	private ContextInformationProvider contextInformationProvider;

	private final Map<String, Properties> propertyFiles = new HashMap<String, Properties>();

	private static final int FILTER_PRIORITY_1 = 1;
	private static final int FILTER_PRIORITY_2 = 2;
	private static final int FILTER_PRIORITY_3 = 3;
	private static final int FILTER_PRIORITY_4 = 4;
	private static final int FILTER_PRIORITY_5 = 5;
	private static final int FILTER_PRIORITY_6 = 6;
	private static final int FILTER_PRIORITY_LOWEST = 7;

	private static final String TESTEDSYSTEM_PARAMETERS = "testedsystem.";

	/**
	 * PropertyFilter to contain filter string and priority
	 */
	private final class PropertyFilter {

		private final String propFilter;
		private final int propPriority;

		public PropertyFilter(final String filter, final int priority) {
			propFilter = filter;
			propPriority = priority;
		}

		private String getFilter() {
			return propFilter;
		}

		private Integer getPriority() {
			return Integer.valueOf(propPriority);
		}
	}

	/**
	 * Gets the property for Parameter Converter from properties file.<br>
	 * 
	 * @param fromFile The filename containing the property
	 * @param withName The name of the property
	 * @return The property value.
	 */
	public final String getProperty(final String fromFile, final String withName) {
		try {
			if (!propertyFiles.containsKey(fromFile)) {
				propertyFiles.put(fromFile, getPropertiesByPath(fromFile));
			}
		}
		catch (final IOException ioe) {
			return StringUtils.EMPTY;
		}
		return StringUtils.defaultString(propertyFiles.get(fromFile).getProperty(withName));
	}

	/**
	 * Gets the property for Parameter Converter from global properties file.<br>
	 * 
	 * @param fromFile The filename containing the property
	 * @param withName The name of the property
	 * @return The property value.
	 */
	public final String getGlobalProperty(final String fromFile, final String withName) {
		try {
			if (!propertyFiles.containsKey(fromFile)) {
				propertyFiles.put(fromFile, getGlobalPropertiesByPath(fromFile));
			}
		}
		catch (final IOException ioe) {
			return StringUtils.EMPTY;
		}
		final Properties properties = propertyFiles.get(fromFile);
		if (properties != null) {
			final Map<String, String> params = filterNamedParametersFromProperties(properties);
			if (!params.isEmpty()) {
				final String prop = params.get(withName);
				if (prop != null) {
					return prop;
				}
			}
			return StringUtils.defaultString(properties.getProperty(withName));
		}
		return StringUtils.EMPTY;
	}

	/**
	 * Gets the list of properties for Parameter Converter from global properties file.<br>
	 * 
	 * @param fromFile The filename containing the property
	 * @param startsWithName The starting name of the properties
	 * @return The map of found properties.
	 */
	public final Map<String, String> getGlobalProperties(final String fromFile, final String startsWithName) {
		final Map<String, String> propertiesMap = new HashMap<String, String>();
		try {
			if (!propertyFiles.containsKey(fromFile)) {
				propertyFiles.put(fromFile, getGlobalPropertiesByPath(fromFile));
			}
		}
		catch (final IOException ioe) {
			return propertiesMap;
		}

		final Properties properties = propertyFiles.get(fromFile);

		for (final String properyName : properties.stringPropertyNames()) {
			final String propertyKey = properyName.toLowerCase(Locale.US);
			if (propertyKey.startsWith(startsWithName)) {
				propertiesMap.put(propertyKey.substring(startsWithName.length()), properties.getProperty(properyName));
			}
		}
		return propertiesMap;
	}

	private Properties getPropertiesByPath(final String fileName) throws IOException {
		final Properties properties = new Properties();
		final String testedSystem = getWebTestsConfiguration().getTestedSystem().toLowerCase(Locale.US);
		final String resourcePath = new StringBuilder("/itelli/webtests/config/").append(testedSystem).append('/')
				.append(fileName.toLowerCase(Locale.US)).append(".properties").toString();

		properties.load(this.getClass().getResourceAsStream(resourcePath));
		processParameterizedProperties(properties, testedSystem);
		return properties;
	}

	private Properties getGlobalPropertiesByPath(final String fileName) throws IOException {
		final Properties properties = new Properties();
		final String resourcePath = new StringBuilder("/itelli/webtests/config/global/")
				.append(fileName.toLowerCase(Locale.US)).append(".properties").toString();

		final InputStream stream = this.getClass().getResourceAsStream(resourcePath);

		if (stream == null) {
			throw new IllegalStateException("Unable to load " + resourcePath + ". Please check if parameter exist in file!");
		}

		properties.load(stream);
		String testedSystem = getWebTestsConfiguration().getTestedSystem().toLowerCase(Locale.US);
		processParameterizedProperties(properties, testedSystem);
		return properties;
	}

	private Properties getLocalPropertiesByPath() throws IOException {
		final Properties properties = new Properties();
		final String path = "/local.properties";

		final InputStream stream = this.getClass().getResourceAsStream(path);
		if (stream == null) {
			// local.properties file is optional!
			PropertiesReader.LOG.warn("unable to load " + path);
		}
		else {
			try {
				properties.load(stream);
				String testedSystem = getWebTestsConfiguration().getTestedSystem().toLowerCase(Locale.US);
				processParameterizedProperties(properties, testedSystem);
			}
			catch (final IOException ioe) {
				PropertiesReader.LOG.error("unable to load " + path);
			}
		}
		return properties;
	}

	/**
	 * Reads in the key and values from the global properties file.<br>
	 * 
	 * @param parameters The Map containing the named parameters.
	 */
	public void getNamedParametersFromGlobalProperties(final Map<String, String> parameters) {
		try {
			final Properties properties = getGlobalPropertiesByPath("global");

			if (properties != null) {
				final Map<String, String> params = filterNamedParametersFromProperties(properties);
				if (!params.isEmpty()) {
					parameters.putAll(params);
				}
			}
		}
		catch (final IOException e) {
			PropertiesReader.LOG.error("Read properties from global.properties file failed", e);
		}
	}

	/**
	 * Reads in the key and values from the local properties file.<br>
	 * 
	 * @param parameters The Map containing the named parameters.
	 */
	public void getNamedParametersLocalProperties(final Map<String, String> parameters) {
		try {
			final Properties properties = getLocalPropertiesByPath();
			if (properties != null) {
				for (final String key : properties.stringPropertyNames()) {
					parameters.put(key, properties.getProperty(key).trim());
				}
			}
		}
		catch (final IOException e) {
			PropertiesReader.LOG.error("Read properties from local.properties file failed", e);
		}
	}

	/**
	 * Reads in the key and values from the common properties file.<br>
	 * 
	 * @param parameters The Map containing the named parameters.
	 */
	public void getNamedParametersFromCommonProperties(final Map<String, String> parameters) {
		final Map<String, String> params = readNamedParametersFromProperties("common");
		if (!params.isEmpty()) {
			parameters.putAll(params);
		}
	}

	/**
	 * Reads in the key and values from a properties file usable for named parameters.<br>
	 * 
	 * @param filename The name of the properties file
	 * @param parameters The Map containing the named parameters.
	 */
	public void getNamedParametersFromProperties(final String filename, final Map<String, String> parameters) {
		final Map<String, String> params = readNamedParametersFromProperties(filename);
		if (params.isEmpty()) {
			PropertiesReader.LOG.warn("Warning, no properties found in tested system file: " + filename);
			try {
				final Properties properties = getGlobalPropertiesByPath(filename);
				final Map<String, String> paramsDefault = filterNamedParametersFromProperties(properties);
				if (paramsDefault.isEmpty()) {
					PropertiesReader.LOG.warn("Warning, no properties found in global config directory for file: " + filename);
				}
				else {
					parameters.putAll(paramsDefault);
				}
			}
			catch (final IOException e) {
				PropertiesReader.LOG.error("Read properties from global config directory failed for file: " + filename, e);
			}

		}
		else {
			parameters.putAll(params);
		}
	}

	/**
	 * Reads in the key and values from a properties file usable for named parameters.<br>
	 * 
	 * @param filename The name of the properties file
	 * @return The Map containing the named parameters, can be empty but never null.
	 */
	private Map<String, String> readNamedParametersFromProperties(final String filename) {
		final Properties props = new Properties();
		loadProperties(props, filename);

		return filterNamedParametersFromProperties(props);
	}

	/**
	 * Reads in the key and values from a properties file usable for named parameters.<br>
	 * 
	 * @param filename The name of the properties file
	 * @return The Map containing the named parameters, can be empty but never null.
	 */
	private Map<String, String> filterNamedParametersFromProperties(final Properties props) {
		final String brand = getBrandFilter();
		final String language = getLanguageFilter();
		final String country = getCountryFilter();
		final String siteType = getSiteTypeFilter();

		final List<PropertyFilter> propFilters = findPropertyFilters(brand, language, country, siteType);

		final String fullSpecifiedFilter = getFilter(brand, language, country, siteType);

		final Map<String, String> parameters = findParameters(props, brand, propFilters, fullSpecifiedFilter);

		return parameters;
	}

	/**
	 * Finds all parameters from the properties files.
	 * 
	 * @param props The property file object.
	 * @param brand The brand for which the properties will be loaded.
	 * @param propFilters The property filters which will be honored.
	 * @param fullSpecifiedFilter The full specified filter with brand, country and language information.
	 * @return Returns all parameters from the properties file.
	 */
	private Map<String, String> findParameters(final Properties props, final String brand,
			final List<PropertyFilter> propFilters, final String fullSpecifiedFilter) {
		final Map<String, String> parameters = new HashMap<String, String>();
		final Map<String, Integer> priorities = new HashMap<String, Integer>();

		for (final String key : props.stringPropertyNames()) {
			if (key.contains(".")) {
				if (!fullSpecifiedFilter.isEmpty() && key.startsWith(fullSpecifiedFilter)) {
					final String value = props.getProperty(key);
					final String keyName = key.substring(fullSpecifiedFilter.length());
					PropertiesReader.LOG.info("ADDED: " + keyName + "=" + value);
					parameters.put(keyName, value.trim());
					priorities.put(keyName, Integer.valueOf(PropertiesReader.FILTER_PRIORITY_1));
				}
				else if (key.startsWith(PropertiesReader.TESTEDSYSTEM_PARAMETERS)) {
					final String value = props.getProperty(key);
					final String keyName = key.substring(PropertiesReader.TESTEDSYSTEM_PARAMETERS.length());
					PropertiesReader.LOG.info("ADDED TESTEDSYSTEM_PARAMETER: " + keyName + "=" + value);
					parameters.put(keyName, value.trim());
					priorities.put(keyName, Integer.valueOf(PropertiesReader.FILTER_PRIORITY_LOWEST));
				}
				else if (brand != null && key.startsWith(brand)) {
					for (final PropertyFilter propFilter : propFilters) {
						final String filter = propFilter.getFilter();
						if (key.startsWith(filter) && key.indexOf(".", filter.length()) < 0) {
							final String value = props.getProperty(key);
							PropertiesReader.LOG.info("ADDED: " + key + "=" + value);

							final String paramKey = key.substring(filter.length());
							if (parameters.get(paramKey) == null) {
								parameters.put(paramKey, value.trim());
								priorities.put(paramKey, propFilter.getPriority());
							}
							else {
								final Integer oldPrio = priorities.get(paramKey);
								final Integer newPrio = propFilter.getPriority();
								if (oldPrio == null || newPrio.intValue() <= oldPrio.intValue()) {
									parameters.put(paramKey, value.trim());
									priorities.put(paramKey, newPrio);
								}
							}
							break;
						}
					}
				}
			}
			else {
				// general key for all brands (lowest priority)
				if (parameters.get(key) == null) {
					final String value = props.getProperty(key);
					PropertiesReader.LOG.info("ADDED: " + key + "=" + value);
					parameters.put(key, value.trim());
					priorities.put(key, Integer.valueOf(PropertiesReader.FILTER_PRIORITY_LOWEST));
				}
			}
		}

		return parameters;
	}

	/**
	 * Gets all property filters with their corresponding priority.
	 * 
	 * @param brand The brand information (optional).
	 * @param language The language information (optional).
	 * @param country The country information (optional).
	 * @param siteType The site-type (optional).
	 */
	private List<PropertyFilter> findPropertyFilters(final String brand, final String language, final String country,
			final String siteType) {
		final List<PropertyFilter> propFilters = new ArrayList<PropertyFilter>();

		if (language != null) {
			// additional filter without language
			propFilters.add(new PropertyFilter(getFilter(brand, null, country, siteType), PropertiesReader.FILTER_PRIORITY_2));

			if (country != null) {
				if (siteType != null) {
					// additional filter without language and country (check siteType first)
					propFilters
							.add(new PropertyFilter(getFilter(brand, null, null, siteType), PropertiesReader.FILTER_PRIORITY_3));
					// additional filter only without siteType
					propFilters.add(new PropertyFilter(getFilter(brand, language, country, null),
							PropertiesReader.FILTER_PRIORITY_4));
					// additional filter without language and siteType (only country)
					propFilters
							.add(new PropertyFilter(getFilter(brand, null, country, null), PropertiesReader.FILTER_PRIORITY_5));
				}
			}
			else {
				PropertiesReader.LOG.error("No country (only language) specified for properties in");
			}
		}
		else {
			if (country != null) {
				if (siteType != null) {
					// additional filter without country (check siteType first)
					propFilters
							.add(new PropertyFilter(getFilter(brand, null, null, siteType), PropertiesReader.FILTER_PRIORITY_3));
					// additional filter without siteType (only country)
					propFilters
							.add(new PropertyFilter(getFilter(brand, null, country, null), PropertiesReader.FILTER_PRIORITY_5));
				}
			}
		}

		if (language != null || country != null || siteType != null) {
			// at last additional filter only with brand
			propFilters.add(new PropertyFilter(getFilter(brand, null, null, null), PropertiesReader.FILTER_PRIORITY_6));
		}

		return propFilters;
	}

	private Properties loadProperties(final Properties properties, final String resource) {
		final StringBuilder filepath = new StringBuilder();

		String testedSystem = getWebTestsConfiguration().getTestedSystem().toLowerCase(Locale.US);
		String propertyFile;
		
		if(testedSystem.contains("sandbox")){
			propertyFile = "sandbox";
		}else{
			propertyFile = testedSystem;
		}
		
		final String path = filepath.append("/itelli/webtests/config/")
				.append(propertyFile).append('/').append(resource)
				.append(".properties").toString();

		PropertiesReader.LOG.info("LOADING " + path);
		final InputStream stream = this.getClass().getResourceAsStream(path);
		if (stream == null) {
			PropertiesReader.LOG.warn("unable to load " + path);
		} else {
			try {
				properties.load(stream);

				processParameterizedProperties(properties, testedSystem);

			} catch (final IOException ioe) {
				PropertiesReader.LOG.error("unable to load " + path);
			}
		}
		
		try {
			
			ContextInformation info = contextInformationProvider.getContextInformation();
			if (info.getBrand() != null && info.getCountry() != null) {
			
				String brand = info.getBrand().getDisplay().toLowerCase(Locale.ENGLISH);
				String country = info.getCountry().getIsocode().toLowerCase(Locale.ENGLISH);
				String type = info.getSiteType().getDisplayString().toLowerCase(Locale.ENGLISH);
				
				String language = null;
				String languageDisplayName = null;
				if(info.getLanguage() != null){
					language = info.getLanguage().getIsocode().toLowerCase(Locale.ENGLISH);
					languageDisplayName = info.getLanguage().getDisplay();
					
					if(languageDisplayName.equals("Deutsch")){
						languageDisplayName = "German";
					}
				}
			
				String propertiesFullKey=null;
				//example of propertiesFullKey: bosch.se.d2c.starturl
				if(language==null){
					propertiesFullKey = brand + "." + country + "." + type + ".starturl";
				}else{
					propertiesFullKey = brand + "." + language + "_" + country + "." + type + ".starturl";
				}
				
				if( properties.get(propertiesFullKey) != null ){
					LOG.info("loadProperties-1 : "+properties.get(propertiesFullKey));
					String newStartUrl = getUrlDynamic(brand, country, testedSystem, type, languageDisplayName, language);
					LOG.info("loadProperties-2 : "+newStartUrl);
					
					if(newStartUrl != null){
						//newStartUrl = "noservice";
						if (newStartUrl.equals("noservice")) {
							properties.put("shoplinksstatus", newStartUrl);
						} else {
							properties.put(propertiesFullKey, newStartUrl);
						}
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			//if the url-discover page is not accessable, thancontinue with properties default value.
		}
		
		return properties;
	}

	private String getUrlDynamic(String brand, String country, String testedSystem, String type, String languageDisplayName, String language) throws IOException{
		
		String url = null;
		
		String username = "";
		String password = "";
		
		LOG.info("getUrlDynamic-1: " + testedSystem);
		
		if(testedSystem.equals("production")){
			
			 if(country.equals("cn") ){
				 
				 //TODO: 
				 username = "";
				 password = "";
				 
				 url = "https://admin.d2cfarm.com/bshadmin/shoplinks";
				 
			 } else if (country.equals("ru")) {
				 
				 username = "bsh";
				 password = "testSiteMSK";
				 
				 url = "https://admin.ru.icorefarm.com/bshadmin/shoplinks";
				 
			 } else {
				 
				 username = "bsh";
				 password = "prodSiteD2C";
				 
				 url = "https://admin.d2cfarm.com/bshadmin/shoplinks";
			 }
			
			
		} else 	if(testedSystem.equals("futureint")){
						 
			 if(country.equals("cn") ){
				 
				//TODO: 
				 username = "";
				 password = "";
				 
				url = "https://admin-tt.cn.icorefarm.com/bshadmin/shoplinks";
				
			 } else if (country.equals("ru")) {
				 
				 username = "bsh";
				 password = "testSiteMSK";
				 
				 url = "https://admin-tt.ru.icorefarm.com/bshadmin/shoplinks";
				 
             } else if (country.equals("sg")) {
				 
				 username = "bsh";
				 password = "testSiteSIN";
				 
				 url = "https://admin-tt.sg.icorefarm.com/bshadmin/shoplinks";
				 
			 } else {
				 
				 username = "bsh";
				 password = "newSiteD2C";
				 
				 url = "https://admin-is.d2cfarm.com/bshadmin/shoplinks";
			 }
			 
		} else if(testedSystem.contains("sandbox")){
			
			url = "http://admin." + testedSystem + ".muc.icore.io/bshadmin/shoplinks";
			 
		} 
		
		LOG.info("getUrlDynamic-2: " + url);

		//future int credents. todo: cynamicly read from currenturl the country
		String login = username + ":" + password;
		

		String webPageAsString = doGetRequestWithJersey(username, password, url);
		Document document = Jsoup.parse(webPageAsString);
		
		
//		String base64login = new String(Base64.encodeBase64(login.getBytes()));
//		Document document = Jsoup
//		    .connect(url)
//		    .followRedirects(true)
//		    .timeout(60000)
//		    .ignoreContentType(true)
//		    .ignoreHttpErrors(true)
//		    .userAgent("Mozilla/5.0 (Windows NT 6.3; WOW64; rv:29.0) Gecko/20100101 Firefox/29.0")
//		    .header("Authorization", "Basic " + base64login)
//		    .post();
		
		if("d2c".equals(type)){
			type = "STORE";
		}
		
		if("staff".equals(type)){
			type = "Staff";
		}
		
		if("outlet".equals(type)){
			type = "outlet";
		}
		
		String _country = country;
		if(country.equals("gb")){
			_country = "uk";
		}
		
		String linkText = brand + " " + _country + " - " + type;
		
		if (webPageAsString.contains("Service Unavailable")) {
			return "noservice";
		}

		Elements linkLines = document.select(".js-shoplink");
		
		for (Element linkLine : linkLines) {
			
			Elements links = linkLine.select("a");
			
			for (Element linkEl : links) {
				String textOfEl = linkEl.text();
				
				if(textOfEl.toLowerCase(Locale.ENGLISH).indexOf((linkText.toLowerCase(Locale.ENGLISH))) != -1){
					
						if(languageDisplayName == null){
							return linkEl.attr("href");	
						}
						else{
							Elements columns = linkLine.select("td");
							
							for (Element column : columns) {
								if( column.text() != null && column.text().equals(language.toLowerCase()+"_"+country.toUpperCase()) ){
									return linkEl.attr("href");	
								}
								
								/*
								if( column.text() != null && column.text().startsWith("Lang:") ){
									
									if(column.text().endsWith(languageDisplayName)){
										return linkEl.attr("href");	
									}
								}
								*/
							}
						}
				}
			}
		}
		LOG.info("getUrlDynamic-3: ");
		return null;
	}
	
	private static String doGetRequestWithJersey(String username, String pass, String urlStr) {
		
		//request with jersey
		
		String line = "";
        try {
            URL url = new URL (urlStr);
            
            //basic auth
//            HttpAuthenticationFeature feature = 
//            		HttpAuthenticationFeature.basicBuilder()
//            	    .nonPreemptive()
//            	    .credentials(username, pass)
//            	    .build();
            
            //universal auth
	          HttpAuthenticationFeature feature = HttpAuthenticationFeature.universalBuilder()
	          .credentialsForBasic(username, pass)
	          .credentials(username, pass).build();
            
            
            ClientConfig clientConfig = new ClientConfig();
            clientConfig.register(feature) ;

            Client client = ClientBuilder.newClient(clientConfig);
            
            WebTarget webTarget = client.target(urlStr);
            Invocation.Builder invocationBuilder =  webTarget.request(MediaType.TEXT_PLAIN_TYPE);

            Response response = invocationBuilder.get();
           
            System.out.println( response.getStatus() );
            
            line = response.readEntity(String.class);
            
        } catch(Exception e) {
            e.printStackTrace();
        }
		return line;

    }
	
	private static String doGetRequest(String username, String pass, String urlStr) {
		
		//simple httprequest with java
		
		String line = "";
        try {
            URL url = new URL (urlStr);
            String login = username + ":" + pass;
            String encoding = new String(Base64.encodeBase64(login.getBytes()));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setRequestProperty  ("Authorization", "Basic " + encoding);
            InputStream content = (InputStream)connection.getInputStream();
            BufferedReader in   = 
                new BufferedReader (new InputStreamReader (content));
            
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
		return line;

    }
	
	
	private void processParameterizedProperties(final Properties properties, String testedSystem) {
		ContextInformation info = contextInformationProvider.getContextInformation();
		if (info.getBrand() != null && info.getCountry() != null) {
			String brand = info.getBrand().getDisplay().toLowerCase(Locale.ENGLISH);
			String country = info.getCountry().getIsocode().toLowerCase(Locale.ENGLISH);
			Language lng = info.getLanguage();
			String langStr = "";
			if (lng != null) {
				langStr = lng.getIsocode().toLowerCase(Locale.ENGLISH);
			}
			String story = info.getStoryName();
			
			if (story.contains("rollout")){
				story = story.substring(story.lastIndexOf('/') + 1);
			}
			else {
				story = story.substring(story.lastIndexOf('-') + 1);
			}
				
	
			Object[] keys = new Object[properties.size()];
			keys = properties.keySet().toArray(keys);
			for (Object key : keys) {
				String value = properties.getProperty(key.toString());
				if (value.contains("{")) {
					properties.remove(key);
	
					value = value.replace("{env}", testedSystem);
	
					value = value.replace("{issuekey}", story);
					value = value.replace("{country}", country);
					value = value.replace("{brand}", brand);
					value = value.replace("{lang}", langStr);
					
					properties.put(key, value);
				}
			}
		}
	}

	private String getFilter(final String brand, final String language, final String country, final String siteType) {
		final StringBuffer filter = new StringBuffer();

		if (brand != null) {
			filter.append(brand);
		}
		if (language != null) {
			filter.append(language);
		}
		if (country != null) {
			filter.append(country);
		}
		if (siteType != null) {
			filter.append(siteType);
		}
		return filter.toString();
	}

	private String getBrandFilter() {
		final Brand brand = getContextInformation().getBrand();
		if (brand == null) {
			PropertiesReader.LOG.error("No Brand specified for reading properties");
			return null;
		}
		final String filter = brand.getDisplay().toLowerCase(Locale.US);
		if (filter.isEmpty()) {
			PropertiesReader.LOG.error("Brand specified for reading properties is empty");
		}
		return filter + ".";
	}

	private String getLanguageFilter() {
		final Language language = getContextInformation().getLanguage();
		if (language == null) {
			return null; // not mandatory
		}
		final String filter = language.getIsocode().toLowerCase(Locale.US);
		if (filter.isEmpty()) {
			PropertiesReader.LOG.error("Language specified for reading properties is empty");
		}
		return filter + "_";
	}

	private String getCountryFilter() {
		final Country country = getContextInformation().getCountry();
		if (country == null) {
			return null; // not mandatory
		}
		final String filter = country.getIsocode().toLowerCase(Locale.US);
		if (filter.isEmpty()) {
			PropertiesReader.LOG.error("Country specified for reading properties is empty");
		}
		return filter + ".";
	}

	private String getSiteTypeFilter() {
		final SiteType type = getContextInformation().getSiteType();
		if (type == null) {
			return null; // not mandatory
		}
		final String filter = type.getDisplayString().toLowerCase(Locale.US);
		if (filter.isEmpty()) {
			PropertiesReader.LOG.error("SiteType specified for reading properties is empty");
		}
		return filter + ".";
	}

	protected final WebTestsConfiguration getWebTestsConfiguration() {
		return webTestsConfiguration;
	}

	public final void setWebTestsConfiguration(final WebTestsConfiguration webTestsConfiguration) {
		this.webTestsConfiguration = webTestsConfiguration;
	}

	protected final ContextInformation getContextInformation() {
		return getContextInformationProvider().getContextInformation();
	}

	public ContextInformationProvider getContextInformationProvider() {
		return contextInformationProvider;
	}

	public void setContextInformationProvider(ContextInformationProvider contextInformationProvider) {
		this.contextInformationProvider = contextInformationProvider;
	}

}
