package xpath;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropDown {
	WebDriver driver;

	@Test
	public void xMethod() {

		System.setProperty("webdriver.chrome.driver", "C:\\pallav\\Selenium\\chrome-80\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();

		driver.get("http://www.spicejet.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			driver.findElement(By.xpath("//div[@class='paxinfo']")).click();

			//Thread.sleep(5000);
	
	
			WebElement objDropPassengerSelect=driver.findElement(By.id("ctl00_mainContent_ddl_Adult"));
			Select objDropDownPassengers = new Select(objDropPassengerSelect);
			objDropDownPassengers.selectByIndex(2);
			Thread.sleep(5000);
			WebElement dropDownCurrency= driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
			Select objSelect = new Select(dropDownCurrency);
			objSelect.selectByValue("AED");
			Thread.sleep(5000);
			objSelect.selectByIndex(3);
			Thread.sleep(5000);
			objSelect.selectByVisibleText("INR");
			Thread.sleep(6000);
			objSelect.selectByIndex(0);
			Thread.sleep(6000);
			driver.close();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
}
