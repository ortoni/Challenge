package testcases;

import org.testng.annotations.Test;

import wdMethods.ProjectMethods;

public class TC002_EditLead extends ProjectMethods {
	
	@Test(dataProvider="fetchData")
	public  void editLead(String phnNumber, String updateCname)  throws InterruptedException {
		click(locateElement("linktext", "Leads"));
		click(locateElement("linktext", "Find Leads"));
		click(locateElement("xpath", "//span[text()='Phone']"));
		type(locateElement("name", "phoneNumber"),phnNumber);
		click(locateElement("xpath", "//button[text()='Find Leads']"));
		Thread.sleep(2000);
		click(locateElement("xpath", "//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		click(locateElement("linktext", "Edit"));
		type(locateElement("id", "updateLeadForm_companyName"),updateCname);
		click(locateElement("class", "smallSubmit"));
		
	}

}
