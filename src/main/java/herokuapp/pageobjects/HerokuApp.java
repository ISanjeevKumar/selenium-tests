package herokuapp.pageobjects;

import common.enums.BrowserType;
import common.enums.ExecutionType;
import common.modelObjects.RunSettings;
import org.openqa.selenium.WebDriver;
import selenium.helpers.BrowserManager;

public class HerokuApp {

    private WebDriver _driver;
    private String _baseUrl;

    private DropdownPage _dropdownPage;
    private DynamicLoadingPage _dynamicLoadingPage;
    private LoginPage _loginPage;
    private SecureAreaPage _secureAreaPage;

    public HerokuApp(RunSettings runSettings) throws Exception {
        _baseUrl = runSettings.baseUrl;
        _driver = new BrowserManager().getWebDriver(ExecutionType.Local, BrowserType.CHROME);
    }

    public HerokuApp(ExecutionType executionType, BrowserType browserType) throws Exception {
        _driver = new BrowserManager().getWebDriver(executionType, browserType);
    }

    public DropdownPage dropdownPage() {
        return _dropdownPage == null ? _dropdownPage = new DropdownPage(_driver, _baseUrl) : _dropdownPage;
    }

    public DynamicLoadingPage dynamicLoadingPage() {
        return _dynamicLoadingPage == null ? _dynamicLoadingPage = new DynamicLoadingPage(_driver, _baseUrl) : _dynamicLoadingPage;
    }

    public LoginPage loginPage() {
        return _loginPage == null ? _loginPage = new LoginPage(_driver, _baseUrl) : _loginPage;
    }

    public SecureAreaPage secureAreaPage() {
        return _secureAreaPage == null ? _secureAreaPage = new SecureAreaPage(_driver, _baseUrl) : _secureAreaPage;
    }


    public void dispose() {
        if (_driver != null) {
            _driver.close();
            _driver.quit();
        }
        _driver = null;
    }
}
