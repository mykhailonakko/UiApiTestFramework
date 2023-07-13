package org.rptest.uitests.testng;

import org.rptest.core.browser.actions.IBrowser;
import org.rptest.core.browser.driver.Driver;
import org.rptest.core.browser.driver.DriverFactory;
import org.rptest.core.config.Property;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTestNG {

    @BeforeMethod
    public void setup(ITestContext testContext) {
        Driver driver = new DriverFactory().getDriver();
        driver.initiateDriver();
        testContext.setAttribute("driver", driver);
        IBrowser browser = driver.getBrowser();
        browser.open(Property.COMMON_PROPERTY.baseUrl());
        testContext.setAttribute("browser", browser);
    }

    @AfterMethod
    public void tearDown(ITestContext testContext) {
        ((Driver) testContext.getAttribute("driver")).quitDriver();
    }
}
