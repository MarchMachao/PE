package cn.vito.coding.check.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.vito.coding.check.po.User;
import cn.vito.coding.check.po.UserLike;
import cn.vito.coding.check.service.UserService;
import cn.vito.coding.check.utils.ExcelUtils;
import cn.vito.coding.check.utils.ShiroUtils;
import cn.vito.coding.check.utils.ValidaterUtil;
import cn.vito.coding.check.vo.BaseMsg;
import cn.vito.coding.check.vo.DataGrideRow;

/**
 * 用户信息的操作
 * 
 * @author 刘晓庆
 *
 */
@Controller
public class UserController {
	@Autowired
	public UserService userService;
	
	@Autowired
	private ExcelUtils excelUtils;

	/**
	 * 管理员，查询所有教职工用户在表格中
	 * 
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getAllUser")
	public DataGrideRow<User> findAllUser(String nickName, String role, int page, int rows) {
		List<User> users = userService.getAllUser(nickName, role, page, rows);
		return new DataGrideRow<User>(userService.count(), users);
	}

	/**
	 * 管理员，添加新教职工用户
	 * 
	 * @param userName
	 * @param password
	 * @param nickName
	 * @param role
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "addUser")
	public BaseMsg addNewUser(String userName, String password, String nickName, String role) {
		try {
			userService.addUser(userName, password, nickName, role);
		} catch (Exception e) {
			return new BaseMsg(false, "用户存在!");
		}
		return new BaseMsg(true, "成功添加新用户!");
	}

	/**
	 * 管理员，删除教职工用户数据
	 * 
	 * @param userName
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "deleteUserByName")
	public BaseMsg deleteUser(String userName) {
		userService.deleteUserByName(userName);
		return new BaseMsg(true, "成功删除用户!");
	}

	/**
	 * 管理员，修改教职工用户信息
	 * 
	 * @param userName
	 * @param password
	 * @param nickName
	 * @param role
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "updateUserByName")
	public BaseMsg updateUser(String userName, String password, String nickName, String role) {
		if (!ValidaterUtil.checkPassWord(password)) {
			return new BaseMsg(false, "密码格式不正确,至少6位!");
		}
		try {
			userService.updateUser(userName, password, nickName, role);
		} catch (Exception e) {
			return new BaseMsg(false, "用户名已存在!");
		}
		return new BaseMsg(true, "修改密码成功！");
	}

	/**
	 * 管理员，查询所有学生数据
	 * 
	 * @param name
	 * @param school
	 * @param grade
	 * @param state
	 * @param teacher
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getAllStudentUser")
	public DataGrideRow<UserLike> getStudentUser(String name, String school, Integer grade, String state,
			String teacher, int page, int rows) {
		List<UserLike> list = userService.findStudentUser(name, school, grade, state, teacher, page, rows);
		return new DataGrideRow<>(list.size(), list);
	}

	/**
	 * 管理员，添加新学生数据
	 * 
	 * @param userName
	 * @param password
	 * @param gender
	 * @param name
	 * @param school
	 * @param grade
	 * @param classes
	 * @param duration
	 * @param state
	 * @param teacher
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "addNewStudent")
	public BaseMsg addStudent(String userName, String password, String gender, String name, String school,
			Integer grade, String classes, Integer duration, String state, String teacher) {
		try {
			userService.addStudentUser(userName, password, gender, name, school, grade, classes, duration, state,
					teacher);
		} catch (Exception e) {
			return new BaseMsg(false, "用户名已存在!");
		}
		return new BaseMsg(true, "添加学生成功！");
	}

	/**
	 * 管理员，删除学生数据
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "deleteStudentUser")
	public BaseMsg deleteStudent(String userName) {
		userService.deleteStudentUser(userName);
		return new BaseMsg(true, "删除学生成功！");
	}

	/**
	 * 管理员，更新学生数据
	 * 
	 * @param userName
	 * @param password
	 * @param name
	 * @param gender
	 * @param school
	 * @param grade
	 * @param classes
	 * @param duration
	 * @param state
	 * @param teacher
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "updateStudentUser")
	public BaseMsg updateStudent(String userName, String password, String name, String gender, String school,
			Integer grade, String classes, Integer duration, String state, String teacher) {
		userService.updateStudentUser(userName, password, name, gender, school, grade, classes, duration, state,
				teacher);
		return new BaseMsg(true, "更新数据成功！");
	}

	/**
	 * 管理员Excel导入成绩
	 * 
	 * @param file
	 * @return
	 */
	@ResponseBody
	@RequestMapping("uploadStudentExcel")
	public BaseMsg uploadTeachersAndAcademyExcel(MultipartFile file) {
		String FileName = file.getOriginalFilename();
		String prefix = FileName.substring(FileName.lastIndexOf(".") + 1);
		System.out.println("-------------!!!!!-------");
		if (!(prefix.equals("xls") | prefix.equals("xlsx"))) {
			return new BaseMsg(false, "上传的文件不是Excel类型，请检查后重新上传！");
		} else {
			if (excelUtils.excelStudentReader(file)) {
				return new BaseMsg(true, "上传成绩成功！");
			} else {
				return new BaseMsg(false, "上传成绩失败！");
			}
		}
	}

	/**
	 * 用户自己修改密码
	 * 
	 * @param password
	 *            原密码
	 * @param pwd
	 *            新密码
	 * @param pwd2
	 *            新密码确认
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "updateStuPassword")
	public BaseMsg updateStuPassword(String password, String pwd, String pwd2) {
		User userpo = userService.getUserByUserName(userService.getCurrentUserName());
		if (!userpo.getPassword().equals(ShiroUtils.passwdMD5(password))) {
			return new BaseMsg(false, "原密码错误！");
		} else if (!pwd.equals(pwd2)) {
			return new BaseMsg(false, "两次密码输入不一致！");
		} else if (!ValidaterUtil.checkPassWord(password)) {
			return new BaseMsg(false, "密码格式不正确！");
		}
		userService.updateUser(userService.getCurrentUserName(), ShiroUtils.passwdMD5(pwd), null, null);
		return new BaseMsg(true, "修改密码成功！");
	}
}
