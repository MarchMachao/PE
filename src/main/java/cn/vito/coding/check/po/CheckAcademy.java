package cn.vito.coding.check.po;

/**
 * 学院审核端的页面
 * 
 * @author 刘晓庆
 *
 */
public class CheckAcademy {
	private String school;// 学院
	private int page;
	private int rows;

	public CheckAcademy() {
	}

	public CheckAcademy(String school, int page, int rows) {
		this.school = school;
		this.page = (page - 1) * rows;
		this.rows = rows;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
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
