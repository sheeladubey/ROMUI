package com.gsicommerce.romui.selenium.ROMUI.Utilities;

import static org.testng.Assert.fail;

import java.text.Normalizer;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.gsicommerce.romui.selenium.ROMUI.Utilities.AssertingWebElement;
import com.gsicommerce.romui.selenium.ROMUI.Utilities.Common;


public class AssertingWebElement implements GsiWebElement{
	private final WebElement wrapped;
    private final String byLocatorDesc;
    private By locator;
    /**
     * This constructor will convert selenium webelement to Webelement object
     *
     * @param we
     */
    public AssertingWebElement(final WebElement we) {
        this(we, "unspecified");
    }

    public AssertingWebElement(final WebElement we, final By locator) {
    	
        this(we, locator == null ? "unspecified" : locator.toString());
        this.locator = locator;
    }

    public AssertingWebElement(final WebElement we, final String locatorDesc) {
        this.wrapped = we;
        this.byLocatorDesc = locatorDesc;
    }

    public By getLocator() {
        return locator;
    }
    /**
     * clicks on the webelement.
     */
    public void click() {
        assertNotNull();
        wrapped.click();

    }
    public void clickWithBrowserType(final String browserType) {
        assertNotNull();
        if (browserType.equalsIgnoreCase("ie"))
          sendKeys(Keys.ENTER);
        else
            wrapped.click();
    }


    public boolean exists() {
        if (wrapped instanceof WebElement) {
            return ((AssertingWebElement) wrapped).exists();
        }

        return wrapped != null;
    }

    /**
     * @see WebElement#enter(String)
     */
    public void enter(final String value) {

        if (null == value || "".equals(value)) {
            return;
        }
        click();
        clear();
        sendKeys(Keys.HOME, value);
    }

    private void assertNotNull() {
        if (null == wrapped) {
            failNotFound();
        }
    }

    private void failNotFound() {
        fail(byLocatorDesc + " ELEMENT NOT FOUND. TEST FAILED.");
    }

    
    public String getByLocatorDesc() {
        return byLocatorDesc;
    }

    /**
     * Un-selects the webelement. This method should be used only for radio
     * buttons.
     */
    public void setUnselected() {
        try {
            if (wrapped.isSelected()) {
                wrapped.click();
            }
        } catch (final NoSuchElementException e) {
            failNotFound();
        } catch (final NullPointerException e) {
            failNotFound();
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.gsicommerce.webstore.utilities.WebElement#select(java.lang.String)
     */
    
    public void select(final String value) {
        assertNotNull();
        new Select(wrapped).selectByVisibleText(value);
    }

    
    public void submit() {
        assertNotNull();
        wrapped.submit();
    }

    
    public void sendKeys(final CharSequence... keysToSend) {
        assertNotNull();
        wrapped.sendKeys(keysToSend);
    }

    
    public void clear() {
        assertNotNull();
        wrapped.clear();
    }

    
    public String getTagName() {
        assertNotNull();
        return wrapped.getTagName();

    }

    public String getAttribute(final String name) {
        assertNotNull();
        return wrapped.getAttribute(name);
    }

    
    public boolean isSelected() {
        assertNotNull();
        return wrapped.isSelected();
    }

    
    public boolean isEnabled() {
        assertNotNull();
        return wrapped.isEnabled();
    }

    public String getText() {
        assertNotNull();
        return wrapped.getText();
    }

    
    public List<WebElement> findElements(final By by) {
        assertNotNull();
        return wrapped.findElements(by);
    }

    
    public GsiWebElement findElement(final By by) {
        assertNotNull();
        int maxTime = 10;
        int i = 0;
        do {
            try {
                return new AssertingWebElement(wrapped.findElement(by));
            } catch (final NoSuchElementException e) {
                return new AssertingWebElement(null, by);
            } catch (final StaleElementReferenceException s) {
              //  Common.sleepFor(1000);
                i++;
            }
        } while (i <= maxTime);
        return new AssertingWebElement(null, by);
    }

    
    public boolean verifyTextPresentIn(final String expectedText) {
        assertNotNull();
        final String actualText = Normalizer.normalize(wrapped.getText(),
                Normalizer.Form.NFKC);
       // Common.sleepFor(1000);
        if (actualText.contains(expectedText)) {
            return true;
        } else if (actualText.equalsIgnoreCase(expectedText)) {
            return true;
        } else if (actualText.replace("\n", "").replace("\r", "")
                .contains(expectedText.replace("\r", "").replace("\n", ""))) {
            return true;
        }
        return false;
    }

    
    public boolean isTextPresentIn(final String expectedText) {
        final String actualText = wrapped.getText();
     //   Common.sleepFor(1000);
        if (actualText.contains(expectedText)) {
            return true;
        } else if (actualText.equalsIgnoreCase(expectedText)) {
            return true;
        } else if (actualText.replace("\n", "").replace("\r", "")
                .contains(expectedText.replace("\r", "").replace("\n", ""))) {
            return true;
        }

        return false;
    }

    /**
     * for list boxes, select an option by its index in the list.
     */
    
    public void selectByIndex(final int i) {
        assertNotNull();
        try {
            new Select(wrapped).selectByIndex(i);
        } catch (final NullPointerException e) {
            failNotFound();
        }
    }

    
    public void selectByValue(final String value) {
        assertNotNull();
        try {
            new Select(wrapped).selectByValue(value);
        } catch (final NullPointerException e) {
            failNotFound();
        }
    }

    /**
     * @return The first selected option in this select tag (or the currently
     *         selected option in a normal select)
     */
    
    public WebElement getFirstSelectedOption() {
        assertNotNull();
        try {
            return new Select(wrapped).getFirstSelectedOption();
        } catch (final NoSuchElementException e) {
            failNotFound();
            return null;
        }
    }

    /**
     * @return All selected options belonging to this select tag
     */
    
    public List<WebElement> getAllSelectedOptions() {
        assertNotNull();
        try {
            return new Select(wrapped).getAllSelectedOptions();
        } catch (final NoSuchElementException e) {
            failNotFound();
            return null;
        }
    }

    /**
     * @return All options belonging to this select tag
     */
    
    public List<WebElement> getOptions() {
        assertNotNull();
        try {
            return new Select(wrapped).getOptions();
        } catch (final NoSuchElementException e) {
            failNotFound();
            return null;
        } catch (final NullPointerException e) {
            failNotFound();
            return null;
        }
    }

    
    public boolean searchByValue(final String value) {
        assertNotNull();
        final List<WebElement> options = wrapped.findElements(By
                .xpath(".//option[@value = '" + value + "']"));
        for (final WebElement option : options) {
            if (option.getText().compareToIgnoreCase(value) == 0) {
                return true;
            }
        }

        return false;
    }

    
    public boolean searchByText(final String text) {
        assertNotNull();
        final List<WebElement> options = new Select(wrapped).getOptions();
        for (final WebElement option : options) {
            if (option.getText().compareToIgnoreCase(text) == 0) {
                return true;
            }
        }

        return false;
    }

    
    public void selectByPartialText(final String text) {
        assertNotNull();
        boolean blnFound = false;
        final List<WebElement> options = getOptions();
        for (int i = 0; i < options.size(); i++) {
            if (Common.convertUniCodeToASCII(options.get(i).getText())
                    .toLowerCase().contains(text.toLowerCase())) {
                new Select(wrapped).selectByIndex(i);
                blnFound = true;
                break;
            }
        }
        if (!blnFound) {
            failNotFound();
        }
    }

    
    public boolean isLink() {
        assertNotNull();
        if ("body".equals(this.getTagName())) {
            return false;
        }
        if (("a").equals(this.getTagName())) {
            return true;
        }
        return ((AssertingWebElement) this.findElement(By.xpath(".."))).isLink();
    }

    
    public String getCssValue(final String propertyName) {
        assertNotNull();
        return wrapped.getCssValue(propertyName);
    }

    
    public Point getLocation() {
        assertNotNull();
        return wrapped.getLocation();
    }

    
    public Dimension getSize() {
        assertNotNull();
        return wrapped.getSize();
    }

    public Rectangle getRect() {
        return null;
    }


    public boolean isDisplayed() {
        assertNotNull();
        return wrapped.isDisplayed();
    }

    
    public void setToggleElement(final boolean setSelected) {
        assertNotNull();
        if (setSelected == wrapped.isSelected()) {
            return;
        }

        wrapped.click();
    }

    /**
     * mouse over
     *
     * @param driver
     */
    
    public void mouseOver(final WebDriver driver) {
        assertNotNull();
//        String code = "var fireOnThis = arguments[0];"
//                    + "var evObj = document.createEvent('MouseEvents');"
//                    + "evObj.initEvent( 'mouseover', true, true );"
//                    + "fireOnThis.dispatchEvent(evObj);";
//        ((JavascriptExecutor) driver).executeScript(code, wrapped);
        final Actions builder = new Actions(
                driver); // Or maybe seleniumDriver? Not sure which one to use
        builder.moveToElement(wrapped).build().perform();

    }

    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return null;
    }

}
