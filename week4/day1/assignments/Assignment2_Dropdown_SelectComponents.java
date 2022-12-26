package week4.day1.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2_Dropdown_SelectComponents {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.leafground.com/select.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Which is your favorite UI Automation tool?
		WebElement findElement = driver.findElement(By.xpath("(//select[@class='ui-selectonemenu'])[1]"));
        Select dd1 = new Select(findElement);
        dd1.selectByVisibleText("Playwright");
        
        //Choose your preferred country.
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//label[@class='ui-selectonemenu-label ui-inputfield ui-corner-all'])[1]")).click();
        driver.findElement(By.id("j_idt87:country_3")).click();
        String text = driver.findElement(By.xpath("(//label[@class='ui-selectonemenu-label ui-inputfield ui-corner-all'])[1]")).getText();
        //System.out.println(text);
        
        //Confirm Cities belongs to Country is loaded
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//label[@class='ui-selectonemenu-label ui-inputfield ui-corner-all'])[2]")).click();
        driver.findElement(By.id("j_idt87:city_1")).click();
        
        //Choose the Course
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@class='ui-button-icon-primary ui-icon ui-icon-triangle-1-s']")).click();
        driver.findElement(By.xpath("(//li[@class='ui-autocomplete-item ui-autocomplete-list-item ui-corner-all'])[2]")).click();
        driver.findElement(By.xpath("//span[@class='ui-button-icon-primary ui-icon ui-icon-triangle-1-s']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//li[@class='ui-autocomplete-item ui-autocomplete-list-item ui-corner-all'])[1]")).click();
        driver.findElement(By.xpath("(//label[@class='ui-selectonemenu-label ui-inputfield ui-corner-all'])[3]")).click();
        
        //Choose language randomly
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//li[@class='ui-selectonemenu-item ui-selectonemenu-list-item ui-corner-all'])[4]")).click();
        
        //Select 'Two' irrespective of the language chosen
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//span[@class='ui-icon ui-icon-triangle-1-s ui-c'])[4]")).click();
        driver.findElement(By.id("j_idt87:value_3")).click();
        
        
        
	}
}