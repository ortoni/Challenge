package challenge;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

public class UploadFileUsingFileDetector {
	@Test
	public void upload() throws MalformedURLException{
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setCapability("platform", "Windows 10");
		caps.setCapability("version", "67.0");

		/*http://uesrId:AccessId@ondemand.saucelabs.com:80/wd/hub
		Access ID: c35b5eee-95d7-4a73-8be2-d05b77456594
		 */
		RemoteWebDriver driver = new RemoteWebDriver(new URL
				("http://TunaTestDemo:c35b5eee-95d7-4a73-8be2-d05b77456594@ondemand.saucelabs.com:80/wd/hub"), caps);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Load the URL
		driver.get("https://www.naukri.com/");

		// Locate the WebElement
		WebElement upload = driver.findElementByXPath("//input[@type='file']");

		LocalFileDetector detector = new LocalFileDetector();
		((RemoteWebElement)upload).setFileDetector(detector);
		upload.sendKeys(detector.getLocalFile("./Resume.pdf").getAbsolutePath());

	}

}
















