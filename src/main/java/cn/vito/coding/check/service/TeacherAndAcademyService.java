package cn.vito.coding.check.service;

import java.util.List;

import cn.vito.coding.check.po.TeacherAndAcademy;

/**
 * 教师和学院相关service
 * 
 * @author baijw12
 *
 */
public interface TeacherAndAcademyService {
	/**
	 * 教师页面查询大一/大二学生的信息
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
	public List<TeacherAndAcademy> findFreshmanTeacherData(String id, String name, String school, String teacher,
			Integer year, String subjectname, int page, int rows);

	/**
	 * 根据老师姓名大一大二课程列表
	 * 
	 * @param subjectname
	 * @return
	 */
	public List<String> teacherFreshmanList(String subjectname);

	/**
	 * 教师页面查询大三/大四学生的信息
	 * 
	 * @param id
	 * @param name
	 * @param school
	 * @param year
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<TeacherAndAcademy> findJuniorTeacherData(String id, String name, String school, Integer year, int page,
			int rows);

	/**
	 * 学院页面查询大一，大二学生信息
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
	public List<TeacherAndAcademy> findAcademyFreshmanData(String id, String name, String school, Integer year,
			int page, int rows);

	/**
	 * 学院页面查询大三，大四学生信息
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
	public List<TeacherAndAcademy> findAcademyData(String id, String name, String school, String teacher, Integer year,
			int page, int rows);

	/**
	 * 修改教师页面的数据
	 * 
	 * @param data
	 */
	public void updateTeacherData(String id, Integer year, Integer height, Double weight, Integer vital_capacity,
			Double fivem, Double long_jump, Double reach, String eightm, String tenm, Integer sit_ups, Integer pull_up,
			Integer grade, String gender);

}
