package cn.vito.coding.check.serviceImpl;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.vito.coding.check.mapper.UserDao;
import cn.vito.coding.check.po.User;
import cn.vito.coding.check.po.UserLike;
import cn.vito.coding.check.service.UserService;
import cn.vito.coding.check.utils.ShiroUtils;

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
		userDao.addUser(new User(userName, ShiroUtils.passwdMD5(password), nickName, role));
	}

}
