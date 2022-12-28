package week4.day2.classwork;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class LaunchSnapdealWebsite_Using_Actions {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions ch = new ChromeOptions();
		ch.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(ch);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); 
		driver.get(" https://www.snapdeal.com/");
		
		WebElement findElement = driver.findElement(By.xpath("//span[@class='catText']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(findElement).perform();
		
		driver.findElement(By.xpath("(//span[text()='Shirts'])[1]")).click();
		
		WebElement findElement2 = driver.findElement(By.xpath("(//img[@class='product-image '])[1]"));
		Actions builder1 = new Actions(driver);
		builder1.moveToElement(findElement2).perform();
		
		driver.findElement(By.xpath("(//div[@class='center quick-view-bar  btn btn-theme-secondary  '])[1]")).click();
		Thread.sleep(2000);
		driver.close();

	}

}
