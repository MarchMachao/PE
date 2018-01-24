package cn.vito.coding.check.controller.web;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.vito.coding.check.po.Notice;
import cn.vito.coding.check.service.NoticesService;
import cn.vito.coding.check.service.UserService;
import cn.vito.coding.check.utils.StringUtils;
import cn.vito.coding.check.vo.BaseMsg;

@Controller
public class NoticesController {

	@Autowired
	private NoticesService noticesService;

	@Autowired
	private UserService userService;

	@ResponseBody
	@RequestMapping("addOneNotice")
	public BaseMsg addOneNotice(String text, String roles) {
		Date date = new Date();
		noticesService.addOneNotice(new Notice(text, StringUtils.dateToString(date), true, roles));
		return new BaseMsg(true, "添加成功！");
	}
}
