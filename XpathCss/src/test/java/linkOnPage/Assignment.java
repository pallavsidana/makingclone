package linkOnPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
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
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
	}

	@Test
	public void selectCheckBox() {
		driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]/input")).click();
		String opt = driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]")).getText();
		System.out.println(opt);
		WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
		Select s = new Select(dropdown);
		s.selectByVisibleText(opt);
		driver.findElement(By.name("enter-name")).sendKeys(opt);
		driver.findElement(By.id("alertbtn")).click();
		String text = driver.switchTo().alert().getText();
		if (text.contains(opt)) {
			System.out.println("Alert message successfull displayed");
		}
		else
			System.out.println("Alert message was not sucesfully displayed");
	}
}
