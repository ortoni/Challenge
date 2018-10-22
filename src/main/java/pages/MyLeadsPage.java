package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import wdMethods.ProjectMethods;

public class MyLeadsPage extends ProjectMethods {

	public MyLeadsPage() {		
	PageFactory.initElements(driver, this);
	}
	@FindBy(linkText="Create Lead")
	WebElement eleCreateLead;
	public CreateLeadPage clickCreateLead() {
	click(eleCreateLead);
	return new CreateLeadPage();
	}
}







