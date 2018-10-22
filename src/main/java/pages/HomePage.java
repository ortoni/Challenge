package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.And;
import wdMethods.ProjectMethods;

public class HomePage extends ProjectMethods {

	public HomePage() {		
	PageFactory.initElements(driver, this);
	}
	@FindBy(className="decorativeSubmit")
	WebElement eleLogOut;
	@And("click on logout")
	public LoginPage clickLogOut() {
	click(eleLogOut);
	return new LoginPage();
	}
	@FindBy(linkText="CRM/SFA")
	WebElement eleCrmsfa;
	public MyHomePage clickCrmsfa() {
	click(eleCrmsfa);
	return new MyHomePage();
	}
}







