package cn.vito.coding.check.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import cn.vito.coding.check.mapper.AdminDao;
import cn.vito.coding.check.mapper.TeacherAndAcademyDao;
import cn.vito.coding.check.mapper.UserDao;
import cn.vito.coding.check.po.Data;
import cn.vito.coding.check.po.Student;
import cn.vito.coding.check.po.TeacherAndAcademy;
import cn.vito.coding.check.po.TeacherAndAcademyLike;
import cn.vito.coding.check.po.TeacherToStudent;
import cn.vito.coding.check.po.User;
import cn.vito.coding.check.scoreTable.ComputeScore;

/**
 * Excel导入导出
 * 
 * @author March
 *
 */
@Service
public class ExcelUtils {

	@Autowired
	private TeacherAndAcademyDao teacherAndAcademyDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private AdminDao adminDao;

	/**
	 * 教师导出大一，大二成绩
	 * 
	 * @param id
	 * @param name
	 * @param subjectname
	 * @param school
	 * @param teacher
	 * @param year
	 */
	public void outputTeacherFreshmanExcel(String id, String name, String school, String teacher, Integer year,
			String subjectname) {
		// 第一步，创建一个webbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet("sheet1");
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		HSSFRow row = sheet.createRow(0);
		// 第四步，创建单元格，并设置值表头 设置表头居中
		// HSSFCellStyle style = wb.createCellStyle();
		// style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

		HSSFCell cell = row.createCell(0);
		cell.setCellValue("学号");
		// cell.setCellStyle(style);
		cell = row.createCell(1);
		cell.setCellValue("姓名");
		cell = row.createCell(2);
		cell.setCellValue("性别");
		// cell.setCellStyle(style);
		cell = row.createCell(3);
		cell.setCellValue("院系");
		cell = row.createCell(4);
		cell.setCellValue("年级");
		cell = row.createCell(5);
		cell.setCellValue("班级");
		// cell.setCellStyle(style);
		cell = row.createCell(6);
		cell.setCellValue("年份");
		cell = row.createCell(7);
		cell.setCellValue("身高");
		cell = row.createCell(8);
		cell.setCellValue("体重");
		cell = row.createCell(9);
		cell.setCellValue("肺活量");
		cell = row.createCell(10);
		cell.setCellValue("50m跑");
		cell = row.createCell(11);
		cell.setCellValue("立定跳远");
		cell = row.createCell(12);
		cell.setCellValue("坐位前屈");
		cell = row.createCell(13);
		cell.setCellValue("800米跑");
		cell = row.createCell(14);
		cell.setCellValue("1000m跑");
		cell = row.createCell(15);
		cell.setCellValue("一分钟仰卧起坐");
		cell = row.createCell(16);
		cell.setCellValue("引体向上");
		cell = row.createCell(17);
		cell.setCellValue("分数");
		cell = row.createCell(18);
		cell.setCellValue("备注");

		// // 第五步，写入实体数据 实际应用中这些数据从数据库得到，
		List<TeacherAndAcademy> teacherAndAcademys = teacherAndAcademyDao
				.findTeacherFreshmanExcel(new TeacherAndAcademyLike(id, name, school, teacher, year, subjectname));

		for (int i = 0; i < teacherAndAcademys.size(); i++) {
			row = sheet.createRow((int) i + 1);
			TeacherAndAcademy teacherAndAcademyss = teacherAndAcademys.get(i);
			// 第四步，创建单元格，并设置值
			row.createCell(0).setCellValue(teacherAndAcademyss.getId());
			row.createCell(1).setCellValue(teacherAndAcademyss.getName());
			row.createCell(2).setCellValue(teacherAndAcademyss.getGender());
			row.createCell(3).setCellValue(teacherAndAcademyss.getSchool());
			row.createCell(4).setCellValue(teacherAndAcademyss.getGrade());
			row.createCell(5).setCellValue(teacherAndAcademyss.getClasses());
			row.createCell(6).setCellValue(
					teacherAndAcademyss.getYear() == null ? "" : teacherAndAcademyss.getYear().toString());
			row.createCell(7).setCellValue(
					teacherAndAcademyss.getHeight() == null ? "" : teacherAndAcademyss.getHeight().toString());
			row.createCell(8).setCellValue(
					teacherAndAcademyss.getWeight() == null ? "" : teacherAndAcademyss.getWeight().toString());
			row.createCell(9).setCellValue(teacherAndAcademyss.getVital_capacity() == null ? ""
					: teacherAndAcademyss.getVital_capacity().toString());
			row.createCell(10).setCellValue(
					teacherAndAcademyss.getFivem() == null ? "" : teacherAndAcademyss.getFivem().toString());
			row.createCell(11).setCellValue(
					teacherAndAcademyss.getLong_jump() == null ? "" : teacherAndAcademyss.getLong_jump().toString());
			row.createCell(12).setCellValue(
					teacherAndAcademyss.getReach() == null ? "" : teacherAndAcademyss.getReach().toString());
			row.createCell(13).setCellValue(teacherAndAcademyss.getEightm().toString());
			row.createCell(14).setCellValue(teacherAndAcademyss.getTenm().toString());
			row.createCell(15).setCellValue(
					teacherAndAcademyss.getSit_ups() == null ? "" : teacherAndAcademyss.getSit_ups().toString());
			row.createCell(16).setCellValue(
					teacherAndAcademyss.getPull_up() == null ? "" : teacherAndAcademyss.getPull_up().toString());
			row.createCell(17).setCellValue(
					teacherAndAcademyss.getScore() == null ? "" : teacherAndAcademyss.getScore().toString());
			row.createCell(18)
					.setCellValue(teacherAndAcademyss.getState().equals("正常") ? "" : teacherAndAcademyss.getState());

			// row.createCell((short) 2).setCellValue((double) stu.getAge());
			// cell = row.createCell((short) 3);
			// cell.setCellValue(new
			// SimpleDateFormat("yyyy-mm-dd").format(stu.getBirth()));
		}
		// 第六步，将文件存到指定位置
		try {
			FileOutputStream fout = new FileOutputStream("/home/page/excel/pe1.xls");
			wb.write(fout);
			fout.close();
			wb.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 教师导出大三，大四成绩
	 * 
	 * @param id
	 * @param name
	 * @param school
	 * @param teacher
	 * @param year
	 */
	public void outputTeacherExcel(String id, String name, String school, String teacher, Integer year) {
		// 第一步，创建一个webbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet("sheet1");
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		HSSFRow row = sheet.createRow(0);
		// 第四步，创建单元格，并设置值表头 设置表头居中
		// HSSFCellStyle style = wb.createCellStyle();
		// style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

		HSSFCell cell = row.createCell(0);
		cell.setCellValue("学号");
		// cell.setCellStyle(style);
		cell = row.createCell(1);
		cell.setCellValue("姓名");
		cell = row.createCell(2);
		cell.setCellValue("性别");
		// cell.setCellStyle(style);
		cell = row.createCell(3);
		cell.setCellValue("院系");
		cell = row.createCell(4);
		cell.setCellValue("年级");
		cell = row.createCell(5);
		cell.setCellValue("班级");
		// cell.setCellStyle(style);
		cell = row.createCell(6);
		cell.setCellValue("年份");
		cell = row.createCell(7);
		cell.setCellValue("身高");
		cell = row.createCell(8);
		cell.setCellValue("体重");
		cell = row.createCell(9);
		cell.setCellValue("肺活量");
		cell = row.createCell(10);
		cell.setCellValue("50m跑");
		cell = row.createCell(11);
		cell.setCellValue("立定跳远");
		cell = row.createCell(12);
		cell.setCellValue("坐位前屈");
		cell = row.createCell(13);
		cell.setCellValue("800米跑");
		cell = row.createCell(14);
		cell.setCellValue("1000m跑");
		cell = row.createCell(15);
		cell.setCellValue("一分钟仰卧起坐");
		cell = row.createCell(16);
		cell.setCellValue("引体向上");
		cell = row.createCell(17);
		cell.setCellValue("分数");
		cell = row.createCell(18);
		cell.setCellValue("备注");

		// // 第五步，写入实体数据 实际应用中这些数据从数据库得到，
		List<TeacherAndAcademy> teacherAndAcademys = teacherAndAcademyDao
				.findTeacherExcel(new TeacherAndAcademyLike(id, name, school, teacher, year));

		for (int i = 0; i < teacherAndAcademys.size(); i++) {
			row = sheet.createRow((int) i + 1);
			TeacherAndAcademy teacherAndAcademyss = teacherAndAcademys.get(i);
			// 第四步，创建单元格，并设置值
			row.createCell(0).setCellValue(teacherAndAcademyss.getId());
			row.createCell(1).setCellValue(teacherAndAcademyss.getName());
			row.createCell(2).setCellValue(teacherAndAcademyss.getGender());
			row.createCell(3).setCellValue(teacherAndAcademyss.getSchool());
			row.createCell(4).setCellValue(teacherAndAcademyss.getGrade());
			row.createCell(5).setCellValue(teacherAndAcademyss.getClasses());
			row.createCell(6).setCellValue(
					teacherAndAcademyss.getYear() == null ? "" : teacherAndAcademyss.getYear().toString());
			row.createCell(7).setCellValue(
					teacherAndAcademyss.getHeight() == null ? "" : teacherAndAcademyss.getHeight().toString());
			row.createCell(8).setCellValue(
					teacherAndAcademyss.getWeight() == null ? "" : teacherAndAcademyss.getWeight().toString());
			row.createCell(9).setCellValue(teacherAndAcademyss.getVital_capacity() == null ? ""
					: teacherAndAcademyss.getVital_capacity().toString());
			row.createCell(10).setCellValue(
					teacherAndAcademyss.getFivem() == null ? "" : teacherAndAcademyss.getFivem().toString());
			row.createCell(11).setCellValue(
					teacherAndAcademyss.getLong_jump() == null ? "" : teacherAndAcademyss.getLong_jump().toString());
			row.createCell(12).setCellValue(
					teacherAndAcademyss.getReach() == null ? "" : teacherAndAcademyss.getReach().toString());
			row.createCell(13).setCellValue(teacherAndAcademyss.getEightm());
			row.createCell(14).setCellValue(teacherAndAcademyss.getTenm());
			row.createCell(15).setCellValue(
					teacherAndAcademyss.getSit_ups() == null ? "" : teacherAndAcademyss.getSit_ups().toString());
			row.createCell(16).setCellValue(
					teacherAndAcademyss.getPull_up() == null ? "" : teacherAndAcademyss.getPull_up().toString());
			row.createCell(17).setCellValue(
					teacherAndAcademyss.getScore() == null ? "" : teacherAndAcademyss.getScore().toString());
			row.createCell(18)
					.setCellValue(teacherAndAcademyss.getState().equals("正常") ? "" : teacherAndAcademyss.getState());

			// row.createCell((short) 2).setCellValue((double) stu.getAge());
			// cell = row.createCell((short) 3);
			// cell.setCellValue(new
			// SimpleDateFormat("yyyy-mm-dd").format(stu.getBirth()));
		}
		// 第六步，将文件存到指定位置
		try {
			FileOutputStream fout = new FileOutputStream("/home/page/excel/pe2.xls");
			wb.write(fout);
			fout.close();
			wb.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// =========================================学院数据======================================

	/**
	 * 学院导出大一、大二成绩
	 * 
	 * @param id
	 * @param name
	 * @param school
	 * @param year
	 */
	public void outputAcademyFreshmanExcel(String id, String name, String school, Integer year) {
		// 第一步，创建一个webbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet("sheet1");
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		HSSFRow row = sheet.createRow(0);
		// 第四步，创建单元格，并设置值表头 设置表头居中
		// HSSFCellStyle style = wb.createCellStyle();
		// style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

		HSSFCell cell = row.createCell(0);
		cell.setCellValue("学号");
		// cell.setCellStyle(style);
		cell = row.createCell(1);
		cell.setCellValue("姓名");
		cell = row.createCell(2);
		cell.setCellValue("性别");
		// cell.setCellStyle(style);
		cell = row.createCell(3);
		cell.setCellValue("院系");
		cell = row.createCell(4);
		cell.setCellValue("年级");
		cell = row.createCell(5);
		cell.setCellValue("班级");
		// cell.setCellStyle(style);
		cell = row.createCell(6);
		cell.setCellValue("年份");
		cell = row.createCell(7);
		cell.setCellValue("身高");
		cell = row.createCell(8);
		cell.setCellValue("体重");
		cell = row.createCell(9);
		cell.setCellValue("肺活量");
		cell = row.createCell(10);
		cell.setCellValue("50m跑");
		cell = row.createCell(11);
		cell.setCellValue("立定跳远");
		cell = row.createCell(12);
		cell.setCellValue("坐位前屈");
		cell = row.createCell(13);
		cell.setCellValue("800米跑");
		cell = row.createCell(14);
		cell.setCellValue("1000m跑");
		cell = row.createCell(15);
		cell.setCellValue("一分钟仰卧起坐");
		cell = row.createCell(16);
		cell.setCellValue("引体向上");
		cell = row.createCell(17);
		cell.setCellValue("分数");
		cell = row.createCell(18);
		cell.setCellValue("备注");

		// // 第五步，写入实体数据 实际应用中这些数据从数据库得到，
		List<TeacherAndAcademy> teacherAndAcademys = teacherAndAcademyDao
				.findAcademyFreshmanExcel(new TeacherAndAcademyLike(id, name, school, year));

		for (int i = 0; i < teacherAndAcademys.size(); i++) {
			row = sheet.createRow((int) i + 1);
			TeacherAndAcademy teacherAndAcademyss = teacherAndAcademys.get(i);
			// 第四步，创建单元格，并设置值
			row.createCell(0).setCellValue(teacherAndAcademyss.getId());
			row.createCell(1).setCellValue(teacherAndAcademyss.getName());
			row.createCell(2).setCellValue(teacherAndAcademyss.getGender());
			row.createCell(3).setCellValue(teacherAndAcademyss.getSchool());
			row.createCell(4).setCellValue(teacherAndAcademyss.getGrade());
			row.createCell(5).setCellValue(teacherAndAcademyss.getClasses());
			row.createCell(6).setCellValue(
					teacherAndAcademyss.getYear() == null ? "" : teacherAndAcademyss.getYear().toString());
			row.createCell(7).setCellValue(
					teacherAndAcademyss.getHeight() == null ? "" : teacherAndAcademyss.getHeight().toString());
			row.createCell(8).setCellValue(
					teacherAndAcademyss.getWeight() == null ? "" : teacherAndAcademyss.getWeight().toString());
			row.createCell(9).setCellValue(teacherAndAcademyss.getVital_capacity() == null ? ""
					: teacherAndAcademyss.getVital_capacity().toString());
			row.createCell(10).setCellValue(
					teacherAndAcademyss.getFivem() == null ? "" : teacherAndAcademyss.getFivem().toString());
			row.createCell(11).setCellValue(
					teacherAndAcademyss.getLong_jump() == null ? "" : teacherAndAcademyss.getLong_jump().toString());
			row.createCell(12).setCellValue(
					teacherAndAcademyss.getReach() == null ? "" : teacherAndAcademyss.getReach().toString());
			row.createCell(13).setCellValue(teacherAndAcademyss.getEightm());
			row.createCell(14).setCellValue(teacherAndAcademyss.getTenm());
			row.createCell(15).setCellValue(
					teacherAndAcademyss.getSit_ups() == null ? "" : teacherAndAcademyss.getSit_ups().toString());
			row.createCell(16).setCellValue(
					teacherAndAcademyss.getPull_up() == null ? "" : teacherAndAcademyss.getPull_up().toString());
			row.createCell(17).setCellValue(
					teacherAndAcademyss.getScore() == null ? "" : teacherAndAcademyss.getScore().toString());
			row.createCell(18)
					.setCellValue(teacherAndAcademyss.getState().equals("正常") ? "" : teacherAndAcademyss.getState());

			// row.createCell((short) 2).setCellValue((double) stu.getAge());
			// cell = row.createCell((short) 3);
			// cell.setCellValue(new
			// SimpleDateFormat("yyyy-mm-dd").format(stu.getBirth()));
		}
		// 第六步，将文件存到指定位置
		try {
			FileOutputStream fout = new FileOutputStream("/home/page/excel/pe3.xls");
			wb.write(fout);
			fout.close();
			wb.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 学院导出大三、大四成绩
	 * 
	 * @param id
	 * @param name
	 * @param school
	 * @param year
	 */
	public void outputAcademyExcel(String id, String name, String school, Integer year) {
		// 第一步，创建一个webbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet("sheet1");
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		HSSFRow row = sheet.createRow(0);
		// 第四步，创建单元格，并设置值表头 设置表头居中
		// HSSFCellStyle style = wb.createCellStyle();
		// style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

		HSSFCell cell = row.createCell(0);
		cell.setCellValue("学号");
		// cell.setCellStyle(style);
		cell = row.createCell(1);
		cell.setCellValue("姓名");
		cell = row.createCell(2);
		cell.setCellValue("性别");
		// cell.setCellStyle(style);
		cell = row.createCell(3);
		cell.setCellValue("院系");
		cell = row.createCell(4);
		cell.setCellValue("年级");
		cell = row.createCell(5);
		cell.setCellValue("班级");
		// cell.setCellStyle(style);
		cell = row.createCell(6);
		cell.setCellValue("年份");
		cell = row.createCell(7);
		cell.setCellValue("身高");
		cell = row.createCell(8);
		cell.setCellValue("体重");
		cell = row.createCell(9);
		cell.setCellValue("肺活量");
		cell = row.createCell(10);
		cell.setCellValue("50m跑");
		cell = row.createCell(11);
		cell.setCellValue("立定跳远");
		cell = row.createCell(12);
		cell.setCellValue("坐位前屈");
		cell = row.createCell(13);
		cell.setCellValue("800米跑");
		cell = row.createCell(14);
		cell.setCellValue("1000m跑");
		cell = row.createCell(15);
		cell.setCellValue("一分钟仰卧起坐");
		cell = row.createCell(16);
		cell.setCellValue("引体向上");
		cell = row.createCell(17);
		cell.setCellValue("分数");
		cell = row.createCell(18);
		cell.setCellValue("备注");

		// // 第五步，写入实体数据 实际应用中这些数据从数据库得到，
		List<TeacherAndAcademy> teacherAndAcademys = teacherAndAcademyDao
				.findAcademyExcel(new TeacherAndAcademyLike(id, name, school, year));

		for (int i = 0; i < teacherAndAcademys.size(); i++) {
			row = sheet.createRow((int) i + 1);
			TeacherAndAcademy teacherAndAcademyss = teacherAndAcademys.get(i);
			// 第四步，创建单元格，并设置值
			row.createCell(0).setCellValue(teacherAndAcademyss.getId());
			row.createCell(1).setCellValue(teacherAndAcademyss.getName());
			row.createCell(2).setCellValue(teacherAndAcademyss.getGender());
			row.createCell(3).setCellValue(teacherAndAcademyss.getSchool());
			row.createCell(4).setCellValue(teacherAndAcademyss.getGrade());
			row.createCell(5).setCellValue(teacherAndAcademyss.getClasses());
			row.createCell(6).setCellValue(
					teacherAndAcademyss.getYear() == null ? "" : teacherAndAcademyss.getYear().toString());
			row.createCell(7).setCellValue(
					teacherAndAcademyss.getHeight() == null ? "" : teacherAndAcademyss.getHeight().toString());
			row.createCell(8).setCellValue(
					teacherAndAcademyss.getWeight() == null ? "" : teacherAndAcademyss.getWeight().toString());
			row.createCell(9).setCellValue(teacherAndAcademyss.getVital_capacity() == null ? ""
					: teacherAndAcademyss.getVital_capacity().toString());
			row.createCell(10).setCellValue(
					teacherAndAcademyss.getFivem() == null ? "" : teacherAndAcademyss.getFivem().toString());
			row.createCell(11).setCellValue(
					teacherAndAcademyss.getLong_jump() == null ? "" : teacherAndAcademyss.getLong_jump().toString());
			row.createCell(12).setCellValue(
					teacherAndAcademyss.getReach() == null ? "" : teacherAndAcademyss.getReach().toString());
			row.createCell(13).setCellValue(teacherAndAcademyss.getEightm());
			row.createCell(14).setCellValue(teacherAndAcademyss.getTenm());
			row.createCell(15).setCellValue(
					teacherAndAcademyss.getSit_ups() == null ? "" : teacherAndAcademyss.getSit_ups().toString());
			row.createCell(16).setCellValue(
					teacherAndAcademyss.getPull_up() == null ? "" : teacherAndAcademyss.getPull_up().toString());
			row.createCell(17).setCellValue(
					teacherAndAcademyss.getScore() == null ? "" : teacherAndAcademyss.getScore().toString());
			row.createCell(18)
					.setCellValue(teacherAndAcademyss.getState().equals("正常") ? "" : teacherAndAcademyss.getState());

			// row.createCell((short) 2).setCellValue((double) stu.getAge());
			// cell = row.createCell((short) 3);
			// cell.setCellValue(new
			// SimpleDateFormat("yyyy-mm-dd").format(stu.getBirth()));
		}
		// 第六步，将文件存到指定位置
		try {
			FileOutputStream fout = new FileOutputStream("/home/page/excel/pe4.xls");
			wb.write(fout);
			fout.close();
			wb.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 教师导入成绩
	 * 
	 * @param file
	 * @param year
	 * @return boolean
	 */
	public boolean excelTeachersReader(MultipartFile file, int year) {
		try {
			InputStream is = file.getInputStream();
			Workbook workbook = WorkbookFactory.create(is);
			int sheetCount = workbook.getNumberOfSheets(); // Sheet的数量
			// 遍历每个Sheet
			for (int s = 0; s < sheetCount; s++) {
				Sheet sheet = workbook.getSheetAt(s);
				int rowCount = sheet.getPhysicalNumberOfRows(); // 获取总行数
				// 遍历每一行
				for (int r = 4; r < rowCount; r++) {
					try {
						Row row = sheet.getRow(r); // 取出相应的列

						String id = null;
						try {
							id = row.getCell(1).toString();
						} catch (NullPointerException e) {
							continue;
						}
						String gender = row.getCell(3).toString();
						Integer grade = (int) Double.parseDouble(row.getCell(5).toString().substring(0, 4));
						Integer height = (int) Double.parseDouble(row.getCell(6).toString());
						Double weight = Double.parseDouble(row.getCell(7).toString());
						Integer vital_capacity = (int) Double.parseDouble(row.getCell(8).toString());
						Double fivem = Double.parseDouble(row.getCell(9).toString());
						Double long_jump = Double.parseDouble(row.getCell(10).toString());
						Double reach = Double.parseDouble(row.getCell(11).toString());
						String eightm = "";
						String tenm = "";
						Integer sit_ups = 0;
						Integer pull_up = 0;
						try {
							eightm = row.getCell(12).toString();
							sit_ups = (int) Double.parseDouble(row.getCell(14).toString());
						} catch (Exception e) {
						}
						try {
							tenm = row.getCell(13).toString();
							pull_up = (int) Double.parseDouble(row.getCell(15).toString());
						} catch (Exception e) {
						}

						double score = ComputeScore.score(grade, gender, height, weight, vital_capacity, fivem,
								long_jump, reach, eightm, tenm, sit_ups, pull_up);

						Data data = new Data(id, year, height, weight, vital_capacity, fivem, long_jump,
								reach, eightm, tenm, sit_ups, pull_up, score, "未审核", "未审核");
						teacherAndAcademyDao.updateTeacherData(data);
					} catch (NumberFormatException e) {
						continue;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
			return false;
		} catch (InvalidFormatException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 学院导入成绩
	 * 
	 * @param file
	 * @param year
	 * @param school
	 * @return boolean
	 */
	public boolean excelAcademyReader(MultipartFile file, int year, String school) {
		try {
			InputStream is = file.getInputStream();
			Workbook workbook = WorkbookFactory.create(is);
			int sheetCount = workbook.getNumberOfSheets(); // Sheet的数量
			// 遍历每个Sheet
			for (int s = 0; s < sheetCount; s++) {
				Sheet sheet = workbook.getSheetAt(s);
				int rowCount = sheet.getPhysicalNumberOfRows(); // 获取总行数
				// 遍历每一行
				for (int r = 4; r < rowCount; r++) {
					try {
						Row row = sheet.getRow(r); // 取出相应的列

						String id = null;
						try {
							id = row.getCell(1).toString();
						} catch (NullPointerException e) {
							continue;
						}
						if (!row.getCell(4).toString().equals(school)) {
							continue;
						}
						String gender = row.getCell(3).toString();
						Integer grade = (int) Double.parseDouble(row.getCell(5).toString().substring(0, 4));
						Integer height = (int) Double.parseDouble(row.getCell(6).toString());
						Double weight = Double.parseDouble(row.getCell(7).toString());
						Integer vital_capacity = (int) Double.parseDouble(row.getCell(8).toString());
						Double fivem = Double.parseDouble(row.getCell(9).toString());
						Double long_jump = Double.parseDouble(row.getCell(10).toString());
						Double reach = Double.parseDouble(row.getCell(11).toString());
						String eightm = "";
						String tenm = "";
						Integer sit_ups = 0;
						Integer pull_up = 0;
						try {
							eightm = row.getCell(12).toString();
							sit_ups = (int) Double.parseDouble(row.getCell(14).toString());
						} catch (Exception e) {
						}
						try {
							tenm = row.getCell(13).toString();
							pull_up = (int) Double.parseDouble(row.getCell(15).toString());
						} catch (Exception e) {
						}

						double score = ComputeScore.score(grade, gender, height, weight, vital_capacity, fivem,
								long_jump, reach, eightm, tenm, sit_ups, pull_up);

						Data data = new Data(id, year, height, weight, vital_capacity, fivem, long_jump,
								reach, eightm, tenm, sit_ups, pull_up, score, "未审核", "未审核");
						teacherAndAcademyDao.updateTeacherData(data);
					} catch (NumberFormatException e) {
						continue;
					}
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
			return false;
		} catch (InvalidFormatException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 学生用户管理的Excel表格的导入
	 * 
	 * @param file
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	public boolean excelStudentReader(MultipartFile file) {
		try {
			InputStream is = file.getInputStream();
			Workbook workbook = WorkbookFactory.create(is);
			int sheetCount = workbook.getNumberOfSheets(); // Sheet的数量
			// 遍历每个Sheet
			List<User> user = new ArrayList<>();
			List<Student> student = new ArrayList<>();
			List<Data> datas = new ArrayList<>();
			for (int s = 0; s < sheetCount; s++) {
				Sheet sheet = workbook.getSheetAt(s);
				int rowCount = sheet.getPhysicalNumberOfRows(); // 获取总行数
				// 遍历每一行
				for (int r = 1; r < rowCount; r++) {
					Row row = sheet.getRow(r); // 取出相应的行

					String userName = row.getCell(0).toString();
					String name = row.getCell(1).toString();
					String gender = row.getCell(2).toString();
					String school = row.getCell(3).toString();
					Integer grade = (int) Double.parseDouble(row.getCell(4).toString());
					String classes = row.getCell(5).toString();
					Integer duration = (int) Double.parseDouble(row.getCell(6).toString());

					String id = userName;
					String nickName = name;

					user.add(new User(userName, ShiroUtils.passwdMD5("123456"), nickName, "学生"));
					student.add(new Student(id, name, gender, school, grade, classes, duration, "正常", "老师"));
					datas.add(new Data(id, Integer.parseInt(StringUtils.yearToString(new Date()))));
				}

			}
			userDao.addExcelStudent1(user);
			userDao.addExcelStudent2(student);
			userDao.addExcelStudent3(datas);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
			return false;
		} catch (InvalidFormatException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 学生与老师绑定的Excel表格的导入
	 * 
	 * @param file
	 * @param year
	 * @return
	 */
	public boolean excelTeacherToStudentReader(MultipartFile file, Integer year) {
		try {
			InputStream is = file.getInputStream();
			Workbook workbook = WorkbookFactory.create(is);
			int sheetCount = workbook.getNumberOfSheets(); // Sheet的数量
			// 遍历每个Sheet
			List<TeacherToStudent> teacherToStudents = new ArrayList<>();
			for (int s = 0; s < sheetCount; s++) {
				Sheet sheet = workbook.getSheetAt(s);
				int rowCount = sheet.getPhysicalNumberOfRows(); // 获取总行数
				// 遍历每一行
				for (int r = 1; r < rowCount; r++) {
					Row row = sheet.getRow(r); // 取出相应的行

					String studentId = row.getCell(0).toString();
					String teacher = row.getCell(1).toString();
					Integer subjectId = (int) Double.parseDouble(row.getCell(2).toString());
					String subjectName = row.getCell(3).toString();

					teacherToStudents.add(new TeacherToStudent(studentId, year, teacher, subjectId, subjectName));
				}
			}
			adminDao.addTeacherToStudentDatas(teacherToStudents);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
			return false;
		} catch (InvalidFormatException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 管理员界面新增学生成绩数据
	 * 
	 * @param file
	 * @param year
	 * @return
	 */
	public boolean excelAdminReader(MultipartFile file, int year) {
		try {
			InputStream is = file.getInputStream();
			Workbook workbook = WorkbookFactory.create(is);
			int sheetCount = workbook.getNumberOfSheets(); // Sheet的数量
			// 遍历每个Sheet
			List<Data> datas = new ArrayList<>();
			for (int s = 0; s < sheetCount; s++) {
				Sheet sheet = workbook.getSheetAt(s);
				int rowCount = sheet.getPhysicalNumberOfRows(); // 获取总行数
				// 遍历每一行

				for (int r = 4; r < rowCount; r++) {
					try {
						Row row = sheet.getRow(r); // 取出相应的列
						String id = null;
						try {
							id = row.getCell(1).toString();
						} catch (NullPointerException e) {
							continue;
						}
						String gender = row.getCell(3).toString();
						Integer grade = (int) Double.parseDouble(row.getCell(5).toString().substring(0, 4));
						Integer height = (int) Double.parseDouble(row.getCell(6).toString());
						Double weight = Double.parseDouble(row.getCell(7).toString());
						Integer vital_capacity = (int) Double.parseDouble(row.getCell(8).toString());
						Double fivem = Double.parseDouble(row.getCell(9).toString());
						Double long_jump = Double.parseDouble(row.getCell(10).toString());
						Double reach = Double.parseDouble(row.getCell(11).toString());
						String eightm = "";
						String tenm = "";
						Integer sit_ups = 0;
						Integer pull_up = 0;
						try {
							eightm = row.getCell(12).toString();
							sit_ups = (int) Double.parseDouble(row.getCell(14).toString());
						} catch (Exception e) {
						}
						try {
							tenm = row.getCell(13).toString();
							pull_up = (int) Double.parseDouble(row.getCell(15).toString());
						} catch (Exception e) {
						}
						double score = ComputeScore.score(grade, gender, height, weight, vital_capacity, fivem,
								long_jump, reach, eightm, tenm, sit_ups, pull_up);

						Data data = new Data(id, year, height, weight, vital_capacity, fivem, long_jump,
								reach, eightm, tenm, sit_ups, pull_up, score, "已审核", "已审核");
						datas.add(data);
					} catch (NumberFormatException e) {
						continue;
					}
				}
			}
			adminDao.addListStudentDatas(datas);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
			return false;
		} catch (InvalidFormatException e) {
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 管理员修改导入成绩
	 * 
	 * @param file
	 * @param year
	 * @return boolean
	 */
	public boolean excelAdminUpdateReader(MultipartFile file, int year) {
		try {
			InputStream is = file.getInputStream();
			Workbook workbook = WorkbookFactory.create(is);
			int sheetCount = workbook.getNumberOfSheets(); // Sheet的数量
			// 遍历每个Sheet
			for (int s = 0; s < sheetCount; s++) {
				Sheet sheet = workbook.getSheetAt(s);
				int rowCount = sheet.getPhysicalNumberOfRows(); // 获取总行数
				// 遍历每一行
				for (int r = 4; r < rowCount; r++) {
					try {
						Row row = sheet.getRow(r); // 取出相应的列
						String id = null;
						try {
							id = row.getCell(1).toString();
						} catch (NullPointerException e) {
							continue;
						}
						String gender = row.getCell(3).toString();
						Integer grade = (int) Double.parseDouble(row.getCell(5).toString().substring(0, 4));
						Integer height = (int) Double.parseDouble(row.getCell(6).toString());
						Double weight = Double.parseDouble(row.getCell(7).toString());
						Integer vital_capacity = (int) Double.parseDouble(row.getCell(8).toString());
						Double fivem = Double.parseDouble(row.getCell(9).toString());
						Double long_jump = Double.parseDouble(row.getCell(10).toString());
						Double reach = Double.parseDouble(row.getCell(11).toString());
						String eightm = "";
						String tenm = "";
						Integer sit_ups = 0;
						Integer pull_up = 0;
						try {
							eightm = row.getCell(12).toString();
							sit_ups = (int) Double.parseDouble(row.getCell(14).toString());
						} catch (Exception e) {
						}
						try {
							tenm = row.getCell(13).toString();
							pull_up = (int) Double.parseDouble(row.getCell(15).toString());
						} catch (Exception e) {
						}
						double score = ComputeScore.score(grade, gender, height, weight, vital_capacity, fivem,
								long_jump, reach, eightm, tenm, sit_ups, pull_up);

						Data data = new Data(id, year, height, weight, vital_capacity, fivem, long_jump,
								reach, eightm, tenm, sit_ups, pull_up, score, "已审核", "已审核");
						teacherAndAcademyDao.updateTeacherData(data);
					} catch (NumberFormatException e) {
						e.printStackTrace();
						continue;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
			return false;
		} catch (InvalidFormatException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 管理员导出未毕业数据Excel
	 * 
	 * @param id
	 * @param name
	 * @param school
	 * @param year
	 */
	public void outputAdminDatasExcel(String id, String name, String school, Integer year) {
		// 第一步，创建一个webbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet("sheet1");
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		HSSFRow row = sheet.createRow(0);
		// 第四步，创建单元格，并设置值表头 设置表头居中
		// HSSFCellStyle style = wb.createCellStyle();
		// style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

		HSSFCell cell = row.createCell(0);
		cell.setCellValue("学号");
		// cell.setCellStyle(style);
		cell = row.createCell(1);
		cell.setCellValue("姓名");
		cell = row.createCell(2);
		cell.setCellValue("性别");
		// cell.setCellStyle(style);
		cell = row.createCell(3);
		cell.setCellValue("院系");
		cell = row.createCell(4);
		cell.setCellValue("年级");
		cell = row.createCell(5);
		cell.setCellValue("班级");
		// cell.setCellStyle(style);
		cell = row.createCell(6);
		cell.setCellValue("年份");
		cell = row.createCell(7);
		cell.setCellValue("身高");
		cell = row.createCell(8);
		cell.setCellValue("体重");
		cell = row.createCell(9);
		cell.setCellValue("肺活量");
		cell = row.createCell(10);
		cell.setCellValue("50m跑");
		cell = row.createCell(11);
		cell.setCellValue("立定跳远");
		cell = row.createCell(12);
		cell.setCellValue("坐位前屈");
		cell = row.createCell(13);
		cell.setCellValue("800米跑");
		cell = row.createCell(14);
		cell.setCellValue("1000m跑");
		cell = row.createCell(15);
		cell.setCellValue("一分钟仰卧起坐");
		cell = row.createCell(16);
		cell.setCellValue("引体向上");
		cell = row.createCell(17);
		cell.setCellValue("分数");
		cell = row.createCell(18);
		cell.setCellValue("备注");

		// // 第五步，写入实体数据 实际应用中这些数据从数据库得到，
		List<TeacherAndAcademy> teacherAndAcademys = adminDao
				.outputAdminDatasExcel(new TeacherAndAcademyLike(id, name, school, year));

		for (int i = 0; i < teacherAndAcademys.size(); i++) {
			row = sheet.createRow((int) i + 1);
			TeacherAndAcademy teacherAndAcademyss = teacherAndAcademys.get(i);
			// 第四步，创建单元格，并设置值
			row.createCell(0).setCellValue(teacherAndAcademyss.getId());
			row.createCell(1).setCellValue(teacherAndAcademyss.getName());
			row.createCell(2).setCellValue(teacherAndAcademyss.getGender());
			row.createCell(3).setCellValue(teacherAndAcademyss.getSchool());
			row.createCell(4).setCellValue(teacherAndAcademyss.getGrade());
			row.createCell(5).setCellValue(teacherAndAcademyss.getClasses());
			row.createCell(6).setCellValue(
					teacherAndAcademyss.getYear() == null ? "" : teacherAndAcademyss.getYear().toString());
			row.createCell(7).setCellValue(
					teacherAndAcademyss.getHeight() == null ? "" : teacherAndAcademyss.getHeight().toString());
			row.createCell(8).setCellValue(
					teacherAndAcademyss.getWeight() == null ? "" : teacherAndAcademyss.getWeight().toString());
			row.createCell(9).setCellValue(teacherAndAcademyss.getVital_capacity() == null ? ""
					: teacherAndAcademyss.getVital_capacity().toString());
			row.createCell(10).setCellValue(
					teacherAndAcademyss.getFivem() == null ? "" : teacherAndAcademyss.getFivem().toString());
			row.createCell(11).setCellValue(
					teacherAndAcademyss.getLong_jump() == null ? "" : teacherAndAcademyss.getLong_jump().toString());
			row.createCell(12).setCellValue(
					teacherAndAcademyss.getReach() == null ? "" : teacherAndAcademyss.getReach().toString());
			row.createCell(13).setCellValue(teacherAndAcademyss.getEightm());
			row.createCell(14).setCellValue(teacherAndAcademyss.getTenm());
			row.createCell(15).setCellValue(
					teacherAndAcademyss.getSit_ups() == null ? "" : teacherAndAcademyss.getSit_ups().toString());
			row.createCell(16).setCellValue(
					teacherAndAcademyss.getPull_up() == null ? "" : teacherAndAcademyss.getPull_up().toString());
			row.createCell(17).setCellValue(
					teacherAndAcademyss.getScore() == null ? "" : teacherAndAcademyss.getScore().toString());
			row.createCell(18)
					.setCellValue(teacherAndAcademyss.getState().equals("正常") ? "" : teacherAndAcademyss.getState());

			// row.createCell((short) 2).setCellValue((double) stu.getAge());
			// cell = row.createCell((short) 3);
			// cell.setCellValue(new
			// SimpleDateFormat("yyyy-mm-dd").format(stu.getBirth()));
		}
		// 第六步，将文件存到指定位置
		try {
			FileOutputStream fout = new FileOutputStream("/home/page/excel/pe5.xls");
			wb.write(fout);
			fout.close();
			wb.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 管理员导出已毕业数据Excel
	 * 
	 * @param id
	 * @param name
	 * @param school
	 * @param year
	 */
	public void outputAdminGraduateDatasExcel(String id, String name, String school, Integer year) {
		// 第一步，创建一个webbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet("sheet1");
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		HSSFRow row = sheet.createRow(0);
		// 第四步，创建单元格，并设置值表头 设置表头居中
		// HSSFCellStyle style = wb.createCellStyle();
		// style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

		HSSFCell cell = row.createCell(0);
		cell.setCellValue("学号");
		// cell.setCellStyle(style);
		cell = row.createCell(1);
		cell.setCellValue("姓名");
		cell = row.createCell(2);
		cell.setCellValue("性别");
		// cell.setCellStyle(style);
		cell = row.createCell(3);
		cell.setCellValue("院系");
		cell = row.createCell(4);
		cell.setCellValue("年级");
		cell = row.createCell(5);
		cell.setCellValue("班级");
		// cell.setCellStyle(style);
		cell = row.createCell(6);
		cell.setCellValue("年份");
		cell = row.createCell(7);
		cell.setCellValue("身高");
		cell = row.createCell(8);
		cell.setCellValue("体重");
		cell = row.createCell(9);
		cell.setCellValue("肺活量");
		cell = row.createCell(10);
		cell.setCellValue("50m跑");
		cell = row.createCell(11);
		cell.setCellValue("立定跳远");
		cell = row.createCell(12);
		cell.setCellValue("坐位前屈");
		cell = row.createCell(13);
		cell.setCellValue("800米跑");
		cell = row.createCell(14);
		cell.setCellValue("1000m跑");
		cell = row.createCell(15);
		cell.setCellValue("一分钟仰卧起坐");
		cell = row.createCell(16);
		cell.setCellValue("引体向上");
		cell = row.createCell(17);
		cell.setCellValue("分数");
		cell = row.createCell(18);
		cell.setCellValue("备注");

		// // 第五步，写入实体数据 实际应用中这些数据从数据库得到，
		List<TeacherAndAcademy> teacherAndAcademys = adminDao
				.outputAdminGraduateDatasExcel(new TeacherAndAcademyLike(id, name, school, year));

		for (int i = 0; i < teacherAndAcademys.size(); i++) {
			row = sheet.createRow((int) i + 1);
			TeacherAndAcademy teacherAndAcademyss = teacherAndAcademys.get(i);
			// 第四步，创建单元格，并设置值
			row.createCell(0).setCellValue(teacherAndAcademyss.getId());
			row.createCell(1).setCellValue(teacherAndAcademyss.getName());
			row.createCell(2).setCellValue(teacherAndAcademyss.getGender());
			row.createCell(3).setCellValue(teacherAndAcademyss.getSchool());
			row.createCell(4).setCellValue(teacherAndAcademyss.getGrade());
			row.createCell(5).setCellValue(teacherAndAcademyss.getClasses());
			row.createCell(6).setCellValue(
					teacherAndAcademyss.getYear() == null ? "" : teacherAndAcademyss.getYear().toString());
			row.createCell(7).setCellValue(
					teacherAndAcademyss.getHeight() == null ? "" : teacherAndAcademyss.getHeight().toString());
			row.createCell(8).setCellValue(
					teacherAndAcademyss.getWeight() == null ? "" : teacherAndAcademyss.getWeight().toString());
			row.createCell(9).setCellValue(teacherAndAcademyss.getVital_capacity() == null ? ""
					: teacherAndAcademyss.getVital_capacity().toString());
			row.createCell(10).setCellValue(
					teacherAndAcademyss.getFivem() == null ? "" : teacherAndAcademyss.getFivem().toString());
			row.createCell(11).setCellValue(
					teacherAndAcademyss.getLong_jump() == null ? "" : teacherAndAcademyss.getLong_jump().toString());
			row.createCell(12).setCellValue(
					teacherAndAcademyss.getReach() == null ? "" : teacherAndAcademyss.getReach().toString());
			row.createCell(13).setCellValue(teacherAndAcademyss.getEightm());
			row.createCell(14).setCellValue(teacherAndAcademyss.getTenm());
			row.createCell(15).setCellValue(
					teacherAndAcademyss.getSit_ups() == null ? "" : teacherAndAcademyss.getSit_ups().toString());
			row.createCell(16).setCellValue(
					teacherAndAcademyss.getPull_up() == null ? "" : teacherAndAcademyss.getPull_up().toString());
			row.createCell(17).setCellValue(
					teacherAndAcademyss.getScore() == null ? "" : teacherAndAcademyss.getScore().toString());
			row.createCell(18).setCellValue(
					teacherAndAcademyss.getState().equals("正常") ? "" : teacherAndAcademyss.getState().toString());

			// row.createCell((short) 2).setCellValue((double) stu.getAge());
			// cell = row.createCell((short) 3);
			// cell.setCellValue(new
			// SimpleDateFormat("yyyy-mm-dd").format(stu.getBirth()));
		}
		// 第六步，将文件存到指定位置
		try {
			FileOutputStream fout = new FileOutputStream("/home/page/excel/pe6.xls");
			wb.write(fout);
			fout.close();
			wb.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
