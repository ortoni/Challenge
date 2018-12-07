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
		driver.findElementByXPath("//span[text()='AGENT LOGIN']").click();
		driver.findElementById("loginbutton").click();
		Thread.sleep(1000);
		// take snap		
		BufferedImage image = new Robot().createScreenCapture
		(new Rectangle(
				Toolkit.getDefaultToolkit().getScreenSize()));
		
		ImageIO.write(image, "png", new File("./snaps/Alert.png"));
	}


}
