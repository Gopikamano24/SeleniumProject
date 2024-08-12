package PracticeDataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Read_Data_BasedOn_Condition {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//saving test case no, whose details i need to get
		String expectedTestId="tc_03";
		//declare the container for no of column i have to get 
		String data1="";
		String data2="";
		String data3="";
		//declare one boolean container and make it false, if it went inside loop make
		//it as true so we can identify that data is present if its not present provide 
		//else condition
		Boolean flag=false;
	    FileInputStream fis=new FileInputStream("C:\\\\Users\\\\USER\\\\Documents//excelddt.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Sheet1");
		int count = sh.getLastRowNum();
		for(int i=0;i<=count;i++)//i denotes column where i have to check first column
		{
          //declare container for getting column one
			String data="";
		//some cell are null so it may throw exception, so to ignore that null cell
			//we are using try and catch
		try{
			data=sh.getRow(i).getCell(0).toString();//get that data to compare whether 
			//its present or not
			if(data.equals(expectedTestId)) {
				flag=true;//here it becomes true so data is present
				data1=sh.getRow(i).getCell(1).toString();
				data2=sh.getRow(i).getCell(2).toString();
				data3=sh.getRow(i).getCell(3).toString();
			}
			}
		catch(Exception e) {}
		}
		if(flag==true) {//if data is present print values
			System.out.println(data1);
			System.out.println(data2);
			System.out.println(data3);
		}
		else {//if not print its not present
			System.out.println(expectedTestId+" data is not available");
		}
		wb.close();
	} 
	
	}

