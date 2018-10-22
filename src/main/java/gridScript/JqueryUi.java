package gridScript;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class JqueryUi {
	public static final String USERNAME = "ortoni0001";
	public static final String ACCESS_KEY = "ace4ca3f-f752-47ec-84a5-d4299bdf3d05";
	public static final String URL =
			"https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

	@Test
	public void frame() throws InterruptedException, MalformedURLException {
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.WINDOWS);
		
		RemoteWebDriver driver = new RemoteWebDriver(
				new URL(URL), dc);
		
		//Load the URL
		driver.get("http://jqueryui.com/draggable/");
		
		WebElement demo = driver.findElementByClassName("demo-frame");
		
		// switch to the frame
		driver.switchTo().frame(demo);
		
		// Get the text of the draggable
		System.out.println(driver.findElementById("draggable").getText());
		
		// come out frame
		driver.switchTo().defaultContent();
		
		// Click on the Download
		driver.findElementByLinkText("Download").click();
		
		
		
		
	}
}