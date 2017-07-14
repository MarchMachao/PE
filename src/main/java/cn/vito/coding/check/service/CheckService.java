package cn.vito.coding.check.service;

import java.util.List;

import cn.vito.coding.check.po.TeacherAndAcademy;

/**
 * 审核相关service
 * 
 * @author 刘晓庆
 *
 */
public interface CheckService {

	/**
	 * 教师审核，审核的教师列表
	 * 
	 * @return
	 */
	public List<TeacherAndAcademy> findCheckList();

	/**
	 * 教师审核，列表的学生数据
	 * 
	 * @param teacherAndAcademyLike
	 * @return
	 */
	public List<TeacherAndAcademy> findCheckByTeacher(String teacher, int pageNo, int pageSize);

	/**
	 * 教师审核，更新状态数据
	 * 
	 * @param teacher
	 */
	public void updateState(String teacher);

	/**
	 * 教师审核，更新状态数据被退回
	 * 
	 * @param teacher
	 */
	public void updateStateNo(String teacher);

	/**
	 * 学院审核，根据不同学院查询不同的信息
	 * 
	 * @param school
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<TeacherAndAcademy> findCheckBySchool(String school, int pageNo, int pageSize);

	/**
	 * 学院审核，更新状态数据已审核
	 * 
	 * @param teacher
	 */
	public void checkPass(String school);

	/**
	 * 学院审核，更新状态数据被退回
	 * 
	 * @param teacher
	 */
	public void checkNoPass(String school);

	/**
	 * 管理员审核的学院状态列表
	 * 
	 * @return
	 */
	public List<TeacherAndAcademy> findSchoolCheckList();

	/**
	 * 管理员审核的教师状态列表
	 * 
	 * @return
	 */
	public List<TeacherAndAcademy> findTeacherCheckList();

	/**
	 * 管理员审核的教师列表的学生数据
	 * 
	 * @param teacherAndAcademyLike
	 * @return
	 */
	public List<TeacherAndAcademy> findAdminCheckByTeacher(String teacher, int pageNo, int pageSize);

	/**
	 * 管理员审核的学院列表的学生数据
	 * 
	 * @param teacherAndAcademyLike
	 * @return
	 */
	public List<TeacherAndAcademy> findAdminCheckBySchool(String school, int pageNo, int pageSize);

	/**
	 * 管理员更新教师状态数据已审核
	 * 
	 * @param teacher
	 */
	public void updateAdminTeacherStateOk(String teacher);

	/**
	 * 管理员更新教师状态数据被退回
	 * 
	 * @param teacher
	 */
	public void updateAdminTeacherStateNo(String teacher);
}
