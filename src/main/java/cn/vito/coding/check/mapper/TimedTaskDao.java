package cn.vito.coding.check.mapper;

import java.util.List;

import cn.vito.coding.check.po.Data;

/**
 * 定时任务DAO
 * 
 * @author March
 *
 */
public interface TimedTaskDao {

	/**
	 * 每年8月25日修改毕业生信息，将a_student.state修改为"已毕业"
	 */
	public void updateGraduateState(int year);

	/**
	 * 每年8月27日修改请假生信息，将a_student.state修改为"正常"
	 */
	public void updateLeaveState();

	/**
	 * 每年8月29日修改大三以上的学生的teacher为"学院"
	 */
	public void updateStusTeacher(int year);

	/**
	 * 每年8月31日为每一位a_student.state为"正常"的学生增加该年体侧任务 ！ 第一部分！
	 */
	public List<String> insertNewTask_part_1();

	/**
	 * 每年8月31日为每一位a_student.state为"正常"的学生增加该年体侧任务 ！ 第二部分！
	 */
	public void insertNewTask_part_2(List<Data> datas);
}