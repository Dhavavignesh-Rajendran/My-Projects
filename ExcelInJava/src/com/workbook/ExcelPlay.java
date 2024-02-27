package com.workbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
public class ExcelPlay {

	public static void main(String[] args) throws Exception {
		String fileLocation = ".\\ExcelWoorkBook\\States_Capital.xlsx";
		FileInputStream inputStream = new FileInputStream(fileLocation);
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("sheet1");
		int lastRowNum = sheet.getLastRowNum();
		int RowNumWthHeader = sheet.getPhysicalNumberOfRows();
		int lastCellNum = sheet.getRow(0).getLastCellNum();
		for (int i = 1; i <= lastRowNum; i++) {

			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < lastCellNum; j++) {
				XSSFCell cell = row.getCell(j);
				DataFormatter dft=new DataFormatter();
				String value =cell.getStringCellValue();
				System.out.println(value);

			}
		}
		workbook.close();

	}

}
