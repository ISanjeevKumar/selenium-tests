package extentreport.config;

import com.aventstack.extentreports.ExtentTest;

public class ExtentLogger {
    private ExtentTest _test;

    public ExtentLogger(ExtentTest test) {
        this._test = test;
    }

    public void pass(String message) {
        _test.pass(message);
    }

    public void info(String message) {
        _test.info(message);
    }

    public void fail(String message) {
        _test.fail(message);
    }

    public void skip(String message) {
        _test.skip(message);
    }
}
