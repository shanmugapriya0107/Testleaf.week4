package week4.day2.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Assignment1b_WindowHandling_Leaftaps {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions ch = new ChromeOptions();
		ch.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(ch);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); 
		driver.get("https://leafground.com/window.xhtml;jsessionid=node0ohpw87cjok1dz9p1fgudvj6l12019.node0");
		
		driver.findElement(By.xpath("//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only mr-2 mb-2']")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> listOfHandles = new ArrayList<String>(windowHandles);
		driver.switchTo().window(listOfHandles.get(1));
		driver.manage().window().maximize();
		
		String title = driver.getTitle();
		System.out.println(title);
		driver.close();
		
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> listOfHandles1 = new ArrayList<String>(windowHandles1);
		driver.switchTo().window(listOfHandles1.get(0));
		
		driver.findElement(By.xpath("//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-button-help']")).click();
		
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> listOfHandles2 = new ArrayList<String>(windowHandles2);
		System.out.println("Number of windows opened " +listOfHandles2.size());
		
		
		Set<String> windowHandles3 = driver.getWindowHandles();
		List<String> listOfHandles3 = new ArrayList<String>(windowHandles3);
		driver.switchTo().window(listOfHandles3.get(1));
		driver.close();
		
		Set<String> windowHandles4 = driver.getWindowHandles();
		List<String> listOfHandles4 = new ArrayList<String>(windowHandles4);
		driver.switchTo().window(listOfHandles4.get(1));
		driver.close();
		
		Set<String> windowHandles5 = driver.getWindowHandles();
		List<String> listOfHandles5 = new ArrayList<String>(windowHandles5);
		driver.switchTo().window(listOfHandles5.get(0));
		
		String title2 = driver.getTitle();
		System.out.println(title2);
		
		driver.findElement(By.id("j_idt88:j_idt93")).click();
		
		Set<String> windowHandles6 = driver.getWindowHandles();
		List<String> listOfHandles6 = new ArrayList<String>(windowHandles6);
		driver.switchTo().window(listOfHandles6.get(1));
		String title3 = driver.getTitle();
		System.out.println(title3);
		driver.close();
		
		Set<String> windowHandles7 = driver.getWindowHandles();
		List<String> listOfHandles7 = new ArrayList<String>(windowHandles7);
		driver.switchTo().window(listOfHandles7.get(1));
		driver.close();
		
		Set<String> windowHandles8 = driver.getWindowHandles();
		List<String> listOfHandles8 = new ArrayList<String>(windowHandles8);
		driver.switchTo().window(listOfHandles8.get(1));
		driver.close();
		
		Set<String> windowHandles9 = driver.getWindowHandles();
		List<String> listOfHandles9 = new ArrayList<String>(windowHandles9);
		driver.switchTo().window(listOfHandles9.get(0));
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-button-raised ui-button-success mr-2 mb-2']")).click();

	}

}
