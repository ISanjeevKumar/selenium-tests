package selenium.helpers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;

public class WebButtonHelper {

    public static void click(WebElement element) {
        try {
            Actions action = new Actions(((RemoteWebElement) element).getWrappedDriver());
            try {
                element.click();
            } catch (Exception ex) {
                action.click(element);
            }
            action.perform();
        } catch (Exception ex) {
            throw ex;
        }
    }
}
