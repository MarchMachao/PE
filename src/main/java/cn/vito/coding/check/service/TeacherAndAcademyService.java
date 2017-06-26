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
	 * 教师页面查询所有学生信息
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
	public List<TeacherAndAcademy> findTeacherData(String id, String name, String school, String teacher, Integer year,
			int page, int rows);

	/**
	 * 教师页面查询出Excel的数据
	 * 
	 * @param id
	 * @param name
	 * @param school
	 * @param teacher
	 * @param year
	 * @return
	 */
	public List<TeacherAndAcademy> findTeacherExcel(String id, String name, String school, String teacher,
			Integer year);

	/**
	 * 学院页面查询所有学生信息
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

}
