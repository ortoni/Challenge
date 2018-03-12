package challenge;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.chrome.ChromeDriver;

public class UploadUsingRobotClass {

	public static void main(String[] args) throws InterruptedException, AWTException {
		// opening Chrome browser
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		// maximize the browser
		driver.manage().window().maximize();
		// load the browser with url
		driver.get("https://www.naukri.com/");	
		
		//for BrowserName
		driver.getCapabilities().getBrowserName();
		
		driver.findElementById("input_resumeParser").click();

		Thread.sleep(3000);

		// Store the copied text in the clipboard
		
			StringSelection stringSelection = new StringSelection("FILEPATH"); // give your file path eg: "C://resume.pdf"
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

			// Paste it using Robot class
			Robot robot = new Robot();

			// Enter to confirm it is uploaded
			robot.keyPress(KeyEvent.VK_CONTROL);			
			robot.keyPress(KeyEvent.VK_V);
			
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			

			Thread.sleep(5000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			}
	
	

}
