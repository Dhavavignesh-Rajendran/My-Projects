package Excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	static public void ReadNum( ) throws IOException{
		String fileLocation = "./ExcelWorkbook/States_Capital.xlsx";
		FileInputStream inputStream = new FileInputStream(fileLocation);
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("sheet1");
		int lastRowNum = sheet.getLastRowNum();
		int RowNumWthHeader = sheet.getPhysicalNumberOfRows();
		int lastCellNum = sheet.getRow(0).getLastCellNum();
//		for (int i = 1; i <= lastRowNum; i++) {
//
//			XSSFRow row = sheet.getRow(i);
//			for (int j = 0; j < lastCellNum; j++) {
//				XSSFCell cell = row.getCell(j);
//				DataFormatter dft = new DataFormatter();
//				String value = dft.formatCellValue(cell);
//				System.out.println(value);
//
//			}
//			
//		}
//		System.out.println("-------------------------------------------------------------------------------");
	
		Scanner getuservalue=new Scanner(System.in);
		System.out.println("Enetr the value---->");
		String id= getuservalue.nextLine();  
			//String id="2.0";			
			for(Row row:sheet) {
				if(row.getCell(0).toString().equals(id)) {
					for(Cell cell: row) {
						switch (cell.getCellType()) {
						case STRING:
							System.out.print(cell.getStringCellValue());
							System.out.println();
							break;
						case NUMERIC:
							System.out.print(cell.getNumericCellValue());
							System.out.println();
							break;
						default:
							break;
						}
					}
				}
			}
		}
		//workbook.close();
			public static void main(String[] args) throws IOException {
				ExcelRead.ReadNum();
				
	}
		
}
