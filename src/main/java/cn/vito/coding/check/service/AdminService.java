package cn.vito.coding.check.service;

import java.util.List;

import cn.vito.coding.check.po.TeacherAndAcademy;
import cn.vito.coding.check.po.TeacherToStudent;

/**
 * 管理员相关service
 * 
 * @author 刘晓庆
 *
 */
public interface AdminService {
	/**
	 * 查询所有未毕业学生信息
	 * 
	 * @param id
	 * @param name
	 * @param school
	 * @param teacher
	 * @param year
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<TeacherAndAcademy> findAdminData(String id, String name, String school, String teacher, Integer year,
			int page, int rows);
	
	/**
	 * 查询未毕业学生的信息数据量
	 * 
	 * @return
	 */
	public int countAdminDatas();

	/**
	 * 查询所已毕业有学生的信息
	 * 
	 * @return
	 */
	public List<TeacherAndAcademy> findAdminGraduateData(String id, String name, String school, String teacher,
			Integer year, int page, int rows);

	/**
	 * 查询已毕业学生信息数据量
	 * 
	 * @return
	 */
	public int countAdminGraduateDatas();

	/**
	 * 修改教师页面的数据
	 * 
	 * @param data
	 */
	public void updateAdminData(String id, Integer year, Integer height, Double weight, Integer vital_capacity,
			Double fivem, Double long_jump, Double reach, String eightm, String tenm, Integer sit_ups, Integer pull_up,
			Integer grade, String gender);

	/**
	 * 老师与学生、课程之间的对应关系
	 * 
	 * @param studentId
	 * @param school
	 * @param year
	 * @param teacher
	 * @param subjectId
	 * @param subjectName
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<TeacherToStudent> findTeachersToStudentData(String studentId, String school, Integer year,
			String teacher,
			Integer subjectId, String subjectName, int page, int rows);

	/**
	 * 查询学生与老师对应关系数据的量
	 * 
	 * @return
	 */
	public int countTeacherToStudent();

	/**
	 * 学生与教师对应关系管理页面增加一条数据
	 * 
	 * @param studentId
	 * @param year
	 * @param teacher
	 * @param subjectId
	 * @param subjectName
	 */
	public void addOneTeacherToStudentData(String studentId, Integer year, String teacher, Integer subjectId,
			String subjectName);


	/**
	 * 学生与教师对应关系管理页面删除一条数据
	 * 
	 * @param studentId
	 * @param year
	 */
	public void deleteTeacherToStudentData(String studentId, Integer year);

	/**
	 * 学生与教师对应关系管理页面修改一条数据
	 * 
	 * @param studentId
	 * @param year
	 * @param teacher
	 * @param subjectId
	 * @param subjectName
	 */
	public void updateTeacherToStudentData(String studentId, Integer year, String teacher, Integer subjectId,
			String subjectName);

	/**
	 * 管理员增加学生成绩
	 * 
	 * @param data
	 */
	public void addOneStudentData(String id, Integer year, Integer height, Double weight, Integer vital_capacity,
			Double fivem, Double long_jump, Double reach, String eightm, String tenm, Integer sit_ups, Integer pull_up,
			Integer grade, String gender);
}
