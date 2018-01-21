package page;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import myDriver.GenericWrapper;

public class Insta extends GenericWrapper {
	@Test
	public void browser() throws IOException{
		launchBrowser("https://www.instagram.com/");	

	}

	@Test
	public void logIn() throws IOException {
		clickByLinkText("Log in");
		enterByXpath("//input[contains(@placeholder,'Phone')]", "chatterjee_kous");
		enterByXpath("//input[contains(@placeholder,'Password')]", "");
		clickByXpath("//button");	

	}

	@Test
	public void mainPage() throws InterruptedException, InvalidFormatException, IOException  {
		clickByXpath("//a[contains(@class,'NavProfile')]");
		clickByXpath("//a[contains(@href,'followers')]");

		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		

		List<WebElement> friendName = driver.findElementsByXPath("//div[@class='_9mmn5']");
		wait.until(ExpectedConditions.elementToBeClickable((By) friendName));
		int newFrnd = friendName.size();

		Actions act = new Actions(driver);
		int oldFrnd = 0;

		while(newFrnd != oldFrnd) {
			oldFrnd = newFrnd;
			WebElement lastFrnd = friendName.get(friendName.size()-1);
			act.moveToElement(lastFrnd).build().perform();
			Thread.sleep(2000);
			friendName = driver.findElementsByXPath("//div[@class='_9mmn5']");
			newFrnd = friendName.size();
			System.out.println("Total : "+friendName.size());			
		}
		String text="";
		for (WebElement followers : friendName){
			System.out.println(followers.getText());
			text = followers.getText();
		}

		
		XSSFWorkbook wbook = new XSSFWorkbook();
		XSSFSheet sheetName = 	wbook.createSheet("Wbook");
		int rowA = friendName.size();
		int columnA = 0;
		Row row = sheetName.createRow(rowA);
		Cell cell = row.createCell(columnA);
		cell.setCellValue(text);
		FileOutputStream fo = new FileOutputStream("./data/insta.xlsx");
		wbook.write(fo);

		fo.close();
		wbook.close();
	}


}

