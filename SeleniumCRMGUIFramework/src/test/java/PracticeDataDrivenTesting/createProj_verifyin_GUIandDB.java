package PracticeDataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class createProj_verifyin_GUIandDB {

	public static void main(String[] args) throws SQLException {
		
		String projname="Gopika1";
		//create project in GUI using Selenium Code
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.get("http://106.51.90.215:8084/");
		driver.findElement(By.name("username")).sendKeys("rmgyantra");
		driver.findElement(By.name("password")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.linkText("Projects")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(projname);
		Select sel=new Select(driver.findElement(By.name("status")));
		sel.selectByIndex(2);
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		System.out.println("Project "+projname+" is created successfully");
		//verify in DB whether project is available or not
		Connection con=null;
		try {
		 Boolean flag=false;
		 Driver driverref=new Driver(); 
		 DriverManager.registerDriver(driverref);
		  con=DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects","root@%","root");
			System.out.println("-------------");
			Statement stmt=con.createStatement();
			ResultSet result=stmt.executeQuery("select * from project;");
			while(result.next()) {
				String actprojname=result.getString(4);
				if(projname.equals(actprojname)) {
					System.out.println(actprojname+" is available");
					flag=true;
				}}
			if(flag==false) {
			System.out.println(projname+"is not available");
			}
			}
		
		catch(Exception e) {}
		finally {
		con.close();
		}
	}

}
