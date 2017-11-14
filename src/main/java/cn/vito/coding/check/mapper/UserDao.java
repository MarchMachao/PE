package cn.vito.coding.check.mapper;

import java.util.List;

import cn.vito.coding.check.po.Data;
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
	 * 管理员，查询所有教职工用户的信息
	 * 
	 * @return
	 */
	public List<User> findAllUser(UserLike userLike);

	/**
	 * 管理员，获取教职工用户数量
	 * 
	 * @return
	 */
	public int count();

	/**
	 * 管理员，修改教职工用户
	 * 
	 * @param user
	 */
	public void updateUser(User user);

	/**
	 * 管理员，添加新教职工用户
	 * 
	 * @param user
	 */
	public void addUser(User user);

	/**
	 * 管理员，删除教职工用户
	 * 
	 * @param userName
	 */
	public void deleteUserByName(String userName);

	/**
	 * 管理员，查询所有学生用户的信息
	 * 
	 * @return
	 */
	public List<UserLike> findStudentUser(UserLike userLike);

	/**
	 * 查询学生用户数量
	 * 
	 * @param userlike
	 * @return
	 */
	public int countStudents(UserLike userLike);

	/**
	 * 管理员插入学生用户数据1
	 * 
	 * @param user
	 */
	public void addStudentUser1(User user);

	/**
	 * 管理员插入学生用户数据2
	 * 
	 * @param student
	 */
	public void addStudentUser2(Student student);

	/**
	 * 管理员插入学生用户数据3
	 * 
	 * @param data
	 */
	public void addStudentUser3(Data data);

	/**
	 * 管理员删除学生数据
	 * 
	 * @param id
	 */
	public void deleteStudentUser(String userName);

	/**
	 * 管理员更新学生数据
	 * 
	 * @param userLike
	 */
	public void updateStudentUser(UserLike userLike);

	/**
	 * 学生用户，导入Excel
	 */
	public void addExcelStudent1(List<User> user);

	public void addExcelStudent2(List<Student> student);

	public void addExcelStudent3(List<Data> datas);

}