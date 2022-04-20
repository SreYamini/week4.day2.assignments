package week4.day2.assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameScreenshot {

	public static void main(String[] args) throws IOException {
		
WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leafground.com/pages/frame.html");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.switchTo().frame(0);
		
		WebElement click1 = driver.findElement(By.xpath("(//button[text()='Click Me'])[1]"));
		
		driver.findElement(By.xpath("(//button[text()='Click Me'])[1]")).click();
		
		File screenshotAs = click1.getScreenshotAs(OutputType.FILE);
		
		File image = new File("./snaps/img.jpg");
		
		FileUtils.copyFile(screenshotAs, image);
		
		driver.switchTo().defaultContent();
		
		 List<WebElement> findElements = driver.findElements(By.tagName("iframe"));
		 
		
		 int size = findElements.size();
		 
		 System.out.println("The count of the frames visible to the main page"+size);
		
	
	}

}
