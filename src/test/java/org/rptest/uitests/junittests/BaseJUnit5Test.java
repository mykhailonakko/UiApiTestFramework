package org.rptest.uitests.junittests;

import com.epam.reportportal.junit5.ReportPortalExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.rptest.core.browser.actions.IBrowser;
import org.rptest.core.browser.driver.Driver;
import org.rptest.core.browser.driver.DriverFactory;
import org.rptest.core.config.Property;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(ReportPortalExtension.class)
public class BaseJUnit5Test {
    private final Driver driver = new DriverFactory().getDriver();
    IBrowser browser;
    @BeforeAll
    void launchBrowser() {
        driver.initiateDriver();
    }

    @BeforeEach
    void createPageContextAndBrowserActions() {
        browser = driver.getBrowser();
        browser.open(Property.COMMON_PROPERTY.baseUrl());
    }

    @AfterEach
    void closeContext() {
        browser.close();
        driver.closeBrowser();
    }

    @AfterAll
    public void tearDown() {
        driver.quitDriver();
    }
}
