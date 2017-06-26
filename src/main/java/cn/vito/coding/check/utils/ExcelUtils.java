package cn.vito.coding.check.utils;

import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.vito.coding.check.po.TeacherAndAcademy;
import cn.vito.coding.check.service.TeacherAndAcademyService;

@Service
public class ExcelUtils {

	@Autowired
	private TeacherAndAcademyService teacherAndAcademyService;

	public void outputExcel(String id, String name, String school, String teacher, Integer year) {
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
		// cell.setCellStyle(style);
		cell = row.createCell(2);
		cell.setCellValue("院系");
		// cell.setCellStyle(style);
		cell = row.createCell(3);
		cell.setCellValue("教师");
		// cell.setCellStyle(style);
		cell = row.createCell(4);
		cell.setCellValue("年份");
		cell = row.createCell(5);
		cell.setCellValue("身高");
		cell = row.createCell(6);
		cell.setCellValue("体重");
		cell = row.createCell(7);
		cell.setCellValue("肺活量");
		cell = row.createCell(8);
		cell.setCellValue("50m跑");
		cell = row.createCell(9);
		cell.setCellValue("立定跳远");
		cell = row.createCell(10);
		cell.setCellValue("坐位前屈");
		cell = row.createCell(11);
		cell.setCellValue("800米跑");
		cell = row.createCell(12);
		cell.setCellValue("1000m跑");
		cell = row.createCell(13);
		cell.setCellValue("一分钟仰卧起坐");
		cell = row.createCell(14);
		cell.setCellValue("引体向上");
		// // 第五步，写入实体数据 实际应用中这些数据从数据库得到，
		List<TeacherAndAcademy> teacherAndAcademys = teacherAndAcademyService.findTeacherExcel(id, name, school,
				teacher, year);

		for (int i = 0; i < teacherAndAcademys.size(); i++) {
			row = sheet.createRow((int) i + 1);
			TeacherAndAcademy teacherAndAcademyss = teacherAndAcademys.get(i);
			// 第四步，创建单元格，并设置值
			row.createCell(0).setCellValue(teacherAndAcademyss.getId());
			row.createCell(1).setCellValue(teacherAndAcademyss.getName());
			row.createCell(2).setCellValue(teacherAndAcademyss.getSchool());
			row.createCell(3).setCellValue(teacherAndAcademyss.getTeacher());
			row.createCell(4).setCellValue(teacherAndAcademyss.getYear());
			row.createCell(5)
					.setCellValue(teacherAndAcademyss.getHeight() == null ? ' ' : teacherAndAcademyss.getHeight());
			row.createCell(6).setCellValue(teacherAndAcademyss.getWeight());
			row.createCell(7).setCellValue(teacherAndAcademyss.getVital_capacity());
			row.createCell(8).setCellValue(teacherAndAcademyss.getFivem());
			row.createCell(9).setCellValue(teacherAndAcademyss.getLong_jump());
			row.createCell(10).setCellValue(teacherAndAcademyss.getReach());
			row.createCell(11).setCellValue(teacherAndAcademyss.getEightm());
			row.createCell(12).setCellValue(teacherAndAcademyss.getTenm());
			row.createCell(13).setCellValue(teacherAndAcademyss.getSit_ups());
			row.createCell(14).setCellValue(teacherAndAcademyss.getPull_up());
			// row.createCell((short) 2).setCellValue((double) stu.getAge());
			// cell = row.createCell((short) 3);
			// cell.setCellValue(new
			// SimpleDateFormat("yyyy-mm-dd").format(stu.getBirth()));
		}
		// // 第六步，将文件存到指定位置
		try {
			FileOutputStream fout = new FileOutputStream("/home/pe.xls");
			wb.write(fout);
			fout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
