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
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleTestjdbc {
@Test
public void Projectcheck() throws SQLException {
	Boolean flag=false;
	Driver driverref=new Driver();
	DriverManager.registerDriver(driverref);
	Connection con=DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects","root@%","root");
	System.out.println("-------------");
	Statement stmt=con.createStatement();
	int result=stmt.executeUpdate("insert into project values('TY_PROJ_1047', 'gopika', '25/07/2024', 'gopika_24', 'Created', 3);");
	con.close();
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
	driver.get("http://106.51.90.215:8084/");
	driver.findElement(By.name("username")).sendKeys("rmgyantra");
	driver.findElement(By.name("password")).sendKeys("rmgy@9999");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	driver.findElement(By.linkText("Projects")).click();
	driver.findElement(By.xpath("//select[@class='form-control']/option[@value='projectName']")).click();
	driver.findElement(By.xpath("//input[@placeholder='Search by Project Id']")).sendKeys("gopika_24");
	
}		

}
