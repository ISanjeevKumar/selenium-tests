package selenium.helpers;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;

public class WebTextHelper {

    public static void setText(WebElement element, String text) {
        try {
            if (element.getTagName().toLowerCase() == "textarea") {
                element.sendKeys(Keys.CONTROL, Keys.HOME);
                element.sendKeys(text);
            } else {
                element.sendKeys(Keys.HOME + text);
            }
            System.out.println("Executed setText for value '" + text + "' at locator " + element.toString());
        } catch (Exception ex) {
            throw ex;
        }
    }

    public static void sendKeys(WebElement element, String keysToSend) {

        try {
            Actions action = new Actions(((RemoteWebElement) element).getWrappedDriver());
            action.sendKeys(element, keysToSend);
            action.perform();
            System.out.println("Executed sendKeys for key '" + keysToSend + "' at locator " + element.toString());
        } catch (Exception ex) {
            throw ex;
        }
    }

}
