package cn.vito.coding.check.mapper;

import java.util.List;

import cn.vito.coding.check.po.Teacher;
import cn.vito.coding.check.vo.Page;

/**
 * 教师页面操作
 * 
 * @author 刘晓庆
 *
 */
public interface TeacherDao {

	/**
	 * 查询所有学生的信息
	 * 
	 * @return
	 */
	public List<Teacher> findTeacherData(Page page);

	/**
	 * 获取学生数据数量
	 * 
	 * @return
	 */
	public int count();
}