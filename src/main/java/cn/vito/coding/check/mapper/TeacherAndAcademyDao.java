package cn.vito.coding.check.mapper;

import java.util.List;

import cn.vito.coding.check.po.Data;
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
	 * 教师页面查询大一/大二学生的信息
	 * 
	 * @return
	 */
	public List<TeacherAndAcademy> findFreshmanTeacherData(TeacherAndAcademyLike teacherLike);

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
	 * @return
	 */
	public List<TeacherAndAcademy> findJuniorTeacherData(TeacherAndAcademyLike teacherLike);

	/**
	 * 教师页面导出大一/大二学生的Excel信息
	 * 
	 * @return
	 */
	public List<TeacherAndAcademy> findTeacherFreshmanExcel(TeacherAndAcademyLike teacherLike);

	/**
	 * 教师页面导出大三、大四Excel的数据
	 * 
	 * @param id
	 * @param name
	 * @param school
	 * @param teacher
	 * @param year
	 * @return
	 */
	public List<TeacherAndAcademy> findTeacherExcel(TeacherAndAcademyLike teacherAndAcademyLike);

	// ==============================学院数据操作===================================================

	/**
	 * 学院页面查询大一，大二学生的信息
	 * 
	 * @return
	 */
	public List<TeacherAndAcademy> findAcademyFreshmanData(TeacherAndAcademyLike teacherLike);

	/**
	 * 学院页面查询大三，大四学生的信息
	 * 
	 * @return
	 */
	public List<TeacherAndAcademy> findAcademyData(TeacherAndAcademyLike teacherLike);

	/**
	 * 学院页面导出大一，大二Excel的数据
	 * 
	 * @param id
	 * @param name
	 * @param school
	 * @param teacher
	 * @param year
	 * @return
	 */
	public List<TeacherAndAcademy> findAcademyFreshmanExcel(TeacherAndAcademyLike teacherAndAcademyLike);

	/**
	 * 学院页面导出大三、大四Excel的数据
	 * 
	 * @param id
	 * @param name
	 * @param school
	 * @param teacher
	 * @param year
	 * @return
	 */
	public List<TeacherAndAcademy> findAcademyExcel(TeacherAndAcademyLike teacherAndAcademyLike);

	/**
	 * 修改教师页面的数据
	 * 
	 * @param data
	 */
	public void updateTeacherData(Data data);

	/**
	 * 教师页面查询大一、大二的数据量
	 * 
	 * @param teacherAndAcademyLike
	 * @return
	 */
	public int countFreshmanTeacherData(TeacherAndAcademyLike teacherAndAcademyLike);

	/**
	 * 教师页面中查询大三大四的数据量
	 * 
	 * @param teacherAndAcademyLike
	 * @return
	 */
	public int countJuniorTeacherData(TeacherAndAcademyLike teacherAndAcademyLike);

	/**
	 * 学院页面查询大三，大四的数据量
	 * 
	 * @param teacherAndAcademyLike
	 * @return
	 */
	public int countAcademyData(TeacherAndAcademyLike teacherAndAcademyLike);

	/**
	 * 学院页面查询大一，大二的数据量
	 * 
	 * @param teacherAndAcademyLike
	 * @return
	 */
	public int countAcademyFreshmanData(TeacherAndAcademyLike teacherAndAcademyLike);
}