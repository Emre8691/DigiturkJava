package steps.itelli.webtestsItelli.src.main.java.itelli.webtests;


import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.embedder.Embedder.EmbedderFailureStrategy;
import org.jbehave.core.embedder.EmbedderControls;
import org.jbehave.core.embedder.EmbedderMonitor;
import org.jbehave.core.embedder.MetaFilter;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.failures.PassingUponPendingStep;
import org.jbehave.core.failures.PendingStepStrategy;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.model.Meta;
import org.jbehave.core.model.Scenario;
import org.jbehave.core.model.Story;
import org.jbehave.core.reporters.CrossReference;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporter;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.MarkUnmatchedStepsAsPending;
import org.jbehave.core.steps.ParameterConverters.ParameterConverter;
import org.jbehave.core.steps.Step;
import org.jbehave.core.steps.spring.SpringStepsFactory;
import org.jbehave.web.selenium.SeleniumConfiguration;
import org.jbehave.web.selenium.SeleniumContext;
import org.jbehave.web.selenium.SeleniumContextOutput;
import org.jbehave.web.selenium.WebDriverHtmlOutput;
import org.jbehave.web.selenium.WebDriverProvider;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import itelli.webtests.config.ExtendedMetaFilter;
import itelli.webtests.config.WebTestsConfiguration;
import itelli.webtests.pages.common.ContextInformation;
import itelli.webtests.pages.common.ContextInformationProvider;
import net.sf.saxon.expr.StringTokenIterator;

/**
 * Entry Point of the web tests. Should be called with JUnit.<br>
 * All the stories are executed within the JUnit Test. We use Spring to configure all the web tests "application". Per convention,
 * we define all beans in XML. But we have to use @Resource here in this class due to the Spring Lifecycle.<br>
 * We extend {@link JUnitStories} so we are accordant with the JBehave framework. But we have to overwrite a lot of methods so we
 * can have our desired configuration.
 * 
 * @author stefan.person (created), 21.12.2012
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring-configuration.xml" })
public class WebTests extends JUnitStories implements ApplicationContextAware {

	private static final long MAX_STORY_TIMEOUT = 3600 * 3;
	private static final String IGNORE_FOR_ADDON_FILTER = "ignore";

	/**
	 * Using an own Embedder to overwrite default of MetaFilter (ExtendedMetaFilter to enhance match method).
	 */
	final class MyEmbedder extends Embedder {

		@Override
		public MetaFilter metaFilter() {
			final List<String> filters = this.metaFilters();
			if (!filters.contains("-" + IGNORE_FOR_ADDON_FILTER)) {
				filters.add("-" + IGNORE_FOR_ADDON_FILTER);	// add exclude filter for handling addon filters starting with '&'
			}
			return new ExtendedMetaFilter(StringUtils.join(filters, " "), this.embedderMonitor());
		}
	}

	private final Embedder embedder = new MyEmbedder();

	private ApplicationContext applicationContext;

	@Resource(name = "webTestConfiguration")
	private WebTestsConfiguration webTestsConfiguration;
	@Resource
	private ContextInformationProvider contextInformationProvider;
	@Resource(name = "webDriverProvider")
	private WebDriverProvider webDriverProvider;
	@Resource(name = "parameterConverters")
	private List<ParameterConverter> parameterConverters;
	public static Map<String,String> storyDescriptions = new HashMap<String, String>();

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.jbehave.core.ConfigurableEmbedder#configuredEmbedder()
	 */
	@Override
	public Embedder configuredEmbedder() {
		// Steps factory has to be the first call because it
		// fixes the application context during the maven-run.
		embedder.useStepsFactory(stepsFactory());
		embedder.useConfiguration(configuration());
		embedder.useEmbedderControls(embedderControls());
		embedder.useEmbedderFailureStrategy(failureStategy());
		embedder.useEmbedderMonitor(getEmbedderMonitor());
		embedder.useMetaFilters(getMetaFilter());
		embedder.useSystemProperties(systemProperties());
		return embedder;
	}

	/**
	 * Using an own step collector to add parameters from properties files to meta map before starting the secanrio.
	 */
	final class MyStepCollector extends MarkUnmatchedStepsAsPending {

		private final ThreadLocal<StoryReporter> reporterData;
		private final ThreadLocal<String> storyData;

		/**
		 * @param storyData contains the name of the current story
		 * @param reporterData contains used StoryReporter
		 */
		public MyStepCollector(final ThreadLocal<String> storyData, final ThreadLocal<StoryReporter> reporterData) {
			super();
			this.reporterData = reporterData;
			this.storyData = storyData;
		}

		@Override
		public List<Step> collectBeforeOrAfterStorySteps(final List<CandidateSteps> candidateSteps, final Story story,
				final Stage stage, final boolean givenStory) {

			// set story name without suffix for all containing scenarios
			if (!givenStory) {
				final String storyName = story.getName();
				storyData.set(StringUtils.removeEnd(storyName, ".story"));
				try {

					String _storyName = storyData.get();

					if(storyData.get().indexOf("_")>0){

						_storyName = storyData.get().split("_")[0];

						String _country = storyData.get().split("_")[1].toUpperCase();

						String _countryFirstCharUpperCase = ("" +_country.charAt(0)).toUpperCase() + _country.substring(1).toLowerCase();

						WebTests.storyDescriptions.put(_storyName + " " + _country, extractStoryDescription(story.getDescription().asString(), _storyName) );
						WebTests.storyDescriptions.put(_storyName + " " + _countryFirstCharUpperCase, extractStoryDescription(story.getDescription().asString(), _storyName) );

						WebTests.storyDescriptions.put(storyData.get().replaceAll("_", " "), extractStoryDescription(story.getDescription().asString(), _storyName) );

					}

					WebTests.storyDescriptions.put(_storyName, extractStoryDescription(story.getDescription().asString(), _storyName) );

				} catch (Exception e) {
					WebTests.storyDescriptions.put(storyData.get()," ");
					Logger.getLogger(getClass()).error("Can not extract story description",e);
				}

			}
			return super.collectBeforeOrAfterStorySteps(candidateSteps, story, stage, givenStory);
		}

		private String extractStoryDescription(String raw, String storyName) {
			String desc = "";
			int firstIndex = raw.indexOf("!", 5);

			int nextIndex = raw.indexOf("!", firstIndex+1);

			if (nextIndex > (firstIndex+5)) {
				desc = raw.substring(firstIndex+5,nextIndex).replaceAll(storyName, "");
			}
			return desc;

		}

		@Override
		public List<Step> collectScenarioSteps(final List<CandidateSteps> candidateSteps, final Scenario scenario,
				final Map<String, String> parameters) {

			// get loaded context parameters (possibly loaded via DSL "Given are properties from ...")
			// which are set for the scenario and put it all into parameters
			final Map<String, String> metaMap = getContextInformation().getMetaMap();
			if (metaMap != null) {
				parameters.putAll(metaMap);
			}

			// filter scenarios dynamically by story name (name of the story file without suffix)
			final String storyName = storyData.get();
			if (storyName != null) {
				final MetaFilter metaFilter = embedder.metaFilter();
				final Properties excludeFilter = new Properties();
				final Properties ignoreFilter = new Properties();
				final Properties storyFilter = new Properties();

				storyFilter.put("story", storyData.get());

				// report all excluded steps of given story
				if (!metaFilter.allow(new Meta(storyFilter))) {
					final StoryReporter reporter = reporterData.get();
					if (reporter != null) {
						reporter.scenarioNotAllowed(scenario, storyFilter.toString());
					}
					return new ArrayList<Step>();
				}

				// add storyName as value to any meta tag extended by ".exclude" of the scenario
				// to exclude some special scenarios steps by meta filter (default.properties)
				// f.e. within GivenStories (multiple used) but only for a certain story
				for (final String key : scenario.getMeta().getPropertyNames()) {
					excludeFilter.put(key + ".exclude", storyName);
					ignoreFilter.put(key + ".skip", storyName);
				}

				// add skip parameter for each scenario meta tag for addon filter handling
				for (final String key : scenario.getMeta().getPropertyNames()) {
					if (key.startsWith(IGNORE_FOR_ADDON_FILTER + ".")) {
						ignoreFilter.put(IGNORE_FOR_ADDON_FILTER, "");	// ignore this scenario by default
						ignoreFilter.put(key.substring(IGNORE_FOR_ADDON_FILTER.length() + 1), ""); // except addon is set
					}
				}
				// report all excluded steps of given scenario
				if (!metaFilter.allow(new Meta(excludeFilter))) {
					final StoryReporter reporter = reporterData.get();
					if (reporter != null) {
						reporter.scenarioNotAllowed(scenario, excludeFilter.toString());
					}
					return new ArrayList<Step>();
				}

				// report all ignored steps of given scenario
				if (!metaFilter.allow(new Meta(ignoreFilter))) {
					final StoryReporter reporter = reporterData.get();
					if (reporter != null) {
						reporter.ignorable("ignored steps by filter: " + ignoreFilter.toString());
						for (final String step : scenario.getSteps()) {
							reporter.ignorable(step);
						}
					}
					return new ArrayList<Step>();
				}
			}

			return super.collectScenarioSteps(candidateSteps, scenario, parameters);
		}
	}

	/**
	 * {@inheritDoc}<br>
	 * We create our own configuration here because the default implementation of is not that good.
	 * 
	 * @see org.jbehave.core.ConfigurableEmbedder#configuration()
	 */
	@Override
	public Configuration configuration() {

		Logger.getRootLogger().setLevel(Level.INFO);
		
		// JBehave uses the Builder pattern very intensive. That makes it hard to integrate it with Spring. In this place, we do
		// not create all Instances with Spring because they are not used anywhere else and it would make it much harder to read
		// and to understand if we delegate that instantiation to Spring.

		// final PendingStepStrategy pendingStepStrategy = new FailingUponPendingStep();
		final PendingStepStrategy pendingStepStrategy = new PassingUponPendingStep();

		final SeleniumConfiguration config = new SeleniumConfiguration();
		final SeleniumContext seleniumContext = new SeleniumContext();

		// Not used at the moment because XREF of JBehave has a bug at the moment
		// final CrossReference crossReference = getCrossReference(pendingStepStrategy);
		// final ContextView contextView = new LocalFrameContextView().sized(640, 120);
		// final SeleniumStepMonitor stepMonitor = new SeleniumStepMonitor(contextView, seleniumContext,
		// crossReference.getStepMonitor());

		final ThreadLocal<StoryReporter> reporterData = new ThreadLocal<StoryReporter>();
		final ThreadLocal<String> storyData = new ThreadLocal<String>();

		final StoryReporterBuilder reporterBuilder = getStoryReporterBuilder(seleniumContext, reporterData);
        config.useViewGenerator(new CustomFreemarkerViewGenerator(this.getClass()));
		config.useSeleniumContext(seleniumContext)
			    .useWebDriverProvider(getWebDriverProvider())
				.usePendingStepStrategy(pendingStepStrategy)
				.useStoryControls(new StoryControls().doResetStateBeforeScenario(false).doSkipScenariosAfterFailure(true))
				// .useStepMonitor(stepMonitor)
				.useStoryLoader(new LoadFromClasspath(WebTests.class)).useStoryReporterBuilder(reporterBuilder)
				.useStepCollector(new MyStepCollector(storyData, reporterData))
				.parameterConverters().addConverters(getParameterConverters());

		return config;
	}

	@SuppressWarnings("unused")
	private CrossReference getCrossReference(final PendingStepStrategy pendingStepStrategy) {
		// @formatter:off
		final CrossReference crossReference = new CrossReference()
				.withJsonOnly()
				.withPendingStepStrategy(pendingStepStrategy)
				.withOutputAfterEachStory(true)
				.excludingStoriesWithNoExecutedScenarios(true);
		// @formatter:on
		return crossReference;
	}

	private StoryReporterBuilder getStoryReporterBuilder(final SeleniumContext seleniumContext,
			final ThreadLocal<StoryReporter> reporterData) {

		final StoryReporterBuilder reporterBuilder = new StoryReporterBuilder() {

			@Override
			public StoryReporter build(final String storyPath) {
				final StoryReporter reporter = super.build(storyPath);
				// set story reporter to use the same as taken by story runner
				reporterData.set(reporter);
				getContextInformation().setReporterData(reporterData);
				getContextInformation().setStoryName(StringUtils.removeEnd(storyPath, ".story"));
				return reporter;
			}
		};

		// Note: Format.XML is required for processing the results in Jenkins!
		final Format[] formats = new Format[] { new SeleniumContextOutput(seleniumContext), Format.CONSOLE, Format.STATS,
				Format.XML, CustomWebDriverHtmlOutput.WEB_DRIVER_HTML };
		Properties viewResources = new Properties();
		viewResources.put("decorateNonHtml","false");
		// @formatter:off
		reporterBuilder.withCodeLocation(CodeLocations.codeLocationFromClass(WebTests.class))
				.withFailureTrace(true)
				.withFailureTraceCompression(true)
				.withDefaultFormats()
				.withFormats(formats)
				.withViewResources(viewResources);
//				.withCrossReference(crossReference);
		// @formatter:on

		reporterBuilder.withRelativeDirectory("jbehave/" + webTestsConfiguration.getTestedSystem());
		




		return reporterBuilder;
	}

	/**
	 * Uses the local preconfigured {@link Embedder} and configures the used {@link EmbedderControls}.<br>
	 * Created by: stefan.person
	 * 
	 * @return The fully configured/updated {@link EmbedderControls} object which is also used by the {@link Embedder}.
	 */
	private EmbedderControls embedderControls() {
		final EmbedderControls embedderControls = this.embedder.embedderControls();
		int threadCount = webTestsConfiguration.getJbehaveThreadCount();
		embedderControls.doIgnoreFailureInStories(true).useThreads(threadCount);
		embedderControls.useStoryTimeoutInSecs(MAX_STORY_TIMEOUT);
		return embedderControls;
	}

	/**
	 * Uses the local preconfigured {@link Embedder} and configures the used {@link EmbedderFailureStrategy}.<br>
	 * Created by: stefan.person
	 * 
	 * @return The fully configured/updated {@link EmbedderFailureStrategy} object which is also used by the {@link Embedder}.
	 */
	private EmbedderFailureStrategy failureStategy() {
		return this.embedder.embedderFailureStrategy();
	}

	/**
	 * Uses the local preconfigured {@link Embedder} and configures the used {@link EmbedderMonitor}.<br>
	 * Created by: stefan.person
	 * 
	 * @return The fully configured/updated {@link EmbedderMonitor} object which is also used by the {@link Embedder}.
	 */
	private EmbedderMonitor getEmbedderMonitor() {
		return this.embedder.embedderMonitor();
	}

	/**
	 * Gets the list of meta filters which are configured in the {@link WebTestsConfiguration}.<br>
	 * Created by: stefan.person
	 * 
	 * @return The List of meta filters as Strings. Will never be null but an empty List if nothing is configured.
	 */
	private List<String> getMetaFilter() {
		return getWebTestsConfiguration().getJBehaveMetaFilterAsList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.jbehave.core.ConfigurableEmbedder#stepsFactory()
	 */
	@Override
	public InjectableStepsFactory stepsFactory() {
		// When executing the test via maven the JUnit runner is not working correctly.
		// Thus we manually have to create the spring context and apply autowiring.
		if (getApplicationContext() == null) {
			final ContextConfiguration contextConfiguration = this.getClass().getAnnotation(ContextConfiguration.class);
			setApplicationContext(new ClassPathXmlApplicationContext(contextConfiguration.locations()));

			getApplicationContext().getAutowireCapableBeanFactory().autowireBeanProperties(this,
					org.springframework.beans.factory.config.AutowireCapableBeanFactory.AUTOWIRE_BY_NAME, false);
		}

		return new SpringStepsFactory(configuration(), getApplicationContext());
	}

	/**
	 * Uses the local preconfigured {@link Embedder} and configures the used system {@link Properties}.<br>
	 * Created by: stefan.person
	 * 
	 * @return The fully configured/updated system {@link Properties} object which is also used by the {@link Embedder}.
	 */
	private Properties systemProperties() {
		return this.embedder.systemProperties();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.jbehave.core.junit.JUnitStories#storyPaths()
	 */
	@Override
	protected List<String> storyPaths() {
		final String storyPathPrefix = StringUtils.defaultString(getWebTestsConfiguration().getjBehaveStoryPathPrefix(), "");
		final String storyPatterns = StringUtils.defaultString(getWebTestsConfiguration().getjBehaveStoryPathPattern(),
				"**/*.story");
		final String searchRoot = CodeLocations.codeLocationFromClass(this.getClass()).getFile();
		final List<String> includes = Arrays.asList(storyPatterns.split("\\s*,\\s*"));

		// sort only within one include path
		final List<String> storypaths = new ArrayList<String>();
		final StoryFinder storyFinder = new StoryFinder();

		for (String includePath : includes) {
			if (!includePath.contains("/")) {
				includePath = storyPathPrefix + includePath;
			}
			if (!includePath.endsWith("*") && !includePath.endsWith(".story")) {
				includePath += ".story";
			}
			final List<String> storiesPerPath = storyFinder.findPaths(searchRoot, Arrays.asList(includePath), null);
			Collections.sort(storiesPerPath, new Comparator<String>() {

				@Override
				public int compare(final String string1, final String string2) {
					final File file1 = new File(string1);
					final File file2 = new File(string2);
					return file1.getName().compareTo(file2.getName());
				}
			});
			storypaths.addAll(storiesPerPath);
		}
		return storypaths;
	}

	/**
	 * Gets the applicationContext.
	 * 
	 * @return the applicationContext
	 */
	protected final ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	/**
	 * Sets the applicationContext.
	 * 
	 * @param applicationContext the applicationContext to set
	 */
	@Override
	public final void setApplicationContext(final ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	protected final WebTestsConfiguration getWebTestsConfiguration() {
		return webTestsConfiguration;
	}

	public final void setWebTestsConfiguration(final WebTestsConfiguration webTestsConfiguration) {
		this.webTestsConfiguration = webTestsConfiguration;
	}

	protected final WebDriverProvider getWebDriverProvider() {
		return webDriverProvider;
	}

	public final void setWebDriverProvider(final WebDriverProvider webDriverProvider) {
		this.webDriverProvider = webDriverProvider;
	}

	protected final ContextInformation getContextInformation() {
		return contextInformationProvider.getContextInformation();
	}

	public ContextInformationProvider getContextInformationProvider() {
		return contextInformationProvider;
	}
	
	public void setContextInformationProvider(ContextInformationProvider contextInformationProvider) {
		this.contextInformationProvider = contextInformationProvider;
	}

	protected final List<ParameterConverter> getParameterConverters() {
		return parameterConverters;
	}

	public final void setParameterConverters(final List<ParameterConverter> parameterConverters) {
		this.parameterConverters = parameterConverters;
	}
}
