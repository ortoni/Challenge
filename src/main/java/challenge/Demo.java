package challenge;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Demo {
	/*public Demo() {
		// TODO Auto-generated constructor stub
		String property = System.getProperty("browser");
		if(property.equalsIgnoreCase("ff")) {
			ChromeDriver d = new ChromeDriver();
		}
	}*/
	@Test
	public void tes()
	{
		String property = System.getProperty("browser");
		if(property.equalsIgnoreCase("ff")) {
			ChromeDriver d = new ChromeDriver();
			//			d.get});
		}
		/*System.out.println("running");
		System.out.println();*/
	}

}
