package readers;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public String readexcel(int myrow, int mycol, String mysheetname) throws IOException {
		
		FileInputStream testdatareader = new FileInputStream("D:\\java eclipse\\MyProjects\\Ocean\\PearlWebAutomation\\src\\test\\resources\\TestData.xlsx");
		//D:\java eclipse\MyProjects\Ocean\PearlWebAutomation\src\test\resources\TestData.xlsx
		  XSSFWorkbook xfile= new XSSFWorkbook(testdatareader);// for .xlsx file type
		  
		  
		 XSSFSheet getsheetvalue=xfile.getSheet(mysheetname);
		   
		  String Value=getsheetvalue.getRow(myrow).getCell(mycol).toString();
		  
		return  Value;
		  
			
			/*
			 * int last=getsheetvalue.getLastRowNum();
			 * 
			 * for (int i = 0; i <=last; i++) {
			 * 
			 * String value=getsheetvalue.getRow(i).getCell(0).toString();
			 * 
			 * System.out.println(value);
			 * 
			 * }
			 */			 
		
	}
	/*
	 * public static void main(String[] args) throws IOException {
	 * 
	 * TestDataReader readobj= new TestDataReader();
	 * readobj.readexcel(2,5,"TestData");
	 * 
	 * 
	 * 
	 * }
	 */

}
