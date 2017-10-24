package net.sinou.poc.cms.domain;

//@Entity
//@Table(name = "Pages")
public class Page {

	// @Id
	private Long id;
	private String title;
	private String desc;
	private String body;

	public Page() {
	}

	public Page(String title, String desc, String body) {
		this.title = title;
		this.desc = desc;
		this.body = body;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

}
