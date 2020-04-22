package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragDropItems {
	public class CapitalLetterinSearchbox {
		WebDriver driver;

		@BeforeTest
		public void setUp() {
			System.setProperty("webdriver.chrome.driver",
					"C:\\pallav\\Selenium\\chrome-80\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.get("http://www.amazon.in");
			driver.get("https://jqueryui.com/droppable/");
		}
		@Test
		public void dragdropItem() {
			WebElement frameElement = driver.findElement(By.cssSelector(".demo-frame"));
			frameElement.click();
			driver.switchTo().frame(frameElement);
			Actions action = new Actions(driver);
			WebElement source = driver.findElement(By.id("draggable"));
			WebElement target = driver.findElement(By.id("droppable"));
			action.dragAndDrop(source, target).build().perform();
		}
	}
}
