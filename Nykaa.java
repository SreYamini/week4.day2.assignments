package week4.day2.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		
WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.nykaa.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));
		
		Actions builder = new Actions(driver);
		
		builder.moveToElement(brands).perform();
		
		driver.findElement(By.xpath("(//div[@id='brandCont_Popular']//a)[5]")).click();
		
		String titleLoreal = driver.getTitle();
		
		if(titleLoreal.contains("L'Oreal Paris")) {
			
			System.out.println("In Loreal Paris Page");
		}
		
		else {
			System.out.println("Not in Loreal Paris Page");
		}
		
		driver.findElement(By.xpath("//div[@id='filter-sort']/div/div/button")).click();
		
		driver.findElement(By.xpath("//label[@for='radio_customer top rated_undefined']//div[2]")).click();
		
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		
		driver.findElement(By.xpath("//label[@for='checkbox_Shampoo_316']//div[2]")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		
		driver.findElement(By.xpath("//label[@for='checkbox_Tangled Hair_10715']//div[2]")).click();
		
		 String filtersApplied = driver.findElement(By.xpath("//div[@id='filters-listing']/div[1]/div[2]")).getText();
		
		System.out.println(filtersApplied);
		
		if(filtersApplied.contains("Shampoo")) {
			
			System.out.println("Shampoo filtered");
		}
		else {
			System.out.println("Shampoo not filtered");
		}
		
		driver.findElement(By.xpath("//div[@class='product-listing']//div[2]/div[1]")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		List<String> lsthandles = new ArrayList<String>(windowHandles);
		
		driver.switchTo().window(lsthandles.get(1));
		
		Thread.sleep(3000);
		
		WebElement sizesh = driver.findElement(By.xpath("//select[@title='SIZE']"));
		
		Select sizeShampoo = new Select(sizesh);
		
		sizeShampoo.selectByIndex(2);
		
		String textMRP = driver.findElement(By.xpath("//span[text()='₹159']")).getText();
		
		System.out.println("The MRP of the product "+textMRP);
		
		driver.findElement(By.xpath("//button[@type='button']/span[text()='ADD TO BAG']")).click();
		
		driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
		
		driver.switchTo().frame(0);
		
		String grandTotal = driver.findElement(By.xpath("//div[@class='first-col']//div")).getText();
		
		System.out.println("Grand Total amount "+grandTotal);
		
		driver.findElement(By.xpath("//span[text()='PROCEED']")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();
		
		String confirmTotal = driver.findElement(By.xpath("//div[@class='payment-details-tbl grand-total-cell prl20']")).getText();
	
		if(confirmTotal.contains(grandTotal)){
			
			System.out.println("The total is same");
		}
		
		else {
			
			System.out.println("The total is different");
		}
		
		driver.quit();

	}

}
