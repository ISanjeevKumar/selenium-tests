package extentreport.config;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import common.modelObjects.ExtentReportSettings;

import java.util.Objects;


public class ExtentReportManager {
    private ExtentReports _extent;
    private ExtentTest _test;

    public ExtentReportManager(ExtentReportSettings extentReportSettings) {
        System.out.println("Path" + extentReportSettings.reportPath);
        _extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter(extentReportSettings.reportPath);
        _extent.attachReporter(spark);
        spark.config().setTheme(Theme.STANDARD);
        System.out.println("Title:" + extentReportSettings.reportTitle);
        spark.config().setDocumentTitle(extentReportSettings.reportTitle);
        spark.config().setReportName(extentReportSettings.reportTitle);
    }

    public void createTest(String testcaseName) {
        _test = _extent.createTest(testcaseName);
    }

    public void flushReports() {
        if (Objects.nonNull(_extent))
            _extent.flush();
    }

    public ExtentTest getTest() {
        return _test;
    }

}
