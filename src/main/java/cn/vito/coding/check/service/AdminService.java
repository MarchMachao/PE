package cn.vito.coding.check.service;

import java.util.List;

import cn.vito.coding.check.po.TeacherAndAcademy;

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
	 * 查询所已毕业有学生的信息
	 * 
	 * @return
	 */
	public List<TeacherAndAcademy> findAdminGraduateData(String id, String name, String school, String teacher,
			Integer year, int page, int rows);

	/**
	 * 修改教师页面的数据
	 * 
	 * @param data
	 */
	public void updateAdminData(String id, Integer year, Integer height, Double weight, Integer vital_capacity,
			Double fivem, Double long_jump, Double reach, String eightm, String tenm, Integer sit_ups, Integer pull_up,
			Integer grade, String gender);

}
