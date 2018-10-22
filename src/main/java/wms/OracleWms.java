/*
 * 	Date: 18-09-2018
	TOTAL TIME TAKEN: 01 hrs 10 mins
	Challenges faced:
		1) Identifying locators
		2) Handling script loading wait and wait for locators
		3) Handling with date picker
 */
package wms;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class OracleWms {
	RemoteWebDriver driver;
	WebDriverWait wait;

	@Test
	public void oracle() throws InterruptedException {
		String poNumber = "PO234567820";

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://p1.logfireapps.com/itorizons/index/");
		driver.findElementById("username").sendKeys("sample.login");
		driver.findElementById("password").sendKeys("Welcome!23");
		driver.findElementByName("btnActive").click();
		driver.findElementByXPath("//span[@widgetid='lgf_main_menu']").click();
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable
				(By.xpath("(//span[text()='Purchase Orders'])[3]")));
		try {
			driver.findElementByXPath("(//span[text()='Purchase Orders'])[3]").click();
		} catch (Exception e) {
			// TODO Auto-generated catch block

		}
		WebElement addButton = driver.findElementByXPath("//span[@title='Create']");
		Actions act = new Actions(driver);
		act.moveToElement(addButton).pause(5000).click().perform();
		//.click();
		driver.findElementById("view_widgets_KeyTextFieldWidget_0").sendKeys(poNumber);
		driver.findElementByXPath("(//label[text()='Vendor'])[2]/following::span[1]").click();
		WebElement searchButton = driver.findElementByXPath("(//label[text()='Country'])[2]/following::span[text()='Search']");
		wait.until(ExpectedConditions.elementToBeClickable(searchButton));
		act.moveToElement(searchButton).pause(1000).click().perform();
		//.click();
		WebElement table = driver.findElementByXPath("(//table[@class='dgrid-row-table'])[4]/tr/td[2]");
		act.moveToElement(table).pause(2000).click().perform();
		WebElement okButton = driver.findElementByXPath("//span[text()='OK']");
		act.moveToElement(okButton).pause(2000).click().perform();
		Thread.sleep(1000);
		driver.findElementByXPath("(//input[@class='dijitReset dijitInputField dijitArrowButtonInner'])[3]/..").click();
		Thread.sleep(1000);
		driver.findElementByXPath("//span[text()='18']/..").click();
		driver.findElementByXPath("(//input[@class='dijitReset dijitInputField dijitArrowButtonInner'])[4]/..").click();
		Thread.sleep(1000);
		driver.findElementByXPath("(//span[text()='19']/..)[2]").click();
		Thread.sleep(1000);
		driver.findElementByXPath("(//input[@class='dijitReset dijitInputField dijitArrowButtonInner'])[5]/..").click();
		driver.findElementByXPath("(//span[text()='18']/..)[3]").click();
		Thread.sleep(1000);
		driver.findElementByXPath("(//input[@class='dijitReset dijitInputField dijitArrowButtonInner'])[6]/..").click();
		driver.findElementByXPath("(//span[text()='18']/..)[4]").click();
		Thread.sleep(1000);
		WebElement savebutton = driver.findElementByXPath("//span[text()='Save']");
		act.moveToElement(savebutton).pause(250).click().perform();
		Thread.sleep(1000);
		WebElement data = driver.findElementByXPath("//div[@class='dgrid-content ui-widget-content']//table/tr/td[3]");
		if (data.getText().equals(poNumber)) {
			System.out.println("Test Case Passed");
		}else {
			System.out.println("Test Case Failed, The PO number is: "+ data.getText());
		}

	}

}
