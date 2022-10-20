package herokuapp.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicElementHandling extends TestBase{

    @Test
    public void verifyDynamicallyLoadedText(){
        app.dynamicLoadingPage().visit();
        app.dynamicLoadingPage().navigateToExampleOne();
        String pageContent = app.dynamicLoadingPage().getPageContent();
        Assert.assertEquals(pageContent,"Hello World!");
    }
}
