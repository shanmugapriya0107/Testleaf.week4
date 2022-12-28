package week4.day2.classwork;

import java.util.List;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LaunchIRCTC_Using_WindowHandling {

	public static void main(String[] args) throws IOException {
		ChromeOptions ch = new ChromeOptions();
		ch.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(ch);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); 
		driver.get(" https://www.irctc.co.in/");

		driver.findElement(By.xpath("//a[text()=' FLIGHTS ']" )).click();

		Set<String> windowHandles = driver.getWindowHandles();
		List<String> listOfHandles = new ArrayList<String>(windowHandles);
		driver.switchTo().window(listOfHandles.get(1));

		File source = driver.getScreenshotAs(OutputType.FILE);
		File target = new File("./snaps/leaftaps.png");
		FileUtils.copyFile(source, target);

		driver.close();

		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> listOfHandles1 = new ArrayList<String>(windowHandles1);
		driver.switchTo().window(listOfHandles1.get(0));
		System.out.println(driver.getTitle());

	}
}


