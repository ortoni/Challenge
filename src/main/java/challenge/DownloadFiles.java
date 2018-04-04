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
	public void downloadFiles()	{
		options	 = new ChromeOptions();
		prefs = new HashMap<String, Object>();	// To put preferences using "prefs" (KeyWord)
		prefs.put("download.default_directory", downloadFilepath); //To set path
		prefs.put("safebrowsing.enabled", "false"); // To disable security check (keep or Cancel)
        options.addArguments("plugins.plugins_disabled", "Chrome PDF Viewer"); //to download PDF
		options.setExperimentalOption("prefs", prefs); // Adding preferences to ChromeOptions
		options.addArguments("--disable-extensions"); //to disable window browser
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.win-rar.com/predownload.html");
		driver.findElementByLinkText("Download WinRAR").click();
	}
}