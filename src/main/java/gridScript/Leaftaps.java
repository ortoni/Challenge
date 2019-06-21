package gridScript;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Leaftaps {

	/*
	 * public static final String USERNAME = "ortoni0001"; public static final
	 * String ACCESS_KEY = "ace4ca3f-f752-47ec-84a5-d4299bdf3d05"; // public static
	 * final String URL = "https://" + USERNAME + ":" + ACCESS_KEY +
	 * "@ondemand.saucelabs.com:443/wd/hub";
	 */
	@Test
	public void login() throws InterruptedException, MalformedURLException {
		String url = "http://localhost:4444/wd/hub";
		new DesiredCapabilities();
		DesiredCapabilities dc = DesiredCapabilities.firefox();
		dc.setVersion("67.0");
		dc.setPlatform(Platform.WIN10);

		RemoteWebDriver driver = new RemoteWebDriver(new URL(url), dc);
		// Load the URL
		driver.get("http://leaftaps.com/opentaps");
		// Set wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Maximize
		driver.manage().window().maximize();
	}
}