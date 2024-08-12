package practice_orgtest;

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

public class CreateNewOrgwithPhoneNum {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		  //read data from property file
		FileInputStream fis=new FileInputStream("C:\\Users\\USER\\eclipse-workspace\\SeleniumCRMGUIFramework\\src\\main\\resources\\Commondata_vtiger.java");
		Properties pobj=new Properties();
		pobj.load(fis);
		String URL= pobj.getProperty("url");
		String BROWSER=pobj.getProperty("browser");
		String USERNAME=pobj.getProperty("username");
		String PASSWORD=pobj.getProperty("password");
		//generating random number
		Random random=new Random();
		int randomnum= random.nextInt(1000);
		
	    //read data from excel file
	    FileInputStream fis1=new FileInputStream("C:\\Users\\USER\\Documents\\excelddt.xlsx");
	    Workbook wb= WorkbookFactory.create(fis1);
		Sheet sh=wb.getSheet("org");
		Row row=sh.getRow(1);
		String orgname=row.getCell(2).toString()+ randomnum;
		Row row1=sh.getRow(4);
		String phone=row1.getCell(3).toString();
		wb.close();
		
	   
	    WebDriver driver=null;
	    if(BROWSER.equalsIgnoreCase("firefox"))
	    	driver=new FirefoxDriver();
	    else if(BROWSER.equalsIgnoreCase("edge"))
	    	driver=new EdgeDriver();
	    else
	    	driver=new ChromeDriver();
	    driver.get(URL);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	    driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	    driver.findElement(By.id("submitbutton")).click();
	    driver.findElement(By.linkText("Organizations")).click();
	    driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	    driver.findElement(By.name("accountname")).sendKeys(orgname);
	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	    
	    //enter phno 
	    driver.findElement(By.name("phone")).sendKeys(phone);
	    
	    //verifying that phno is displayed or not
	    String headername=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	    if(headername.contains(orgname))
	    	System.out.println(orgname+" is created");
	    else
	    	System.out.println(orgname+" is not created");
	    String actphno=driver.findElement(By.id("dtlview_Phone")).getText();
	    if(phone.equalsIgnoreCase(actphno))
	        System.out.println(phone+" is present ");
	    else
	    	System.out.println(phone+" is not present ");
	    
	    Actions a=new Actions(driver);
	    a.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).click().perform();
	    driver.findElement(By.linkText("Sign Out")).click();
	    driver.quit();
	}

}