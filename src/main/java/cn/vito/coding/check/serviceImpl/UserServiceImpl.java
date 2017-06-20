package cn.vito.coding.check.serviceImpl;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.vito.coding.check.mapper.UserDao;
import cn.vito.coding.check.po.User;
import cn.vito.coding.check.service.UserService;

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

}
