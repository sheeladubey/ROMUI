package com.gsicommerce.romui.selenium.utilities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Webtable {

	private WebDriver _driver;
	public Collection<WebElement> ColCollection;
	public static Collection<WebElement> RowCollection;
	public static WebElement Table;
	private static String _xpath = "";

	public Webtable(WebDriver driver, WebElement el) {
		_driver = driver;
		_driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Table = el;
		RowCollection = Table.findElements(By.xpath(".//tr")); //// div//table//tbody
	}

	public static int GetNumOfRows() {
		return RowCollection.size();
	}

	/// <summary>
	/// This method returns whether the expected text is present within a table row
	/// </summary>
	/// <param name="rowNum">The row number to be searched for the string
	/// presence@param
	/// <param name="stringToSearch">The search string@param
	/// <returns></returns>
	public Boolean isTableRowContains(int rowNum, String stringToSearch) {
		_xpath = String.format(".//tr[{0}]", rowNum);
		Collection<WebElement> rowCollectioninput = Table.findElements(By.xpath(_xpath));
		for (WebElement item : rowCollectioninput) {
			if (item.getText().contains(stringToSearch))
				return true;
		}
		return false;
	}

	// Save all the column values into an array
	public List<String> getInputColumnValues(int col) {

		_xpath = String.format(".//td[{0}]/input", col);
		Collection<WebElement> rowCollectioninput = Table.findElements(By.xpath(_xpath));
		List<String> _colValues = new ArrayList<String>();
		for (WebElement item : rowCollectioninput) {
			_colValues.add(item.getAttribute("value"));
		}
		return _colValues;
	}

	/// <summary>
	/// Get RowNum for a specified Column# and CellText
	/// </summary>
	/// <param name="cellText">@param
	/// <param name="col">@param
	/// <returns></returns>
	public int getTableRowNum(String cellText, int col, int inputChild) {
		int rowNum = 0;
		for (int i = 1; i <= RowCollection.size(); i++) {
			if (getInputCellValue(i, col, inputChild).trim() == cellText.trim()) {
				rowNum = i;
				break;
			}
		}
		return rowNum;
	}

	public String getInputCellValue(int row, int col, int inputChild) {
		if (inputChild == 0) {
			_xpath = String.format(".//tr[{0}]/td[{1}]/input", row, col); // input
		} else {
			_xpath = String.format(".//tr[{0}]/td[{1}]/input[{2}]", row, col, inputChild); // input
		}
		WebElement el = Table.findElement(By.xpath(_xpath));
		scrollToElement(el, _driver);
		return Table.findElement(By.xpath(_xpath)).getAttribute("value");

	}

	public static void scrollToElement(WebElement el, WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", el);
	}

	public static String getTableCellText(int row, int col) {
		_xpath = String.format(".//tr[" + row + "]/td[" + col + "]", row, col);
		return Table.findElement(By.xpath(_xpath)).getText();
	}

	public static String getTableCellText(int col) {
		_xpath = String.format(".//tr/td[" + col + "]", col);
		return Table.findElement(By.xpath(_xpath)).getText();
	}

	public String getTableRowCellText(int row) {
		_xpath = String.format(".//tr[{0}]/td", row);
		return Table.findElement(By.xpath(_xpath)).getText();
	}

	public String getInputCellValueRow0(int col, int inputChild) {
		if (inputChild == 0) {
			_xpath = String.format(".//tr/td[{0}]/input", col); // input
		} else {
			_xpath = String.format(".//tr/td[{0}]/input[{1}]", col, inputChild); // input
		}
		WebElement el = Table.findElement(By.xpath(_xpath));
		scrollToElement(el, _driver);
		return Table.findElement(By.xpath(_xpath)).getAttribute("value");

	}

	/// <summary>
	/// Get particular row value
	/// </summary>
	/// <param name="row">@param
	/// <returns></returns>
	public static String getRowText(int row) {
		_xpath = String.format(".//tr[" + row + "]", row);
		return Table.findElement(By.xpath(_xpath)).getText();
	}

	public static String getRowText(int row, int col) {
		_xpath = String.format(".//tr[" + row + "]/td[" + col + "]/span", row, col);
		return Table.findElement(By.xpath(_xpath)).getText();
	}

	public void setInputCellTextValue(int row, int col, String text) {
		if (row == 0) {
			_xpath = String.format(".//tr/td[{1}]/input", col);
		} else {
			_xpath = String.format(".//tr[{0}]/td[{1}]/input", row, col);
		}
		Table.findElement(By.xpath(_xpath)).clear();
		Table.findElement(By.xpath(_xpath)).sendKeys(text);
	}

	/// <summary>
	/// This method finds the selects webElement from the dropdown in a table
	/// </summary>
	/// <param name="row">@param
	/// <param name="col">@param

	public WebElement setDropDownValue(int row, int col) {
		_xpath = String.format(".//tr[{0}]/td[{1}]/select", row, col);
		return Table.findElement(By.xpath(_xpath));
	}

	public void clickIcon(int row, int col, int child) {
		if (child == 0) {
			_xpath = String.format(".//tr[" + row + "]/td[" + col + "]/div/a", row, col);
		} else {
			_xpath = String.format(".//tr[" + row + "]/td[" + col + "]/div/a[" + child + "]", row, col);
		}
		Table.findElement(By.xpath(_xpath)).click();

	}

	// For pipeline screen-need to include span child as well
	public void clickIconPipeline(int row, int col, int child, int spanchild) throws InterruptedException {

		if (child == 0) {
			_xpath = String.format(".//tr[" + row + "]/td[" + col + "]/div/a/span", row, col);
		} else {
			_xpath = String.format(".//tr[" + row + "]/td[" + col + "]/div/a[" + child + "]/span[" + spanchild + "]",
					row, col);
		}
		Action.scrollingToBottomofAPage();
		Action.clickElementJavaScipt(Table.findElement(By.xpath(_xpath)));
	}

//For clicking delete icon on pipeline screen.
	public void clickDeleteIconPipeline(int row, int col, int spanchild) throws InterruptedException {

		_xpath = String.format(".//tr[" + row + "]/td[" + col + "]/div/button/span[" + spanchild + "]", row, col);
		Action.scrollingToBottomofAPage();
		Action.clickElementJavaScipt(Table.findElement(By.xpath(_xpath)));
	}

	public void clickSpanElement(int row, int col) {
		_xpath = String.format(".//tr[{0}]/td[{1}]/*/span", row, col);
		Table.findElement(By.xpath(_xpath)).click();
	}

	/// <summary>
	/// Click on a link @given row and column
	/// </summary>
	/// <param name="row">@param
	/// <param name="col">@param
	public void clickLinkElement(int row, int col) {
		_xpath = String.format(".//tr[{0}]/td[{1}]/a", row, col);
		if (row == 0) {
			_xpath = String.format(".//tr/td[{1}]/a", row, col);
		}

		Table.findElement(By.xpath(_xpath)).click();
	}

	/// <summary>
	/// Get RowNum for a specified Column# and CellText
	/// </summary>
	/// <param name="cellText">@param
	/// <param name="col">@param
	/// <returns></returns>
	public int getTableRowNumForCellText(String cellText, int col) {
		int rowNum = 0;
		for (int i = 1; i < RowCollection.size(); i++) {
			if (getTableCellText(i, col).trim().contains(cellText.trim())) {
				rowNum = i;
				break;
			}
		}
		return rowNum;
	}
	
	public void clickIconDelete(int row, int col, int child,int spanchild) {
		if (child == 0) {
			_xpath = String.format(".//tr[" + row + "]/td[" + col + "]/div/button/span["+ spanchild +"]", row, col);
		} else {
			_xpath = String.format(".//tr[" + row + "]/td[" + col + "]/div/button[" + child +"]/span["+ spanchild +"]", row, col);
		}
		
		Table.findElement(By.xpath(_xpath)).click();

	}
	
	//Click view order and view audits icon on Order lookup screen
	public void clickIconViewOrder(int row,int col,int divchild,int child,int spanchild) {		
		if (divchild == 0) {
		//	_xpath = String.format(".//tr[" + row + "]/td[" + col + "]/div/a[" + child + "]/span[" + spanchild + "]", row, col);
			_xpath = String.format(".//tr[" + row + "]/td[" + col + "]/div/a/span", row, col);
		} else {
			_xpath = String.format(".//tr[" + row + "]/td[" + col + "]/div["+divchild+"]/a[" + child + "]/span[" + spanchild + "]",
					row, col);
		}
		Action.scrollingToBottomofAPage();
		Action.clickElementJavaScipt(Table.findElement(By.xpath(_xpath)));
		
	}

	
}
