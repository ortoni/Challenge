package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LoginPage;
import wdMethods.ProjectMethods;

public class TC001_CreateLead extends ProjectMethods {

	@BeforeTest(groups="common")
	public void setData() {
		testCaseName = "TC001_CreateLead";
		testDescription ="Create a lead";
		category = "Smoke";
		authors= "sarath";
		testNodes = "Leads";
		dataSheetName="TC001";
	}
	@Test(dataProvider="fetchData")
	public  void createLead(String uname, String pwd,String cname, String fname, String lname, String email)   {
     new LoginPage()
     .typeUsername(uname)
     .typePassword(pwd)
     .clickLogin()
     .clickCrmsfa()
     .clickLeads()
     .clickCreateLead()
     .typeCompanyName(cname)
     .typeFirstName(fname)
     .typeLastName(lname)
     .typeEmail(email)
     .clickCreateButton();

	}


}
