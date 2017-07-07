package cn.vito.coding.check.mapper;

import java.util.List;

import cn.vito.coding.check.po.Data;
import cn.vito.coding.check.po.TeacherAndAcademy;
import cn.vito.coding.check.po.TeacherAndAcademyLike;

/**
 * 管理员页面操作
 * 
 * @author 刘晓庆
 *
 */
public interface AdminDao {

	/**
	 * 查询所有未毕业学生的信息
	 * 
	 * @return
	 */
	public List<TeacherAndAcademy> findAdminData(TeacherAndAcademyLike teacherLike);

	/**
	 * 查询所已毕业有学生的信息
	 * 
	 * @return
	 */
	public List<TeacherAndAcademy> findAdminGraduateData(TeacherAndAcademyLike teacherLike);

	/**
	 * 修改页面的数据
	 * 
	 * @param data
	 */
	public void updateAdminData(Data data);

}