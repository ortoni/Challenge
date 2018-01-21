package challenge;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.chrome.ChromeDriver;

public class Upload {

	public static void main(String[] args) throws AWTException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.naukri.com/");
		System.out.println(driver.getCurrentUrl());

		driver.findElementById("input_resumeParser").click();

		Thread.sleep(2000); // Must require so that pasting file location will get delay so that it can paste in opened windows

		StringSelection sc = new StringSelection("H:\\Koushik Chatterjee.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sc, null);

		//Robot

		Robot rb = new Robot();

		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);

		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(20000);
		driver.quit();
	}

}
