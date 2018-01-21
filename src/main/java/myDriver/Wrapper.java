package myDriver;

import java.io.IOException;

public interface Wrapper {
	
	public void launchBrowser(String url) throws IOException;
	
		
	public void enterById(String id, String value) throws IOException;
		
	public void enterByName(String name, String value) throws IOException;

	public void clickByLinkText(String linkText) throws IOException;

	public void enterByClass(String classValue, String value) throws IOException;
			
	public void enterByTag(String tagName, String value) throws IOException;
	
	public void enterByXpath(String xpath, String value) throws IOException;
	
	public void clickByid(String id) throws IOException;
	
	public void clickByXpath(String xpath);
	
	public void clickByName(String name);
	
	public void clickByClass(String clas);
	
	public void clickBytag(String tag);
	
	
	public void takeSnap() throws IOException;

}
