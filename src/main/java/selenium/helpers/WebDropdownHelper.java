package selenium.helpers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebDropdownHelper {

    public static void selectByValue(WebElement element, String value) {
        try {
            Select select = new Select(element);
            select.selectByValue(value);
            System.out.println("Successfully Selected value " + value);
        } catch (Exception ex) {
            System.err.println("Failed to selected value '" + value + "' due to an error:" + ex.getMessage());
            throw ex;
        }
    }
}
