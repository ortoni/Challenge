package challenge;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ZoomPage {
	ChromeDriver driver;

	@Test
	public void main() throws IOException {
		// System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/draggable/");
		// WebElement drag = d.findElementByLinkText("Draggable");
		takeSnap();
		driver.switchTo().frame(0);
		driver.executeScript("document.body.style.zoom='170%'", "");
		takeSnap();
		// d.quit();
	}

	int i = 1;

	public long takeSnap() throws IOException {

		File src = driver.getScreenshotAs(OutputType.FILE);

		File dest = new File("./snap/ZoomPage" + i + ".jpg");
		try {
			FileUtils.copyFile(src, dest);
		} catch (Exception e) {
			System.out.println("File exception occured");
		}
		i++;
		return 0;
	}
}
