package cn.vito.coding.check.po;

public class TeacherAndAcademyLike {
	private String id;// 学号
	private String name;// 姓名
	private String school;// 学院
	private String teacher;// 教师
	private Integer year;// 年份
	private String subjectname;// 科目
	private int page;
	private int rows;

	public TeacherAndAcademyLike() {
	}

	public TeacherAndAcademyLike(String teacher, int page, int rows) {
		this.teacher = teacher;
		this.page = (page - 1) * rows;
		this.rows = rows;
	}

	public TeacherAndAcademyLike(String id, String name, String school, Integer year) {
		this.id = id;
		this.name = name;
		this.school = school;
		this.year = year;
	}

	public TeacherAndAcademyLike(String id, String name, String school, Integer year, int page, int rows) {
		this.id = id;
		this.name = name;
		this.school = school;
		this.year = year;
		this.page = (page - 1) * rows;
		this.rows = rows;
	}

	public TeacherAndAcademyLike(String id, String name, String school, String teacher, Integer year) {
		this.id = id;
		this.name = name;
		this.school = school;
		this.teacher = teacher;
		this.year = year;
	}
	

	public TeacherAndAcademyLike(String id, String name, String school, String teacher, Integer year,
			String subjectname) {
		this.id = id;
		this.name = name;
		this.school = school;
		this.teacher = teacher;
		this.year = year;
		this.subjectname = subjectname;
	}

	public TeacherAndAcademyLike(String id, String name, String school, String teacher, Integer year,
			String subjectname, int page, int rows) {
		this.id = id;
		this.name = name;
		this.school = school;
		this.teacher = teacher;
		this.year = year;
		this.subjectname = subjectname;
		this.page = (page - 1) * rows;
		this.rows = rows;
	}

	public TeacherAndAcademyLike(String id, String name, String school, String teacher, Integer year, int page,
			int rows) {
		this.id = id;
		this.name = name;
		this.school = school;
		this.teacher = teacher;
		this.year = year;
		this.page = (page - 1) * rows;
		this.rows = rows;
	}

	public String getSubjectname() {
		return subjectname;
	}

	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
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
