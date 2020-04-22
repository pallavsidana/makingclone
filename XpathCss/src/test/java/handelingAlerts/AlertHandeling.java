package handelingAlerts;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;


public class AlertHandeling {

	WebDriver driver;
	TestDataAertValidation objAlert = new TestDataAertValidation();
	String alertTextBoxValue = "Pallav";

	@BeforeTest
	public void setUp() throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\pallav\\Selenium\\chrome-80\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("C:\\ss\\s1.png"));
	}

	public static void Takescreenshot(WebDriver driver) throws IOException {
		//File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	//	FileUtils.copyFile(src,new File("C:\\ss\\s1.png"));
	}
	
	
	@Test
	public void TestAlertBox() throws IOException {

		try {

			objAlert.TestURL(driver);
			objAlert.TestAlertTextBox(driver).sendKeys(alertTextBoxValue);
			objAlert.TestAlertButton(driver).click();
			Thread.sleep(5000);
			String text = driver.switchTo().alert().getText();
			System.out.println(text);
		//	File src2= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	//		FileUtils.copyFile(src2,new File("C:\\ss\\s2.png"));
			driver.switchTo().alert().accept();
			objAlert.TestAlertConfirmButton(driver).click();
			Thread.sleep(5000);

			String text2 = driver.switchTo().alert().getText();
			System.out.println(text2);
			Thread.sleep(5000);
			///File src3= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//	FileUtils.copyFile(src3,new File("C:\\ss\\s3.png"));
			// click on cancel
			driver.switchTo().alert().dismiss();
			Thread.sleep(5000);
			objAlert.TestAlertConfirmButton(driver).click();
			driver.switchTo().alert().accept();
			Thread.sleep(5000);
			//File src4= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			//FileUtils.copyFile(src4,new File("C:\\ss\\s4.png"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// @AfterTest
	// public void teaDown() {
	// driver.close();
	// driver.quit();
	// }
}
