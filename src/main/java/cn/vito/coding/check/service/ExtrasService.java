package cn.vito.coding.check.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

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

	/**
	 * 增加一条附加分数据
	 * 
	 * @param id
	 * @param year
	 * @param extras
	 */
	public void addOneExtra(String id, Integer year, Double extra);

	/**
	 * 修改一条附加分数据
	 * 
	 * @param id
	 * @param year
	 * @param extras
	 */
	public void updateExtras(String id, Integer year, Double extra);

	/**
	 * 删除一条附加分数据
	 * 
	 * @param id
	 * @param year
	 */
	public void deleteExtras(String id, Integer year);

	/**
	 * Excel附加分新增导入
	 * 
	 * @param file
	 * @param year
	 * @return
	 */
	public boolean excelExtrasInsertReader(MultipartFile file, int year);

	/**
	 * 附加分Excel导出
	 * 
	 * @param extras
	 */
	public void outputExtrasExcel(Extras extras);
}
