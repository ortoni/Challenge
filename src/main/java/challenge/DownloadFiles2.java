package challenge;

import java.io.File;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.HashMap;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
public class DownloadFiles2 {
	RemoteWebDriver driver;
	ChromeOptions options;
	Capabilities caps;
	DesiredCapabilities dc;
	HashMap<String, Object> prefs;
	public String generateRandomFolderName() {
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L; 
		String folderName = Long.toString(number);
		return  folderName;
	}

	@Test
	public void downloadFiles() throws InterruptedException, UnknownHostException, MalformedURLException	{
		ChromeOptions options =  new ChromeOptions();
		HashMap<String, Object> setPath = new HashMap<String, Object>();	
		File file = new File("E:download\\"+generateRandomFolderName());
		setPath.put("download.default_directory", file); //To set path
		setPath.put("safebrowsing.enabled", "false"); // To disable security check

		HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
		options.setExperimentalOption("prefs", setPath);
		options.addArguments("--disable-extensions");

		dc = DesiredCapabilities.chrome(); //Adding capabilities
		dc.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
		dc.setCapability(ChromeOptions.CAPABILITY, options);

		dc.setVersion("ANY");
		dc.setPlatform(Platform.WINDOWS);

		driver = new RemoteWebDriver(
				new URL("http://192.168.54.15:4444/wd/hub"), dc);
		driver.manage().window().maximize();
		driver.get("https://www.win-rar.com/predownload.html");
		System.out.println(InetAddress.getLocalHost().getHostAddress());

		System.out.println(System.getProperty("os.name"));
		System.out.println(System.getProperty("user.name"));
		driver.findElementByLinkText("Download WinRAR").click();
		//Thread.sleep(25000);




	}
}