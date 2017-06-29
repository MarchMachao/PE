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
	 * 查询需要审核的数据
	 * 
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<TeacherAndAcademy> findCheckData(int pageNo, int pageSize);

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
	public List<TeacherAndAcademy> findCheckByTeacher(String teacher, int pageNo, int pageSize);

	/**
	 * 更新状态数据
	 * 
	 * @param teacher
	 */
	public void updateState(String teacher);
}
