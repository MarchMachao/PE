package cn.vito.coding.check.po;

/**
 * 用户po
 * 
 * @author 刘晓庆
 * 
 */
public class UserLike {

	private String nickName;
	private String role;
	private int page;
	private int rows;

	public UserLike() {
	}

	public UserLike(String nickName, String role, int page, int rows) {
		super();
		this.nickName = nickName;
		this.role = role;
		this.page = (page - 1) * rows;
		this.rows = rows;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
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
}
