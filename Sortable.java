package week4.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sortable {

	public static void main(String[] args) {
		
WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://www.leafground.com/pages/sortable.html");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement item2 = driver.findElement(By.xpath("//ul[@id='sortable']/li[text()='Item 2']"));
		
		WebElement item4 = driver.findElement(By.xpath("//ul[@id='sortable']/li[text()='Item 4']"));
		
		WebElement item6 = driver.findElement(By.xpath("//ul[@id='sortable']/li[text()='Item 6']"));
		
		WebElement item1 = driver.findElement(By.xpath("//ul[@id='sortable']/li[text()='Item 1']"));
		
		Actions builder = new Actions(driver);
		
		//builder.clickAndHold(item1).moveToElement(item4).release().perform();
		
		//builder.clickAndHold(item6).moveToElement(item2).release().perform();
		
		builder.dragAndDrop(item1, item4).dragAndDrop(item2, item6).perform();
		
		
	}

}
