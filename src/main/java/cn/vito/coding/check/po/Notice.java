package cn.vito.coding.check.po;

public class Notice {

	private String text;
	private String date;
	private Boolean valid;
	private String roles;
	private int page;
	private int rows;

	public Notice() {
	}

	public Notice(String text, String date, Boolean valid, String roles) {
		this.text = text;
		this.date = date;
		this.valid = valid;
		this.roles = roles;
	}

	public Notice(String text, String date, Boolean valid, String roles, int page, int rows) {
		this.text = text;
		this.date = date;
		this.valid = valid;
		this.roles = roles;
		this.page = (page - 1) * rows;
		this.rows = rows;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Boolean getValid() {
		return valid;
	}

	public void setValid(Boolean valid) {
		this.valid = valid;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
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

}
