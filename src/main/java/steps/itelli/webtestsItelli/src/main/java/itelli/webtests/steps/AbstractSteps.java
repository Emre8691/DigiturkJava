package steps.itelli.webtestsItelli.src.main.java.itelli.webtests.steps;


import org.jbehave.core.steps.Steps;
import org.jbehave.web.selenium.WebDriverPage;
import org.springframework.beans.factory.annotation.Required;

import steps.itelli.webtestsItelli.src.main.java.itelli.webtests.pages.base.SystemHelper;


/**
 * Connection for extending some steps with generic WebDriverPage Implementation
 * 
 * @author bjoern.wedi (created), 22.02.2013
 * @author $Author$ (last changed)
 * @version $Rev$, $Date$ $Id: $
 * @param <C> the context object
 */

public abstract class AbstractSteps<C extends WebDriverPage> extends Steps{

	public static final int MAX_TIMEOUT_1_SECOND = 1;
	public static final int MAX_TIMEOUT_2_SECONDS = 2;
	public static final int MAX_TIMEOUT_5_SECONDS = 5;
	public static final int MAX_TIMEOUT_10_SECONDS = 10;
	public static final int MAX_TIMEOUT_COMMON = 300;

	private C context;
	private SystemHelper system;

	protected final C getContext() {
		return context;
	}

	@Required
	public final void setContextBase(final C context) {
		this.context = context;
	}

	protected final SystemHelper getSystem() {
		return system;
	}

	@Required
	public final void setSystemHelper(final SystemHelper system) {
		this.system = system;
	}

}
