package cn.vito.coding.check.mapper;

import java.util.List;

import cn.vito.coding.check.po.Extras;

/**
 * 附加分DAO
 * 
 * @author March
 *
 */
public interface ExtrasDao {

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

	/**
	 * 增加一条附加分数据
	 * 
	 * @param extras
	 */
	public void addOneExtra(Extras extras);

	/**
	 * 修改一条附加分数据
	 * 
	 * @param extras
	 */
	public void updateExtras(Extras extras);

	/**
	 * 删除一条附加分数据
	 * 
	 * @param extras
	 */
	public void deleteExtras(Extras extras);
}