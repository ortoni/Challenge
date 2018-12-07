package challenge;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollDown {

	public static void main(String[] args) throws InterruptedException, AWTException, IOException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.naukri.com/");
		WebElement reg = driver.findElementByXPath("(//a[text()='Register Now'])[2]");
		int y = reg.getLocation().getY();
		driver.executeScript("scroll(0,"+y+")");
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs, new File("./a.png"));
		
		
		
		
		
		
		
		
		
	}
}
