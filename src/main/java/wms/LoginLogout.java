/*
 * Total time taken: 20 mins
 * challenges:
		 - Handling wait for alert
		 - Handling visibility of elements
 * 
 */
package wms;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LoginLogout {
	WebDriverWait wait;
	ChromeDriver driver;
	@Test
	public void loginLogout() throws InterruptedException {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 30);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize(); 
		driver.get("https://p1.logfireapps.com/itorizons/index/");
		driver.findElementById("username").sendKeys("sample.login");
		driver.findElementById("password").sendKeys("Welcome!23");
		Set<Cookie> cookies = driver.manage().getCookies();
		cookies.forEach(i -> System.out.println(i));
		driver.findElementByName("btnActive").click();
		driver.findElementById("dijit_form_DropDownButton_1_label").click();
		driver.findElementByXPath("//td[text()='launch dashboard']").click();
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		WebElement xButton = driver.findElementByXPath("//span[text()='x']/..");
		wait.until(ExpectedConditions.visibilityOf(xButton));
		xButton.click();
		Thread.sleep(1000);
		driver.findElementById("dijit_form_DropDownButton_1_label").click();
		driver.findElementByXPath("//td[text()='Logout']").click();


	}

}
