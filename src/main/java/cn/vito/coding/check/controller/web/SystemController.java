package cn.vito.coding.check.controller.web;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.vito.coding.check.service.MenuService;
import cn.vito.coding.check.service.UserService;

/**
 * 系统模块请求【登录，注销】
 * 
 * @author baijw
 * 
 * @date 2017年3月13日 下午7:18:33
 */
@Controller
public class SystemController {

	@Autowired
	private MenuService menuService;

	@Autowired
	private UserService userService;
	
	private static Logger logger = Logger.getLogger(SystemController.class);

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String loadloginPage() {
		return "login.ftl";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(ModelMap modelMap, String userName, String password) {
		System.out.println(userName+"*******************************");
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
		try {
			subject.login(token);
		} catch (AuthenticationException ae) {
			logger.info("登陆失败");
			modelMap.addAttribute("backinfo", "账号或密码错误");
			return "login.ftl";
		}
		logger.info("登录成功,正在跳转");
		return "redirect:home.do";
	}

	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String home(ModelMap modelMap) {
		System.out.println("当前用户::::::"+userService.getCurrentUserName());
		modelMap.addAttribute("menulist",
				menuService.getMenuByRoles(userService.getUserByUserName(userService.getCurrentUserName()).getRole()));
		return "home.ftl";
	}

	@RequestMapping("logout")
	public String logout() {
		SecurityUtils.getSubject().logout();
		return "login.ftl";
	}

}
