package week4.day1.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Assignment1_HandleFrames {

	public static void main(String[] args) {
		ChromeOptions ch = new ChromeOptions();
		ch.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(ch);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		
		driver.switchTo().frame("frame1");
		driver.findElement(By.xpath("//input[1]")).sendKeys("Not a Friendly Topic");
		
		driver.switchTo().frame(0);
		driver.findElement(By.id("a")).click();
		
		driver.switchTo().defaultContent();// To come out of the frame
		
		driver.switchTo().frame(1);
		WebElement findElement = driver.findElement(By.xpath("//select[@class='col-lg-3']"));
		Select dd1 = new Select(findElement);
		dd1.selectByVisibleText("Baby Cat");
		
		
		
	}

}
