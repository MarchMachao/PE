package cn.vito.coding.check.controller.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.vito.coding.check.po.Notice;
import cn.vito.coding.check.service.NoticesService;
import cn.vito.coding.check.service.UserService;
import cn.vito.coding.check.utils.StringUtils;
import cn.vito.coding.check.vo.BaseMsg;
import cn.vito.coding.check.vo.DataGrideRow;

/**
 * 通知的controller
 * 
 * @author March
 *
 */
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

	@ResponseBody
	@RequestMapping("deleteNotice")
	public BaseMsg deleteNotice(Integer id) {
		noticesService.deleteNotice(id);
		return new BaseMsg(true, "删除成功！");
	}
	
	@ResponseBody
	@RequestMapping("updateNotice")
	public BaseMsg updateNotice(String text, Boolean valid, String roles) {
		Date date = new Date();
		noticesService.updateNotice(new Notice(text, StringUtils.dateToString(date), valid, roles));
		return new BaseMsg(true, "更新成功！");
	}

	@ResponseBody
	@RequestMapping("getAllNotices")
	public DataGrideRow<Notice> getAllNotices(@RequestParam(defaultValue = "1") int page, int rows) {
		Notice notice = new Notice(null, null, null, null, page, rows);
		List<Notice> notices = noticesService.getAllNotices(notice);
		int count = noticesService.getAllNoticesCount(notice);
		return new DataGrideRow<Notice>(count, notices);
	}

	@ResponseBody
	@RequestMapping("getLatestNotice")
	public Notice getLatestNotice() {
		String userName = userService.getCurrentUserName();
		String roles = userService.getUserByUserName(userName).getRole();
		return noticesService.getLatestNotice(roles);
	}
}
