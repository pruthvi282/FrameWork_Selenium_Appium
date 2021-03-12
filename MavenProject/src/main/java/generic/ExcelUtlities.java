package generic;

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

/**
 * 
 * @author Admin
 *
 */
public class ExcelUtlities {
	public String excel(String excelpath, String Sheetname, int rownum, int cellnum)
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		FileInputStream fis = new FileInputStream(excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet she = wb.getSheet(Sheetname);
		Row ro = she.getRow(rownum);
		Cell ce = ro.getCell(cellnum);
		String strin = ce.getStringCellValue();
		return strin;

	}

	/**
	 * To get Number of rows
	 * @param excelpath
	 * @param Sheetname
	 * @return
	 * @throws Throwable
	 */
	public int getrowcount(String excelpath, String Sheetname) throws Throwable {
		FileInputStream fis = new FileInputStream(excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet she = wb.getSheet(Sheetname);
		return she.getLastRowNum();
	}

	/**
	 * To write Data To Excel
	 * @param excelpath
	 * @param Sheetname
	 * @param rownum
	 * @param cellnum
	 * @param cellval
	 * @throws Throwable
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	public void writetoexcel(String excelpath, String Sheetname, int rownum, int cellnum, String cellval)
			throws Throwable {
		FileInputStream fis = new FileInputStream(excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet she = wb.getSheet(Sheetname);
		Row ro = she.getRow(rownum);
		Cell ce = ro.getCell(cellnum);
		ce.setCellValue(cellval);
		FileOutputStream fos = new FileOutputStream(excelpath);
		wb.write(fos);
	}

	/**
	 * used to read the data from excel workbook based on testId & ColumnHeader
	 * 
	 * @param sheetName
	 * @param expTestID
	 * @param expColHEader
	 * @return
	 * @throws Throwable
	 */
	public String getExcelData(String excelpath, String sheetName, String expTestID, String expColHEader)
			throws Throwable {

		int expTestRow = 0;
		int expHeader = 0;
		FileInputStream fis = new FileInputStream(excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int rowCount = sh.getLastRowNum();

		for (int i = 0; i < rowCount; i++) {
			Row row = sh.getRow(i);
			String zeroColData = row.getCell(0).getStringCellValue();
			if (expTestID.contentEquals(zeroColData)) {
				// System.out.println("test is availbale");
				expTestRow = i;
				break;
			}
		}

		int expColHeader = expTestRow - 1;

		int colCount = sh.getRow(expColHeader).getLastCellNum();
		for (int j = 0; j < colCount; j++) {
			String actColHeader = sh.getRow(expColHeader).getCell(j).getStringCellValue();
			if (actColHeader.equals(expColHEader)) {
				// System.out.println("header is avibale ");
				expHeader = j;
				break;
			}
		}

		return sh.getRow(expTestRow).getCell(expHeader).getStringCellValue();

	}
}
