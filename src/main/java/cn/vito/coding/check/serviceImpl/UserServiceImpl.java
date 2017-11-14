package cn.vito.coding.check.serviceImpl;

import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.vito.coding.check.mapper.UserDao;
import cn.vito.coding.check.po.Data;
import cn.vito.coding.check.po.Student;
import cn.vito.coding.check.po.User;
import cn.vito.coding.check.po.UserLike;
import cn.vito.coding.check.service.UserService;
import cn.vito.coding.check.utils.ShiroUtils;
import cn.vito.coding.check.utils.StringUtils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public String getCurrentUserName() {
		return SecurityUtils.getSubject().getPrincipal().toString();
	}

	@Override
	public User getUserByUserName(String userName) {
		return userDao.findUserByUserName(userName);
	}

	@Override
	public List<User> getAllUser(String nickName, String role, int pageNo, int pageSize) {
		return userDao.findAllUser(new UserLike(nickName, role, pageNo, pageSize));
	}

	@Override
	public int count() {
		return userDao.count();
	}

	@Override
	public void addUser(String userName, String password, String nickName, String role) {
		userDao.addUser(new User(userName, ShiroUtils.passwdMD5(password), nickName, role));
	}

	@Override
	public void deleteUserByName(String userName) {
		userDao.deleteUserByName(userName);
	}

	@Override
	public void updateUser(String userName, String password, String nickName, String role) {
		userDao.updateUser(new User(userName, ShiroUtils.passwdMD5(password), nickName, role));
	}

	@Override
	public List<UserLike> findStudentUser(String name, String school, Integer grade, String state, String teacher,
			int page, int rows) {
		return userDao.findStudentUser(new UserLike(name, school, grade, state, teacher, page, rows));
	}

	@Override
	public int countStudents(String name, String school, Integer grade, String state, String teacher) {
		return userDao.countStudents(new UserLike(name, school, grade, state, teacher));
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void addStudentUser(String userName, String password, String name, String gender, String school,
			Integer grade, String classes, Integer duration, String state, String teacher) {
		String nickName = gender;
		String id = userName;
		String year = StringUtils.yearToString(new Date());
		userDao.addStudentUser1(new User(userName, ShiroUtils.passwdMD5(password), nickName, "学生"));
		userDao.addStudentUser2(new Student(id, gender, name, school, grade, classes, duration, state, teacher));
		userDao.addStudentUser3(new Data(id, Integer.parseInt(year)));
	}

	@Override
	public void deleteStudentUser(String userName) {
		userDao.deleteStudentUser(userName);
	}

	@Override
	public void updateStudentUser(String userName, String password, String name, String gender, String school,
			Integer grade, String classes, Integer duration, String state) {
		String nickName = gender;
		String id = userName;
		userDao.updateStudentUser(new UserLike(userName, ShiroUtils.passwdMD5(password), nickName, id, name, gender,
				school, grade, classes, duration, state));
	}

}
