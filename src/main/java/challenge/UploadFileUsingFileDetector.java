package challenge;

import java.awt.AWTException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;

public class UploadFileUsingFileDetector {
	public static void main(String[] args) throws InterruptedException, AWTException {
		//System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		InternetExplorerDriver
		driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.get("https://www.naukri.com/");
		WebElement ele = driver.findElementByXPath("//input[@type='file']");
		String path = "K:\\Koushik\\workspace\\challenge\\Koushik Chatterjee_Automation(Selenium).pdf";
		ele.sendKeys(path);
//		LocalFileDetector detect = new LocalFileDetector();
//		((RemoteWebElement)ele).setFileDetector(detect);
//		ele.sendKeys(detect.getLocalFile(path).getAbsolutePath());
//		Thread.sleep(10000);
//		driver.quit();
	}
}
