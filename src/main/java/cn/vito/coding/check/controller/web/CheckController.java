package cn.vito.coding.check.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.vito.coding.check.po.TeacherAndAcademy;
import cn.vito.coding.check.service.CheckService;
import cn.vito.coding.check.vo.DataGrideRow;

/**
 * 审核信息的操作
 * 
 * @author 刘晓庆
 *
 */
@Controller
public class CheckController {
	@Autowired
	public CheckService checkService;

	/**
	 * 教师审核界面的数据查询
	 * 
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "findCheckData")
	public DataGrideRow<TeacherAndAcademy> findCheckData(@RequestParam(defaultValue = "1") int page, int rows) {
		List<TeacherAndAcademy> checks = checkService.findCheckData(page, rows);
		return new DataGrideRow<TeacherAndAcademy>(checks.size(), checks);
	}

}
