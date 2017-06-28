package cn.vito.coding.check.mapper;

import java.util.List;

import cn.vito.coding.check.po.TeacherAndAcademy;
import cn.vito.coding.check.vo.Page;

/**
 * 审核操作
 * 
 * @author 刘晓庆
 *
 */
public interface CheckDao {
	/**
	 * 查询需要审核的数据
	 * 
	 * @return
	 */
	public List<TeacherAndAcademy> findCheckData(Page page);
}