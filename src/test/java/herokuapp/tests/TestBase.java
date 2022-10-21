package herokuapp.tests;

import common.enums.BrowserType;
import herokuapp.pageobjects.HerokuApp;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static org.assertj.core.api.Assertions.assertThat;

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

    public void assertEqual (String expected, String actual){
        assertThat(expected).isEqualTo(actual);
    }

    public void assertContains (String expected, String actual){
        assertThat(actual).contains(expected);
    }
}
