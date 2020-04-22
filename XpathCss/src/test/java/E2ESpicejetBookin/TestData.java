package E2ESpicejetBookin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class TestData {


	//chrome exe
	public void TestChromeExe(WebDriver driver) {
		String path="C:\\pallav\\Selenium\\chrome-80\\chromedriver_win32\\chromedriver.exe";
	}


	//URL of the website
	public void TestURL(WebDriver driver) {
		driver.get("http://www.spicejet.com");

	}
	// select the Fligth from the page
	public WebElement TestFlight(WebDriver driver) {
		WebElement ClickFlight=driver.findElement(By.xpath("//span[contains(text(),'Flights')]"));
		return ClickFlight;
	}
	//select the OneWay option from the page
	public WebElement TestOneWay(WebDriver driver) {
		WebElement  oneWay=driver.findElement(By.xpath("(//label[contains(text(),'One Way')])[1]"));
		return oneWay;
	}
	//select the  From option from the page
	public WebElement TestFromLocation(WebDriver driver) {

		// select the From option
		WebElement from=driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"));
		return  from;
	}
	//select the source location
	public WebElement TestSourceLocation(WebDriver driver) {

		WebElement sourceLocation=driver.findElement(By.xpath("//a[contains(text(),' Bengaluru (BLR)')]"));
		return sourceLocation;
	}

	//select destination location
	public WebElement TestDestiLocation(WebDriver driver) {

		WebElement destiLocation=driver.findElement(By.xpath("(//a[contains(text(),' Delhi (DEL)')])[2]"));
		return destiLocation;
	}
	//select the current date from calender
	public WebElement TestCurrentDate(WebDriver driver) {

		WebElement currentDate=driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active.ui-state-hover"));
		return currentDate;
	}
	//select opacity
	public WebElement opacity(WebDriver driver) {

		WebElement Testopacity=driver.findElement(By.id("Div1"));
		return Testopacity;
	}
	//select the round trip calender is enables
	public WebElement TestRoundTripEnable(WebDriver driver) {

		WebElement RoundTripEnable=driver.findElement(By.cssSelector("input[id*='ctl00_mainContent_view_date2'"));
		return RoundTripEnable;
	}
	//Senior citizen discount
	public WebElement TestSeniorCitizenDiscount(WebDriver driver) {

		WebElement seniorDiscount=driver.findElement(By.name("ctl00$mainContent$chk_SeniorCitizenDiscount"));
		return seniorDiscount;
	}
	//number of PAX
	public WebElement TestPAX(WebDriver driver) {
		WebElement paxCount=driver.findElement(By.id("divpaxinfo"));
		return paxCount;
	}
	//click on Search button
	public WebElement TestSearchBttn(WebDriver driver) {
		WebElement searchBttn=driver.findElement(By.name("ctl00$mainContent$btn_FindFlights"));
		return searchBttn;
	}
}