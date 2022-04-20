package week4.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Resizable {

	public static void main(String[] args) {
	
WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://jqueryui.com/resizable");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.switchTo().frame(0);
		
		WebElement resize = driver.findElement(By.xpath("//div[@id='resizable']//div[3]"));
		
		Actions builder = new Actions(driver);
		
		
		int x = resize.getLocation().getX();
		
		int y = resize.getLocation().getY();
		
		System.out.println(x);
		System.out.println(y);
		
		builder.clickAndHold(resize).moveByOffset(50, 50).release().perform();

	}

}
