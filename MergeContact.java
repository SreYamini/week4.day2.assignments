package week4.day2.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		driver.findElement(By.linkText("Contacts")).click();
		
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		List<String> lsthandles = new ArrayList<String>(windowHandles);
		
		String newWindow = lsthandles.get(1);
		
		driver.switchTo().window(newWindow);
		
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a[1]")).click();
		
		driver.switchTo().window(lsthandles.get(0));
		
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		
		Set<String> windowHandles2 = driver.getWindowHandles();
		
		List<String> toWin = new ArrayList<String>(windowHandles2);
		
		String toMerge = toWin.get(1);
		
		driver.switchTo().window(toMerge);
		
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")).click();
		
		driver.switchTo().window(toWin.get(0));
		
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		
		Alert alert = driver.switchTo().alert();
		
		alert.accept();
		
		String title = driver.getTitle();
		
		if(title.contains("View Contact")) {
			
			System.out.println("The contact is merged");
		}
		
		else {
			System.out.println("The contact is not merged");
		}
	}

}
