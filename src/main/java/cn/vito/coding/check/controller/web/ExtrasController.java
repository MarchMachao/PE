package cn.vito.coding.check.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.vito.coding.check.po.Extras;
import cn.vito.coding.check.service.ExtrasService;
import cn.vito.coding.check.vo.BaseMsg;
import cn.vito.coding.check.vo.DataGrideRow;

/**
 * 管理员附加分
 * 
 * @author March
 *
 */
@Controller
public class ExtrasController {

	@Autowired
	private ExtrasService extrasService;

	@ResponseBody
	@RequestMapping("findStudentExtras")
	public DataGrideRow<Extras> findStudentExtras(String id, String name, String school, Integer year, int page,
			int rows) {
		Extras extras = new Extras(id, year, null, page, rows);
		extras.setName(name);
		extras.setSchool(school);
		List<Extras> extrasList = extrasService.findStudentExtras(extras);
		int count = extrasService.countStudentExtras(extras);
		return new DataGrideRow<Extras>(count, extrasList);
	}

	@ResponseBody
	@RequestMapping("addOneExtra")
	public BaseMsg addOneExtra(String id, Integer year, Double extra) {
		try {
			extrasService.addOneExtra(id, year, extra);
		} catch (DuplicateKeyException e) {
			return new BaseMsg(false, "已存在该条数据！");
		} catch (Exception e) {
			return new BaseMsg(false, "增加失败！");
		}
		return new BaseMsg(true, "增加成功！");
	}
	
	@ResponseBody
	@RequestMapping("updateExtras")
	public BaseMsg updateExtras(String id, Integer year, Double extra) {
		try {
			extrasService.updateExtras(id, year, extra);
		} catch (Exception e) {
			return new BaseMsg(false, "修改失败！");
		}
		return new BaseMsg(true, "修改成功！");
	}

	@ResponseBody
	@RequestMapping("deleteExtras")
	public BaseMsg deleteExtras(String id, Integer year) {
		try {
			extrasService.deleteExtras(id, year);
		} catch (Exception e) {
			return new BaseMsg(false, "删除失败！");
		}
		return new BaseMsg(true, "删除成功！");
	}

}
