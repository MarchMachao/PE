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
	private UserService userService;

	@Autowired
	private PDFUtils pdfUtils;

	/**
	 * 教师下载大一、大二的名单
	 * 
	 * @param response
	 * @param id
	 * @param name
	 * @param school
	 * @param teacher
	 * @param year
	 * @throws IOException
	 * @throws TemplateException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 * @throws DocumentException
	 */
	@RequestMapping("downTeacherFreshmanPDF")
	public void downTeacherFreshmanPDF(HttpServletResponse response, String id, String name, String school,
			Integer year, String subjectname)
			throws IOException, TemplateException, SAXException, ParserConfigurationException, DocumentException {
		String teacher = userService.getUserByUserName(userService.getCurrentUserName()).getNickName();
		pdfUtils.toTeacherFreshmanPdf(id, name, school, teacher, year, subjectname);
		File file = new File("/home/page/pdf/Test.pdf");
		if (file.exists()) {
			response.setContentType("application/octet-stream; charset=utf-8");
			response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
			StreamUtils.copyThenClose(new FileInputStream(file), response.getOutputStream());
		} else {
			response.setStatus(404);
		}
	}

	/**
	 * 教师下载大三、大四的名单
	 * 
	 * @param response
	 * @param id
	 * @param name
	 * @param school
	 * @param teacher
	 * @param year
	 * @throws IOException
	 * @throws TemplateException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 * @throws DocumentException
	 */
	@RequestMapping("downTeacherPDF")
	public void downTeacherPDF(HttpServletResponse response, String id, String name, String school, String teacher,
			Integer year)
			throws IOException, TemplateException, SAXException, ParserConfigurationException, DocumentException {

		pdfUtils.toTeacherPdf(id, name, school, "学院", year);
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
	public void downAcademyPDF(HttpServletResponse response, String id, String name, String school, Integer year)
			throws IOException, TemplateException, SAXException, ParserConfigurationException, DocumentException {

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
