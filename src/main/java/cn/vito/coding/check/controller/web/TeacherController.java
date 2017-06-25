package cn.vito.coding.check.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.vito.coding.check.po.Teacher;
import cn.vito.coding.check.service.TeacherService;
import cn.vito.coding.check.vo.DataGrideRow;

/**
 * 用户信息的操作
 * 
 * @author 刘晓庆
 *
 */
@Controller
public class TeacherController {
	@Autowired
	public TeacherService teacherService;

	/**
	 * 查询所有用户在表格中
	 * 
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getAllStuData")
	public DataGrideRow<Teacher> findStuData(@RequestParam(defaultValue = "1") int page, int rows) {
		List<Teacher> teachers = teacherService.findTeacherData(page, rows);
		return new DataGrideRow<Teacher>(teacherService.count(), teachers);
	}
}
