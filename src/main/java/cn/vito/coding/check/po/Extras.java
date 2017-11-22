package cn.vito.coding.check.po;

/**
 * 学生附加分
 * 
 * @author March
 *
 */
public class Extras extends Student {

	private String id;
	private Integer year;
	private Double extra;
	private int page;
	private int rows;

	public Extras() {
		super();
	}

	public Extras(String id, Integer year) {
		super();
		this.id = id;
		this.year = year;
	}

	public Extras(String id, Integer year, Double extra) {
		super();
		this.id = id;
		this.year = year;
		this.extra = extra;
	}

	public Extras(String id, Integer year, Double extra, int page, int rows) {
		super();
		this.id = id;
		this.year = year;
		this.extra = extra;
		this.page = (page - 1) * rows;
		this.rows = rows;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Double getExtra() {
		return extra;
	}

	public void setExtra(Double extra) {
		this.extra = extra;
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

	@Override
	public String toString() {
		return "Extras [id=" + id + ", year=" + year + ", extra=" + extra + ", page=" + page + ", rows=" + rows
				+ ", toString()=" + super.toString() + "]";
	}


}
