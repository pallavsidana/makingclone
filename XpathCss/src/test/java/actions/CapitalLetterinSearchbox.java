package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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
	}
	@Test
	public void capsInSearchTextBox() {
	Actions action = new Actions(driver);
	WebElement act = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
	act.click();
	action.moveToElement(act).click().keyDown(Keys.SHIFT).sendKeys("alexa").build().perform();
	//now u select the content by clicking double key
	action.moveToElement(act).click().keyDown(Keys.SHIFT).sendKeys("htrtsonyhometheatre").doubleClick().build().perform();
	//right click on the element USING contextClick
	WebElement rightclick=driver.findElement(By.xpath("//span[contains(text(),'Hello. Sign in')]"));
	action.moveToElement(rightclick).contextClick().build().perform();

}
}