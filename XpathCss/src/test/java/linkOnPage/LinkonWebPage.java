package linkOnPage;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LinkonWebPage {
	WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\pallav\\Selenium\\chrome-80\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
	}

	@Test
	public void linkPresent() throws InterruptedException {
		// to find how many links present on page
		System.out.println(driver.findElements(By.tagName("a")).size());
		// find how many link present in the footer section
		// using driver subset
		WebElement footerDriverObj = driver.findElement(By.id("gf-BIG"));
		System.out.println("footer link are :::" + footerDriverObj.findElements(By.tagName("a")).size());

		// count of ink from specific column of footer
		WebElement lmtLinkObj = footerDriverObj.findElement(By.xpath("(//div[@id='gf-BIG']/table/tbody/tr/td)[1]"));
		System.out.println(lmtLinkObj.getText());

		System.out.println("link present in the specific column of footer are ::"
				+ lmtLinkObj.findElements(By.tagName("a")).size());

		// what is the links are dynamic and click on each link from specific footer
		// column check if the pages are opening
		for (int i = 1; i < lmtLinkObj.findElements(By.tagName("a")).size(); i++) {
			String clickonEachlink = Keys.chord(Keys.CONTROL, Keys.ENTER);
			lmtLinkObj.findElements(By.tagName("a")).get(i).sendKeys(clickonEachlink);
			Thread.sleep(5000);
		}
		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> iterator = allWindows.iterator();
		while (iterator.hasNext()) {

			driver.switchTo().window(iterator.next());
			System.out.println(driver.getTitle());
		}

	}
}