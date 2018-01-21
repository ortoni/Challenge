package myDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GenericWrapper implements Wrapper{

	protected static RemoteWebDriver driver;
	int i = 1;

	public void launchBrowser(String url) throws IOException {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Entered url is "+url);
		takeSnap();
	}

	public void takeSnap() throws IOException {
		File src = driver.getScreenshotAs(OutputType.FILE);	
		File dest = new File("./Snap/img"+i+".jpg");
		FileUtils.copyFile(src, dest);
		i++;
	}

	public void enterById(String id, String value) throws IOException {
		try {
			WebElement ele = driver.findElementById(id);		
			ele.clear();
			ele.sendKeys(value);
			System.out.println("id is "+id+ " and passed with the vale"+value);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}finally {
			takeSnap();
		}
	}

	public void enterByName(String name, String value) throws IOException {
		try {
			WebElement ele = driver.findElementByName(name);		
			ele.clear();
			ele.sendKeys(value);
			System.out.println("name is "+name+ " and passed with the vale"+value);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			takeSnap();
		}	
	}

	public void clickByLinkText(String linkText) throws IOException {
		try {
			driver.findElementByLinkText(linkText).click();;	
			System.out.println("Current url is "+driver.getCurrentUrl()+" after clicking the linktext of "+linkText);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			takeSnap();
		}
	}

	public void enterByClass(String classValue, String value) throws IOException {
		try {
			WebElement ele = driver.findElementByClassName(classValue);
			ele.clear();
			ele.sendKeys(value);
			System.out.println("name is "+classValue+ " and passed with the vale"+value);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			takeSnap();
		}
	}

	public void enterByTag(String tagName, String value) throws IOException {
		try {
			WebElement ele = driver.findElementByTagName(tagName);
			ele.clear();
			ele.sendKeys(value);
			System.out.println("name is "+tagName+ " and passed with the vale"+value);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			takeSnap();
		}

	}

	public void enterByXpath(String xpath, String value) throws IOException {
		try {
			WebElement ele = driver.findElementByXPath(xpath);
			ele.clear();
			ele.sendKeys(value);
			System.out.println("name is "+xpath+ " and passed with the value "+value);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			takeSnap();
		}
	}

	public void clickByid(String id) throws IOException {
		try {
			WebElement ele = driver.findElementById(id);
			ele.click();
			//ele.toString();
			System.out.println(ele+" is clicked");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			takeSnap();
		}
	}

	public void clickByXpath(String xpath) {
		WebElement ele = driver.findElementByXPath(xpath);
		ele.click();
		//ele.toString();
		System.out.println(ele.toString()+" is clicked");
		try {
			takeSnap();
		} catch (IOException e) {
		e.printStackTrace();
		}
	}

	public void clickByName(String name) {
		WebElement ele = driver.findElementByName(name);
		ele.click();
		System.out.println(ele+" is clicked");
		try {
			takeSnap();
		} catch (IOException e) {
		e.printStackTrace();
		}
	}

	public void clickByClass(String clas) {
		WebElement ele = driver.findElementByClassName(clas);
		ele.click();
		System.out.println(ele+" is clicked");
		try {
			takeSnap();
		} catch (IOException e) {
		e.printStackTrace();
		}

	}

	public void clickBytag(String tag) {
		WebElement ele = driver.findElementByTagName(tag);
		ele.click();
		System.out.println(ele+" is clicked");
		try {
			takeSnap();
		} catch (IOException e) {
		e.printStackTrace();
		}

	}

}

