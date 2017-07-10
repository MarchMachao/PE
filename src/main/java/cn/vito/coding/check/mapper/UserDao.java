package cn.vito.coding.check.mapper;

import java.util.List;

import cn.vito.coding.check.po.Student;
import cn.vito.coding.check.po.User;
import cn.vito.coding.check.po.UserLike;

/**
 * 用户操作
 * 
 * @author 刘晓庆
 *
 */
public interface UserDao {

	/**
	 * 根据用户登录账号获取用户信息
	 * 
	 * @param userName
	 *            用户名
	 * @return user对象
	 */
	public User findUserByUserName(String userName);

	/**
	 * 教职工用户，查询所有用户的信息
	 * 
	 * @return
	 */
	public List<User> findAllUser(UserLike userLike);

	/**
	 * 教职工用户，获取用户数量
	 * 
	 * @return
	 */
	public int count();

	/**
	 * 教职工用户，修改用户
	 * 
	 * @param user
	 */
	public void updateUser(User user);

	/**
	 * 教职工用户，添加新用户
	 * 
	 * @param user
	 */
	public void addUser(User user);

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
	public List<UserLike> findStudentUser(UserLike userLike);

	/**
	 * 学生用户，插入数据1
	 */
	public void addStudentUser1(User user);

	/**
	 * 学生用户，插入数据2
	 */
	public void addStudentUser2(Student student);

	/**
	 * 学生用户，删除数据
	 * 
	 * @param id
	 */
	public void deleteStudentUser(String userName);

	/**
	 * 学生用户，更新数据
	 * 
	 * @param userLike
	 */
	public void updateStudentUser(UserLike userLike);
}