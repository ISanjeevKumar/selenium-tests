package herokuapp.pageobjects;

import org.openqa.selenium.WebDriver;

public class BasePage {

    protected  WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    protected void logSteps(String message){
        System.out.println(message);
    }
    protected void logError(String message){
        System.err.println(message);
    }
}
