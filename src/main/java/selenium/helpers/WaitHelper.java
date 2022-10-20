package selenium.helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitHelper {

    public static void waitForPageLoad(WebDriver driver){
        try {
            (new WebDriverWait(driver, Duration.ofSeconds(30)))
                    .until((ExpectedCondition<Boolean>) d -> {
                        boolean isJavascriptExecuted = ((JavascriptExecutor)d).executeScript("return document.readyState").equals("complete");
                        boolean isAppInteractive =((JavascriptExecutor) d).executeScript("return document.readyState").toString().matches("interactive|complete");
                        return isJavascriptExecuted&&isAppInteractive;
                    });
        } catch (TimeoutException ex) {
            ((JavascriptExecutor)driver).executeScript("window.stop();");
        }
    }
}
