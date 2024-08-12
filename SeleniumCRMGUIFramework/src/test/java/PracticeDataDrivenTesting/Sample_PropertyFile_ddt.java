package PracticeDataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Sample_PropertyFile_ddt {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("C:\\Users\\USER\\Desktop\\commondata.properties");
		
		Workbook wb=WorkbookFactory.create(fis);
		String organisation=wb.getSheet("org").getRow(1).getCell(1).getStringCellValue();
		
		Properties pobj=new Properties();
		pobj.load(fis);
		 
	    String BROWSER= pobj.getProperty("browser");
	    String URL= pobj.getProperty("url");
	    String USERNAME= pobj.getProperty("username");
	    String PASSWORD= pobj.getProperty("password");
	    
	    WebDriver driver=null;
	    if(BROWSER.equalsIgnoreCase("firefox"))
	    	driver=new FirefoxDriver();
	    else if(BROWSER.equalsIgnoreCase("edge"))
	    	driver=new EdgeDriver();
	    else
	    	driver=new ChromeDriver();
	    driver.get(URL);
	    driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	    driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	    driver.findElement(By.id("submitbutton")).click();
	    driver.findElement(By.linkText("Organizations")).click();
	    driver.findElement(By.partialLinkText("Create an")).click();
	}

}
