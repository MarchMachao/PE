package cn.vito.coding.check.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.vito.coding.check.po.TeacherAndAcademy;
import cn.vito.coding.check.service.TeacherAndAcademyService;
import cn.vito.coding.check.vo.DataGrideRow;

/**
 * 用户信息的操作
 * 
 * @author 刘晓庆
 *
 */
@Controller
public class TeacherAndAcademyController {
	@Autowired
	public TeacherAndAcademyService teacherAndAcademyService;

	/**
	 * 教师页面查询和模糊查询所有用户在表格中
	 * 
	 * @param id
	 * @param name
	 * @param school
	 * @param teacher
	 * @param year
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getAllStuData")
	public DataGrideRow<TeacherAndAcademy> findStuData(@RequestParam(defaultValue = "1") String id, String name,
			String school, String teacher, Integer year, int page, int rows) {
		List<TeacherAndAcademy> teachers = teacherAndAcademyService.findTeacherData(id, name, school, teacher, year,
				page, rows);
		return new DataGrideRow<TeacherAndAcademy>(teachers.size(), teachers);
	}

	/**
	 * 学院页面查询和模糊查询所有用户在表格中
	 * 
	 * @param id
	 * @param name
	 * @param school
	 * @param teacher
	 * @param year
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getAcademyData")
	public DataGrideRow<TeacherAndAcademy> findAcaData(@RequestParam(defaultValue = "1") String id, String name,
			String school, String teacher, Integer year, int page, int rows) {
		List<TeacherAndAcademy> teachers = teacherAndAcademyService.findAcademyData(id, name, school, teacher, year,
				page, rows);
		return new DataGrideRow<TeacherAndAcademy>(teachers.size(), teachers);
	}

}
