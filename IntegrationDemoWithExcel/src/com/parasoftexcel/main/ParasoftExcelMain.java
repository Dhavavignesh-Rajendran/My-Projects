package com.parasoftexcel.main;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.parasoftexcel.util.ParasoftExcelUtil;


public class ParasoftExcelMain {

	static ParasoftExcelUtil util;
	static WebDriver driver;
	static Map<String, String> readExcelValue = new HashMap<>();

	public static void main(String[] args) throws IOException {
		readExcelValues();
		OpenApplication();
		ClickForgetPassword();
		UserDetails();
		ClickFindLoginButton();
		//ValidationOfError();
		//CloseApplication();
	}

	private static void readExcelValues() throws IOException {
        FileInputStream fs = new FileInputStream("./ExcelWorkbook/IntegrationDemoWithExcel.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet = workbook.getSheetAt(0);
 
        for (Row row : sheet) {
            String element = row.getCell(1).getStringCellValue();
            Cell valueCell = row.getCell(2);
 
            readExcelValue.put(element, getStringCellValue(valueCell));
        }
        workbook.close();
    }
	
	  private static String getStringCellValue(Cell cell) {
	        if (cell == null) {
	            return null;
	        } else if (cell.getCellType() == CellType.STRING) {
	            return cell.getStringCellValue();
	        } else if (cell.getCellType() == CellType.NUMERIC) {
	            // here converting numeric value to string
	            return String.valueOf(cell.getNumericCellValue());
	        } else {
	            return null;
	        }
	    }
	
	private static WebDriver OpenApplication() {
		System.setProperty("WebDriver.chrome.driver",
				"C:/Users/DHARAJEN/Downloads/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://parabank.parasoft.com/");
		driver.manage().window().maximize();
		util = new ParasoftExcelUtil(driver);
		return driver;
	}

	private static void ClickForgetPassword() {
	//	util.Click(forgetinfo);
		util.Click(readExcelValue.get("forgetinfo"));
	}

	public static void UserDetails() {
//		util.Sendkeys(FirstName, Dhava);
//		util.Sendkeys(LastName, Vignesh);
//		util.Sendkeys(Address, HomeAddress);
//		util.Sendkeys(City, HomeCity);
//		util.Sendkeys(State, StateName);
//		util.Sendkeys(ZipCode, CityZipcode);
//		util.Sendkeys(Ssn, SsnCode);
		util.Sendkeys(readExcelValue.get("FirstName"),readExcelValue.get("Dhava"));
		util.Sendkeys(readExcelValue.get("LastName"), readExcelValue.get("Vignesh"));
		util.Sendkeys(readExcelValue.get("Address"), readExcelValue.get("HomeAddress"));
		util.Sendkeys(readExcelValue.get("City"), readExcelValue.get("HomeCity"));
		util.Sendkeys(readExcelValue.get("State"), readExcelValue.get("StateName"));
		util.Sendkeys(readExcelValue.get("ZipCode"), readExcelValue.get("CityZipcode"));
		util.Sendkeys(readExcelValue.get("Ssn"), readExcelValue.get("SsnCode"));
	}

	private static void ClickFindLoginButton() {
		//util.Click(FindLoginButtom);
		util.Click(readExcelValue.get("FindLoginButtom"));
	}

//	private static void ValidationOfError() {
//		Assert.assertEquals(ExpectedErrorMessage, util.GetText(ActualErrorMessage));
//	}

	private static void CloseApplication() {
		driver.quit();
	}

}
