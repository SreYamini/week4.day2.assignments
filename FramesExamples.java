package week4.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesExamples {

	public static void main(String[] args) {
		
WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.switchTo().frame(0);
		
		driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input")).sendKeys("Learn frames");
		
		WebElement frame3 = driver.findElement(By.xpath("//iframe[@id='frame3']"));
		
		driver.switchTo().frame(frame3);
	
		driver.findElement(By.xpath("//b[text()='Inner Frame Check box :']/following-sibling::input")).click();
		
		driver.switchTo().defaultContent();
		
		WebElement frame2 = driver.findElement(By.xpath("//iframe[@id='frame2']"));
		
		driver.switchTo().frame(frame2);
		
		WebElement selectAnimals = driver.findElement(By.xpath("//select[@id='animals']"));
		
		Select animals = new Select(selectAnimals);
		
		animals.selectByIndex(3);
		
	}

}
