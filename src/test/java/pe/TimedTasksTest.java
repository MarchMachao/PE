package pe;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import cn.vito.coding.check.TimedTask.TimerTaskOnlineDev;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context.xml" })
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class TimedTasksTest {
	@Autowired
	ApplicationContext ctx;

	@Test
	public void test() {
		TimerTaskOnlineDev timerTaskOnlineDev = ctx.getBean(TimerTaskOnlineDev.class);
		timerTaskOnlineDev.insertNewTask();
	}

}
