package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import wdMethods.ProjectMethods;

public class LoginPage extends ProjectMethods {

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
    
	@FindBy(id="username")
	WebElement eleUname;
	@When("Enter the username as (.*)")
	public LoginPage typeUsername(String data) {
		type(eleUname, data);
		return this;    
	}
	@FindBy(id="password")
	WebElement elePassword;
	@And("Enter the password as (.*)")
	public LoginPage typePassword(String data) {
		type(elePassword, data);
		return this;
	}
	@FindBy(className="decorativeSubmit")
	WebElement eleLogin;
@When("Click on login button")
	public HomePage clickLogin() {
		click(eleLogin);
		return new HomePage();		
	}
	public LoginPage verifyLogin() {
	System.out.println("Verification logic");
		return this;
	}
}







