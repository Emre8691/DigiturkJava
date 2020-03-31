package itelli.webtests.steps.customer.itelli.lumos;

public class FailedVideo {

	private String id;
	private String title;
	private Boolean video;

	public FailedVideo(String id, String title, Boolean video) {
		this.id = id;
		this.title = title;
		this.video = video;
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
