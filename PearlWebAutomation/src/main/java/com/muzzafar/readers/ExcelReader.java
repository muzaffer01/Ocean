package com.muzzafar.readers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.muzzafar.util.Configuration;

import net.bytebuddy.implementation.bytecode.Throw;

public class ExcelReader {
	
	public XSSFSheet readFile(String fileName,String SheetName) {
		FileInputStream testdatareader = null;
		  XSSFWorkbook xfile = null;
		try {
			testdatareader = new FileInputStream(fileName);
			//Reading the complete file along with sheets
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			xfile = new XSSFWorkbook(testdatareader);
			//reading workbook with multiple sheet
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		XSSFSheet getsheetvalue=xfile.getSheet(SheetName);
		 //read specific sheet
		 return getsheetvalue;
	}
	
	
	
	
	public String readexcel(int myrow, int mycol, String mysheetname) throws Exception {
		XSSFSheet mygetsheetvalue = readFile(Configuration.PROJECT_PATH + "/src/test/resources/TestData.xlsx",mysheetname);
		Cell cell = mygetsheetvalue.getRow(myrow - 1).getCell(mycol - 1);
		if (cell != null) {
			String value = mygetsheetvalue.getRow(myrow - 1).getCell(mycol - 1).getStringCellValue();
			return value;

		} else {
			System.out.println("Cell is NUll ...at " + myrow + " RowNum And ColNum" + mycol);
			throw new Exception("Cell value is Null...");
		}
	}

	public static void main(String[] args) throws Exception {
		ExcelReader r = new ExcelReader();
		try {
			String valu = r.readexcel(3, 1, "TestData");
			System.out.println(valu);

			String valu1 = r.readexcel(5, 1, "TestData");
			System.out.println(valu1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
