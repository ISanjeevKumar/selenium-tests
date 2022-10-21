package herokuapp.tests;


import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class DynamicElementHandling extends TestBase{

    @Test
    public void verifyDynamicallyLoadedText(){
        app.dynamicLoadingPage().visit();
        app.dynamicLoadingPage().navigateToExampleOne();
        String pageContent = app.dynamicLoadingPage().getPageContent();
        assertThat(pageContent).isEqualTo("Hello World!");
    }
}
