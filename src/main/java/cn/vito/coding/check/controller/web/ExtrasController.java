package cn.vito.coding.check.controller.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.lf5.util.StreamUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;

import com.lowagie.text.DocumentException;

import cn.vito.coding.check.po.Extras;
import cn.vito.coding.check.service.ExtrasService;
import cn.vito.coding.check.vo.BaseMsg;
import cn.vito.coding.check.vo.DataGrideRow;
import freemarker.template.TemplateException;

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
	@RequestMapping("findStudentExtras") //
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
	@RequestMapping("addOneExtra") //
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
	@RequestMapping("updateExtras") //
	public BaseMsg updateExtras(String id, Integer year, Double extra) {
		try {
			extrasService.updateExtras(id, year, extra);
		} catch (Exception e) {
			return new BaseMsg(false, "修改失败！");
		}
		return new BaseMsg(true, "修改成功！");
	}

	@ResponseBody
	@RequestMapping("deleteExtras") //
	public BaseMsg deleteExtras(String id, Integer year) {
		try {
			extrasService.deleteExtras(id, year);
		} catch (Exception e) {
			return new BaseMsg(false, "删除失败！");
		}
		return new BaseMsg(true, "删除成功！");
	}

	/**
	 * 学生附加分导入excel的样表
	 * 
	 * @param response
	 * @throws IOException
	 * @throws TemplateException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 * @throws DocumentException
	 */
	@RequestMapping("exampleExtrasExcel") //
	public void exampleExtrasExcel(HttpServletResponse response)
			throws IOException, TemplateException, SAXException, ParserConfigurationException, DocumentException {
		File file = new File("/home/page/excel/exampleExtras.xls");
		if (file.exists()) {
			response.setContentType("application/octet-stream; charset=utf-8");
			response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
			StreamUtils.copyThenClose(new FileInputStream(file), response.getOutputStream());
		} else {
			response.setStatus(404);
		}
	}

	/**
	 * 导入附加分excel
	 * 
	 * @param file
	 * @param year
	 * @return
	 */
	@ResponseBody
	@RequestMapping("excelExtrasInsertReader") //
	public BaseMsg excelExtrasInsertReader(MultipartFile file, int year) {
		String FileName = file.getOriginalFilename();
		String prefix = FileName.substring(FileName.lastIndexOf(".") + 1);
		if (!(prefix.equals("xls") | prefix.equals("xlsx"))) {
			return new BaseMsg(false, "上传的文件不是Excel类型，请检查后重新上传！");
		} else if (extrasService.excelExtrasInsertReader(file, year)) {
			return new BaseMsg(true, "上传成功！");
		} else {
			return new BaseMsg(false, "上传失败！");
		}
	}

	/**
	 * 附加分excel导出
	 * 
	 * @param response
	 * @param id
	 * @param name
	 * @param school
	 * @param year
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("outputExtrasExcel")
	public void outputExtrasExcel(HttpServletResponse response, String id, String name, String school, Integer year)
			throws FileNotFoundException, IOException {
		Extras extras = new Extras(id, year, null);
		extras.setName(name);
		extras.setSchool(school);
		extrasService.outputExtrasExcel(extras);
		File file = new File("/home/page/excel/pe7.xls");
		response.setContentType("application/octet-stream; charset=utf-8");
		response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
		StreamUtils.copyThenClose(new FileInputStream(file), response.getOutputStream());
	}
}
