package challenge;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

public class UploadFileUsingFileDetector {
	RemoteWebDriver driver;

	@Test
	public void upload() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://files.fm");
		WebElement ele = driver.findElementByXPath("(//input[@type='file'])[2]");

		// Local file detector loads the files
		LocalFileDetector detc = new LocalFileDetector();
		((RemoteWebElement) ele).setFileDetector(detc);

		// \n can be multiple times to upload multiple files
		// getAbsolutePath gives the full file path
		ele.sendKeys(detc.getLocalFile("K://a.jpeg").getAbsolutePath() + "\n"
				+ detc.getLocalFile("K://b.jpeg").getAbsolutePath());

	}
}
