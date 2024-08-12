package PracticeDataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.google.common.collect.Table.Cell;

public class CreatOrg_CmdTestScript {

	@Test
	public void createOrgtest()throws EncryptedDocumentException, IOException {
		//read data from command line
		String URL= System.getProperty("url");
		String BROWSER=System.getProperty("browser");
		String USERNAME=System.getProperty("username");
		String PASSWORD=System.getProperty("password");
		//generating random number
		Random random=new Random();
		int randomnum= random.nextInt(1000);
		
	    //read data from excel file
	    FileInputStream fis1=new FileInputStream("C:\\Users\\USER\\Documents\\excelddt.xlsx");
		Workbook wb= WorkbookFactory.create(fis1);
		Sheet sh=wb.getSheet("Sheet1");
		Row row=sh.getRow(0);
		String orgname=row.getCell(1).toString()+ randomnum;
		wb.close();
	   
	    WebDriver driver=null;
	    if(BROWSER.equalsIgnoreCase("firefox"))
	    	driver=new FirefoxDriver();
	    else if(BROWSER.equalsIgnoreCase("edge"))
	    	driver=new EdgeDriver();
	    else
	    	driver=new ChromeDriver();
	    driver.get(URL);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	    driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	    driver.findElement(By.id("submitbutton")).click();
	    driver.findElement(By.linkText("Organizations")).click();
	    driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	    driver.findElement(By.name("accountname")).sendKeys(orgname);
	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	    Actions a=new Actions(driver);
	    a.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).click().perform();
	    driver.findElement(By.linkText("Sign Out")).click();
	}

}
