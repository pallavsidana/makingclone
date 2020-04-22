package checkbox;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstPractise {

	WebDriver driver;
	@Test
	public void Practise() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\pallav\\Selenium\\chrome-80\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
		 //this will check if by default the first check box is selected
		 Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected());;
		 Thread.sleep(5000); 
		 //Check the first Checkbox and verify if it is successfully checked 
		 driver.findElement(By.id("checkBoxOption1")).click();
		  Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());
		 //and Uncheck it again to verify if it is successfully Unchecked
		 driver.findElement(By.id("checkBoxOption1")).click();
		 Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected());
		 //How to get the Count of number of check boxes present in the page
		 
		System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
	}
}
