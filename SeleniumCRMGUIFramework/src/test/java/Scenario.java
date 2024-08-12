import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario {



	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.hotstar.com/in/home?ref=%2Fin");
		driver.findElement(By.xpath("//i[@class='icon-search-line soul-icon NAV_ICON_FONT_SIZE']")).click();
		driver.findElement(By.id("searchBar")).sendKeys("Family man");
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//div/span[text()='Special Ops - The biggest digital show']"))).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//i[@class='icon-play-fill soul-icon ON_IMAGE_ALT ICON_FONTSIZE_04']")).click();
		Thread.sleep(4000);
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./ScreenshotGG/film.png"));
		driver.quit();
	}

}


