package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import wdMethods.ProjectMethods;

public class CreateLeadPage extends ProjectMethods {

	public CreateLeadPage() {		
	PageFactory.initElements(driver, this);
	}
	@FindBy(id="createLeadForm_companyName")
	WebElement eleCname;
	public CreateLeadPage typeCompanyName(String data) {
	type(eleCname, data);
	return this;
	}
	@FindBy(id="createLeadForm_firstName")
	WebElement eleFname;
	public CreateLeadPage typeFirstName(String data) {
	type(eleFname, data);
	return this;
	}
	@FindBy(id="createLeadForm_lastName")
	WebElement eleLname;
	public CreateLeadPage typeLastName(String data) {
	type(eleLname, data);
	return this;
	}
	@FindBy(id="createLeadForm_primaryEmail")
	WebElement eleEmail;
	public CreateLeadPage typeEmail(String data) {
	type(eleEmail, data);
	return this;
	}
	@FindBy(className="smallSubmit")
	WebElement eleCreateButton;
	public ViewLeadPage clickCreateButton() {
	click(eleCreateButton);
	return new ViewLeadPage();
	}
	
}







