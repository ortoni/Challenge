package challenge;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerAndScroll {
	static int i = 1;
	public static void main(String[] args) throws IOException, HeadlessException, AWTException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/datepicker/");

		takeSnap();

/*		File src = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./S/img.jpg");
		FileUtils.copyFile(src, dest);*/

		WebElement sw = driver.findElementByClassName("demo-frame");
		driver.switchTo().frame(sw);


		WebElement date = driver.findElementById("datepicker");
		date.clear();
		date.sendKeys("04/12/1994");
		date.sendKeys(Keys.TAB);
		takeSnap();
		driver.switchTo().parentFrame();
		takeSnap();
		((JavascriptExecutor)driver).executeScript("scroll(0,1600)");
		Thread.sleep(5000);

		takeSnap();

		driver.quit();
	}
	public static void takeSnap() throws IOException, HeadlessException, AWTException {
		BufferedImage img = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		ImageIO.write(img, "jpg", new File("./S/"+i+".jpg"));
		i++;
	}
}
