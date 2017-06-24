package cn.vito.coding.check.controller.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.vito.coding.check.po.User;
import cn.vito.coding.check.service.UserService;
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

	/**
	 * 查询所有用户在表格中
	 * 
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getAllUser")
	public DataGrideRow<User> findAllUser(@RequestParam(defaultValue = "1") int page, int rows) {
		List<User> users = userService.getAllUser(page, rows);
		return new DataGrideRow<User>(userService.count(), users);
	}

	/**
	 * 修改学生密码
	 * 
	 * @param password
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "updateStuPassword")
	public BaseMsg updateStuPassword(String password) {
		if (!ValidaterUtil.checkPassWord(password)) {
			return new BaseMsg(false, "密码格式不正确！");
		}
		// 格式化时间
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		User user = new User(userService.getCurrentUserName(), ShiroUtils.passwdMD5(password),
				formatter.format(new Date()));
		userService.updateStudentP(user);
		return new BaseMsg(true, "修改密码成功！");
	}
}
