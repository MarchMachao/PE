package pe;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import cn.vito.coding.check.utils.ExcelUtils;

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
		ExcelUtils excelUtils = ctx.getBean(ExcelUtils.class);
		// StudentAndItsTeacher studentAndItsTeacher = studentService
		// .findStudentById("220150925821");
		excelUtils.outputAdminDatasExcel("320130901041", null, "草地农业科技学院", null);
		// System.out.println(studentAndItsTeacher);
	}

}
