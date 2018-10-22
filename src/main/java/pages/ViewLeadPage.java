package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import wdMethods.ProjectMethods;

public class ViewLeadPage extends ProjectMethods {

	public ViewLeadPage() {		
	PageFactory.initElements(driver, this);
	}
	@FindBy(className="decorativeSubmit")
	WebElement eleLogOut;
	public ViewLeadPage verify() {
	System.out.println("create lead success");
	return this;
	}
}







