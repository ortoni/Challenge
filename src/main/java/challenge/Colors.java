package challenge;

import java.awt.Color;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Colors {
	
	@Test
	public void main() {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://leaftaps.com/opentaps/control/main");
		WebElement but = driver.findElementByXPath("//input[@class='decorativeSubmit']");
		String cssValue = but.getCssValue("color");
		System.out.println(cssValue);
		Color col = new Color(255,255, 255);
				System.out.println(col);
		
	}

}
