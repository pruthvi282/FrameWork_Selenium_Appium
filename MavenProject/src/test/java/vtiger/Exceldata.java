package vtiger;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Exceldata {
	public String excel(String Sheetname,int rownum,int cellnum) throws EncryptedDocumentException, InvalidFormatException, IOException{
FileInputStream fis=new FileInputStream("./Excel/org.xlsx");	
Workbook wb = WorkbookFactory.create(fis);
Sheet she = wb.getSheet(Sheetname);
Row ro = she.getRow(rownum);
Cell ce = ro.getCell(cellnum);
String strin = ce.getStringCellValue();
		return strin;
		
	}

	public int getrowcount(String Sheetname) throws Throwable{
		FileInputStream fis=new FileInputStream("./Excel/test.xlsx");	
		Workbook wb = WorkbookFactory.create(fis);
		Sheet she = wb.getSheet(Sheetname);
		return  she.getLastRowNum();
	}
	public void writetoexcel(String Sheetname,int rownum,int cellnum,String cellval) throws Throwable, InvalidFormatException, IOException{
		FileInputStream fis=new FileInputStream("./Excel/test.xlsx");	
		Workbook wb = WorkbookFactory.create(fis);
		Sheet she = wb.getSheet(Sheetname);
		Row ro = she.getRow(rownum);
		Cell ce = ro.getCell(cellnum);
		ce.setCellValue(cellval);
		FileOutputStream fos=new FileOutputStream("./Excel/test.xlsx");
		wb.write(fos);
		
		
	}

}
