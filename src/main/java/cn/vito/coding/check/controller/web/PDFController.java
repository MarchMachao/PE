package cn.vito.coding.check.controller.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.lf5.util.StreamUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xml.sax.SAXException;

import com.lowagie.text.DocumentException;

import cn.vito.coding.check.service.UserService;
import cn.vito.coding.check.utils.PDFUtils;
import freemarker.template.TemplateException;

/**
 * PDF文件下载
 * 
 * @author March
 *
 */
@Controller
public class PDFController {

	@Autowired
	private PDFUtils pdfUtils;

	@Autowired
	private UserService userService;
	
	@RequestMapping("downTeacherPDF")
	public void downTeacherPDF(HttpServletResponse response, String id, String name, String school, String teacher,
			Integer year)
			throws IOException, TemplateException, SAXException, ParserConfigurationException, DocumentException {
		
		pdfUtils.toTeacherPdf(id, name, school, teacher, year);
		File file = new File("/home/page/pdf/Test.pdf");
		if (file.exists()) {
			response.setContentType("application/octet-stream; charset=utf-8");
			response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
			StreamUtils.copyThenClose(new FileInputStream(file), response.getOutputStream());
		} else {
			response.setStatus(404);
		}
	}

	@RequestMapping("downAcademyPDF")
	public void downAcademyPDF(HttpServletResponse response, String id, String name, Integer year)
			throws IOException, TemplateException, SAXException, ParserConfigurationException, DocumentException {
		String userName = userService.getCurrentUserName();
		String school = userService.getUserByUserName(userName).getNickName();
		pdfUtils.toAcademyPdf(id, name, school, year);
		File file = new File("/home/page/pdf/Test.pdf");
		if (file.exists()) {
			response.setContentType("application/octet-stream; charset=utf-8");
			response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
			StreamUtils.copyThenClose(new FileInputStream(file), response.getOutputStream());
		} else {
			response.setStatus(404);
		}
	}

}
