package gridScript;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class CrystalCruises {

	@Test
	public void crystalCruises() throws InterruptedException, MalformedURLException {

		/*
		 * DesiredCapabilities dc = new DesiredCapabilities();
		 * dc.setBrowserName("firefox"); dc.setVersion("67.0");
		 * dc.setPlatform(Platform.WIN10);
		 */
		DesiredCapabilities dc = new DesiredCapabilities().firefox();
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc);

		// Load the URL
		driver.get("http://legacy.crystalcruises.com/Calendar.aspx");

		// Maximize
		driver.manage().window().maximize();

		// Enter the UserName
		List<WebElement> allQuotes = driver.findElementsByLinkText("Request A Quote".toUpperCase());

		// Print the number of quote
		int count = allQuotes.size();
		System.out.println(count);
		//
		System.out.println(driver.getCurrentUrl());

	}
}