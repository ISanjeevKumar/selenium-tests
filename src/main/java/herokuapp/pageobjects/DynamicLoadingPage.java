package herokuapp.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium.helpers.WebElementFinder;

public class DynamicLoadingPage extends BasePage{

    public DynamicLoadingPage(WebDriver driver) {
        super(driver);
    }

    public void visit(){
        driver.get("https://the-internet.herokuapp.com/dynamic_loading");
    }

    public void navigateToExampleOne(){
        try {
            WebElement exampleOneElement = WebElementFinder.getElement(driver, By.cssSelector("#content > div > a:nth-child(5)"),30);
            exampleOneElement.click();
            WebElement startElement = WebElementFinder.getElement(driver, By.cssSelector("#start > button"),30);
            startElement.click();
            System.out.println("navigate To Example One");
        } catch (Exception ex){
            System.err.println("Failed  to navigate To Example One due to:"+ex.getMessage());
            throw ex;
        }
    }


    public String getPageContent(){
        try {
            WebElement pageContent = WebElementFinder.getElement(driver, By.cssSelector("div#finish"),30);
            return pageContent.getText().trim();
        } catch (Exception ex){
            System.err.println("Failed  to navigate To Example One due to:"+ex.getMessage());
            throw ex;
        }
    }
}
