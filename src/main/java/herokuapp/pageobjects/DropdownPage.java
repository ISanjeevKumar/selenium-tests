package herokuapp.pageobjects;

import extentreport.config.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium.helpers.WebDropdownHelper;
import selenium.helpers.WebElementFinder;


public class DropdownPage extends BasePage {

    public DropdownPage(WebDriver driver, String baseUrl, ExtentLogger logger) {
        super(driver, baseUrl, logger);
    }

    public void visit() {
        driver.get(baseUrl + "/dropdown");
    }

    public void selectOption(String option) {
        WebElement element = WebElementFinder.getElement(driver, By.id("dropdown"), 10);
        WebDropdownHelper.selectByValue(element, option);
    }
}
