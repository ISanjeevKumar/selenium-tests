package herokuapp.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium.helpers.WebElementFinder;

public class SecureAreaPage extends  BasePage{

    protected WebElement flashMessage(){
        return WebElementFinder.getElement(driver, By.id("flash-messages"), 30 );
    }
    public SecureAreaPage(WebDriver driver) {
        super(driver);
    }

    public String getFlashMessage(){
        return flashMessage().getText().trim();
    }
}
