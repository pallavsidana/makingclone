package actions;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Assignment {

	WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\pallav\\Selenium\\chrome-80\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://the-internet.herokuapp.com");
	}

	@Test
	public void windowHandleAssignment() {
		driver.findElement(By.xpath("//a[contains(text(),'Multiple Windows')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> itr = ids.iterator();
		String parentWindow = itr.next();
		String childWindow = itr.next();
		driver.switchTo().window(childWindow);
		WebElement childWinText = driver.findElement(By.xpath("//h3[contains(text(),'New Window')]"));
		System.out.println(childWinText.getText());
		driver.switchTo().window(parentWindow);
		WebElement parentWinText = driver.findElement(By.xpath("//h3[contains(text(),'Opening a new window')]"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(parentWinText));
		System.out.println(parentWinText.getText());

	}

}
