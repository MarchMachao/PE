package pe;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import cn.vito.coding.check.po.Extras;
import cn.vito.coding.check.service.ExtrasService;
import cn.vito.coding.check.serviceImpl.ExtrasServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context.xml" })
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class TimedTasksTest {
	@Autowired
	ApplicationContext ctx;

	@Test
	public void test() {
		// StudentService studentService = ctx.getBean(StudentService.class);
		ExtrasService extrasService = ctx.getBean(ExtrasServiceImpl.class);
		// StudentAndItsTeacher studentAndItsTeacher = studentService
		// .findStudentById("220150925821");
		List<Extras> list = extrasService.findStudentExtras(new Extras(null, null, null, 1, 100));
		System.out.println(list.get(0).getGender());
		// System.out.println(studentAndItsTeacher);
	}

}
