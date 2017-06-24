package cn.vito.coding.check.mapper;

import java.util.List;

import cn.vito.coding.check.po.Data;
import cn.vito.coding.check.po.Student;

/**
 * 学生业务处理
 * 
 * @author 刘晓庆
 *
 */
public interface StudentDao {

	/**
	 * 根据用户登录账号获取用户信息
	 * 
	 * @param userName
	 *            用户名
	 * @return user对象
	 */
	public Student findStudentById(String id);

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