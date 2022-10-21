## Selenium 4.0 Sample Tests

The automation framework has sample tests that use Selenium 4.0 and Page object model design pattern.

### Websites used for testing:
- https://the-internet.herokuapp.com
### Project Dependencies
- org.assertj 
- webdrivermanager
- org.testng 
- org.seleniumhq.selenium 

## Design Pattern
In this automation framework , I have used layered Architecture and this framework has following layer:
- Test Layer - Where I will write tests
- Page Layer - Page Class Implementation 
- Component Layer - Common library 
- Data Layer - Test data 
### Page object model for Internet-herokuapp

Test Layer 

```java

public class LoginTests extends TestBase {

    @Test
    public void shouldBeAbleToLogin() {
        app.loginPage().navigateTo();
        app.loginPage().enterUsername("tomsmith");
        app.loginPage().enterPassword("SuperSecretPassword!");
        app.loginPage().clickOnLoginButton();
        assertContains("You logged into a secure area!", app.secureAreaPage().getFlashMessage());
    }
}
```

Page Class
```java
public class LoginPage extends BasePage {

    protected WebElement username() {
        return WebElementFinder.getElementByIdOrName(driver, "username", 30);
    }

    protected WebElement password() {
        return WebElementFinder.getElementByIdOrName(driver, "password", 30);
    }

    protected WebElement loginBtn() {
        return WebElementFinder.getElement(driver, By.cssSelector("#login > button"), 30);
    }

    public LoginPage(WebDriver driver, String baseUrl) {
        super(driver, baseUrl);
    }

    public void navigateTo() {
        try {
            driver.get(baseUrl + "/login");
            logSteps("Successfully navigateTo Login");
        } catch (Exception ex) {
            logError("Failed to navigateTo due to:" + ex.getMessage());
            throw ex;
        }
    }

    public void enterUsername(String username) {
        try {
            WebTextHelper.setText(username(), username);
            logSteps("Successfully entered username:" + username);
        } catch (Exception ex) {
            logError("Failed to execute enterUsername due :" + ex.getMessage());
            throw ex;
        }
    }
}
```

App Class - Which have all the page objects reference

```java
public class HerokuApp {

    private WebDriver _driver;
    private String _baseUrl;

    private DropdownPage _dropdownPage;
    private DynamicLoadingPage _dynamicLoadingPage;
    private LoginPage _loginPage;
    private SecureAreaPage _secureAreaPage;

    public HerokuApp(RunSettings runSettings) throws Exception {
        _baseUrl = runSettings.baseUrl;
        _driver = new BrowserManager(runSettings).getWebDriver();
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
```


