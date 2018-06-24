package challenge;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UpdateDrivesrAutomatically {
	
	public RemoteWebDriver driver;
	
	@BeforeClass
	public void beforeclass() {
		WebDriverManager.chromedriver().setup();
		WebDriverManager.iedriver().setup();
	}
	
	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
	}
		
	@Test
	public void test1(){
		driver.get("http://leaftaps.com/opentaps");
		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
	}
	
	
	@AfterMethod
	public void afterMethod() {
		driver.close();
	}
	
	
	

}
