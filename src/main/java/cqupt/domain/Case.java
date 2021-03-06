package cqupt.domain;

public class Case {
    private Integer id;

    private String username;

    private Integer caseclass;
    
    private String content;
    
    private String sbcontent;
    
    private String time;
    
    private String title;
    
    private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getCaseclass() {
		return caseclass;
	}

	public void setCaseclass(Integer caseclass) {
		this.caseclass = caseclass;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSbcontent() {
		return sbcontent;
	}

	public void setSbcontent(String sbcontent) {
		this.sbcontent = sbcontent;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
    
}

   