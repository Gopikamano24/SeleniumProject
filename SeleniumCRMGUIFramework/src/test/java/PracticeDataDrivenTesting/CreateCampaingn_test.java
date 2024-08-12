package PracticeDataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class CreateCampaingn_test {
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
	    driver.findElement(By.linkText("More")).click();
	    driver.findElement(By.linkText("Campaigns")).click();
	    driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
	    //read data from excel sheet
	    FileInputStream fis=new FileInputStream("C:\\Users\\USER\\Documents//excelddt.xlsx");
	    Workbook wb= WorkbookFactory.create(fis);
	    String campname=wb.getSheet("Sheet2").getRow(1).getCell(0).getStringCellValue()+randomnum;
	    String leadname=wb.getSheet("Sheet2").getRow(3).getCell(0).getStringCellValue()+randomnum;
	    String leadcompany=wb.getSheet("Sheet2").getRow(3).getCell(1).getStringCellValue()+randomnum;
	    
	    driver.findElement(By.name("campaignname")).sendKeys(campname);
	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	    System.out.println("campaign is created");
	    driver.findElement(By.linkText("Leads")).click();
	    driver.findElement(By.xpath("//img[@alt='Create Lead...']")).click();
	    driver.findElement(By.name("lastname")).sendKeys(leadname);
	    driver.findElement(By.name("company")).sendKeys(leadcompany);
	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	    System.out.println("Lead is created");
	    driver.findElement(By.linkText("Convert Lead")).click();
	    driver.findElement(By.xpath("//div[@id='convertleaddiv']//td[@align='center']/input[@type='submit']")).click();
	    System.out.println("Lead converted");
	}
}
