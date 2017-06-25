package cn.vito.coding.check.po;

/**
 * 教师页面的实体类
 * 
 * @author 刘晓庆
 *
 */
public class Teacher {
	private String id;// 学号
	private String name;// 姓名
	private String school;// 学院
	private String teacher;// 教师
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
	private Integer score;// 成绩
	private String first_check;// 第一次审核

	public Teacher() {
	}

	public Teacher(String id, String name, String school, String teacher, Integer year, Integer height, double weight,
			Integer vital_capacity, double fivem, double long_jump, double reach, String eightm, String tenm,
			double sit_ups, double pull_up, Integer score, String first_check) {
		this.id = id;
		this.name = name;
		this.school = school;
		this.teacher = teacher;
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
		this.score = score;
		this.first_check = first_check;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
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

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getFirst_check() {
		return first_check;
	}

	public void setFirst_check(String first_check) {
		this.first_check = first_check;
	}

}
