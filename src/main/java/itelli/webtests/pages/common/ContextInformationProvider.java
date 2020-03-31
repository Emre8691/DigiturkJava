package itelli.webtests.pages.common;

public class ContextInformationProvider {
	private ThreadLocal<ContextInformation> contextInformationlocal;

	public ContextInformationProvider() {
		this.setContextInformationlocal(new ThreadLocal<ContextInformation>());
	}

	public ContextInformation getContextInformation() {
		ContextInformation c = getContextInformationlocal().get();
		if (c == null) {
			c = new ContextInformation();
			getContextInformationlocal().set(c);
		}

		return c;
	}

	public void setContextInformation(ContextInformation contextInformation) {
		this.getContextInformationlocal().set(contextInformation);
	}

	public ThreadLocal<ContextInformation> getContextInformationlocal() {
		return contextInformationlocal;
	}

	public void setContextInformationlocal(ThreadLocal<ContextInformation> contextInformationlocal) {
		this.contextInformationlocal = contextInformationlocal;
	}
}
