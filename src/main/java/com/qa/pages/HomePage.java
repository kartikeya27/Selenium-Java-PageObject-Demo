package com.qa.pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//span[contains(text(),'Trade')]")
	WebElement tradeLnk;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	// Actions:
	public void tapOnTradeLink() {
		tradeLnk.click();
	}
	
	public void scrollElement(String txt) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.linkText(txt));
		js.executeScript("arguments[0].scrollIntoView();", Element);
		Element.click();
	}

	public void selectRandomRow() {
		for(int i = 1; i < 15; i++){
			Random rnd = new Random();
			List<WebElement> cells = driver.findElements(By.xpath("//*[@data-qa='star-off-icon']//*[@fill-rule='evenodd']"));
			int index = rnd.nextInt(cells.size());
			Actions builder = new Actions(driver);
			builder.click(cells.get(index)).build().perform();
		}
	} 
	
	public void verifyData() {
		//Locate table.
    	WebElement mytable = driver.findElement(By.xpath("//table[@class='table_container__3oBMw watchlist-table_container__1VL47']//tbody"));
    	List < WebElement > rows_table = mytable.findElements(By.tagName("tr"));
    	//To calculate no of rows In table.
    	int rows_count = rows_table.size();
    	//Loop will execute till the last row of table.
    	for (int row = 0; row < rows_count; row++) {
    	    //Locate columns(cells) of that specific row.
    	    List < WebElement > Columns_row = rows_table.get(row).findElements(By.tagName("td"));
    	    //To calculate no of columns (cells). In that specific row.
    	    int columns_count = Columns_row.size();
    	    System.out.println("Number of cells In Row " + row + " are " + columns_count);
    	    for (int column = 0; column < columns_count; column++) {
    	        String celtext = Columns_row.get(column).getText();
    	        System.out.println("Cell Value of row number " + row + " and column number " + column + " Is " + celtext);
    	    }
    	    System.out.println("-------------------------------------------------- ");
    	}
   	}
}
