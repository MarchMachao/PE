package cn.vito.coding.check.mapper;

import cn.vito.coding.check.po.User;

/**
 * 用户相关操作
 * 
 * @author baijw
 * 
 * @date 2017年3月13日 下午8:41:39
 */
public interface UserDao {
	
	/**
	 * 根据用户登录账号获取用户信息
	 * @param userName 用户名
	 * @return user对象
	 */
	public User findUserByUserName(String userName);
	
}