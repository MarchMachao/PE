package cn.vito.coding.check.service;

import cn.vito.coding.check.po.User;

/**
 * 用户相关service
 * 
 * @author baijw12
 *
 */
public interface UserService {

	/**
	 * 获取当前登录的用户账号
	 * @return 用户账号
	 */
	public String getCurrentUserName();

	/**
	 * 根据用户账号获取用户信息
	 * @param userName 用户账号
	 * @return 用户信息
	 */
	public User getUserByUserName(String userName);
	
}
