package challenge;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

public class UploadFileUsingFileDetector {
	@Test
	public void upload() throws MalformedURLException{
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("");
		WebElement ele= driver.findElementByXPath("(//input[@type='file'])[1]");
		LocalFileDetector detector = new LocalFileDetector();
		((RemoteWebElement)ele).setFileDetector(detector);
		ele.sendKeys("path");
	}
}
















