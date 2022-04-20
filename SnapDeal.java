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
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.snapdeal.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement mens = driver.findElement(By.xpath("(//span[@class='catText'])[1]"));
		
		Actions builder = new Actions(driver);
		
		builder.moveToElement(mens).perform();
		
		driver.findElement(By.xpath("(//span[text()='Sports Shoes'])[1]")).click();
		
		String count = driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText();
		
		System.out.println("the count of the sports shoes "+count);
		
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//span[text()='Sort by:']")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//li[@data-sorttype='plth']")).click();
		
		Thread.sleep(5000);
		//Check if the items displayed are sorted correctly
		
		java.util.List<WebElement> sorted = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		
		for (WebElement webElement : sorted) {
			
			String sortedtext = webElement.getText();
			
			System.out.println("list of brand of the products displayed in the page "+sortedtext);
		}
		
		driver.findElement(By.xpath("//input[@name='fromVal']")).clear();
		driver.findElement(By.xpath("//input[@name='fromVal']")).sendKeys("900");
		
		
		driver.findElement(By.xpath("//input[@name='toVal']")).clear();
		driver.findElement(By.xpath("//input[@name='toVal']")).sendKeys("1699");
		
		driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//label[@for='Color_s-White']")).click();
		
		Thread.sleep(3000);
		
		String filterShoes = driver.findElement(By.xpath("//div[@class='filters']")).getText();
		
		if(filterShoes.contains("900-1699") || filterShoes.contains("White")) {
			
			System.out.println("The filter is applied");
		}
		
		else {
			System.out.println("The filter is not applied");
		}
		
		WebElement firstShoe = driver.findElement(By.xpath("//picture[@class='picture-elem']//img"));
		
		Actions builder1 = new Actions(driver);
		
		builder1.moveToElement(firstShoe).perform();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[@class='clearfix row-disc']//div")).click();
		
		Thread.sleep(3000);
		
		String cost = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
		
		System.out.println("the cost is "+cost);
		
		String discount = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
		
		System.out.println("the discount is "+discount);
		
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		
		File image = new File("./snaps/img1.jpg");
		
		FileUtils.copyFile(screenshotAs, image);

		driver.close();
		
	}
		
		/*
			13. Print the cost and the discount percentage
			14. Take the snapshot of the shoes.
			15. Close the current window
			16. Close the main window
*/

	

}
