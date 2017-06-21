package cn.vito.coding.check.controller.web;

import org.springframework.beans.factory.annotation.Autowired;

import cn.vito.coding.check.service.MenuService;
import cn.vito.coding.check.service.UserService;

/**
 * 
 * 
 * @author baijw
 * 
 * @date 2017年3月13日 下午8:40:33
 */
public class BaseController {

	@Autowired
	public UserService userService;

	@Autowired
	public MenuService menuService;

}
