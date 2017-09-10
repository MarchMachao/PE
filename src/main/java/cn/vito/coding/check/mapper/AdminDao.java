package cn.vito.coding.check.mapper;

import java.util.List;

import cn.vito.coding.check.po.Data;
import cn.vito.coding.check.po.TeacherAndAcademy;
import cn.vito.coding.check.po.TeacherAndAcademyLike;
import cn.vito.coding.check.po.TeacherToStudent;

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

	/**
	 * 老师与学生、课程之间的对应关系
	 * 
	 * @param teacherToStudent
	 * @return
	 */
	public List<TeacherToStudent> findTeachersToStudentData(TeacherToStudent teacherToStudent);

	/**
	 * 学生与教师对应关系管理页面增加一条数据
	 * 
	 * @param teacherToStudent
	 */
	public void addOneTeacherToStudentData(TeacherToStudent teacherToStudent);

	/**
	 * 学生与教师对应关系管理页面导入数据
	 * 
	 * @param teacherToStudents
	 */
	public void addTeacherToStudentDatas(List<TeacherToStudent> teacherToStudents);

	/**
	 * 学生与教师对应关系管理页面删除一条数据
	 * 
	 * @param teacherToStudent
	 */
	public void deleteTeacherToStudentData(TeacherToStudent teacherToStudent);

	/**
	 * 学生与教师对应关系管理页面修改一条数据
	 * 
	 * @param teacherToStudent
	 */
	public void updateTeacherToStudentData(TeacherToStudent teacherToStudent);
}