package challenge;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class DownInter {
	public static void main(String[] args) throws InterruptedException {
		InternetExplorerOptions op = new InternetExplorerOptions();
		InternetExplorerDriver driver = new InternetExplorerDriver(op);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://leafground.com/pages/download.html");
		driver.findElementByLinkText("Download xls").click();
		Thread.sleep(7000);
		driver.quit();
	}

}
