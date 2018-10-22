package wms;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class InboundShipments {
	WebDriverWait wait;
	ChromeDriver driver;
	Actions act;	
	@Test
	public void inbound() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 30);
		act = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize(); 
		driver.get("https://p1.logfireapps.com/itorizons/index/");
		driver.findElementById("username").sendKeys("sample.login");
		driver.findElementById("password").sendKeys("Welcome!23");
		driver.findElementByName("btnActive").click();
		driver.findElementByXPath("//span[@class='dijitReset dijitInline dijitIcon menuBtn']/*").click();
		WebElement inputInterface = driver.findElementByXPath("(//span[text()='Input Interfaces'])[3]");
		try {
			inputInterface.click();
		} catch (WebDriverException e) {
			System.out.println("Catch block "+e.getMessage());
			moveToElement(inputInterface);
		}
		driver.findElementByXPath("(//input[contains(@id,'dijit_form_FilteringSelect')])[2]/preceding::div[2]/input").click();
		driver.findElementByXPath("//div[text()='Inbound Shipment']").click();
		WebElement uploadText = driver.findElementByXPath("//span[text()='Upload Files']");
		wait.until(ExpectedConditions.elementToBeClickable(uploadText));
		uploadText.click();
		driver.findElementByXPath("//input[@type='file']").sendKeys("K://ISS_FLOW PL - Case level - Single SKU.xls");
		WebElement uploadButton = driver.findElementByXPath("//span[text()='Upload']");
		uploadButton.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement runInterface = driver.findElementByXPath("//span[text()='Run Interface']");
		elementToBeClickable(runInterface);
		WebElement loader = driver.findElementByXPath("(//div[text()='Please wait...']/preceding::img[1])[5]");
		waitUntilInvisibility(loader);
		driver.findElementByXPath("//span[text()='OK']").click();
		driver.quit();

	}
	private void elementToBeClickable(WebElement runInterface) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(runInterface)).click();
		} catch (WebDriverException e) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			moveToElement(runInterface);
		}
	}
	private void waitUntilInvisibility(WebElement loader) {
		wait.until(ExpectedConditions.invisibilityOf(loader));
	}
	private void moveToElement(WebElement inputInterface) {
		act.moveToElement(inputInterface).pause(100).click();
	}

}
