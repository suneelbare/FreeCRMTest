package com.crm.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase
{
	public static long PAGE_LOAD_TIMEOUT = 80;
	public static long 	IMPLICIT_WAIT = 80;
	
	public static String TESTDATA_SHEET_PATH="C:\\Users\\Suneel Govinda Bare\\workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCRMTestData.xlsx";
	
	static Workbook book;
	static Sheet sheet;
	
	public void switchToFrame()
	{
		driver.switchTo().frame("mainpanel");
	}
	
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet =  book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		 
		 System.out.println("FirstRowNum: "+sheet.getFirstRowNum());
		 System.out.println("LastRowNum: "+sheet.getLastRowNum());
		 System.out.println("Row 0 FirstCellNum "+sheet.getRow(0).getFirstCellNum());
		 System.out.println("Row 0 LastCellNum "+sheet.getRow(0).getLastCellNum());
		 System.out.println("Row 0 Cell 3 Data "+sheet.getRow(0).getCell(3));
		 
		 for (int i = 0; i < (sheet.getLastRowNum()); i++) {
			for (int j = 0; j<=1; j++) {
				data[i][j] = (sheet).getRow(i+1).getCell(j).toString();
				System.out.println("i= "+i+" j= "+j);
				System.out.println(data[i][j]);
			}
		}
		return data;
	}
}
