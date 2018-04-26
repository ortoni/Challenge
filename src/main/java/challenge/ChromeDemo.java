package challenge;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(op);

		

		// Headless mode
		//ch.setHeadless(true);

		//To run in private mode
		//ch.addArguments("-incognito");

		//To disable automation browser running infobar
		//ch.addArguments("disable-infobars");

		//To maximize the browser
		//ch.addArguments("start-maximized");

		//To run the browser in full screen
	

		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
	}

}
