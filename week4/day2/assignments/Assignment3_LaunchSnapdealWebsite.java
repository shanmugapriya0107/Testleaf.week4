package week4.day2.assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Assignment3_LaunchSnapdealWebsite {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeOptions ch = new ChromeOptions();
		ch.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(ch);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); 
		driver.get("https://www.snapdeal.com/");
		
		WebElement findElement = driver.findElement(By.xpath("(//span[@class='catText'])[1]"));
		Actions builder = new Actions(driver);
		builder.moveToElement(findElement).perform();
		
		driver.findElement(By.xpath("(//span[text()='Sports Shoes'])[1]")).click();
		String text = driver.findElement(By.xpath("(//div[@class='child-cat-count '])[2]")).getText();
		System.out.println("The count of Sports Shoes is " +text);
		
		driver.findElement(By.xpath("(//div[@class='child-cat-name '])[2]")).click();
		driver.findElement(By.xpath("//i[@class='sd-icon sd-icon-expand-arrow sort-arrow']")).click();
		driver.findElement(By.xpath("(//i[@class='sd-icon sd-icon-expand-arrow sort-arrow']//following::li)[2]")).click();
		
		driver.findElement(By.name("fromVal")).clear();
		driver.findElement(By.name("fromVal")).sendKeys("900");
		driver.findElement(By.name("toVal")).clear();
		driver.findElement(By.name("toVal")).sendKeys("1200");
		driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='filter-color-tile Yellow ']")).click();
		String text2 = driver.findElement(By.xpath("//a[contains(text(),' Yellow')]")).getText();
		System.out.println(text2);
		if(text2.equals("Yellow"))
		{
			System.out.println("Yellow colour filter applied");
		}
		else
		{
			System.out.println("Yellow filter not applied");
		}
		WebElement findElement2 = driver.findElement(By.xpath("//p[@class='product-title']"));
		Actions builder1 = new Actions(driver);
		builder1.moveToElement(findElement2).perform();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='center quick-view-bar  btn btn-theme-secondary  ']")).click();
		
		String text3 = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
		System.out.println("The price of the shoe is " +text3);
		String text4 = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
		System.out.println(text4);
		
		File source = driver.getScreenshotAs(OutputType.FILE);
		File target = new File("./snaps/Snapdeal_Shoe.png");
		FileUtils.copyFile(source, target);
		
		driver.findElement(By.xpath("(//i[@class='sd-icon sd-icon-delete-sign'])[3]")).click();
		
		Thread.sleep(3000);
		driver.close();
		
	}
	

}
