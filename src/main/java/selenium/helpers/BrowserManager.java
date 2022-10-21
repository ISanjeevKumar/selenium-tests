package selenium.helpers;

import common.enums.BrowserType;
import common.enums.ExecutionType;
import common.modelObjects.RunSettings;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


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
                throw new NotFoundException("ExecutionType NOT FOUND.");
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
                    options.addArguments("--disable-gpu");
                    return new ChromeDriver(options);
                case EDGE:
                    WebDriverManager.edgedriver().setup();
                    EdgeOptions edgeOptions = new EdgeOptions();
                    if (_runSettings.headless) edgeOptions.addArguments("--headless");
                    return new EdgeDriver(edgeOptions);
                case FIREFOX:
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    if (_runSettings.headless) firefoxOptions.addArguments("--headless");
                    return new FirefoxDriver(firefoxOptions);
                default:
                    throw new NotFoundException("Browser Not Found. Please check Browser name.");

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
