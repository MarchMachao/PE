package cn.vito.coding.check.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.vito.coding.check.po.Data;
import cn.vito.coding.check.service.StudentService;
import cn.vito.coding.check.service.UserService;

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
		modelMap.addAttribute("item", studentService.findStudentById(userService.getCurrentUserName()));
		return "student.ftl";
	}

	@ResponseBody
	@RequestMapping(value = "getAllDataById")
	public List<Data> findDataById() {
		return studentService.findAllDataById(userService.getCurrentUserName());
	}

}
