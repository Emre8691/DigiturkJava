package itelli.webtests.steps.customer.itelli.lumos;

public class LumosImage {

	private String vib;
	private String locale;
	private String status;
	private Integer page;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public LumosImage(String vib, String locale, String status, Integer page) {
		this.vib = vib;
		this.locale = locale;
		this.status = status;
		this.page = page;
	}

	public String getVib() {
		return vib;
	}

	public void setVib(String vib) {
		this.vib = vib;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

}
