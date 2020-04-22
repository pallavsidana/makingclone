package checkbox;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Checkboxes {



	WebDriver driver;

	@Test
	public void xMethod() {

		System.setProperty("webdriver.chrome.driver", "C:\\pallav\\Selenium\\chrome-80\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();

		driver.get("http://www.spicejet.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).click();


		int checkboxlists =driver.findElements(By.xpath("//input[@type='checkbox']")).size();
		System.out.println(checkboxlists);

		//below assert will return false only
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

		//this should fail the test case
		//	Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected(), "true");	

		System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		for (int i =0;i<5;i++) {
			driver.findElement(By.id("ctl00_mainContent_ddl_Adult")).click();
		}
			Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "1 Adult");
			System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		


		driver.close();
	}
}
