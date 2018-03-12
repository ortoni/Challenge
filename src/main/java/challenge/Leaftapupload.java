package challenge;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.FileDetector;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.remote.Response;

public class Leaftapupload {
	static Response parent;
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.leaftaps.com/opentaps");
		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Leads").click();	
		driver.findElementByLinkText("Upload Leads").click();
		RemoteWebElement ele = (RemoteWebElement) driver.findElementById("uploadedFile");
		LocalFileDetector detect = new LocalFileDetector();
		((RemoteWebElement)ele).setFileDetector(detect);
		String path = "";
		ele.sendKeys(detect.getLocalFile(path).getAbsolutePath());
		driver.findElementByXPath("//input[@type='submit']").click();
		driver.quit();
	}
}