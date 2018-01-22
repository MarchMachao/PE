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
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;

import com.lowagie.text.DocumentException;

import cn.vito.coding.check.po.TeacherAndAcademy;
import cn.vito.coding.check.po.TeacherToStudent;
import cn.vito.coding.check.service.AdminService;
import cn.vito.coding.check.utils.ExcelUtils;
import cn.vito.coding.check.utils.StringUtils;
import cn.vito.coding.check.utils.ValidaterUtil;
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
public class AdminController {

	@Autowired
	public AdminService adminService;
	@Autowired
	private ExcelUtils excelUtils;

	/**
	 * 管理员页面查询和模糊查询所有未毕业数据在表格中
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
	@RequestMapping(value = "getAdminData")
	public DataGrideRow<TeacherAndAcademy> findStuData(String id, String name, String school,
			Integer year, @RequestParam(defaultValue = "1") int page, int rows) {
		List<TeacherAndAcademy> teachers = adminService.findAdminData(id, name, school, year, page, rows);
		return new DataGrideRow<TeacherAndAcademy>(adminService.countAdminDatas(id, name, school, year),
				teachers);
	}

	/**
	 * 查询已毕业数据
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
	@RequestMapping(value = "getAdminGraduateData")
	public DataGrideRow<TeacherAndAcademy> findAdminData(String id, String name, String school,
			Integer year, @RequestParam(defaultValue = "1") int page, int rows) {
		List<TeacherAndAcademy> teachers = adminService.findAdminGraduateData(id, name, school, year, page, rows);
		return new DataGrideRow<TeacherAndAcademy>(
				adminService.countAdminGraduateDatas(id, name, school, year), teachers);
	}

	/**
	 * 导出成绩Excel
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
	@RequestMapping(value = "downAdminExcel")
	public void downTeacherExcel(HttpServletResponse response, String id, String name, String school, String teacher,
			Integer year) throws FileNotFoundException, IOException {
		excelUtils.outputTeacherExcel(id, name, school, teacher, year);
		File file = new File("/home/page/excel/pe2.xls");
		response.setContentType("application/octet-stream; charset=utf-8");
		response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
		StreamUtils.copyThenClose(new FileInputStream(file), response.getOutputStream());
	}

	/**
	 * Excel导入成绩
	 * 
	 * @param file
	 *            excel文件
	 * @param year
	 *            年份
	 * @return
	 */
	@ResponseBody
	@RequestMapping("uploadAdminExcel")
	public BaseMsg uploadTeachersAndAcademyExcel(MultipartFile file, Integer year) {
		String FileName = file.getOriginalFilename();
		String prefix = FileName.substring(FileName.lastIndexOf(".") + 1);
		if (!(prefix.equals("xls") | prefix.equals("xlsx"))) {
			return new BaseMsg(false, "上传的文件不是Excel类型，请检查后重新上传！");
		} else {
			if (excelUtils.excelAdminUpdateReader(file, year)) {
				return new BaseMsg(true, "上传成绩成功！");
			} else {
				return new BaseMsg(true, "上传成绩失败！");
			}

		}
	}

	/**
	 * 管理员修改成绩
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
	@RequestMapping("updateAdmin")
	public BaseMsg updateTeacherAndAcademy(String id, Integer year, Integer height, Double weight,
			Integer vital_capacity, Double fivem, Double long_jump, Double reach, String eightm_minuite,
			String eightm_second, String tenm_minuite, String tenm_second, Integer sit_ups, Integer pull_up,
			Integer grade, String gender) {
		if (!ValidaterUtil.checkHeight(height)) {
			return new BaseMsg(false, "身高超出正常范围");
		}
		if (!ValidaterUtil.checkWeight(weight)) {
			return new BaseMsg(false, "体重超出正常范围");
		}
		if (!ValidaterUtil.checkVital_capacity(vital_capacity)) {
			return new BaseMsg(false, "肺活量超出正常范围");
		}
		if (!ValidaterUtil.checkFivem(fivem)) {
			return new BaseMsg(false, "50m超出正常范围");
		}
		if (!ValidaterUtil.checkLong_jump(long_jump)) {
			return new BaseMsg(false, "跳远超出正常范围");
		}
		if (!ValidaterUtil.checkReach(reach)) {
			return new BaseMsg(false, "坐位体前屈超出正常范围");
		}
		try {
			String eightm="";
			String tenm = "";
			if (!StringUtils.isEmpty(eightm_minuite) && !StringUtils.isEmpty(eightm_second)) {
				eightm = eightm_minuite + "'" + eightm_second;
				if (!ValidaterUtil.checkRunningTime(eightm)) {
					return new BaseMsg(false, "800m超出正常范围");
				}
				if (!ValidaterUtil.checkSit_ups(sit_ups)) {
					return new BaseMsg(false, "仰卧起坐超出正常范围");
				}
			} 
			if (!StringUtils.isEmpty(tenm_minuite) && !StringUtils.isEmpty(tenm_second)) {
				tenm = tenm_minuite + "'" + tenm_second;
				if (!ValidaterUtil.checkRunningTime(tenm)) {
					return new BaseMsg(false, "1000m超出正常范围");
				}
				if (!ValidaterUtil.checkPull_up(pull_up)) {
					return new BaseMsg(false, "引体向上超出正常范围");
				}
			}
			adminService.updateAdminData(id, year, height, weight, vital_capacity, fivem, long_jump, reach, eightm,
					tenm, sit_ups, pull_up, grade, gender);
		} catch (DuplicateKeyException e) {
			e.printStackTrace();
			return new BaseMsg(false, "已存在该条数据！");
		} catch (Exception e) {
			e.printStackTrace();
			return new BaseMsg(false, "修改失败!");
		}
		return new BaseMsg(true, "修改成功!");
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
	@RequestMapping("exampleAdminExcel")
	public void exampleAdminExcel(HttpServletResponse response)
			throws IOException, TemplateException, SAXException, ParserConfigurationException, DocumentException {
		File file = new File("/home/page/excel/exampleAdminExcel.xls");
		if (file.exists()) {
			response.setContentType("application/octet-stream; charset=utf-8");
			response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
			StreamUtils.copyThenClose(new FileInputStream(file), response.getOutputStream());
		} else {
			response.setStatus(404);
		}
	}

	/**
	 * 查询老师和学生、课程之间的关系
	 * 
	 * @author March
	 * 
	 * @param studentId
	 * @param school
	 * @param year
	 * @param teacher
	 * @param subjectId
	 * @param subjectName
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResponseBody
	@RequestMapping("findTeachersToStudentData")
	public DataGrideRow<TeacherToStudent> findTeachersToStudentData(String studentId, String school, Integer year,
			String teacher, Integer subjectId, String subjectName, @RequestParam(defaultValue = "0") int page,
			int rows) {
		List<TeacherToStudent> teacherToStudents = adminService.findTeachersToStudentData(studentId, school, year,
				teacher, subjectId, subjectName, page, rows);
		return new DataGrideRow<TeacherToStudent>(
				adminService.countTeacherToStudent(studentId, school, year, teacher, subjectId, subjectName),
				teacherToStudents);
	}

	/**
	 * 学生与教师对应关系管理页面增加一条数据
	 * 
	 * @param studentId
	 * @param year
	 * @param teacher
	 * @param subjectId
	 * @param subjectName
	 * @return
	 */
	@ResponseBody
	@RequestMapping("addOneTeacherToStudentData")
	public BaseMsg addOneTeacherToStudentData(String studentId, Integer year, String teacher, Integer subjectId,
			String subjectName) {
		try {
			adminService.addOneTeacherToStudentData(studentId, year, teacher, subjectId, subjectName);
		} catch (Exception e) {
			e.printStackTrace();
			return new BaseMsg(false, "添加失败");
		}
		
		return new BaseMsg(true, "添加成功");
	}

	/**
	 * 学生与教师对应关系管理页面删除一条数据
	 * 
	 * @param studentId
	 * @param year
	 * @return
	 */
	@ResponseBody
	@RequestMapping("deleteTeacherToStudentData")
	public BaseMsg deleteTeacherToStudentData(String studentId, Integer year) {
		if (studentId.isEmpty() || year.equals(null)) {
			return new BaseMsg(false, "删除失败");
		}
		adminService.deleteTeacherToStudentData(studentId, year);
		return new BaseMsg(true, "删除成功");
	}

	/**
	 * 学生与教师对应关系管理页面修改一条数据
	 * 
	 * @param studentId
	 * @param year
	 * @param teacher
	 * @param subjectId
	 * @param subjectName
	 * @return
	 */
	@ResponseBody
	@RequestMapping("updateTeacherToStudentData")
	public BaseMsg updateTeacherToStudentData(String studentId, Integer year, String teacher, Integer subjectId,
			String subjectName) {
		adminService.updateTeacherToStudentData(studentId, year, teacher, subjectId, subjectName);
		return new BaseMsg(true, "更新成功");
	}

	/**
	 * 学生老师绑定页面导入excel
	 * 
	 * @param file
	 * @param year
	 * @return
	 */
	@ResponseBody
	@RequestMapping("uploadTeacherToStudentExcel")
	public BaseMsg uploadTeacherToStudentExcel(MultipartFile file, Integer year) {
		String FileName = file.getOriginalFilename();
		String prefix = FileName.substring(FileName.lastIndexOf(".") + 1);
		if (!(prefix.equals("xls") | prefix.equals("xlsx"))) {
			return new BaseMsg(false, "上传的文件不是Excel类型，请检查后重新上传！");
		} else if (excelUtils.excelTeacherToStudentReader(file, year)) {
			return new BaseMsg(true, "上传成功！");
		} else {
			return new BaseMsg(false, "上传失败！");
		}
	}

	/**
	 * 学生老师绑定页面导入excel的样表
	 * 
	 * @param response
	 * @throws IOException
	 * @throws TemplateException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 * @throws DocumentException
	 */
	@RequestMapping("exampleTeacherToStudentExcel")
	public void exampleTeacherToStudentExcel(HttpServletResponse response)
			throws IOException, TemplateException, SAXException, ParserConfigurationException, DocumentException {
		File file = new File("/home/page/excel/exampleTeacherToStudent.xls");
		if (file.exists()) {
			response.setContentType("application/octet-stream; charset=utf-8");
			response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
			StreamUtils.copyThenClose(new FileInputStream(file), response.getOutputStream());
		} else {
			response.setStatus(404);
		}
	}

	/**
	 * 管理员增加学生数据
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
	@RequestMapping("addOneStudentData")
	public BaseMsg addOneStudentData(String id, Integer year, Integer height, Double weight, Integer vital_capacity,
			Double fivem, Double long_jump, Double reach, String eightm_minuite, String eightm_second,
			String tenm_minuite, String tenm_second, Integer sit_ups, Integer pull_up, Integer grade, String gender) {
		if (!ValidaterUtil.checkHeight(height)) {
			return new BaseMsg(false, "身高超出正常范围");
		}
		if (!ValidaterUtil.checkWeight(weight)) {
			return new BaseMsg(false, "体重超出正常范围");
		}
		if (!ValidaterUtil.checkVital_capacity(vital_capacity)) {
			return new BaseMsg(false, "肺活量超出正常范围");
		}
		if (!ValidaterUtil.checkFivem(fivem)) {
			return new BaseMsg(false, "50m超出正常范围");
		}
		if (!ValidaterUtil.checkLong_jump(long_jump)) {
			return new BaseMsg(false, "跳远超出正常范围");
		}
		if (!ValidaterUtil.checkReach(reach)) {
			return new BaseMsg(false, "坐位体前屈超出正常范围");
		}
		try {
			String eightm = "";
			String tenm = "";
			if (!StringUtils.isEmpty(eightm_minuite) && !StringUtils.isEmpty(eightm_second)) {
				eightm = eightm_minuite + "'" + eightm_second;
				if (!ValidaterUtil.checkRunningTime(eightm)) {
					return new BaseMsg(false, "800m超出正常范围");
				}
				if (!ValidaterUtil.checkSit_ups(sit_ups)) {
					return new BaseMsg(false, "仰卧起坐超出正常范围");
				}
			}
			if (!StringUtils.isEmpty(tenm_minuite) && !StringUtils.isEmpty(tenm_second)) {
				tenm = tenm_minuite + "'" + tenm_second;
				if (!ValidaterUtil.checkRunningTime(tenm)) {
					return new BaseMsg(false, "1000m超出正常范围");
				}
				if (!ValidaterUtil.checkPull_up(pull_up)) {
					return new BaseMsg(false, "引体向上超出正常范围");
				}
			}
			adminService.addOneStudentData(id, year, height, weight, vital_capacity, fivem, long_jump, reach, eightm,
					tenm, sit_ups, pull_up, grade, gender);
		} catch (DuplicateKeyException e) {
			return new BaseMsg(false, "已有该条数据！");
		} catch (Exception e) {
			e.printStackTrace();
			return new BaseMsg(false, "失败！请检查");
		}

		return new BaseMsg(true, "增加成功！");
	}

	/**
	 * 管理员上传新增的学生成绩数据
	 * 
	 * @param file
	 * @param year
	 * @return
	 */
	@ResponseBody
	@RequestMapping("uploadStudentsDatasExcel")
	public BaseMsg uploadStudentsDatasExcel(MultipartFile file, Integer year) {
		String FileName = file.getOriginalFilename();
		String prefix = FileName.substring(FileName.lastIndexOf(".") + 1);
		if (!(prefix.equals("xls") | prefix.equals("xlsx"))) {
			return new BaseMsg(false, "上传的文件不是Excel类型，请检查后重新上传！");
		} else if (excelUtils.excelAdminReader(file, year)) {
			return new BaseMsg(true, "上传成功！");
		} else {
			return new BaseMsg(false, "上传失败！");
		}
	}

	/**
	 * 管理员导出未毕业数据excel
	 * 
	 * @param response
	 * @param id
	 * @param name
	 * @param school
	 * @param year
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@RequestMapping(value = "outputAdminDatasExcel")
	public void outputAdminDatasExcel(HttpServletResponse response, String id, String name, String school, Integer year)
			throws FileNotFoundException, IOException {
		excelUtils.outputAdminDatasExcel(id, name, school, year);
		File file = new File("/home/page/excel/pe5.xls");
		response.setContentType("application/octet-stream; charset=utf-8");
		response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
		StreamUtils.copyThenClose(new FileInputStream(file), response.getOutputStream());
	}

	/**
	 * 管理员导出未毕业数据excel
	 * 
	 * @param response
	 * @param id
	 * @param name
	 * @param school
	 * @param year
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@RequestMapping(value = "outputAdminGraduateDatasExcel")
	public void outputAdminGraduateDatasExcel(HttpServletResponse response, String id, String name, String school,
			Integer year)
			throws FileNotFoundException, IOException {
		excelUtils.outputAdminGraduateDatasExcel(id, name, school, year);
		File file = new File("/home/page/excel/pe6.xls");
		response.setContentType("application/octet-stream; charset=utf-8");
		response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
		StreamUtils.copyThenClose(new FileInputStream(file), response.getOutputStream());
	}
}
