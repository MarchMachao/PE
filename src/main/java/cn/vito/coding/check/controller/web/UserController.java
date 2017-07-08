package cn.vito.coding.check.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.vito.coding.check.po.User;
import cn.vito.coding.check.service.UserService;
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
	public DataGrideRow<User> findAllUser(String nickName, String role, int page, int rows) {
		List<User> users = userService.getAllUser(nickName, role, page, rows);
		for (User user : users) {
			System.out.println(user);
		}
		return new DataGrideRow<User>(userService.count(), users);
	}

	/**
	 * 添加新用户
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
	 * 删除用户数据
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
	 * 修改用户信息
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
}
