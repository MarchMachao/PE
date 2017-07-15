package cn.vito.coding.check.mapper;

import java.util.List;

import cn.vito.coding.check.po.CheckAcademy;
import cn.vito.coding.check.po.TeacherAndAcademy;
import cn.vito.coding.check.po.TeacherAndAcademyLike;

/**
 * 审核操作
 * 
 * @author 刘晓庆
 *
 */
public interface CheckDao {

	/**
	 * 审核的教师列表
	 * 
	 * @return
	 */
	public List<TeacherAndAcademy> findCheckList();

	/**
	 * 审核的教师列表的学生数据
	 * 
	 * @param teacherAndAcademyLike
	 * @return
	 */
	public List<TeacherAndAcademy> findCheckByTeacher(TeacherAndAcademyLike teacherAndAcademyLike);

	/**
	 * 教师审核，更新状态数据已审核
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
	 * 学院审核。根据不同学院查询不同的信息
	 * 
	 * @param teacherAndAcademyLike
	 * @return
	 */
	public List<TeacherAndAcademy> findCheckBySchool(CheckAcademy checkAcademy);

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
	public List<TeacherAndAcademy> findAdminCheckByTeacher(TeacherAndAcademyLike teacherAndAcademyLike);

	/**
	 * 管理员审核的学院列表的学生数据
	 * 
	 * @param teacherAndAcademyLike
	 * @return
	 */
	public List<TeacherAndAcademy> findAdminCheckBySchool(CheckAcademy checkAcademy);

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

	/**
	 * 管理员更新学院状态数据已审核
	 * 
	 * @param teacher
	 */
	public void updateAdminSchoolStateOk(String school);

	/**
	 * 管理员更新学院状态数据被退回
	 * 
	 * @param teacher
	 */
	public void updateAdminSchoolStateNo(String school);

}