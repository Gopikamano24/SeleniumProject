package PracticeDataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Write_data_ToExcelFile {

		public static void main(String[] args) throws EncryptedDocumentException, IOException {
			FileInputStream fis=new FileInputStream("C:\\\\Users\\\\USER\\\\Documents//excelddt.xlsx");
			Workbook wb= WorkbookFactory.create(fis);
			Sheet sh=wb.getSheet("Sheet1");
			 Row row=sh.getRow(0);
			 Cell cell=row.createCell(4);	
			 cell.setCellType(CellType.STRING);//derive the cell type as what kind of
			 //value we are going to write
			 cell.setCellValue("Good");//pass value
			 FileOutputStream fos=new FileOutputStream("C:\\Users\\USER\\Documents//excelddt.xlsx");
			 wb.write(fos);//to save that file 
			 wb.close();
			 System.out.println("...........");
	}

}
