package org.rptest.uitests.bddtests.stepsdef;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import org.rptest.core.browser.actions.IBrowser;
import org.rptest.core.browser.driver.Driver;
import org.rptest.core.browser.driver.DriverFactory;
import org.rptest.core.config.Property;
import org.rptest.uitests.bddtests.BrowserHolder;

public class Hooks {
    Driver driver;
    IBrowser browser;

    private final BrowserHolder browserHolder;

    public Hooks(BrowserHolder browserHolder) {
        this.browserHolder = browserHolder;
    }

    @BeforeAll
    void setupDriver() {
        System.out.println("DSJJDSFFJKD");
        driver = new DriverFactory().getDriver();
        driver.initiateDriver();
    }

    @Before
    void setupBrowser() {
        browser = driver.getBrowser();
        browser.open(Property.COMMON_PROPERTY.baseUrl());
        browserHolder.setBrowser(browser);
    }

    @After
    void quitBrowser() {
        IBrowser browser = browserHolder.getBrowser();
        if (browser != null) {
            browser.close();
        }
    }

    @AfterAll
    void tearDown() {
        driver.quitDriver();
    }
}
