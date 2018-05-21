package challenge;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class ElementSnap {
	ChromeDriver driver;
	ChromeOptions options;
	@Test
	public void main() throws IOException {
		options = new ChromeOptions();
		options.setHeadless(true);
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://leaftaps.com/opentaps/control/main");
		WebElement button = driver.findElementByClassName("decorativeSubmit");
		elementScreenshot(button);
		driver.quit();
	}

	public void elementScreenshot(WebElement ele) throws IOException {
		// Take Snap first
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		int x = ele.getLocation().getX();
		int y = ele.getLocation().getY();
		int width = ele.getSize().getWidth();
		int height = ele.getSize().getHeight();

		//After getting x, y, h & w, crop the image using BufferedImage - getSubimage
		BufferedImage img = ImageIO.read(screenshotAs);
		BufferedImage subimage = img.getSubimage(x, y, width, height);
		ImageIO.write(subimage, "png", new File("./Snap/cropped.png"));
	}

}
