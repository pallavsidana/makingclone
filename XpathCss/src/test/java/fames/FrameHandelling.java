package fames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FrameHandelling {
	WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\pallav\\Selenium\\chrome-80\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
	}
	@Test
	public void frameHandeling() {
		WebElement felement = driver.findElement(By.cssSelector(".demo-frame"));
		felement.click();
		driver.switchTo().frame(felement);
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		Actions act = new Actions(driver);
		WebElement source =driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		act.dragAndDrop(source, target).build().perform();
		System.out.println("source drag and dropped in target");
		//this will bring the webdriver out of frame
		driver.switchTo().defaultContent();
		
	}
	@Test
	public void framePresentInPage() {
	
		
		
	}
}
