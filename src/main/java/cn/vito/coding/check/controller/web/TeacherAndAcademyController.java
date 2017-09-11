package cn.vito.coding.check.controller.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.lf5.util.StreamUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;

import com.lowagie.text.DocumentException;

import cn.vito.coding.check.po.TeacherAndAcademy;
import cn.vito.coding.check.service.TeacherAndAcademyService;
import cn.vito.coding.check.service.UserService;
import cn.vito.coding.check.utils.ExcelUtils;
import cn.vito.coding.check.vo.BaseMsg;
import cn.vito.coding.check.vo.DataGrideRow;
import freemarker.template.TemplateException;

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
	@Autowired
	private UserService userService;

	/**
	 * 教师页面查询和模糊查询大一、大二用户在表格中
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
	@RequestMapping(value = "findStuFreshmanData")
	public DataGrideRow<TeacherAndAcademy> findStuFreshmanData(String id, String name, String school, Integer year,
			String subjectname, int page, int rows) {
		String teacher = userService.getUserByUserName(userService.getCurrentUserName()).getNickName();
		List<TeacherAndAcademy> teachers = teacherAndAcademyService.findFreshmanTeacherData(id, name, school, teacher,
				year, subjectname, page, rows);
		return new DataGrideRow<TeacherAndAcademy>(teachers.size(), teachers);
	}

	/**
	 * 教师输入信息，查询课程的列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "teacherFreshmanList")
	public String teacherFreshmanList(ModelMap modelMap) {
		String teacher = userService.getUserByUserName(userService.getCurrentUserName()).getNickName();
		modelMap.addAttribute("subjuectList", teacherAndAcademyService.teacherFreshmanList(teacher));
		return "teacherFreshmanListManger.ftl";
	}

	/**
	 * 教师输入信息，跳转页面
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "turnToManger")
	public String turnToCheck(ModelMap modelMap, String subjectname) {
		modelMap.addAttribute("teacherSubject", subjectname);
		return "teacherFreshmanManger.ftl";
	}

	/**
	 * 教师页面查询和模糊查询大三、大四用户在表格中
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
	@RequestMapping(value = "findJuniorData")
	public DataGrideRow<TeacherAndAcademy> findJuniorData(@RequestParam(defaultValue = "1") String id, String name,
			String school, String teacher, Integer year, int page, int rows) {
		List<TeacherAndAcademy> teachers = teacherAndAcademyService.findJuniorTeacherData(id, name, school, year, page,
				rows);
		return new DataGrideRow<TeacherAndAcademy>(teachers.size(), teachers);
	}

	/**
	 * 学院页面查询和模糊查询大一，大二在表格中
	 * 
	 * @param id
	 * @param name
	 * @param school
	 * @param year
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "findAcademyFreshmanData")
	public DataGrideRow<TeacherAndAcademy> findAcademyFreshmanData(@RequestParam(defaultValue = "1") String id,
			String name, Integer year, int page, int rows) {
		String userName = userService.getCurrentUserName();
		String school = userService.getUserByUserName(userName).getNickName();
		List<TeacherAndAcademy> teachers = teacherAndAcademyService.findAcademyFreshmanData(id, name, school, year,
				page, rows);
		return new DataGrideRow<TeacherAndAcademy>(teachers.size(), teachers);
	}

	/**
	 * 学院页面查询和模糊查询大三，大四在表格中
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
			Integer year, int page, int rows) {
		String userName = userService.getCurrentUserName();
		String school = userService.getUserByUserName(userName).getNickName();
		List<TeacherAndAcademy> teachers = teacherAndAcademyService.findAcademyData(id, name, school, null, year, page,
				rows);
		return new DataGrideRow<TeacherAndAcademy>(teachers.size(), teachers);
	}

	/**
	 * 教师导出大一和大二成绩Excel
	 * 
	 * @param response
	 * @param id
	 * @param name
	 * @param school
	 * @param teacher
	 * @param year
	 * @param subjectname
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@RequestMapping(value = "downTeacherFreshmanExcel")
	public void downTeacherFreshmanExcel(HttpServletResponse response, String id, String name, String school,
			Integer year, String subjectname) throws FileNotFoundException, IOException {
		String teacher = userService.getUserByUserName(userService.getCurrentUserName()).getNickName();
		excelUtils.outputTeacherFreshmanExcel(id, name, school, teacher, year, subjectname);
		File file = new File("/home/page/excel/pe.xls");
		response.setContentType("application/octet-stream; charset=utf-8");
		response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
		StreamUtils.copyThenClose(new FileInputStream(file), response.getOutputStream());
	}

	/**
	 * 教师导出大三和大四成绩Excel
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
	public void downTeacherExcel(HttpServletResponse response, String id, String name, String school, String teacher,
			Integer year) throws FileNotFoundException, IOException {

		excelUtils.outputTeacherExcel(id, name, school, "学院", year);
		File file = new File("/home/page/excel/pe.xls");
		response.setContentType("application/octet-stream; charset=utf-8");
		response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
		StreamUtils.copyThenClose(new FileInputStream(file), response.getOutputStream());
	}

	/**
	 * 学院导出大一、大二成绩Excel
	 * 
	 * @param response
	 * @param id
	 * @param name
	 * @param school
	 * @param year
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@RequestMapping(value = "downAcademyFreshmanExcel")
	public void downAcademyFreshmanExcel(HttpServletResponse response, String id, String name, Integer year)
			throws FileNotFoundException, IOException {
		String userName = userService.getCurrentUserName();
		String school = userService.getUserByUserName(userName).getNickName();
		excelUtils.outputAcademyFreshmanExcel(id, name, school, year);
		File file = new File("/home/page/excel/pe.xls");
		response.setContentType("application/octet-stream; charset=utf-8");
		response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
		StreamUtils.copyThenClose(new FileInputStream(file), response.getOutputStream());
	}

	/**
	 * 学院导出大三、大四成绩Excel
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
	public void downAcademyExcel(HttpServletResponse response, String id, String name, Integer year)
			throws FileNotFoundException, IOException {
		String userName = userService.getCurrentUserName();
		String school = userService.getUserByUserName(userName).getNickName();
		excelUtils.outputAcademyExcel(id, name, school, year);
		File file = new File("/home/page/excel/pe.xls");
		response.setContentType("application/octet-stream; charset=utf-8");
		response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
		StreamUtils.copyThenClose(new FileInputStream(file), response.getOutputStream());
	}

	/**
	 * 老师Excel导入成绩
	 * 
	 * @param file
	 *            excel文件
	 * @param year
	 *            年份
	 * @return
	 */
	@ResponseBody
	@RequestMapping("uploadTeachersAndAcademyExcel")
	public BaseMsg uploadTeachersAndAcademyExcel(MultipartFile file, Integer year) {
		String FileName = file.getOriginalFilename();
		String prefix = FileName.substring(FileName.lastIndexOf(".") + 1);
		if (!(prefix.equals("xls") | prefix.equals("xlsx"))) {
			return new BaseMsg(false, "上传的文件不是Excel类型，请检查后重新上传！");
		} else {
			if (excelUtils.excelTeachersReader(file, year)) {
				return new BaseMsg(true, "上传成绩成功！");
			} else {
				return new BaseMsg(false, "上传成绩失败！");
			}
		}
	}

	/**
	 * 学院Excel导入成绩
	 * 
	 * @param file
	 *            excel文件
	 * @param year
	 *            年份
	 * @return
	 */
	@ResponseBody
	@RequestMapping("uploadAcademyExcel")
	public BaseMsg uploadAcademyExcel(MultipartFile file, Integer year) {
		String FileName = file.getOriginalFilename();
		String prefix = FileName.substring(FileName.lastIndexOf(".") + 1);
		if (!(prefix.equals("xls") | prefix.equals("xlsx"))) {
			return new BaseMsg(false, "上传的文件不是Excel类型，请检查后重新上传！");
		} else {
			String userName = userService.getCurrentUserName();
			String school = userService.getUserByUserName(userName).getNickName();
			if (excelUtils.excelAcademyReader(file, year, school)) {
				return new BaseMsg(true, "上传成绩成功！");
			} else {
				return new BaseMsg(false, "上传成绩失败！");
			}

		}
	}

	/**
	 * 老师修改成绩
	 * 
	 * @param id
	 * @param year
	 * @param height
	 * @param weight
	 * @param vital_capacity
	 * @param fivem
	 * @param long_jump
	 * @param reach
	 * @param eightm
	 * @param tenm
	 * @param sit_ups
	 * @param pull_up
	 * @param grade
	 * @param gender
	 * @return
	 */
	@ResponseBody
	@RequestMapping("updateTeacherAndAcademy")
	public BaseMsg updateTeacherAndAcademy(String id, Integer year, Integer height, Double weight,
			Integer vital_capacity, Double fivem, Double long_jump, Double reach, String eightm, String tenm,
			Integer sit_ups, Integer pull_up, Integer grade, String gender) {
		try {
			teacherAndAcademyService.updateTeacherData(id, year, height, weight, vital_capacity, fivem, long_jump,
					reach, eightm, tenm, sit_ups, pull_up, grade, gender);
		} catch (Exception e) {
			e.printStackTrace();
			return new BaseMsg(false, "修改成绩失败！");
		}

		return new BaseMsg(true, "修改成绩成功！");
	}

	/**
	 * 导入成绩模板excel
	 * 
	 * @param response
	 * @throws IOException
	 * @throws TemplateException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 * @throws DocumentException
	 */
	@RequestMapping("exampleTeacherAndAcademyExcel")
	public void exampleTeacherAndAcademyExcel(HttpServletResponse response)
			throws IOException, TemplateException, SAXException, ParserConfigurationException, DocumentException {
		File file = new File("/home/page/excel/exampleTeacherAndAcademy.xls");
		if (file.exists()) {
			response.setContentType("application/octet-stream; charset=utf-8");
			response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
			StreamUtils.copyThenClose(new FileInputStream(file), response.getOutputStream());
		} else {
			response.setStatus(404);
		}
	}
}
