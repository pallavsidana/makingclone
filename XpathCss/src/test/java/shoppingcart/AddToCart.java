package shoppingcart;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddToCart {
	WebDriver driver;
	String[] names = { "Raspberry", "Strawberry", "Beetroot" };

	@BeforeTest
	public void setUp() throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\pallav\\Selenium\\chrome-80\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	}

	@Test
	public void AddItemToCArt() {
		List<WebElement> product = driver.findElements(By.cssSelector("h4.product-name"));
		int j = 0;
		for (int i = 0; i < product.size(); i++) {
			// format the actual vegetable name and pas this to ur if condition to check
			// with your array
			String[] name = product.get(i).getText().split("-");
			String formatedname = name[0].trim();
			System.out.println(formatedname);
			// convert array to arraylist
			// check if the product u extracted present in the list
			List list = Arrays.asList(names);
			if (list.contains(formatedname)) {
				// apply click on add to cart
				// being in if block that means the current index value is cucumber and pass the
				// index value as i and perform the click operation
				j++;
				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				System.out.println("item present in list ");
				if (j == 3)
					break;
			} else {
				System.out.println("none of the item present");
			}
		}
	}
}
