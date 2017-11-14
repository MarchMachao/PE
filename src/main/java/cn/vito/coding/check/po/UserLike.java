package cn.vito.coding.check.po;

/**
 * 用户po
 * 
 * @author 刘晓庆
 * 
 */
public class UserLike {

	private String userName;
	private String password;
	private String nickName;
	private String role;
	private String id;
	private String name;
	private String gender;
	private String school;
	private Integer grade;
	private String classes;
	private Integer duration;
	private String state;
	private String teacher;
	private int page;
	private int rows;

	public UserLike() {
	}

	public UserLike(String nickName, String role, int page, int rows) {
		super();
		this.nickName = nickName;
		this.role = role;
		this.page = (page - 1) * rows;
		this.rows = rows;
	}

	public UserLike(String name, String school, Integer grade, String state, String teacher) {
		this.name = name;
		this.school = school;
		this.grade = grade;
		this.state = state;
		this.teacher = teacher;
	}

	public UserLike(String name, String school, Integer grade, String state, String teacher, int page, int rows) {
		this.name = name;
		this.school = school;
		this.grade = grade;
		this.state = state;
		this.teacher = teacher;
		this.page = (page - 1) * rows;
		this.rows = rows;
	}

	public UserLike(String userName, String password, String nickName, String id, String name, String gender,
			String school, Integer grade, String classes, Integer duration, String state) {
		this.userName = userName;
		this.password = password;
		this.nickName = nickName;
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.school = school;
		this.grade = grade;
		this.classes = classes;
		this.duration = duration;
		this.state = state;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
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

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
