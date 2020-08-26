package com.muzzafar.readers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.muzzafar.util.Configuration;

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

	public String readexcel(int myrow, int mycol, String mysheetname) throws IOException {
		XSSFSheet getsheetvalue=readFile(Configuration.PROJECT_PATH+"/src/test/resources/TestData.xlsx", mysheetname);
		String Value=getsheetvalue.getRow(myrow).getCell(mycol).toString();
		return  Value;	
	}
	
	
	/*
	 * public static void main(String[] args) { ExcelReader r= new ExcelReader();
	 * try { String valu=r.readexcel(0, 0, "TestData"); System.out.println(valu); }
	 * catch (IOException e) { e.printStackTrace(); } }
	 */

}
