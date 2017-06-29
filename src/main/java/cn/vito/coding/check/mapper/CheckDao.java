package cn.vito.coding.check.mapper;

import java.util.List;

import cn.vito.coding.check.po.TeacherAndAcademy;
import cn.vito.coding.check.po.TeacherAndAcademyLike;
import cn.vito.coding.check.vo.Page;

/**
 * 审核操作
 * 
 * @author 刘晓庆
 *
 */
public interface CheckDao {
	/**
	 * 查询需要审核的数据
	 * 
	 * @return
	 */
	public List<TeacherAndAcademy> findCheckData(Page page);

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
}