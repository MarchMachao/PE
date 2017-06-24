package cn.vito.coding.check.po;

/**
 * 体侧数据
 * 
 * @author 刘晓庆
 *
 */
public class Data {
	private String id;// 学号
	private Integer year;// 年份
	private Integer height;// 身高
	private double weight;// 体重
	private Integer vital_capacity;// 肺活量
	private double fivem;// 50m
	private double long_jump;// 立定跳远
	private double reach;// 坐位体前屈
	private String eightm;// 800m
	private String tenm;// 1000m
	private double sit_ups;// 仰卧起坐
	private double pull_up;// 引体向上
	private String check;// 审核

	public Data() {
	}

	public Data(String id, Integer year, Integer height, double weight, Integer vital_capacity, double fivem,
			double long_jump, double reach, String eightm, String tenm, double sit_ups, double pull_up, String check) {
		this.id = id;
		this.year = year;
		this.height = height;
		this.weight = weight;
		this.vital_capacity = vital_capacity;
		this.fivem = fivem;
		this.long_jump = long_jump;
		this.reach = reach;
		this.eightm = eightm;
		this.tenm = tenm;
		this.sit_ups = sit_ups;
		this.pull_up = pull_up;
		this.check = check;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Integer getVital_capacity() {
		return vital_capacity;
	}

	public void setVital_capacity(Integer vital_capacity) {
		this.vital_capacity = vital_capacity;
	}

	public double getFivem() {
		return fivem;
	}

	public void setFivem(double fivem) {
		this.fivem = fivem;
	}

	public double getLong_jump() {
		return long_jump;
	}

	public void setLong_jump(double long_jump) {
		this.long_jump = long_jump;
	}

	public double getReach() {
		return reach;
	}

	public void setReach(double reach) {
		this.reach = reach;
	}

	public String getEightm() {
		return eightm;
	}

	public void setEightm(String eightm) {
		this.eightm = eightm;
	}

	public String getTenm() {
		return tenm;
	}

	public void setTenm(String tenm) {
		this.tenm = tenm;
	}

	public double getSit_ups() {
		return sit_ups;
	}

	public void setSit_ups(double sit_ups) {
		this.sit_ups = sit_ups;
	}

	public double getPull_up() {
		return pull_up;
	}

	public void setPull_up(double pull_up) {
		this.pull_up = pull_up;
	}

	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}

}
