package challenge;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateLeadWithDataProvicer_indices {

	@Test(dataProvider = "fetchData")
	public void createLead(String cName, String fName, String lName) {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();

		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Create Lead").click();

		driver.findElementById("createLeadForm_companyName").sendKeys(cName);
		driver.findElementById("createLeadForm_firstName").sendKeys(fName);
		driver.findElementById("createLeadForm_lastName").sendKeys(lName);
		driver.findElementByName("submitButton").click();
		driver.close();
	}
	
	@DataProvider(name = "fetchData", indices = {0,3})
	public Object[][] getData() {
		
		Object[][] data = new Object[4][3];
		
		data[0][0] = "TestLeaf";
		data[0][1] = "Gopinath";
		data[0][2] = "Jayakumar";
		
		data[1][0] = "TestLeaf";
		data[1][1] = "Sarath";
		data[1][2] = "M";
		
		data[2][0] = "TestLeaf";
		data[2][1] = "Koushik";
		data[2][2] = "M";
		
		data[3][0] = "TestLeaf";
		data[3][1] = "Gayathri";
		data[3][2] = "M";
		
		return data;		
	}

}
