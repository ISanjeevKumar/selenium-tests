package herokuapp.pageobjects;

import common.modelObjects.RunSettings;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;
    protected String baseUrl;

    public BasePage(WebDriver driver, String baseUrl) {
        this.driver = driver;
        this.baseUrl = baseUrl;
    }

    protected void logSteps(String message) {
        System.out.println(message);
    }

    protected void logError(String message) {
        System.err.println(message);
    }
}
