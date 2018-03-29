package challenge;

import java.awt.AWTException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HighLight {

	public static void main(String[] args) throws InterruptedException, AWTException{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();		
		driver.manage().window().maximize();		
		driver.get("http://google.com/");
		WebElement goobutt = driver.findElementByName("btnK");

		for (int i = 0; i <= 10; i++) {
			driver.executeScript("arguments[0].setAttribute('style', arguments[1]);", goobutt,
					"color: transparent;");
			Thread.sleep(250);
			driver.executeScript("arguments[0].setAttribute('style', arguments[1]);", goobutt,
					"color: Red;");
			Thread.sleep(250);
		}
		driver.quit();
	}

}
