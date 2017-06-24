package cn.vito.coding.check.serviceImpl;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.vito.coding.check.mapper.UserDao;
import cn.vito.coding.check.po.User;
import cn.vito.coding.check.service.UserService;
import cn.vito.coding.check.vo.Page;

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
	public List<User> getAllUser(int pageNo, int pageSize) {
		return userDao.findAllUser(new Page(pageNo, pageSize));
	}

	@Override
	public int count() {
		return userDao.count();
	}

	@Override
	public void updateStudentP(User user) {
		userDao.updateStudentP(user);
	}

}
