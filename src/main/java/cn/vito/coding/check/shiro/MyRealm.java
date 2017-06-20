package cn.vito.coding.check.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAccount;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.vito.coding.check.po.User;
import cn.vito.coding.check.service.UserService;
import cn.vito.coding.check.utils.ShiroUtils;

@Component
public class MyRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;

	// 登陆
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String UserName = (String) token.getPrincipal();
		String password = new String((char[]) token.getCredentials());
		User user = userService.getUserByUserName(UserName);
		if (user == null) {
			throw new AuthenticationException();
		}
		if (user.getPassword().equals(ShiroUtils.passwdMD5(password))) {
			return new SimpleAccount(UserName, password, getName());
		}
		return null;
	}

	// 授权 通过用户获取Permissions和 Roles
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		User user = (User) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addRole(user.getRole());
		return info;
	}

}