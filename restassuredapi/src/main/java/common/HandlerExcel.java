package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.RowIdLifetime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author 张大爷
 * @time 2017年9月23日 上午12:33:52 Just a joke
 */

public class HandlerExcel {

	// 向表格单元格中写入数据
	public static void setDataToCell(String excelPath, String excelName, String excelConfigSheet, String data) {
		Log.info("=========================表格测试数据写入开始=========================");
		File file = new File(excelPath + "\\" + excelName);
		Log.info("测试数据表格：" + file.toString());
		Log.info("读取sheet: " + excelConfigSheet);
		try {
			FileInputStream inputStream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet sheet = workbook.getSheet(excelConfigSheet);
			int rowcount = sheet.getLastRowNum() - sheet.getFirstRowNum() + 1;
			// 获取表格表头信息
			Row headerrow = sheet.getRow(0);
			String headerrowfields[] = new String[headerrow.getLastCellNum()];
			for (int k = 0; k < headerrow.getLastCellNum(); k++) {
				headerrowfields[k] = headerrow.getCell(k).getStringCellValue();
			}
			// 循环查找单元格并且插入数据
			for (int i = 1; i < rowcount; i++) {
				Row row = sheet.getRow(i);
				for (int j = 0; j < row.getLastCellNum(); j++) {
					if ("token".equals(headerrowfields[j])) {
						row.createCell(j).setCellValue(data);
					}
				}
			}
			FileOutputStream outputStream = new FileOutputStream(file);
			workbook.write(outputStream);
			outputStream.close();
			inputStream.close();
			workbook.close();
		} catch (Exception e) {
			String failString = "数据写入表格失败！！";
			Log.info(failString);
			e.printStackTrace();
		}
		Log.info("=========================表格测试数据写入结束=========================");
	}

	// 获取二维数组数据提供给测试数据提供类pro
	public static Object[][] getTestDataMap(String excelPath, String excelName, String excelConfigSheet)
			throws IOException {
		Log.info("=========================表格测试数据读取开始=========================");
		File file = new File(excelPath + "\\" + excelName);
		Log.info("测试数据表格：" + file.toString());
		Log.info("读取sheet: " + excelConfigSheet);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(excelConfigSheet);
		int rowcount = sheet.getLastRowNum() - sheet.getFirstRowNum() + 1;
		List<Object[]> records = new ArrayList<Object[]>();
		// 获取表格表头信息
		Row headerrow = sheet.getRow(0);
		String headerrowfields[] = new String[headerrow.getLastCellNum()];
		for (int k = 0; k < headerrow.getLastCellNum(); k++) {
			headerrowfields[k] = headerrow.getCell(k).getStringCellValue();
		}
		// 获取表格数据信息
		for (int i = 1; i < rowcount; i++) {
			Log.info("--------------------第" + i + "组测试数据" + "--------------------");
			Row row = sheet.getRow(i);
			String fields[] = new String[row.getLastCellNum()];
			for (int j = 0; j < row.getLastCellNum(); j++) {
				if (row.getCell(j) != null) {
					fields[j] = row.getCell(j).getStringCellValue();
					Log.info(headerrowfields[j] + "：" + fields[j]);
				}
			}
			records.add(fields);
		}
		Object[][] results = new Object[records.size()][];
		for (int i = 0; i < records.size(); i++) {
			results[i] = records.get(i);
		}
		workbook.close();
		Log.info("=========================表格测试数据读取结束=========================");
		return results;

	}

	// 获取服务器、社区、用户、验证码、推荐码
	public static Map<String, String> getConfigMap(String excelPath, String excelName, String excelConfigSheet,
			int configRow) throws IOException {
		Log.info("=========================测试环境数据读取开始=========================");
		File file = new File(excelPath + "\\" + excelName);
		Log.info("配置文件表格：" + file.toString());
		Log.info("读取sheet: " + excelConfigSheet);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(excelConfigSheet);
		// 获取表格表头信息
		Row headerrow = sheet.getRow(0);
		String headerrowfields[] = new String[headerrow.getLastCellNum()];
		for (int k = 0; k < headerrow.getLastCellNum(); k++) {
			headerrowfields[k] = headerrow.getCell(k).getStringCellValue();
		}
		// 获取服务器、社区、用户、验证码、推荐码信息
		Row row = sheet.getRow(configRow - 1);
		String fields[] = new String[row.getLastCellNum()];
		Map<String, String> map = new HashMap<String, String>();
		for (int j = 0; j < row.getLastCellNum(); j++) {
			if (row.getCell(j) != null) {
				fields[j] = row.getCell(j).getStringCellValue();
				map.put(headerrowfields[j], fields[j]);
				Log.info(headerrowfields[j] + "：" + fields[j]);
			}
		}
		workbook.close();
		Log.info("=========================测试环境数据读取结束=========================");
		return map;
	}

	// 获取接口信息
	public static Map<String, String> getApiMap(String excelPath, String excelName, String excelApiSheet, int apiRow)
			throws IOException {
		Log.info("=========================接口信息读取开始=========================");
		File file = new File(excelPath + "\\" + excelName);
		Log.info("配置文件表格：" + file.toString());
		Log.info("读取sheet: " + excelApiSheet);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(excelApiSheet);
		// 获取表格表头信息
		Row headerrow = sheet.getRow(0);
		String headerrowfields[] = new String[headerrow.getLastCellNum()];
		for (int k = 0; k < headerrow.getLastCellNum(); k++) {
			headerrowfields[k] = headerrow.getCell(k).getStringCellValue();
		}
		// 获取第apirow行接口信息
		Row row = sheet.getRow(apiRow - 1);
		String fields[] = new String[row.getLastCellNum()];
		Map<String, String> map = new HashMap<String, String>();
		for (int j = 0; j < row.getLastCellNum(); j++) {
			if (row.getCell(j) != null) {
				fields[j] = row.getCell(j).getStringCellValue();
				map.put(headerrowfields[j], fields[j]);
				Log.info(headerrowfields[j] + "：" + fields[j]);
			}
		}
		workbook.close();
		Log.info("=========================接口信息读取结束=========================");
		return map;
	}
}
