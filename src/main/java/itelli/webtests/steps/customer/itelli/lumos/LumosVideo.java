package itelli.webtests.steps.customer.itelli.lumos;

public class LumosVideo {

	private String id;
	private String title;
	private Boolean video;
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

	public LumosVideo(String id, String title, Boolean video, String status, Integer page) {
		this.id = id;
		this.title = title;
		this.video = video;
		this.status = status;
		this.page = page;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Boolean getVideo() {
		return video;
	}
	public void setVideo(Boolean video) {
		this.video = video;
	}
}
