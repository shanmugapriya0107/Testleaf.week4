package week4.day2.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1a_WindowHandling_MergeContact {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://leaftaps.com/opentaps");
		driver.findElement(By.id("username")).sendKeys("DemoCSR"); //Using id locator
		driver.findElement(By.id("password")).sendKeys("crmsfa"); //Using id locator
		driver.findElement(By.className("decorativeSubmit")).click(); //Using className locator
		driver.findElement(By.linkText("CRM/SFA")).click(); //Using LinkText locator
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		
		driver.findElement(By.xpath("(//table[@class='twoColumnForm']//following::a)[1]")).click();
		
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> listOfHandles = new ArrayList<String>(windowHandles);
		driver.switchTo().window(listOfHandles.get(1));
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();
		
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> listOfHandles1 = new ArrayList<String>(windowHandles1);
		driver.switchTo().window(listOfHandles1.get(0));
		
		//Thread.sleep(3000);
		driver.findElement(By.xpath("(//table[@class='twoColumnForm']//following::a)[2]")).click();
		
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> listOfHandles2 = new ArrayList<String>(windowHandles2);
		driver.switchTo().window(listOfHandles2.get(1));
		driver.manage().window().maximize();
		
		
		driver.findElement(By.xpath("//a[@class='linktext'][1]")).click();
		
		Set<String> windowHandles3 = driver.getWindowHandles();
		List<String> listOfHandles3 = new ArrayList<String>(windowHandles3);
		driver.switchTo().window(listOfHandles3.get(0));
		
		driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		String title = driver.getTitle();
		System.out.println(title);
		
		
		
		
		
		

	}

}
