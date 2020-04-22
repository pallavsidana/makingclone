package xpath;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DynamicDropdown {
	
	WebDriver driver;

	@Test
	public void xMethod() {

		System.setProperty("webdriver.chrome.driver", "C:\\pallav\\Selenium\\chrome-80\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();

		driver.get("http://www.spicejet.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
	//normal concept to click on xpath
		//	driver.findElement(By.xpath("//a[@value='BLR']")).click();
		
		//second way to click the dynamic drop down with indexing here we use parent child concepts
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='IXU']")).click();
		try {
			Thread.sleep(10000);
			
			//selecting ATQ from "TO" option thats y we have put (//a[@value='ATQ')[2] xpath
			driver.findElement(By.xpath("(//a[@value='ATQ'])[2]")).click();
			Thread.sleep(5000);
			driver.close();	
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
