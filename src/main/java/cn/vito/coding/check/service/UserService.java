package cn.vito.coding.check.service;

import java.util.List;

import cn.vito.coding.check.po.User;
import cn.vito.coding.check.po.UserLike;

/**
 * 用户相关service
 * 
 * @author baijw12
 *
 */
public interface UserService {

	/**
	 * 获取当前登录的用户账号
	 * 
	 * @return 用户账号
	 */
	public String getCurrentUserName();

	/**
	 * 教职工用户，根据用户账号获取用户信息
	 * 
	 * @param userName
	 *            用户账号
	 * @return 用户信息
	 */
	public User getUserByUserName(String userName);

	/**
	 * 教职工用户，获取用户的信息
	 * 
	 * @return
	 */
	public List<User> getAllUser(String nickName, String role, int pageNo, int pageSize);

	/**
	 * 教职工用户，获取用户数量
	 * 
	 * @return
	 */
	public int count();

	/**
	 * 教职工用户，修改学生密码
	 * 
	 * @param user
	 */
	public void updateUser(String userName, String password, String nickName, String role);

	/**
	 * 教职工用户，添加新用户
	 * 
	 * @param user
	 */
	public void addUser(String userName, String password, String nickName, String role);

	/**
	 * 教职工用户，删除用户
	 * 
	 * @param userName
	 */
	public void deleteUserByName(String userName);

	/**
	 * 学生用户，查询所有用户的信息
	 * 
	 * @return
	 */
	public List<UserLike> findStudentUser(String name, String school, Integer grade, String state, String teacher,
			int page, int rows);

	/**
	 * 学生用户，插入数据
	 */
	public void addStudentUser(String userName, String password, String name, String gender, String school,
			Integer grade, String classes, Integer duration, String state, String teacher);

	/**
	 * 学生用户，删除数据s
	 * 
	 * @param id
	 */
	public void deleteStudentUser(String userName);

	/**
	 * 学生用户，更新数据
	 * 
	 * @param userLike
	 */
	public void updateStudentUser(String userName, String password, String name, String gender, String school,
			Integer grade, String classes, Integer duration, String state, String teacher);
}
