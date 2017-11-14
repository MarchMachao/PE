package cn.vito.coding.check.service;

import java.util.List;

import cn.vito.coding.check.po.User;
import cn.vito.coding.check.po.UserLike;

/**
 * 用户相关service
 * 
 * @author 刘晓庆
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
	 * 根据用户账号获取用户信息
	 * 
	 * @param userName
	 *            用户账号
	 * @return 用户信息
	 */
	public User getUserByUserName(String userName);

	/**
	 * 管理员，获取教职工用户的信息
	 * 
	 * @param nickName
	 * @param role
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<User> getAllUser(String nickName, String role, int pageNo, int pageSize);

	/**
	 * 管理员，获取教职工用户数量
	 * 
	 * @return
	 */
	public int count();

	/**
	 * 修改密码
	 * 
	 * @param userName
	 * @param password
	 * @param nickName
	 * @param role
	 */
	public void updateUser(String userName, String password, String nickName, String role);

	/**
	 * 管理员，添加新教职工用户
	 * 
	 * @param userName
	 * @param password
	 * @param nickName
	 * @param role
	 */
	public void addUser(String userName, String password, String nickName, String role);

	/**
	 * 管理员，删除教职工用户
	 * 
	 * @param userName
	 */
	public void deleteUserByName(String userName);

	/**
	 * 管理员，查询所有学生用户的信息
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
	public List<UserLike> findStudentUser(String name, String school, Integer grade, String state, String teacher,
			int page, int rows);

	/**
	 * 查询学生用户数量
	 * 
	 * @param name
	 * @param school
	 * @param grade
	 * @param state
	 * @param teacher
	 * @return
	 */
	public int countStudents(String name, String school, Integer grade, String state, String teacher);

	/**
	 * 管理员，插入学生数据
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
	 */
	public void addStudentUser(String userName, String password, String name, String gender, String school,
			Integer grade, String classes, Integer duration, String state, String teacher);

	/**
	 * 管理员，删除学生数据
	 * 
	 * @param id
	 */
	public void deleteStudentUser(String userName);

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
	 */
	public void updateStudentUser(String userName, String password, String name, String gender, String school,
			Integer grade, String classes, Integer duration, String state);
}
