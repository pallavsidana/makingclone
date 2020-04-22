package E2ESpicejetBookin;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class BookTicket  {


	/*Advantages of Extent Reports:
	Some of the advantages of Extent Reports are as follows-

	1. Extent reports are more customizable than others
	2. Extent API can produce more interactive reports, a dashboard view, graphical view, 
	3. capture screenshots at every test step, and emailable reports
	4. It can be easily integrated with frameworks like JUnit & TestNG
	5. It displays the time taken for test case execution
	 *  
	 */
	WebDriver driver;
	TestData obj = new TestData();
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\pallav\\Selenium\\chrome-80\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void OneWayCalend() {
		try {
			obj.TestURL(driver);
			obj.TestFlight(driver).click();
			obj.TestOneWay(driver).click();
			obj.TestFromLocation(driver).click();
			Thread.sleep(5000);
			obj.TestSourceLocation(driver).click();
			Thread.sleep(5000);
			obj.TestDestiLocation(driver).click();
			obj.TestCurrentDate(driver).click();
			//System.out.println(obj.opacity(driver).getAttribute("style"));
			String check=obj.opacity(driver).getAttribute("style");
			if (check.contains("0.5")) {
				obj.TestRoundTripEnable(driver).isEnabled();
				//System.out.println("the round trip calender is not enabled");
				Assert.assertTrue(obj.TestRoundTripEnable(driver).isEnabled());
				Assert.assertTrue(true);
			}
			else {
				Assert.assertFalse(false);
				System.out.println("the round trip calender is enabled");
			}
			obj.TestSeniorCitizenDiscount(driver).click();
			obj.TestPAX(driver).click();
			Thread.sleep(2000L);
			obj.TestSearchBttn(driver).click();
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	@AfterTest
	public void teaDown() {
		driver.close();
		driver.quit();
	}
}
