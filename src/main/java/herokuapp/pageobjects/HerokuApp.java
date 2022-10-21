package herokuapp.pageobjects;

import common.enums.BrowserType;
import common.enums.ExecutionType;
import org.openqa.selenium.WebDriver;
import selenium.helpers.BrowserManager;

public class HerokuApp {

    private WebDriver driver;
    private DropdownPage _dropdownPage;
    private DynamicLoadingPage _dynamicLoadingPage;
    private LoginPage _loginPage;
    private SecureAreaPage _secureAreaPage;

    public HerokuApp(BrowserType browserType) throws Exception {
        driver = new BrowserManager().getWebDriver(ExecutionType.Local, browserType);
    }

    public HerokuApp(ExecutionType executionType, BrowserType browserType) throws Exception {
        driver = new BrowserManager().getWebDriver(executionType, browserType);
    }

    public DropdownPage dropdownPage() {
        return _dropdownPage == null ? _dropdownPage = new DropdownPage(driver) : _dropdownPage;
    }

    public DynamicLoadingPage dynamicLoadingPage() {
        return _dynamicLoadingPage == null ? _dynamicLoadingPage = new DynamicLoadingPage(driver) : _dynamicLoadingPage;
    }

    public LoginPage loginPage() {
        return _loginPage == null ? _loginPage = new LoginPage(driver) : _loginPage;
    }

    public SecureAreaPage secureAreaPage() {
        return _secureAreaPage == null ? _secureAreaPage = new SecureAreaPage(driver) : _secureAreaPage;
    }


    public void dispose() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
        driver = null;
    }
}
