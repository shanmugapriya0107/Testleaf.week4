package week4.day2.assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Assignment4_LaunchAmazonWebsite {

	public static void main(String[] args) throws IOException, InterruptedException {
		ChromeOptions ch = new ChromeOptions();
		ch.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(ch);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); 
		driver.get("https://www.amazon.in/");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro", Keys.ENTER);
		String text = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[4]")).getText();
		System.out.println(text);
		String text2 = driver.findElement(By.xpath("(//span[@class='a-size-base s-underline-text'])[1]")).getText();
		System.out.println(text2);
		
		driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> listOfHandles = new ArrayList<String>(windowHandles);
		driver.switchTo().window(listOfHandles.get(1));
		
		File source = driver.getScreenshotAs(OutputType.FILE);
		File target = new File("./snaps/Oneplus 9 pro.png");
		FileUtils.copyFile(source, target);
		
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		
		Thread.sleep(3000);
		if(text.equals("66,999"))
		{
			System.out.println("Both the prices are same");
		}
		else
		{
			System.out.println("Both the prices are different");
		}
		Thread.sleep(3000);
		driver.quit();
	
	
	}
	
	

}
