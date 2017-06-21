package cn.vito.coding.check.TimedTask;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import cn.vito.coding.check.utils.StringUtils;

@Component
public class TimerTaskOnlineDev {

	/**
	 * 从0秒开始，每隔五秒执行一次
	 */
	@Scheduled(cron = "0/5 * * * * ?")
	public void onlineTask() {
		System.out.println(StringUtils.dateTimeToString(new Date()));
	}
	
}