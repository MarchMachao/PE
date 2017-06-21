package cn.vito.coding.check.vo;

/**
 * 用于科目分页
 * 
 * @author 刘晓庆
 *
 */
public class Page {
	private int startNum;
	private int rows;

	public Page(int page, int rows) {
		this.startNum = (page - 1) * rows;
		this.rows = rows;
	}

	public int getStartNum() {
		return startNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

}
