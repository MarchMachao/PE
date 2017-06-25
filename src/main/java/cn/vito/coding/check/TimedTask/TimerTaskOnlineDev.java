package cn.vito.coding.check.TimedTask;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import cn.vito.coding.check.mapper.TimedTaskDao;
import cn.vito.coding.check.po.Data;
import cn.vito.coding.check.utils.StringUtils;

@Component
public class TimerTaskOnlineDev {

	@Autowired
	private TimedTaskDao timedTaskDao;
	/**
	 * 从0秒开始，每隔五秒执行一次
	 */
	// @Scheduled(cron = "0/5 * * * * ?")
	// public void onlineTask() {
	// System.out.println(StringUtils.yearToString(new Date()));
	// }
	
	/**
	 * 每年8月25日修改毕业生信息，将a_student.state修改为"已毕业"
	 */
	@Scheduled(cron = "0 0 0 25 8 ?")
	public void updateGraduateState() {
		String year = StringUtils.yearToString(new Date());
		timedTaskDao.updateGraduateState(Integer.parseInt(year));
	}

	/**
	 * 每年8月27日修改请假生信息，将a_student.state修改为"正常"
	 */
	@Scheduled(cron = "0 0 0 27 8 ?")
	public void updateLeaveState() {
		timedTaskDao.updateLeaveState();
	}

	/**
	 * 每年8月29日修改大三以上的学生的teacher为"学院"
	 */
	@Scheduled(cron = "0 0 0 29 8 ?")
	public void updateStusTeacher() {
		String year = StringUtils.yearToString(new Date());
		timedTaskDao.updateStusTeacher(Integer.parseInt(year));
	}

	/**
	 * 每年8月31日为每一位a_student.state为"正常"的学生增加该年体侧任务
	 */
	@Scheduled(cron = "0 0 0 31 8 ?")
	// @Scheduled(cron = "0/5 * * * * ?")
	public void insertNewTask() {
		String year = StringUtils.yearToString(new Date());
		List<String> ids = timedTaskDao.insertNewTask_part_1();
		List<Data> datas = new ArrayList<>();
		for (String id : ids) {
			datas.add(new Data(id, Integer.parseInt(year)));
		}
		timedTaskDao.insertNewTask_part_2(datas);
	}
}