package challenge;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementSnap {
	public static void main(String[] args) throws IOException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.findElementById("username").sendKeys("DemoSalesManager", Keys.TAB, 
				"crmsfa");
		WebElement button = driver.findElementByClassName("decorativeSubmit");
		// capture particular element
		File src = button.getScreenshotAs(OutputType.FILE);
		File dst = new File("./snaps/im.png");
		FileUtils.copyFile(src, dst);
		button.click();
		driver.quit();
	}
}
