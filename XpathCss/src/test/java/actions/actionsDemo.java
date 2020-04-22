package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class actionsDemo {
	WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\pallav\\Selenium\\chrome-80\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("http://www.amazon.in");
	}
	@Test
	public void printText() {
		WebElement act=driver.findElement(By.xpath("(//span[contains(text(),'Account & Lists')])[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(act).build().perform();
		
		//click on sign on button after mouse move
		driver.findElement(By.cssSelector(".nav-action-inner")).click();
		
	}

}
