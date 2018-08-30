package challenge;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

public class UploadFileUsingFileDetector {
	@Test
	public void upload() throws MalformedURLException{
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://files.fm/");
		WebElement ele= driver.findElementByXPath("(//input[@type='file'])[2]");
		ele.sendKeys("C:\\Users\\dell\\Desktop\\a.jpg"+"\n"+"C:\\Users\\dell\\Desktop\\b.jpg"); 
	}
}
















