package challenge;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDemo {

	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--disable-notifications");
		op.addArguments("--allow-silent-push");
		ChromeDriver driver = new ChromeDriver(op);

		driver.get("https://www.google.co.in/");
		driver.findElementById("gs_st0").click();
		//System.out.println(driver.getTitle());
		//driver.switchTo().alert().accept();
	}

}
