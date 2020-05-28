package com.gsicommerce.romui.selenium.utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.gsicommerce.romui.selenium.testdata.Environment;
import com.gsicommerce.romui.selenium.utilities.Action;
import com.gsicommerce.romui.selenium.utilities.AssertingWebElement;


public class Webtable_Old extends Action {
    public WebElement webtable;

    public Webtable_Old(final WebElement element, final WebDriver driver,
            final Environment env) {
        super(driver, env);
        this.webtable = element;
    }

    /**
     * This method will return whether webtable exists
     *
     * @return
     */
    public boolean exists() {
        if (null == this.webtable || ((AssertingWebElement) this.webtable).exists() == false) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * This method will return the index of the column
     *
     * @param columnHeader
     * @return int - index of the column. If column not found, then -1 will be
     *         returned.
     */
    public int getColumnIndex(final String columnHeader) {
        enableExplicitWait();
        try {
            WebElement rowData;
            final WebElement temp = this.webtable;
            rowData = getRowData(columnHeader);
            this.webtable = temp;

            disableWait();

            // search the th elements
            final List<WebElement> thColumns = rowData.findElements(By
                    .xpath("th"));
            for (int i = 0; i < thColumns.size(); i++) {
                if (thColumns.get(i).getText().equalsIgnoreCase(columnHeader)) {
                    return i;
                }
            }

            // search the td elements
            final List<WebElement> tdColumns = rowData.findElements(By
                    .xpath("td"));
            for (int i = 0; i < tdColumns.size(); i++) {
                if (tdColumns.get(i).getText().equalsIgnoreCase(columnHeader)) {
                    return i;
                }
            }

            return -1;
        } finally {
            enableWait();
        }
    }

    /**
     * This method will search through the column and returns whether it found
     * the expected value
     *
     * @param columnHeader
     *            - header text of the column to be searched.
     * @param expValue
     *            - expected value
     * @return boolean
     */
    public boolean findCellData(final String columnHeader, final String expValue) {
        final WebElement cell = getCellData(columnHeader, expValue);

        return ((AssertingWebElement) cell).exists();
    }

    /**
     * To get the cell data using column header and the text passed in.
     * searchValue parameter is be used to search for the row where the cell
     * resides.
     *
     * @param columnHeader
     * @param searchValue
     * @return GsiWebElement
     */
    public WebElement getCellData(final String columnHeader,
            final String searchValue) {
        disableWait();
        try {
            final WebElement rowData = getRowData(searchValue);
            if (!((AssertingWebElement) rowData).exists()) {
                return new AssertingWebElement(null);
            }
            final int columnIndex = getColumnIndex(columnHeader);
            return new AssertingWebElement(rowData.findElements(
                    By.xpath(".//td")).get(columnIndex));
        } finally {
            enableWait();
        }
    }

    /**
     * To get the cell data using column header and the text passed in.
     * searchValue parameter is be used to search for the row where the cell
     * resides. This uses exact match instead of String.contains(..)
     *
     * @param columnHeader
     * @param searchValue
     * @return GsiWebElement
     */
    public WebElement getCellDataUsingExactMatch(final String columnHeader,
            final String searchValue) {
        disableWait();
        try {
            final WebElement rowData = getRowDataUsingExactMatch(searchValue);
            if (!((AssertingWebElement) rowData).exists()) {
                return new AssertingWebElement(null);
            }
            final int columnIndex = getColumnIndex(columnHeader);
            return new AssertingWebElement(rowData.findElements(
                    By.xpath(".//td")).get(columnIndex));
        } finally {
            enableWait();
        }
    }

    /**
     * To get the cell data from the row passed in and the column index passed
     *
     * @param rowData
     * @param columnIndex
     * @return GsiWebElement
     */
    public WebElement getCellData(final WebElement rowData,
            final int columnIndex) {
        disableWait();
        try {
            if (!((AssertingWebElement) rowData).exists()) {
                return new AssertingWebElement(null);
            }

            return new AssertingWebElement(rowData.findElements(
                    By.xpath(".//td")).get(columnIndex));
        } finally {
            enableWait();
        }
    }

    /**
     * This method returns the row based on the text provided. Row is selected
     * if any of the column has the text.
     *
     * @param searchValue
     * @return row GsiWebElement
     */
    public WebElement getRowData(final String searchValue) {
        disableWait();
        try {
            WebElement rowData = null;
            final List<WebElement> rows = new ArrayList<WebElement>();

            rows.addAll(getHeaderRows());
            rows.addAll(getBodyRows());

            for (final WebElement row : rows) {
                { // contains
                    if (row.getText().contains(searchValue)) {
                        rowData = row;
                        break;
                    }
                }
            }
            return new AssertingWebElement(rowData);
        } finally {
            enableWait();
        }
    }

    public WebElement getRowDataUsingExactMatch(final String searchValue) {
        disableWait();
        try {
            WebElement rowData = null;
            final List<WebElement> rows = new ArrayList<WebElement>();

            rows.addAll(getHeaderRows());
            rows.addAll(getBodyRows());

            for (final WebElement row : rows) {
                final List<WebElement> wes = row.findElements(By.xpath(".//td"));
                boolean blnmatch = false;
                for (final WebElement we : wes) {
                    if (we.getText().equalsIgnoreCase(searchValue)) {
                        rowData = row;
                        blnmatch = true;
                        break;
                    }
                }
                if (blnmatch) {
                    break;
                }
            }
            return new AssertingWebElement(rowData);
        } finally {
            enableWait();
        }
    }

    /**
     * This method returns row based on the index passed in. For example,
     * index=0, will return the first row.
     *
     * @param index
     * @return GsiWebElement
     */
    public WebElement getRowData(final int index) {
        disableWait();
        try {
            final List<WebElement> rows = new ArrayList<WebElement>();

            rows.addAll(getHeaderRows());
            rows.addAll(getBodyRows());

            return new AssertingWebElement(rows.get(index));
        } finally {
            enableWait();
        }
    }

    /**
     * This method returns the number of rows of the table
     *
     * @return
     */
    public int getRowCount() {
        disableWait();
        try {
            final List<WebElement> rows = getBodyRows();
            return rows.size();
        } finally {
            enableWait();
        }
    }

    /**
     * This method returns row index of the row based on image in that row. For
     * example, index=1, will return the first row.
     *
     * @param By
     *            imgPath
     * @return int
     */
    public int getRowIndex(final By imgPath) {
        disableWait();
        try {
            int i = 0;
            final List<WebElement> rows = new ArrayList<WebElement>();
            rows.addAll(getHeaderRows());
            rows.addAll(getBodyRows());

            for (final WebElement row : rows) {
                try {
                    i = i + 1;
                    final WebElement we = row.findElement(imgPath);
                    if (we != null) {
                        break;
                    }
                } catch (final NoSuchElementException e) {
                }
            }
            return i;
        } finally {
            enableWait();
        }
    }

    /**
     * Get the values for a given column and return them in order as a List
     *
     * @param columnName
     *            : The name of the column to get the values from
     * @return List<GsiWebElement> : A list with the values for the column in
     *         the order they appear on the page
     */
    public List<WebElement> getColumnValues(final Integer columnIndex) {
        final List<WebElement> valuesList = new ArrayList<WebElement>();

        for (int i = 0; i < getRowCount(); i++) {
            valuesList.add(getCellData(getRowData(i), columnIndex));
        }

        return valuesList;
    }

    /**
     * Get a list of all the header rows of the table, if there is no header, an
     * empty list will be returned.
     *
     * @return List
     */
    private List<WebElement> getHeaderRows() {
        try {
            return webtable.findElement(By.xpath("./thead")).findElements(
                    By.xpath("./tr"));
        } catch (final NoSuchElementException e) {
            return new ArrayList<WebElement>();
        } catch (final NullPointerException e) {
            return new ArrayList<WebElement>();
        } catch (final AssertionError e) {
            return new ArrayList<WebElement>();
        }
    }

    /**
     * Get a list of all the body rows of the table, if there is no body, an
     * empty list will be returned.
     *
     * @return List
     */
    private List<WebElement> getBodyRows() {
        try {
            return webtable.findElement(By.xpath("./tbody")).findElements(
                    By.xpath("./tr"));
        } catch (final NoSuchElementException e) {
            return new ArrayList<WebElement>();
        } catch (final NullPointerException e) {
            return new ArrayList<WebElement>();
        } catch (final AssertionError e) {
            return new ArrayList<WebElement>();
        }
    }
}
