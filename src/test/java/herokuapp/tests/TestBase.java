package herokuapp.tests;

import common.components.JsonHelper;
import common.modelObjects.RunSettings;
import herokuapp.pageobjects.HerokuApp;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static org.assertj.core.api.Assertions.assertThat;

public class TestBase {
    protected HerokuApp app;
    protected RunSettings runSettings;

    @BeforeTest
    public void testInitialization() throws Exception {
        runSettings = JsonHelper.getRunSettings();
        app = new HerokuApp(runSettings);
    }

    @AfterTest
    public void testCleanUp() {
        app.dispose();
    }

    public void assertEqual(String expected, String actual) {
        assertThat(expected).isEqualTo(actual);
    }

    public void assertContains(String expected, String actual) {
        assertThat(actual).contains(expected);
    }
}
