package cn.vito.coding.check.mapper;

import java.util.List;

import cn.vito.coding.check.po.User;
import cn.vito.coding.check.vo.Page;

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
	 * 查询所有用户的信息
	 * 
	 * @return
	 */
	public List<User> findAllUser(Page page);

	/**
	 * 获取用户数量
	 * 
	 * @return
	 */
	public int count();

	/**
	 * 修改学生密码
	 * 
	 * @param user
	 */
	public void updateStudentP(User user);
}