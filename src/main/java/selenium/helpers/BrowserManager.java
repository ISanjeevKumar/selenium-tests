package selenium.helpers;

import common.enums.BrowserType;
import common.enums.ExecutionType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserManager {

    public static WebDriver getWebDriver(ExecutionType executionType, BrowserType browserType) throws Exception {
        switch (executionType) {
            case Local:
                return createLocalWebDriverDriver(browserType);
            case REMOTE_WEBDRIVER:
                return createRemoteWebDriver();
            default:
                throw new Exception("Invalid Execution Type");
        }
    }


    private static WebDriver createLocalWebDriverDriver(BrowserType browserType) throws Exception {
        try {
            switch (browserType) {
                case CHROME:
                    System.out.println("Starting Chrome Browser");
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    //options.addArguments("headless");
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

    private static WebDriver createRemoteWebDriver() {
        try {
            return null;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            throw ex;
        }
    }
}
