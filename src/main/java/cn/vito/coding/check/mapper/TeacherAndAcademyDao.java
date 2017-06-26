package cn.vito.coding.check.mapper;

import java.util.List;

import cn.vito.coding.check.po.TeacherAndAcademy;
import cn.vito.coding.check.po.TeacherAndAcademyLike;

/**
 * 页面操作
 * 
 * @author 刘晓庆
 *
 */
public interface TeacherAndAcademyDao {

	/**
	 * 教师页面查询所有学生的信息
	 * 
	 * @return
	 */
	public List<TeacherAndAcademy> findTeacherData(TeacherAndAcademyLike teacherLike);

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
	public List<TeacherAndAcademy> findTeacherExcel(TeacherAndAcademyLike teacherAndAcademyLike);

	/**
	 * 学院页面查询所有学生的信息
	 * 
	 * @return
	 */
	public List<TeacherAndAcademy> findAcademyData(TeacherAndAcademyLike teacherLike);

}