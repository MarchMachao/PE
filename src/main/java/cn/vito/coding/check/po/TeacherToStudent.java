package cn.vito.coding.check.po;

/**
 * 记录某老师与学生之间的带课关系
 * 
 * @author March
 *
 */
public class TeacherToStudent {

	private String studentId; // 学号
	private String name; // 学生姓名
	private String gender; // 性别
	private Integer grade; // 年级
	private String school; // 学院
	private Integer year; // 年份
	private String teacher; // 老师姓名
	private Integer subjectId; // 课程编号
	private String subjectName; // 课程名称
	private int page;
	private int rows;

	public TeacherToStudent() {
	}

	public TeacherToStudent(String studentId, Integer year, String teacher, Integer subjectId, String subjectName) {
		this.studentId = studentId;
		this.year = year;
		this.teacher = teacher;
		this.subjectId = subjectId;
		this.subjectName = subjectName;
	}

	public TeacherToStudent(String studentId, String name, String gender, Integer grade, String school, Integer year,
			String teacher, Integer subjectId, String subjectName) {
		this.studentId = studentId;
		this.name = name;
		this.gender = gender;
		this.grade = grade;
		this.school = school;
		this.year = year;
		this.teacher = teacher;
		this.subjectId = subjectId;
		this.subjectName = subjectName;
	}

	public TeacherToStudent(String studentId, String school, Integer year, String teacher, Integer subjectId,
			String subjectName, int page, int rows) {
		this.studentId = studentId;
		this.school = school;
		this.year = year;
		this.teacher = teacher;
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.page = page;
		this.rows = rows;
	}

	public String getstudentId() {
		return studentId;
	}

	public void setstudentId(String studentId) {
		this.studentId = studentId;
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

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
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
