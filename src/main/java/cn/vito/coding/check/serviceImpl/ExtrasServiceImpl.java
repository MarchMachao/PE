package cn.vito.coding.check.serviceImpl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
import org.springframework.web.multipart.MultipartFile;

import cn.vito.coding.check.mapper.ExtrasDao;
import cn.vito.coding.check.po.Extras;
import cn.vito.coding.check.service.ExtrasService;

@Service
public class ExtrasServiceImpl implements ExtrasService {

	@Autowired
	private ExtrasDao extrasDao;

	@Override
	public List<Extras> findStudentExtras(Extras extras) {
		return extrasDao.findStudentExtras(extras);
	}

	@Override
	public int countStudentExtras(Extras extras) {
		return extrasDao.countStudentExtras(extras);
	}

	@Override
	public void addOneExtra(String id, Integer year, Double extra) {
		extrasDao.addOneExtra(new Extras(id, year, extra));
	}

	@Override
	public void updateExtras(String id, Integer year, Double extra) {
		extrasDao.updateExtras(new Extras(id, year, extra));
	}

	@Override
	public void deleteExtras(String id, Integer year) {
		extrasDao.deleteExtras(new Extras(id, year));
	}

	@Override
	public boolean excelExtrasInsertReader(MultipartFile file, int year) {
		try {
			InputStream is = file.getInputStream();
			Workbook workbook = WorkbookFactory.create(is);
			int sheetCount = workbook.getNumberOfSheets(); // Sheet的数量
			// 遍历每个Sheet
			for (int s = 0; s < sheetCount; s++) {
				Sheet sheet = workbook.getSheetAt(s);
				int rowCount = sheet.getPhysicalNumberOfRows(); // 获取总行数
				// 遍历每一行
				for (int r = 1; r < rowCount; r++) {
					try {
						Row row = sheet.getRow(r); // 取出相应的列
						String id = row.getCell(0).toString();
						Double extra = Double.parseDouble(row.getCell(1).toString());
						Extras extras = new Extras(id, year, extra);
						extrasDao.addOneExtra(extras);
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

	@Override
	public void outputExtrasExcel(Extras extras) {
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
		cell.setCellValue("年份");
		cell = row.createCell(6);
		cell.setCellValue("附加分");
		cell = row.createCell(7);
		cell.setCellValue("备注");

		// // 第五步，写入实体数据 实际应用中这些数据从数据库得到，
		List<Extras> extrasList = extrasDao.findStudentExtras(extras);

		for (int i = 0; i < extrasList.size(); i++) {
			row = sheet.createRow((int) i + 1);
			Extras extra = extrasList.get(i);
			// 第四步，创建单元格，并设置值
			row.createCell(0).setCellValue(extra.getId());
			row.createCell(1).setCellValue(extra.getName());
			row.createCell(2).setCellValue(extra.getGender());
			row.createCell(3).setCellValue(extra.getSchool());
			row.createCell(4).setCellValue(extra.getGrade());
			row.createCell(5).setCellValue(extra.getYear());
			row.createCell(6).setCellValue(extra.getExtra());
			row.createCell(7).setCellValue(extra.getState().equals("正常") ? "" : extra.getState().toString());

			// row.createCell((short) 2).setCellValue((double) stu.getAge());
			// cell = row.createCell((short) 3);
			// cell.setCellValue(new
			// SimpleDateFormat("yyyy-mm-dd").format(stu.getBirth()));
		}
		// 第六步，将文件存到指定位置
		try {
			FileOutputStream fout = new FileOutputStream("/home/page/excel/pe7.xls");
			wb.write(fout);
			fout.close();
			wb.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
