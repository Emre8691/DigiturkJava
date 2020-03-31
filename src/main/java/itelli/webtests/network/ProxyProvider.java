package itelli.webtests.network;


import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;

public class ProxyProvider {
	private ThreadLocal<BrowserMobProxy> proxylocal;

	public ProxyProvider() {
		proxylocal = new ThreadLocal<BrowserMobProxy>();
	}

	public BrowserMobProxy getProxy() {
		BrowserMobProxy p = getProxylocal().get();
		if (p == null) {
			p = new BrowserMobProxyServer();
		    p.start();
			getProxylocal().set(p);
		}

		return p;
	}

	public void setProxy(BrowserMobProxy proxy) {
		this.getProxylocal().set(proxy);
	}

	
	
	public ThreadLocal<BrowserMobProxy> getProxylocal() {
		return proxylocal;
	}

	public void setProxylocal(ThreadLocal<BrowserMobProxy> proxylocal) {
		this.proxylocal = proxylocal;
	}
}
