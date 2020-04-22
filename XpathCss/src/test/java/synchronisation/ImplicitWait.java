package synchronisation;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ImplicitWait {
	WebDriver driver;
	// String[] names = { "Raspberry", "Strawberry", "Beetroot" };

	@BeforeTest
	public void setUp() throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\pallav\\Selenium\\chrome-80\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();

	
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		//expilict wait syntex

		// we define globally wait n number of second before you throw exception
		// advantage of implicit wait
		// define wait globally and it will apllicable till the webdriver instance is
		// alive
		// keep on listning to the DOM
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
// impilicit disadvantage performance are not cought
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	}

	@Test
	public void AddItemToCart() throws InterruptedException {

		String[] names = { "Raspberry", "Strawberry", "Beetroot" };
		List<WebElement> product = driver.findElements(By.cssSelector("h4.product-name"));
		int j = 0;
		for (int i = 0; i < product.size(); i++) {
			String[] name = product.get(i).getText().split("-");

			String formatedname = names[0].trim();
			List list = Arrays.asList(names);
			if (list.contains(formatedname)) {
				j++;
				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();

				if (j == 3)
					break;
			}
		}
		clickAddCart(driver);
	}

	//Click on Add Cart
	public void clickAddCart(WebDriver driver) throws InterruptedException {
		// expilict wait only applied where ever require
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		System.out.println("clicked checkout");
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		System.out.println("promocode printed");
		// enter the promo code
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input.promoCode")));
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		//click on apply button
		System.out.println("promocode button clicked");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
	}
}