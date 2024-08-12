package PracticeDataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Read_Multiple_data_Excel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("C:\\\\Users\\\\USER\\\\Documents//excelddt.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Sheet1");
		int count = sh.getLastRowNum();
		for(int i=1;i<=count;i++)
		{
			Row row=sh.getRow(i);
			String column1=row.getCell(0).toString();
			String column2=row.getCell(0).getStringCellValue();
			System.out.println(column1 +"\t"+column2);
			
		}
		wb.close();
	}

}
