package herokuapp.pageobjects;

import extentreport.config.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium.helpers.WebElementFinder;

public class SecureAreaPage extends BasePage {

    protected WebElement flashMessage() {
        return WebElementFinder.getElement(driver, By.id("flash-messages"), 30);
    }

    public SecureAreaPage(WebDriver driver, String baseUrl, ExtentLogger logger) {
        super(driver, baseUrl, logger);
    }

    public String getFlashMessage() {
        return flashMessage().getText().trim();
    }
}
