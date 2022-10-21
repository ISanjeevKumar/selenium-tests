package herokuapp.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium.helpers.WebButtonHelper;
import selenium.helpers.WebElementFinder;
import selenium.helpers.WebTextHelper;

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

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void navigateTo(){
        try {
            driver.get("https://the-internet.herokuapp.com/login");
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

    public void enterPassword(String password) {
        try {
            WebTextHelper.sendKeys(password(), password);
            logSteps("Successfully entered password:" + password);
        } catch (Exception ex) {
            logError("Failed to execute enterPassword due :" + ex.getMessage());
        }
    }

    public void clickOnLoginButton() {
        try {
            WebButtonHelper.click(loginBtn());
            logSteps("Successfully clicked login");
        } catch (Exception ex) {
            logError("Failed to execute click on login due :" + ex.getMessage());
            throw ex;
        }
    }

}
