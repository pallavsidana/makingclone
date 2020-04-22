package actions;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MultipleWindowHandelling {
	WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\pallav\\Selenium\\chrome-80\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com/intl/en-GB/gmail/about/");
	}
	
	@Test
	public void windowHandle() {
	
	//validate th title of the parernt window
		System.out.println(driver.getTitle());
	//clicked on privacy link
		driver.findElement(By.cssSelector(".h-c-footer__link")).click();
		
		Set<String> id=driver.getWindowHandles();
		Iterator itr = id.iterator();
		String parentwindow = (String) itr.next();
		String childWindow= (String) itr.next();
		driver.switchTo().window(parentwindow);
		//switching to child window
		driver.switchTo().window(childWindow);
		System.out.println(driver.getTitle());
		//switching back to the parent window
		driver.switchTo().window(parentwindow);
		System.out.println(driver.getTitle());
		
		
		
		
	
	
	}
}
