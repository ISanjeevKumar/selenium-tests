package herokuapp.pageobjects;

import extentreport.config.ExtentLogger;
import org.openqa.selenium.WebDriver;

public class BasePage {
    private ExtentLogger _logger;

    protected WebDriver driver;
    protected String baseUrl;


    public BasePage(WebDriver driver, String baseUrl, ExtentLogger logger) {
        this.driver = driver;
        this.baseUrl = baseUrl;
        this._logger = logger;
    }

    protected void logSteps(String message) {
        _logger.pass(message);
    }

    protected void logError(String message) {
        _logger.fail(message);
    }
}
