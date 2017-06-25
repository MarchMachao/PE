package cn.vito.coding.check.TimedTask;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TimerTaskOnlineDev {

	/**
	 * 从0秒开始，每隔五秒执行一次
	 */
	// @Scheduled(cron = "0/5 * * * * ?")
	// public void onlineTask() {
	// System.out.println(StringUtils.dateTimeToString(new Date()));
	// }
	
	/**
	 * 每年8月25日修改毕业生信息，将a_student.state修改为"已毕业"
	 */
	@Scheduled(cron = "0 0 0 25 8 ?")
	public void updateGraduateState() {

	}

	/**
	 * 每年8月27日修改请假生信息，将a_student.state修改为"正常"
	 */
	@Scheduled(cron = "0 0 0 27 8 ?")
	public void updateLeaveState() {

	}

	/**
	 * 每年8月29日修改大三以上的学生的teacher为"学院"
	 */
	@Scheduled(cron = "0 0 0 29 8 ?")
	public void updateStusTeacher() {

	}

	/**
	 * 每年8月31日为每一位a_student.state为"正常"的学生增加该年体侧任务
	 */
	@Scheduled(cron = "0 0 0 31 8 ?")
	public void insertNewTask() {

	}
}