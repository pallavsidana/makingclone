package handelingAlerts;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class TestDataAertValidation {


		//URL of the website
	public void TestURL(WebDriver driver) {
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

	}
	// enter the value in the alert text box
	public WebElement TestAlertTextBox(WebDriver driver) {
		WebElement alertTextBox=driver.findElement(By.id("name"));
		return alertTextBox;
	}
	//Click on Alert Button
	public WebElement TestAlertButton(WebDriver driver) {
		WebElement  alertButton=driver.findElement(By.id("alertbtn"));
		return alertButton;
	}
	
	//Click on Confirm near alert
		public WebElement TestAlertConfirmButton(WebDriver driver) {
			WebElement  alertConfirmButton=driver.findElement(By.id("confirmbtn"));
			return alertConfirmButton;
		}
		
		//SwitchTo Alert method
				public WebElement SwithcToAlert(WebDriver driver) {
					WebElement  alertSwitchTo=(WebElement) driver.switchTo().alert();
					return alertSwitchTo;
				//return null;
				}
	
}