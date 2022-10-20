package selenium.helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebElementFinder {

    public static WebElement getElement(WebDriver driver, final By elementLocator, int timeOutInSecs) {
        try {
            WebDriverWait wait = new WebDriverWait(driver,
                    Duration.ofSeconds(timeOutInSecs));
            wait.ignoring(NoSuchElementException.class);
            wait.ignoring(ElementNotInteractableException.class);
            return wait.until(d -> getElement(d, elementLocator));
        } catch (Exception ex) {
            System.err.println("Error:" + ex);
            throw ex;
        }

    }

    private static WebElement getElement(final SearchContext searchContext, final By elementLocator) {
        WebElement element = searchContext.findElement(elementLocator);
        if (element.isDisplayed() && element.isEnabled()) {
            return element;
        }
        throw new NoSuchElementException("WebElement with locator " + elementLocator + " is not Found.");
    }
}
