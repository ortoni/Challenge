package challenge;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDemo {

	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(op);
		op.setHeadless(true);
//		op.addArguments("--allow-silent-push");
		op.addArguments("--disable-translate-new-ux");

		driver.get("https://www.google.co.in/");
		System.out.println(driver.getTitle());
		//driver.findElementById("gs_st0").click();
		//System.out.println(driver.getTitle());
		//driver.switchTo().alert().accept();
	}

}
