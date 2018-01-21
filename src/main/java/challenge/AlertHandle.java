package challenge;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AlertHandle {
	public static void main(String[] args) throws HeadlessException, IOException, AWTException {

		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.setHeadless(false);
		opt.addArguments("--maximize");
		ChromeDriver driver = new ChromeDriver(opt);

		driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf");

		String img = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		
		
		
		WebElement button = driver.findElementById("loginbutton");
		button.click();
		
		
		//DatePickerAndScroll.takeSnap();

		Alert alt = driver.switchTo().alert();

		String alertText = alt.getText();
		System.out.println(alertText);
		alt.accept();

		driver.close();
	}

}