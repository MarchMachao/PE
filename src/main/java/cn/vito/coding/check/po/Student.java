package cn.vito.coding.check.po;

/**
 * 学生表
 * 
 * @author 刘晓庆
 *
 */
public class Student {
	private String id;
	private String name;
	private String gender;
	private String school;
	private Integer grade;
	private String classes;
	private Integer duration;
	private String state;
	private String teacher;

	public Student() {
	}

	public Student(String id, String classes) {
		this.id = id;
		this.classes = classes;
	}
	
	public Student(String id, String name, String gender, String school, Integer grade, String classes,
			Integer duration, String state) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.school = school;
		this.grade = grade;
		this.classes = classes;
		this.duration = duration;
		this.state = state;
	}

	public Student(String id, String name, String gender, String school, Integer grade, String classes, Integer duration,
			String state, String teacher) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.school = school;
		this.grade = grade;
		this.classes = classes;
		this.duration = duration;
		this.state = state;
		this.teacher = teacher;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
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

}
