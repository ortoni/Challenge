package challenge;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class Franklin {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.franklintempleton.com/");
		
		//using link text - wont work - As available in the DOM
		driver.findElementByLinkText("Equity").click();
		
		// --- Or using the text visible in webPage-->>>	(works)
		//driver.findElementByLinkText("EQUITY").click();
		
		
		// Using Xpath (works)
		//driver.findElementByXPath("//a[text()='Equity']").click();
		driver.quit();
	}

}
