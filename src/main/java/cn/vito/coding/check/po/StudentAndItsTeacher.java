package cn.vito.coding.check.po;

/**
 * student页面显示实体
 * 
 * @author March
 *
 */
public class StudentAndItsTeacher extends Student {

	private Integer subjectId;
	private String subjectName;
	private String year;
	private String newTeacher;

	public StudentAndItsTeacher() {
		super();
	}

	public StudentAndItsTeacher(Integer subjectId, String subjectName, String year, String newTeacher) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.year = year;
		this.newTeacher = newTeacher;
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

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}


	public String getNewTeacher() {
		return newTeacher;
	}

	public void setNewTeacher(String newTeacher) {
		this.newTeacher = newTeacher;
	}

	@Override
	public String toString() {
		return "StudentAndItsTeacher [subjectId=" + subjectId + ", subjectName=" + subjectName + ", year=" + year
				+ ", newTeacher=" + newTeacher + ", toString()=" + super.toString() + "]";
	}

}
