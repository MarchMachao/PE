package cn.vito.coding.check.po;

/**
 * 用户po
 * 
 * @author baijw
 * 
 * @date 2017年3月13日 下午8:21:19
 */
public class User {

	private String userName;
	private String password;
	private String nickName;
	private String role;
	private String createDate;

	public User() {
		super();
	}

	public User(String userName, String password, String nickName, String role, String createDate) {
		super();
		this.userName = userName;
		this.password = password;
		this.nickName = nickName;
		this.role = role;
		this.createDate = createDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

}
