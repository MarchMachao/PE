package cn.vito.coding.check.mapper;

import java.util.List;

import cn.vito.coding.check.po.Data;
import cn.vito.coding.check.po.Student;
import cn.vito.coding.check.po.StudentAndItsTeacher;

/**
 * 学生业务处理
 * 
 * @author 刘晓庆
 *
 */
public interface StudentDao {

	/**
	 * 根据学生登录账号获取学生基本信息
	 * 
	 * @param userName
	 *            用户名
	 * @return user对象
	 */
	public Student findStudentById(String id);

	/**
	 * 根据学生登录账号获取师生绑定信息
	 * 
	 * @param id
	 * @return
	 */
	public StudentAndItsTeacher findStudentToTeacherById(String id);

	/**
	 * 查询所有的data数据
	 * 
	 * @return
	 */
	public List<Data> findAllDataById(String id);

	/**
	 * 更新学生班级信息
	 * 
	 * @param student
	 */
	public void updateData(Student student);
}