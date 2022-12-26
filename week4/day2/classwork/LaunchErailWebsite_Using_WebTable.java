package week4.day2.classwork;

import java.time.Duration;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LaunchErailWebsite_Using_WebTable {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions ch = new ChromeOptions();
		ch.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(ch);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); 
		driver.get(" https://erail.in/");

		Thread.sleep(3000);
		driver.findElement(By.id("txtStationFrom")).clear();
		driver.findElement(By.id("txtStationFrom")).sendKeys("ms", Keys.TAB);

		driver.findElement(By.id("txtStationTo")).clear();
		driver.findElement(By.id("txtStationTo")).sendKeys("mdu", Keys.TAB);

		driver.findElement(By.xpath("//input[@id='chkSelectDateOnly']")).click();

		System.out.println("Train Names:");
		List<WebElement> allRows = driver.findElements(By.xpath("//table[contains(@class,'DataTable TrainList TrainListHeader stickyTrainListHeader')]/tbody/tr"));
		Set<String> set = new LinkedHashSet<String>();

		for (int i = 2; i <= allRows.size(); i++) {
			String text = driver.findElement(By.xpath("//table[contains(@class,'DataTable TrainList TrainListHeader stickyTrainListHeader')]/tbody/tr["+i+"]/td[2]")).getText();
			System.out.println(text);
			set.add(text);
		}
		if(allRows.size()-1 == set.size())
		{
			System.out.println("No Duplicate Train");
		}
		else
		{
			System.out.println("Duplicate trains are present");
		}

	}
}


