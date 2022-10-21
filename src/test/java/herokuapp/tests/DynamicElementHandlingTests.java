package herokuapp.tests;


import org.testng.annotations.Test;

public class DynamicElementHandlingTests extends TestBase {

    @Test
    public void verifyDynamicallyLoadedText() {
        app.dynamicLoadingPage().visit();
        app.dynamicLoadingPage().navigateToExampleOne();
        assertEqual("Hello World!", app.dynamicLoadingPage().getPageContent());
    }
}
