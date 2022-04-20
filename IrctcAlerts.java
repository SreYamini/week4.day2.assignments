package week4.day2.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IrctcAlerts {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.irctc.co.in/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
		WebElement okAlert = driver.findElement(By.xpath("//button[text()='OK']"));
		
		Actions builder = new Actions(driver);
		
		builder.moveToElement(okAlert).click().perform();
		
		
		//Alert alert = driver.switchTo().alert();
		
		//alert.accept();
		
		driver.findElement(By.xpath("//a[text()=' FLIGHTS ']")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		List<String>	lsthandles = new ArrayList<String>(windowHandles);
		
		String flightWindow = lsthandles.get(1);
		
		driver.switchTo().window(flightWindow);
		
		String winFilghts = driver.getTitle();
		
		System.out.println(winFilghts);
		
		driver.close();
		
		driver.switchTo().window(lsthandles.get(0));
		
		String winTrains = driver.getTitle();
		
		System.out.println(winTrains);
	}

}
