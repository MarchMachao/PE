package cn.vito.coding.check.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.xml.sax.SAXException;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.BaseFont;

import cn.vito.coding.check.mapper.TeacherAndAcademyDao;
import cn.vito.coding.check.po.TeacherAndAcademy;
import cn.vito.coding.check.po.TeacherAndAcademyLike;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * PDF输出的Util
 * 
 * @author March
 *
 */
@Service
public class PDFUtils {

	@Autowired
	private TeacherAndAcademyDao teacherAndAcademyDao;

	/**
	 * 老师端导出PDF
	 * 
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
	public void toTeacherPdf(String id, String name, String school, String teacher,
			Integer year)
			throws IOException, TemplateException, SAXException, ParserConfigurationException, DocumentException {
		Configuration cfg = new Configuration();
		cfg.setDefaultEncoding("UTF-8");
		cfg.setDirectoryForTemplateLoading(new File("/home/page"));
		Template temp = cfg.getTemplate("index.ftl");
		List<TeacherAndAcademy> teacherAndAcademys = teacherAndAcademyDao
				.findTeacherExcel(new TeacherAndAcademyLike(id, name, school, teacher, year));
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("list", teacherAndAcademys);

		// 合并模板和数据模型
		String file1 = "/home/page/pdf/contractTemplate.html";
		File file = new File(file1);

		if (!file.exists())
			file.createNewFile();

		Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8"));
		temp.process(root, out);
		out.flush();
		String url = new File(file1).toURI().toURL().toString();
        String outputFile = "/home/page/pdf/Test.pdf";  
		OutputStream os = new FileOutputStream(outputFile);
		
		ITextRenderer renderer = new ITextRenderer();
		renderer.setDocument(url);

		// 解决中文支持问题
		ITextFontResolver fontResolver = renderer.getFontResolver();
		fontResolver.addFont("/home/page/SIMHEI.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);

		renderer.layout();
		renderer.createPDF(os);

		os.close();
	}

	/**
	 * 学院端导出PDF
	 * 
	 * @param id
	 * @param name
	 * @param school
	 * @param year
	 * @throws IOException
	 * @throws TemplateException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 * @throws DocumentException
	 */
	public void toAcademyPdf(String id, String name, String school, Integer year)
			throws IOException, TemplateException, SAXException, ParserConfigurationException, DocumentException {
		Configuration cfg = new Configuration();
		cfg.setDefaultEncoding("UTF-8");
		cfg.setDirectoryForTemplateLoading(new File("/home/page"));
		Template temp = cfg.getTemplate("index.ftl");
		List<TeacherAndAcademy> teacherAndAcademys = teacherAndAcademyDao
				.findAcademyExcel(new TeacherAndAcademyLike(id, name, school, year));
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("list", teacherAndAcademys);

		// 合并模板和数据模型
		String file1 = "/home/page/pdf/contractTemplate.html";
		File file = new File(file1);

		if (!file.exists())
			file.createNewFile();

		Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8"));
		temp.process(root, out);
		out.flush();
		String url = new File(file1).toURI().toURL().toString();
		String outputFile = "/home/page/pdf/Test.pdf";
		OutputStream os = new FileOutputStream(outputFile);

		ITextRenderer renderer = new ITextRenderer();
		renderer.setDocument(url);

		// 解决中文支持问题
		ITextFontResolver fontResolver = renderer.getFontResolver();
		fontResolver.addFont("/home/page/SIMHEI.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);

		renderer.layout();
		renderer.createPDF(os);

		os.close();
	}

}
