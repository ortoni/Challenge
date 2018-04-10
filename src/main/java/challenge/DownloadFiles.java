package challenge;

import java.util.HashMap;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
public class DownloadFiles {
	RemoteWebDriver driver;
	ChromeOptions options;
	String downloadFilepath = "K:\\";
	HashMap<String, Object> prefs;
	@Test
	public void downloadFiles() throws InterruptedException	{
		options	 = new ChromeOptions();
		
		//options.setHeadless(true);
		// To put preferences using "prefs" (KeyWord)
		prefs = new HashMap<String, Object>();	
		//To set path
		prefs.put("download.default_directory", downloadFilepath); 
		// To disable security check (keep or Cancel)
		prefs.put("safebrowsing.enabled", "false"); 
		//to download PDF, pdf plugin is turning off
		//options.addArguments("plugins.plugins_disabled", "Chrome PDF Viewer"); 
		// Adding preferences to ChromeOptions
		options.setExperimentalOption("prefs", prefs); 
		//to disable window browser
		options.addArguments("--disable-extensions"); 
		// Adding Chromeoptions to driverChromeD
		driver = new ChromeDriver(options); 		
		driver.manage().window().maximize();
		driver.get("https://www.win-rar.com/predownload.html");
		driver.findElementByLinkText("Download WinRAR").click();
		Thread.sleep(25000);
	}
}