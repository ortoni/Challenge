package challenge;

import org.openqa.selenium.chrome.ChromeDriver;

public class CheckLink {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://newtours.demoaut.com/index.php");
		driver.findElementByXPath("//a[text()[normalize-space()='Register here']]").click();
	}

}
