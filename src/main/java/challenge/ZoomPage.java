package challenge;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ZoomPage {
	ChromeDriver d ;
	@Test
	public void main() throws IOException {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		d = new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://jqueryui.com/draggable/");
		takeSnap();
		d.switchTo().frame(0);
		d.executeScript("document.body.style.zoom='170%'", "");
		takeSnap();
		d.quit();
	}
	int i =1;
	public long takeSnap() throws IOException {

		File src = d.getScreenshotAs(OutputType.FILE);
		
		File dest = new File("./snap/ZoomPage"+i+".jpg");
		try {
			FileUtils.copyFile(src, dest);
		} catch (Exception e) {
			System.out.println("File exception occured");
		}
		i++;
		return 0;
	}
}
