package cqupt.domain;

public class User {
    private Integer userid;

    private String username;

    private String password;
    
    private String post;
    
    public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	private int  manager;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

	public int getManager() {
		return manager;
	}

	public void setManager(int manager) {
		this.manager = manager;
	}
}