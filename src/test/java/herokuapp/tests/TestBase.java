package herokuapp.tests;

import common.components.JsonHelper;
import common.modelObjects.RunSettings;
import extentreport.config.ExtentLogger;
import extentreport.config.ExtentReportManager;
import herokuapp.pageobjects.HerokuApp;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


import static org.assertj.core.api.Assertions.assertThat;

public class TestBase {
    private ExtentReportManager _extentReportManager;
    private ExtentLogger _extentLogger;
    protected HerokuApp app;
    protected RunSettings runSettings;

    @BeforeTest(alwaysRun = true)
    public void testInitialization(ITestContext context) throws Exception {
        runSettings = JsonHelper.getRunSettings();
        _extentReportManager = new ExtentReportManager(runSettings.extentReportSettings);
        _extentReportManager.createTest(context.getName());
        _extentLogger = new ExtentLogger(_extentReportManager.getTest());
        app = new HerokuApp(runSettings, _extentLogger);
    }

    @AfterTest(alwaysRun = true)
    public void testCleanUp() {
        app.dispose();
        _extentReportManager.flushReports();
    }

    public void assertEqual(String expected, String actual) {
        _extentLogger.info(String.format("assertEqual: expected '%s' against actual '%s'", expected, actual));
        assertThat(expected).isEqualTo(actual);
    }

    public void assertContains(String expected, String actual) {
        _extentLogger.info(String.format("assertContains: expected '%s' against actual '%s'", expected, actual));
        assertThat(actual).contains(expected);
    }
}
