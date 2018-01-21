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

		WebElement gooimg = driver.findElementByXPath("//*[@id=\'hplogo\']");
		for (int i = 0; i <= 5; i++) {

			((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1]);", goobutt,
					"color: Yellow;");
			Thread.sleep(300);
			((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1]);", gooimg,
					"color: transparent;");
			Thread.sleep(300);
		}
	}

}
