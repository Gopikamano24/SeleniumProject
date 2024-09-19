package ddt;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String getDataFromExcel(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis=new FileInputStream("./testdata/testScriptdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String data=wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		return data;
	}
	
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./testdata/testScriptdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		int rowcount=wb.getSheet(sheetName).getLastRowNum();
		return rowcount;
	}
	public void setDataIntoExcel(String sheetName, int rowNum, int cellNum, String data) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./testdata/testScriptdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Row row=wb.getSheet(sheetName).getRow(rowNum);
		Cell cell=row.createCell(cellNum);
		cell.setCellValue(data);
		
		FileOutputStream fos=new FileOutputStream("./testdata/testScriptdata.xlsx");
		wb.write(fos);
		wb.close();
	}
	
}
