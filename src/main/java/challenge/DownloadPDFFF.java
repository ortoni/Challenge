package challenge;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class DownloadPDFFF {

	public static void main(String[] args) throws InterruptedException {

		
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.download.dir","K:\\");
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.download.manager.skipWinSecurityPolicyChecks", false);
		profile.setPreference("browser.download.manager.useWindow", false);
		profile.setPreference("browser.download.hide_plugins_without_extensions", true);
		profile.setPreference("pdfjs.disabled", true);
		profile.setPreference("pdfjs.enableWebGL", false);
		profile.setPreference("pdfjs.enabIedCache.initialized", true);
		profile.setPreference("pdfjs.enabIedCache.state", false);	
		profile.setPreference("pdfjs.previousHandler.alwaysAskBeforeHandling", true);
		profile.setPreference("pdfjs.renderer", false);
		profile.setPreference("pdfjs.enabledCache.initialized", true);
		profile.setPreference("pdfjs.enabledCache.state", false);		
		profile.setPreference("browser.download.useToolkitUI",false);
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/plain,application/octet-stream,application/pdf,application/x-pdf,application/vnd.pdf");
		profile.setPreference("browser.download.manager.showWhenStarting", false);
		profile.setPreference("browser.helperApps.neverAsk.openFile","text/plain,application/octet-stream,application/pdf,application/x-pdf,application/vnd.pdf");
		profile.setPreference("browser.helperApps.alwaysAsk.force", false);
		// System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		FirefoxOptions options = new FirefoxOptions();
		FirefoxOptions profile1 = options.setProfile(profile);
		FirefoxDriver driver = new FirefoxDriver(profile1);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://enos.itcollege.ee/~jpoial/allalaadimised/reading/");
		/*WebElement pdf = driver.findElementByLinkText("Advanced-java.pdf");
		pdf.click();*/
		driver.get("https://www.win-rar.com/predownload.html");
		driver.findElementByLinkText("Download WinRAR").click();
		Thread.sleep(5000);


	}

}