package cn.vito.coding.check.service;

import java.util.List;

import cn.vito.coding.check.po.Teacher;

/**
 * 教师和学院相关service
 * 
 * @author baijw12
 *
 */
public interface TeacherService {
	/**
	 * 查询所有学生信息
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */

	public List<Teacher> findTeacherData(int pageNo, int pageSize);

	/**
	 * 获取用户数量
	 * 
	 * @return
	 */
	public int count();

}
