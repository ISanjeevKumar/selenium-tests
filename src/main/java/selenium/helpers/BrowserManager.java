package selenium.helpers;

import common.enums.BrowserType;
import common.enums.ExecutionType;
import common.modelObjects.RunSettings;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Locale;

public class BrowserManager {

    private RunSettings _runSettings;

    public BrowserManager(RunSettings runSettings) {
        this._runSettings = runSettings;
    }

    public WebDriver getWebDriver() throws Exception {
        BrowserType browserType = BrowserType.valueOf(_runSettings.browser.toUpperCase());
        ExecutionType executionType = ExecutionType.valueOf(_runSettings.executionType.toUpperCase());
        System.out.println("Browser is:" + browserType);
        switch (executionType) {
            case LOCAL:
                return createLocalWebDriverDriver(browserType);
            case REMOTE_WEBDRIVER:
                return createRemoteWebDriver();
            default:
                throw new Exception("Invalid Execution Type");
        }
    }


    private WebDriver createLocalWebDriverDriver(BrowserType browserType) throws Exception {
        try {
            switch (browserType) {
                case CHROME:
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    if (_runSettings.headless) options.addArguments("headless");
                    options.addArguments("window-size=1200x600");
                    return new ChromeDriver(options);
                case EDGE:
                    return null;
                case FIREFOX:
                    return null;
                default:
                    throw new Exception("Invalid Browser Type");

            }

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            throw ex;
        }
    }

    private WebDriver createRemoteWebDriver() {
        try {
            return null;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            throw ex;
        }
    }
}
