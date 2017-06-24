package cn.vito.coding.check.service;

import java.util.List;

import cn.vito.coding.check.po.Data;
import cn.vito.coding.check.po.Student;

/**
 * 学生业务操作
 * 
 * @author 刘晓庆
 *
 */
public interface StudentService {

	/**
	 * 根据用户账号获取用户信息
	 * 
	 * @param userName
	 *            用户账号
	 * @return 用户信息
	 */
	public Student findStudentById(String id);

	/**
	 * 查询所有的data数据
	 * 
	 * @return
	 */
	public List<Data> findAllDataById(String id);
}
