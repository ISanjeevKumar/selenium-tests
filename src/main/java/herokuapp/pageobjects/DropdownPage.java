package herokuapp.pageobjects;

import org.openqa.selenium.WebDriver;

public class DropdownPage extends BasePage{
    public DropdownPage(WebDriver driver) {
        super(driver);
    }
    public void visit(){
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }
    public void selectOption(String Option){

    }
}
