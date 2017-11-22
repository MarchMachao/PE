package cn.vito.coding.check.service;

import java.util.List;

import cn.vito.coding.check.po.Extras;

public interface ExtrasService {

	/**
	 * 查询学生附加分数据
	 * 
	 * @param extras
	 * @return
	 */
	public List<Extras> findStudentExtras(Extras extras);

	/**
	 * 查询学生附加分数据量
	 * 
	 * @param extras
	 * @return
	 */
	public int countStudentExtras(Extras extras);
}
