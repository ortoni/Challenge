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

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class IframeScreens {
	static int i=200;
	@Test
	public void alertSnap() throws IOException, AWTException, InterruptedException{
		//System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/draggable/");
		driver.switchTo().frame(0);
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs, new File("./snap/a.jpg"));
	}
	public void takeSnap() throws IOException, AWTException {
		BufferedImage img = new Robot()
				.createScreenCapture(
						new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		BufferedImage subimage = img.getSubimage(i, i, i, i);
		ImageIO.write(subimage, "png", new File("./snap/"+i+".png"));
		i++;
	}

}
