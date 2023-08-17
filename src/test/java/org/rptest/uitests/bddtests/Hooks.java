package org.rptest.uitests.bddtests;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.rptest.core.browser.actions.IBrowser;
import org.rptest.core.browser.driver.Driver;
import org.rptest.core.browser.driver.DriverFactory;
import org.rptest.core.utilities.FileUtils;

import java.io.IOException;

public class Hooks {
    Driver driver;
    IBrowser browser;

    private final BrowserHolder browserHolder;

    public Hooks(BrowserHolder browserHolder) {
        this.browserHolder = browserHolder;
    }

    @Before()
    public void setupBrowser() {
        driver = new DriverFactory().getDriver();
        driver.initiateDriver();
        browser = driver.getBrowser();
        browserHolder.setBrowser(browser);
    }

    @After(order = 1)
    public void takeScreenshotOnFail(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            browserHolder.getBrowser().takeScreenshot(FileUtils.getScreenshotFolderPath()
                    .resolve(getScenarioNameIncludingExample(scenario) + ".png"));
        }
    }

    @After(order = 0)
    public void quitBrowser() {
        IBrowser browser = browserHolder.getBrowser();
        if (browser != null) {
            browser.close();
        }
        driver.quitDriver();
    }

    private String getScenarioNameIncludingExample(Scenario scenario) {
        return String.format("%s (Line %s)",scenario.getName(), scenario.getLine());
    }
}
