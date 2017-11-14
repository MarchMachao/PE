package cn.vito.coding.check.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.vito.coding.check.po.Data;
import cn.vito.coding.check.po.Student;
import cn.vito.coding.check.po.StudentAndItsTeacher;
import cn.vito.coding.check.service.StudentService;
import cn.vito.coding.check.service.UserService;
import cn.vito.coding.check.vo.BaseMsg;

/**
 * 学生权限操作
 * 
 * @author 刘晓庆
 *
 */
@Controller
public class StudentController {

	@Autowired
	public StudentService studentService;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "getStudentById")
	public String findStudentById(ModelMap modelMap) {
		String id = userService.getCurrentUserName();
		Student s = studentService.findStudentById(id);
		StudentAndItsTeacher s2 = studentService.findStudentToTeacherById(id);
		System.out.println(s);
		modelMap.addAttribute("item", s);
		modelMap.addAttribute("teacher", s2);
		return "student.ftl";
	}

	@ResponseBody
	@RequestMapping(value = "getAllDataById")
	public List<Data> findDataById() {
		return studentService.findAllDataById(userService.getCurrentUserName());
	}
	
	@ResponseBody
	@RequestMapping(value = "updateClass")
	public BaseMsg updateData(String classes) {
		studentService.updateData(userService.getCurrentUserName(), classes);
		return new BaseMsg(true, "修改班级信息成功!");
	}
}
