package herokuapp.tests;

import common.enums.BrowserType;
import herokuapp.pageobjects.HerokuApp;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {
    protected HerokuApp app;

    @BeforeTest
    public void testInitialization() throws Exception {
        app = new HerokuApp(BrowserType.CHROME);
    }

    @AfterTest
    public void testCleanUp() {
        app.dispose();
    }
}
