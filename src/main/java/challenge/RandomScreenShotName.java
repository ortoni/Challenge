package challenge;

import java.security.SecureRandom;
import java.util.Random;

public class RandomScreenShotName {

	public static void main(String[] args) {

		/*	System.setProperty("webdriver.chrome.drive", "./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.tamilrockers.tv");*/

		Random ran = new Random();
		int maxRange = 10;
		for(int i = 1; i<= 12; i++) {
			System.out.println(ran.nextInt(maxRange)*10);


		}
		System.out.println("****************************");
		SecureRandom rand = new SecureRandom();
		int maxRang = 10;
		for(int i = 1; i<= 12; i++) {
			System.out.println(ran.nextInt(maxRang)*10);



		}

	}
}
