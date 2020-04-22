package calender;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
public class CalenderSelection {
	WebDriver driver;
	@Test
	public void Calend() {
		System.setProperty("webdriver.chrome.driver", "C:\\pallav\\Selenium\\chrome-80\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://www.spicejet.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
			//normal concept to click on xpath
			//driver.findElement(By.xpath("//a[@value='BLR']")).click();
			//second way to click the dynamic drop down with indexing here we use parent child concepts
			driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='IXU']")).click();
			Thread.sleep(10000);
			//selecting ATQ from "TO"option thats y we have put (//a[@value='ATQ')[2] xpath
			driver.findElement(By.xpath("(//a[@value='ATQ'])[2]")).click();
			Thread.sleep(5000);
			//select the current date from the calendar 
			driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
			//once the one way is selected the return date is disabled'
			//	System.out.println(driver.findElement(By.cssSelector("input[id*='ctl00_mainContent_view_date2'")).isEnabled());
			System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
			String check=driver.findElement(By.id("Div1")).getAttribute("style");
			if (check.contains("0.5")) {
				driver.findElement(By.cssSelector("input[id*='ctl00_mainContent_view_date2'")).isEnabled();
				System.out.println("the round trip calender is not enabled");
				Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='ctl00_mainContent_view_date2'")).isEnabled());
				Assert.assertTrue(true);
				
			}
			else {
				Assert.assertFalse(false);
				System.out.println("the round trip calender is enabled");
			}
			//driver.close();	
		}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
