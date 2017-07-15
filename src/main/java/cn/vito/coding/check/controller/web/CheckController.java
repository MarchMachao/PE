package cn.vito.coding.check.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.vito.coding.check.po.TeacherAndAcademy;
import cn.vito.coding.check.service.CheckService;
import cn.vito.coding.check.service.UserService;
import cn.vito.coding.check.vo.DataGrideRow;

/**
 * 审核信息的操作
 * 
 * @author 刘晓庆
 *
 */
@Controller
public class CheckController {
	@Autowired
	public CheckService checkService;
	@Autowired
	public UserService userService;

	/**
	 * 教师审核，查询审核教师的列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "getCheckList")
	public String findCheckList(ModelMap modelMap) {
		modelMap.addAttribute("TeacherList", checkService.findCheckList());
		return "checkTeacherListManger.ftl";
	}

	/**
	 * 教师审核，跳转页面
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "turnToCheck")
	public String turnToCheck(ModelMap modelMap, String teacher) {
		modelMap.addAttribute("checkTeacher", teacher);
		return "checkTeacherManger.ftl";
	}

	/**
	 * 教师审核，获取跳转页面的学生数据信息
	 * 
	 * @param teacher
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "fCheckByTeacher")
	public DataGrideRow<TeacherAndAcademy> getCheckByTeacher(@RequestParam(defaultValue = "1") String teacher, int page,
			int rows) {
		List<TeacherAndAcademy> checks = checkService.findCheckByTeacher(teacher, page, rows);
		return new DataGrideRow<>(checks.size(), checks);
	}

	/**
	 * 教师审核，通过审核
	 * 
	 * @param teacher
	 * @return
	 */
	@RequestMapping(value = "updateState")
	public String update(String teacher) {
		checkService.updateState(teacher);
		return "redirect:getCheckList.do";
	}

	/**
	 * 教师审核，被退回
	 * 
	 * @param teacher
	 * @return
	 */
	@RequestMapping(value = "updateStateNo")
	public String updateNo(String teacher) {
		checkService.updateStateNo(teacher);
		return "redirect:getCheckList.do";
	}

	/**
	 * 学院审核，根据不同学院查询不同信息
	 * 
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getCheckBySchool")
	public DataGrideRow<TeacherAndAcademy> getCheckBySchool(@RequestParam(defaultValue = "1") int page, int rows) {
		String userName = userService.getCurrentUserName();
		String school = userService.getUserByUserName(userName).getNickName();
		List<TeacherAndAcademy> checkSchool = checkService.findCheckBySchool(school, page, rows);
		return new DataGrideRow<>(checkSchool.size(), checkSchool);
	}

	/**
	 * 学院审核，通过审核
	 * 
	 * @param school
	 */
	@RequestMapping(value = "checkPass")
	public String checkPassBySchool(String school) {
		String sc = userService.getUserByUserName(userService.getCurrentUserName()).getNickName();
		checkService.checkPass(sc);
		return "checkAcademyManger.ftl";
	}

	/**
	 * 学院审核，被退回
	 * 
	 * @param school
	 */
	@RequestMapping(value = "checkNoPass")
	public String checkNoPassBySchool(String school) {
		String sh = userService.getUserByUserName(userService.getCurrentUserName()).getNickName();
		checkService.checkNoPass(sh);
		return "checkAcademyManger.ftl";
	}

	/**
	 * 管理员审核，查询审核教师的列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "getAdminCheckList")
	public String findAdminCheckList(ModelMap modelMap) {
		modelMap.addAttribute("adminTeacherList", checkService.findTeacherCheckList());
		modelMap.addAttribute("adminSchoolList", checkService.findSchoolCheckList());
		return "checkAdminListManger.ftl";
	}

	/**
	 * 管理员审核，跳转页面
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "turnToTeacherCheck")
	public String turnToTeacherCheck(ModelMap modelMap, String teacher) {
		modelMap.addAttribute("checkAdminTeacher", teacher);
		return "checkAdminTeacherManger.ftl";
	}

	/**
	 * 管理员审核，跳转页面
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "turnToSchoolCheck")
	public String turnToSchoolCheck(ModelMap modelMap, String school) {
		modelMap.addAttribute("checkAdminSchool", school);
		return "checkAdminSchoolManger.ftl";
	}

	/**
	 * 管理员获取跳转学院页面的学生数据信息
	 * 
	 * @param school
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "findAdminCheckBySchool")
	public DataGrideRow<TeacherAndAcademy> getAdminCheckBySchool(@RequestParam(defaultValue = "1") String school,
			int page, int rows) {
		List<TeacherAndAcademy> checks = checkService.findAdminCheckBySchool(school, page, rows);
		return new DataGrideRow<>(checks.size(), checks);
	}

	/**
	 * 管理员获取跳转教师页面的学生数据信息
	 * 
	 * @param school
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "findAdminCheckByTeacher")
	public DataGrideRow<TeacherAndAcademy> getAdminCheckByTeacher(@RequestParam(defaultValue = "1") String teacher,
			int page, int rows) {
		List<TeacherAndAcademy> checks = checkService.findAdminCheckByTeacher(teacher, page, rows);
		return new DataGrideRow<>(checks.size(), checks);
	}

	/**
	 * 管理员通过教师审核
	 * 
	 * @param teacher
	 * @return
	 */
	@RequestMapping(value = "updateAdminTeacherStateOk")
	public String updateTeacherOk(String teacher) {
		checkService.updateAdminTeacherStateOk(teacher);
		return "redirect:getAdminCheckList.do";
	}

	/**
	 * 管理员退回教师审核
	 * 
	 * @param teacher
	 * @return
	 */
	@RequestMapping(value = "updateAdminTeacherStateNo")
	public String updateTeacherNo(String teacher) {
		checkService.updateAdminTeacherStateNo(teacher);
		return "redirect:getAdminCheckList.do";
	}

	/**
	 * 管理员通过学院审核
	 * 
	 * @param school
	 * @return
	 */
	@RequestMapping(value = "updateAdminSchoolStateOk")
	public String updateSchoolOk(String school) {
		checkService.updateAdminSchoolStateOk(school);
		return "redirect:getAdminCheckList.do";
	}

	/**
	 * 管理员退回学院审核
	 * 
	 * @param school
	 * @return
	 */
	@RequestMapping(value = "updateAdminSchoolStateNo")
	public String updateSchoolNo(String school) {
		checkService.updateAdminSchoolStateNo(school);
		return "redirect:getAdminCheckList.do";
	}

}
