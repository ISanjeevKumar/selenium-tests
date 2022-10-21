package herokuapp.pageobjects;

import common.enums.BrowserType;
import common.enums.ExecutionType;
import common.modelObjects.RunSettings;
import extentreport.config.ExtentLogger;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import selenium.helpers.BrowserManager;

public class HerokuApp {

    private WebDriver _driver;
    private String _baseUrl;
    private ExtentLogger _logger;

    private DropdownPage _dropdownPage;
    private DynamicLoadingPage _dynamicLoadingPage;
    private LoginPage _loginPage;
    private SecureAreaPage _secureAreaPage;

    @SneakyThrows
    public HerokuApp(RunSettings runSettings, ExtentLogger logger) {
        _baseUrl = runSettings.baseUrl;
        _logger = logger;
        _driver = new BrowserManager(runSettings).getWebDriver();
    }

    public DropdownPage dropdownPage() {
        return _dropdownPage == null ? _dropdownPage = new DropdownPage(_driver, _baseUrl, _logger) : _dropdownPage;
    }

    public DynamicLoadingPage dynamicLoadingPage() {
        return _dynamicLoadingPage == null ? _dynamicLoadingPage = new DynamicLoadingPage(_driver, _baseUrl, _logger) : _dynamicLoadingPage;
    }

    public LoginPage loginPage() {
        return _loginPage == null ? _loginPage = new LoginPage(_driver, _baseUrl, _logger) : _loginPage;
    }

    public SecureAreaPage secureAreaPage() {
        return _secureAreaPage == null ? _secureAreaPage = new SecureAreaPage(_driver, _baseUrl, _logger) : _secureAreaPage;
    }


    public void dispose() {
        if (_driver != null) {
            _driver.close();
            _driver.quit();
        }
        _driver = null;
    }
}
