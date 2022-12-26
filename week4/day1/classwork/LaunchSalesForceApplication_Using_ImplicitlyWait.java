package week4.day1.classwork;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LaunchSalesForceApplication_Using_ImplicitlyWait {

	public static void main(String[] args) {
		ChromeOptions ch = new ChromeOptions();
		ch.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(ch);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); //will load the element immediately as soon it finds it
		
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com"); //Using id locator
		driver.findElement(By.id("password")).sendKeys("Testleaf$321"); //Using id locator
		driver.findElement(By.xpath("//input[@class='button r4 wide primary']")).click(); //Using className locator
		driver.findElement(By.xpath("(//div[@class='tooltipTrigger tooltip-trigger uiTooltip'])[6]")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();

	}

}
