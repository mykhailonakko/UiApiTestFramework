package org.rptest.uitests.testng;

import org.rptest.core.browser.BrowserActionsFactory;
import org.rptest.core.config.Property;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTestNG {
    @BeforeMethod
    public void openLoginPage() {
        BrowserActionsFactory.getBrowserActions().open(Property.COMMON_PROPERTY.baseUrl());
    }

    @AfterMethod
    public void tearDown() {
        BrowserActionsFactory.getBrowserActions().close();
    }
}
