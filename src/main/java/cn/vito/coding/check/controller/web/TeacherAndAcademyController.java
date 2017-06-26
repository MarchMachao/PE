package cn.vito.coding.check.controller.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.lf5.util.StreamUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.vito.coding.check.po.TeacherAndAcademy;
import cn.vito.coding.check.service.TeacherAndAcademyService;
import cn.vito.coding.check.utils.ExcelUtils;
import cn.vito.coding.check.vo.BaseMsg;
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
	@Autowired
	private ExcelUtils excelUtils;

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

	/**
	 * 教师导出成绩Excel
	 * 
	 * @param response
	 * @param id
	 * @param name
	 * @param school
	 * @param teacher
	 * @param year
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@RequestMapping(value = "downTeacherExcel")
	public BaseMsg downTeacherExcel(HttpServletResponse response, String id, String name, String school, String teacher,
			Integer year) throws FileNotFoundException, IOException {
		excelUtils.outputTeacherExcel(id, name, school, teacher, year);
		File file = new File("/home/pe.xls");
		response.setContentType("application/octet-stream; charset=utf-8");
		response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
		StreamUtils.copyThenClose(new FileInputStream(file), response.getOutputStream());
		return new BaseMsg(true, "成功导出Excel");
	}

	/**
	 * 学院导出成绩Excel
	 * 
	 * @param response
	 * @param id
	 * @param name
	 * @param school
	 * @param year
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@RequestMapping(value = "downAcademyExcel")
	public void downAcademyExcel(HttpServletResponse response, String id, String name, String school, Integer year)
			throws FileNotFoundException, IOException {
		excelUtils.outputAcademyExcel(id, name, school, year);
		File file = new File("/home/pe.xls");
		response.setContentType("application/octet-stream; charset=utf-8");
		response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
		StreamUtils.copyThenClose(new FileInputStream(file), response.getOutputStream());
	}
}
