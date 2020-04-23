package com.gsicommerce.romui.selenium.ROMUI.Utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.gsicommerce.romui.selenium.ROMUI.Utilities.GsiWebElement;

public interface GsiWebElement extends WebElement{
	public By getLocator();
    /**
     * Verifies whether the webelement exists or not.
     * 
     * @return boolean
     */
    boolean exists();

    /**
     * Enter value on the webelement. This method should be used only for
     * textboxes.
     * 
     * @param value
     */
    void enter(final String value);

    /**
     * Find the first {@link WebElement} using the given method. See the note in
     * {@link #findElement(By)} about finding via XPath.
     * 
     * @param by
     *            The locating mechanism
     * @return The first matching element on the current context.
     * @throws NoSuchElementException
     *             If no matching elements are found
     */

    GsiWebElement findElement(By by);

    /**
     * Select the displayed text from the list. This method should be used only
     * for listboxes.
     * 
     * @param value
     */
    void select(final String value);

    /**
     * This method will search for the text inside the webelement.
     * 
     * @param expectedText
     * @return boolean
     */
    boolean verifyTextPresentIn(final String expectedText);

    /**
     * This method will search for the text inside the webelement
     * 
     * @param expectedText
     * @return boolean
     */
    boolean isTextPresentIn(final String expectedText);

    /**
     * select a list option by its position in the list
     * 
     * @param i
     *            index
     */
    void selectByIndex(int i);

    /**
     * This method will select based on the value of the list element
     * 
     * @param value
     */
    void selectByValue(final String value);

    /**
     * This method will return all the options on the select object
     */
    List<WebElement> getOptions();

    /**
     * This method will return All selected options belonging on the select
     * object
     * 
     * @return
     */
    List<WebElement> getAllSelectedOptions();

    /**
     * @return The first selected option in this select tag (or the currently
     *         selected option in a normal select)
     */
    public WebElement getFirstSelectedOption();

    /**
     * This will search the list Options by value using value passed in
     * 
     * @param value
     * @return
     */
    public boolean searchByValue(final String value);

    /**
     * This will search the list Options by text using value passed in
     * 
     * @param value
     * @return
     */
    public boolean searchByText(final String text);

    /**
     * This will select an option based on partial text
     * 
     * @param text
     * @return
     */
    public void selectByPartialText(final String text);

    /**
     * This method will un-select a radio button (should also work for
     * checkboxes)
     */
    public void setUnselected();

    /**
     * This method will set or un-set a radio button based on the value passed
     * in (should also work for checkboxes
     * 
     * @param setSelected
     * @return
     */
    public void setToggleElement(final boolean setSelected);

    /**
     * This method finds if this element is surrounded with <a>
     * 
     * @return boolean
     */
    public boolean isLink();

    /**
     * get the description of the locator
     * 
     * @return
     */
    public String getByLocatorDesc();
    
    /**
     * Do a mouse over
     * @param we
     */
    public void mouseOver(WebDriver driver);

}
