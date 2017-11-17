package cn.vito.coding.check.TimedTask;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
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

	private static Logger logger = Logger.getLogger(TimerTaskOnlineDev.class);
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
		logger.info("8月25日updateLeaveState成功！！！");
	}

	/**
	 * 每年8月27日修改请假生信息，将a_student.state修改为"正常"
	 */
	@Scheduled(cron = "0 0 0 27 8 ?")
	public void updateLeaveState() {
		timedTaskDao.updateLeaveState();
		logger.info("8月27日updateLeaveState成功！！！");
	}

	/**
	 * 每年8月29日修改大三以上的学生的teacher为"学院"
	 */
	@Scheduled(cron = "0 0 0 29 8 ?")
	public void updateStusTeacher() {
		String year = StringUtils.yearToString(new Date());
		timedTaskDao.updateStusTeacher(Integer.parseInt(year));
		logger.info("8月29日updateStusTeacher成功！！！");
	}

	/**
	 * 每年8月31日为每一位a_student.state为"正常"的学生增加该年体侧任务
	 */
	@Scheduled(cron = "0 0 0 31 8 ?")
	public void insertNewTask() {
		String year = StringUtils.yearToString(new Date());
		List<String> ids = timedTaskDao.insertNewTask_part_1();
		List<Data> datas = new ArrayList<>();
		for (String id : ids) {
			datas.add(new Data(id, Integer.parseInt(year)));
		}
		timedTaskDao.insertNewTask_part_2(datas);
		logger.info("8月31日insertNewTask成功！！！");
	}

	/**
	 * 数据库定时备份
	 * 
	 * @throws InterruptedException
	 */
	@Scheduled(cron = "0 0 3 1 * ?")
	public void exportDatabaseTool() {
		// String hostIP = "localhost";
		String hostIP = "123.206.214.132";
		String userName = "root";
		// String password = "root";
		String password = "machao911214";
		String savePath = "/home/page/backup";
		String fileName = StringUtils.dateToString(new Date()) + "pe.sql";
		String databaseName = "pe";
		File saveFile = new File(savePath);
		if (!saveFile.exists()) {// 如果目录不存在
			saveFile.mkdirs();// 创建文件夹
		}
		if (!savePath.endsWith(File.separator)) {
			savePath = savePath + File.separator;
		}

		PrintWriter printWriter = null;
		BufferedReader bufferedReader = null;
		try {
			printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(savePath + fileName), "utf8"));
			Process process = Runtime.getRuntime().exec(" mysqldump -h" + hostIP + " -u" + userName + " -p" + password
					+ " --set-charset=UTF8 " + databaseName);
			InputStreamReader inputStreamReader = new InputStreamReader(process.getInputStream(), "utf8");
			bufferedReader = new BufferedReader(inputStreamReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				printWriter.println(line);
			}
			printWriter.flush();
			if (process.waitFor() == 0) {// 0 表示线程正常终止。
				logger.info("备份数据库成功");
				return;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
				if (printWriter != null) {
					printWriter.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		logger.info("备份数据库失败！！！");
	}
}