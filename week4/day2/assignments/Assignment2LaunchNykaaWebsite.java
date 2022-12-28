package week4.day2.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Assignment2LaunchNykaaWebsite {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions ch = new ChromeOptions();
		ch.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(ch);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); 
		driver.get("https://www.nykaa.com/");
		
		WebElement findElement = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(findElement).perform();
		
		driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal Paris", Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='css-ov2o3v'])[1]//a")).click();
		
		String title = driver.getTitle();
		System.out.println(title);
		if(title.contains("L'Oreal Paris"))
		{
			System.out.println("The title contains L'Oreal Paris");
		}
		else
		{
			System.out.println("The title does not contain L'Oreal Paris");
		}
		driver.findElement(By.xpath("(//*[name()='svg'])[8]")).click();
		driver.findElement(By.xpath("(//div[@class='control-indicator radio '])[3]")).click();
		driver.findElement(By.xpath("(//*[name()='svg'])[9]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//*[name()='svg'])[11]")).click();
		driver.findElement(By.xpath("(//*[name()='svg'])[11]")).click();
		driver.findElement(By.xpath("(//div[@class='control-indicator checkbox '])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='css-xdicx1'])[6]")).click();
		driver.findElement(By.xpath("(//div[@class='control-indicator checkbox '])[9]")).click();
		Thread.sleep(3000);
		String text = driver.findElement(By.xpath("//span[text()='Shampoo']")).getText();
		System.out.println(text);
		if(text.equals("Shampoo"))
		{
			System.out.println("Filter applied as Shampoo");
		}
		else
		{
			System.out.println("Filter not applied as Shampoo");
		}
		driver.findElement(By.xpath("(//div[@class='css-xrzmfa'])")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> listOfHandles = new ArrayList<String>(windowHandles);
		driver.switchTo().window(listOfHandles.get(1));
		driver.manage().window().maximize();
		
		WebElement findElement2 = driver.findElement(By.xpath("(//select[@class='css-2t5nwu'])"));
		Select dd1 = new Select(findElement2);
		dd1.selectByVisibleText("175ml");
		
		String text2 = driver.findElement(By.xpath("(//span[@class='css-1jczs19'])[1]")).getText();
		System.out.println("Rs=" +text2);
		
		driver.findElement(By.xpath("(//span[@class='btn-text'])[1]")).click();
		driver.findElement(By.xpath("(//span[@class='cart-count'])")).click();
		Thread.sleep(3000);
		
		WebElement findElement3 = driver.findElement(By.xpath("//iframe[@class='css-acpm4k']"));
		driver.switchTo().frame(findElement3);
		String text3 = driver.findElement(By.xpath("//span[@class='css-1um1mkq e171rb9k3']")).getText();
		System.out.println("The Grand Total is " +text3);
		
		driver.findElement(By.xpath("//span[@class=' css-1l4d0ex e171rb9k3']")).click();
		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("(//button[@class='css-110s749 e8tshxd1'])[2]")).click();
		driver.findElement(By.xpath("//span[@class='css-175whwo ehes2bo0']")).click();
		
		String text4 = driver.findElement(By.xpath("//p[@class='css-cla92e eka6zu20']")).getText();
		System.out.println(text4);
		if(text3.equals(text4))
		{
			System.out.println("Same as Grand Total");
		}
		else
		{
			System.out.println("Not same as Grand Total");
		}
		Thread.sleep(3000);
		driver.quit();

	}

}
