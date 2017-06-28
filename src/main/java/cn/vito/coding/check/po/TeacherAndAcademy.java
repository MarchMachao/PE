package cn.vito.coding.check.po;

/**
 * 教师页面的实体类
 * 
 * @author 刘晓庆
 *
 */
public class TeacherAndAcademy {

	private String id;// 学号
	private String name;// 姓名
	private String gender; // 性别
	private String school;// 学院
	private Integer grade;// 年级
	private String classes;// 班级
	private Integer duration;// 学制
	private String state; // 状态、备注
	private String teacher;// 教师
	private Integer year;// 年份
	private Integer height;// 身高
	private Double weight;// 体重
	private Integer vital_capacity;// 肺活量
	private Double fivem;// 50m
	private Double long_jump;// 立定跳远
	private Double reach;// 坐位体前屈
	private String eightm;// 800m
	private String tenm;// 1000m
	private Integer sit_ups;// 仰卧起坐
	private Integer pull_up;// 引体向上
	private Double score;// 成绩
	private String first_check;// 第一次审核
	private String second_check;// 第二次审核

	public TeacherAndAcademy() {
	}

	public TeacherAndAcademy(String id, String name, String gender, String school, Integer grade, String classes,
			Integer duration, String state, String teacher, Integer year, Integer height, Double weight,
			Integer vital_capacity, Double fivem, Double long_jump, Double reach, String eightm, String tenm,
			Integer sit_ups, Integer pull_up, Double score, String first_check, String second_check) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.school = school;
		this.grade = grade;
		this.classes = classes;
		this.duration = duration;
		this.state = state;
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
		this.second_check = second_check;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Integer getVital_capacity() {
		return vital_capacity;
	}

	public void setVital_capacity(Integer vital_capacity) {
		this.vital_capacity = vital_capacity;
	}

	public Double getFivem() {
		return fivem;
	}

	public void setFivem(Double fivem) {
		this.fivem = fivem;
	}

	public Double getLong_jump() {
		return long_jump;
	}

	public void setLong_jump(Double long_jump) {
		this.long_jump = long_jump;
	}

	public Double getReach() {
		return reach;
	}

	public void setReach(Double reach) {
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

	public Integer getSit_ups() {
		return sit_ups;
	}

	public void setSit_ups(Integer sit_ups) {
		this.sit_ups = sit_ups;
	}

	public Integer getPull_up() {
		return pull_up;
	}

	public void setPull_up(Integer pull_up) {
		this.pull_up = pull_up;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public String getFirst_check() {
		return first_check;
	}

	public void setFirst_check(String first_check) {
		this.first_check = first_check;
	}

	public String getSecond_check() {
		return second_check;
	}

	public void setSecond_check(String second_check) {
		this.second_check = second_check;
	}

}
