package xpath;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AutosuggestiveDropDown {
	WebDriver driver;

	@Test
	public void xMethod() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\pallav\\Selenium\\chrome-80\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();

		driver.get("http://www.makemytrip.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//label[@for='fromCity']//span[@class='lbl_input latoBold  appendBottom5']")).click();
		Thread.sleep(4000);
	
		WebElement source=driver.findElement(By.xpath("//input[@placeholder='From']"));

		source.clear();
		source.sendKeys("DEL");

		Actions builder = new Actions(driver);        
		builder.sendKeys(Keys.ENTER);//.SendKeys(Keys.ENTER);
	
	
	}
}
