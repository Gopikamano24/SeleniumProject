package practice_contactstest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateContactwithOrgtest {

	public static void main(String[] args) throws IOException {
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
		Row row=sh.getRow(4);
		String orgname=row.getCell(2).toString()+ randomnum;
		String contactlastname=row.getCell(3).toString()+ randomnum;
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
	    String parentwd=driver.getWindowHandle();
	    driver.findElement(By.linkText("Organizations")).click();
	    driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	    driver.findElement(By.name("accountname")).sendKeys(orgname);
	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	    
	    
	    //verifying that orgname is displayed or not
	    String headername=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	    if(headername.contains(orgname))
	    	System.out.println(orgname+" is created");
	    else
	    	System.out.println(orgname+" is not created");
	    //navigate to contact module
	    driver.findElement(By.linkText("Contacts")).click();
	    driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
	    driver.findElement(By.name("lastname")).sendKeys(contactlastname);
	    driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
	    //switch to child window
	    Set<String> set=driver.getWindowHandles();
	    Iterator<String> it=set.iterator();
		while(it.hasNext()) {
	    	 String windowId = it.next();
	    	 driver.switchTo().window(windowId);
	    	 
	    	 String actUrl=driver.getCurrentUrl();
	    	 if(actUrl.contains("Accounts&action"))
	    		 break;
		}
	    driver.findElement(By.name("search_text")).sendKeys(orgname);
	    driver.findElement(By.name("search")).click();
	    driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
	    //dynamic xpath
	    //xpath that changes during runtime
	    
	    //switch to parent window
   	    driver.switchTo().window(parentwd);
	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	    //verifying that contact page is displayed or not
	    String headername1=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	    if(headername1.contains(contactlastname))
	    	System.out.println(contactlastname+" is created");
	    else
	    	System.out.println(contactlastname+" is not created");
	    //verify that organization is visible or not
	    String actorgname=driver.findElement(By.id("mouseArea_Organization Name")).getText();
	    if(actorgname.trim().equals(orgname))
	    	System.out.println(orgname+" is created");
	    else
	    	System.out.println(orgname+" is not created");
	    //logout
	    Actions a=new Actions(driver);
	    a.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).click().perform();
	    driver.findElement(By.linkText("Sign Out")).click();
	    driver.quit();
	}

}
