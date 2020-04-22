package xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class XpathLocator {

	
	WebDriver driver;
	
	@Test
	public void xMethod() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\pallav\\Selenium\\chrome-80\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		//driver.get("http://www.facebook.com");
		//xpath locator
		//<input type="email" class="inputtext login_form_input_box" name="email" id="email" data-testid="royal_email">
		//tagName[contains(@attribute,'value')] 
		
		//driver.findElement(By.xpath("//input[@type='email']")).sendKeys("xpathregular expression");
	//	driver.findElement(By.xpath("//input[contains(@type,'email')]")).sendKeys("xpathregular expression");
		driver.get("http://www.google.com");
		//parent child relation xpath
		
		
		driver.findElement(By.xpath("//div[@class='SDkEP']/div[2]/input")).sendKeys("enter the word");
	}
	
}
