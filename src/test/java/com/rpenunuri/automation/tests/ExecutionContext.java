package com.rpenunuri.automation.tests;

import com.rpenunuri.automation.util.DriverType;
import org.openqa.selenium.WebDriver;
import static java.util.concurrent.TimeUnit.SECONDS;

public class ExecutionContext {

    private WebDriver _webDriver;
    private final int _contextIndex;

    public ExecutionContext(int contextIndex) {
        _contextIndex = contextIndex;
    }

    public WebDriver getWebDriver() {
        return _webDriver;
    }

    public void initializeWebDriver() {
        _webDriver = createDriver();
        _webDriver.manage().timeouts().implicitlyWait(10, SECONDS);
        _webDriver.manage().window().maximize();
    }

    private WebDriver createDriver() {
        WebDriver webDriver = DriverType.valueOf("chrome").createWebDriver();
        return webDriver;
    }

    public void shutDown() {
        if (getWebDriver() != null) {
            _webDriver.quit();
        }
    }
}
