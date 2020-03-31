package itelli.webtests.network;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.jbehave.web.selenium.FirefoxWebDriverProvider;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.Command;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.Response;
import org.springframework.beans.factory.annotation.Autowired;

import net.lightbody.bmp.BrowserMobProxy;

public class ProxyFirefoxWebDriverProvider extends FirefoxWebDriverProvider {

	private ProxyProvider proxyProvider;
	
	@Override
	public void initialize() {

		final FirefoxBinary binary = new FirefoxBinary();
		decorateFirefoxBinary(binary);

		//bug: https://github.com/seleniumhq/selenium-google-code-issue-archive/issues/7272
		binary.setTimeout(TimeUnit.SECONDS.toMillis(180));
		//end

		FirefoxProfile profile = createProfile();

		OverriddenFirefoxDriver firefoxDriver = new OverriddenFirefoxDriver(binary, profile);
		delegate.set(firefoxDriver);

		firefoxDriver.setCommandExecutor(new OverridableCommandExecutor(firefoxDriver.getCommandExecutor()));
	}

	private FirefoxProfile createProfile() {
		BrowserMobProxy proxy = proxyProvider.getProxy();
		String proxyIP = "localhost";
		int proxyPort = proxy.getPort();
	    FirefoxProfile profile = new FirefoxProfile();  
	    profile.setPreference("network.proxy.type",1);  
	    profile.setPreference("network.proxy.ftp",proxyIP);  
	    profile.setPreference("network.proxy.http",proxyIP);  
	    profile.setPreference("network.proxy.socks",proxyIP);  
	    profile.setPreference("network.proxy.ssl",proxyIP);  
	    profile.setPreference("network.proxy.ftp_port",proxyPort);  
	    profile.setPreference("network.proxy.http_port",proxyPort);  
	    profile.setPreference("network.proxy.socks_port",proxyPort);  
	    profile.setPreference("network.proxy.ssl_port",proxyPort); 
		
		profile.setAcceptUntrustedCertificates(false);
		return profile;
	}

	public ProxyProvider getProxyProvider() {
		return proxyProvider;
	}

	public void setProxyProvider(ProxyProvider proxyProvider) {
		this.proxyProvider = proxyProvider;
	}
	
    protected static class OverriddenFirefoxDriver extends FirefoxDriver {
        public OverriddenFirefoxDriver(FirefoxBinary binary, FirefoxProfile profile) {
            super(binary, profile);
        }

        @Override
        public void setCommandExecutor(CommandExecutor executor) {
            super.setCommandExecutor(executor);
        }

        @Override
        protected void stopClient() {
            ((OverridableCommandExecutor) this.getCommandExecutor()).stopClient();
        }

    }

	private class OverridableCommandExecutor implements CommandExecutor {
		private final CommandExecutor realExecutor;
		private Method quitMethod;

		public OverridableCommandExecutor(CommandExecutor realExecutor) {
			this.realExecutor = realExecutor;
			try {
				Class<? extends CommandExecutor> aClass = realExecutor.getClass();
				quitMethod = aClass.getDeclaredMethod("quit");
				quitMethod.setAccessible(true);
			} catch (NoSuchMethodException e) {
			}
		}

		public Response execute(Command command) throws IOException {
			long when = System.currentTimeMillis();
			Response execution = null;
			try {
				execution = realExecutor.execute(command);
			} finally {
				long dur = System.currentTimeMillis() - when;
				synchronized (getJournal()) {
					getJournal().add(when, dur, command, execution);
				}
			}
			return execution;
		}

		protected void stopClient() {
			try {
				quitMethod.invoke(realExecutor);
			} catch (IllegalAccessException e) {
			} catch (InvocationTargetException e) {
			}
		}

	}

}
