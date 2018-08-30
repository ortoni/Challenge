package challenge;

import java.awt.AWTException;

import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollDown {

	public static void main(String[] args) throws InterruptedException, AWTException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.naukri.com/");
		int y = driver.findElementByLinkText("Browse All Jobs").getLocation().getY();
		driver.executeScript("scroll(0,"+y+");");
		
	}
}
