package gridScript;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Leaftaps {
	public static final String USERNAME = "ortoni0001";
	public static final String ACCESS_KEY = "ace4ca3f-f752-47ec-84a5-d4299bdf3d05";
	public static final String URL =
			"https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

	@Test
	public void login() throws InterruptedException, MalformedURLException {
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.LINUX);
		
		RemoteWebDriver driver = new RemoteWebDriver(
				new URL(URL), dc);
		
		
		//Load the URL
		driver.get("http://leaftaps.com/opentaps");
		
		// Set wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
		//Maximize
		driver.manage().window().maximize();
						
		//Enter the UserName
		WebElement user = driver.findElementById("username");
		user.clear();
		user.sendKeys("DemoSalesManager");

		//Enter the Password
		driver.findElementById("password").sendKeys("crmsfa");
		
		//Click on Login Button
		driver.findElementByClassName("decorativeSubmit").click();
		
		////Click on LogOut Button
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Create Lead").click();
		driver.findElementById("createLeadForm_companyName").sendKeys("TestLeaf");
		driver.findElementById("createLeadForm_firstName").sendKeys("Babu");
		driver.findElementById("createLeadForm_lastName").sendKeys("M");
		driver.findElementByName("submitButton").click();
	}
}