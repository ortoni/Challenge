package challenge;

import java.awt.AWTException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;

public class UploadFile {

	public static void main(String[] args) throws InterruptedException, AWTException {
		// opening Chrome browser
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		// maximize the browser
		driver.manage().window().maximize();
		// load the browser with url
		driver.get("https://files.fm/");
		WebElement ele = driver.findElementByXPath("(//input[@type='file'])[2]");
		String path = "./resource/CP.pdf";
		LocalFileDetector detect = new LocalFileDetector();
		((RemoteWebElement)ele).setFileDetector(detect);
		ele.sendKeys(detect.getLocalFile(path).getAbsolutePath());


	}



}
