package itelli.webtests.steps.web.alerts;

import org.apache.log4j.Logger;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;

import itelli.webtests.pages.base.ContextBase;
import itelli.webtests.steps.AbstractSteps;

/**
 * Implements DSL which simulate the input of keyboard keys.
 */
public class AlertWebSteps extends AbstractSteps<ContextBase> {

	private static final Logger LOG = Logger.getLogger(AlertWebSteps.class);

	/**
	 * Press Enter to Alert Window expected focus.<br>
	 */
	@When("I confirm the pop up box")
	public void pressAlertBoxFocus() {
		try {
			final Alert alert = getContext().switchTo().alert();
			if (alert != null) {
				alert.accept();
			}
		}
		catch (final Exception e) {
			LOG.error("The alert box couldn´t be confirmed!", e);
		}
	}

	/**
	 * Press Enter to Alert Window expected focus. test<br>
	 */
	@When("I confirm the pop up box test")
	public void pressAlertBoxFocustest() {
		try {
			LOG.info("u are trying to login through auth window");

			final Alert alert = getContext().switchTo().alert();

			alert.wait(10000);
			alert.sendKeys("b");
			alert.sendKeys("s");
			alert.sendKeys("h");
			alert.sendKeys(Keys.TAB.toString());
			alert.sendKeys("n");
			alert.sendKeys("e");
			alert.sendKeys("w");
			alert.sendKeys("S");
			alert.sendKeys("i");
			alert.sendKeys("t");
			alert.sendKeys("e");
			alert.sendKeys("D");
			alert.sendKeys("2");
			alert.sendKeys("C");

			alert.accept();

			/*
			 * try { Robot robot = new Robot(); //alert.sendKeys("username"); robot.keyPress(KeyEvent.VK_B);
			 * robot.keyPress(KeyEvent.VK_S); robot.keyPress(KeyEvent.VK_H); robot.keyPress(KeyEvent.VK_TAB);//go to password
			 * feild robot.keyPress(KeyEvent.VK_N); robot.keyPress(KeyEvent.VK_E); robot.keyPress(KeyEvent.VK_W);
			 * robot.keyPress(KeyEvent.VK_S); robot.keyPress(KeyEvent.VK_I); robot.keyPress(KeyEvent.VK_T);
			 * robot.keyPress(KeyEvent.VK_E); robot.keyPress(KeyEvent.VK_D); robot.keyPress(KeyEvent.VK_2);
			 * robot.keyPress(KeyEvent.VK_C); robot.keyPress(KeyEvent.VK_ENTER); } catch (AWTException e) { e.printStackTrace(); }
			 */

			// alert.authenticateUsing(new UserAndPassword("bsh", "newSiteD2C"));
			if (alert != null) {
				alert.accept();
			}
		}
		catch (final Exception e) {
			LOG.error("The alert box couldn´t be confirmed!", e);
		}
	}

	/**
	 * Press a given key for expected focus.<br>
	 * 
	 * @values 'tabulator', 'enter', 'space'
	 * @param key The key which has to be pressed on keyboard.
	 */
	@When("I press $key at the focused pop up box")
	public void pressSpace(final String key) {
		keyMangaer(key);

	}

	private void keyMangaer(final String key) {
		if (key.equalsIgnoreCase("tabulator")) {
			getContext().getContextBasedActions().setTab();
			return;
		}
		if (key.equalsIgnoreCase("enter")) {
			getContext().getContextBasedActions().setEnter();
			return;
		}
		if (key.equalsIgnoreCase("space")) {
			getContext().getContextBasedActions().setSpace();
			return;
		}
		LOG.error("No match was found for '" + key + "'!");
	}
}
