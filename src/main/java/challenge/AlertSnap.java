package challenge;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AlertSnap {
	static int i=200;
	@Test
	public void alertSnap() throws IOException, AWTException, InterruptedException{
		//System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		WebElement left = driver.findElementByXPath("//div[@class='grid_7']/img");
		WebElement right =driver.findElementByXPath("//div[@class='grid_9']/img");
		int y = right.getLocation().getY();
		int y2 = left.getLocation().getY();
		int x2 = left.getLocation().getX();
		WebElement bottom = driver.findElementByXPath("//marquee");
		int x = bottom.getLocation().getX();
		driver.findElementById("loginbutton").click();	

		Thread.sleep(2000);

		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		BufferedImage img = new Robot()
				.createScreenCapture(
						new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		driver.quit();
	}


}
